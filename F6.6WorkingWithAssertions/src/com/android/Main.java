package com.android;

public class Main {
	/**
	 * Assertions are not enabled by default in eclipse so we have to do the following if we want to enable them
	 * for a particular project
	 * In Eclipse, select "Run » Run Configurations..." from the menu bar. This will open 
	 * up a dialog window. If you do not already have a run configuration for the current 
	 * file, go ahead and create one. Otherwise, select the "Arguments" tab and enter -ea in the "VM Arguments
	 * Assertions Uses
	 * Internal Invariants
	 * check a value is within a certain range or constraint (x between 1 and 10)
	 * Class Invariants
	 * assert the validity of an objects state (i.e a human object is male or female, and has valid values for
	 * weight, height, etc)
	 * Control Flow Invariants
	 * assert that a line of code is unreachable is never reached
	 * Preconditions
	 * Assert that certain conditions are met before a method executes (human object owns a number of cow objects before
	 * he calls the milking() method
	 * PostConditions assert certain conditions are met after a method executes sucessfully
	 * Assertions should be turned off in production code (finished apps gone out to production)
	 * ASSERTIONS SHOULD not contain any business logic that affects your code
	 * Assertions could be called "ACTIVE COMMENTS", in that they actually check if rules are 
	 * enforced rather than just comments which issue a comment that does not do any checks
	 * @param args
	 */

	public static void main(String[] args) {
		/*
		 * this does nothing if assertions are not turned on
		 * it produces 
		 * java.lang.AssertionError
		 * if assertions are turned on
		 * Assertions are also called ACTIVE COMMENT
		 * NEVER use these in final production code
		 * if you have assertions turned off, the code is ignored
		 */
		System.out.println("ensure someone is over 18 years of age");
	/*	int age=5;
		if(age<18)
			assert false;//if we use an age less than 18, we get an assertion error and our application will crash
		else
			System.out.println("you are over 18 years of age");
	//	assert false;
		assert true;*/
		
		Examples.ex1();
	//	Examples.ex2();
		
		assert true;
		System.out.println("our code can continue after an assert true");

	}

}
