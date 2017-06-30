package com.vixir.beprepared.linkedlist.reverse;

public class ReverseLinkedList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.printList();
		list.reverseListRecursive();
		list.printList();
	}

}

class LinkedList {

	ListNode head;
	ListNode currentNode;

	public void add(Integer a) {
		if (null == head) {
			head = new ListNode(a);
			currentNode = head;
		} else {
			ListNode temp = new ListNode(a);
			currentNode.next = temp;
			currentNode = temp;
		}
	}

	public LinkedList() {
	}

	public ListNode reverseList(ListNode a) {
		if (a.next == null) {
			return a;
		}
		ListNode prevNode = null;
		ListNode currentNode = a;
		while (currentNode != null) {
			ListNode temp = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = temp;
		}
		return prevNode;
	}

	public ListNode reverseListRecursive() {
		ListNode a = head;
		reverseListRecursive(a);
		a.next = null;
		return head;
	}

	private ListNode reverseListRecursive(ListNode a) {
		if (a.next == null) {
			head = a;
			return head;
		}
		ListNode returnRecursive = reverseListRecursive(a.next);
		returnRecursive.next = a;
		return a;
	}

	public void printList() {
		ListNode a = head;
		StringBuilder builder = new StringBuilder();
		while (a != null) {
			if (a.next != null) {
				builder.append(a.val + " -> ");
			} else {
				builder.append(a.val);
			}
			a = a.next;
		}
		System.out.println(builder);
	}
}

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}