package com.company;

public class Main {

    public static void main(String[] args) {
        WordLinkedList wordLinkedList = new WordLinkedList();
        wordLinkedList.insert("google", "url1");
        wordLinkedList.insert("google", "url1");
        wordLinkedList.insert("google", "url1");
        wordLinkedList.insert("google1", "url1");
        wordLinkedList.insert("google1", "url1");
        wordLinkedList.insert("google1", "url1");
        wordLinkedList.insert("google2", "url1");
        wordLinkedList.insert("google2", "url1");
        wordLinkedList.insert("google2", "url1");
        wordLinkedList.search("google");
        wordLinkedList.search("google3");
        wordLinkedList.print();

    }
}
