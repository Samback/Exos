package com.my.Threads.Philosophers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadLockPhilosophers {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		int ponder = 10;
		int size = 5;
		ExecutorService exec = Executors.newCachedThreadPool();
		Chopstik [] sticks = new Chopstik[size];
		for (int i = 0; i < size; i++)
			sticks[i] = new Chopstik();
		
		for (int i = 0; i < sticks.length; i++) 
			exec.execute(new Philosopher(sticks[i], sticks[(i+1)%size], i, ponder));
				
		TimeUnit.SECONDS.sleep(50);
		System.out.println("Exiting");
			exec.shutdownNow();
	}

}
