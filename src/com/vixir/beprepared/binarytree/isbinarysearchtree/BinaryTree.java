package com.vixir.beprepared.binarytree.isbinarysearchtree;

public class BinaryTree {

	Node root, prev;

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);

		if (tree.isBST())
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}

	public boolean isBST() {
		return isBST(root);
	}

	private boolean isBST(Node node) {
		if (null == node) {
			return true;
		}
		if (!isBST(node.left)) {
			return false;
		}
		if (null != prev && prev.data > node.data) {
			return false;
		}
		prev = node;
		return isBST(node.right);
	}
}

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}
