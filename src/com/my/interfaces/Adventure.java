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
public class Adventure implements CanFly, CanSwim, CanFight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

}
