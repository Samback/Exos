package com.my.InpIutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputOutPutTests {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		File f = null;
		
		OutputStream out = null;
		InputStream in =null;
		
		try{
			f = new File ("input.txt");
			out = new FileOutputStream(f);
			byte [] b = "It's not funny, lips in honey:)".getBytes();
			out.write(b);			
		}catch (Exception e) {
			System.err.print(e);
		}finally{
			out.close();
		}
		
		try{
			f = new File ("input.txt");
			in = new FileInputStream(f);
			byte [] b = new  byte [10];
			int n = 0, n1 = 0;
			do{
				n = in.read(b, 0, 10);
				System.out.println(new String(b));
				n1 += n;				
			}while(n == 10);
			System.out.println(n1);
			byte c [] = new byte[n1];
			in.read(c);
			System.out.println(new String(c));
		}catch (Exception e) {
			System.err.print(e);
		}finally{
			out.close();
		}

	}

}
