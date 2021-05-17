package com.android;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class Examples {
	/**
	 * printStream and printWriter are high level classes that write formatted representations of objects
	 * to a file i.e clear text of a Animal object would be 
	 * Animal name="andy"
	 * age=45
	 * weight=45.6
	 * printStream works on outputStreams and writes data as bytes
	 * printwriter works on writer objects and writes data as characters
	 */
	static void ex1() {
		System.out.println("print");
		/*
		 * print is the most basic method of a printWriter object and it basically writes to 
		 * a file
		 */
		try(PrintWriter out=new PrintWriter("rubbish.txt");
				PrintWriter out2=new PrintWriter("rubbish.txt")){//try with resources
			out.print(5);//will write 5 to the file
			//writes can only take strings or chars, it will try to take an int, but does know what it is
			out.write(5);//this will not know what this is, so will print a ?
			/*
			 * a printwriter object can only takes strings or characters, so if you want to use the
			 * write() method, this can only takes a string or a character, if you attempt to use a int with
			 * with a write, it will not recognise the number
			 */
			out.write(String.valueOf(5));
			
			Animal andy=new Animal(34,"andy");
			/*
			 * this takes the toString method of the Animal class and whatever the toString method returns
			 * is what will be put in the file
			 */
			out.print(andy);
			out.print(new Animal(12,"angela"));
			
		//	out.write(andy);//this will not compile
			out.write(andy.toString());//this will compile
			andy=null;
			out.write(andy==null?"null":andy.toString());
			/*
			 * ways to insert a new line
			 */
			out.print("\n backslash n puts in a new line");
			out.print("this is not a new line");
			out.println();//this will also put in a new line in our file rubbish.txt
			out.print("we are now on a new line");
			
			System.out.println("Format");
			out.println("\nwill write this text to rubbish.txt");
			out.print(Math.PI);
			out.println();
			/*
			 * form writes text to a file using a particular format, this takes a string format object and
			 * the object to be formatted. you can use printf to write formatted text to rubbish.txt
			 * or you can use format()
			 */
			out.printf("PI=%f%n",Math.PI);
			out.printf("PI=%.2f%n", Math.PI);
			out.format("PI=%.2f%n", Math.PI);
			/*
			 * these two commands print the formatted text to the screen rather than save them to a 
			 * file
			 */
			System.out.printf("PI=%f%n",Math.PI);
			System.out.format("PI=%.2f%n", Math.PI);
			out.println();//new line in our file "rubbish.txt"
			//this will put in the year to "rubbish.txt"
			out.format("%tY", LocalDate.now());
			//will print off the current year
			System.out.format("%tY", LocalDate.now());
			
			out.format("%tA", LocalDate.now().plusDays(4));//this will write the name of day four days from now
			System.out.printf("%tA", LocalDate.now().plusDays(4));
			//	PrintWriter out2=new PrintWriter("rubbish.txt");
		//	out2.print("some text");
	//		out2.flush();
			
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static void ex2() {
		Animal animal=new Animal(23,"cow");
		File source=new File("Animals.txt");
		try(PrintWriter out = new PrintWriter(
				new BufferedWriter(new FileWriter(source))
				))
		{
			out.print("hello there ");
				out.print("Today's weather is: ");
				out.println("Sunny");
				out.print("Today's temperature at the zoo is: ");
				out.print(1/3.0);
				out.println('C');
				out.format("It has rained 10.12 inches this year");
				out.println();
				out.printf("It may rain 21.2 more inches this year");
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}

}
