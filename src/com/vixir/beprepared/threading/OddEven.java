package com.vixir.beprepared.threading;

public class OddEven {

	public static void main(String[] args) {
		NumberPrintr numberPrinter = new NumberPrintr();
		new EvenPrinter(numberPrinter).start();
		new OddPrinter(numberPrinter).start();
	}
}

class NumberPrintr {
	public boolean isEvenPrinted = true;

	public synchronized void printEven(int number) throws InterruptedException {
		if (isEvenPrinted) {
			wait();
		}
		isEvenPrinted = true;
		System.out.println(number);
		notifyAll();
	}

	public synchronized void printOdd(int number) throws InterruptedException {
		if (!isEvenPrinted) {
			wait();
		}
		System.out.println(number);
		isEvenPrinted = false;
		notifyAll();

	}

}

class OddPrinter extends Thread {

	NumberPrintr printer;

	public OddPrinter(NumberPrintr printer) {
		this.printer = printer;
	}

	@Override
	public void run() {
		for (int i = 1; i < 10; i += 2) {
			try {
				printer.printOdd(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class EvenPrinter extends Thread {
	NumberPrintr numberPrinter;

	public EvenPrinter(NumberPrintr printer) {
		this.numberPrinter = printer;
	}

	@Override
	public void run() {
		super.run();
		for (int i = 2; i <= 10; i += 2) {
			try {
				numberPrinter.printEven(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
