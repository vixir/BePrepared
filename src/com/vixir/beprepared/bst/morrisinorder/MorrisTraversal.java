package com.vixir.beprepared.bst.morrisinorder;

public class MorrisTraversal {
	// for simplicity assume that BST just has keys.
	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(1);
		binarySearchTree.insert(2);
		binarySearchTree.insert(3);
		binarySearchTree.insert(4);
		binarySearchTree.insert(5);
		binarySearchTree.insert(6);
		binarySearchTree.morrisTraversal();
	}
}

class Node {
	Node right, left;
	int data;

	Node(int data) {
		this.data = data;
	}
}

class BinarySearchTree {
	Node root;

	public void morrisTraversal() {
		Node currNode = root;
		while (currNode != null) {
			if (currNode.left == null) {
				System.out.print(currNode.data + " ");
				currNode = currNode.right;
			} else {
				Node predecessor = currNode.left;
				while (predecessor.right != currNode && predecessor.right != null) {
					predecessor = predecessor.right;
				}
				if (predecessor.right == null) {
					predecessor.right = currNode;
					currNode = currNode.left;
				} else {
					predecessor.right = null;
					System.out.print(currNode.data + " ");
					currNode = currNode.right;
				}
			}
		}
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node node, Integer data) {
		if (node == null) {
			return new Node(data);
		}
		int cmp = data.compareTo(node.data);
		if (cmp < 0) {
			node.left = insert(node.left, data);
		} else {
			node.right = insert(node.right, data);
		}
		return node;
	}
}
