package com.company;

public class BinaryTree <T extends Comparable<T>> {
    TreeNode<T> root;

    public void insert (T data){
        if (this.root == null) {
            root = new TreeNode<T>(data);
            return;
        }

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
            previousPointer.left = new TreeNode<T>(data);
            previousPointer.left.parent = previousPointer;
        } else {
            previousPointer.right = new TreeNode<T>(data);
            previousPointer.right.parent = previousPointer;
        }


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

    private TreeNode<T> findMaxNodeLeftSubtree (TreeNode<T> node) {
        TreeNode<T> currentPointer = node;
        TreeNode<T> previousPointer = node;
        currentPointer = currentPointer.left;

        while (currentPointer.right != null) {
            previousPointer = currentPointer;
            currentPointer = currentPointer.right;
        }

        return currentPointer;
    }

    private boolean hasNoChild (TreeNode<T> node) {
        if (node.left == null && node.right == null) return true;
        return false;
    }

    private boolean hasOneChild (TreeNode<T> node) {
        if ((node.left != null && node.right == null) || (node.left == null && node.right != null)) return true;
        return false;
    }

    private boolean hasTwoChildren (TreeNode<T> node) {
        if (node.left != null && node.right != null) return true;
        return false;
    }

    private void handleNoChildNodeDeletion (TreeNode<T> previousPointer, TreeNode<T> currentPointer) {
        if (currentPointer.data.compareTo(previousPointer.data) <= 0) {
            previousPointer.left = null;
            currentPointer = null;
        } else {
            previousPointer.right = null;
            currentPointer = null;
        }
    }

    private void handleOneChildNodeDeletion (TreeNode<T> previousPointer, TreeNode<T> currentPointer) {
        if (previousPointer.left == currentPointer) {
            if (currentPointer.left != null) {
                previousPointer.left = currentPointer.left;
            } else {
                previousPointer.left = currentPointer.right;
            }
        } else {
            if (currentPointer.left != null) {
                previousPointer.right = currentPointer.left;
            } else {
                previousPointer.right = currentPointer.right;
            }
        }
    }

    private void handleTwoChildrenNodeDeletion (TreeNode<T> currentPointer) {
        TreeNode<T> maxNode = this.findMaxNodeLeftSubtree(currentPointer);
        currentPointer.data = maxNode.data;

        if (this.hasNoChild(maxNode)) {
            handleNoChildNodeDeletion(maxNode.parent, maxNode);
        } else {
            handleOneChildNodeDeletion(maxNode.parent, maxNode);
        }
    }


        public void delete (T data) {
        TreeNode<T> currentPointer = root;
        TreeNode<T> previousPointer = root;
        TreeNode<T> foundNode = null;

        while (currentPointer != null) {
            if (data.compareTo(currentPointer.data) == 0) {
                foundNode = currentPointer;
                break;
            }

            previousPointer = currentPointer;

            if (data.compareTo(currentPointer.data) < 0) {
                currentPointer = currentPointer.left;
            } else if (data.compareTo(currentPointer.data) > 0) {
                currentPointer = currentPointer.right;
            }
        }


        if (foundNode != null) {
            if (this.hasNoChild(foundNode)) {
                this.handleNoChildNodeDeletion(previousPointer, currentPointer);
            } else if (this.hasOneChild(foundNode)) {
                this.handleOneChildNodeDeletion(previousPointer, currentPointer);
            } else {
                this.handleTwoChildrenNodeDeletion(currentPointer);
            }
        }

    }
}
