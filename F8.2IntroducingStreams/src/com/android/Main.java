package com.android;
/*
 * these are NOT THE SAME AS DATA STREAMS FROM CHAPTER 4 AND ARE TOTALLY
 * UNRELATED, THEY USE THE NEW STREAM API AND GENERATE DATA 
 * these streams (Stream i/o) are all about input and outputing data from external sources
 * such as a file and/or from a user. Stream i/0 DOES NOT generate data
 * but gets the data from an external source
 * 
 */
public class Main {
	/*
	 * the contents of a a file may be accessed or written via a stream.
	 * so you could have a 1TB file, and your machine has very little memory. yet streams enable
	 * us to deal with this file, as we are only focussing on one small bit of the file at a time,
	 * just like a stream of water flowing through a channel that allows, say five gallons a second.
	 * the channel is not dealing with the entire contents of the stream, just five gallons at particular 
	 * point in time to the closest second.
	 * when a stream beginnis processing a file, it has no ideaa when the beginning, or end of the file is
	 * it just processes one data block at a time. we do have a pointer to our current position in
	 * the stream.
	 * each type of stream segments data into a "wave" or "block" in a particular way. for instance
	 * some stream classes read or write data as individual byte, some read or write individual characters
	 * or strings of characters. Some read or write groups of bytes or characters at at time, specifically
	 * those with the word buffered in their name.
	 * those that deal with bytes are low level, and all higher level streams are built on lower level
	 * streams (high level are more conveinent, i.e handle every word in a txt file).
	 * also writing one byte a time is slow in practise(java application and file system has to communicate
	 * for every bytes, as opposed to doing this for every particular chuck of bytes at a time).
	 * two sets of classes for READING and WRITING
	 * java has three inbulit streams
	 * System.in, System.err,System.out
	 * Difference between Byte Streams and Character Streams
	 * those with "Stream" in the name (FileInputStream)
	 * those with Reader/writer in the name(FileReader,FileWrite)
	 * Stream class used for inputting all type of binary or byte data
	 * read and writer classes are used for inputting only character and String data
	 * stream classes that are Reader/Write are sometimes called convenience classes
	 * most Input classes has a corresponding output class
	 * i.e FileOutputStream FileInputStream
	 * FileReader, FileWriter
	 * Low level stream directly accesses the source of data (i.e array, string, file)FileInputStream
	 * High level stream is a stream built on another stream
	 * what directly interacts with the file is a low level stream
	 *FileReader is the low level stream and BufferedReader is the high level stream
	 * BufferedReader bufferedReader = new BufferedReader(new FileReader("zoo-data.txt")))
	 * you should really wrap a File stream in a Buffered class as it improves performance
	 * four base abstract classes for all stream classes
	 * InputStream
	 * OutputStream
	 * Reader
	 * Writer
	 * the child classes of each always use the parent class suffix in they're names
	 * i.e ObjectInputStream, FileReader
	 * constructors of high level classes often take a reference to the abstract class 
	 * i.e BufferedWrite takes a writer object, which means it can take any sub class of 
	 * writer
	 * can't mix streams with Reader/Writer
	 * i.e new BuffereInputStream(new FileReader("myText.txt");
	 * can't really mix inputs with outputs this way
	 * new FileReader(new FileWriter("myText.txt)
	 * 
	 * A class with the word InputStream or OutputStream in its name is used for reading or
	writing binary data, respectively.
	A class with the word Reader or Writer in its name is used for reading or writing
	character or string data, respectively.
	Most, but not all, input classes have a corresponding output class.
	A low-level stream connects directly with the source of the data.
	A high-level stream is built on top of another stream using wrapping.
	A class with Buffered in its name reads or writes data in groups of bytes or characters
	and often improves performance in sequential file systems.
	When wrapping a class you can only mix and match type thats inherit form the same abstract
	parent stream
	
	InputStream N/A The abstract class all InputStream classes
	inherit from
	OutputStream N/A The abstract class all OutputStream classes
	inherit from
	Reader N/A The abstract class all Reader classes inherit from
	Writer N/A The abstract class all Writer classes inherit from
	FileInputStream Low Reads file data as bytes
	FileOutputStream Low Writes file data as bytes
	FileReader Low level Reads file data as characters
	FileWriter Low level Writes file data as characters
	BufferedReader High level Reads character data from an existing Reader in
	a buffered manner, which improves efficiency
	and performance
	BufferedWriter High level Writes character data to an existing Writer in a
	buffered manner, which improves efficiency and
	performance
	ObjectInputStream High level Deserializes primitive Java data types and graphs
	of Java objects from an existing InputStream
	ObjectOutputStream High level Serializes primitive Java data types and graphs
	of Java objects to an existing OutputStream
	InputStreamReader High level Reads character data from an existing InputStream
	OutputStreamWriter High level Writes character data to an existing
	OutputStream
	PrintStream High level Writes formatted representations of Java
	objects to a binary stream
	PrintWriter High level Writes formatted representations of Java
	objects to a text-based output stream
	 */
	 /**
	  * Common Stream Operations
	  * close()
	  * streams are resources, so they HAVE to be closes. As all the above generate IOException
	  * , prior to java 7, all operations were in try catch/blocks. to close this resource we have
	  * to call the close() method of the File i/o. Previously this was in a catch or finally block.
	  * now however it can be in the Try-with-resource syntax
	  * Flush(), 
	  * this writes data to disk immediately, but it does cause a noticible lag in performance, 
	  * so only use sparingly. The close() method calls the flush() method automatically
	  * Mark() reset()
	  * InputStream and Reader class methods that allow the stream to move back to an earlier position
	  * these allow the stream to move back to an earlier point.
	  * always call the markSupported() method, with returns true onlly if mark() is supported (not all 
	  * java.io input stream classes support it)
	  * 
	  */
	public static void main(String[] args) {
	//	Examples.ex1();
	//	Examples.ex2();
	//	Examples.ex3();
	//	Examples.ex5();
		Examples.ex6();
		

	}

}
