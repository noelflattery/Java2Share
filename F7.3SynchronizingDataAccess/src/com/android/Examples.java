package com.android;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.android.Human.Nationality;

public class Examples {
	static int count=0;
	//List of Humans to be used in ex1
	static List<Human>humans;
	static void ex1() {
		//this is a the array of Nationality values as a list
		System.out.println(Arrays.asList(Nationality.values()));
		/*
		 * this creates a list of humans that will contain a Human 
		 * of every nationality
		 */
		humans=Arrays.asList(Nationality.values()).//array of Nationality as a list
				stream().//creates a stream from the list
				map((n)->(//takes the nationality and creates a Human from this
						new Human(
								(int)(Math.random()*100),//age
								Math.random()*10,//weight
								Math.random()*10,//height
								n)//nationality
						
						)).
				collect(Collectors.toList());//saves the stream to a list
		
		
		ExecutorService service=Executors.newFixedThreadPool(20);
		/*
		 * this will end with 10 tasks and a thread for each task, incrementCount runs 10 times. 
		 * which increments the number count by one each time. it starts at 0, however sometimes two threads
		 * may access the same integer value at the same time
		 *say thread t1 and thread t2 access count, when it is 0, at the same time, then you will get two 1's and
		 *it will never reach 10
		 *//*
		 * Race condition
		 * if you have two threads accessing the same  block of code or variable at the same time, and both of these
		 * threads are CHANGING some aspect of the variable or code, you can have no idea what the end result
		 * is going to be
		 * the unexpected result of two task executing at the same time on a block is known as a RACE conidtion
		 */
		 //this will sometimes result in a RACE CONDITION
		try {
		//	Thread.sleep(100);
			for(int i=0;i<10;i++)
				//this is 10 tasks
				service.submit(()->incrementCount());
		}
		catch(Exception e) {
			
		}
		finally {
			
			System.out.println("amount of threads is "+Thread.activeCount());
			service.shutdown();
		}
	
	}
	
	static void incrementCount() {
		System.out.println(++count);
	}
	
	static AtomicInteger atomCount=new AtomicInteger(0);
	
	static void ex2() {
		/*
		 * this is for making certain objects thread safe
		 */
		System.out.println("Atomic classes");
		/*
		 * Atomic classes and they're instances can only be accessed by one thread at a time. i.e
		 * a int age, can be accessed by many threads at the same time
		 * a AtomicInteger age can only be accessed by one thread at a time.
		 */
		AtomicBoolean atomBool;//boolean value that can only be accessed by one thread at a time
		//can't assign a value directly to a Atomic variable, have to use the new keyword
		AtomicInteger atomInt=new AtomicInteger(200);
		//atomInt=45;//will not compile
		//this is a array of 5 Integers and the array itself can only be accessed by one thread at a time
		AtomicIntegerArray atomAray=new AtomicIntegerArray(5);
		AtomicLong atomLong=new AtomicLong(60_000_000_000l);
		//this is an array of 10 long and the array itself can only be accessed by one thread at at ime
		AtomicLongArray atomArayLong=new AtomicLongArray(10);
		/*
		 * this is an object that can only be accessed by one thread at a time
		 */
		AtomicReference atomDog=new AtomicReference(new Dog());
		/*
		 * there is no AtomicDouble however you can do something like this
		 */
		AtomicReference atomDouble=new AtomicReference(new Double(2.34));
		/*
		 * if you want to make a object thread safe, you can use one of the Atomic classes
		 * all objects and all primitives are not thread safe
		 * you can't do basic mathematical operations (+,-,/,*,++) with Atomic classed numbers
		 * 
		 */
		System.out.println(atomInt);//this is NOT a primitive int or Integer wrapper
	//	System.out.println(atomInt+atomInt);//will not compile
	//	System.out.println(atomInt++);//will not compile
		/*
		 * you have to use the methods of the Atomic classes to do any operations on atomic variables
		 * use get() to get the numeric value of the atomicINt
		 */
		System.out.println(atomInt.get()+atomInt.get());//this will compile
		//set changes the value of an existing atomicInt
		atomInt.set(1000);
		System.out.println("value is now "+atomInt.get());
		System.out.println("getAndSet: sets the new value and returns the old value");
		System.out.println(atomInt.getAndSet(2000));
		System.out.println("incrementAndGet: same as ++count, preincrement operator");
		System.out.println(atomInt.incrementAndGet());
		System.out.println("getAndIncrement: same as count++, post increment operator");
		System.out.println(atomInt.getAndIncrement());
		System.out.println(atomInt);
		System.out.println("decrementAndCount and getAndDecrement operate the exact same way as --count, count--");
		System.out.println(atomInt.decrementAndGet());
		System.out.println(atomInt.getAndDecrement());
		System.out.println(atomInt);
		//our thread pool is set to size 20, so no more than 20 threads operating at the same time
		ExecutorService service=Executors.newFixedThreadPool(20);
		atomCount.set(0);
		/*
		 * this is accessing the atomicINteger atomCount and incrementing each time the 
		 * incrementAtom method is called. as this is a Atomic variable, only one thread can 
		 * access this variable at time, so you cannot get any unexpected outcomes. namely the final
		 * number will always be 10 and there will be no repeating numbers (i.e 1,2,1)
		 */
		try {
			for(int i=0;i<10;i++)
			service.submit(()->incrementAtom());
		}
		catch(Exception e) {
			
		}
		finally {
			service.shutdown();
		}
		
		
	}
	
