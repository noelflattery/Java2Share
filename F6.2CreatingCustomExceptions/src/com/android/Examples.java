package com.android;

public class Examples {
	
	static void ex1() {
	try{
			//our own checked exception, has to be in a try/catch block
			throw new CannotSwimException();
		}
	catch(Exception e) {
		System.out.println(e);
		System.out.println("exception caught");
	}
	
	try {
		throw new CannotSwimException(new Exception());
		/*
		 * this produces
		 * com.android.CannotSwimException: java.lang.Exception
		 * com.android.CannotSwimException is the primary exception produced
		 * and java.lang.Exception is the exception that was sent to constructor in the 
		 * CannotSwimException class that takes a exception as an arguement
		 */
	}
	catch(CannotSwimException e) {
		System.out.println(e);
		System.out.println("exception 2 caught");
	}
	
	try {
		/*
		 * calls the constructor in the 
		 * CannotSwimException class that takes a string
		 */
		throw new CannotSwimException("here is my message for the third try block");
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println(e.getClass().getSimpleName());
		System.out.println("exception 3 caught");
	}
	}
	
	static void ex2() {
		Person percy=new Person();
		Animal dog=new Animal();
		try {
			/*
			 * the swim method for the Person class generates a checked CannotSwimException
			 * as people can't swim
			 */
			percy.swim();
		}
		catch(CannotSwimException e) {
			/*
			 * this catches the exception and resuces our human
			 */
			System.out.println("resuce our human");
		}
		
		try {
			/*
			 * the swim method for the Animal class does NOT generate a checked CannotSwimException
			 * as Animals can swim
			 */
			dog.swim();
		}
		catch(CannotSwimException e) {
			System.out.println("rescue our animal");
		}
	}

}
