package com.vixir.beprepared.threading;

import java.util.concurrent.ArrayBlockingQueue;

public class InterthreadUsingBlockingQ {

	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
		new QProducer(queue).start();
		new QConsumer(queue).start();
	}
}

class QProducer extends Thread {

	ArrayBlockingQueue<Integer> x;

	public QProducer(ArrayBlockingQueue<Integer> x) {
		this.x = x;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
				x.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("put " + i);
		}
	}

}

class QConsumer extends Thread {

	ArrayBlockingQueue<Integer> x;

	public QConsumer(ArrayBlockingQueue<Integer> x) {
		this.x = x;
	}

	@Override
	public void run() {
		try {
			int l = 0;
			while ((l = x.take()) != 9) {
				System.out.println("taken" + l);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
