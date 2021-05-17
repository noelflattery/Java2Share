package com.android;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[]args) {
		try {
			/*
			 * a traditional try Has to have a catch OR  finally
			 * it can have both
			 * you can't have a catch or a finally without a try
			 */
			throw new Exception();//checked exception
			
		}
		catch(Exception e) {
			System.out.println("exception "+e+" is generated");
		}
		finally {
			
		}
		/*
		 * you have to deal with a checked exception, if you don't, your program NOT
		 * compile
		 */
//	throw new Exception();
		/*
		 * this could produced a checked exception, so it has to be put in try/catch block
		 */
		try {
			throwMeChecked();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		throwMeRuntime();
		multi();

	}
	/*
	 * anything that CAN produce a checked exception, HAS TO BE PUT in a try/catch block
	 */
	static void throwMeChecked()throws Exception{
		
	}
	/*
	 * this does NOT have to be put in a try catch block, as this is only a runtimeException.
	 * this method produces no excpetion at all, so when you call this method, your code will run
	 * fine. all that the throws does here is, IF runtimeExcpetion is generated in this method
	 * the method does not need a try/catch block but will throw it out. however if it does
	 * throw out a runtimeException (ArrayIndexOutOfBoundsException) then the call would have to
	 * put ina  try catch block
	 */
	static void throwMeRuntime()throws RuntimeException{
		System.out.println("throwMeRuntime method");
		/*
		 * if we comment in this code, our program will crash as the call to this method
		 * is NOT in a try catch block
		 */
	/*	List<Integer>nums=Arrays.asList(4,56,78);
		System.out.println(nums.get(5));*/
		
	}
	
	static void multi() {
		/*
		 * a file object is the address of the file, not the file itself
		 */
		System.out.println("multi");
		File myFile=new File("test.txt");
		File myfile2=new File("C:/somedir/moredir/test2.txt");
		List<Integer>nums=Arrays.asList(34,56,8);
		
		try {
	//		nums.get(5);//this will be caught by first catch block
	//		Dog spot=(Dog)new Animal();//this will be caught by the second catch block
			/*
			 * this will be caught by the catch block that deals with all other
			 * runtimeException
			 */
		//	LocalDate myDate=LocalDate.of(1970, 14, 29);//there is no 14 month
			//this will create a file "test.txt" inside the com.android package
			//to see file click on project name in package explorer and click on refresh
			System.out.println("is file created "+myFile.createNewFile());
			/**
			 * this will NOT create a file as myfile2 has new directories in the file path name
			 * so this command cannot create the new directories needed for the file path
			 * c:/somedir/moredir/test2.txt"
			 */
	//		System.out.println("is file created "+myfile2.createNewFile());
			/*
			 * this will be caught by the 
			 * catch(Exception e) blockc
			 */
			throw new SQLException();
			
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("this catches index out of bounds exception");
			System.out.println(e.getClass().getSimpleName());
		}
		catch(ClassCastException e) {
			System.out.println("this catches the class cast exeption ");
			System.out.println(e.getClass().getSimpleName());
		}
		catch(RuntimeException e) {
			System.out.println("this will catch all other runtime exceptions");
			System.out.println(e.getClass().getSimpleName());
		}
		/*
		 * this will NOT compile, unless there is code in the try block that COULD generate
		 * a checked exception
		 */
		catch(IOException e) {
			System.out.println("this will catch all IO Exceptions (dealing with files)");
			System.out.println(e.getClass().getSimpleName());
		}
		
		/*
		 * this can deal with ALL exceptions
		 */
		catch(Exception e) {
			System.out.println("this will catch all other checked exceptions ");
			System.out.println(e.getClass().getSimpleName());
		}
		
		
		
		
		
		
	}

}
