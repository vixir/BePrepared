package com.vixir.beprepared.binarytree;

public class MaximumPathSum {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(2);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(20);
		tree.root.left.right = new Node(1);
		tree.root.right.right = new Node(-25);
		tree.root.right.right.left = new Node(3);
		tree.root.right.right.right = new Node(4);
		System.out.println("maximum path sum is : " + tree.findMaxSum());
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

class Res {
	public int val;
}

class BinaryTree {
	Node root;

	int findMaxUtil(Node node, Res res) {
		if (null == node) {
			return 0;
		}
		int l = findMaxUtil(node.left, res);
		int r = findMaxUtil(node.right, res);
		int maxAtMostOne = Math.max(Math.max(l, r) + node.data, node.data);
		int maxCurrTop = Math.max(res.val, maxAtMostOne);
		res.val = Math.max(res.val, maxCurrTop);
		return maxAtMostOne;
	}

	int findMaxSum() {
		return findMaxSum(root);
	}

	int findMaxSum(Node node) {
		Res res = new Res();
		res.val = Integer.MIN_VALUE;
		findMaxUtil(node, res);
		return res.val;
	}

}