package com.my.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



class DeamonsFactorys implements Runnable{

	@Override
	public void run() {
		while (true)
		{			
			try {
				System.out.println(Thread.currentThread().getId()+ " ");
				TimeUnit.SECONDS.sleep(1);
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
public class DeamonsStart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i = 0; i < 6; i++)
			exec.execute(new DeamonsFactorys());
		System.out.println("Now deamons are free!!!!1");	
		try {
			TimeUnit.SECONDS.sleep(10);
			System.out.println("Thats all");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
