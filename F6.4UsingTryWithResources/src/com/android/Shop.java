package com.android;

public class Shop implements AutoCloseable{

	@Override
	public void close() throws IllegalStateException {
		System.out.println("shop closing");
		/*
		 * only when you have this line code, do you need to include a catch block 
		 * in examples.ex5
		 */
		throw new IllegalStateException("shop will not close");
		
	}

}
