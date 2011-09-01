package com.my.InpIutput;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BufferedINOUT {

	class Write {
		void write(String arg) throws IOException {
			
			BufferedOutputStream bof = null;
			try {				
				bof = new BufferedOutputStream(new FileOutputStream(new File(arg)));
				byte b[] = "10 20 30 20 10 ".getBytes();
				bof.write(b);
				bof.flush();
			} catch (IOException e) {
			} finally {
				bof.close();
			}
		}
	}
	class Read{
		void read(String arg) throws IOException{
			File f = null;
			DataInputStream in = null;
			try{
				in = new DataInputStream(new FileInputStream(new File (arg)));
				byte b [] = new byte[100];
				in.read(b);
				int i = 0;
				String s = new String(b);
				
				System.out.println(s);
				String [] ss = s.split(" ");
	
				int l = ss.length-1;
				int a [] = new int [l];
				
				for ( i = 0; i < l; i++)
					a[i] = Integer.parseInt(ss[i]);	
				 System.out.println(Arrays.toString(a));
				 a[0]=a[0]*1;
				
			}finally{
				
				in.close();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		String ar = "itsanameoffile.txt";
		BufferedINOUT bo = new BufferedINOUT();
		BufferedINOUT.Write  st = bo.new Write();
		
		
		BufferedINOUT.Read  out = bo.new Read();
		try{
		st.write(ar);
		out.read(ar);
		}
		catch (IOException e){
			System.out.print(e);
		}
	}

}

