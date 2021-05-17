package com.android;

public class Main {
	/*
	 * the previous chapter was about java.io API
	 * in this chapter we focus on what is known as java.nio version 2 API or 
	 * NIO.2 for short, also called "New I/O"
	 * when we are talkng about streams in this chapter we are refereeing functional programming
	 * specification as seen in chapter 4
	 */

	public static void main(String[] args) {
		/*
		 * first version of file I/O is java.io.api and this uses byte streams, as seen in chapter 7, 
		 * to interface with data files.
		 * java 1.4 introduced Non-Blocking I/O or NIO for short
		 * the basic idea being that it uses buffers and channels in place of I/O streams, and you load
		 * the data from the file into a temporary buffer. so you can read backward and forward and it
		 * does not block the underlying resource (file).
		 * NIO 1 was not very popular so java 7 introduced NIO.2, and this is a proper replacement for 
		 * java.io.file class
		 */
	//	Examples.ex1();
	//	Examples.ex2();
		Examples.ex3();

	}

}
