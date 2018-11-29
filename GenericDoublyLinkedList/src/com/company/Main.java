package com.company;

public class Main {

    public static void main(String[] args) {
        LinkedList <String> stringLinkedList = new LinkedList();

        stringLinkedList.insertInOrder("1");
        stringLinkedList.insertInOrder("102");
        stringLinkedList.insertInOrder("10212");
        stringLinkedList.insertInOrder("102asd");
        stringLinkedList.insertInOrder("10200p;");

        stringLinkedList.print();

        stringLinkedList.reverse();

        stringLinkedList.print();

        LinkedList <Integer> integerLinkedList = new LinkedList();

        integerLinkedList.insertInOrder(1);
        integerLinkedList.insertInOrder(102);
        integerLinkedList.insertInOrder(102);
        integerLinkedList.insertInOrder(103);
        integerLinkedList.insertInOrder(10);
        integerLinkedList.insertInOrder(102);
        integerLinkedList.insertInOrder(2);
        integerLinkedList.insertInOrder(0);
        integerLinkedList.insertInOrder(50);
        integerLinkedList.insertInOrder(90);

        integerLinkedList.print();

        integerLinkedList.reverse();

        integerLinkedList.print();

    }
}
