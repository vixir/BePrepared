package com.vixir.beprepared.linkedlist.removeloop;

public class RemoveLoop {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.push(20);
		list.push(4);
		list.push(15);
		list.push(10);
		list.push(11);
		list.push(12);
		list.push(13);
		list.head.next.next.next.next.next.next.next = list.head.next.next.next.next;
		if (list.detectAndRemoveLoop()) {
			System.out.println("Loop detected");
			list.print();
		} else {
			System.out.println("no loop in the list");
		}

	}
}

class LinkedList {

	Node head;
	Node current;

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
		if (head == null) {
			head = node;
		} else {
			current.next = node;
		}
		current = node;
	}

	public void print() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

	public boolean detectAndRemoveLoop() {
		Node slow = head;
		Node fast = head.next;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				removeLoop(slow);
				return true;
			}
		}
		return false;
	}

	private void removeLoop(Node fast) {
		Node slow = head;
		while (slow != fast.next) {
			fast = fast.next;
			slow = slow.next;
		}
		fast.next = null;
	}

}