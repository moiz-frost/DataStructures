package com.company;

public class TreeNode <T> {

    TreeNode<T> parent;
    TreeNode<T> left;
    TreeNode<T> right;
    T data;

    TreeNode(T data) {
        this.parent = null;
        this.left = null;
        this.right = null;
        this.data = data;
    }

}