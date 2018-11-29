package com.company;

import java.text.MessageFormat;

public class UrlLinkedList {
    UrlNode head;
    UrlNode tail;

    public void insert (String url) {
        UrlNode newNode = new UrlNode(url);

        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }

    }

    public void print () {
        System.out.print("[");
        UrlNode currentPointer = head;
        while (currentPointer != null) {
            MessageFormat message = new MessageFormat(", {0}");
            Object[] args = {
                    currentPointer.url
            };
            System.out.print(message.format(args));
            currentPointer = currentPointer.next;
        }
        System.out.print("]");
        System.out.print("\n");
    }

}
