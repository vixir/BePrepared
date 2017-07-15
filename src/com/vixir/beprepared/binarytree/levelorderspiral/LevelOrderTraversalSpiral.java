package com.vixir.beprepared.binarytree.levelorderspiral;

import java.util.Stack;

public class LevelOrderTraversalSpiral {

	public static void main(String[] args) {

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
	Stack stackA;
	Stack stackB;

	public void lvlOrdSpiralUsingTwoStacks() {
		stackA = new Stack<Integer>();
		stackB = new Stack<Integer>();
		Node current = root;
		stackA.push(current);
		while (!stackA.isEmpty() && !stackB.isEmpty()) {
			if (stackB.isEmpty()) {
				if (null != current.left) {
					stackB.push(current.left);
				}
				if (null != current.right) {
					stackB.push(current.right);
				}
			} else {
				if (null != current.left) {
					stackA.push(current.left);
				}
				if (null != current.right) {
					stackA.push(current.right);
				}
			}
		}
	}
}
