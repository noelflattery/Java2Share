package com.android;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Examples {
	static void ex1() {
		System.out.println("FileReader and FileWriter classes");
		/*
		 * just like they're streams equalivent they have a read() and write() methods
		 * however these classe work on Characters as opposed to byte values
		 * they also have lower level classes deal with individual characters and higher 
		 * level classes that deal with groups of characters (words, sentences, etc)
		 */
		File myFile=new File("input.txt");
		File myFile2=new File("output.txt");
		/*
		 * we will use these to store the words and strings from our files
		 */
		List<String>myStrings=new ArrayList<String>();
		List<String>words=new ArrayList<String>();
		try {
			if(!myFile.exists())
				myFile.createNewFile();
			if(!myFile2.exists())
				myFile2.createNewFile();
			/*
			 * if we were to use these objects, we would have a write to the hard drive for every 
			 * character in the file, as opposed to every byte in the file. So 900 characters in a file
			 * to be written, we have 900 writes
			 */
			Reader reader=new FileReader(myFile);//reader of individual characters for file "input.txt"
			Writer writer=new FileWriter(myFile2);//writer of individual characters for file "output.txt"
			
			System.out.println("BufferedReader");
			//bufferedReader can take a low level or high level reader
			BufferedReader buffRead=new BufferedReader(reader);
			/*
			 * readLIne returns null when it gets to the end of the file
			 * readline reads in teh full line and goes to the next line
			 */
		//	System.out.println(buffRead.readLine());//little miss muffet
		//	System.out.println(buffRead.readLine());//sat on a tuffet
			
			
			String s;
			while((s=buffRead.readLine())!=null)
				myStrings.add(s);//each line will be a new entry in this list
			//this will print off our six strings
			System.out.println(myStrings);
			buffRead.close();
			/*
			 * this is what we will use to write to our file "output.txt"
			 * this will write ONE line at a time
			 */
			BufferedWriter buffWrite=new BufferedWriter(writer);
			buffWrite.write("hello there nice to meet you");
			buffWrite.newLine();
			/*
			 * we put in flush here as we wish to write to the file straight away and not use
			 * close() as we are using the 
			 */
		//	buffWrite.flush();
			for(String myS:myStrings) {
				//this will write all the contents of the myStrings list to the file "output.txt"
				buffWrite.write(myS);
				//this will insert a new line after each string
				buffWrite.newLine();
			}
		//	buffWrite.flush();
			buffWrite.close();
			/*
			reader=new FileReader(myFile);//reader of individual characters for file "input.txt"
			writer=new FileWriter(myFile2);//writer of individual characters for file "output.txt"
			int charInt;
			while((charInt=reader.read())!=-1)
				writer.write(charInt);*/	
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static void ex2() {
		File myFile=new File("input.txt");
		File myFile2=new File("output.txt");
		//this list holds all the words of our file "input.txt"
		List<String>words=new ArrayList<String>();
		try {
			Scanner sc=new Scanner(new FileInputStream(myFile));
			/*
			 * the hasNext() of the scanner class returns true if there is a next value, false
			 * if no next value, hasNext applies to WORDS
			 */
			while(sc.hasNext()) {
				/*
				 * a word is considered to be a collection of characters with no spaces
				 * i.e
				 * muffet, is one word
				 * whereas muffet , is considered to be two words "muffet" and ","
				 */
				words.add(sc.next());
			}
			System.out.println("there are "+words.size()+" words in this file");
			for(String s:words)
				System.out.println(s);
			/*
			 * this is a new BufferedWriter if there is any text in the file it is writing too
			 * it will be overwritten. however if you write more text to the file using the same
			 * bufferedWriter, it will append to the end of the file
			 */
			BufferedWriter buffWrite=new BufferedWriter(new FileWriter(myFile2));
			//this will delete all text from "output.txt" and write "more text" to the file
			buffWrite.write("more text");
		//	buffWrite.flush();
			//this will be appended to the end of the file, after "more text"
			//so we end up with "more texteven more text"
			buffWrite.write("even more text");
			buffWrite.flush();
			/*
			 * this will NOT delete any text in "output.txt" but will append to the end of the file
			 * this constructor for a fileWriter object takes two arguements, a file object and 
			 * a boolean, true if we want to keep the text and append to the end of the file, false
			 * if we wish to delete all existing text with our new text
			 */
			BufferedWriter buffWrite2=new BufferedWriter(new FileWriter(myFile2,true));
			buffWrite2.newLine();
			buffWrite2.write("this text appears after the other text");
			buffWrite2.newLine();
			buffWrite2.write("this appears at the very end of the file");
			buffWrite2.flush();
			
				
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	static void ex3() {
		try {
			InputStream in=new FileInputStream("input2.txt");
			OutputStream out=new FileOutputStream("output2.txt");
			
			int b;
			while((b=in.read())!=-1) {//will write jack and jill to "output2.txt"
				out.write(b);
			}
			out.flush();
			/*
			 * if you are using the same output (outputStreams and writers) any new text will be 
			 * appended to the end of file
			 * here we get "jack and jill" followed by "X"
			 */
			out.write('X');//this will be appended to the end of the file
			out.flush();
			/*
			 * if we then use a different output object, the existing text will be overwritten with the new text
			 * this is a new FileOutputStream object so this will overrwrite the existing text
			 */
			OutputStream out2=new FileOutputStream("output2.txt");
			out2.write('A');
			//this will append to the end of the file
			/*
			 * if we use the constructor of the output that takes a file (can be file object or string representing
			 * the path) and a boolean, we can set this new output object to append to the end of the file by
			 * passing in the boolean "true", false it will not be appended and will delete all the text
			 */
			OutputStream out3=new FileOutputStream("output2.txt",true);
			out3.write('B');
			
		}
		catch(Exception e) {
			
		}
	}
	
	static void ex4() {
		try {
			Reader reader=new FileReader("input2.txt");
			Writer writer=new FileWriter("output2.txt");
			
			writer.write("hello there");
			writer.flush();
			writer.write(" nice to meet you");
			writer.flush();
			//writer.close();
			
			Writer writer2=new FileWriter("output2.txt",true);
			writer2.write("brand new text");
			writer2.flush();
			
		}
		catch(Exception e) {
			System.out.println("exception is "+e);
		}
		
	}

}
