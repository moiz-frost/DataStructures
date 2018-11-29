package com.company;

import java.text.MessageFormat;

public class BinaryTreeArray <T extends Comparable<T>> {

    T[] tree;

    public BinaryTreeArray (int size) {
        tree = (T[]) new Comparable[size];
    }

    public void insert (T data) {
        if (tree[0] == null) {
            tree[0] = data;
            return;
        }

        int currentIndex = 0;
        while (currentIndex < tree.length && tree[currentIndex] != null) {

            if (data.compareTo(tree[currentIndex]) <= 0 ) {
                currentIndex = (currentIndex * 2) + 1;
            } else {
                currentIndex = (currentIndex * 2) + 2;
            }

        }

        tree[currentIndex] = data;

    }


    public void printArray () {
        System.out.print("\n");
        System.out.print("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                MessageFormat message = new MessageFormat(", {0}");
                Object[] args = {
                        tree[i]
                };
                System.out.print(message.format(args));
            } else {
                MessageFormat message = new MessageFormat(", {0}");
                Object[] args = {
                        "null"
                };
                System.out.print(message.format(args));
            }
        }
        System.out.print("]");
        System.out.print("\n");
    }

    public void displayRecursive (int index) {
        if (index >= tree.length || tree[index] == null) {
            return;
        }
        displayRecursive((index * 2) + 1);
        System.out.println(tree[index]);
        displayRecursive((index * 2) + 2);
    }

    public boolean find (T data) {
        int currentIndex = 0;

        while (currentIndex < tree.length && tree[currentIndex] != null) {

            if (data.compareTo(tree[currentIndex]) == 0) {
                return true;
            }

            if (data.compareTo(tree[currentIndex]) <= 0 ) {
                currentIndex = (currentIndex * 2) + 1;
            } else {
                currentIndex = (currentIndex * 2) + 2;
            }


        }

        return false;

    }

}
