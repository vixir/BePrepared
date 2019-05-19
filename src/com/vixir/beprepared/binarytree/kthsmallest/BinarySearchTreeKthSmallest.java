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
        stack.add(A);
        int depth = 0;
        while (!stack.isEmpty() || A != null) {
            if (A != null) {
                while (A.left != null) {
                    A = A.left;
                    stack.push(A);
                }
                A = A.right;
            }
            if (!stack.isEmpty()) {
                Node x = stack.poll();
                depth++;
                if (depth == B) {
                    return x.data;
                }
                if (x.right != null) {
                    A = x.right;
                    stack.push(x.right);
                }
            }
        }
        return -1;
    }
}