package com.android;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Examples {
	
	static void ex1() {
		System.out.println("displaying our seperator (which can be different for different machines)");
		System.out.println(java.io.File.separator);//my separator is \
		/*
		 * this is a file object, this is NOT the actual file, but the location of a File
		 * this can also be the location of directory that may or may not exist
		 */
		File myFile;
		/*
		 * forward slash "/" is system independent
		 * this is something called an abseloute path, which is the exact address of folder or file
		 * this does not exist
		 */
		myFile=new File("C:/JavaTest/home");
		//exists returns true if a folder or file exists at this location, false if not
		//this will be false
		System.out.println("does this file exist "+myFile.exists());
		//create this folder first, then run this code
		myFile=new File("C:/Test");
		System.out.println("does this folder exist "+myFile.exists());//this folder exists so this will return true
		//create the file first then run this code
		myFile=new File("C:/Test/One.txt");
		System.out.println("does this file exist "+myFile.exists());//this file exists so this will return true
		//the above are abseloute file paths (the full address path)
		/*
		 * however we can also use relative file paths, 
		 * my User directory is 
		 * C:\Users\noelf\OneDrive\JavaProgrammer2019-20\WorkSpace2\8.1UnderstandingFilesAndDirectories
		 */
		System.out.println(System.getProperty("user.dir"));
		/*
		 * if we were using abseloute paths this is what we would need to use to create a file called Test.txt in our
		 * user directory
		 */
	//	myFile=new File("C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/8.1UnderstandingFilesAndDirectories/Test.txt");
		/*
		 * if you don't provide a path, this is then a RELATIVE PATH, which means relative to  your user directory
		 */
		myFile=new File("Test.txt");
		//this returns true as Test.txt exists in the user directory which is here
		//C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/F8.1UnderstandingFilesAndDirectories/
		System.out.println("file in same directory "+myFile.exists());
		File dummy=new File("dummy.txt");
		System.out.println("this file does exist ? "+dummy.exists());
		System.out.println("relative to our working directory");
		myFile=new File("src/com/android/test2.txt");
		System.out.println("does this file exist using a relative path "+myFile.exists());
		//this is a relative path
		myFile=new File("src/com/android/test3.txt");
		System.out.println("this file does it  exist test3 "+myFile.exists());
		System.out.println("combination of paths");
		/*
		 * you can use a combination of abseloute and relative paths to create a file object
		 */
		//abseloute path
		File parent=new File("C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/F8.1UnderstandingFilesAndDirectories");
		//relative path
		File child=new File("src/com/android/test2.txt");
		/*
		 * there is a consturctor in the file class that takes a file object(which is the parent) and a String
		 * which is a relative file path
		 * or we can have a constructor that takes a String (whihc is the parent) and a file object, which will be
		 * the relative file path
		 * no consturctor that takes two file objects
		 */
		File newPath=new File(parent,"src/com/android/test2.txt");
		System.out.println("file location is a combination of a file object and a string which is a relative path");
		System.out.println("does file exist "+newPath.exists());
		System.out.println(newPath);
	//	System.out.println(newPath.getParent());
		//newPath=new File("C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/F8.1UnderstandingFilesAndDirectories",child);
	}
	
	static void ex2() {
		System.out.println("various methods of the file class");
		System.out.println("Exists");
		/*
		 * returns a boolean, true if a file or directory exists at this location, false if not
		 */
		File myFile=new File("Test.txt");
		System.out.println(myFile.exists());//true this file exists
		
		File myDir=new File("C:/Program Files");
		System.out.println(myDir.exists());//true this directory exists
		
		System.out.println("getName()");
		/*
		 * returns name of the file or directory denoted by this path
		 */
		System.out.println(myFile.getName());
		System.out.println(myDir.getName());
		System.out.println("getAbseloutePath()");
		/*
		 * gets the full abseloute address path of the file or directory
		 */
		System.out.println(myFile.getAbsolutePath());
		System.out.println(myDir.getAbsolutePath());
		
		System.out.println("isFile");
		/*
		 * returns a boolean, true if this is a file, false if not
		 */
		System.out.println(myFile.isFile());
		System.out.println(myDir.isFile());
		File dummy=new File("dummy.txt");
		/*
		 * as this does not exist this will return false
		 */
		System.out.println(dummy.isFile());
		/*
		 * returns a boolean, true if it is a directory, false if not or does not exist
		 */
		System.out.println("isDirectory()");
		System.out.println(myFile.isDirectory());//false
		System.out.println(myDir.isDirectory());//true
		/*******************************
		 * returns the number of bytes in a file or directory
		 * 
		 ******************/
		System.out.println("length()");
		System.out.println(myFile.length());
		System.out.println(myDir.length());
		
		System.out.println("lastModified()");
		/*
		 * returns the number of miliseconds since the start of (01-01-1970) (current epoch) the file
		 * or directory was last modified, so the one modified most recently will always be a bigger
		 * number
		 */
		System.out.println(myFile.lastModified());
		System.out.println(myDir.lastModified());
		System.out.println(dummy.lastModified());
		/*
		 * 1583928363024//file
1581066930972//directory
1583928824762
		 */
		System.out.println("delete()");
		/*
		 * deletes the file or directory, if its a directory the directory must be empty in
		 * order to delete
		 */
		System.out.println("we will use delete in combination wiht mkDir()");
		System.out.println("mkDir()");
		/*
		 * this command created directories
		 */
		File myDir2=new File("C:/Users/noelf/Documents/MyJavaTest");
		if(myDir2.exists()) {
			System.out.println("the directory already exists so this command will delete the existing directory");
			/*
			 * if your existing directory contains a file, the existing directory will NOT be 
			 * deleted
			 * after creating directory put a file in this directory and you will see the directory will not be
			 * deleted
			 * if the directory is deleted this returns true, if not, this returns false
			 */
			System.out.println(myDir2.delete());
		}
		//this creates the directory
		
		System.out.println(myDir2.mkdir());
		System.out.println(myDir2.exists());
		
		myFile=new File("C:/Users/noelf/Documents/MyJavaTest/file1.txt");
		System.out.println(myFile.exists());
		System.out.println(myFile.delete());
		/*
		 * this creates a full directory structure, for insnace
		 * C:/Users/noelf/Documents/great/entirely/mighty/filey.txt
		 */
		System.out.println("mkdirs()");
		File totDir=new File("C:/Users/noelf/Documents/great/entirely/mighty/filey");
		System.out.println(totDir.mkdirs());
		
		File myFile4=new File(totDir,"myFile.txt");
		System.out.println("createNewFile");
		/*
		 * this is the command we use to create a new file, in this case a text file called
		 * myFile.txt
		 * when you are doing anything with a file, be that creating a file, writing, reading, etc
		 * you have to put it in a try/catch block, the reason being is that you may not have access to this
		 * file, as the file is outside of the control of java.
		 */
		try {/*
		if i include this code, if the file already exists, this will delete that file
		and then will create a new file of the same name
			if(myFile4.exists())
				myFile4.delete();*/
			System.out.println(myFile4.createNewFile());
		}
		catch(IOException e) {
			System.out.println(e);
		}
		System.out.println(myFile4.exists());
/*		
		System.out.println("GetParent");
		File parentFile=new File("C:/Users/noelf/Documents/great/entirely/mighty/filey");
		System.out.println(parentFile.exists());
		System.out.println(parentFile.getParent());*/
		/*
		 * this generates an array of file objects, whihc are all the file objects contained within a
		 * particular directory
		 */
		System.out.println("listFiles()");
		//this is the directory "C:/Users/noelf/Documents/great/entirely/mighty/filey
		System.out.println(Arrays.asList(totDir.listFiles()));//will print off both full addresses for file and folders
		//for(File subFile:totDir.listFiles())
		System.out.println("listing only files");
		for(File subFile:totDir.listFiles()) {
			if(subFile.isFile())//isFile() returns true if a File obbject is an Actual file
				System.out.println(subFile.getName());
		}
		System.out.println("listing only directories");
		
		for(File subFile:totDir.listFiles()) {
			if(subFile.isDirectory())//isFile() returns true if a File obbject is an Actual file
				System.out.println(subFile.getName());
		}
		
	}

}
