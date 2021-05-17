package com.android;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Examples {
	/*
	 * this is about accessing file and directory METADATA or atributes
	 * which is data about the file or directory and not about the contents of the file or directory
	 */
	static void ex1() {
		System.out.println("isDirectory");
		Path dir=Paths.get("C:/Original");
		Path file=Paths.get("C:/Original/MyFile.txt");
		/*
		 * this is a symbolic link file that links to the file MyFile.txt
		 */
		Path sFile=Paths.get("C:/Original/Symlink_MyFile.txt");
		System.out.println("is this a directory "+Files.isDirectory(dir));//true
		System.out.println("is this file a directory "+Files.isDirectory(file));//false
		System.out.println("is this symbolic link file a directory "+Files.isDirectory(sFile));
		/*
		 * the directory has to exist for this to return true, if the directory does NOT exist then it will
		 * return false
		 */
		Path noPath=Paths.get("C:/NotExist");
		System.out.println("is this a directory even though it's not on my machine "+Files.isDirectory(noPath));
		/*
		 * a regular file is a file that contains content as opposed to a symbolic link, directory, a resource or other
		 * non-regular file
		 */
		System.out.println("isRegularFile()");
		System.out.println("is our directory a regular file "+Files.isRegularFile(dir));//false
		System.out.println("is our file a regular file "+Files.isRegularFile(file));//true
		/*
		 * sFile is a symbolic link file, however this returns true, as its not checking if the file 
		 * C:/Original/Symlink_MyFile.txt" is a regular file, its checking the file it's linked too, which is the file
		 * "C:/Original/MyFile.txt" which is a regular file
		 */
		System.out.println("is the file the symbolic linked file is linked to a regular file "+Files.isRegularFile(sFile));//true
		/*
		 * this will return false as we are telling java NOT to go the file that is linked to the symbolic linked file,
		 * so this is just checking the symbolic link file C:/Original/Symlink_MyFile.txt and not the file it is
		 * linked too
		 */
		System.out.println("is the symbolic linked file a regular file "+Files.isRegularFile(sFile, LinkOption.NOFOLLOW_LINKS));//false
		noPath=Paths.get("C:/Original/rubbish.txt");
		/*
		 * just like isDirectory() if the file does not actually exist this will return false
		 */
		System.out.println("is the rubbish file a regular file "+Files.isRegularFile(noPath));
		
		System.out.println("isSymbolicLink()");
		
		System.out.println("is this file a symbolic linked file "+Files.isSymbolicLink(file));//false
		System.out.println("is this symbolic link a symbolic link file "+Files.isSymbolicLink(sFile));//true
		
		System.out.println("isHidden()");
		
		Path hidden=Paths.get("C:/Original/Hidden.txt");
		Path hideDir=Paths.get("C:/Original/HideDir");
		System.out.println(Files.isDirectory(hideDir));
		/*
		 * before you run this example create a file called Hidden.txt and then right click on the file, properties, click on 
		 * hidden
		 */
		try {
			System.out.println("is Hidden.txt file hidden "+Files.isHidden(hidden));//true as this is hidden
			System.out.println("is MyFile.txt hidden "+Files.isHidden(file));//false as this is NOT hidden
			/*
			 * this only works for hidden FILES
			 */
			System.out.println("is the directory HideDir hidden "+Files.isHidden(Paths.get("C:/Original/HideDir")));
		}
		catch(Exception e) {
			System.out.println("exception is "+e);
		}
		/*
		 * this is just checking to see can we access files or directories
		 */
		System.out.println("isReadable()");
		System.out.println("is the file myFile.txt readable, can we access it "+Files.isReadable(file));//true
		System.out.println("is the directory C:/Original readable "+Files.isReadable(dir));//true
		System.out.println("is noPath readable "+Files.isReadable(noPath));//fase as this is a folder that does not exist
		
		System.out.println("isExecutable()");
		/*
		 * in windows this checks if the OS has privileges to execute the file, it does not check if the file is executable 
		 * or not
		 */
		Path exeFile=Paths.get("C:/Original/eclipse.exe");
		System.out.println("is file executable "+Files.isExecutable(exeFile));
		/*
		 * file is NOT an executable path, as its "C:/Original/MyFile.txt", but this will still return true
		 * as it's just checkin to see if you have the correct privileges to run executables at this location
		 */
		System.out.println("is MyFile.txt executable "+Files.isExecutable(file));//true
		
		Path exe2=Paths.get("C:/Original/eclipse2.jpg");
		System.out.println("is eclipse2.jpg executable "+Files.isExecutable(exe2));//true
		
		System.out.println("size");
		
		try {
			System.out.println("size of MyFile.txt is "+Files.size(file));
			/*
			 * the size here may be different from the size expressed in the OS, due to file compression and organisation
			 */
			System.out.println("size of eclipse.exe is "+Files.size(exeFile));//
			/*
			 * the size() method does not work for directories, for that you need to "walk" the directory tree, 
			 * which will be explained in further sections
			 */
			System.out.println("size of directory is "+Files.size(Paths.get("C:/Original/copy_town")));
			System.out.println("size of directory is "+Files.size(Paths.get("C:/Original/country")));
			
		}
		catch(Exception e) {
			System.out.println("exception is "+e);
		}
	}
	
	static void ex2() {
		Path file=Paths.get("C:/Original/MyFile.txt");
		System.out.println(LocalDateTime.now());
		System.out.println("getLastModifiedTime");
		try {
			/*
			 * this returns a localdateTime of when the time this file was last modified, HOWEVER this does not take into
			 * account daylight saving time in Ireland so if ran in summer will be one hour behind the offical time
			 * i.e my clock in April reads 17:04 but this will return 16:04
			 */
			System.out.println(Files.getLastModifiedTime(file));
			/*
			 * localTime and LocalDateTime and LocalDate all operate from the base date of 01 january 1970
			 * this will be the amount of miliseconds since 1 janauary 1970 that the file was modified
			 * i.e the file was modified 1_586_355_765_904 miliseconds after 00:00 1 janauary 1970
			 */
			System.out.println("the amount of miliseconds since january first when the file was modified "
								+Files.getLastModifiedTime(file).toMillis());
			System.out.println("the amount of seconds since janauary first when the file was modified "
								+Files.getLastModifiedTime(file).to(TimeUnit.SECONDS));
			System.out.println("the amount of days since january first 1970 when the file was modifed "
								+Files.getLastModifiedTime(file).to(TimeUnit.DAYS));
			System.out.println("the amount of hours since january first 1970 when th is file was modified "
								+Files.getLastModifiedTime(file).to(TimeUnit.HOURS));
			System.out.println("setLastModifiedTime");
			/*
			 * this is changing the lastModifiedTime to the current time
			 */
			Files.setLastModifiedTime(file, FileTime.fromMillis(System.currentTimeMillis()));//set to current time
			System.out.println(Files.getLastModifiedTime(file)/*.toMillis()*/);
			
		//	LocalDateTime now=LocalDateTime.now();
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	static void ex3() {
		/*
		 * this is about the concept of User owned files and directories and this is more a facet of UNIX and by extension 
		 * Android
		 * As far as i know this code will not work on average windows 10 installation, it will work somewhat on windows
		 * 10 professional (or whatever version of windows you are using are you read this)
		 * Windows server this code will work on
		 */
		System.out.println("getOwner() and setOwner()");
		try {
			/*
			 * this create a owner, which in my case is the admin of this machine which is me on my own machine
			 * LAPTOP-9SV4AT83 is the name of my machine
			 * noelf is the admin on this machine
			 * owner is actually the a object that implements the UserPrincipal interface
			 */
			UserPrincipal owner=FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("noelf");
			UserPrincipal owner2=FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("PatJo");
			System.out.println("this owner is "+owner);
			System.out.println("this owners name is "+owner.getName());
			System.out.println("owner2 is "+owner2);
		}
		catch(Exception e) {
			System.out.println("first exception caught "+e);
		}
		
		try {
			//file we want to find the owner of, which is the account on this machine that created this file
			Path path=Paths.get("C:/Original/MyFile.txt");
			
			System.out.println("the owner of this file is "+Files.getOwner(path).getName());
			
			UserPrincipal owner = path.getFileSystem()
					.getUserPrincipalLookupService().lookupPrincipalByName("noelf");
			/*
			 * even though this is a different user, and it does exist on my system
			 * i still do not have the correct privileges to change the owner of a file
			 */
			UserPrincipal owner2=FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("PatJo");
			/*
			 * this version of windows does not allow me to change owners of files, or in this case, change who the operating
			 * system thinks created the file, it may be possible to change settings in windows to allow this to happen.
			 * this will generate java.nio.file.AccessDeniedException
			 * you can change owners in UNIX a lot easier than you can in windows
			 */
			Files.setOwner(path, owner2);//this will generate AccessDeniedException 
			
			System.out.println("owner is "+Files.getOwner(path).getName());
			
		}
		catch(Exception e) {
			System.out.println("second exception caught is "+e);
		}	
	}
	
	static void ex4() {
		/*
		 * we can access individiual atributes of a file by the various methods above
		 * i.e Files.size(path)
		 * Files.getLastModifiedTime(path)
		 * Files.isExecutable(exe2)
		 * Files.isRegularFile(file)
		 * this will have to access our file, our disk, for each of the above methods, so the file and main memory has
		 * to be accessed 4 times, which is slow
		 * we can use a view to create a object that will hold all the metadata of a file so you will then only have to 
		 * read the file once, rather than for instance above 4 times.
		 * a view is actually a object that holds metadata about a path
		 * All atributes objects extends BasicFileAtributes
		 * we are using 
		 * 
		 */
		System.out.println("Improve access with views");
		Path path=Paths.get("C:/Original/MyFile.txt");
		try {
			/*
			 * this creates a object that holds the atributes of the file MyFile.txt
			 * after this, we not longer need to access the file MyFile.txt
			 * readAtributes() means we can only read the metadata (is it a executable, is it a symbocl file, is it a regaulr
			 * file, size of file,etc)
			 * but it DOES NOT allow us to change the metadata
			 */
			BasicFileAttributes metaData=Files.readAttributes(path,BasicFileAttributes.class);
			
			System.out.println("is it a directory "+metaData.isDirectory());
			System.out.println("is it a file "+metaData.isRegularFile());
			System.out.println("is it a symbolic link "+metaData.isSymbolicLink());
			System.out.println("is it not a file nor directory nor SymbolicLink "+metaData.isOther());
			System.out.println("file creation time is "+metaData.creationTime());
			
			System.out.println("file last accessed is "+metaData.lastAccessTime());
			System.out.println("File last modified "+metaData.lastModifiedTime());
			/*
			 * this is not available on this system
			 * md5 is another system we could use to uniquelyh identify a file - which we will be using in the very
			 * last lesson in chapter 10
			 */
			System.out.println("unique file identifier(if available) "+metaData.fileKey());
			
			
		}
		catch(Exception e) {
			System.out.println("exception is "+e);
		}
		
		/*
		 * this gets us all the file atributes but this time we can MODIFY the file atributes
		 */
		System.out.println("Modifying Atributes");
		path=Paths.get("C:/Original/Modify.txt");
		BasicFileAttributeView view =
				Files.getFileAttributeView(path,BasicFileAttributeView.class);
		try {
			//atrbiutes of the modify.txt file
			BasicFileAttributes data = view.readAttributes();
			System.out.println("File last modified before change"+data.lastModifiedTime());
			/*
			 * fileTime is particualr point in time in the lifetime of a path
			 * this is 10 seconds after the file was actually modified
			 */
			FileTime lastModifiedTime = FileTime.fromMillis(
					data.lastModifiedTime().toMillis()+10_000);
			/*
			 * first arguement is the changed modified time
			 * second argument is the changed last accessed time
			 * third arguement is the changed last created time
			 */
					view.setTimes(lastModifiedTime,null,null);
					
			System.out.println("File last modified plus 10 seconds"+data.lastModifiedTime()/*.to(TimeUnit.SECONDS)*/);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
