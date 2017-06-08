package com.vixir.beprepared.linkedlist;

public class DetectLoop {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.push(20);
		list.push(4);
		list.push(15);
		list.push(10);
		list.head.next.next.next.next = list.head;
		if (list.detectLoop()) {
			System.out.println("Loop detected");
		}else{
			System.out.println("no loop in the list");
		}

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

	public boolean detectLoop() {
		Node slow = head;
		Node fast = head;
		while (null != slow && null != fast && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast){
				return true;
			}
		}
		return false;
	}
}