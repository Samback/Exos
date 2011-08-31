package com.my.Threads;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Sender implements Runnable {

	private PipedWriter out = new PipedWriter();
	public PipedWriter getPipedWrter (){ return out;}

	@Override
	public void run() {
		try {
			while (true)
				for (char c = 'A'; c < 'z'; c++) {
					out.write(c);
					TimeUnit.MILLISECONDS.sleep(100);
				}
		} catch (IOException e) {
			System.out.print(e);
		} catch (InterruptedException e) {
			System.out.print(e);
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class Reciver implements Runnable{

	private PipedReader in ;
	public Reciver (Sender sender ) throws IOException{
		in = new PipedReader(sender.getPipedWrter());
	}
	@Override
	public void run() {
		try{
			while(true)
				System.out.println(" Read " + (char) in.read());
		}catch (IOException e) {
			System.out.println(e);
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	} 
	
}

public class ReadWriteBetweenThreads {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		ExecutorService exec = Executors.newCachedThreadPool();
		Sender sender = new Sender ();
		Reciver reciver = new Reciver(sender);
		exec.execute(sender);
		exec.execute(reciver);
		TimeUnit.SECONDS.sleep(4);
		exec.shutdownNow();

	}

}
