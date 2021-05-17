package com.android;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Examples {
	/*
	 * first point to acknowledge about paths and they're methods, is that like File objects, many operations
	 * can be accomplished whether the path is a file or directory that actually exists
	 */
	static void ex1() {
		System.out.println("various methods of NIO.2");
		Path path=Paths.get("C:/JavaCode/Main.java");//this file actually exists and this is an abseloute path
		System.out.println("the path is "+path);
		System.out.println("getNameCount");
		/*
		 * this will get the amount of elements in the path, it does not include the drive letter (more commonly 
		 * called ROOT)
		 * or if it's ftp or http, does not include that either
		 */
		System.out.println("amount of items in this path is "+path.getNameCount());
		Path path2=Paths.get("text.txt");
		System.out.println(path2.toUri());
		Path path3=Paths.
				get("C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/F9.2InteractingWithPathAndFiles/text.txt");
		/*
		 * this will print off 7 as there is 7 elements in this path (excluding the drive letter)
		 */
		System.out.println(path3.getNameCount());
		System.out.println("getting details of our path");
		for(int i=0;i<path3.getNameCount();i++) {
			/*
			 * this will get the name of all the elements in the path, including the final elemetn which will
			 * be text.txt
			 */
			System.out.println("element name is "+path3.getName(i));
	//		System.out.println(path3.getFileName());
		}
		//this will get the final element, which is the produce of the whole path, which is "text.txt"
		System.out.println("the file at this location is "+path3.getFileName());
		//this will get the final element, which will be F9.2InteractingWithPathAndFiles
		Path path4=Paths.
				get("C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/F9.2InteractingWithPathAndFiles");
		System.out.println(path4.getFileName());
		/*
		 * if you have a realtive path, the folders leading up to your relative path, namely in this case
		 * C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/F9.2InteractingWithPathAndFiles
		 * is not counted at all
		 * so this below here only returns 4
		 */
		Path relPath=Paths.get("src/com/android/Examples.java");//4
		System.out.println("the relative path has "+relPath.getNameCount()+" elements");//return 4
		//this will return 1 as the elements preceded this, the relative path folder, are NOT counted
		relPath=Paths.get("text.txt");
		System.out.println(relPath.getNameCount());//return 1
		
		Path root=Paths.get("C:/");//will return 0, because the root element (the drive) is not counted
		System.out.println(root.getNameCount());
		//does not matter that this does NOT exist, its just checking the string
		root=Paths.get("D:/");//0
		System.out.println(root.getNameCount());
		//does not matter that this does NOT exist, it's just checking the string
		root=Paths.get("D:/Home/Web/myWebsite/index.html");
		System.out.println(root.getNameCount());//4

	}
	
	static void ex2() {
		Path path=Paths.get("D:/Animal/Monkey/ape/human.txt");
		System.out.println("getFileName");
		/*
		 * this will get the element furtherest from the root
		 * will return a file or a directory
		 */
		System.out.println(path.getFileName());//human.txt
		path=Paths.get("C:/JavaCode/Dir");//Dir
		System.out.println(path.getFileName());//Dir
		//works with relative path
		Path path2=Paths.get("src/com/android");
		System.out.println(path2.getFileName());//android
		
		System.out.println("getParent");
		path=Paths.get("D:/Animal/Monkey/ape/human.txt");
		/*
		 * this is the folder that contains our last element in our list
		 * in this case, its the folder that contains "human.txt"
		 */
		System.out.println("the parent folder of this file is "+path.getParent());
		path2=Paths.get("text.txt");
		/*
		 * when its a relative path, getParent cannot go beyond the folder that is  your relative path
		 * in my case it's 
		 * C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/F9.2InteractingWithPathAndFiles
		 * if the parent is the relative path which is our application folder, this will return null
		 */
		System.out.println("the parent folder of the relative path text.txt is "+path2.getParent());//null
		path2=Paths.get("src/com/android/Examples.java");
		/*
		 * the parent of file Examples.java, is a realtive path
		 * src/com/android
		 */
		System.out.println(path2.getParent());
	//	System.out.println(path2.toAbsolutePath());
		Path path3=path2.toAbsolutePath();
		System.out.println(path3);//path3 is now an abseloute path
		//this will return the full abseloute path name for the parent folder of Examples.java
		//C:\Users\noelf\OneDrive\JavaProgrammer2019-20\WorkSpace2\F9.2InteractingWithPathAndFiles\src\com\android
		System.out.println(path3.getParent());
		/*
		 * if your path is just a drive letter, then getParent will return null
		 */
		path3=Paths.get("C:/");
		System.out.println("using getParent on a root drive ");
		System.out.println(path3.getParent());
		
		System.out.println("getRoot");
		/*
		 * this gets us the left most element, usually a drive
		 * i.e
		 * D:/Animal/Monkey/ape/human.txt root of this will be D
		 */
		path=Paths.get("D:/Animal/Monkey/ape/human.txt");
		System.out.println(path.getRoot());
		/*
		 * only works with abselout paths
		 */
		path2=Paths.get("C:/JavaCode/Examples.java");
		System.out.println(path2.getRoot());
		path3=Paths.get("src/com/android/Examples.java");
		/*
		 * getRoot does NOT work on relative paths, this will return null
		 */
		System.out.println(path3.getRoot());
		
		path=Paths.
				get("C:\\Users\\noelf\\OneDrive\\JavaProgrammer2019-20\\WorkSpace2\\F9.2InteractingWithPathAndFiles");
		//System.out.println(Files.exists(path));
		//File myFile=new File("names.txt");
		Path pathFile=Paths.get("names.txt");
		
		try {
		/*	if(!myFile.exists())
				myFile.createNewFile();
			while((path=path.getParent())!=null)*/ {
			System.out.println("parent is "+path);
		//	myFile=new File(path,myFile);
		/*	if(!myFile.exists())
				myFile.createNewFile();*/
		}
			
		}
		catch(Exception e) {
				System.out.println(e);
			}
		
	}
	
	static void ex3() {
		System.out.println("**isAbsolute() to AbsolutePath()");
		/*
		 * is Abseolute returns a boolean, true if the path is abseloute
		 * false if realtive
		 * toAbsolutePath() converts a realitive path to a abeloute path
		 */
		Path path=Paths.get("C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/F9.2InteractingWithPathAndFiles");
		Path path2=Paths.get("src/com/android/Examples.java");//relative path
		
		System.out.println(path.isAbsolute());//true
		System.out.println(path2.isAbsolute());//false
		
		Path noPath=Paths.get("D:/Muck/luck/tuck.txt");
		/*
		 * does not check if this actually exists or not, it just checks the string to see
		 * if this is a absolute or relative path
		 */
		System.out.println(noPath.isAbsolute());//true
		/*
		 * this converts this relative path to an abselout path
		 */
		System.out.println(path2.toAbsolutePath());
		/*
		 * if it's already an absolute path this will return the same path
		 */
		System.out.println(path.toAbsolutePath());
		
		noPath=Paths.get("muck/no/no/no/not.txt");
		System.out.println(noPath.isAbsolute());//false
		/*
		 * this will produce 
		 * C:\Users\noelf\OneDrive\JavaProgrammer2019-20\WorkSpace2\F9.2InteractingWithPathAndFiles\muck\no\no\no\not.txt
		 */
		System.out.println(noPath.toAbsolutePath());
		/*
		 * we need to be careful while using isAbsolute as absolute and relative paths are file system dependant
		 * (Windows,linux,mac)
		 * for example this prints true on linux and mac but false on windows as missing a drive letter
		 * the symbol "/" at the start of a string can refer to a root folder(drive) in Mac and linux
		 */
		System.out.println(Paths.get("/stripes/Zebra.exe").isAbsolute());//false but this will true if running
		//this on a UNIX or a MAC machine
		/*
		 * this will return true on a windows machine but false on UNIX or Mac OS because its missing
		 * a root forward slash at the beginning
		 */
		System.out.println(Paths.get("C:/goats/Food.java").isAbsolute());
		/*
		 * I think that this will be true on unix and mac and windows, we have a root forward slash at the 
		 * beginning
		 */
		System.out.println(Paths.get("//goats/Food.java").isAbsolute());
		
	}
	
	static void ex4() {
		/*
		 * subPath() like the previous methods, does not care if this path corresponds to actual folder and files
		 * on your system, or in other words whether the actual folders and files exist or not
		 */
		System.out.println("subPath");
		/*
		 * this is a path within a path
		 */
		String parent="C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/F9.2InteractingWithPathAndFiles";
		String child="src/com/android/Examples.java";
		Path fullPath=Paths.get(parent,child);
		System.out.println(fullPath);
		System.out.println("is this an absolute path "+fullPath.isAbsolute());
		/*C:\Users\noelf\OneDrive\JavaProgrammer2019-20\WorkSpace2\F9.2InteractingWithPathAndFiles
		\src\com\android\Examples.java
		*/
		//this path has 10 elements, 9 folders and one file
		//the elements use array numbering, so these elements go from 0 to 9
		System.out.println("there are "+fullPath.getNameCount()+" elements in the path");
		/*
		 * subpath returns any relative subpath within the abseloute path
		 * there are 10 elements in this path
		 * so this path goes from index postion 0, up to index positiion 5, but DOES NOT include
		 * index position 5, operates exact same way as the subString() method of the String
		 * this creates the relative path
		 * Users\noelf\OneDrive\JavaProgrammer2019-20\WorkSpace2
		 * subpath returns a relative path
		 */
		System.out.println("subpath from 0 to 5 but not including 5 "+fullPath.subpath(0, 5));
		/*
		 * this starts at index position 3, which is the folder "JavaProgrammer2019-20"
		 * and up to index position 7, but not including position 7, which will be the folder "src"
		 */
		Path relPath=fullPath.subpath(3, 7);
		//prints off
		/*
		 * JavaProgrammer2019-20\->index postion 3
		 * WorkSpace2\ -> index position 4
		 * F9.2InteractingWithPathAndFiles -> index position 5
		 * \src -> index position 6
		 * index position 7 is NOT included
		 */
		System.out.println(relPath);
		System.out.println(relPath.isAbsolute());//false as it's a relative path
		/*
		 * this will print
		 * C:\Users\noelf\OneDrive\JavaProgrammer2019-20\WorkSpace2\F9.2InteractingWithPathAndFiles\
		 * JavaProgrammer2019-20\WorkSpace2\F9.2InteractingWithPathAndFiles\src
		 */
		System.out.println(relPath.toAbsolutePath());
		try {
			/*
			 * if you attempt to access an element in a path by subpath that does not exist
			 * you will get an IllegalArguementException
			 */
			System.out.println("subpath from 0 to 10 "+fullPath.subpath(0, 10));//this wil compile, no exception
			//this will give us an illegalArugmenmt exception as this is out of bounds as only
			//10 elements in our path, so only goes UP TO 10, but numbering is 0 t0 9
		//	System.out.println("subpath from 0 to 11 "+fullPath.subpath(0, 11));
			/*
			 * can't have an empty path or subpath, this is a empty path, so this will throw an
			 * IllegalArguement exception as well
			 */
			System.out.println("subpath from 2 to 2 "+fullPath.subpath(2, 2));
		}
		catch(Exception e) {
			System.out.println("exception is "+e);
		}
		
		
		
	}
	
	static void ex5() {
		System.out.println("using path symbols");
		String parent="C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/F9.2InteractingWithPathAndFiles";
		String child="src/com/android/Examples.java";
		Path fullPath=Paths.get(parent,child);
		//full path is 
		/*
		 * C:\Users\noelf\OneDrive\JavaProgrammer2019-20\WorkSpace2\F9.2InteractingWithPathAndFiles
		 * \src\com\android\Examples.java
		 */
		System.out.println(fullPath);
		Path relPath=Paths.get("names.txt");
		System.out.println(relPath);
		/*
		 * this symbol
		 * ../
		 * one directory up from the current relative directory
		 */
		System.out.println("using path symbol ../");
		/*
		 * this is path, that will be the parent directory of the directory that is the relative path
		 * we start at this folder
		 * C:\Users\noelf\OneDrive\JavaProgrammer2019-20\WorkSpace2\F9.2InteractingWithPathAndFiles
		 *../ is the parent of the current application relevant path folder, goes up one folder to
		 *C:\Users\noelf\OneDrive\JavaProgrammer2019-20\WorkSpace2
		 *../../ goes up two level, goest to the folder
		 * C:\Users\noelf\OneDrive\JavaProgrammer2019-20
		 * this example here refers the following path, workspace2 is the parent folder of 
		 * the folder that is the location of our application relative path
		 * C:\Users\noelf\OneDrive\JavaProgrammer2019-20\WorkSpace2\animal.txt
		 * make sure you have this file created in your own folder
		 */
		Path newPath=Paths.get("../animal.txt");//up one level to C:\Users\noelf\OneDrive\JavaProgrammer2019-20\WorkSpace2\animal.txt
	//	Path newPath2=Paths.get("names.txt").toAbsolutePath();
	//	System.out.println(newPath2);
		System.out.println(newPath);//will print out ..\animal.txt, go up ONE folder from current position
		System.out.println(newPath.toAbsolutePath());
		System.out.println(Files.exists(newPath));
		/*
		 * up two levels to 
		 * C:\Users\noelf\OneDrive\JavaProgrammer2019-20\places.txt
		 */
		newPath=Paths.get("../../places.txt");
		System.out.println(Files.exists(newPath));
		/*
		 * up three levels to 
		 * C:\Users\noelf\OneDrive\clothes.txt"
		 */
		newPath=Paths.get("../../../clothes.txt");
		System.out.println(Files.exists(newPath));
		
		newPath=Paths.get("../../../JavaCodeTest/Folder1/Money.txt");
		System.out.println("does the money file in onedrive exist "+Files.exists(newPath));
		System.out.println(newPath);
		/*
		 * this displays
		 * C:\Users\noelf\OneDrive\JavaProgrammer2019-20\WorkSpace2\
		 * F9.2InteractingWithPathAndFiles\..\..\..\JavaCodeTest\Folder1\Money.txt
		 */
		System.out.println(newPath.toAbsolutePath());
		/*
		 * the default schema is file, however you can change this to whatever schema  you want
		 * i.e FTP, HTTP, HTTPS
		 * this prints off
		 * file:///C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/
		 * F9.2InteractingWithPathAndFiles/../../../JavaCodeTest/Folder1/Money.txt
		 * so the actual abseloute path is actually this
		 *C:/Users/noelf/OneDrive/JavaCodeTest/Folder1/Money.txt
		 *this is more useful that toAbsolute path, as this output can be directly pasted into java
		 *code
		 */
		System.out.println(newPath.toUri());	
	}
	
	static void ex6() {
		System.out.println("Deriving a path with relativize");
		String parent="C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2/F9.2InteractingWithPathAndFiles";
		String child="src/com/android/Examples.java";
		Path fullPath=Paths.get(parent,child);
		//this is
		/*
		 * C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2
		 * /F9.2InteractingWithPathAndFiles/src/com/android/Examples.java
		 */
		System.out.println(fullPath.toUri());
		/*
		 * both of these paths are abseloute paths
		 * this file actually exists, but it does'nt have too in order for the code to run
		 */
		Path relPath=Paths.get("C:/Users/noelf/OneDrive/JavaCodeTest/Folder1/Money.txt");
		System.out.println(relPath);
		/*
		 * this produces 
		 * ..\..\..\..\..\..\..\JavaCodeTest\Folder1\Money.txt
		 * this is asking where is relpath (which is 
		 * C:/Users/noelf/OneDrive/JavaCodeTest/Folder1/Money.txt"
		 * in relation to fullPath
		 * which is this 
		 *  C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2
		 * /F9.2InteractingWithPathAndFiles/src/com/android/Examples.java
		 */
		System.out.println(fullPath.relativize(relPath));
		/*
		 * this produces 
		 * ..\..\..\JavaProgrammer2019-20\WorkSpace2\F9.2InteractingWithPathAndFiles\src\com\android\Examples.java
		 * we start at relpath which is 
		 * C:/Users/noelf/OneDrive/JavaCodeTest/Folder1/Money.txt"
		 * so we have to go up three levels, when we go up three levels we are in the folder
		 * C:/Users/noelf/OneDrive
		 * we then to the the following folder and subfolders in OneDrive
		 * JavaProgrammer2019-20\WorkSpace2\F9.2InteractingWithPathAndFiles\src\com\android\Examples.java
		 * relativize() is a map of how to get from one location to another
		 */
		System.out.println(relPath.relativize(fullPath));
		System.out.println("this can be a path");
		Path newPath=relPath.relativize(fullPath);
		System.out.println("new Path is "+newPath);
		System.out.println("newPath to abseloute path is "+newPath.toAbsolutePath());
		/*
		 * you can use relative paths with relativize, if both paths are relative it will 
		 * presume that both use the
		 * same current working directory
		 * these two relative paths assume the same working directory of 
		 * C:/Users/noelf/OneDrive/JavaProgrammer2019-20/WorkSpace2
		 * /F9.2InteractingWithPathAndFiles
		 */
		Path path1=Paths.get("fish.txt");
		Path path2=Paths.get("birds.txt");
		/*
		 * this will return ..\, which means they are in the same folder
		 */
		System.out.println("path1 realtive to path2 "+path1.relativize(path2));
		System.out.println("path2 relative to path1 "+path2.relativize(path1));
		/*
		 * in order to use relativize both paths have to either abseloute or relative
		 *can't have one relative and one abseloute
		 *also won't work if you ahve a different root folder
		 */
		path1=Paths.get("names.txt");//relative path
		path2=Paths.get("C:/Users/noelF/OneDrive");//abseloute path
		/*
		 * this generates an IllegalArgumentException as one is relative and the other is abseloute
		 */
	//	System.out.println(path1.relativize(path2));
		
		 Path pathA=Paths.get("D:/JavaCode/Main.java");
		 Path pathB=Paths.get("C:/more/lot/great/jobs.txt");
		 /*
		  *  this generates an IllegalArgumentException as these two paths have different roots
		  */
	//	 System.out.println(pathA.relativize(pathB));
		/*
		 * i created two files, NoBook.txt and NoJava.txt and placed them in two seperate folders
		 * in my case i placed the first in the folder
		 * C:/Users/noelf/OneDrive/JavaProgrammer2019-20/Books
		 * and the second in 
		 * C:/Users/noelf/OneDrive/GalwayJava2016-2017/Books
		 * so at the very start we know both files exists in the they're respective folders
		 */
		path1=Paths.get("C:/Users/noelf/OneDrive/JavaProgrammer2019-20/Books/NoBook.txt");
		path2=Paths.get("C:/Users/noelf/OneDrive/GalwayJava2016-2017/Books/NoJava.txt");
		System.out.println("two paths first path relative to second path");
		/*
		 * path1 goest up until it finds a common folder to path2, which is
		 * C:/Users/noelf/OneDrive
		 * it then goest down three levels to find the file NoJava.txt
		 */
		//produces ..\..\..\GalwayJava2016-2017\Books\NoJava.txt
		System.out.println(path1.relativize(path2));
		//produces ..\..\..\JavaProgrammer2019-20\Books\NoBook.txt
		System.out.println("second path relative to first path");
		/*
		 * same process but reversed
		 */
		System.out.println(path2.relativize(path1));
		/*
		 * relative returns a Path, now it always returns a relative path, which is
		 * essentially the map of how to get from Path1 to Path2
		 */
		System.out.println(Files.exists(path1.relativize(path2)));
/*		Path noPath=path1.relativize(path2);
		System.out.println(noPath.toUri());
		System.out.println(Files.exists(noPath));*/
		 /*
		  * this file exists and is a relative path
		  * it does not matter where is is relative too
		  * path1=Paths.get("C:/Users/noelf/OneDrive/JavaProgrammer2019-20/Books/NoBook.txt");
		path2=Paths.get("C:/Users/noelf/OneDrive/GalwayJava2016-2017/Books/NoJava.txt");
		the above two files exist on my machine
		here this is a relative path, but it's NOT relative to our existing application folder, here 
		its relative to another folder, does not matter which folder as the Path interface interacts
		with whatever your operating system to determine if the is a relative path or not and also
		whether it exists or not
		  */
		Path test=Paths.get("../../../GalwayJava2016-2017/Books/NoJava.txt");
		System.out.println(Files.exists(test));	
	}
	
	static void ex7() {
		System.out.println("resolve()");
		System.out.println("abseloute path");
		Path path1=Paths.get("C:/folder/stuff");//abseloute path
		System.out.println("relative path");
		Path path2=Paths.get("test/more");//relative path
		/*
		 * this produces 
		 * C:\folder\stuff\test\more
		 */
		System.out.println("an abseloute path calling resolve with a relative path as input");
		System.out.println(path1.resolve(path2));
		/*
		 * resolve does have an overloaded method taht takes a string
		 * Path1, an abseloute calling resolve and the input parameter for resolves is a relative path
		 * "text/more" then the two parts are just joined to produce one path
		 */
		System.out.println(path1.resolve("test/more"));
		/*
		 * this produces 
		 * C:\folder\stuff\test\more
		 * the get has no method that takes a Path object
		 * get() just sticks two paths together, actually sticks the strings of the path together to 
		 * become one path
		 */
		System.out.println(Paths.get("C:/folder/stuff","test/more"));
		
		System.out.println("with two relative paths");
		path1=Paths.get("test/more");
		path2=Paths.get("animal/goose");
		/*
		 * if you have a relative path calling (path1) and the input parameter for resolve is a 
		 * relative path(path2) then the two parts are just joined to produce one path
		 * resolve takes two paths and tries to resolve the two to become one path
		 * as long as the input parmeter is a relative path, then path1 and path2 will just be joined
		 * in the same way if you use Paths.get
		 */
		System.out.println(path1.resolve(path2));//produces the relative path test\more\animal\goose
		System.out.println(Paths.get("test/more","animal/goose"));//produces the same relative path
		
		path1=Paths.get("C:/myDocs");//abseloute
		path2=Paths.get("/animals/Dog");//abseloute
		System.out.println("two abseloute path with resolve");
		/*
		 * if you have a abseloute path as the input parameter (here path2 is an abseloute path)
		 * this is what will be returned by the resolve method. only path2 will be returned 
		 * path2 is /animals/Dog, which is actually c:/animals/Dog
		 */
		System.out.println(path1.resolve(path2));
		/*
		 * this produces C:\myDocs\animals\Dog
		 * get just joins up two strings to prouduce a path
		 */
		System.out.println(Paths.get("C:/myDocs","/animals/Dog"));
		
		path1=Paths.get("dog.txt");//relative path
		path2=Paths.get("C:/myDocs");//abseloute path
		/*
		 * resolve takes two paths, or two strings which represents paths to to produce one path, it attempts
		 * to RESOLVE two paths to one, however with abseloute paths this can be impossible
		 * so if your input parameter is a abseloute path in resolve, what is returned is a copy of the 
		 * the inputer parameter, which is in this case path2
		 */
		System.out.println(path1.resolve(path2));	
		System.out.println(Paths.get("C:/myDocs", "dog.txt"));
	}
	
	static void ex8() {
		System.out.println("Normalize");
		Path path1=Paths.get("C:/data");//abseloute path
		Path path2=Paths.get("C:/user/home");//abselout path
		
		Path relativePath=path1.relativize(path2);//relative path
		/*
		 * this returns ..\ user\home which means to get from C:/data we have to go up one level to
		 * C:/
		 * and then we go down to /user/home
		 */
		System.out.println(relativePath);
		/*
		 * this produces 
		 * C:\data\..\ user\home
		 * as the relative path ..\ user\home is simply added to the path
		 * abseloute path C:\data
		 */
		System.out.println(path1.resolve(relativePath));
		/*
		 * at this point we create a folder c:/data
		 * and folders c:/user/home
		 * this returns true as C:\data\..\ user\home is the same as c:/user/home and this 
		 * folder does exist
		 */
		System.out.println("does this path exist "+Files.exists(path1.resolve(relativePath)));
		/*
		 * we use normalize to tidy up the output so C:\data\..\ user\home
		 * becomes c:/user/home
		 */
		System.out.println("normalized address is "+path1.resolve(relativePath).normalize());
		/*
		 * this creates the path C:/data/../user\home
		 * which we then normalize to become c:/user/home
		 * which we then call the toString() method which converts this to the strin "c:/user/home", which
		 * is used in a get to be assigned to the Path newPath
		 */
		Path newPath=Paths.get(path1.resolve(relativePath).normalize().toString());
		System.out.println(newPath);
	}
	
	static void ex9() {
		System.out.println("toRealPath()");
		/*
		 * this returns a abseloutPath which points to the location of your file or directory
		 */
		try {
			/*
			 * toRealPath() only works with actual files that exist, if this file did not exist, we would
			 * get a NoSuchFileException
			 */
			System.out.println(Paths.get("text.txt").toRealPath());
			/*
			 * with toAbsolutePath() it doest not matter if the file exists or not (this file does NOT 
			 * exist) and yet it will print out the full address whether this file exists or not
			 */
			System.out.println(Paths.get("aniamls.txt").toAbsolutePath());
			/*
			 * this will generate a NoSuchFileException as this file does NOT exist
			 * toRealPath() actually acesses your file, so it has to exist to work, if the file does not
			 * exist toRealPath() will return NoSuchFileException
			 */
	//		System.out.println(Paths.get("muck.txt").toRealPath());
			/*
			 * to realPath applies to paths, so the end point can be a folder or a file
			 */
			Path path1=Paths.get("src/com/android");
			/*
			 * we usualy use a if statement or a ternary operator to check if the file path actually exist
			 * before we use toRealPath()
			 */
			if(Files.exists(path1))
				System.out.println(path1.toRealPath());
		}
		catch(IOException e) {
			System.out.println("exception "+e+" is caught");
		}
	}
	
	
	
	
}
