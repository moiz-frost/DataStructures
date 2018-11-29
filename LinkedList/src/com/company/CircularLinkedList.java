package com.company;

import java.text.MessageFormat;
import java.util.Random;

public class CircularLinkedList {
    Node head;
    Node tail;
    int length;

    public void insert (int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            Node newNode = new Node(data);
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        length++;
    }

    public void print () {
        System.out.print("\n");
        System.out.print("[");
        Node currentPointer = head;
        int loopCounter = 0;
        while (loopCounter != length) {
            MessageFormat message = new MessageFormat(", {0}");
            Object[] args = {
                    currentPointer.data
            };
            System.out.print(message.format(args));
            currentPointer = currentPointer.next;
            loopCounter++;
        }

        System.out.print("]");
        System.out.print("\n");
    }

    public boolean find (int data) {
        Node currentPointer = head;
        int loopCounter = 0;
        while (loopCounter != length) {
            if (currentPointer.data == data) return true;
            currentPointer = currentPointer.next;
            loopCounter++;
        }
        return false;
    }

    public boolean delete (int data) {
        Node currentPointer = head;
        int loopCounter = 0;

        if (head.data == data) {
            // beginning case
            head = head.next;
            tail.next = head;
            length--;
            return true;
        }

        while (loopCounter != length) {
            if (currentPointer.next.data == data) {
                if (currentPointer.next.next == head ) {
                    // end case
                    currentPointer.next = head;
                    length--;
                    return true;
                } else {
                    currentPointer.next = currentPointer.next.next;
                    length--;
                    return true;
                }
            }
            currentPointer = currentPointer.next;
            loopCounter++;
        }
        return false;
    }

    public boolean clear () {
        head = null;
        tail = null;
        return true;
    }

    private int generateRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public Node playGame () {
        Node currentPointer = head;
            while (length != 1) {
                for (int rotations = generateRandomNumberInRange(0, length * 2); rotations != 0; rotations--) {
                    currentPointer = currentPointer.next;
                }
                delete(currentPointer.data);
            }
            return currentPointer;
    }
}
