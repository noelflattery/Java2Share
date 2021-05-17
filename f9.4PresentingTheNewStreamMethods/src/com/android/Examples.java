package com.android;

import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.file.attribute.BasicFileAttributes;

public class Examples {
	
	static void ex1() {
		System.out.println("walking a directory");
		/*
		 * Files.walk(path) method returns a stream of paths (Stream<Path> that allows you to WALK (search) the 
		 * directory ina  DEPTH FIRST LAZY manner (lazy means that the set of elements is built while the 
		 * directory is being walked i.e unilt a specific directory is reach it's child elements are no loaded into 
		 * the stream of Paths
		 */
		Path path=Paths.get("C:/Original");
		Path jPath=Paths.get("src/com/android");
		System.out.println(Files.exists(path));
		System.out.println(Files.exists(jPath));
		System.out.println("is this a directory "+Files.exists(path));
		try {
			System.out.println("*******all files and directories");
			/*
			 * Files.walk(path) returns a stream of type Path
			 */
			Stream<Path>pStream=Files.walk(path);
			/*
			 * this will print our all of the files and directories contained in teh 
			 * C:/Original
			 * including C:/Orignal
			 */
			pStream.forEach(System.out::println);
			
			Set<String>setPaths=Files.
									walk(path).//creates a stream of Paths contained in C:/Original, inclucing c:/Original folder
									map(p->p.toString()).//converts each path to a string, ie."C:\Original\AnewFile.txt"
									collect(Collectors.toSet());//saves them to a Set of Strings
			/*
			 * we do not want to count c:/Original so we subtract 1 to get the amount of files and directories inside
			 * C:/Original but not included C:/Oringal folder
			 */
			System.out.println("amount of objects in C:/Original is "+(setPaths.size()-1));
			System.out.println("**************************************");
			
			System.out.println("using filter() with our stream of paths");
			System.out.println("all directories in C:/Original*******");
			Files.
				walk(path).//creates a stream of paths
				filter(p->Files.isDirectory(p)).//filter takes a predicate, returns true if the path is a Directory
				forEach(System.out::println);//print out the address of each directory
			System.out.println("all Files in C:/Original*********");
			Files.walk(path).
			/*
			 * we have to say NOT (!) as there are three different types of general file
			 * symbolic linked file
			 * regular file and
			 * and executable
			 * so this will get ALL types of file
			 */	
			filter(p->!Files.isDirectory(p)).
			forEach(System.out::println);
			System.out.println("***********All text files in alphabetical order");
			Files.walk(path).
			/*
			 * takes each path and converts to a string and only pic those strings that end with the file extension
			 * ".txt"
			 * i.e will pick the path C:\Original\AnewFile.txt
			 * but not the path C:\Original\eclipse2.jpg or this C:\Original\country
			 */
				filter(p->p.toString().endsWith(".txt")).//you end up with a stream of strings
				sorted().//string class implements comparable interface so you can sort them
				forEach(System.out::println);//prints off the sorted stream of strings
			System.out.println("all java files in current working directory****");
			/*
			 * this operates the same way as the previous example, but this time we are searching for java files
			 * not text files
			 */
			Files.walk(jPath).
				filter(p->p.toString().
						endsWith(".java")).
				sorted().
				forEach(System.out::println);
			/*
			 * we want to find the other files in the folder src/com/android but NOT the java files or any other directories
			 * we want to find the files myFile.txt and in my case the file backup280000000008Backup.data
			 * you may have different files in your system
			 * 
			 */
			System.out.println("All non java files in the current directory src/com/android");
			/*
			 * the int value 1 here is a overloaded walk method which takes a path and a int which is the maximum directory
			 * depth we wish to explore. When we set it to 1, this will only search inside the folder src/com/android
			 * it will NOT search any of the sub directories of src/com/android
			 * it will not search com.android.MyFolder or com.android.TestFolder
			 * if i had set the maximum directory depth to 2, then it would have serached the two sub folders
			 * by default the method sets the maximum depth to Integer.MAX_VALUE directories deep, which would be
			 * 2_147_483_647 deep (highly unlikely any application would every exceeed this
			 * and if it does, well you would really want to consider a redesign of your application)
			 */
			Files.walk(jPath,1).//will only search com.android and not any subfolders
				filter(
					p->{
						/*
						 * this will return false if the file extension is .java OR if the path is a
						 * directory. so this will only return true if the path is only a non java file 
						 * you could also do this over two calls to the filter() method instead of using
						 * a OR clause (||)
						 */
						if(p.toString().endsWith(".java")||Files.isDirectory(p))
							return false;
						else
							return true;
					}
					).
				forEach(System.out::println);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		path=Paths.get("C:/Original");
		System.out.println(Files.exists(path));
		System.out.println("Avoiding Cicular paths");
		/*
		 * the walk() does NOT traverse symbolic links by default
		 * can lead to directories that have nothing really to do with the current directory being searched
		 * worse it could lead to a CIRCULAR PATH, as an example
		 * we have a folder that contains a symbolic link 
		 * C:/MyFolder/FolderA/MyLink.txt
		 * MyLink is linked to C:/MyFolder, which works down to MyLink.txt which links back again to the root folder
		 * and does this infinitely
		 * if you want to override this default behaviour then
		 * use FOLLOW_lINKS
		 * Files.walk(path,LinkOption.NOFOLLOW_LINKS)//this is the default behaviour in the walk method
		 * it follows the path down all the subdirectories, but will NOT FOLLOW	any shortcuts(symbolic linked files) it finds
		 * Files.walk(path,LinkOption.FOLLOW_LINKS)//this will follow the links
		 */
		/*
		 * create two files, one a file in a different directory called 
		 * "C:/brandNewDir/BrandNewDir.txt"
		 * and another a symbolic link with the name C:/Original/BrandNewDirLink.txt
		 * refer to section 9.2InteractingWithPathAndFilesB on how to create a symbolic link
		 * 
		 */
		Path link=Paths.get("C:/Original/BrandNewDirLink.txt");
		Path file=Paths.get("C:/brandNewDir/BrandNewDir.txt");
		try {
			System.out.println("is one file linked to the other "+Files.isSameFile(link, file));
			System.out.println("following links");
			/*
			 * as symoblic links are not traversed by default with walk the file "C:/brandNewDir/BrandNewDir.txt"
			 * which is linked to "C:/Original/BrandNewDirLink.txt" will not appear in the stream of paths
			 */
			Files.walk(path).sorted().forEach(System.out::println);
			System.out.println("Follow_Links options *******");
			/*
			 * this does not work correctly but in principle this should follow all symbolic links
			 */
			Files.walk(path,1, FileVisitOption.FOLLOW_LINKS).sorted().forEach(System.out::println);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	static void ex2() {
		System.out.println("using find() to search a directory");
		/*
		 * path is the path of the directory you wish to search
		 * maxdepth is the depth of the serach of the directory (i.e 1 will only search c:/original and none of the subfolders
		 * BiPredicate takes in two objects and returns true or false
		 */
		System.out.println("Files.find(path, maxDepth, Bipredicate)");
		/*
		 * we will try and get all files and folders that were created more than three days ago
		 * this is the time exactly 72 hours ago from running this code- 72 hours is three days
		 */
		LocalDateTime dateTime=LocalDateTime.now().minusDays(3);
		System.out.println("3 days ago is exactly "+dateTime);
		
		long seconds=dateTime.atZone(ZoneOffset.systemDefault()).toEpochSecond();
		//this will be approx 1.58 billion seconds 
		System.out.println("amount of seconds since 01 jan 1970 to three days ago is "+seconds);
		
		Path path=Paths.get("C:/Original");
		try {
		//	Stream<Path>stream=
				/*
				 * seraching in our path, to a depth of 5
				 */
				Files.find(path, 5, 
						/*
						 * bi predicate that is a path and basicFileAtributes (which is all the
						 * file atributes) 
						 * this will get all the text files that were created less than three days ago
						 * in  this folder
						 * you do not have to put in Path p and BasicFileAttributes a, we put them in there
						 * to make it more clear what is actually happening.
						 * we can use all the methods of Path p to pick a file based on what these methods return
						 * similary BasicFileAttributes returns all the metadata about the files in this
						 * directory, so this allows us to search for files using a very broad set of 
						 * search criteria
						 * to try and accomplish this without streams is a lot more complicated and 
						 * convuluted
						 */
						(Path p,BasicFileAttributes a)->{
							//get text files only
					//	return p.toString().endsWith(".txt")
							return !Files.isDirectory(p)//if its not a directory its a file, return true if a file AND
									&&
									//files created in last three days with a C:/Original root folder
									/*
									 * this converts the creationTime of the files, to the amount of seconds since
									 * 1st janauary 1970, if it greater than the time 3 days ago, then the file was 
									 * created in the last three days
									 */
									a.creationTime().to(TimeUnit.SECONDS)>seconds;
						}
					).forEach(System.out::println);;
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	static void ex3() {
		System.out.println("Files.list");
		System.out.println("listing directory contents");
		Path path=Paths.get("C:/Original/FolderA");
		System.out.println(Files.exists(path));
		try {
			/*
			 * this will only list the files and folders of "C:/Original/FolderA" it will NOT list any the contents of any
			 * sub folders or files contained within a sub folders. it only searches at level 1. this is the equalivent of
			 * Files.walk(path,1)
			 */
			Files.list(path).forEach(System.out::println);
			System.out.println("using list to only show files");
			Files.list(path).
			filter(p->!Files.isDirectory(p)).
			forEach(System.out::println);
			System.out.println("using walk");
			/*
			 * if you just use walk, without a depth, it will pick all files, folders and sub folders 
			 */
			Files.walk(path).forEach(System.out::println);
			System.out.println("using walk to display only files of C:/Original/FolderA folder");
			/*
			 * if you use walk with a max depth level of 1, you get the same results as if you use list
			 */
			Files.walk(path, 1).filter(p->!Files.isDirectory(p)).forEach(System.out::println);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	static void ex4() {
		System.out.println("printing file contents using NIO.2 and Streams");
		/*
		 * create a file in the working directory with the following format
		 * Male Noel
		 * Female Laura, etc and include a few names of males and females
		 */
		Path path=Paths.get("Names.txt");
		System.out.println(Files.exists(path));
		try {
			System.out.println("lines() method");
			/*
			 * this method reads the lines of a text file in a lazy manner (only reads the lines of text it needs
			 * to memory)
			 * also lines and readAllLines produces a List of Strings
			 */
			System.out.println("print all lines in file");
			Files.lines(path).forEach(System.out::println);
			System.out.println("*******readAllLines() method");
			Files.readAllLines(path).forEach(System.out::println);
			System.out.println("all the females in the list");
			
			Files.lines(path).
			/*
			 * just gets the females in the file and produces the following
			 * Female Mary
			 * Female Sarah
			 * etc
			 */
				filter(s->s.startsWith("Female")).
				/*
				 * we want to remove the word "Female" from each of the strings
				 * the word "Female" goes from index position 0 to 5, index position 6 is blank space
				 * index postion 7 will always be the start of the name of the female
				 * so this will return just the names of the females
				 * Mary
				 * Sarah
				 * etc
				 */
				map(s->s.substring(7)).
				/*
				 * string class implements comparable so this will sort the names in aphabetical order
				 * i.e 
				 * Denise
				 * Laura
				 * etc
				 */
				sorted().
				/*
				 * this will print them all out
				 */
				forEach(System.out::println);
			/*
			 * readAllLines produces a List of String, so we can't use filter() on a list as filter() can only be used on streams
			 * so we have to put in an additional method call, stream() which converts our list to a stream
			 */
			Files.readAllLines(path).
				stream().//only one additional step needed to get all females
				filter(s->s.startsWith("Female")).
				/*
				 * we want to remove the word "Female" from each of the strings
				 * the word "Female" goes from index position 0 to 5, index position 6 is blank space
				 * index postion 7 will always be the start of the name of the female
				 * so this will return just the names of the females
				 * Mary
				 * Sarah
				 * etc
				 */
				map(s->s.substring(7)).
				/*
				 * string class implements comparable so this will sort the names in aphabetical order
				 * i.e 
				 * Denise
				 * Laura
				 * etc
				 */
				sorted().
				/*
				 * this will print them all out
				 */
				forEach(System.out::println);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
