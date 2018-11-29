package com.company;

public class AVLTree <T extends Comparable<T>> {
    TreeNode<T> root;

    public void insert (T data){
        TreeNode newNodeReference = new TreeNode<T>(data);
        if (this.root == null) {
            root = newNodeReference;
        } else {
            TreeNode<T> currentPointer = root;
            TreeNode<T> previousPointer = root;

            while (currentPointer != null) {
                previousPointer = currentPointer;
                if (data.compareTo(currentPointer.data) <= 0) {
                    currentPointer = currentPointer.left;
                } else if (data.compareTo(currentPointer.data) > 0) {
                    currentPointer = currentPointer.right;
                }
            }

            if (data.compareTo(previousPointer.data) <= 0) {
                previousPointer.left = newNodeReference;
                previousPointer.left.parent = previousPointer;
                newNodeReference = previousPointer.left;
            } else {
                previousPointer.right = newNodeReference;
                previousPointer.right.parent = previousPointer;
                newNodeReference = previousPointer.right;
            }
        }

        computeHeightAndBalanceFactor(newNodeReference);
    }

    public boolean find (T data) {

        TreeNode<T> currentPointer = root;

        while (currentPointer != null) {

            if (data.compareTo(currentPointer.data) == 0) return true;

            if (data.compareTo(currentPointer.data) < 0) {
                currentPointer = currentPointer.left;
            } else if (data.compareTo(currentPointer.data) > 0) {
                currentPointer = currentPointer.right;
            }
        }

        return false;

    }

    private void computeHeightAndBalanceFactor(TreeNode node) {
        TreeNode pointer = node;
        do {
            int height = 1;
            int balanceFactor = 0;
            boolean hasLeft = pointer.left != null;
            boolean hasRight = pointer.right != null;

            if (!hasLeft && !hasRight) height = 0;
            if (!hasLeft && hasRight) {
                height = pointer.right.height;
                balanceFactor = pointer.right.height;
            }
            if (hasLeft && !hasRight) {
                height = pointer.left.height;
                balanceFactor = pointer.left.height;
            }
            if (hasLeft && hasRight) {
                height = Math.max(pointer.left.height, pointer.right.height);
                balanceFactor = Math.abs(pointer.left.height - pointer.right.height);
            }

            pointer.balanceFactor = balanceFactor;
            pointer.height = ++height;

            pointer = pointer.parent;
        } while (pointer != null);
    }

}
