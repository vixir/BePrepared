package com.vixir.beprepared.threading;

import java.util.LinkedList;
import java.util.Queue;

public class InterthreadCommunication {

	public static void main(String[] args) {
		Queue<Integer> sharedQ = new LinkedList<Integer>();
		new Producer(sharedQ).start();
		new Consumer(sharedQ).start();
	}

}

class Producer extends Thread {
	private final Queue<Integer> sharedQ;

	public Producer(Queue<Integer> sharedQ) {
		this.sharedQ = sharedQ;
	}

	@Override
	public void run() {
		for (int i = 0; i < 7; i++) {
			synchronized (sharedQ) {
				while (sharedQ.size() >= 1) {
					try {
						System.out.println("queue is full, waiting");
						sharedQ.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("producing " + i);
				sharedQ.add(i);
				sharedQ.notify();
			}
		}
	}
}

class Consumer extends Thread {

	private final Queue<Integer> sharedQ;

	public Consumer(Queue<Integer> sharedQ) {
		this.sharedQ = sharedQ;
	}

	@Override
	public void run() {
		synchronized (sharedQ) {
			while (true) {
				while (sharedQ.size() == 0) {
					try {
						System.out.println("Queue is empty, waiting");
						sharedQ.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				int number = (int) sharedQ.poll();
				System.out.println("consuming Number " + number);
				sharedQ.notify();
				if (number == 6) {
					break;
				}

			}
		}
	}
}
