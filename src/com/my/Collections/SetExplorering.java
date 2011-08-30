package com.my.Collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetExplorering {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		
		Set<Integer> hs = new HashSet<Integer>();
		Integer a[] = new Integer[30];
		
	
		for (int i = 0; i < 30; i++)
			a[i] = (r.nextInt(1000));
		System.out.println(Arrays.deepToString(a));
		hs.addAll(Arrays.asList(a));
		
		System.out.println("Hash Set"+" \n"+hs);
		
		Set <Integer> ts = new TreeSet<Integer>(Arrays.asList(a));
		System.out.println("Tree Set"+" \n"+ts);
		
		Set <Integer> lhs = new LinkedHashSet<Integer>(Arrays.asList(a));
		System.out.println("LinkedHash Set"+" \n"+lhs);
		
			

	}

}
