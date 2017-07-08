package com.vixir.beprepared.linkedlist.deletemidnode;

public class DeleteNode {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.push(3);
		linkedList.push(6);
		linkedList.push(1);
		linkedList.push(7);
		linkedList.push(5);
		linkedList.print();
		System.out.println("\nDeleting mid element.");
		linkedList.deletemid();
		linkedList.print();
	}

}

class LinkedList {

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

	public Node deletemid() {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			head = null;
			return head;
		}

		Node prevNode = head, slowNode = head;
		Node fastNode = head;

		while (null != fastNode && null != fastNode.next) {
			prevNode = slowNode;
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}
		prevNode.next = prevNode.next.next;
		return slowNode;
	}

	public void print() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

}