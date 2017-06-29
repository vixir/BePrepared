package com.vixir.beprepared.stack;

import java.util.LinkedList;

public class StackUsingQueues {

	public static void main(String[] args) {
		StackQ<Integer> q = new StackQ();
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		q.push(5);
		q.pop();
		q.pop();
		q.push(6);
		q.print();
	}

}

class StackQ<Element> {

	LinkedList<Element> inward;
	LinkedList<Element> outward;

	public StackQ() {
		inward = new LinkedList<Element>();
		outward = new LinkedList<Element>();
	}

	public void push(Element e) {
		inward.add(e);
	}

	public Element pop() {
		while (inward.size() > 1) {
			Element t = inward.removeFirst();
			outward.add(t);
		}
		Element t = inward.removeFirst();
		LinkedList<Element> temp = outward;
		outward = inward;
		inward = temp;
		return t;
	}

	public void print() {
		for (Element e : outward) {
			System.out.print(e + " ");
		}
		for (Element e : inward) {
			System.out.print(e + " ");
		}
	}
}