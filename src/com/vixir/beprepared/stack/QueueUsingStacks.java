package com.vixir.beprepared.stack;

import java.util.Stack;

public class QueueUsingStacks<Element> {

	Stack<Element> stackA = new Stack<Element>();
	Stack<Element> stackB = new Stack<Element>();

	public void enqueue(Element a) {
		stackA.push(a);
	}

	public Element dequeue() {
		if (!stackB.isEmpty()) {
			return stackB.pop();
		} else {
			while (!stackA.isEmpty()) {
				stackB.push(stackA.pop());
			}
		}
		return stackB.pop();
	}

	public void print() {
		for (Element e : stackA) {
			System.out.print(e + " ");
		}
		for (Element e : stackB) {
			System.out.print(e + " ");
		}
	}

	public static void main(String[] args) {
		QueueUsingStacks<Integer> queueUsingStacks = new QueueUsingStacks<Integer>();
		queueUsingStacks.enqueue(1);
		queueUsingStacks.enqueue(2);
		queueUsingStacks.enqueue(3);
		queueUsingStacks.dequeue();
		queueUsingStacks.dequeue();
		queueUsingStacks.enqueue(4);
		queueUsingStacks.enqueue(5);
		queueUsingStacks.enqueue(6);
		queueUsingStacks.dequeue();
		queueUsingStacks.print();
	}

}
