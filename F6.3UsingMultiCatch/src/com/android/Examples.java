package com.android;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Examples {
	
	static void ex1() {
		try {
		//	LocalDate date=LocalDate.parse("jiuoliujli");
			/*
			 * this below code will never run, as the above line generates a 
			 * DateTimeParseException
			 */
			Path path=Paths.get("muck.txt");//this is jsut an address
			String text=new String(Files.readAllBytes(path));//this is trying to read the file
			
		}
		catch(DateTimeParseException e) {
			System.out.println(e);
			System.out.println("first catch block");
		//	e=new DateTimeParseException();
		}
		catch(IOException e) {
			System.out.println(e);
			System.out.println("second catch block");
			/*
			 * you CAN REDEFINE A EXCEPTION in a catch block
			 * it is not recommended 
			 */
			e=new IOException();
		}
	}
	
	static void ex2() {
		try {
			/*
			 * this produces a classCast exception which is NOT dealt with in the multi catch
			 * so this will cause our program to crash
			 */
	//		Dog spot=(Dog)new Animal();
			
			List<Integer>numbers=new ArrayList<>(Arrays.asList(34,56,99));
		//	List<Integer>numbers2=Arrays.asList(22,456,78);			
		//	numbers.add(120);
		//	numbers2.add(1000);	
			/*
			 * this triggers the IndexOutOfBoundsException in the multi catch
			 */
			System.out.println(numbers.get(20));
			int[]nums= {45,67,88};
			/*
			 * this triggers the IndexOutOfBoundsException as ArrayIndexOutOfBounds is a subclass
			 * of IndexOUtOfBoundsException and will print out
			 * you are attempting to access a item in our array that does not exist"
			 */
			System.out.println(nums[3]);
			/*
			 * this will trigger a DateTimeParseException and will print out
			 * invalid date entered"
			 */
			LocalDate date=LocalDate.parse("jiuoliujli");
			Path path=Paths.get("muck.txt");
			/*
			 * this will print trigger IOException as this causes a NoSuchFileException which is a sub
			 * class of IOException and print "there is no file of this name
			 */
			String text=new String(Files.readAllBytes(path));
			
		}
		/*
		 * order does NOT MATTER
		 * all of the exception classes used have to be exclusive
		 * you can't have two different exception types that could deal with the same exception
		 * i.e here we can't have ArrayIndexOutOfBounds as indexOutOfBounds could also deal with
		 * anything that generates ArrayIndexOutOfBounds
		 * we could not put in "Exception" as Exception could deal with any exception that could ever
		 * be generated, don't use EXCEPTION IN A MULTI CATCH BLOCK
		 */
		catch(DateTimeParseException|IOException|IndexOutOfBoundsException e) {
			System.out.println(e);
			String eClass=e.getClass().getSimpleName();
			switch(eClass) {
			case "NoSuchFileException":
				System.out.println("there is no file of this name");
				break;
			case "DateTimeParseException":
				System.out.println("invalid date entered");
				break;
			case "ArrayIndexOutOfBoundsException":
				System.out.println("you are attempting to access a item in our array that does not exist");
				break;
			default:
				System.out.println("dunno what the exception is");
			}
			/*
			 * unlike in try catch block, you CANNOT redefine the exception that is caught in a 
			 * multi catch block
			 */
			//e=new IOException();
			//e=new Exception();
		}
	}
	
	

}
