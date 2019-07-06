package com.vixir.beprepared.binarytree;

public class DiameterOfABinaryTree {
    private int maxHeight = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return maxHeight;
        }
        getHeight(root);
        return maxHeight;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        maxHeight = Math.max(leftHeight + rightHeight, maxHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
