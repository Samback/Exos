package com.my.Threads;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import sun.misc.Lock;


class MyRunner implements Runnable{
	private ReentrantLock  locks = new ReentrantLock();
	@Override
	public  void run() {
		
		for (int i = 0; i < 10; i++ )		
		{
			System.out.println(i +" # "+ Thread.currentThread().getId()+ "- ");
			try {
				Thread.currentThread().sleep((new Random()).nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}

public class SimpleThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 6; i++)
			exec.execute(new MyRunner());
		exec.shutdown();
	}

}
