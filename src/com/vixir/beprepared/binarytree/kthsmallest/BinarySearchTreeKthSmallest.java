package com.vixir.beprepared.binarytree.kthsmallest;

import java.util.*;

public class BinarySearchTreeKthSmallest {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(8);
        tree.root.left = new Node(4);
        tree.root.right = new Node(16);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(18);
        tree.root.right.right.left = new Node(17);
        tree.root.right.right.right = new Node(21);
        System.out.println(tree.kthSmallestIterative(4));
    }

}

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    public int kthSmallestIterative(int B) {
        LinkedList<Node> stack = new LinkedList<>();
        Node A = root;
        int depth = 0;
        while (!stack.isEmpty() || A != null) {
            while (A != null) {
                stack.push(A);
                A = A.left;
            }
            A = stack.poll();
            depth++;
            if (depth == B) {
                return A.data;
            }
            A = A.right;
        }
        return -1;
    }
}