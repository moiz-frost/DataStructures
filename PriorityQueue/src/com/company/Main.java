package com.company;

public class Main {

    public static void main(String[] args) {
        ArrayPriorityQueue<Integer> queue = new ArrayPriorityQueue<>(10);
        queue.enqueue(20);
        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(6);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(96    );
        queue.print();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.print();
    }
}
