package com.vixir.beprepared.binarytree.bottomview;

import java.util.*;


/**
 * Vertical Order Traversal of Binary Tree
 *                      1
 *                   2      3
 *               4      6      5
 *                          7     8
 *
 *       4,2,6,7,5,8
 *
 *   In case of two nodes overlapping each other this solution prints one of the nodes that comes later on that level.
 */
public class BinaryTreeBottomView {
    /**
     * Client code to test vertical order traversal
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(5);
        tree.root.right.right.left = new Node(7);
        tree.root.right.right.right = new Node(8);
        tree.printBottomView();
    }
}

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class ModifiedNode {
    Node node;
    int hd;

    ModifiedNode(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class BinaryTree {
    Node root;

    /**
     * TreeMap for sorting horizontal distance.
     * If order is not required use HashMap.
     */
    private Map<Integer, Integer> map = new TreeMap<>();

    private void printBottomView(ModifiedNode mNode) {
        if (mNode.node == null) {
            return;
        }
        if (mNode.node.left != null) {
            map.put(mNode.hd - 1, mNode.node.left.data);
            printBottomView(new ModifiedNode(mNode.node.left, mNode.hd - 1));
        }
        if (mNode.node.right != null) {
            map.put(mNode.hd + 1, mNode.node.right.data);
            printBottomView(new ModifiedNode(mNode.node.right, mNode.hd + 1));
        }
    }

    void printBottomView() {
        ModifiedNode mNode = new ModifiedNode(root, 0);
        printBottomView(mNode);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }
}
