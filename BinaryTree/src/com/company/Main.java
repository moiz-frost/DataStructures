package com.company;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.insert(15);
        tree.insert(10);
        tree.insert(11);
        tree.insert(26);
        tree.insert(9);
        tree.insert(27);
        tree.insert(22);
        tree.insert(28);
        tree.insert(3);


        System.out.println(tree.find(6));
        tree.delete(15);
        tree.delete(26);

/*

        BinaryTreeArray<Integer> arrayTree = new BinaryTreeArray<>(20);

        arrayTree.insert(6);
        arrayTree.insert(5);
        arrayTree.insert(8);
        arrayTree.insert(7);
        arrayTree.insert(9);
        arrayTree.insert(12);

        System.out.println(arrayTree.find(12));

        arrayTree.displayRecursive(0);
*/

    }
}