	static void incrementAtom() {
		System.out.println(atomCount.incrementAndGet());
	}
	
	static void ex3() {
		/*
		 * synchronisation is making a block of code thread safe, so only one thread at a time can
		 * enter a particular block of code
		 * there are two basic types of synchrnoization
		 * Synchronization of a block of code using a Monitor object
		 * Synchronization of a method
		 */
		System.out.println("sychronization");
		System.out.println("using a local object to mark code as being synchronized");
		Dog spot=new Dog();
		
		{//this code is not synchronized and many threads could be accessing the age at the same time
			System.out.println("this is not synchronized");
			int age=45;//age is local to these brackets
		}
		/*
		 * this block of code is synchronized and only one thread at a time can access this code
		 * this is synchronizing with a local object
		 * if we change spot, inside the synchronization block, then the code is no longer
		 * synchronized
		 */
	spot=new Dog();
		synchronized(spot) //what is between the curly brackets is what is synchronized
		{//code can only be accessed by one thread a time starts here
			//if we change the dog object spot, this block of code is no longer synchronized
			spot.dogCount++;
			
		}//code that can only be acccessed by one thread at a time ends here
		
		spot=new Dog();
		ExecutorService service=Executors.newFixedThreadPool(15);
		/*
		 * It is preferable to use a PRIVATE FINAL object as the object that marks a block of code
		 * as synchronized. As it's final private this MONITOR OBJECT cannot be accessed outside of 
		 * the class and also cannot be changed. if you could change this object, that would mean
		 * that as soon as you change the object, your block of code is no longer synchronized
		 */
		count=0;
		System.out.println("using obj_lock to synchronize code");
		//instead of using atomic numbers we are synchronizing this block of code
		synchronized(OBJ_LOCK) {
			/*
			 * this block of code is synchronized, so only thread at at ime can access this block
			 */
			for(int i=0;i<10;i++)
				service.submit(()->incrementCount());
			service.shutdown();
		}
		/*
		 * this is using the Examples class to synchronized this block of code
		 */
		System.out.println("second block is not synchronized");
		count=0;
		synchronized(Examples.class) 
		{/*
			 * this synchronizes the creation of the threads, but not the
			 * execution, 
			 * the threads are created inside the synchronization block but all we have done
			 * here is any thread external to these threads can only access these threads
			 * one at a time
			 */
			service=Executors.newFixedThreadPool(15);
			for(int i=0;i<10;i++)
				service.submit(()->incrementCount());
			service.shutdown();
		}
		
		
		
	}
	private static final Object OBJ_LOCK=new Object();
	Integer number=0;
	static Double myDouble=4.5;
	void useSync() {
		/*
		 * as long as it's not a static method, you can use the keyword "this" to mark a block of 
		 * code as being synchronized. if we create an object of the examples class and then use
		 * that object to call this method, this is the object that will synchronize this block 
		 * of code
		 */
		synchronized(this) 
		{
			
		}
		/*
		 * you can both static and non static objects to synchronize a block of code
		 * YOU CAN'T USE A PRIMITIVE
		 */
		synchronized(number){
			
		}
		
		synchronized(myDouble) {
			
		}
		
		
	}
	
	static void ex4() {
		System.out.println("synchronized methods");
		
		count=0;
		ExecutorService service=Executors.newFixedThreadPool(25);
		Examples ex1=new Examples();
		try {
			for(int i=0;i<10;i++) 
			{/*
			as the method statSyncCount is synchronized this will only allow one thread at at ime
			to enter the method, so no duplicate numbers are produced and will always end up at 20
			*/
				service.submit(()->statSyncCount());//this gets as far as 10
				service.submit(()->ex1.syncCount());//this gets as far as 20
				/*
				 * this code is NOT synchronized so you will eventually see numbers appearing twice
				 * and will NOT get as far as 20
				 */
			//	service.submit(()->incrementCount());
			//	service.submit(()->incrementCount());
			}
		}
		finally {
			service.shutdown();
		}
		
	}
	
