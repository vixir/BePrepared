package com.vixir.beprepared.linkedlist.reverseklist;

public class ReverseKList {
	public static void main(String... args) {
		LinkedList listA = new LinkedList();
		listA.push(1);
		listA.push(2);
		listA.push(3);
		listA.push(4);
		listA.push(6);
		listA.print();
		System.out.println();
		listA.reverseK(2);
		listA.print();
	}
}

class LinkedList {

	Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}

	public void reverseK(int k) {
		head = reverseK(head, k);
	}

	private Node reverseK(Node node, int k) {
		Node current = node;
		Node next = null;
		Node prev = null;
		int count = 0;
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		if (next != null) {
			node.next = reverseK(next, k);
		}
		return prev;
	}

	public void print() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
}
