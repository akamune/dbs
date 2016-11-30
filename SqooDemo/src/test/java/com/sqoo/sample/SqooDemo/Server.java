package com.sqoo.sample.SqooDemo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new Worker("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}

	static class Worker implements Runnable {

		private String command;

		public Worker(String command) {
			this.command = command;
		}

		@Override
		public void run() {
			System.out.println("Processing Request = " + command);
			processCommand();
			System.out.println("End request = " + command);
		}

		private void processCommand() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Override
		public String toString() {
			return this.command;
		}
	}

}