package com.vixir.beprepared.bst.morrisinorder;

/**
 * Using Morris order traversal we can traverse the tree without using stack or recursion
 */
public class MorrisTraversal {
    // for simplicity assume that BST just has keys.
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(1);
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);
        binarySearchTree.morrisInOrderTraversal();
    }
}

class Node {
    Node right, left;
    int data;

    Node(int data) {
        this.data = data;
    }
}

class BinarySearchTree {
    private Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, Integer data) {
        if (node == null) {
            return new Node(data);
        }
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public void morrisInOrderTraversal() {
        Node currNode = root;
        while (currNode != null) {
            if (currNode.left == null) {
                System.out.print(currNode.data + " ");
                currNode = currNode.right;
            } else {
                // find the inorder predecessor of currentNode
                Node predecessor = currNode.left;
                // keep going right until right node is not null or right node is not current
                while (predecessor.right != currNode && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                // if right node is null, go left after establishing link from predecessor to current
                if (predecessor.right == null) {
                    predecessor.right = currNode;
                    currNode = currNode.left;
                } else {
                    // left is already visited. Reset the predecessor link to null. Go right after visiting current
                    predecessor.right = null;
                    System.out.print(currNode.data + " ");
                    currNode = currNode.right;
                }
            }
        }
    }

}
