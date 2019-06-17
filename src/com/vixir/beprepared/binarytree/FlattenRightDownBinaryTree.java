package com.vixir.beprepared.binarytree;

// Input : Linkedlist 1-2-3-4-5
//                    |     |
//                    6-10  7-8
//                          |
//                          9
// Solution : 1-2-3-4-5-7-8-9-6-10

public class FlattenRightDownBinaryTree {

    private static TreeNode previousNode;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);
        root.right.right.right.bottom = new TreeNode(7);
        root.right.right.right.bottom.bottom = new TreeNode(9);
        root.right.right.right.bottom.right = new TreeNode(8);
        root.bottom = new TreeNode(6);
        root.bottom.right = new TreeNode(10);
        flattenTree(root);
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    /**
     * 1) go bottom
     * 2) go right
     * 3) save the prevNode
     * 4)
     */
    private static void flattenTree(TreeNode node) {
        if (node == null) {
            return;
        }
        flattenTree(node.bottom);
        flattenTree(node.right);
        node.right = previousNode;
        node.bottom = null;
        previousNode = node;
    }

}

class TreeNode {
    int val;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode right;
    TreeNode bottom;
}


