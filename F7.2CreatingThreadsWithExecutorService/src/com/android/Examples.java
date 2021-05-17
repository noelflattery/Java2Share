package com.android;

import java.util.concurrent.ExecutorService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples {
	
	private static final String Callable = null;

	static void ex1() {
		System.out.println("ExecutorService");
		/**
		 * ExcecutorService is a an Interface that creates and manages threads for any developer.
		 * you first obtain an instance of the ExecutorService interface and then you send tasks
		 * to be processed
		 * An executor service can take many tasks, which will always be something that implements
		 * the runnable interface
		 * you use the Executor factory class to create instances of the ExecutorService
		 */
		System.out.println("single thread execution");
		/*
		 * this is the object we will use to manage a thread
		 * we create these objects outside of the try catch, so we will then be able to access these objects
		 * outside of the try block as we will be closing them in the finally block
		 */
		ExecutorService service=null;
		/*this is the object we will use to manage a second thread
		 * 
		 */
		ExecutorService service2=null;
		try {
			/*
			 * you can't use try with resources on a executorservice as executor does NOT implement
			 * autoclosable
			 */
			/*
			 * you have to say what type of executor you want, this is a executor for a single thread
			 * if you want a executor for multiple threads, you would use NewFixedThreadPool
			 * newSingleThreadExecutor() is the simpliest executor you can careate. 
			 * this will result in a single thread, so all tasks in this thread will run concurrently
			 * you can add as many tasks as you want to this thread, a task is an object that 
			 * implements the Runnable interface, implement void run returns nothing takes no variables
			 * 
			 */
			service=Executors.newSingleThreadExecutor();
			service2=Executors.newSingleThreadExecutor();
			//first task added to thread
			/*
			 * execute takes a object that implements the Runnable interface, can be a lambda, can be 
			 * object a class that implements Runnable or can be a full nested inner class
			 * this creates only one thread, which means everything will be in order.
			 * Execute is considered a "Fire and forget" method as once its is submitted the results
			 * are not directly avaialable to the calling thread
			 */
			service.execute(()->System.out.println("using our first executor service"));
			//second task added to thread
			service.execute(new Dog());
			//first task added to new thread
			service2.execute(()->System.out.println("service 2 executing"));;
			//third task added to older thread
			service.execute(()->{
				Stream.iterate(0, i->i+1).limit(10).forEach((i)->System.out.println("i is "+i));
			}
			);	
		}
		finally
		{
			
			try {
				/*
				 * this is sleeping the system thread
				 */
				Thread.sleep(100);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			/*
			 * before the system thread attempts to print this, it will sleep for 100 miliseconds
			 */
			System.out.println("finally runs");
			/*
			 * isShutDown returns true if the thread is closed false if not closed, so this is saying
			 * if this service is NOT shutdown
			 */
			if(!service.isShutdown()) {
			//	service.shutdown();
				/*
				 * this shutdown both services which closes both threads
				 * if we don't have a shutdown() the service will keep running indefinately, which
				 * you may want if there is some thread that that contains tasks that need to be
				 * constantly operating in the background of your app
				 */
				service2.shutdown();
				service.shutdown();		
			}
			System.out.println("service is shutdown "+service.isShutdown());
					
		}
		/*
		 * ExecutorService does NOT implement AutoClosable so you cannot use try with resources with
		 * the ExecutorService
		 */
		System.out.println("after finally");
	}//end of ex1
	
	public static ExecutorService statService=null;
	public ExecutorService oService=Executors.newSingleThreadExecutor();
	
	static void ex2() {
		System.out.println("static executorService");
		statService=Executors.newSingleThreadExecutor();
		Examples myEx=new Examples();
		myEx.oService.execute(()->System.out.println("oservice thread service "));;//first taks on this thread
		try {
			/*
			 * this the first task on our thread
			 */
			statService.execute(()->System.out.println("accessing static service "));//first task on this thread
			myEx.oService.execute(()->System.out.println("second task on this thread"));//second task on this thread
			/*
			 * the Cat constructor adds another task to the static statService thread
			 */
			Cat myCat=new Cat();
			//statService=Executors.newSingleThreadExecutor();
		//	statService.execute(();
		}
		finally {
			if(!statService.isShutdown()) {
				statService.shutdown();
				myEx.oService.shutdown();
				System.out.println("statService shutDown ? "+statService.isShutdown());
			}
			
			//statService=Executors.newSingleThreadExecutor();
			/*
			 * this wil generate RejectedExecutionException as this service has already been shutdown and the
			 * thread it was managing has been closed
			 */
			try {
				statService.execute(()->System.out.println("next task on this thread"));;
			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				
			}
			/*
			 * this creates a new Thread that statService will manage
			 */
			Dog spot=new Dog();
			statService=Executors.newSingleThreadExecutor();
			statService.execute(()->System.out.println("first task on new thread"));//first task
			statService.execute(()->System.out.println("second task on new thread"));//second task
			//in cat class constructor a thrid task is added to the thread
			Cat myCat=new Cat();
			//Dog implements Runnable so this can be put in an execute as an arguement, 
			statService.execute(spot);//fourth task
		//	statService.shutdown();
			/*
			 * you should only have one way to shutdown the service
			 */
			shutDownThredExe();	
		}
	}
	
		static private void shutDownThredExe() {
			if(!statService.isShutdown())
				statService.shutdown();
		}
		
static int count=0;
		static void ex3() {
			System.out.println("submit");
			ExecutorService service=Executors.newSingleThreadExecutor();
			/**
			 * sumbit() is like execute in that it adds tasks to a thread, but unlike execute it returns something
			 * called a FUTURE object, instad of void
			 * A future object can hold information about whether a task is completed or not, can be also
			 * used with Scheduling (tasks that will happen at some point in the future at regular intervals, i.e
			 * your screensaveer will launch after 5 minues of inactivity, check all connections on laptop every
			 * 5 minutes,
			 * you should use Submit() whenever possible over execute
			 */
			
			try {
				//Interface Future<V> 
				//? means it can be any object, but it has to abe a object that implements the Runnable interface
				Future<?>mySubmit;
			//	Future<Dog>dogSubmit;//strange that you have to cast it to be a Dog below
		//		Future<Cat>catSubmit;//even if cast to Cat this will not compile
		//		dogSubmit=(Future<Dog>) service.submit(new Dog());
				//submit takes an object that implements the Runnable interface
				mySubmit=service.submit(()->System.out.println("running submit"));;//task 1
				
				service.submit(new Dog());//second task
				service.submit(()->System.out.println("third task on submit"));//third task
				System.out.println("isDone");
				/*
				 * Returns true if this task completed.Completion may be due to 
				 * normal termination, an exception, orcancellation -- in all of these cases, this method will return true.
				 */
				System.out.println(mySubmit.isDone());//this is just about task 1
				
				System.out.println("isCancelled");
				/*
				 * isCancelled returns true if the task was completed and not cancelled before completion
				 * returns false if the task was cancelled before completion
				 */
				System.out.println("is first task cancelled before completion "+mySubmit.isCancelled());
				/*
				 * this is how we cancel a particular task associated with this future object
				 */
				System.out.println(mySubmit.cancel(true));
			
			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				if(!service.isShutdown()) {
					service.shutdown();
				}
			}
		}
		
		static int number=10;
		static int sum=2;	
		static void ex4() {
			System.out.println("Introducing callable");
			ExecutorService service=Executors.newSingleThreadExecutor();
			/*
			 * if your future object has a particular type (not a question ? or just object) then you can't 
			 * use the submit() method that takes a runnable object, as a runnable object returns void, and
			 * this object here for instance needs an Integer
			 */
		//	Future<Integer>futInt=service.submit(()->System.out.println("runnable returns nothing"));
			/**
			 * we  use the overloaded submit() method that takes an object that implements the CALLABLE 
			 * interface
			 * the Callable interface is simlar to the runnable interface except that the call() returns a value
			 * and also can throw an exception
			 * looks like this
			 *  @FunctionalInterface public interface Callable<V> {
				V call() throws Exception;
			}
			 */
			int num=12,num2=44;
			int total=0;
			Runnable runMe=()->System.out.println("runMe");
			Callable<Integer>sumCall=()->num+num;
			try {
				Future<Integer>result=service.submit(sumCall);//first task added to thread
				Future<Integer>result2=service.submit(()->num*num);//second task added to thread
				Future<Integer>result3=service.submit(()->num2-num);//third task added to thread
				Future<Integer>result4=service.submit(()->num2/num);//fourth task added to the threa
				/*
				 * if you want to get the VALUE of a future object (in this case they are all Integers)
				 * we use the .get() method
				 */
				System.out.println("first task result"+result.get());
				System.out.println("second task result"+result2.get());
				System.out.println("third task result"+result3.get());
				System.out.println("fourth task result"+result4.get());
				total=result.get()+result2.get()+result3.get()+result4.get();
				System.out.println(total);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				if(!service.isShutdown())
					service.shutdown();
			}
			total=0;
			service=Executors.newSingleThreadExecutor();
			number=10;sum=2;
			try {
				Future<Integer>result=service.submit(()->{
					return sum=number+sum;//return the number 12, assign 12 to sum
				}
			);//task 1
				Future<Integer>result2=service.submit(
						()->{
							return sum=sum*sum;//this then multiples sum, which is 12 by sum, which 144
						}
						
						);//task2
				
				total=result.get()+result2.get();
				/*
				 * this takes two tasks, the first task produces teh number 12, which is used by the second
				 * and multiplied by itself
				 * which gives us
				 * task1 12
				 * task2 144
				 * 12+144=156
				 */
				System.out.println("result of all tasks is "+total);
			}
			catch(Exception e) {
				
			}
			finally{
				if(!service.isShutdown())
					service.shutdown();
			}
			
		}
		
		static void ex5() {
			ExecutorService service=Executors.newSingleThreadExecutor();
			try {
				//future object refers to a task
				Future<?>mySubmit=service.submit(()->{//thiis a submit with a runnabloe
					System.out.println("running sumbit ");
					Stream.iterate(0, i->i+1).
							limit(1000000).
							collect(Collectors.toList());
				});
				
			//	mySubmit.get();
				/*
				 * this time units you can use are TimeUnit.NANOSECONDS
				 * TimeUnit.MICROSECONDS
				 * TimeUnit.MILLISECONDS
				 * TimeUNit.SECONDS
				 * TimeUnit.MINUTES
				 * TimeUnit.HOURS
				 * TimeUnit.DAYS
				 * the maximum amount of time allowed for this task is 10 miliseconds, if its not completed
				 * in 10 miliseconds, which is .01 of a second, it throws TimeOutException
				 */
				mySubmit.get(100, TimeUnit.MILLISECONDS);
				System.out.println("our list has been created");
				Future<Integer>mySubmit2=service.submit(()->2+2);//this is a submit with a callable
				System.out.println(mySubmit2.get());
			}
			catch(Exception e) {
				System.out.println("exception caught");
				System.out.println(e);
			}
			finally {
				if(!service.isShutdown())
					service.shutdown();
			}
			
		}
		
		static void ex6() {
			/*
			 * system thread tasks
			 */
			int total=0;
			count=0;
			ExecutorService service=Executors.newSingleThreadExecutor();
			ExecutorService service2=Executors.newSingleThreadExecutor();
			ExecutorService service3=Executors.newSingleThreadExecutor();
			ExecutorService service4=Executors.newSingleThreadExecutor();
			ExecutorService service5=Executors.newSingleThreadExecutor();
			/*
			 * last point in the system thread before we may or may not sleep the thread
			 */
		/*	Optional<Integer>num=*/
			/*
			 * anything not on either of our two below threads is then on the system threa
			 * if a our program was running from top to bottom with no concurrency this would print out
			 * count is in first thread 0//this is the original value of the static int count
			 * in system thread first time 99//the stream in the first thread will assign 99 to count
			 * count in second thread 99//count is still 99
			 * in system thread second time 0//the stream in the second thread will assign 0 to count
			 * however what we actually get is 
			 * count is in first thread 0//
			 * in system thread first time 0
			 * count in second thread 0
			 * in system thread second time 0
			 * what is happening is that the system thread is performing all its tasks while 
			 * thread 1 is still performing its task, which will change the value of count to 99.
			 * so the system thread completes all of its tasks before thread 1, so the value of count
			 * will still be 0 by time all of the system threads task are complete.
			 */
			try {
				service.submit(()->{//task submitted to thread 1
				Optional<Integer>num=Stream.generate(()->(int)(Math.random()*100)).
					limit(200_000).max((i1,i2)->i1-i2);
				System.out.println("count is in first thread "+count);
				count=num.get();
			});
				/*
				 * if we put a sleep in here, this will sleep the system thread for 100 miliseconds
				 * from the previous point in the system thread
				 * this will cause the first 
				 */
			Thread.sleep(100);
				//task on system thread
			System.out.println("in system thread first time "+count);
			//task submitted to thread 2
			
			service2.execute(()->{
				try {
				
				}
				catch(Exception e) {
					System.out.println(e);
				}
				
				Optional<Integer>num=Stream.generate(()->(int)(Math.random()*100)).
						limit(200000).min((i1,i2)->i1-i2);
					System.out.println("count in second thread "+count);
					count=num.get();
			}
					
			);//end of service2
			Thread.sleep(100);
			//task on system thread
			System.out.println("in system thread second time "+count);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				if(!service.isShutdown()) {
					service.shutdown();
					service2.shutdown();
				}
			}
			
	
		}
		
		static void ex7() {
			
			ExecutorService service=Executors.newSingleThreadExecutor();
			ExecutorService service2=Executors.newSingleThreadExecutor();
			ExecutorService service3=Executors.newSingleThreadExecutor();
			/*
			 * this takes the time before and after both thread tasks have been executed and we see that 
			 * the tasks in the second thread are completed before the tasks in the first thread.
			 * the first thread is produced 20 million doubles, which are larger data types and take long to handle 
			 * and compute
			 * the second thread produces 20 million ints, which are smaller data types and take less time to handle 
			 * and compute
			 */
			try {
				LocalTime now=LocalTime.now();
				//produces 20 million random double numbers
				service.submit(()->{
					System.out.println("before first thread "+now);
					Stream.generate(()->Math.random()*100).
					limit(20_000_000).
					collect(Collectors.toList());
					System.out.println("after first thread "+LocalTime.now());
				});
				/*
				 * you can sleep the system thread, whcih means the second will not be called until 1 second after the 
				 * first thread starts to execute
				 */
				Thread.sleep(1000);
				//productes 20 million random int numbers between 0 and 99 inclusive
				service2.submit(()->{
					System.out.println("before second thread "+LocalTime.now());
					Stream.generate(()->(int)(Math.random()*100)).
					limit(20_000_000).
					collect(Collectors.toList());
					System.out.println("after second thread "+LocalTime.now());
				});
				
				
				
			}
			catch(Exception e) {
				System.out.println("exception is "+e);
			}
			finally {
				service.shutdown();
				service2.shutdown();
			}
			try {
				service.execute(()->{
					try {
						Thread.sleep(100);
					}
					catch(Exception e) {
						
					}
				
				System.out.println("print this thread out");
			});
			}
			catch(Exception e) {
				
			}
			
			
		}
		
		static void ex8() {
			
			
			System.out.println("using sumbit to sleep threads");
			/*
			 * this submit uses a callable, a callable returns an object and throws exception, which means you can have
			 * a Thread.sleep command inside this service
			 */
			ExecutorService service=Executors.newSingleThreadExecutor();
			ExecutorService service2=Executors.newSingleThreadExecutor();
			
			LocalTime now=LocalTime.now();
			//produces 20 million random double numbers
			System.out.println("submit with a callable");
			/*
			 * if your submit returns ANY TYPE OF OBJECT, EVEN NULL, then this is submit with a Callable, which throws
			 * InterruptedException, the call method in the callable interface looks like this
			 * V call()throws InterruptedException
			 */
			try {
			//	Thread.sleep(100);
				service.submit(()->{//this is using the call method from callable
				//	Thread.sleep(100);
								System.out.println("before first thread "+now);
								Stream.generate(()->Math.random()*100).
								limit(20_000_000).
								collect(Collectors.toList());
								System.out.println("after first thread "+LocalTime.now());
								return null;
			});//end of first thread
				
			/*
			 * as long as your thread is inside a try catch block, you can use thread.sleep in a submit with a callable
			 * as callable throws InterruptedException, which means that it looks for an enclosing try/catch block to deal 
			 * with any exception or the method that contains these threads, could THROWS exception
			 */
				//Thread.sleep(100);//not always a good idea to put the system to sleep
				/*
				 * submit returns a future Object
				 * the submit will runnale returns a this sort of Future object
				 * Future<?>futobj
				 * the submit with a Callable returns a future object of a particualr type
				 * ie. here the type is Integer, which means that we have to return an Integer or null
				 */
				Future<Integer>futInt=service2.submit(()->{
					/*
					 * nearly always a better idea to put your own threads to sleep, as you exactly what they are doing, 
					 * the system thread could be managing all other sorts of services, processes
					 * makes sense to put your thread to sleep at start, before the work is done, as at the end of the thread
					 * the work is already done
					 */
										Thread.sleep(1000);
										System.out.println("before second thread "+LocalTime.now());
										//Max returns an Optional Integer
										Optional<Integer>optInt=Stream.generate(()->(int)Math.random()*100).
												limit(20_000_000).
												max((i1,i2)->i1-i2);
										System.out.println("after second thread "+LocalTime.now());
									//	return null;
										return optInt.get();
				}
						
						);//end of secon thread
				
				
						
		
				
				
			}
			catch(Exception e) {
				System.out.println("exception is "+e);
			}
			finally {
				service.shutdown();
				service2.shutdown();
			}
			
		}
		
		static void ex9() {
			ExecutorService service=Executors.newSingleThreadExecutor();
			try {
				//submit using runnable
				service.submit(()->System.out.println("calling first submit "));//first task
				//execute can only use runnable
				service.execute(()->System.out.println("calling first execute on same thread"));;//second task
				//sumbit using callable with type Integer
				Future<Integer>futInt=service.submit(()->2+2);//third task
				System.out.println(futInt.get());
				/*
				 * this waits for 10 seconds after all the tasks should have completed, if they are not completed
				 * in this time it will geneate a TimeOutException
				 */
				if(!service.isShutdown())
					service.awaitTermination(10, TimeUnit.SECONDS);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally{
				if(!service.isShutdown())
					service.shutdown();
				System.out.println("finally runs");
			}
			
			
		}
		
		static void ex10() {
			System.out.println("scheduling");
			count=0;
			/*
			 * this is the object we use to control threads that have tasks that will run at some point in the future
			 */
			ScheduledExecutorService service=Executors.newSingleThreadScheduledExecutor();
			/*
			 * scheduling certain tasks to be carried out at certain times
			 * 
			 */
			try{
				//to see our schedulerExecutor in action we need to know what time we start at 
				System.out.println("time is "+LocalTime.now());//our start time
				//our first task to be added to the thread
			Runnable task1=()->{
				System.out.println("time of first task is "+LocalTime.now());//five seconds after our start time (approx)
				System.out.println("runnable task count is "+ (++count));
			};
			//our second task to be added to the thread, callable returns an object, here its a string
			Callable<String>task2=()->{
				System.out.println("time of second task is "+LocalTime.now());//Seven seconds after our start time(approx)
				String str="horse "+(++count);
				System.out.println("count is "+count);
				return str;
			};
			int time=5;
			System.out.println("schedule method of the ScheduledExecutorService class");
			/*
			 * we will run the first task, five seconds in the future, this is five from the time it woudl have run if this
			 * was just a normal task on a thread
			 * schedule takes three arguements, a task which can be a runnable or a callable, a amount of time, and a unit of
			 * time (which can be nanoseconds to Days)
			 */
			Future<?>result1=service.schedule(task1, time, TimeUnit.SECONDS);
			/*
			 * we will run the second task, 7 seconds in the future, this is the time it would have run if this was a normal
			 * task on a thread. if this was 5 seconds, it would run the same time as task 1.
			 */
			Future<String>result2=service.schedule(task2, time+2, TimeUnit.SECONDS);
			}
			catch(Exception e) {
				System.out.println("exception is "+e);
			}
			finally {
				if(!service.isShutdown())
					service.shutdown();
			}
			
	/*		ExecutorService service=Executors.newSingleThreadExecutor();
	//		int num=(int) (Math.random()*100);
			try {
				Future<Set<Integer>>futSet=service.submit(
						()->{
							Thread.sleep(1000);
							Set<Integer>mySet=Stream.generate(()->(int)(Math.random()*100)).
									limit(50).
									collect(Collectors.toSet());
							return mySet;
						}
						);//end of submit
			}
			catch(Exception e) {
				
			}
			finally {
				
			}*/	
		}
		
		static void ex11() {
			ScheduledExecutorService service=Executors.newSingleThreadScheduledExecutor();
			count=0;
			try {
				//five task added and executed in this thread
				for(int i=0;i<5;i++) {
					service.schedule(
							()->{/*
								 * at the start of each task, we put the task to sleep for 2 seconds, so the previous task
								 * is given time to finish
								 * we have a lead in time of 4 seconds for the first task, then every other task in this
								 * thread will come at 2 second intervals
								 */
								Thread.sleep(2000);
								System.out.println("count is "+(++count)+"time is "+LocalTime.now());
								if(count>4)
									System.out.println("tasks all complete");
								
								
								//this makes this a callable
								return null;
							},/*
							this will run ALL THE TASKS, approximately 2 seconds ahead of the time it would have run if they
							were normal tasks in a normal string
							so all tasks will run at approximately the same time, if we have no sleep this is what will happen
							comment out the above sleep to see this
							*/
							 2, TimeUnit.SECONDS
							);
					
				}
				
			}
			catch(Exception e) {
				System.out.println("exception is "+e);
			}
			finally {
				if(!service.isShutdown())
					service.shutdown();
			}
		}
		
		static void ex12() {
			ScheduledExecutorService service=Executors.newSingleThreadScheduledExecutor();
			count=0;
			System.out.println("time at start is "+LocalTime.now());
			Runnable task1=()->{
				System.out.println("Runnable task one "+(++count)+" time is "+LocalTime.now());
				};
				/*
				 * this is going to complete tasks
				 * the first task will have a 5 second lead in time
				 * every task after the first task will have a two second delay
				 * make sure all of your tasks would complete in two seconds, as each new task does NOT wait until
				 * the previous task in finished
				 * THIS CAN ONLY TAKE A RUNNABLE
				 */
				service.scheduleAtFixedRate(task1, 5, 2, TimeUnit.SECONDS);
				/*
				 * this will run before the above, as the above task waits 5 seconds and in that five second period
				 * this task completes
				 */
				service.submit(()->System.out.println("our second task"));
				try {
					/*
					 * this is the time period the task will be repeatedly done
					 * the five second lead in time is included in this fifteen seconds, so we only have 10 seconds 
					 * of tasks, which can be 5 tasks, 6 tasks or even 4 tasks
					 * its not a set amount of tasks, its a time limited amount of tasks
					 */
					TimeUnit.SECONDS.sleep(15);
				}
				catch(Exception e) {
					System.out.println("exception is "+e);
				}
				finally{
					/*
					 * if you want a thread to run continuously  you just dont' shutdown the scheduled thread
					 * until you close the app
					 *  comment out this code to see the thread runs continuously
					 */
					
					if(!service.isShutdown())
						service.shutdown();
					System.out.println("service is shutdown at "+LocalTime.now());
				}
			
		}
		
		static void ex13() {
			System.out.println("before any tasks time is "+LocalTime.now());
			ScheduledExecutorService service=Executors.newSingleThreadScheduledExecutor();
			Runnable task1=()->{
				System.out.println("before set creation time is "+LocalTime.now());
				Set<Double>douSet=Stream.generate(()->Math.random()).
						limit(10_000_000).
						collect(Collectors.toSet());
				System.out.println("after set creation time is "+LocalTime.now());	
			};
			/*
			 * each of these tasks will only start after the previous task has been finished and will give a 2 second
			 * delay after the previous task has been finished
			 * the very first task in this service will start immeidately after the previous task
			 * without a TimeUnit.Seconds.sleep() this will continue infinately, or until you shut your app
			 */
			System.out.println("system thread 1");
			/*
			 * the issue with these is that if exceptions are generated during any of these tasks, lets say this produces
			 * 50 tasks and task 25 produces a InterruptedException, this will be a Surpressed Exception
			 */
			service.scheduleWithFixedDelay(task1, 0, 2, TimeUnit.SECONDS);
			System.out.println("system thread 2");
			try {
				TimeUnit.SECONDS.sleep(18);
			}
			catch(Exception e) {
				System.out.println(e);
				/*
				 * e not only contains the primary excpetion, but also an array of supressed exceptions, if they exist
				 * this is an array of type Throwable
				 */
				System.out.println(e.getSuppressed());
				Arrays.asList(
						e.getSuppressed()//array of throwables
						).stream().
				forEach(System.out::println);
				
				
			}
			finally {
				if(!service.isShutdown())
					service.shutdown();
				System.out.println("service is shutdown");
			}
			
		}
		
		static void ex14() {
			System.out.println("increasing concurrency with pools");
			/*
			 * A thread pool is a group of pre-instantiated reusuable threads that can be used to perform
			 * any set of arbitrary tasks
			 * newCachedThreadPool()
			 * newFixedThreadPool(int nThreads)
			 * newScheduledThreadPool(int nThreads)
			 * wherease a single thread executor will usually (but not always) wait until a thread is read to execute
			 * a task, a pooled thread can execute the next task at the same time (concurrently)
			 */
			ExecutorService service =Executors.newCachedThreadPool();
			count=0;
			/*this is used for any application that have may short lived asynchronous tasks (at the same time)
			 * this will create a pool of threads of unbounded sized and will create threads as needed
			 *
			 */
			try {
				service.submit(()->{
					//this submit takes a callable, which has to return something, even null
					//thread 1 starts at this time
					System.out.println("time in first submit is "+LocalTime.now());//all threads start at same time
					System.out.println("submit task 1");
					int i=0;
					for(i=0;i<5_000_000;i++)
						i=i+i;
					System.out.println("i is "+i);
					System.out.println(++count);
					return null;
				});
				service.submit(()->{
					//this submit takes a Runnable
					//thread 2 starts at this time, which is the same as thread 1
					System.out.println("time in second sumbit is "+LocalTime.now());
					System.out.println(++count);
				}
				);
				//this execute takes a Runnable, it can only take a Runnable
				service.execute(()->{
					//thread 3 starts at this time, which is the same as thread 2
					System.out.println("time in first runnable is "+LocalTime.now());
					System.out.println("runnable task 3");
					System.out.println(++count);
				});
				/*
				 * this puts the system thread to sleep for 1 second and while it is asleep, all the other threads
				 * complete all the tasks
				 */
				Thread.sleep(1000);
			
			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				if(!service.isShutdown())
					service.shutdown();
			}
			/*
			 * this is also system thread which will only run after the the Thread.sleep(1000) command, so all the other threads will
			 * have completed by this time, so this will print last
			 */
			System.out.println("amount of threads is "+Thread.activeCount());
		}
		
		static void ex15() {
			System.out.println("newFixedThreadPool");
			/*
			 * takes a number of threads and allocates them all upon creation, as long
			 * as the number of tasks is less than our number of threads, then all
			 * tasks will be executed concurrently (at same time)
			 * if there are more tasks than threads available, then the task will be put in
			 * queue
			 * i.e we have a fixedThreadPool of 10 threads and have 15 tasks, the first 10 tasks will
			 * be assigned to the 10 threads and 5 tasks will be queued
			 */
			/*
			 * a maximum amount of four threads will be running at the same time, which means a maxiumum amount
			 * of four tasks will be running at the same time
			 */
			ExecutorService service=Executors.newFixedThreadPool(4);
			try {
				service.execute(()->System.out.println("runnable service 1 time is "+LocalTime.now()));//thread 1
				service.submit(()->System.out.println("first sumbit runnable time is "+LocalTime.now()));//thread 2
				service.submit(()->{//thread 3
					System.out.println("callable sumbit time is "+LocalTime.now());
					return null;
				});
				service.submit(new Dog());//thread 4
				/*
				 * this is a fifth task, so this will have to wait until one of the 4 threads becomes avaiable, so
				 * this task will never be first, it will usually be last to complete, but not guaranteeed. 
				 * it wil be last to start, but it may not be last to finish.
				 */
				service.submit(new Employee());
				Thread.sleep(100);
				System.out.println("amount of threads in use is "+Thread.activeCount());
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				if(service!=null)
					service.shutdown();
			}
			
			System.out.println("amount of avaliable processers");
			System.out.println(Runtime.getRuntime().availableProcessors());
			int threadPool=Runtime.getRuntime().availableProcessors();
			/*
			 * this will create a thread pool of size 16, but this can hog machines resources
			 * this does not ACTUALLY USE THE THE THREADS, this merely says we can have a maximum of 16 threads
			 * running at the same time, or a maximum of 16 tasks can be running at the same time
			 */
			service=Executors.newFixedThreadPool(threadPool);
			System.out.println("amount of threads in use is "+Thread.activeCount());
			
			//service=Executors.newFixedThreadPool(threadPool/2);
			
		}
		
		static void ex16() {
			//counter=0;
			count=0;
			System.out.println("newScheduledThreadPool");
			System.out.println("time before thread execution "+LocalTime.now());
			/*
			 * this is the same as newFixedThreadPool except it returns an instance of ScheduleExcutorService which
			 * means you can can scedule taks
			 */
			ScheduledExecutorService service=Executors.newScheduledThreadPool(10);
			Runnable task1=()->System.out.println("task 1 number is "+ ++count+" time is "+LocalTime.now());
			service.scheduleAtFixedRate(task1, 3, 2, TimeUnit.SECONDS);
			Runnable task2=()->System.out.println("task 2 number is "+ ++count+" time is "+LocalTime.now());
			service.scheduleWithFixedDelay(task2, 3, 2, TimeUnit.SECONDS);
			/*
			 * this will result in more than 20 tasks been accomplished by the above service, however only
			 * 10 threads plus the system thread will be used to accomplish these tasks
			 */
			try {
				TimeUnit.SECONDS.sleep(25);	
			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				System.out.println("amount of Threads is "+Thread.activeCount());
				if(service!=null)
					service.shutdown();
			}
			
			
			
		}
			
		static void ex17() {
			
			System.out.println(Runtime.getRuntime().availableProcessors());
			int cpuCount=Runtime.getRuntime().availableProcessors();
			System.out.println("Free Memory");
			/*
			 * amount of free memory in the JVM
			 */
			System.out.println(Runtime.getRuntime().freeMemory());//amount of free memory, measured in bytes
			System.out.println("Total Memory");
			/*
			 * total amount of memory in the JVM
			 */
			System.out.println(Runtime.getRuntime().totalMemory());
			System.out.println("Max Memory");
			/*
			 * Maximum amount of memory the JVM will attempt to use
			 */
			System.out.println(Runtime.getRuntime().maxMemory());
			
			
			ScheduledExecutorService service=null;
			
			if(cpuCount<=2)
				service=Executors.newScheduledThreadPool(4);
			else if(cpuCount<=4)
				service=Executors.newScheduledThreadPool(4);
			else if(cpuCount<8)
				service=Executors.newScheduledThreadPool(8);
			else
				service=Executors.newScheduledThreadPool(16);
			service=Executors.newScheduledThreadPool(cpuCount);
			
		}
		
		
		
		
	
			
		
}		
		
		
		
		
		
		
		


