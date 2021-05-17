package com.android;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Examples {
	/**
	 * FileInputStream and FileOutputStream
	 * the most basic file stream for reading and writing bytes to a file
	 * they contain constructors that take a file object or a string representing a path
	 * Data is accessed usually by sucessive calls to the read() method until value of
	 * -1 is returned, which indicates the end of the fileStream. so the read method
	 * returns an int.
	 * overloaded read() methods takes a pointer to a byte array (which is an array) where
	 * the data is written too, read returns an integer value indicating how many bytes
	 * can be read into the byte array.
	 * FileOutStream is accessed by writing sucessive bytes using write(int) and 
	 * has an overloaded write(byte[]array) method	
	 *  */
	
	static void ex1() {
		System.out.println("FileOutputStream FileInputStream");
		System.out.println("these are low level classes that input and output individual "
				+ " bytes to file");
		/*
		 * this will be the file we will be reading from
		 */
		File myFile=new File("source.txt");
		/*
		 * this is the file we will be writing too
		 */
		File myFile2=new File("destination.txt");
		try {
			if(!myFile.exists())
				myFile.createNewFile();
			else
				System.out.println("source.txt already exists");
			if(!myFile2.exists())
				myFile2.createNewFile();
			else
				System.out.println("destination.txt already exists");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			/*
			 * you can have a FileInputStream reference to a FileInputStream object
			 * or you can have the abstract superclass refernce InputStream to a FileInputStream
			 * object, this is the recommened syntax
			 * this is for reading
			 * we will use this object to read from our file "source.txt"
			 */
			InputStream in=new FileInputStream(myFile);
			/*
			 * this is the object we use to write to the file "destination.txt", this constructors uses a String
			 * that will be the path of the file, this is a relative path
			 * this is for writing
			 */
			OutputStream out=new FileOutputStream("destination.txt");
			//read returns an int, which represents the ASCII key code for a char, it returns -1
			//if not a valid character or end of file
			int b;
			//we will counnt the amount of blanks in our string
			int blankCount=0;
			//keeps total count of our characters
			int counter=0;
			int paraCounter=0;
			/*
			 * reads returns an postive int if its a character and -1 if its NOT a char
			 */
			while((b=in.read())!=-1) {
				System.out.println((char)b);
				/*
				 * when you go to write ASCII key codes into a text file, it is the Character value that will
				 * be written
				 * 54 times our slow permanent memory hard drive is being accessed
				 */
				out.write(b);
				//this counts the total amount of charcters including spaces, return characters, etc
				counter++;
				if((char)b==' ') {
					/*
					 * a paragraph counts as a space, however if you click or return twice this still only
					 * counts as one paragraph space
					 */
					blankCount++;
				}
				if((char)b=='\n')
					/*
					 * amount of paragraphs
					 */
					paraCounter++;
				
			}
			
			System.out.println("there are "+counter+" characters and spaces and return characters");//comes to 56
			System.out.println("there are "+blankCount+" spaces ");
			System.out.println("there are "+paraCounter+" paragraph spaces");
			
			int totalChar=counter-blankCount-paraCounter;
			System.out.println("there are "+totalChar+" characters in our file");
			/*
			 * to ensure and make sure your data IS DEFINATELY WRITTEN TO A FILE
			 * you either call flush() or you close(){close calls flush}
			 */
			out.flush();//this flushes all the data that has been read to the buffer
			in.close();
			out.close();	
		}
		catch(Exception e) {
			System.out.println("exception is "+e);
		}
	}
	
	static void ex2() {
		System.out.println("****BufferedInputStream, BufferedOutputStream");
		//this is the file we read from
		File myFile=new File("source2.txt");
		//this is the file we write too
		File myFile2=new File("destination2.txt");
		
		try {
			//this creates our files if they do not exist
			if(!myFile.exists())
				myFile.createNewFile();
			if(!myFile2.exists())
				myFile2.createNewFile();
			//this is the object we will use to read in all our text in the file "source2.txt"
			InputStream in=new BufferedInputStream(new FileInputStream(myFile));
			//this is the object we will use to write to the file "destination2.txt"
			OutputStream out=new BufferedOutputStream(new FileOutputStream(myFile2));
			/*
			 * we will read and write in blocks of 1 kilobyte
			 * if you file is one megabyte, you will have a 1000 reads as there is a 1000 kilobytes in a 
			 * megabyte. if we were using FileInputStream then we would have a MILLION reads instead of 1000
			 */
			byte[]buffer=new byte[1024];//this is one kilobtye of data
			/*
			 * byte[]buffer=new byte[10240];//10 kilobytes of data
			 * byte[]buffer=new byte[102400];//100 kilobytes of data
			 * byte[]buffer=new byte[1024000];//1 MegaByte of data
			 */
			int lengthRead;
			/*
			 * this will count how many times our while loop executes so will count how many reads and writes to
			 * the Main memory we have to make.
			 */
			int counter=0;
			while((lengthRead=in.read(buffer))>0) {
				//the maximum amount of bytes it can read, has been set to 1024
				System.out.println(lengthRead);//this block of code has x amount of bytes, 499 in this case
				counter++;//this loop will 499 times as opposed to 500,000 times because this file is .5 mb in size
				//you only have 499 writes as opposed to half million writes writes if using FileInputStream
				out.write(buffer,0,lengthRead);
				//this is to make sure the file is written too
				out.flush();
				//out.close();
			}
			System.out.println("amount of times loop executed "+counter);
			out.close();
		}
		catch(Exception e) {
			System.out.println("exception is "+e);
		}
		
	}
	
	static void ex3() {
		System.out.println("try with resources closing input output resources");
		
		File myFile=new File("source2.txt");
		File myFile2=new File("destination2.txt");
	/*	InputStream in;
		OutputStream out;
		*/
		InputStream in2;//=new BufferedInputStream(new FileInputStream(myFile));
		try(
				/*
				 * when you create the resources inside a try with resources parameter list (an ordinary try
				 * block or any try block before java 8, did not have a parameter list). The resources are
				 * automatically closed at the end of the try block
				 */
				InputStream in=new BufferedInputStream(new FileInputStream(myFile));
				OutputStream out=new BufferedOutputStream(new FileOutputStream(myFile2));
			)
		
		{
			/*
			 * the BufferedInputStream object in and the BufferedOutputStream object are only available inside
			 * the try block and are close automatically at the end of the try block, so we dont' have to go
			 */
		//	in.close();
		//	out.close();
		}//end of try block
		catch(Exception e) {
			System.out.println("file not created "+e);
		}
	}

}
