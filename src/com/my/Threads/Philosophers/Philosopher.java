package com.my.Threads.Philosophers;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable {

	private Chopstik left;
	private Chopstik right;

	private final int id;
	private final int ponderFactor;
	private Random rand = new Random(47);

	private void pause() throws InterruptedException {
		if (ponderFactor == 0)
			return;
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
	}

	public Philosopher(Chopstik left, Chopstik right, int ident, int ponder) {
		this.left = left;
		this.right = right;
		id = ident;
		ponderFactor = ponder;
	}
	@Override
	public String toString () { return "Philosopher " + id;}

	@Override
	public void run() {
		try{
			
			while(!Thread.interrupted()){
				System.out.println(this + " thinking");
				//takes right 
				System.out.println(this + " take right");
				right.take();
				
				//takes left
				System.out.println(this + " take left");
				left.take();
				
				System.out.println(this + " drop left");
				left.drop();
				System.out.println(this + " drop right");
				right.drop();
				
			}
		}catch (InterruptedException e) {
			System.out.println("exit interupted" + this);
		}

	}
}
