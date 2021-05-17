package com.android;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cafe implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("cafe closing");
		Path path1=Paths.get("src/test3.txt");
		BufferedReader in=Files.newBufferedReader(path1);
		String str=in.readLine();
		System.out.println("closed for good");
//		throw new Exception();
		
	}

}
