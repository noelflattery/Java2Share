package com.android;

public class Examples {
	
	static void ex1() {
		System.out.println("Runnable");
		/*
		 * any class that wishes to use threads has to implement the Runnable interface
		 * @FucntionalInterface 
		 * public interface Runnable{
		 * 			void run();
		 */
		Runnable r1=()->System.out.println("R1 runnable lambda");
		Runnable r2=()->{
			System.out.println("r2 runnable lambda");
		};
		Runnable r3=()->{
			System.out.println("r3 runnable lambda");
			return;
		};
		
		r1.run();
		r2.run();
		r3.run();
	}
	
	static void ex2() {
		/*
		 * /*
		 * creating a thread is a two step process, first  you define the thread with the corresponding task to
		 * be done, then you start the task by using the Thread.start()method
		 * these are two different threads, using two different classes
		 * can guarantee order within the thread itself (always t1 goes from 0 to 9,
		 * t2 always goes from 10 to 19, but can't guarantee the order of the threads called
		 * themselves, in this example we could have 10 appearing before 9, as they are two
		 * seperate threads, or 100 before 19 as again these are two seperate threads.
		 * but the order of the first thread will always go 0 to 9, but you may have other
		 * threads returning results in the middle of that thread. we don't know the exact 
		 * layout of the printout until runtime
		 */
		/*
		 * only a class that implements runnable can be including as an argument when creating a thread
		 * PrintData implements runnable, so this can be included
		 */
		Thread t1=new Thread(new PrintData());//this creates the thread
		System.out.println("first thread");
		t1.start();//this causes the run method in printData to run
		System.out.println("second thread");
		new Thread(new PrintData()).start();
		/*
		 * a lambda implementation of the Runnable interface (this is a task you want a thread to complete)
		 */
		Runnable r1=()->System.out.println("R1 runnable lambda");
		Thread t2=new Thread(r1);
		//this executes the thread
		t2.start();
		/*
		 * this is a less common way to create a thread, MyThreads extends Thread
		 */
		new MyThreads().start();
		MyThreads myT=new MyThreads();
		myT.start();
		/*
		 * in most cases you should implemetn the Runnable interface rather than extend the Thread class
		 */
	}
	static int counter=0;
	
	static void ex3() {
		//this statement is running on the system thread
		System.out.println("threads without sleep");
		//this is a user defined thread in a anonymous inner class
		new Thread(
				()->{
					for(int i=0;i<500_000;i++) {
						counter++;
					}
				}
				).start();
		int wCounter=0;
		/*
		 * this while loop is a task on the system thread, so it will start while the user defined thread is still
		 * running. so our for loop above and our while here at running at the same time.
		 * the while loop will keep executing until the for loop increments counter to be above 500,000. Also you
		 * can't guarantee how many times the while loop will execute, run this numberous times and you will see that the 
		 * amount of times the while loop runs will be different each time
		 */
		while(counter<500_000) {
			System.out.println("not reached yet");
			wCounter++;
		}
		System.out.println("reached");
		System.out.println("while loop has executed "+wCounter+" times");
		
	}
	
	static void ex4() {
		System.out.println("all tasks are on our own user defined threads");
		new Thread(//our first user defined thread
				()->{
					for(int i=0;i<500_000;i++) {
						counter++;
					}
				}
				).start();
		
		new Thread(//our second user defined thread
			()->{
					int wCounter=0;
					while(counter<500_000) {
						System.out.println("not reached yet");
						wCounter++;
					}
					System.out.println("reached");
					System.out.println("while loop has executed "+wCounter+" times");	
				}
				).start();
		
		/*
		 * this while loop is a task on the system thread, so it will start while the user defined thread is still
		 * running. so our for loop above and our while here at running at the same time.
		 * the while loop will keep executing until the for loop increments counter to be above 500,000. Also you
		 * can't guarantee how many times the while loop will execute, run this numberous times and you will see that the 
		 * amount of times the while loop runs will be different each time
		 */
		
	
	}
	
