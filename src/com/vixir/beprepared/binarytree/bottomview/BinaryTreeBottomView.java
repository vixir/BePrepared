package com.vixir.beprepared.binarytree.bottomview;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBottomView {
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

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

class BinaryTree {
	Node root;
	Queue<Node> queue = new LinkedList<Node>();

	public void printBottomView() {
		if (root == null) {
			return;
		}
		printBottomView(root);
	}

	private void printBottomView(Node x) {
		if (x.left == null && x.right == null) {
			System.out.print(x.data + " ");
			return;
		}
		if (x.left != null) {
			printBottomView(x.left);
		}
		if (x.right != null)
			printBottomView(x.right);
	}
}
