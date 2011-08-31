package com.my.simple;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;



public class FilesWork {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException, IOException  {
		File f = new File("input.txt");
		DataOutputStream out = new DataOutputStream(new FileOutputStream(f));
		out.writeBytes("Helooooooooo\n helooooooo");
		out.close();
		
		
		DataInputStream in = new DataInputStream(new FileInputStream(f));
		byte b[] = new byte [1000];
		
		String s = in.readLine();
		System.out.println(s);
		in.close();
		
		
		
	}
	
}
