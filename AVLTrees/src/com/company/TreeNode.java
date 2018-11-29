package com.company;

public class TreeNode <T> {

    TreeNode<T> parent;
    TreeNode<T> left;
    TreeNode<T> right;
    int height;
    int balanceFactor;
    T data;

    TreeNode(T data) {
        this.parent = null;
        this.left = null;
        this.right = null;
        this.height = 1;
        this.balanceFactor = 0;
        this.data = data;
    }

}