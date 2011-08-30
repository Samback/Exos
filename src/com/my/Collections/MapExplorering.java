package com.my.Collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExplorering {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("abcde", 5);
		hm.put("abc", 3);
		hm.put("abcd", 4);
		hm.put("aaaaaa", 1);
		
		System.out.println(hm);
		
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>(hm);
		System.out.println(tm);
		
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>(tm);
		System.out.println(lhm);

	}

}
