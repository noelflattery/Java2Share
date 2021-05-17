package com.android;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Examples {
	static void ex1() {
		System.out.println("old way of interacting with users on the command line prompt");
		System.out.println("enter your text ");
		int num=0;
		/*
		 * System.in is user input on the console or command prompt
		 */
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		try {
			String userInput=reader.readLine();
			System.out.println("you entered the string "+userInput);
			/*
			 * this method will only produce strings or characters
			 * this will not produce numbers for instance
			 */
			System.out.println("enter a number");
			String strNum=reader.readLine();
			System.out.println("this is a string represtnation of a number "+strNum);
		//	System.out.println(strNum++);
			System.out.println("enter a second number");
			num=Integer.parseInt(reader.readLine());
			System.out.println("now this is a number "+(++num));
					
		}
		catch(Exception e) {
			System.out.println(e);
		//	while(e.getClass().getSimpleName().equalsIgnoreCase("NumberFormatException")) {
			/*
			 * if in this loop a number is entered then the exception type e will be given a value of null
			 * and if the value of e is null the loop will exit and num will have been given a value
			 */
			while(e!=null) {
				try {
					System.out.println("enter a number please this time");
					num=Integer.parseInt(reader.readLine());
				//	e=new ArrayIndexOutOfBoundsException();
					/*
					 * this line only executes if a valid number has been entered above
					 */
					e=null;
				}
				/*
				 * the named inner exception CANNOT be the same name as an exception in the outer block
				 */
				catch(Exception n){
					System.out.println("this is not a number , please enter a number");
					
					//e=n;
				}
			}
			
			
				
	//		System.out.println(e.getClass().getSimpleName().equalsIgnoreCase("NumberFormatException"));
		//	while(e.getClass().getSimpleName().eq)
			
		}
		System.out.println("num is "+num);
		
	}
	/**
	 * the console class will not really work in eclipse, so you need to run these examples from the command
	 * line prompt
	 * copy the java files to another folder in a more conveninet location (i.e C:\JavaCode) in my case
	 * you will need to edit both files, and remove "package.com.android", as if you don't the compiler and 
	 * the java program will be looking for the following folder C:\JavaCode\com\android.
	 * before we run Javac and java we have to set the path file (basically telling our command line prompt where
	 * to the the Javac.exe program and the Java.exe program, in my case this is the in following folder
	 * C:\Program Files\Java\jdk1.8.0_231\bin
	 * you can set the permanent path name by the method described in the following web page
	 * https://javatutorial.net/set-java-home-windows-10
		or by opening your command line prompt as a administrator and CD (change directory) to the folder
		where your Main.java and Examples.java file are located and run the following command
		path=C:\Program Files\Java\jdk1.8.0_231\bin
		
	 * run the Javac command to create the class files (run this command first on the Examples file, as Main
	 * calls the Examples file and main will not compile until the Examples file is first compiled. you must run
	 * the javac command on all java files
	 * the syntax for this is "javac Examples.java" and "javac Main.java"
	 * you only have to run the Java program on the Main class file
	 * then run "java Main" and your program will run.
	 * if you get "javac not recognised", go to this following youtube video
	 * https://www.youtube.com/watch?v=bVjsFFkPgbo
	 * which will explain how to fix this error
	 * also when compiling these two files in a different folder, make sure to remove the 
	 * "package com.android"
	 * as if you don't the compiler will be looking for these two packages, or windows will interpret them
	 * as folder and will not compile
	 * ALTERNATIVELY
	 * open a commanod line prompt as a Administrator, cd to the build path folder which
	 * for here it's
	 * C:\Users\noelf\OneDrive\JavaProgrammer2019-20\WorkSpace2\F8.4InteractingWithUsers\src
	 * then go
	 * javac com\android\Examples.java
	 * javac comzandroid\Main.java
	 * then 
	 * java com.android.Main
	 * and the console class will run
	 */
//	Console myConsole;
	static void ex2() {
		/*
		 * the console class can only be a singleton object, which means you can only have one created
		 * 	/*
		 * the new way uses the console class
		 * java.io.console
		 * this is a class that contains multiple  convenience methods
		 * console is a singleton, so only one version of this is
		 * available
		 * the JVM automatically created this for you by calling
		 * his method will return null in environments where text interactions are not
		 * supported
		 * system.console() method
		 */
		 
		try (PrintWriter out=new PrintWriter("Backup.txt");){
			Console console=System.console();
			System.out.println("some text");
			/*
			 * this is just a good habit to check if the console is NOT null
			 */
			if(console!=null) {
				System.out.println("enter some text");
				String userInput=console.readLine();
				console.writer().println("your entered the following text "+userInput);
				console.writer().format("PI=%.2f%n", Math.PI);
			//	out.println(userInput);
		}
			else
				System.out.println("console is null");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
			
	}
	
	static void ex3() {
		System.out.println("our second program using Console");
		Console console=System.console();//creating our object to get input from command line prompt
		if(console==null) {
			throw new RuntimeException("console not available");
		}
		else {
			console.writer().println("Welcome to the Zoo");
			console.writer().println();//blank
			console.format("PI=%.2f%n", Math.PI);
			console.format("this format just prints off text to the screen");
			console.printf("PI=%.2f%n", Math.PI);
			console.printf("this just prints off normal text");
			console.writer().print("hello there ");
			//there is not console.print()
			//there is not console.prinln()
		}
		
	}
	
	static void ex4() {
		System.out.println("ReadLine");
		/*
		 * before you use readLine() or readPassword() you should call the flush() method
		 * which forces any buffered output to be written immediately
		 */
		//creates console for reading from the command line prompt
		Console console=System.console();
		if(console!=null) {
			console.writer().println("what sort of mood are you in today");
			/*
			 * readline has an overloaded method that takes a string that will appear directly before where
			 * you type your text
			 */
			console.flush();
			String moodAnswer=console.readLine("enter you mood here :");
	//		console.flush();
			/*
			 * readLine can take a string argument that will appear before the text you
			 * are to enter. if no text here, then there is no text before where you are supposed
			 * to enter the text
			 */
		//	console.writer().println("please enter your name");
			/*
			 * the reason we use console, instead of say System.out.print() is for Passwords
			 * so if we have the method readPassword() the password will NOT appear on the screen, if it
			 * was a print or a println, it would appear on the screen.
			 */
		//	System.out.print("please enter your name :");
			String name=console.readLine("please enter your name :");
			console.writer().println("your moode is "+moodAnswer);
			console.format("your name is "+name);
			/*
			 * the reason why we use console, instead of System.out.println is for 
			 * secure password (when you type in the password nothing appears on the devices screen)
			 * synchronisation and threads allows you to queue up the the results so they can appear in 
			 * certain order. if we used system.out.println all the results will appear at once
			 */
			System.out.println("age of person ");
			console.flush();
			/*
			 * this code will not ensure that you can only enter in a number, you would have to put in
			 * other code to esnure that it is a number
			 */
			int age=Integer.parseInt(console.readLine("enter your age :"));
			System.out.println("your age in a years time will be "+(++age));
		}
		else {
			throw new RuntimeException("console not available"); 
		}
		int age=0;
		/*
		 * this allows for text to be processed in specifed chunks of bytes
		 * so it could be, as in this case, at the end of each line of text 
		 * or it could be for every paragraph, for every sentence, for every page, for every chapter
		 * for every whatever grouping you want.
		 */
		BufferedReader reader=new BufferedReader(console.reader());
		try {
			String value=reader.readLine();//will read in every line of text
			age=Integer.valueOf(value);
			console.writer().println();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static void ex5() {
		System.out.println("readPassword");
		/*
		 * wheny you are inputting a password to gain access to some resource, it should NEVER be displayed.
		 * this method will display NOTHING as you are typing in your password
		 */
		Console console=System.console();
		try {
			if(console!=null) {
				/*
				 * the passwords we use will be using hashing algorithms that give a number for
				 * every character in password, so readPassowrd, operatates on an array of characters
				 * 1231
				 * the number 1 would produce the number 345678
				 * the number 2 would produce the number 999999
				 * the number 3 would produce the number 888888
				 * the number 1 would produce the number 777777
				 */
				console.flush();
				char[]password=console.readPassword("Enter your Password");
				System.out.println("view password");
				//you can still view this password as readPassword only stops anyone from seeing what you type
				//as you enter your password
				System.out.println(password[0]);//prints off first element of password
				Arrays.asList(password).stream().forEach(System.out::println);
				console.flush();
				/*
				 * when you are creating any of profile for any app or website, you have to enter in your
				 * new password twice, this is to ensure that you have the password you want
				 */
				char[]verify=console.readPassword("enter your password again :");
				/*
				 * if both arrays contain the same characters, then the passwords match
				 */
				boolean match=Arrays.equals(password, verify);
				/*
				 * both verify and password, contains your password, so as soon as they are no longer needed we
				 * must overwrite the values contained within each of these arrays
				 */
				for(int i=0;i<password.length;i++)
					password[i]='X';
				/*
				 * the fill method will overwrite each character in teh verify array with teh character 'X'
				 */
				Arrays.fill(verify, 'X');
				
			//	Arrays.asList(verify).stream().map((c)->'x').close();	
				Arrays.asList(password).stream().forEach(System.out::println);
				console.format("your password was a "+(match?"correct":"incorrect")+" match");
				
			}
			else {
				throw new RuntimeException("console not available ");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}


}
