package com.vixir.beprepared.threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ExecutorExample {

	public static void main(String[] args) {

		ExecutorService serviceExecute = Executors.newSingleThreadExecutor();
		serviceExecute.execute(() -> {
			System.out.println("vivek");
		});
		serviceExecute.shutdown();

		ExecutorService serviceSubmit = Executors.newCachedThreadPool();
		Future future = (FutureTask) serviceSubmit.submit(() -> {
			return "callable result";
		});
		try {
			System.out.println("Future result "+future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
