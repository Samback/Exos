package com.my.interfaces;

interface CanFly {
	void fly();
}

interface CanSwim
{
	void swim();
}

interface CanFight{
	void fly();
	void fight();
}

interface AllInOne extends CanFly, CanSwim, CanFight{
	
}

class Realization implements AllInOne{

	
	@Override
	public void swim() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}
	
}
public class Adventure extends Realization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object	b= new Object();
		

	}

	
}
