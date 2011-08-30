package com.my.Collections;

import java.util.ArrayList;
import java.util.Collection;

public class SimpleCollection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<Integer>  c = new ArrayList<Integer>(){	{add(5);add(2);		}	};
		System.out.println(c.iterator().next());
		
		

	}

}
