package com.vixir.beprepared.binarytree.extractleaves;

public class ExtractLeaves {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.head = new Node(10);
        binaryTree.head.right = new Node(14);
        binaryTree.head.left = new Node(7);
        binaryTree.head.left.right = new Node(8);
        binaryTree.head.left.left = new Node(6);
        binaryTree.head.right.left = new Node(12);
        binaryTree.head.right.right = new Node(16);
        binaryTree.inorder();
        binaryTree.removeLeaves();
        binaryTree.printDLL();
    }
}

class Node {
    int data;
    public Node left, right;

    public Node(int data) {
        this.data = data;
    }
}

class BinaryTree {
    Node head;
    Node leaves;
    Node prev;

    public void removeLeaves() {
        head = removeLeaves(head);
    }

    private Node removeLeaves(Node node) {
        if (null == node) {
            return node;
        }
        if ((node.left == null) && (node.right == null)) {
            if (leaves == null) {
                leaves = node;
                prev = node;
            } else {
                prev.right = node;
                node.left = prev;
                prev = node;
            }
            return null;
        }
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);
        return node;
    }

    public void inorder() {
        inorder(head);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public void printDLL() {
        Node temp = leaves;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }

}