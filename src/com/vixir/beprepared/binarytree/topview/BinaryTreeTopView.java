package com.vixir.beprepared.binarytree.topview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeTopView {
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
		tree.printTopView();
	}
}

class Node {
	int data, level;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

class BinaryTree {
	Node root;
	Queue<Node> queue = new LinkedList<Node>();
	public TreeMap<Integer, Integer> ht = new TreeMap<>();

	public void printTopView() {
		if (root == null) {
			return;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			int level = n.level;
			if (!ht.containsKey(level)) {
				System.out.print(n.data + " ");
				ht.put(level, n.data);
			}
			if (null != n.left) {
				n.left.level = level + 1;
				queue.add(n.left);
			}
			if (null != n.right) {
				n.right.level = level - 1;
				queue.add(n.right);
			}
		}
	}

}
