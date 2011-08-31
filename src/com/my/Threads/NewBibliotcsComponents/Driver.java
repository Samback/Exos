package com.my.Threads.NewBibliotcsComponents;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class Driver { // ...
	public static final int N = 10;
	protected int vk = 0; 
	class im {
		public im() {
		vk = 0;
		}
		
	}
	public static void main(String[] args)   throws InterruptedException{
		
	 {
		 
	     CountDownLatch startSignal = new CountDownLatch(1);
	     CountDownLatch doneSignal = new CountDownLatch(N);

	     for (int i = 0; i < N; ++i) // create and start threads
	       new Thread(new Worker(startSignal, doneSignal)).start();

	    TimeUnit.SECONDS.sleep(2);
	     startSignal.countDown();      // let all threads proceed
	     TimeUnit.SECONDS.sleep(2);
	     doneSignal.await();           // wait for all to finish
	   }
	 }
}
	 class Worker implements Runnable {
	   private final CountDownLatch startSignal;
	   private final CountDownLatch doneSignal;
	   Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
	      this.startSignal = startSignal;
	      this.doneSignal = doneSignal;
	   }
	   public void run() {
	      try {
	        startSignal.await();
	  TimeUnit.SECONDS.sleep(3);
	        doneSignal.countDown();
	        System.out.println(Thread.currentThread().getName() + " "+ doneSignal);
	      } catch (InterruptedException ex) {} // return;
	   }
	 }
