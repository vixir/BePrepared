package com.vixir.beprepared.linkedlist;

public class PairwiseReverse {

	public static void main(String[] args) {
		LinkedListLocal list = new LinkedListLocal();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(7);
		list.printList();
		list.reversePairWise();
		list.printList();
	}
}

class LinkedListLocal {
	Node head;
	Node currentNode;

	class Node {
		Node next;
		Integer data;

		public Node(int data) {
			this.data = data;
		}
	}

	public void add(int a) {
		if (null == head) {
			head = new Node(a);
			currentNode = head;
		} else {
			currentNode.next = new Node(a);
			currentNode = currentNode.next;
		}
	}

	public void printList() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public void reversePairWise() {
		if (null == head && head.next == null) {
			return;
		}
		Node prevNode = head;
		Node currNode = head.next;
		head = currNode;
		while (true) {
			Node temp = currNode.next;
			currNode.next = prevNode;
			if (temp == null || temp.next == null) {
				prevNode.next = temp;
				break;
			}
			prevNode.next = temp.next;
			prevNode = temp;
			currNode = prevNode.next;
		}
	}

}