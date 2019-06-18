package com.vixir.beprepared.binarytree.lvlorder;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.right.right.left = new Node(7);
        tree.root.right.right.right = new Node(8);
        tree.bfsBinaryTree();
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
    Queue<Node> queue = new LinkedList<Node>();

    public void bfsBinaryTree() {
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            System.out.print(n.data + " ");
            if (null != n.left) {
                queue.add(n.left);
            }
            if (null != n.right) {
                queue.add(n.right);
            }
        }
    }
}
