package com.company;

public class Main {

    public static void main(String[] args) {

        /* Single Linked List */

        LinkedList list = new LinkedList();

        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);
        list.print();

        System.out.println(list.find(5));
        System.out.println(list.find(6));
        System.out.println(list.find(7));
        System.out.println(list.find(8));
        System.out.println(list.find(0));

        list.delete(5);
        list.delete(6);
        list.delete(10);
        list.delete(15);
        list.print();

        list.clear();
        list.print();

        /* Doubly Linked List */

        DoublyLinkedList doublyList = new DoublyLinkedList();

        doublyList.insertInOrder(1);
        doublyList.insertInOrder(5);
        doublyList.insertInOrder(0);
        doublyList.insertInOrder(102);
        doublyList.insertInOrder(2);
        doublyList.insertInOrder(102);
        doublyList.insertInOrder(4);
        doublyList.insertInOrder(3);
        doublyList.insertInOrder(102);
        doublyList.insertInOrder(102);
        doublyList.insertInOrder(19);
        doublyList.insertInOrder(12);
        doublyList.insertInOrder(50);
        doublyList.print();


        System.out.println(doublyList.find(7));
        System.out.println(doublyList.find(0));
        System.out.println(doublyList.find(1));
        System.out.println(doublyList.find(50));

        doublyList.print();

        System.out.println(doublyList.head.data);
        System.out.println(doublyList.tail.data);
        doublyList.reverse();
        System.out.println(doublyList.head.data);
        System.out.println(doublyList.tail.data);

        doublyList.print();

        /* Circular Linked List */

        CircularLinkedList circularList = new CircularLinkedList ();

        circularList.insert(1);
        circularList.insert(2);
        circularList.insert(3);
        circularList.insert(4);
        circularList.insert(5);
        circularList.insert(6);
        circularList.insert(7);

        System.out.println(circularList.playGame().data);

        circularList.print();

    }
}
