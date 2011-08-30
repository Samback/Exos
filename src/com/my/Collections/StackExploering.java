package com.my.Collections;

import java.util.Random;
import java.util.Stack;

public class StackExploering {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<Integer>();
		Random r = new Random();
		for (int i = 0; i < 6; i++)
			st.push(r.nextInt(100));
		while (!st.empty())
			System.out.print(st.pop()+ " ");
		

	}

}
