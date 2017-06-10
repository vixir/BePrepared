package com.vixir.beprepared.linkedlist;

public class DetectLoop {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.push(8);
		list.push(7);
		list.push(6);
		list.push(5);
		list.push(4);
		list.push(3);
		list.push(2);
		list.push(1);
		System.out.println("Before adding loop...");
		list.print();
		System.out.println("add loop...");
		list.head.next.next.next.next.next.next.next.next = list.head.next.next.next;
		if (list.detectAndRemoveLoop()) {
			System.out.println("\nLoop detected and Removed");
		} else {
			System.out.println("No loop in the list");
		}
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
		node.next = head;
		head = node;
	}

	public boolean detectAndRemoveLoop() {
		Node slow = head;
		Node fast = head;
		while (null != slow && null != fast && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				removeLoop(slow);
				return true;
			}
		}
		return false;
	}

	public void print() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

	private void removeLoop(Node loop) {
		Node ptr1 = head, ptr2 = loop;
		while (ptr2.next != loop) {
			ptr2 = ptr2.next;
			ptr1 = ptr1.next;
		}
		ptr1 = ptr1.next;
		ptr2 = head;
		while (ptr2 != ptr1) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		while (ptr2.next != ptr1) {
			ptr2 = ptr2.next;
		}

		ptr2.next = null;
	}

}