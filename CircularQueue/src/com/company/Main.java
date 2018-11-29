package com.company;

public class Main {

    public static void main(String[] args) {
        LinkedListQueue<String> listQueue = new LinkedListQueue<>();
        listQueue.enqueue("ASDASD");
        listQueue.enqueue("12");
        listQueue.enqueue("e232132");

        listQueue.print();

        System.out.println(listQueue.dequeue());
        System.out.println(listQueue.dequeue());
        System.out.println(listQueue.dequeue());

        listQueue.print();

        ArrayBasedCircularQueue<Integer> arrayQueue = new ArrayBasedCircularQueue<Integer>(10);
        arrayQueue.enqueue(5);
        arrayQueue.enqueue(6);
        arrayQueue.enqueue(6);
        arrayQueue.enqueue(9);
        arrayQueue.enqueue(15);
        arrayQueue.enqueue(80);
        arrayQueue.enqueue(90);
        arrayQueue.enqueue(15);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(70);
        arrayQueue.enqueue(100);
        arrayQueue.print();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.print();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
    }
}
