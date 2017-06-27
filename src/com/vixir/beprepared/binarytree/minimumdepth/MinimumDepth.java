package com.vixir.beprepared.binarytree.minimumdepth;

public class MinimumDepth {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("The minimum depth of " + "binary tree is : " + tree.minimumHeight());
	}

}

class Node {
	Node left, right;
	int data;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

class BinaryTree {
	Node root;

	public int minimumHeight(Node x) {
		if (x == null) {
			return 0;
		}
		if (x.left == null && x.right == null) {
			return 1;
		}
		if (x.left == null) {
			return minimumHeight(x.right) + 1;
		}
		if (x.right == null) {
			return minimumHeight(x.left) + 1;
		}
		return Math.min(minimumHeight(x.left), minimumHeight(x.right)) + 1;
	}

	public int minimumHeight() {
		return minimumHeight(root);
	}
}
