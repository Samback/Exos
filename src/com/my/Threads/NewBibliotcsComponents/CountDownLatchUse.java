package com.my.Threads.NewBibliotcsComponents;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TaskPoriton implements Runnable{
	private static int counter = 0;
	private final int id = counter ++;
	private static Random rand = new Random(47);
	private final CountDownLatch latch;
	
	public TaskPoriton(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		
			doWork();
			latch.countDown();			
		
	}
	void doWork(){
		try {
			TimeUnit.SECONDS.sleep(rand.nextInt(20));
			System.out.println(this + " ended!!!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
class WaitingTask implements   Runnable{
	private static int counter = 0;
	private final int id = counter ++;
	private static Random rand = new Random(47);
	private final CountDownLatch latch;
	
	public WaitingTask(CountDownLatch latch) {
		this.latch = latch;
	}


	@Override
	public void run() {
		
			try {
				latch.await();
				TimeUnit.SECONDS.sleep(rand.nextInt(20));
				System.out.println("============="+this + "cross barier");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	
}
public class CountDownLatchUse {
	static final int SIZE = 100;
public static void main(String[] args) {
	ExecutorService exec = Executors.newCachedThreadPool();
	CountDownLatch latch = new CountDownLatch(SIZE);
	
	

	for (int i = 0; i < 10; i++)
		exec.execute(new WaitingTask(latch));
	
	
	for (int i = 0; i < SIZE; i++)
		exec.execute(new TaskPoriton(latch));
	
	System.out.println("All processes started -- >");
	
	exec.shutdown();
}
}
