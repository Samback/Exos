package com.my.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ones {
	private static int im = 0;
	private static int inn = 0;
	
	private Lock lockk = new ReentrantLock();
	synchronized int next()
	{
		im ++;
		Thread.currentThread().yield();
		im ++;
		Thread.currentThread().yield();	
		return im;
	}	
	int nextInt() throws InterruptedException
	{
		
		lockk.lock();
		try{
		inn ++;
		Thread.currentThread().sleep(1000);
		inn ++;
	
		return inn;
		}finally{
			lockk.unlock();
		}
		
		
	}
}
class MyOwnRunnable implements Runnable{
private static Ones one = new Ones();
	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
		{			
			try {
				System.out.println(Thread.currentThread().getId()+ "->"+one.nextInt());
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
		{
			executor.execute(new MyOwnRunnable());
			System.out.println("=========");
		}
		executor.shutdown();
		
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++)
			{
			exec.execute(new MyOwnRunnable());
			System.out.println("++++++++++++++");
			}
		exec.shutdown();
	}
	

}
