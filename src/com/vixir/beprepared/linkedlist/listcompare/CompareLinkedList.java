package com.vixir.beprepared.linkedlist.listcompare;

public class CompareLinkedList {

	public static void main(String[] args) {
		LinkedList listA = new LinkedList();
		LinkedList listB = new LinkedList();
		listA.push(1);
		listA.push(2);
		listA.push(3);
		listA.push(4);
		listB.push(1);
		listB.push(2);
		listB.push(3);
		listB.push(4);
		System.out.println(listA.equals(listB));
	}

}

class LinkedList implements Comparable<LinkedList> {

	Node head;

	static class Node {
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

	public void print() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

	@Override
	public boolean equals(Object b) {
		if (!(b instanceof LinkedList)) {
			return false;
		}

		return (this.compareTo((LinkedList) b) == 0);
	}

	@Override
	public int compareTo(LinkedList b) {
		return compare(this, b);
	}

	public int compare(LinkedList a, LinkedList b) {
		Node aHead = a.head;
		Node bHead = b.head;
		if (aHead == null && bHead == null) {
			return 1;
		}
		while (aHead != null && bHead != null && aHead.data == bHead.data) {
			aHead = aHead.next;
			bHead = bHead.next;
		}
		if (aHead != null && bHead != null) {
			return (aHead.data > bHead.data ? 1 : -1);
		}
		if (aHead != null && bHead == null) {
			return 1;
		}
		if (aHead == null && bHead != null) {
			return -1;
		}
		return 0;
	}

}