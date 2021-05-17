package com.android;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Examples {
	/*
	 * Some general file examples before we delve into detailed i/o
	 */
	static void ex1() {
		System.out.println("fileWrite");
		/*
		 * this is our file object, which will be the file we will be writing our text too
		 */
		File myFile=new File("test.txt");
		System.out.println(myFile.exists());//return false as does exist
	

			/*
			 * if you want to read or write to a file, you have to put it in a try/catch block
			 */
			try {
				System.out.println("do some stuff");
				/*
				 * this statement creates the file in the current default director
				 * this will return true if the file is created
				 * the frist time this code runs it will return true, but every subsequent time we run this code
				 * it will return false, as we can't create the same new file more than once
				 */
				System.out.println(myFile.createNewFile());
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("wirte 10 things to our file");
			try {
				/*
				 * FileWriter has a constructor that takes a File object or a string that is a path to a 
				 * file
				 * this object allows us to write to our file "test.txt"
				 */
			//	FileWriter fs=new FileWriter(myFile);
				FileWriter fs=new FileWriter("test.txt");//relative path, which is a string
				/*
				 * we will write 10 statements to our file
				 */
				System.out.println("write()");
				for(int i=0;i<10;i++) {
					/*
					 * this will write number is 0, number is 1, etc to "test.txt" and 
					 * also if there is ANY other text in the file, it will be overwritten. so this will
					 * delete any existing text and write in this text
					 * this text is not written to the file until the resource is closed, the resource is the 
					 * fileWriter object
					 * this will throw an IOException is this text is NOT written to the file
					 */
					fs.write("number is "+i+", ");
				}
				System.out.println("append");
				fs.append("this is text at end of file, that will NOT overwrite existing text");
				/*
				 * this closes the fileWriter object and once closed, you can't write any more to "test.tx" using this
				 * fileWriter object
				 */
		//		fs.close();
				/*
				 * this will generate an IOException as this filewriter resource is already closed
				 */
		//		fs.write("some more text");
				/*
				 * you have to close the filewriter object before the file is written too OR you can call
				 * the flush() method which writes immediately to the file without closing the FileWriter resource
				 */
				System.out.println("flush");
				/*
				 * flush() has a high cost and should be only used sparingly
				 * close calls the flush() method
				 */
				fs.flush();
				/*
				 * every writer object also has a constructor that takes a file object and a boolean, if the value
				 * is set to true, then this will append at the end of the file
				 */
				FileWriter fw=new FileWriter(myFile,true);
				fw.write("more text written at end of file");
		//		fw.close();
				/*
				 * this will write to the end of the file
				 */
				fw.flush();
				/*
				 * this will close this writer
				 */
				fw.close();
				/*
				 * this closes our first writer
				 */
				fs.close();
			}
			catch(IOException e) {
				System.out.println(e);
			}	
	}
	
	static void ex2() {
		System.out.println("FileReader");
		File myFile=new File("test.txt");
		
		try {
			/*
			 * when creating a fileReader or a FileWrite object, the creation of the object has to be in a 
			 * try/catch block
			 * this reads in one character at a time
			 */
		//	FileReader fr=new FileReader(myFile);
			FileReader fr=new FileReader("test.txt");
			
			int i;//this is int version of each character in the file, i.e n is 110, u is 117
			/*
			 * read returns an int as long at we are not at the end of the file
			 * as soon as read returns a minus number, we are at the end of the file
			 * every character has a number that can represent that number, if this read is 
			 * returning a minus number, it means this is no longer a character and we are at the end of 
			 * the file
			 * .read() returns the integer that represents a character, if its not a character, it will return 
			 * -1
			 * these are the ASCII numbers for each characters
			 */
			while((i=fr.read())!=-1) {
				/*
				 * as i is the number that represents a character, we have to cast it to be a character to display
				 * it
				 */
				System.out.println((char)i);

				/*
				 * this will print off the number that will represent each character
				 */
				System.out.println(i);		
			}	
			fr.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		char myChar='a';
		char myChar2=110;
		
		System.out.println(myChar+" "+myChar2);
		
		myFile=new File("test.txt");
		try {
			FileReader frB=new FileReader("test.txt");//low level reader, reads individual characters, slow
			/*
			 * each of the higher level classes, for instance BufferedReader takes an object of the super class
			 * of BufferedReader, which is a a File Readers.
			 * BufferedReader reads lines of text, and it takes as an argument in its constructor a FileReader.
			 * buffered means that as the string is read, its stored in a buffer, so as the line is being 
			 * constructed its stored in a buffer and can be retrieved quickly.
			 * the fileReader reads characters and the bufferedREader reads lines, so the bufferedReader constructor
			 * needs a FileReader to read all the characters for it.
			 */
			BufferedReader br=new BufferedReader(frB);//this can't take a file object or a string representing the file path
			System.out.println("this will read the full line of text");
			while((br.read())!=-1) {
				/*
				 * this will read the full line of text, this method is only available to higher level
				 * readers
				 * similarily writeLine() is avaiable only to higher level writers
				 */
			//	System.out.println(br.readLine());
				/*
				 * this will read the ascii key value of each character
				 */
				System.out.println(br.read());
				/*
				 * this will display each character
				 */
				System.out.println((char)(br.read()));
			}
			br.close();//higher level first
			frB.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	static void ex3() {
		System.out.println("reading from one file and writing to another using BufferedReader and BufferedWriter");
		
		File myFile2=new File("test2.txt");
		/*
		 * if the file does not exist, create it
		 */
		try {
			if(!(myFile2.exists())) {
				System.out.println("file created "+myFile2.createNewFile());
			}	
			else
				System.out.println("file already exists");
		}
		catch(Exception e) {
			System.out.println(e+" file not created");
		}
		
		try {
			System.out.println("file we are reading from");
			/*
			 * BufferedReader object constructor takes a FileReader object as an argument
			 */
			BufferedReader inputFile=new BufferedReader(new FileReader("test.txt"));
			
			System.out.println("file we are writing too");
			/*
			 * BufferedWriter object constructor takes a FileWriter object as an arguement
			 */
			BufferedWriter outputFile=new BufferedWriter(new FileWriter(myFile2));
			int ch=0;
			/*
			 * this loop does not really use the bufferedReader or the BufferedWriter as it reading one character
			 * at a time and writing at one character at a time
			 */
			while((ch=inputFile.read())!=-1){
				//this writes each character to the file test2.txt
				outputFile.write(ch);//this will write teh ascii key version of the character to test2.txt
			}
			outputFile.close();
		}
		catch(Exception e) {
			System.out.println("exception is "+e);
		}
		
		
	}
	
	static void ex4() {
		System.out.println("using high level readers, writers and high level input and output streams");
		try {
			/*
			 * groups of characters 
			 * this BufferedReader can only be created with a constrcutor that takes another reader object, 
			 * in this case it's a lower level FileReader object (which deals in single characters)
			 */
			BufferedReader br=new BufferedReader(new FileReader("test.txt"));
			/*
			 * when we create a BufferedReader the constructor can also take another higher level Reader
			 */
			BufferedReader br2=new BufferedReader(br);
			
			BufferedReader b3=new BufferedReader(new BufferedReader(new FileReader("test.txt")));
			
			BufferedWriter wr=new BufferedWriter(new FileWriter("test2.txt"));//takes a low level file writer
			
			BufferedWriter wr2=new BufferedWriter(wr);//takes a higher level file writer
			/*
			 * groups of Bytes, anything with Stream in the title
			 * basic streams deal with single bytes, higher level streams deal with groups of bytes
			 * fileInputStream takes in single bytes
			 * and ObjectInputStream takes in groups of bytes (serialized file)
			 */
			ObjectInputStream ios=new ObjectInputStream(new FileInputStream("test2.txt"));//taking a lower level stream reader
			
			ObjectInputStream ios2=new ObjectInputStream(ios);//taking a higher level stream reader
			
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("test.txt"));//takes a lower level stream
			ObjectOutputStream oos2=new ObjectOutputStream(oos);//takes a higher level stream
			
		//	oos=new ObjectOutputStream();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static void ex5() {
		System.out.println("****Mark");
		/*
		 * this is for Input and output streams and not readers or writers
		 * this is for bytes
		 * mark is only for input and outputs that deal in bytes
		 */
		try {
			InputStream is=new FileInputStream("file1.txt");
			//this will be the ASCII key code for the character "A", so we need to cast it
			System.out.println("the first character is "+(char)is.read());//will read "A" and go onto next character
		//	System.out.println((char)is.read());//this will cast the ascii key code to be a character, which will be "B"
		/*
		 * mark marks a pointer in memory location, in this case it will be the pointer after "A", but before "B"
		 * markSupported() returns a boolean, true if this input type supports the mark() method (mark only works
		 * with streams)
		 */
		//	System.out.println(is.markSupported());
			if(is.markSupported()) {//will return true
				is.mark(100);
				System.out.println((char)is.read());//prints B
				System.out.println((char)is.read());//prints C
				is.reset();//Goes back to point after A
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static void ex6() {
		/*
		 * this is for Input and output streams and not readers or writers
		 * this is for bytes
		 * mark is only for input and outputs that deal in bytes
		 */
		try {
			System.out.println("****Mark");
			InputStream is=new FileInputStream("file1.txt");
		//	System.out.println("is this read "+(char)is.read());//prints A
			//this returns false as FileInputStream does NOT support mark
			System.out.println(is.markSupported());
			/*
			 * BufferedInputStream DOES SUPPORT mark()
			 */
			InputStream is2=new BufferedInputStream(is);
			System.out.println("is this read "+(char)is2.read());//prints A
			if(is2.markSupported()) {
				/*
				 * you are marking your stream with a read ahead limit value of up to 100 bytes(effectively that means you can
				 * continue with 100 western european alphabetic characters and can only reset within this )
				 * so if you want to go back to this point you just call reset()
				 */
				is2.mark(100);
				System.out.println((char)is2.read());//prints B
				System.out.println((char)is2.read());//prints C
				is2.reset();//Goes back to point after A
			///	System.out.println("print me");
			}
			System.out.println((char)is2.read());//prints B
			System.out.println((char)is2.read());//prints C
			System.out.println((char)is2.read());//prints D
			is2.close();
			
			System.out.println("skip");
			/*
			 * this skips a certain amount of bytes
			 */
			is=new FileInputStream("file2.txt");//contains the word "TIGER"
			System.out.println((char)is.read());//read in first character the letter "T"
			is.skip(2);//skips I and G
		//	System.out.println((char)is.read());//this prints E
			/*
			 * this reads in the character and assigns this character to the reference myChar
			 * so myChar is now the character "E"
			 */
			char myChar=(char)is.read();//this reads E and goes to next byte, which is the next character
			System.out.println((char)is.read());//this prints "R"
			
				
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	

}
