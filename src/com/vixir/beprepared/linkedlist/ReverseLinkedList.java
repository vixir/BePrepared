package com.vixir.beprepared.linkedlist;

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class ReverseLinkedList {

	public static ListNode reverseList(ListNode a) {
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

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		a.next = b;
		ListNode c = new ListNode(3);
		b.next = c;
		ListNode d = new ListNode(4);
		c.next = d;
		ListNode e = new ListNode(5);
		d.next = e;
		printList(a);
		// 1->2->3->4->5
		ListNode node = reverseList(a);
		printList(node);
	}

	private static void printList(ListNode a) {
		StringBuilder builder = new StringBuilder();
		while (a != null) {
			if (a.next != null) {
				builder.append(a.val + " -> ");
			}else{
				builder.append(a.val);
			}
			a = a.next;
		}
		System.out.println(builder);
	}
}
