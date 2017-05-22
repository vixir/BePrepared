package com.vixir.beprepared.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockExample {

	public static void main(String[] args) {
		Runner runner = new Runner();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				runner.firstThread();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				runner.secondThread();
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		runner.finish();
	}

}

class Runner {

	private int count = 0;

	Lock lock = new ReentrantLock();

	public void increment() {

		for (int i = 0; i < 1000; i++) {
			count++;
		}

	}

	public void firstThread() {
		lock.lock();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void secondThread() {
		lock.lock();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void finish() {
		System.out.println("Value of count is " + count);
	}

}