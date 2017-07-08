package com.vixir.beprepared.bstfromsortedarray;

public class BSTFromSortedArray {

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5, 6, 7 };
		BinarySearchTree binarySearchTree = new BinarySearchTree(input);
		boolean isBST = binarySearchTree.isBST();
		System.out.println(isBST);
	}

}

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class BinarySearchTree {

	private Node root;

	BinarySearchTree(int[] input) {
		setRoot(createBST(input, 0, input.length));
	}

	public boolean isBST() {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node node, int min, int max) {
		if (null == node) {
			return true;
		}
		if (node.data < min || node.data > max) {
			return false;
		}
		return (isBST(node.left, min, node.data - 1) && isBST(node.right, node.data + 1, max));
	}

	private Node createBST(int[] array, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		Node node = new Node(mid);
		root.left = createBST(array, start, mid - 1);
		root.right = createBST(array, mid + 1, end);
		return node;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

}
