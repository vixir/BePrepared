package com.vixir.beprepared.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingSingleQueue<Element> {
	Queue<Element> q;

	public void push(Element e) {
		if (null == q || q.size() == 0) {
			q = new ArrayDeque<Element>();
			q.add(e);
		} else {
			q.add(e);
		}
	}

	public Element poll() {
		int n = q.size();
		for (int i = 0; i < n - 1; i++) {
			Element t = q.poll();
			q.add(t);
		}
		return q.poll();
	}

	public static void main(String[] args) {
		StackUsingSingleQueue<Integer> q = new StackUsingSingleQueue<Integer>();
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		q.push(5);
		q.push(6);
		q.push(7);
		q.push(8);
		q.push(9);
		System.out.print("before calling poll() method : ");
		q.printq();
		q.poll();
		System.out.print("after calling poll() method : ");
		q.printq();
	}

	private void printq() {
		for (Element e : q) {
			System.out.print(e.toString() + " ");
		}
		System.out.println();
	}

}
