package com.android;

import java.io.IOException;

public class TurkeyShed implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("turkey shed closing");
	//	throw new IOException();
		
	}

}
