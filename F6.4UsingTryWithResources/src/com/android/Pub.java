package com.android;

public class Pub implements AutoCloseable{
/*
 * this is the method that will run when we put a pub in a Try with resources
 * we override the close method of the AutoClosable interface, 
 * the close method of the Autoclosable interface throws exception, so when you are overriding you can
 * choose to throw the same exception or a sub class of exception or no exception
 * here we override the close method of the Autoclosable interface with a close method that 
 * throws NO exception
 */
	@Override
	public void close()/* throws Exception */{
		System.out.println("closing our pub");
		
	}
	
	void makeMoney() {
		System.out.println("pub making money");
	}
	void pullPints() {
		System.out.println("pub pulling pints");
	}
	

}
