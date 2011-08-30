package com.my.Threads;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car{
	private boolean WaxOn = false;
	
	public synchronized void waxes() {
		WaxOn = true;	//ready to cleaning
		notifyAll();
	}
	
	public synchronized void buffed() {
		WaxOn = false;	//ready to new layout
		notifyAll();
	}
	
	public synchronized void waitForWaxing() throws InterruptedException {
		while (WaxOn == false)	//ready to new layout
			wait();
	}
	public synchronized void waitForBuffering() throws InterruptedException {
		while (WaxOn == true)	//ready to new layout
			wait();
	}
	
	
	
}
class WaxOn implements Runnable{
	private Car car;
	public WaxOn(Car c) {
		car = c;
	}

	@Override
	public void run() {
		try{
			while(!Thread.interrupted())
			{
				System.out.println("WaxOn!!!");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxes();
				car.waitForBuffering();
			}
		}catch (InterruptedException e) {
			System.out.println("Exiting via interupted");
		}
		System.out.println("Ending wax on task");			
	}
	
}

class WaxOFF implements Runnable{
	private Car car;
	public WaxOFF(Car c) {
		car = c;
	}

	@Override
	public void run() {
		try{
			while(!Thread.interrupted())
			{
				car.waitForWaxing();
				System.out.println("WaxOFF!!!");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
				
			}
		}catch (InterruptedException e) {
			System.out.println("Exiting via interupted");
		}
		System.out.println("Ending wax off task");			
	}
	
}	
public class WaxOMatic{
	public static void main(String[] args) throws Exception {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOn(car));
		exec.execute(new WaxOFF(car));
	
		
		exec.shutdown();
		
	}
}