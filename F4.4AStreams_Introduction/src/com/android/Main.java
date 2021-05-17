package com.android;

public class Main {
/***
 * Main method that calls methods in the Examples class that call all the code to do with Streams_Introduction section
 * STREAMS
 * these are NOT file input or outputStreams, which are something totally different and
 * are covered in chapter 8.
 * A stream is not a data structure (i.e not a array, arraylist, etc), instead it
 * takes input from COLLECCTIONS,ARRAYS or io/channels or we can generate data using
 * iterate() or generate()
 * Streams don't usually change the original data structure (if its based on a 
 * list, it will usually not change the original data, but it can but it is difficult
 * to do)
 * Streams are made up of three basic parts
 * Creation
 * Intermediate operation, these are operations that are carried out on the Stream,
 * such as filter(), and limit(). they are lazily executed, which means the actions
 * are not carried until a 
 * TERMINAL OPERATION
 * a TERMINAL operation is a method that calls all of the Intermediate operations 
 * of a stream, it also closes the stream and returns a result for the stream.
 * example of a terminal method is foreach()
 * @see com.android.Examples
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Examples.ex1();
	//	Examples.ex2();
	//	Examples.ex3();
		//Examples.ex4();
		//Examples.ex5();
		//Examples.ex6();
		//Examples.ex7();
		//Examples.ex9();
		//Examples.ex10();
		Examples.ex11();
		Animal ann;

	}

}
