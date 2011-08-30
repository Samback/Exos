package com.my.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeSet;

public class SimpleCollection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<Integer>  c = new ArrayList<Integer>(){	{add(5);add(2);		}	};
		//Another type
		Collection<Integer>  c1	= new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		Integer a [] = new Integer[10];
		for (int i = 0; i < 10; i++)
			a[i] =  (new Random()).nextInt(100);
		
		System.out.println("Generated array"+"\n"+Arrays.deepToString(a));
		
		HashSet<Integer> hs = new HashSet<Integer>(Arrays.asList(a));
		System.out.println("HashSet"+"\n"+hs);
		
		TreeSet<Integer> ts = new TreeSet<Integer>(Arrays.asList(a));
		System.out.println("TreeSet"+"\n"+ts);
		
		LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>(Arrays.asList(a));
		System.out.println("linkedHashSet"+"\n"+lhs);

	}

}
