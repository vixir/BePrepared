package com.vixir.beprepared.threading;

public class OddEvenThread {

	public static void main(String[] args) {
		NumberPrinter pr = new NumberPrinter();
		int maxNumber = 10;
		new Thread(new OddNumGenerator(pr, maxNumber)).start();
		new Thread(new EvenNumGenerator(pr, maxNumber)).start();
	}

}

class NumberPrinter {
	
	private boolean isEvenPrinted = true;

	public void printOdd(int number) throws InterruptedException {
		synchronized (this) {
			if (!isEvenPrinted) {
				wait();
			}
			System.out.println(number);
			isEvenPrinted = false;
			notify();
		}
	}

	public void printEven(int number) throws InterruptedException {
		synchronized (this) {
			if (isEvenPrinted) {
				wait();
			}
			System.out.println(number);
			isEvenPrinted = true;
			notify();
		}
	}
}

class OddNumGenerator implements Runnable {
	private NumberPrinter q;
	private int max;

	public OddNumGenerator(NumberPrinter q, int max) {
		this.q = q;
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = 1; i < max; i = i + 2) {
			try {
				q.printOdd(i);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}

class EvenNumGenerator implements Runnable {
	private NumberPrinter printer;
	private int max;

	public EvenNumGenerator(NumberPrinter printer, int max) {
		this.printer = printer;
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = 2; i <= max; i = i + 2) {
			try {
				printer.printEven(i);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}
