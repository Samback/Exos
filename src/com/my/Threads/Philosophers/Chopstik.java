package com.my.Threads.Philosophers;

public class Chopstik {
	private boolean taken = false;
	public synchronized void take () throws InterruptedException{	
		while(taken)
			wait();
		taken = true;
	}
	public synchronized void drop () throws InterruptedException{	
		taken = false;
		notifyAll();
		
	}


	
}
