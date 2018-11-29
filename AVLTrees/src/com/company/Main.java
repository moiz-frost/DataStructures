package com.company;

public class Main {

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(15);
        tree.insert(10);
        tree.insert(11);
        tree.insert(26);
        tree.insert(9);
        tree.insert(27);
        tree.insert(22);
        tree.insert(28);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(29);
        tree.insert(12);

        System.out.println(tree.find(6));
    }
}
