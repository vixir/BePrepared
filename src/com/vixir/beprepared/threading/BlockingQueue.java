package com.vixir.beprepared.threading;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<Item> {

	private List<Item> queue = new LinkedList<Item>();
	private int limit;

	public BlockingQueue(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Item item) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			wait();
		}
		if (this.queue.size() == 0) {
			notify();
		}
		this.queue.add(item);
	}

	public synchronized Item dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notify();
		}
		return this.queue.remove(0);
	}

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new BlockingQueue<Integer>(5);
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					int i = 0;
					while ((i = queue.dequeue()) <= 9) {
						System.out.println(i + " consumed.");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		for (int i = 0; i < 10; i++) {
			try {
				queue.enqueue(i);
				System.out.println(i + " added.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
