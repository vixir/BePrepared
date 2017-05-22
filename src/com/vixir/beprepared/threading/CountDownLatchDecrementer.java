package com.vixir.beprepared.threading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDecrementer {

	/* CountdownLatch allows one or more thread to wait for a given set of operations to complete.
		Calling await blocks the thread until the count reaches 0.
	*/
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		Waiter waiter = new Waiter(latch);
		Decrementer decrementer = new Decrementer(latch);
		new Thread(waiter).start();
		new Thread(decrementer).start();
	}

}

class Decrementer implements Runnable {

	CountDownLatch latch = null;

	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			System.out.println(this.latch.getCount());

			Thread.sleep(100);
			this.latch.countDown();
			System.out.println(this.latch.getCount());

			Thread.sleep(100);
			this.latch.countDown();
			System.out.println(this.latch.getCount());

			Thread.sleep(100);
			this.latch.countDown();
			System.out.println(this.latch.getCount());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class Waiter implements Runnable {
	CountDownLatch latch = null;

	public Waiter(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("latch released for the waiter.");
	}
}
