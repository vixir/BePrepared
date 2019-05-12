package com.vixir.beprepared.binarytree;


import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    void printSpiral(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stackRL = new Stack<>();
        Stack<Node> stackLR = new Stack<>();

        //push first element to stack
        stackLR.push(node);

        while (!stackLR.isEmpty() || !stackRL.isEmpty()) {

            while (!stackLR.isEmpty()) {
                Node x = stackLR.pop();
                System.out.print(x.data + " ");
                if (x.right != null) {
                    stackRL.push(x.right);
                }
                if (x.left != null) {
                    stackRL.push(x.left);
                }
            }

            while (!stackRL.isEmpty()) {
                Node x = stackRL.pop();
                System.out.print(x.data + " ");
                if (x.left != null) {
                    stackLR.push(x.left);
                }
                if (x.right != null) {
                    stackLR.push(x.right);
                }
            }
        }
    }
}

public class SpiralOrderTraversal {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);
        System.out.println("Spiral Order traversal of Binary Tree is ");
        tree.printSpiral(tree.root);
    }
}
