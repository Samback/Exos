package com.my.simple;

class One {
	public  void  say ()
	{
		System.out.println("Yes");
		int art = 0;
		class KPP{
			public int b ;
			void Kpp(){
			One am = new One();
			am.say();

			}
		}
	}
}
class Two extends One{
	static final int b = 0;
	public void say (){
		System.out.println("NO");
	}
}
public class SimpleOne {

	public static void main(String[] args) {

		
		for (int i = 0; i < 10; i++)
			System.out.println("Hello world !"+ i+ "!!");
		
		System.out.println("My own");
		
		System.out.println(Two.b);
	}

}
