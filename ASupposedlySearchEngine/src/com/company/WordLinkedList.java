package com.company;

public class WordLinkedList {

    WordNode head;
    WordNode tail;

    public void insert (String word, String url) {
        WordNode newNode = new WordNode();

        if (head == null) {
            newNode.word = word;
            newNode.urlLinkedList = new UrlLinkedList();
            newNode.urlLinkedList.insert(url);
            head = newNode;
            tail = head;
        } else {
            WordNode currentPointer = head;
            while (currentPointer != null) {
                if (currentPointer.word.equals(word)) {
                    currentPointer.urlLinkedList.insert(url);
                    return;
                }
                if (currentPointer == tail) {
                    newNode.word = word;
                    newNode.urlLinkedList = new UrlLinkedList();
                    newNode.urlLinkedList.insert(url);
                    newNode.previous = tail;
                    tail.next = newNode;
                    tail = newNode;
                    return;
                }
                currentPointer = currentPointer.next;
            }
        }
    }

    public void print () {
        WordNode currentPointer = head;
        System.out.print("\n");
        while (currentPointer != null) {
            System.out.println(currentPointer.word + ": ");
            currentPointer.urlLinkedList.print();
            currentPointer = currentPointer.next;
        }
        System.out.print("\n");
    }

    public void search (String word) {
        System.out.print("\n");
        WordNode currentPointer = head;
        while (currentPointer != null) {
            if (currentPointer.word.equals(word)) {
                currentPointer.urlLinkedList.print();
                return;
            }
            currentPointer = currentPointer.next;
        }
        System.out.println("Word doesn't exist");
        System.out.print("\n");
    }

}
