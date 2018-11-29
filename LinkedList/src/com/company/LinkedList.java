package com.company;

import java.text.MessageFormat;

public class LinkedList {
    Node head;
    Node tail;

    public LinkedList () {}

    public void insert (int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            Node newNode = new Node(data);
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void print () {
        System.out.print("\n");
        System.out.print("[");
        Node currentPointer = head;
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

    public boolean find (int data) {
        Node currentPointer = head;
        while (currentPointer != null) {
            if (currentPointer.data == data) return true;
            currentPointer = currentPointer.next;
        }
        return false;
    }

    public boolean delete (int data) {
        Node currentPointer = head;
        if (head.data == data) {
            // beginning case
            head = head.next;
            return true;
        }
        while (currentPointer.next.next != null) {
            if (currentPointer.next.data == data) {
                if (currentPointer.next.next == null ) {
                    // end case
                    currentPointer.next = null;
                    return true;
                } else {
                    // end case
                    currentPointer.next = currentPointer.next.next;
                    return true;
                }
            }
            currentPointer = currentPointer.next;
        }
        return false;
    }

    public boolean clear () {
        head = null;
        tail = null;
        return true;
    }

}
