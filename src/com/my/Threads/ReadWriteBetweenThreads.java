package com.my.Threads;

import java.io.IOException;
import java.io.PipedWriter;
import java.util.concurrent.TimeUnit;

class Sender implements Runnable {

	private PipedWriter out = new PipedWriter();

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

public class ReadWriteBetweenThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
