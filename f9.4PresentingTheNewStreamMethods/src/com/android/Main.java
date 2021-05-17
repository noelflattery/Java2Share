package com.android;

public class Main {
	/*
	 * this is all about using streams as we seen in chapter 4 to perform file operations
	 * As streams were a new feature in Java 8, this method of accessing files is also
	 * obviously new to java 8
	 * prior to java 8, if using NIO2 to, for instance search for a file in a directory tree
	 * was a longer and often required to create a seperate class to perform a simple task.
	 * using streams we are often to perform these operations with just one line of code
	 * every record (file and directory) has exactly one parent (with exception of of root
	 * directory i.e c:/ or d:/)
	 * if you want to search, lets say for all the word documents, on a machine, you start at the parent
	 * root directory and then search all the child directories and then they're child directories.
	 * this is known as WALKING or TRAVERSING A DIRECTORY
	 * the starting point is usually at a relevant directory to a application (i.e we have a program installed
	 * on C:/ProgramFiles/MyApp, so we start our search at the MyApp directory and not at the C:/ drive
	 * there are two strategies we can employ for walking a directory tree
	 * DEPTH FIRST
	 * goes from root to an arbitrary leaf then goes back up toward the root, in the processes going down any other
	 * leaf paths they skipped. The "search depth" is the distance from root to current node. for performance reasons
	 * some processes have a maximum search depth to limit how deep the search goes before stopping
	 * BREADTH FIRST
	 * starts at root, then processes all elements at each child level, before proceeding onto next level.
	 * results are then ordered by depth. all nodes at depth 1 are read before all nodes at depth 2, etc 
	 * Java Streams API using DEPTH FIRST with a maximum depth of Integer.MAX_VALUE
	 */
	public static void main(String[]args) {
	//	Examples.ex1();
	//	Examples.ex2();
	//	Examples.ex3();
		Examples.ex4();	
		/*
		 * here are a list of legacy method and they're corresponding NIO.2 method version
		 * 	LEGACY METHOD				NIO.2 METHOD
		 * 	file.exists() 				Files.exists(path)
			file.getName() 				path.getFileName()
			file.getAbsolutePath() 		path.toAbsolutePath()
			file.isDirectory() 			Files.isDirectory(path)
			file.isFile() 				Files.isRegularFile(path)
			file.isHidden() 			Files.isHidden(path)
			file.length() 				Files.size(path)
			file.lastModified() 		Files.getLastModifiedTime(path)
			file.setLastModified(time) 	Files.setLastModifiedTime(path,fileTime)
			file.delete() 				Files.delete(path)
			file.renameTo(otherFile) 	Files.move(path,otherPath)
			file.mkdir() 				Files.createDirectory(path)
			file.mkdirs() 				Files.createDirectories(path)
			file.listFiles() 			Files.list(path)
		 */
	}

}
