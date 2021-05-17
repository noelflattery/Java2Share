package com.android;

import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Examples {
	
	static void ex1() {
		System.out.println("Introducing paths");
		/*
		 * A file object is the basic building block of IO.api
		 * a Path is the basic building block of NIO2
		 * A path is an interface, like LocalDate, you can't directly create a Path
		 * you use a factory class method, for instance get() to create a Path
		 */
		//will not compile as Path is an interface and can't create an object of type interface
	///	Path path1=new Path();
		//this file may or may not exist, and this can take either abseloute or relative paths, this 
		//is a relative path, it's relative to the folder that contains our code
		//which is this folder in my case
		//C:\Users\noelf\OneDrive\JavaProgrammer2019-20\WorkSpace2\F9.1IntroducingNIO.2
		System.out.println("abseloute path");
		Path path1=Paths.get("C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/F9.1IntroducingNIO.2/names.txt");
		System.out.println("relative path");
	//	path1=Paths.get("names.txt");
		/*
		 * 
		 * if a path starts with a drive letter i.e C:/bird, its an abseloute path
		 * otherwise its a relative path
		 * this is a path relative to our application folder which is located in my case at 
		 * C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/F9.1IntroducingNIO.2
		 * this file is located in a the src folder which is inside the above folder, so it's relative
		 * to the main application folder
		 * everyone you see a forward slash, means it's a inner folder
		 * make sure you start this path name with NOT FORWARD SLASH
		 * if we insert /src/com/android/Main.java" this will NOT WORK
		 * don't start your relative paths with any type of slash
		 */
		Path path2=Paths.get("src/com/android/Main.java");//realitve path
		Path muckPath=Paths.get("someMuck.txt");
		//this will get the name of the file in a path
		System.out.println(path1.getFileName());
		System.out.println(path2.getFileName());
		System.out.println("all items in the path");
		path2.forEach((s)->{
			System.out.println("item is "+s);
		}
		);
/*		System.out.println("all items in the abseloute path");
		path1.forEach((s)->{
			System.out.println("itme is "+s);
		});*/
		System.out.println("getParent()"); 
		//this works only for relative paths
		System.out.println(path2.getParent());
		//this will return null as does work with abseloute paths
	//	System.out.println(path1.getParent());
		//will recognise the double back slash
		Path path3=Paths.get("C:\\JavaCode\\Main.java");
		//will not recognise the single backslash
		//Path path4=Paths.get("C:\Users\noelf\OneDrive\JavaProgrammer2019-20\WorkSpace2\F9.1IntroducingNIO.2");
		Path path4=Paths.get("home/bungalow");
		String strPath1="src/com/android";//the folder structure containing our file
		String file="Examples.java";//the name of the file
		Path path5=Paths.get(strPath1,file);
		System.out.println(path2.getFileName());
		System.out.println("path1 "+Files.exists(path1));//true abselout path
		System.out.println("path2 "+Files.exists(path2));//true relative path
		System.out.println("path3 "+Files.exists(path3));//true
		System.out.println("path4 "+Files.exists(path4));//false
		System.out.println("path5 "+Files.exists(path5));//true
		/*
		 * with abselout paths use colons :::::::: after the drive letter
		 */
		Path path6=Paths.get("C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/F9.1IntroducingNIO.2/"
				+ "src/com/android/Examples.java");
		System.out.println("path 6 "+Files.exists(path6));
	}
	
	static void ex2() {
		System.out.println("URI");
		/*
		 * Uniform Resource Identifier 
		 *this is a string of characters which is used to identify a resource
		 *File
		 *directory
		 *database
		 *web page
		 *any other application
		 *that may exist on the same machine or a different machine
		 */
		try {
			/*
			 * the string to connect using URI has to have a schema (protocol) 
			 * can be
			 * file:///
			 * http:///
			 * https:///
			 * ftp:///
			 */
			/*
			 * this is creating a path using URI
			 * this is on the same machine as this code, so there is no additional steps
			 * if you were connecting to a seperate machine, there would most definately be
			 * additional steps and code you would need to log on to that machine and attempt
			 * to access that file
			 */
			Path path1=Paths.get(new URI("file:///C:/JavaCode/Main.java"));
			System.out.println("path1 "+Files.exists(path1));
			/*
			 * URI only works with abseloute paths
			 * it does not work with relative paths
			 * file is for files on same machine on a machine in network
			 */
			Path path2=Paths.get(new URI("file:///src/com/android/Examples.java"));
			System.out.println("path2 "+Files.exists(path2));
			//you would have to have a series of strings here such as username, password,
			//this is onlyl the principle, to get this to work we would have to do a number of additional steps
			//http and https is for web pages
		//	Path webPath=Paths.get(new URI("http:///www.rte.ie/index.html"));
		//	System.out.println("webPath "+Files.exists(webPath));
			/*
			 * connecting to files over the internet
			 * username is a string variable that contains the username
			 * password is a string variable that contains the password (should NEVER be stored as clear text,
			 * you store the hash)
			 */
		//	Path ftpPath=Paths.get(new URI("ftp:///username:password@ftp.the-ftp-server.com"));
			System.out.println("path1 in raw form is "+path1);
			System.out.println("path1 in URI form is "+path1.toUri());
			Path myPath=Paths.get("names.txt");
			/*
			 * toURI works with both relative and abseloute paths and is a very useful utlity method
			 * to produce URI's that can be used to connect up to a particular resource
			 * this produces the full uri
			 * ///C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/F9.1IntroducingNIO.2/names.txt
			 */
			System.out.println(myPath.toUri());
			System.out.println(myPath);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static void ex3() {
		System.out.println("Accessing the underlying FileSystem Object");
		/*
		 * we are assuming we have unlimited access to another network of machines on the other side of the
		 * world. So we don't know FileSystem, basically the layout of folders and files on that machine
		 */
		FileSystem fileSystem;
		fileSystem=FileSystems.getDefault();
		System.out.println("relative path "+fileSystem.getPath("names.txt"));//relative path
		System.out.println("abseloute path "+fileSystem.getPath("names.txt").toAbsolutePath());//complete abesloute path
		System.out.println("URI "+fileSystem.getPath("names.txt").toUri());//URI of path
		try {
			/*
			Path path1=FileSystems.getDefault().getPath("names.txt");
			System.out.println(path1.toAbsolutePath());
			Path fullPath=Paths.get("names.txt");
			fullPath=fullPath.toAbsolutePath();
			System.out.println(fullPath);
			System.out.println(fullPath.toAbsolutePath().toUri());*/
			/*
			 * FileSystem is really for remote file access (accessing folders and files and digital resources on
			 * other machines)
			 * for instance this is an example of a FileSystem on a remote machine, which is server, and we 
			 * identify a particular file by a URI
			 * 
			 */
			/*
			 * this will produced java.nio.file.ProviderNotFoundException: because we would still have to do
			 * several steps to get this to actually work, but we are only showing the principle here
			 * here we are getting the file system of an external machine, using HTTPS, we could also 
			 * use ftp or http
			 */
			FileSystem fileSystemHTTP=FileSystems.getFileSystem(new URI("https://www.rte.ie/index.html"));
			//this is accessing another machine just like mine, so the above will be this actual
			//abselout file address
			//c:/xampp/htdocs/rte/index.html
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
