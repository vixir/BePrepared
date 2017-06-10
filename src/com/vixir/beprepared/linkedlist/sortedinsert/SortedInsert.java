package com.vixir.beprepared.linkedlist.sortedinsert;


public class SortedInsert {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.push(1);
		list.push(2);
		list.push(9);
		list.push(7);
		list.push(-9);
		list.print();
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
		sortedInsert(node);
	}

	public void sortedInsert(Node newNode) {
		Node current;
		if (null == head || head.data >= newNode.data) {
			newNode.next = head;
			head = newNode;
		} else {
			current = head;
			while (current.next != null && current.next.data < newNode.data) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
	}

	public void print() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
}