	static void ex5() throws InterruptedException{
		//this statement is running on the system thread
				System.out.println("threads without sleep");
				//this is a user defined thread
				new Thread(
						()->{
							for(int i=0;i<500_000;i++) {
								counter++;
							}
						}
						).start();
				int wCounter=0;
				/*
				 * this while loop is a task on the system thread, so it will start while the user defined thread is still
				 * running. so our for loop above and our while here at running at the same time.
				 * the while loop will keep executing until the for loop increments counter to be above 500,000. Also you
				 * can't guarantee how many times the while loop will execute, run this numberous times and you will see that the 
				 * amount of times the while loop runs will be different each time
				 * this system thread is accessing our own user defined thread
				 */
				while(counter<500_000) {
					System.out.println("not reached yet");
					wCounter++;
					/*
					 * this can only accesse other threads once every 1 milisecond
					 * thread.sleep() takes an int which is the amount of time this thread waits before accessing
					 * another thread
					 * it's consdiered bad coding practise NOT TO PUT some sort of delay
					 * after the first iteration of this loop, this thread (which is the system theread)
					 *  will go to sleep for 100 miliseconds, so will
					 * not access any other thread for 100 miliseconds
					 */
					Thread.sleep(100);
				}
				System.out.println("reached");
				System.out.println("while loop has executed "+wCounter+" times");
	}
	
	static void ex6() { 
		counter=0;
		//system thread
		System.out.println("all tasks are on our own user defined threads");
		new Thread(//THREAD 1  our own thread
				()->{
					for(int i=0;i<500_000;i++) {
						counter++;
					}
				}
				).start();
		
		new Thread(//THREAD 2 our own thread
			()->{
					int wCounter=0;
					try {
						while(counter<500_000) {
							System.out.println("not reached yet");
							wCounter++;
							/*
							 * this can throw an InterrruptedException, so has to be put in a try catch block
							 * or have to have a throws in the method signature
							 */
							Thread.sleep(100);
					}
					}
					catch(Exception e) 
					{
						System.out.println(e);
					}
						
					
					System.out.println("reached");
					System.out.println("while loop has executed "+wCounter+" times");	
				}
				).start();
	/*	try {
			Thread.sleep(100);
		}
		catch(Exception e) {
			System.out.println(e);
		}*/
		
		System.out.println("counter is "+counter);
	}
	//counter for first thread
	static int counter1=0;
	//counter for second thread
	static int counter2=0;
	
	static int counter3=0;
	static void ex7(){
		System.out.println("three threads and accessing variables in each thread");
		
		Thread t1=new Thread(
				()->{
					System.out.println("t1 thread has started");
					for(int i=0;i<=1_000_000;i++) {
						counter1++;
					}
					System.out.println("in thread1 access counter2 "+counter2);
					System.out.println("in htread1 access counter3 "+counter3);
				}
				);
		Thread t2=new Thread(
				()->{
					counter2=2_000_000;
					System.out.println("t2 has started ");
					//counter1=2_000_000;
					for(int i=2_000_000;i<=3_000_000;i++) {
						counter2++;
					}
					
				}
				);		
		Thread t3=new Thread(
				()->{
					counter3=4_000_000;
					System.out.println("t3 has started");
					for(int i=4_000_000;i<=5_000_000;i++) {
						counter3++;
						/*
						 * t3 is accessing values in t1 and t2 and changing them, which leads to complete and utter
						 * chaos and impossible to predict the final value of 
						 * counter2 and counter1
						 */
				//		counter2++;
					//	counter1++;
					}
				}
				);
		t1.start();
		t2.start();
		t3.start();
	/*	try {
			Thread.sleep(100);
		}
		catch(Exception e) {
			System.out.println(e);
		}*/
		/*
		 * the three threads have each a loop, that could be all operating at the same time.
		 * this is a thread that contains a loop that goes from 0 to 1 million. this is the system thread that is accessing the t1 thread
		 * at a particular point in time, its usually here when we run the code 0
		 */
		System.out.println("before system thread sleep");
		System.out.println("counter1 is "+counter1);
		/*
		 * at the same point in time this thread is running and contains a loop that goes from 2 million to 3 million. this is the system thread
		 * taht is accessing the t2 thread at the same point in time 
		 */
		System.out.println("counter2 is "+counter2);
		System.out.println("counter3 is "+counter3);
		try {
			/*
			 * the only way to ensure a final value for each of these counters is to put the system thread to sleep for a set period of time
			 * (usually 100 miliseconds is enough)
			 * so the system thread will sleep for 100 miliseconds at this point and then check the values of counter1,counter1,counter3
			 * which should read 
			 * 	counter1 is 1000001
				counter2 is 3000001
				counter3 is 5000001
			 */
			Thread.sleep(100);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("after sleep");
		System.out.println("counter1 is "+counter1);
		System.out.println("counter2 is "+counter2);
		System.out.println("counter3 is "+counter3);
		
		
	}

}
