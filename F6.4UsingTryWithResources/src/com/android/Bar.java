package com.android;

public class Bar implements AutoCloseable{

	@Override
	public void close() throws BarNoCloseException {
		System.out.println("bar closed");
		throw new BarNoCloseException();
		
	}

}
