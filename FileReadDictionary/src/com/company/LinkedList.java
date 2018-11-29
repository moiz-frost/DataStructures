package com.company;

import java.text.MessageFormat;

public class LinkedList <T extends Comparable<T>>{
    Node<T> head;
    Node<T> tail;

    public void insertInOrder (T data) {
        Node<T> newNode = new Node<T>(data);
        Node<T> currentPointer = head;

        if (head == null) {
            head = newNode;
            tail = head;
            return;
        }

        if (data.compareTo(head.data) <= 0) {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
            return;
        }

        while (currentPointer != null) {
            if (currentPointer.next == null) {
                if (currentPointer.data.compareTo(data) <= 0) {
                    currentPointer.next = newNode;
                    newNode.previous = currentPointer;
                    currentPointer = newNode;
                    tail = newNode;
                } else {
                    System.out.println(data);
                    newNode.next = currentPointer;
                    currentPointer.previous = newNode;
                    tail = currentPointer;
                    if (currentPointer == head) head = newNode;
                }
                break;
            }

            if (data.compareTo(currentPointer.data) >= 0 && data.compareTo(currentPointer.next.data) <= 0) {
                currentPointer.next.previous = newNode;
                newNode.next = currentPointer.next;
                newNode.previous = currentPointer;
                currentPointer.next = newNode;
                break;
            }

            currentPointer = currentPointer.next;
        }


    }

    public LinkedList () {}

    public void print () {
        System.out.print("\n");
        System.out.print("[");
        Node<T> currentPointer = head;
        while (currentPointer != null) {
            MessageFormat message = new MessageFormat(", {0}");
            Object[] args = {
                    currentPointer.data
            };
            System.out.print(message.format(args));
            currentPointer = currentPointer.next;
        }
        System.out.print("]");
        System.out.print("\n");
    }

    public boolean find (T data) {
        Node<T> currentPointer = head;
        while (currentPointer != null) {
            if (currentPointer.data.compareTo(data) == 0) return true;
            currentPointer = currentPointer.next;
        }
        return false;
    }

    public boolean clear () {
        head = null;
        tail = null;
        return true;
    }

    public void reverse () {
        Node currentPointer = head;
        Node temp = null;

        while (currentPointer != null) {
            /* swap the next and prev pointer */
            temp = currentPointer.previous;
            currentPointer.previous = currentPointer.next;
            currentPointer.next = temp;
            currentPointer = currentPointer.previous;
        }

        head = temp.previous;

        /* Need to find the tail again */
        currentPointer = head;

        while (currentPointer.next != null) {
            currentPointer = currentPointer.next;
        }

        tail = currentPointer;
    }

}
