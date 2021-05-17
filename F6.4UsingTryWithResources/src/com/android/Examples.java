package com.android;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Examples {
	
	static void ex1() {
		Path path1=Paths.get("src/test.txt");
		Path path2=Paths.get("src/test2.txt");
		//shows the folder in which files are contained
		System.out.println(path1.getParent());
		BufferedReader in=null;
		//Files.newBufferedReader(path1);
		try {
			/*
			 * this is now an object that can read from the file in the path
			 * "src/test.txt"
			 * not exception is generated so the catch will not run.
			 * however this bufferedreader object is live connection to an external file, which
			 * is a security risk
			 * so you should always close a connection after you finish reading to the file
			 */
			in=Files.newBufferedReader(path1);
		//	in.close();
		}
		catch(IOException e) {
			System.out.println("IOException is generated ");
			System.out.println("the specific exception is "+e);
		}
		finally {
			System.out.println("closing our BufferedReaderResource");
			/*
			 * you usually close resources in a finally block
			 * in.close is file operation, so it needs to be put in a try catch block
			 */
			try {
				in.close();
			}
			catch(IOException e) {
				System.out.println(e);
			}
			System.out.println("now closed");
			
		}
		
	}
	
	static void ex2() {
		Path path1=Paths.get("src/test.txt");
		Path path2=Paths.get("src/test2.txt");
		/*
		 * try with resources has a (), in here we put the resources we want to be automatically
		 * closed. here we put in a BufferedReader which will read from the file 
		 * "src/test.txt"
		 */
		//this is the object we will use to read from test.txt
		//each of the resources HAS TO be sepearted by a semi colon ;
		try//each of the resou		
		{
			System.out.println("try with resources runs");
			//this is the object we will use to write to test2.txt
			BufferedReader in=Files.newBufferedReader(path1);
			BufferedWriter out=Files.newBufferedWriter(path2);
			/*
			
			 * the file will not be written too UNTIL out.close()
			 */
			/*
			 * in.readLine() produces a string that will be the first line in the
			 * test.txt file. also if we use this command a second time, we are going to the 
			 * second line in the file. if there is no second line in the file and we attempt
			 * to use in.readLine() again we will get a NullPointerException
			 */
			String str=in.readLine();
			System.out.println("string is "+str);
			/*
			 * .write() takes a string, that will be written to the file test2.txt. this 
			 * will overwrite anything that may already existi in this file. so it formats the file
			 * first and then writes.
			 * writing the string hello there nice to meet you
			 */
			out.write(str);
			in.close();
			/*
			 * the string "hello there nice to meet you" is not written to the file until it gets
			 * to this point. if you had no out.close() the text would NOT be written to the file
			 */
			out.close();
		}
		catch(IOException e) {
			System.out.println("IOException generated");
		}
		System.out.println("Bufferedreader is now closed");
		
		try(BufferedReader in=Files.newBufferedReader(path1);
				BufferedWriter out=Files.newBufferedWriter(path2))//each of the resou		
		{
		System.out.println("try with resources runs");
		//this is the object we will use to write to test2.txt
		
		;/*
		 * the file will not be written too UNTIL out.close()
		 */
		out.write(in.readLine());
	//	in.close();
	//	out.close();
	}
	catch(IOException e) {
		System.out.println("IOException generated");
	}
	System.out.println("Bufferedreader is now closed");
}
	
	static void ex3() {
		Path path1=Paths.get("src/test.txt");
		Path path2=Paths.get("src/test2.txt");
		
		try(/*
		this is the object we will use to read from our file test.txt and BufferedReader implements
		the AutoClosable interface, which means it can be used in a Try with Resources.
		only objects whose class implements AutoClosable can be in a try with resources
		*/
				BufferedReader in=Files.newBufferedReader(path1);//text.txt
				BufferedWriter out=Files.newBufferedWriter(path2)
						)//text2.txt		
		{
		System.out.println("try with resources runs");
		;
		/*
		 * this writes to file text2.txt the text that is contained in text.txt
		 */
		out.write(in.readLine());
		System.out.println("our file text2.txt has been written too");

	}
	catch(IOException e) {
		System.out.println("IOException generated");
	}
	System.out.println("Bufferedreader is now closed");
	}//end of ex3


static void ex4() {
	System.out.println("AutoClosable");
	/*
	 * bird class does NOT implement AutoClosable, so cannot be in a try with resources
	 */
	/*try(Bird myBird=new Bird()){
		
	}*/
	/*
	 * pub implements autoclosable so it can be in a try with resources
	 * Pub close method DOES NOT throw an exception so we do not need a catch block or
	 * a finally block. a try with resources is a version of a try that does NOT NEED A catch or 
	 * a finally as long as the try block does not generate a exception
	 * a ordinary try block HAS TO HAVE  a catch or a finally or both
	 */
	try(Pub myPub=new Pub()){
		myPub.pullPints();
		myPub.makeMoney();
	}
	
}

static void ex5()throws Exception{
	/*
	 * in a try with resources the catch and finally block are optional. 
	 * here TurkeyShed implments Autoclosable and the close method has a a "Throws Exception" in
	 * the close method signature, which means we either have to have a catch block catchin this
	 * exception or a have this method ex5 throws exception
	 * the close() method is called automatically in try with resources, and this method 
	 * "throws Exception"
	 */
	try(TurkeyShed myTurkey=new TurkeyShed()){
		//the close method "throws Exception"
		System.out.println("open turkeyShed");
	}
}

static void ex6() {
	try(Shop myShop=new Shop()){
		System.out.println("shop open");
	}
	/*
	 * the close() method in teh shop class throws a IllegalArgumentException, which is a 
	 * runtime exception. if no exception was generated in the close method, then you would not
	 * need the optional catch block. 
	 */
	catch(Exception e) {
		System.out.println(e);
		System.out.println("message is "+e.getMessage());
		//this prints the map of the exception, where it first occurs, what method is called
		//that causes the exception to happen, etc
	//	e.printStackTrace();
	}
	System.out.println("our code continues");
}
/*
 * if the object in the try with resources, generates an exception then it can be dealt with
 * in a catch block as we did in ex6
 *  or the method that is dealing with it can throws it to another method as we did in ex5
 */

static void ex7() {
	
	System.out.println("surpressed exceptions ");
	/*
	 * Shop implements AutoClosable, and the close method of the Shop class throw new 
	 * IllegalStateException, so the catch block will deal with the IllegalStateException
	 */
	try(Shop myShop=new Shop()){
		System.out.println("open my shop");
		//close() method the Shop class will be called automatically here
		//generates IllegalStateException
	}
	catch(Exception e) {//catchs IllegalStateException
		//prints out exception and message "shop will not close"
		System.out.println(e);
	}
	
	System.out.println("not catching surpressed exception");
	/*
	 * myShop.close() generates IllegalStateException
	 * however inside the try block there is a ArrayIndexOutOfBoundsException generated, any exception generated
	 * inside a try block will be considered the PRIMARY exception and will be the exception caught by the 
	 * catch block. the IllegalStateException is NOT caught or dealt with by the catch block
	 */
	try(Shop myShop=new Shop()){
		System.out.println("opening my second shop");
		int[]nums= {34,56};
		System.out.println(nums[4]);
	//	myShop.close();
	}
	catch(Exception e) {//this will only catch the ArrayIndexOutOfBoundsException
		System.out.println(e);
	}
	System.out.println("not catching checked surpressed exceptions");
	try(Cafe myCafe=new Cafe()){
		System.out.println("opening my cafe");
		int[]nums= {34,56};
		System.out.println(nums[4]);
	}
	catch(Exception e) {
		System.out.println(e);
	}
	
	System.out.println("getting information about surpressed exceptions");
	try(Cafe myCafe=new Cafe()//this generates a checked IOException
			){
		System.out.println("opening my cafe for second time");
		int[]nums= {34,56};
		System.out.println(nums[4]);//this is the primary non surpressed exception 
	}
	catch(Exception e) {
		System.out.println("this catches the primary non surpressed exception "+e);
		/*
		 * getSurppressed returns an array of throwables, which are all the supressed exceptions generated by
		 * the try with resources, or any exceptions that were generated in the try() braces
		 * this is getting the amount of supressed exceptions that were thrown by try(Cafe myCafe=new Cafe)
		 * there was only 1
		 * e.getSuppressed() is an array of our supressed exceptions
		 */
		System.out.println(e.getSuppressed().length);//gets the amount of surpressed exceptions
		//there is only 1, so we get the first throwable in this array
		System.out.println(e.getSuppressed()[0]);
		for(Throwable t:e.getSuppressed()) {
			System.out.println("exception is "+t);
			System.out.println("message is "+t.getMessage());
			e.printStackTrace();
		}
	}
	System.out.println("our code continues");
	
}

static void ex8() {
	System.out.println("multiple repressed exceptions");
	/*
	 * the close methods for both myClub and myBar, will run BEFORE any optional catch or finally block
	 */
	try(Club myClub=new Club();//this is called second
			Bar myBar=new Bar()
					/*
					 * the close methods are called in reverse order
					 * names the Bar.close() first
					 * and then the Club.close()method
					 */
					)//this closed method is called first
	{
		System.out.println("inside try block");
		int[]nums= {34,56};
		System.out.println(nums[4]);//this generates ArrayIndexOutOfBoundsException
		//close method for bar then for club runs here
		
	}//end of try block
	
/*	catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("***********arrayIndex is caught "+e);
	}*/
	catch(Exception e) {
		//this will only see the ArrayIndexOutOfBoundsException that was generated in try block
		System.out.println("primary exception is "+e);
		//e.getSupressed() is an array of throwable objects, that are our two supressed exceptions
		System.out.println("amount of repressed exceptions is "+e.getSuppressed().length);
		for(Throwable t:e.getSuppressed()) {
			System.out.println("supressed exception is "+t);
		}
		System.out.println("using streams to print out all supressed exceptions");
		Arrays.asList(e.getSuppressed()).stream().forEach(System.out::println);
		System.out.println("end of catch");
	}
	finally {
		System.out.println("finally run me");
	}
}

}//end of class
	
	
	



