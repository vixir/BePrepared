package com.vixir.beprepared.binarytree.verticalorder;

import java.awt.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class VerticalOrderBinaryTree {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.left.left = new Node(8);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(7);
		tree.root.right.left = new Node(6);
		tree.verticalOrderBinaryTree();
	}
}

class Node {
	int data, lvl;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

class BinaryTree {
	Node root;
	int max, min;
	Map<Integer, LinkedList<Node>> verticalOdrMap = new HashMap<Integer, LinkedList<Node>>();

	public void verticalOrderBinaryTree() {
		root.lvl = 0;
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		verticalOdrMap.put(0, list);
		verticalOrderBinaryTree(root);
		for (int i = min; i <= max; i++) {
			for (Node n : verticalOdrMap.get(i)) {
				System.out.print(" " + n.data);
			}
			System.out.println();
		}
	}

	private void verticalOrderBinaryTree(Node node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			node.left.lvl = node.lvl - 1;
			if (node.left.lvl < min) {
				min = node.left.lvl;
			}
			if (verticalOdrMap.get(node.left.lvl) == null) {
				LinkedList<Node> list = new LinkedList<Node>();
				list.add(node.left);
				verticalOdrMap.put(node.left.lvl, list);
			} else {
				verticalOdrMap.get(node.left.lvl).add(node.left);
			}
			verticalOrderBinaryTree(node.left);
		}

		if (node.right != null) {

			node.right.lvl = node.lvl + 1;
			if (node.right.lvl > max) {
				max = node.right.lvl;
			}
			if (verticalOdrMap.get(node.right.lvl) == null) {
				LinkedList<Node> list = new LinkedList<Node>();
				list.add(node.right);
				verticalOdrMap.put(node.right.lvl, list);
			} else {
				verticalOdrMap.get(node.right.lvl).add(node.right);
			}
			verticalOrderBinaryTree(node.right);
		}
	}
}