	private synchronized void syncCount() {
	//	System.out.println("non static synchronized ");
		System.out.println(++count);
	}
	
	static synchronized void statSyncCount() {
	//	System.out.println("static synchronized");
		System.out.println(++count);
		
	}
	
	private void nonSyncCount() {
		System.out.println(++count);
	}
	
	private void nonSync(){
		
	}
	
	static void ex5() {
		System.out.println("cost of synchronisation");
		/*
		 * synchronization can be useful, but it is costly in terms that is taking a multi threaded
		 * programn and synchronization is about getting your program to behave like a single
		 * threaded application.
		 * Synchronization is about protected data integrity at the cost of performance
		 */
		LocalTime before1=LocalTime.now();
		Examples ex1=new Examples();
		count=0;
		ExecutorService service=Executors.newFixedThreadPool(10);
		for(int i=0;i<500_000;i++) {
			service.submit(()->statSyncCount());//synchonized method
			service.submit(()->ex1.syncCount());//synchronized method
			service.submit(()->ex1.useSync());//a method with synchronized blocks inside it
		}
		LocalTime after1=LocalTime.now();
		service.shutdown();
/*		LocalTime before2=LocalTime.now();
		service=Executors.newFixedThreadPool(10);
		count=0;
		for(int i=0;i<500_000;i++) {
			service.submit(()->ex1.nonSyncCount());
			service.submit(()->incrementCount());
		}
		LocalTime after2=LocalTime.now();
*/		try {
			Thread.sleep(30000);//putting system thread to sleep for 10 seconds
		}
		catch(Exception e) {
			
		}
		finally {
			if(!service.isShutdown())
				service.shutdown();
		}
		
		System.out.println("first loop took from "+before1+" to "+after1);
		
	//	System.out.println("second loop took from "+before2+" to "+after2);
		
		
	}
	
	
	static void ex6() {
		Examples ex1=new Examples();
		LocalTime before2=LocalTime.now();
		ExecutorService service=Executors.newFixedThreadPool(10);
		count=0;
		for(int i=0;i<500_000;i++) {
			service.submit(()->ex1.nonSyncCount());
			service.submit(()->incrementCount());
			service.submit(()->ex1.nonSync());
		}
		LocalTime after2=LocalTime.now();
		try {
			Thread.sleep(30000);
		}
		catch(Exception e) {
			
		}
		finally {
			if(!service.isShutdown())
				service.shutdown();
		}
		System.out.println("second loop took from "+before2+" to "+after2);
		
	}
	//static MyThreads thread=new MyThreads();
	
	static void ex7() {
		
		ExecutorService service=null;
/*		for(int i=0;i<4;i++)
			service.submit(task1);*/		
		try {
		//	Thread.sleep(1000);
			System.out.println("second synchronized block");
			count=0;
			
			service=Executors.newFixedThreadPool(2);
			MyThreads thread=new MyThreads();
			Runnable task1=()->{
					thread.increment();
					thread.getValue();
			//		System.out.println("value is "+thread.getValue());
				};
				Thread.sleep(100);
			synchronized(OBJ_LOCK) {

//			synchronized(OBJ_LOCK) {
					for(int i=0;i<4;i++)
						service.submit(task1);
				}			
	//	}
		}
		catch(Exception e){
			
		}
		finally {
	//		if(service.)
			service.shutdown();
		}	
	}
	
	
	static void ex8() {
		ExecutorService service=null;
		/*		for(int i=0;i<4;i++)
					service.submit(task1);*/		
				try {
				//	Thread.sleep(1000);
					System.out.println("second synchronized block");
					count=0;
					
					service=Executors.newFixedThreadPool(2);
					MyThreads thread=new MyThreads();
					Runnable task1=()->{
							thread.increment();
							thread.getValue();
					//		System.out.println("value is "+thread.getValue());
						};
						Thread.sleep(100);
					synchronized(OBJ_LOCK) {

//					synchronized(OBJ_LOCK) {
							for(int i=0;i<4;i++)
								service.submit(task1);
						}			
			//	}
				}
				catch(Exception e){
					
				}
				finally {
			//		if(service.)
					service.shutdown();
				}	
		
	}
}

class MyThreads{
	private int i=0;
	public synchronized void increment() {
		
			i++;
		
		
		System.out.println(i);
	}
	public synchronized int getValue() {
		System.out.println("value is "+i);
			return i;
		
		
	}
}
