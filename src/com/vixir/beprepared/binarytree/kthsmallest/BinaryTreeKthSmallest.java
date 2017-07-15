package com.vixir.beprepared.binarytree.kthsmallest;

public class BinaryTreeKthSmallest {

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
		System.out.println(tree.kthSmallest(4));
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
	int ans = 0;

	public int kthSmallest(int k) {
		int n = 0;
		Node node = root;
		kthSmallest(k, n, node);
		return ans;
	}

	private void kthSmallest(int k, int n, Node node) {
		if (null == node) {
			return;
		}
		kthSmallest(k, n, node.left);
		n++;
		if (k == n) {
			ans = k;
		}
		kthSmallest(k, n, node.right);
	}
}