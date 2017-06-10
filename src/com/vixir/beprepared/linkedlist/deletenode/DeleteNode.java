package com.vixir.beprepared.linkedlist.deletenode;

public class DeleteNode {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.push(3);
		linkedList.push(6);
		linkedList.push(1);
		linkedList.push(7);
		linkedList.push(2);
		linkedList.push(5);
		linkedList.print();
		System.out.println("\nDeleting head...");
		linkedList.delete(linkedList.head, linkedList.head);
		linkedList.print();
		System.out.println("\nDeleting 6...");
		linkedList.delete(linkedList.head, linkedList.head.next.next.next);
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

	public void print() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

	// delete node n from the linked list.
	public void delete(Node head, Node n) {
		// delete the head node
		if (head == n) {
			if (n.next == null) {
				System.out.println("list will be empty after deleting this");
				return;
			}
			head.data = head.next.data;
			head.next = head.next.next;
			return;
		}
		Node curr = head;
		while (curr.next != null && curr.next != n) {
			curr = curr.next;
		}
		if (curr.next == null) {
			System.out.println("node doesn't exist");
			return;
		}
		curr.next = curr.next.next;
		return;
	}
}