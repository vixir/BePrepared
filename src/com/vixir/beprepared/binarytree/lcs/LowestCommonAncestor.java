package com.vixir.beprepared.binarytree.lcs;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(2);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(20);
		tree.root.left.right = new Node(1);
		tree.root.right.right = new Node(5);
		tree.root.right.right.left = new Node(3);
		tree.root.right.right.right = new Node(4);
		System.out.println(tree.lcs(tree.root, tree.root.right.right.left, tree.root.right.right).data);
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

	public Node lcs(Node x, Node a, Node b) {
		if (null == x) {
			return x;
		}
		if (x.equals(a) || x.equals(b)) {
			return x;
		}
		Node left = lcs(x.left, a, b);
		Node right = lcs(x.right, a, b);
		if (null != left && null != right) {
			return x;
		}
		return null != left ? left : right;
	}
}
