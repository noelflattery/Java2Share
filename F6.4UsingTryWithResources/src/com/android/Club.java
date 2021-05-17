package com.android;

public class Club implements AutoCloseable{

	@Override
	public void close() throws ClubNoCloseException {
		System.out.println("club closed");
		throw new ClubNoCloseException();
		
	}

}
