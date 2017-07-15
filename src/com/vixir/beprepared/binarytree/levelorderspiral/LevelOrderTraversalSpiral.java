package com.vixir.beprepared.binarytree.levelorderspiral;

import java.util.Stack;

public class LevelOrderTraversalSpiral {

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
		tree.lvlOrdSpiralUsingTwoStacks();
	}
}

class Node {
	Node left, right;
	Integer data;

	Node(Integer data) {
		this.data = data;
	}
}

class BinaryTree {
	Node root;

	public void lvlOrdSpiralUsingTwoStacks() {
		Stack<Node> stackA;
		Stack<Node> stackB;
		stackA = new Stack<Node>();
		stackB = new Stack<Node>();
		Node current = root;
		stackA.push(current);
		while (!stackA.isEmpty() || !stackB.isEmpty()) {
			if (stackB.isEmpty()) {
				emptyStack(stackA, stackB);
			} else {
				emptyStack(stackB, stackA);
			}
		}
	}

	private void emptyStack(Stack<Node> stackA, Stack<Node> stackB) {
		while (!stackA.isEmpty()) {
			Node x = stackA.pop();
			System.out.print(x.data + " ");
			if (null != x.left) {
				stackB.push(x.left);
			}
			if (null != x.right) {
				stackB.push(x.right);
			}
		}
		System.out.println();
	}
}
