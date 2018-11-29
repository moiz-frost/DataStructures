package com.company;

import java.text.MessageFormat;

public class LinkedListStack<T extends Comparable<T>> {

    private int length;
    private Node<T> head;
    Node<T> top; // tail

    public LinkedListStack () {}

    public void push (T data) {
        if (head == null) {
            head = new Node(data);
            top = head;
        } else {
            Node newNode = new Node(data);
            newNode.previous = top;
            top.next = newNode;
            top = newNode;
        }
        length++;
    }

    public Node<T> pop () {
        Node<T> oldTop = top;
        if (length == 0) return null;
        if (length == 1) {
            clear();
        } else {
            top = top.previous;
            top.next = null;
        }
        length--;
        return oldTop;
    }

    public Node<T> getLast () {
        return top;
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

    private boolean clear () {
        head = null;
        top = null;
        return true;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean validateStringExpression(String expression) {
        char symbol;
        char popped;

        LinkedListStack <Character> testStack = new LinkedListStack<>();

        for( int i = 0; i < expression.length(); i++ ) {
            symbol = expression.charAt(i);
            if (symbol == '(' || symbol == '{' || symbol == '[') {
                testStack.push(symbol);
            }

            if (symbol == ')' || symbol == '}' || symbol == ']') {
                if (testStack.isEmpty()) {
                    return false;
                } else {
                    popped = testStack.pop().data;
                    if (popped == symbol) return false;
                }
            }
        }

        return testStack.isEmpty();
    }

}