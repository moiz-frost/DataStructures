package com.company;

import java.text.MessageFormat;

public class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;

    public DoublyLinkedList () {}

    public void insertInOrder (int data) {
        DoublyNode newNode = new DoublyNode(data);
        DoublyNode currentPointer = head;

        if (head == null) {
            head = newNode;
            tail = head;
            return;
        }

        if (data <= head.data) {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
            return;
        }

        while (currentPointer != null) {
            if (currentPointer.next == null) {
                if (currentPointer.data <= data) {
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

            if (data >= currentPointer.data && data <= currentPointer.next.data) {
                currentPointer.next.previous = newNode;
                newNode.next = currentPointer.next;
                newNode.previous = currentPointer;
                currentPointer.next = newNode;
                break;
            }

            currentPointer = currentPointer.next;
        }


    }

    public boolean find (int data) {
        DoublyNode currentPointer = head;
        while (currentPointer != null) {
            if (currentPointer.data == data) return true;
            currentPointer = currentPointer.next;
        }
        return false;
    }

    public void print () {
        System.out.print("\n");
        System.out.print("[");
        DoublyNode currentPointer = head;
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

    public boolean clear () {
        head = null;
        tail = null;
        return true;
    }

    public void reverse () {
        DoublyNode currentPointer = head;
        DoublyNode temp = null;

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
