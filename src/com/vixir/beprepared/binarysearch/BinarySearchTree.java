package com.vixir.beprepared.binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

	private Node root;

	private class Node {
		private Key key;
		private Value value;
		private Node left, right;
		private int count;

		public Node(Key key, Value value, int count) {
			this.key = key;
			this.value = value;
			this.count = count;
		}
	}

	public Value get(Key key) {
		Node x = root;
		while (x != null) {
			int c = key.compareTo(x.key);
			if (c < 0) {
				x = x.left;
			} else if (c > 0) {
				x = x.right;
			} else {
				return x.value;
			}
		}
		return null;
	}

	public void put(Key key, Value val) {
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		if (x == null) {
			return new Node(key, val, 1);
		}
		int c = key.compareTo(x.key);
		if (c < 0) {
			x.left = put(x.left, key, val);
		} else if (c > 0) {
			x.right = put(x.right, key, val);
		} else {
			x.value = val;
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (null != node) {
			return node.count;
		}
		return 0;
	}

	// how many keys < key
	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node x) {
		if (x == null) {
			return 0;
		}
		int c = key.compareTo(x.key);
		if (c < 0) {
			return rank(key, x.left);
		} else if (c > 0) {
			return 1 + size(x.left) + rank(key, x.right);
		} else {
			return size(x.left);
		}
	}

	//sorted list
	public Iterable<Key> keys() {
		Queue<Key> q = new ArrayDeque<Key>();
		inorder(root, q);
		return q;
	}

	private void inorder(Node x, Queue<Key> q) {
		if (x == null) {
			return;
		}
		inorder(x.left, q);
		q.add(x.key);
		inorder(x.right, q);
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
		bst.put(11, "1");
		bst.put(21, "2");
		bst.put(52, "5");
		bst.put(63, "6");
		bst.put(71, "7");
		bst.put(13, "3");
		bst.put(41, "4");
		Iterable<Integer> iterable = bst.keys();
		for (Integer i : iterable) {
			System.out.print(i + " ");
		}
	}

}
