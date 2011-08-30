package com.my.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Ones {
	private static int im = 0;
	synchronized int next()
	{
		im ++;
		Thread.currentThread().yield();
		im ++;
		Thread.currentThread().yield();	
		return im;
	}
}
class MyOwnRunnable implements Runnable{
private static Ones one = new Ones();
	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
		{			
			try {
				System.out.println(Thread.currentThread().getId()+ "->"+one.next());
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}


public class SimpleSincronization {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++)
			executor.execute(new MyOwnRunnable());
		executor.shutdown();
	}
	

}
