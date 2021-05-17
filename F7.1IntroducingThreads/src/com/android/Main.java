package com.android;
/**
 * /**Pre java 8 method of dealing with threads is dealt with in the "ThreadsOld" java project
 * a Thread is smallest unit of execution that can be scheduled by the operationg system.
 * A process is a group of associated threads that execute in the same shared environment
 * shared environment is threads in the same process that share the same memory space and
 * can communicate with each other.
 * the above means that a static variable is updated by a thread it is then available to ALL
 * threads within the process to read
 * A single-threaded process is one that contains one thread
 * A multi-threaded process is one that contains multiple threads
 * a task is a single unit of work performed by a thread, a thread can perform many 
 * independant task, but only one task at a time
 * all java applications are actually multi threaded
 * System thread
 * this a thread that is created by the JVM and runs in the background of the application 
 * (i.e garbage collection thread). mostly, these threads execute invivsbly to the application
 * developer. when one of these threads encounters an error and cannot recover, it generates
 * an error, as opposed to an exception
 * User Defined Thread
 * This is a thread created by the application developer to accomplish a specific task
 * all applictions up to this point have been multi threaded but they only contained
 * one user defined thread
 * @author noelf
 * * You do not have to use Threads in Programming, what they are used for is that they do increase
	 * productivity as, if used properly, can lead to a significant decrease in time needed to complete
	 * tasks. So if a particular task or tasks are taking for instance 5 minutes to complete, by using threads
	 * you could decrease the time taking to 30 seconds or less for example (if done correctly the increase in
	 * productivity can be even more pronounced that that example). 
	 * the increase in productivity using threads is also dependent on the amount of processors that is on any machine 
	 * running your application (if you have 10 processors on a machine, your application using threads 
	 * will run a lot faster than a machine with
	 * only 1 processor)
 *
 */
public class Main {

	public static void main(String[] args) {
	//	Examples.ex1();
	//	Examples.ex2();
	//	Examples.ex3();
	//	Examples.ex4();
		try {
	//		Examples.ex5();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	//	Examples.ex6();
		Examples.ex7();

	}

}
