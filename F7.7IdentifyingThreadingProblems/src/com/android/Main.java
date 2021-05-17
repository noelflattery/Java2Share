package com.android;

public class Main {

	public static void main(String[] args) {
		/*
		 * The Concurrency API reduces a lot of potential threading issues, it does not however eliminate them
		 */
		System.out.println("Understanding Liveness");
		/*
		 * Liveness is the ability for an application to execute in a timely manner 
		 * i.e if a thread is waiting for another thread to finish its task (await(), sleep(), cyclicBarrier)
		 * if your application contains threads and is executed slowly or hanging three of the issues could
		 * be Deadlock,Starvation and Livelock
		 */
		System.out.println("Deadlock");
		/*
		 *Deadlock occurs when two or more threads are blocked forever
		 *One thread could be waiting for another thread, which may be waiting for the first thread, will crash your
		 *system
		 */
		System.out.println("starvation");
		/*
		 * this is where a single thread is perpetually denied access to a shared resource or variable because other
		 * threads are constantly accessing some resource that blocks a thread
		 */
		System.out.println("LiveLock");
		/*
		 * this is a deadlock that results in your program hanging, in that the threads keep trying to access and complete
		 * a task, which they can NEVER finish
		 */
		System.out.println("Managing Race conditions ");
		/*
		 * this is when two tasks that should happen sequenetially (one after another) are completed at the same time.
		 * i.e two users trying to register the same username, which could result in both users have the same username.
		 * say the user has a username of "timmy1979" and another user at the same time wants the username "timmy1979". 
		 * you could end up with neither been awarded the username, you could end up with both been awaring the username
		 * one solution for this is to just award the name to one of them
		 * or a more elegant is to use a singleton, the username is a singleton, so only one thread can access this variable
		 * or assign a value to this variable at a time.
		 */

	}

}
