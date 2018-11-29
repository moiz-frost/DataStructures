package com.company;

import java.text.MessageFormat;

public class HeapTreeArray <T extends Comparable<T>> {

    private int[] tree;
    private int size = 0;

    private int getLeftIndex (int parentIndex) { return (parentIndex * 2) + 1; }
    private int getRightIndex (int parentIndex) { return (parentIndex * 2) + 2; }
    private int getParentIndex (int childIndex) { return childIndex != 0 ? (childIndex - 1) / 2 : 0; }

    private boolean hasLeftChild (int parentIndex) { return getLeftIndex(parentIndex) < tree.length; }
    private boolean hasRightChild (int parentIndex) { return getRightIndex(parentIndex) < tree.length; }
    private boolean hasParent (int childIndex) { return getParentIndex(childIndex) >= 0; }

    private int getLeftChild (int parentIndex) { return tree[getLeftIndex(parentIndex)]; }
    private int getRightChild (int parentIndex) { return tree[getRightIndex(parentIndex)]; }
    private int getParent (int childIndex) { return tree[getParentIndex(childIndex)]; }

    private void swap(int indexOne, int indexTwo) {
        int temp = tree[indexOne];
        tree[indexOne] = tree[indexTwo];
        tree[indexTwo] = temp;
    }

    private void reheapDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftIndex(index);

            System.out.println(getLeftChild(index));

            if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallerChildIndex = getRightIndex(index);
            }

            if (tree[index] < tree[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }

    private void reheapUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) > tree[index]) {
            System.out.println(getParent(index));
            System.out.println(tree[index]);
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }


    public void buildHeap (int[] array) {
        tree = new int[array.length];
        for (int data : array) {
            insert(data);
        }
    }

    private void insert (int data) {
        tree[size] = data;
        size++;
        reheapUp();
    }

    public void delete (T value) {}

    public void print () {
        System.out.print("\n");
        System.out.print("[");
        for (int i = 0; i < tree.length; i++) {
            MessageFormat message = new MessageFormat(", {0}");
            Object[] args = {
                    tree[i]
            };
            System.out.print(message.format(args));
        }
        System.out.print("]");
        System.out.print("\n");
    }
}
