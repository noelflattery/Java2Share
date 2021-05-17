package com.android;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Examples {
	
	static void ex1() throws SQLException,DateTimeParseException{
		try {
			System.out.println("before catchMulti");
			catchMulti();
			System.out.println("after catch multi");
		}
		catch(SQLException |DateTimeParseException e) {
			System.out.println("in ex1 exception is "+e);
			System.err.println(e);
			System.out.println("message is "+e.getMessage());
			throw e;
		}
	}
	
	static void catchMulti()throws SQLException,DateTimeParseException{
		System.out.println("calling multicatch");
		//throw new SQLException();
		LocalDateTime now=LocalDateTime.parse("mucckk");
		/*
		 * if we generate any other type of exception, anywhere in the chain, our program will crash
		 */
	//	int[]nums= {45,67};
	//	System.out.println(nums[4]);
	}
	
	/*
	 * we can also add exception to this method signature and java will still work
	 * or we can take away exceptions in the method signature and it will still work
	 */
	static void ex2()throws SQLException,DateTimeParseException,IOException{
		try {
			System.out.println("before catchMulti");
			catchMulti();
			System.out.println("after catchMulti");
		}
		/*
		 * this can catch any type of exception, so it can deal with any with both sql and datetimeparse
		 * and any other exception both runtime and checked
		 */
		catch(Exception e) {
			System.out.println("catch in ex2 "+e.toString());
			//prints teh error message, with most in bulit exception classes these will be the same
			System.err.println("in ex2 "+e);
			throw e;
		}
	}
	

}
