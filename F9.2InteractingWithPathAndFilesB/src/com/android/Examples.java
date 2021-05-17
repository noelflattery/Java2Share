package com.android;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Examples {
	
	static void ex1() {
		System.out.println("Files.exists()");
		/*
		 * operates in teh same way as exists() for the File class, returns true if the directory or file
		 * exists, false if not
		 */
		Path path1=Paths.get("/Apps");//this is the absloute path c:/Apps
		//this method can take a path object
		System.out.println("does the folder c:/apps exist "+Files.exists(path1));
		//can take a string 
		System.out.println(Files.exists(Paths.get("C:/Apps")));
		
		System.out.println("checking for a folder called /src ");
		/*
		 * this is the abseloute path c/src, which does exist so this will return 
		 * false
		 */
		System.out.println(Files.exists(Paths.get("/src")));
		/*
		 * this is a relative and it's relative to the current application directory
		 * so this will return true as we can see from our package explorer view that there is a 
		 * folder called src inside the application folder F9.2InteractingWithPathAndFilesB
		 */
		System.out.println(Files.exists(Paths.get("src")));
		/*
		 * this just returns the "." which is the last symbol in our current working directory address
		 * C:\Users\noelf\OneDrive\JavaProgrammer2019-20\WorkSpace2\F9.2InteractingWithPathAndFilesB\.
		 */
		System.out.println(Paths.get("."));
		/*
		 * this will get the full absolute path address of the current working directory
		 * notice the dot "." at the end of the address
		 */
		System.out.println(Paths.get(".").toAbsolutePath());
		/*
		 * this will return true as this is the current working directory
		 */
		System.out.println(Files.exists(Paths.get(".")));
	}
	
	static void ex2() {
		System.out.println("Symbolic Links");
		System.out.println("Hard Links");
		/*
		 *  * NIO.2 provides support for Symbolic and hard links, the exam only really covers Symbolic links. but the premise
		 * is that a Hard link is source file and a file that is called a HARD LINK, and appears on the operating system
		 * as a seperate file, but it is actually only a link the the source. NIO.2 can use this hard link then to access
		 * the source file.
		 * A SYMBOLIC LINK appears on your OS as a shortcut, so it is more immediately apparent that this is a link and
		 * the file it is linked to is easily obtained. NIO.2 can use the symbolic link to then access the source
		 * file
		 * In NIO.2 a lot of methods have optional arguments, and two of them that apply to symbolic links are
		 * NOFOLLOW_LINKS
		 * - this means that we will NOT follow the link to the file, use this to perform actions on the actual link file
		 * FOLLOW_LINKS
		 * this will follow a link to a file if a symbolic link is encountered
		 */
		Path target=Paths.get("c:/Original/Original.txt");
		/*READ ALL COMMENTS BEFORE ATTEMPTING THIS CODE
		 * create folder "Original" in C:/ drive 
		 * create two files inside this folder 
		 * "Original.txt" and "Myfile.txt"
		 * open command line prompt as an administrator, in windows 10 in search box type "cmd" and command prompt option appear
		 * right click on this option and click on "run as administrator"
		 * type command "cd C:/Original"
		 * run the below command line command to create thie hard link
		 * mkLink /h "HardCopy_Original.txt" "Original.txt", check folder to see if file is created
		 * run the below command line prompt to create the symbolic link
		 * mkLink "Symlink_MyFile.txt" "MyFile.txt", check folder to see if file is created
		 * we can't create hard or symbolic links in this code unless we can change settings that you can only
		 * do in windows 10 professional, as far as i know
		 * inn Windows Home edition you cannot directly create symbolic links in java code, if you do
			 * you get the following Exception
			 * java.nio.file.FileSystemException:C:\MatchVideos\copy.txt: A required privilege is not held by the client.
			 * if you have windows 10 professional you need to run secpol.msc to get the require privileges
			 * unsure if linux or Mac OS allow direct creation of links without modification, google to 
			 * find out
			 */
		
		Path hLink=Paths.get("c:/Original/HardCopy_Original.txt");
		/*
		 * you may need to restart eclipse or even reboot your machine for windows to recognises the hard and symbolic links
		 * files
		 */
		System.out.println("does our target file exist "+Files.exists(target));//true that is the file we are have a hard link
		
		System.out.println("does our hard link file exist "+Files.exists(hLink));//this is the file that is the hard link
		
		Path sTarget=Paths.get("C:/Original/MyFile.txt");//Path we have a symbolic link too
		Path sLink=Paths.get("C:/Original/Symlink_MyFile.txt");//Path that is the symbolic link
		
		System.out.println("symbolic link target "+Files.exists(sTarget));//true
		System.out.println("Symbolic link "+Files.exists(sLink));//true
		try {
			/*
			 * this command checks to see if this hard link file, hLink - c:/Original/HardCopy_Original.txt
			 * , is a link to the target file file, target - c:/Original/Original.txt
			 * if this is the link for the file this will return true
			 */
			System.out.println("hard link and file it is linked too "+Files.isSameFile(target, hLink));
			System.out.println("not a correct link for a file "+Files.isSameFile(sTarget, hLink));
			
			/*
			 * this returns true as sTarget is the file and sLink is merely a symbolic link to the file
			 */
			System.out.println("symbolic link and file same "+Files.isSameFile(sTarget, sLink));
		}
		catch(Exception e) {
			System.out.println("Exception is "+e);
		}
	//	System.out.println("hard link and file same "+Files.isSameFile(target,hLink));
	}
	
	static void ex3() {
		System.out.println("methods to create directory or directories using the File class");
		/*
		 * this creates a single folder folder
		 * this will only create a single folder, it will NOT create a full directory structure of lets say
		 * Animal/mammal/ape/man
		 */
		System.out.println("mkdir");
		File fDir=new File("books");
		if(!fDir.exists())
			System.out.println("create the folder books in the application directory "+fDir.mkdir());
		System.out.println("mkdirs");
		/*
		 * this creates a folder and any sub folders and any other branch that has subfolders 
		 * this creates a animal folder
		 * and creates a mammal folder inside the animal folder
		 * and creates a ape folder inside the mammal folder
		 * and creates a man folder insdie the ape folder
		 */
		File fDirs=new File("animal/mammal/ape/man");
		if(!fDirs.exists())
			System.out.println("we are creating a full directory structure "+fDirs.mkdirs());
		
		File abDir=new File("c:/building/house/bungalow");
		if(!abDir.exists())
			System.out.println("directory in c dirve created "+abDir.mkdirs());
		/*
		 * if the directoy already exists and has something inside it, then mkdir and mkdirs will NOT create a new 
		 * directory
		 * you can add sub diretories to an existing directory and nothing will be deleted
		 */
		abDir=new File("c:/building/commercial/factory");
		System.out.println(abDir.mkdirs());
		
		/*
		 * we can also create directories and full directory structures by using Paths
		 * the methods are
		 */
		System.out.println("Files.createDirectory(");
		System.out.println("Files.createDirectories(");
		//this will be the path for creating just one folder
		Path dir=Paths.get("newDir");
		//this will be the path for creating a complete directory structure
		Path dirs=Paths.get("one/two/three");
		
		try {
		//	if(Files.notExists(dir))
			/*
			 * if either of these folders exists, delete
			 */
			Files.deleteIfExists(dir);
			System.out.println(Files.createDirectory(dir));
			if(!Files.exists(dirs))
				System.out.println(Files.createDirectories(dirs));
		}
		catch(Exception e) {
			System.out.println("exception "+e);
		}	
	}
	
	static void ex4() {
		System.out.println("copy");
		/*
		 * this copies the file or the directory that a path points to, but this is a shallow copy in that it will
		 * only copy the end point and nothing inbetween, also if the end point is a directory it will only copy
		 * the empty directory
		 */
		Path source=Paths.get("C:/Original/country/county/town");
		Path copy=Paths.get("c:/Original/copy_town");
		try {
			if(!Files.exists(copy))
				Files.copy(source, copy);
		}
		catch(Exception e) {
			System.out.println("exception "+e);
		}
		/*
		 * this is the file will copy
		 */
		source=Paths.get("C:/Original/country/county/town/myTown.txt");
		copy=Paths.get("c:/Original/myTownCopy.txt");
		try {
			if(Files.exists(copy))
				Files.delete(copy);
			/*
			 * this only copies the file myTown.txt, it does not copy
			 * country folder
			 * county folder
			 * town folder
			 */
			Files.copy(source, copy);
		}
		catch(IOException e) {
			System.out.println("exception is "+e);
		}
		/*
		 * if you copy a symbolic link, by default it will copy the file the symbolic points too and not the symbolic link file
		 * itself
		 * so this copied file will be a copy of the file MyFile.txt as this is the file that is linked to the symbolic
		 * file Symlink_MyFile.txt
		 */
		Path symSource=Paths.get("C:/Original/Symlink_MyFile.txt");
		Path symCopy=Paths.get("C:/Original/CopiedSymlink_MyFile.txt");
		try {
			if(Files.exists(symCopy)) {
				Files.delete(symCopy);	
			}
			Files.copy(symSource, symCopy);
			System.out.println("");
				
		}
		catch(IOException e) {
			System.out.println("first exception "+e);
		}
		
		Path symbolicCopy=Paths.get("C:/Original/SymbolicCopySymlink.txt");
		try {
			if(Files.exists(symbolicCopy)) {
				Files.delete(symbolicCopy);	
			}
			/*
			 * this will copy the actual symbolic linke file "SymLink_MyFile.txt" and not the file it is linked too
			 * NOFOLLOW_LINKS means that whatever path method you are using will operate on the actual symbolic link file
			 * and not the file it's linked.
			 * this machine does not have the correct privileges to run code that has LinkOption.NOFOLLOW_LINKS so this will
			 * compile but generate FileSystemException - will come back to this
			 */
	//		Files.copy(symSource, symbolicCopy,LinkOption.NOFOLLOW_LINKS);
		//	System.out.println("");
			/*
			 * we can use this instead of an if statement, this will create a copy to the file that the symbolic link file
			 * links too (the file MyFile.txt) and will replace the copied file if a file of the that name already exists.
			 * this will replace the file "SymbolicCopySymlink.txt" if it already exists, but remember this is a copy of the 
			 * file MyFile.txt
			 */
			source=Paths.get("C:/Original/MyFile.txt");
			Files.copy(symSource, symbolicCopy,StandardCopyOption.REPLACE_EXISTING);
			Path meta=Paths.get("C:/Original/meta_MyFile.txt");
			/*
			 * this in theory is for copying metadata, metadata is details about a file, such as when created, when accessed
			 * file size, type, etc
			 */
			Files.copy(source, meta,
					/*
					 * you can have as many additional atributes as you want
					 */
					StandardCopyOption.REPLACE_EXISTING,//can have this instead of an if statment
					StandardCopyOption.COPY_ATTRIBUTES,//this will copy the metadata (but does not do it in this case)
					LinkOption.NOFOLLOW_LINKS);//if its a linked file, copy the symbolic link, not the file it's linked too
				
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}
	
	static void ex5() {
		System.out.println("two more overloaded copy methods ");
		/*
		 * tow more overloaded copy methods that one takes a source Inputstream and a target path
		 * antoher takes a source path and a target Outputstream object
		 */
		try(
				InputStream is=new FileInputStream("C:/Original/MyFile.txt");//the source path for first copy method
				OutputStream out=new FileOutputStream("C:/Original/ex5Copy2.txt")//target source path for second method
						){
			Path target=Paths.get("C:/Original/ex5Copy.txt");
			/*
			 * if this file already exists, this will generate a 
			 * FileAlreadyExisistsException, so we could put in a if statement, however instead
			 * we will put in a StandCopyOption arguement that will replace the file if it already exists
			 */
			Files.copy(is, target,StandardCopyOption.REPLACE_EXISTING);
			/*
			 * this does not generate a FileAlreadyExistsException even if the file already exists, unlike the method that
			 * takes a Inputstream and a Path
			 */
			Files.copy(Paths.get("C:/Original/MyFile.txt"), out);
			
		}
		catch(Exception e) {
			System.out.println("exception is "+e);
		}
	}
	
	static void ex6() {
		System.out.println("move");
		/*
		 * this can move files to another directory
		 */
		try {
			/*
			 * this will move places.txt to one/ folder and rename the file to places2.txt
			 * run this a second time you will get NoSuchFileExcpetion as places.txt is no longer located in our 
			 * application directory
			 */
		//	Files.move(Paths.get("places.txt"), Paths.get("one/places2.txt"));
			/*
			 * you can use move to rename folders or files
			 * this will rename the filder one to "one_move"
			 * similary our folder was originally called "one" this will rename the folder to "one_move", it does not
			 * matter if there is any folders or files inside this folder
			 * run this a second time you will get NoSuchFileExcpetion
			 */
		//	Files.move(Paths.get("one"), Paths.get("one_move"));
			/*
			 * this is renaming a file
			 */
		//	Files.move(Paths.get("names.txt"), Paths.get("names2.txt"));
			/*
			 * you can move an empty directory anywhere
			 * you can move a directory with files and directories inside it but you can only move it within the same
			 * drive (i.e if the directory is on the C:/ you can't move it to the D:/ drive if the directory has something
			 * inside it.
			 * you can move a empty directory to any other drive
			 */
		}
		catch(Exception e) {
			System.out.println("exception is "+e);
		}
		
	}
	
	static void ex7() {
		System.out.println("delete and deleteIfExists");
		/*
		 * delete() deletes the file or non empty directory, if the file does not exist it throws a IOException
		 * delete CANNOT delete a directory that has files or other inside it, if you attempt to delete a non empty directory
		 * you will get the DirectoryNotEmptyException
		 */
		try {
			/*
			 * this returns void and if you attempt to delete a file that does not exist you will get a
			 * NoSuchFileException
			 */
		//	Files.delete(Paths.get("deleteMe.txt"));
			System.out.println("deleteIfExists");
			/*
			 * this returns true if the file exists and is then deleted, this will return false if the file does not
			 * exist, so this does not throw NoSuchFileException
			 */
			System.out.println("does it exist and has it been deleted "+Files.deleteIfExists(Paths.get("noFile.txt")));
			
			System.out.println("attempt to delete the non empty directoy one");
			/*
			 * if you attempt to delete a non empty directory, you will get the 
			 * DirectoryNotEmptyException
			 */
		//	System.out.println(Files.deleteIfExists(Paths.get("one")));
			/*
			 * you get the same result if you attempt to use delete on a directory that conatins other files or directories
			 */
			Files.delete(Paths.get("one"));
		}
		catch(Exception e) {
			System.out.println("exception is "+e);
		}
		
	}
	
	static void ex8() {
		System.out.println("using a newBufferedReader() and new BufferedWriter() to read and write to file using NIO2");
		Path path=Paths.get("Animals.txt");//the file we will read from
		Path writePath=Paths.get("Countries.txt");//the file we will write too
		/*
		 * A BufferedReader takes a path, which will be the file  you are reading from and a charset value, which is whatever
		 * the format the characters take in your file.
		 * you can use charset.defalutset() to get teh default charset for your jvm
		 */
		System.out.println(Charset.defaultCharset());//in my case it will be windows-1252
		/*
		 * this will return a set of all the available charsets on this machine, you can add to this set
		 */
		System.out.println(Charset.availableCharsets());

		
		try(/*
		this is the object we use to read from the file "Animals.txt", this is NIO2 as we are using the 
		Files class and using paths"
		the method is newBufferedReader, which returns a BufferedReader and takes a path and a charset*/
				BufferedReader reader=Files.newBufferedReader(path,Charset.defaultCharset());
				/*
				 * the default option is when we write to a file, it will overwrite everything already in the
				 * file so if we use the following syntax
				 * BufferedWriter writer=Files.newBufferedWriter(writePath, Charset.defaultCharset())
				 * everytime we write something to this file, it will first delete everything in the file your writing too and
				 * then write the new text to the file. here instead, we provide an optional arguement, which will APPEND
				 * to the end of the file, instead of overwriting to the file
				 */
				BufferedWriter writer=Files.newBufferedWriter(writePath, Charset.defaultCharset(),
						StandardOpenOption.APPEND)
				){
			/*
			 * this will be a string that will hold each line of text in the file Animals.txt
			 */
			String currentLine=null;
			/*
			 * this will count each one of the lines in my file Animals.txt
			 * we have 9 lines of text, so at the end of this program this counter i will read 9
			 */
			int i=0;
			while((currentLine=reader.readLine())!=null) {
				System.out.println(++i+" line "+currentLine);
				/*
				 * this puts in a blank new line
				 */
			//	writer.newLine();
				writer.write(currentLine);
			}
				
			writer.write("new line of text");
			writer.newLine();
			
		}
		catch(Exception e){
			System.out.println("exception is "+e);
		}
		
	}
	
	static void ex9() {
		System.out.println("readAllLines");
		/*
		 * readAllLines returns a list of Strings and each string in the list will be a line of text from our file
		 */
		/*
		 * this is the file we will readAllLines() from
		 */
		Path path=Paths.get("Jobs.txt");
		/*
		 * this is the list that will hold all the lines of text from jobs.txt
		 */
		List<String>lines=null;
		Path writePath=Paths.get("Countries.txt");//the file we will write too
		try(/*
		this is the object we will use to write to end of "Countries.txt" file
		*/
				BufferedWriter writer=Files.newBufferedWriter(writePath, Charset.defaultCharset(),
						StandardOpenOption.APPEND)
				){
			/*
			 * creates a list of strings and assigs them to the lines list
			 */
			lines=Files.readAllLines(path);
			//we see there are 5 lines of text so we will have 5 strings
			System.out.println("there are "+lines.size()+" lines of text");
			System.out.println(lines);
			//puts a blank like at the start before we write, this will insert a blank like before each set of text
		//	writer.newLine();
			/*
			 * this will write each line of text from jobs.txt to countries.txt
			 */
			for(String s:lines) {
				writer.write(s);
				writer.newLine();
			}
				
		}
		catch(Exception e) {
			System.out.println("exception is "+e);
		}
	}
	
	
	
	

}
