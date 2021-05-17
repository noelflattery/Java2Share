package com.android;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples {
	
	static void ex1() {
		System.out.println("our Zookeepers");
		/*
		 * four zooKeepers (which will actually be four threads), which each do three different tasks for the lion pen
		 * which are
		 * removeAnimals()
		 * cleanPen()
		 * addAnimals()
		 * all zoo workers can join in each of the tasks, but we don't want them to start a new task until the 
		 * previous task has been completed.
		 */
	//	ZooKeeper zed=new ZooKeeper();
		/*
		 * this is our set of 4 ZooKeepers that will remove the Lions
		 * clean the lions pen
		 * and then add the lions to the pen 
		 */
		Set<ZooKeeper>zooKeepers=Stream.generate(()->new ZooKeeper()).
				limit(4).
				collect(Collectors.toSet());
		ExecutorService service=Executors.newFixedThreadPool(4);
		/*for(int i=0;i<4;i++)
			service.submit(()->zed.performTasks());*/
		/*
		 * this leads to some zookeepers cleaning the pen while other zookeepers are still removing animals and some 
		 * other zookeeprs have progressed onto adding lions while some zookeepers are still removing lions or cleaning
		 * the pen
		 * if this was a single thread, then the results WOULD be in the correct order
		 */
		for(ZooKeeper z:zooKeepers)
			service.submit(()->z.performTasks());
		if(!service.isShutdown())
			service.shutdown();
	}
	
	static void ex2() {
		Set<Farmer>farmers=Stream.generate(()->new Farmer()).limit(4).collect(Collectors.toSet());
		ExecutorService service=Executors.newFixedThreadPool(4);
		
		/*
		 * cyclicBarrier has a number of constructors, one constructors takes an int, which is the amount of threads
		 * we want our application to wait for to complete a set of tasks,
		 * i.e we have four threads(we have a thread for each farmer), inside the performtask method, the four threads
		 * will not progress onto cleaningPen() until they have all completed removeAnimals()
		 * 
		 */
		CyclicBarrier c1=new CyclicBarrier(4);
		/*
		 * this CyclicBarrier takes an intt, which is before the amount of threads 
		 * and a Runnable object, here this runnable object only print out pen cleaned
		 * the runnable object runs, once all four threads have completed the task, in this case
		 * when all four farmers have finished cleaning the pen
		 */
		CyclicBarrier c2=new CyclicBarrier(4,()->System.out.println("pen cleaned"));
		
		for(Farmer f:farmers)
			service.submit(()->f.performTask(c1,c2));
		service.shutdown();
		
		
		service=Executors.newFixedThreadPool(4);
		Set<StableBoy>stableBoys=Stream.generate(()->new StableBoy()).limit(4).collect(Collectors.toSet());
		
		CyclicBarrier cStable=new CyclicBarrier(4,()->System.out.println("stables boys have removed the horses"));
		CyclicBarrier cStable2=new CyclicBarrier(4,()->System.out.println("stable boys have cleaned all the horseShite"));
		/*
		 * this has a cyclicbarrier between the hourse being removed and the stables been cleans
		 * and a cyclicBarrier between the stabels being cleaned and horse been added to the stables again
		 */
		for(StableBoy s:stableBoys)
			service.submit(()->s.performTask(cStable, cStable2));
		service.shutdown();
		try {
			Thread.sleep(10);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("amounts of threads in operations is "+Thread.activeCount());
		int cpuCount=Runtime.getRuntime().availableProcessors();
		System.out.println("amount of available threads is "+cpuCount);
		/*
		 * if you are using a thread pool make sure that the number of available threads is at least as large
		 * as the CyclicBarrier, if your thread pool is 2, and your CyclicBarrier is 4, then it would result
		 * in a hang as the barrier would never get to 4
		 *  * we can reuse CyclicBarriers, if we have a CyclicBarrier(5) and we have 15 threads executing tasks, the 
		 * CyclicBarrier goes back to zero after it gets to 5, so for 15 threads this CyclicBarrier will be used 3 times
		 */
	}
	
	static void ex3() {
		/*
		 * a Method calling itself is a recursive method, however a recursive method HAS to have a means of coming
		 * to a conclusion. if not, the method will be called a few hundred or possibly a few thousand times and 
		 * will then generate a StackOverFlowErroor
		 * in this example, we call the method recursive(), which prints out "recursive method called" and calls itself
		 * again, and if it did not generate a stackoverflowError, it would continue calling itself forever, as we 
		 * have provided it with no means of exit. you can exit if you provide, for instance an exteran counter, which
		 * will cause our method to exit after the counter reaches a certain number, this number that causes our
		 * recursion to stop, is called a BASE CASE
		 */
	//	recursive();
	}
	
	static void recursive() {
		System.out.println("recursive method called");
		recursive();
	}
	
	static void ex4() {
		/*
		 * this uses recursion, which is a method calling itself and keep calling itself until it gets to a base
		 * case and then exits the method
		 * if a base case is never reached then your program can never finish, so this will results in a a
		 StackOverflowError
		 biNomial numbers get very large, very quickly i.e biNomial 20 is 2.43 Qunitillion, which is 2 and 18 places
		 before the decimal point or this number to be precise
		 2432902008176640000
		 this is a warning as you can quite easily ask and attempt to do tasks in programming that would take
		 more thime than the entire lifetime of the universe to complete
		 */
		System.out.println(biNomial(5));
		System.out.println(biNomial(20));
		System.out.println(biNomial(65));
		/*
		 * to show just how large we create a speical biNomial method that uses the BigInteger data type.
		 * which can't use ordinary mathematical operators, such as +,*,/, etc, so you use they're own methods
		 * such as multiply() and add()
		 * as far as a i know this is the largest number we can deal with
		 */
		System.out.println(biNomial2(984));
		System.out.println("number is "+biNomial2(984).toString().length()+" digits long");//2530 digits long
		System.out.println("the biNomial2 method has been called "+biNomCount+" times");//method has been called 1968 times
	}
	
	static long biNomial(Integer num) {
		/*String strNum=num.toString();
		BigInteger bigNum=new BigInteger(strNum);*/
		
		if(num<=1)//base case is num is 1
			/*
			 * this is the base case, so we keep decrementing num by 1 until num becomes
			 * 1 at which point the biNomial method we no longer call itself
			 */
			return 1;
		else
			return num*biNomial(num-1);
	}
	
	static int biNomCount=0;
	static BigInteger biNomial2(int num) {
		biNomCount++;
		String strNum=""+num;
		BigInteger bigInt=new BigInteger(strNum);
		
		if(num<=1)//base case
			return new BigInteger("1");
		else {
			BigInteger bigInt2=biNomial2(num-1);
			return bigInt2.multiply(bigInt);
		}
	}
	/*
	 * in order to use Fork/Join your class either has to extend the abstract class RecursiveAction and implement
	 * the void compute() method - see Manager class
	 * if you want to return a value, we extends the RecursiveTAsk<T> abstract class and implement the T compute()
	 * method - Employee
	 * Fork is assigning a task or tasks to a new thread (the existing thread forks in two
	 * Join can be called after the fork method and causes the current thread to wait for a result for another
	 * task or sub task, its effectively a sleep, i think.
	 */
	static void ex5() {
		System.out.println("fork/Join framework");
		/*
		 * we want to weight all the Animals in the zoo, of which there are 10 animals and then add up all the 
		 * weights. As our Animals are sperad out, one person, can at most, weigh three animals at one time. 
		 * So we know at start of problem, one person can weight, at most 3 animals. So this is our base case
		 * in our recursive calls will get us to one person(thread) weight three Animals.
		 * we want to weigh all the animals in the least time possible, we ask one person to do this and he has
		 * permission to ask others to help him. At the start we don't know how many others he will ask to help him
		 * but he will ask a certain amount of people to weigh a certain amount of Animals. we don't know at the very
		 * start of the task how many animals each person will weigh.
		 */
		//this will be used to store the weights of our 10 animals
		//we want to get the total weight of Animals
		Double[]weights=new Double[10];
		/*
		 * to create a fork/join there are three steps you need to carry out
		 * create a ForkJoinTask (in our case will be creating a manager to weight some animals)
		 * Create a ForkJoinPool(where the threads for weighing animals will come form)
		 * you will need a class that extends either RecursiveAction or RecursiveTask<T>
		 */
		ForkJoinTask<?>task=new Manager(weights,0,weights.length);
		/*
		 * this is the pool of threads that will accomplish the above recursive task
		 * if this sees that four threads are the most efficient way to weigh three animals at the one
		 * time, then this pool will have four threads
		 */
		ForkJoinPool pool=new ForkJoinPool();
		/*
		 * only at this point is a size given to our pool
		 */
		pool.invoke(task);
		System.out.println("size of the pool is "+pool.getPoolSize());
		System.out.println("weights");
	//	Arrays.asList(weights).stream().forEach(d->System.out.println("weight is "+d));
		System.out.println("amount of Managers created "+Manager.counter);
		System.out.println("amount of managers used "+Manager.manageCounter);
	//	Arrays.asList(weights).stream().forEach((d)->System.out.println("weight is "+d));
		
	}
	
	static void ex6() {
		Double[]weights=new Double[10];
		/*
		 * same as previous we want each employee to be able to weight at most 3 Animals at the same time, and we also
		 * wish to add up all of the weights
		 * if you want to use a ForkJoinPool and you want to return some object, then you have to use only objects that
		 *  extend RecursiveTask<T> as this compute method is like the following
		 *  T compute(){
		 *  }
		 *  the compute method of the Employee returns a double, so this ForkJoinTask has a generic type of 
		 *  Double
		 */
		ForkJoinTask<Double>task=new Employee(weights,0,weights.length);
		
		ForkJoinPool pool=new ForkJoinPool();
		/*
		 * this compute method returns a Double, so this can be assigned to a double variable
		 */
		System.out.println("amount of threads "+Thread.activeCount());
		Double sum=pool.invoke(task);
		System.out.println("the total amount weighted is "+sum);
		System.out.println("there are "+Employee.counter+" created");
		System.out.println("there are "+Employee.empCounter+" employees used");
		System.out.println("amount of threads "+Thread.activeCount());
		
//		ForkJoinPool commonPool=ForkJoinPool.commonPool();
	//	Logger logger=Logger.getAnonymousLogger();
		
	}
	
	

}
