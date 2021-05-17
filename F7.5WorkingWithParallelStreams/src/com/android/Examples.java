package com.android;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Examples {
	
	static void ex1() {
		List<Integer>list=Stream.generate(()->(int)(Math.random()*100)+1).
								limit(40).
								collect(Collectors.toList());
		System.out.println(list);
		//these wil print in the order they are in the list
		list.stream().forEach((n)->System.out.print(n+","));
		System.out.println();//new line
		System.out.println("amount of threads "+Thread.activeCount());//1 thread
		/*
		 * this will NOT print in order, the reason being is that this is a parallelstream, which means, if you have enough
		 * threads, each one of the numbers could be accessed at the same time by the maximum amount of threads 
		 * on your system. in my case its 16 threads, so you have 16 threads accessing this stream at the same time, so
		 * in effect it could be said to be 16 times faster, but in reality its often multiples of this (1000's)
		 */
		list.parallelStream().forEach((n)->System.out.print(n+","));//this is a multithreaded stream
		System.out.println();
		list.parallelStream().//this allows more than one thread to act upon this stream at the same time
		filter((n)->n>50).//this is still a parallel stream
		/*
		 * this only allows one thread at a time to access the stream at this point
		 */
		forEachOrdered((n)->System.out.print(n+","));//this is now a single threaded version
		System.out.println();
		System.out.println("amount of threads "+Thread.activeCount());//16 threads
	}
	
	static void ex2() {
		List<Integer>list=Stream.generate(()->(int)(Math.random()*100)+1).
									limit(15).
									collect(Collectors.toList());
		System.out.println("our list sorted");
		list.stream().sorted().forEach((i)->System.out.print(i+","));
		System.out.println();
		System.out.println("our parallelStream sorted");
		/*
		 * this is an example of certain stream operations, when  used with parallelStreams not working
		 * the same as with ordinary single threaded streams
		 * forEach is NOT thread safe, so that mean multiple threads can access the stream at the same time
		 * 
		 */
		list.parallelStream().sorted().forEach((i)->System.out.print(i+","));
		System.out.println();
		/*
		 * the forEachOrdered()is a terminal operation that only allows one thread access the stream at a time
		 * so it becomes, in effect, a single threaded stream
		 * this leads to a loss of of any performance you may have gained by using the the Parallelstream operation
		 */
		list.parallelStream().
		sorted().
	//	peek(i->System.out.println("thread cound is "+Thread.activeCount())).
		forEachOrdered((i)->System.out.print(i+","));
	}
	
	static void ex3() {
		/*
		 * if you wish to run this code, decrease the amount of numbers (in the limit) until it will run on your
		 * machine
		 */	
		List<Long>list=Stream.generate(()->(long)(Math.random()*100+1)).
				limit(600_000_000).
				collect(Collectors.toList());
//	IntStream.range(0, 900_000_000).unordered().parallel().forEach(action);

//	System.out.println(list);
		System.out.println("time before "+LocalTime.now());
		/*
		 * a single threaded stream, only one thread at a time will be used to process each number
		 */
		list.stream().forEach(
				(n)->{
					n++;

					}
				);
		System.out.println("time after stream "+LocalTime.now());//this stream takes approx 2 seconds
		System.out.println("time before parallel "+LocalTime.now());
		/*
		 * this processes 7 times faster, all because it's a parallelstream and you have mulitple threads operating
		 * on the stream at the same time
		 * 7 times faster does not necessarily mean that only 7 threads are accessing this stream, there could more
		 * there could less
		 * a multi threaded stream
		 * multiple threads will be used to process the numbers in this stream, so you could have 16 threads operatiing
		 * on the stream at any point in time.
		 */
		list.parallelStream().forEach(
		(n)->{
			n++;
		
		}
		);
		System.out.println("time after parallel "+LocalTime.now());//this streams takes approx 0.3 seconds 7 times faster approx
		System.out.println(Thread.activeCount());		
			}
	
	static void ex4() {
		System.out.println("understanding performance Improvements 2");
		Examples ex1=new Examples();
		//goes from 0 to 3999
		List<Integer>data=Stream.iterate(0, i->i+1).limit(4000).collect(Collectors.toList());
		System.out.println(data.size());
		
		long start=System.currentTimeMillis();//the amount of time since the first milisecond on 01-01-1970
		ex1.processAllData(data);
		double finish=System.currentTimeMillis()-start;
		System.out.println("this has taken "+finish+" miliseconds");
		System.out.println("this has take "+finish/1000+" seconds");
		System.out.println("amount of threads in operation "+Thread.activeCount());//1 thread in operation
		
	}
	/*
	 * we will sent our list to this method, which contains our numbers
	 */
	public void processAllData(List<Integer>data) {
		/*
		 * for each number, the thread that is dealing with the number will sleep for 5 miliseconds. as this is
		 * a single threaded stream, a stream will sleep, then perform an operation and will do this 4000 times as we
		 * have 4000 numbers
		 * this takes approximately 23 seconds
		 */
		System.out.println(data.stream().map(a->processRecord(a)).count());
		
	}
	public int processRecord(int input) {
		try {
			/*
			 * each thread will sleep for 5 milliseconds, so if single threaded, it goes sleep, process numbers, sleep
			 * all one after another.
			 * However if it's mutltithreaded, you have 16 threads, so 16 threads go to sleep at same time, wake up at 
			 * same, and process 16 numbers at same time. then goes on to next 16 numbers, so in the time it takes one thread
			 * to process one number, a multi threaded application could h ave 16 numbers processed
			 */
			Thread.sleep(5);
		}
		catch(InterruptedException e) {
			
		}
		return input-1;
	}
	
	static void ex5() {
		System.out.println("understanding performance Improvements 2");
		Examples ex1=new Examples();
		//goes from 0 to 3999
		List<Integer>data=Stream.iterate(0, i->i+1).limit(4000).collect(Collectors.toList());
		System.out.println(data.size());
		
		long start=System.currentTimeMillis();//the amount of time since the first milisecond on 01-01-1970
		/*
		 * the only different with this is that this method uses a parallel stream, and the time taken to do
		 * this work is approx 1.5 seconds, which in my case is approx 16 times faster than in ex4
		 * as we have 16 threads in operation, it seems that all the threads are being used by the parallelStream
		 */
		ex1.processAllDataPar(data);
		double finish=System.currentTimeMillis()-start;
		System.out.println("this has taken "+finish+" miliseconds");
		System.out.println("this has take "+finish/1000+" seconds");
		System.out.println("amount of threads in operation "+Thread.activeCount());//16 threads in operation
	}
	
	public void processAllDataPar(List<Integer>data) {
		/*
		 * the more cpu's you have, the better the performance
		 * SCALING is the property as we add more resources the results gradually improve. 
		 * Improvements in performance using parallelStreams are often only noticible when using streams
		 * with large amounts of elements, or when processing complex tasks (Games, video all use Threads)
		 * for small streams the improvements are often limited as there are some overhead costs to allocating 
		 * and setting up parallel processing
		 */
		System.out.println(data.parallelStream().map(a->processRecord(a)).count());	
	}
	
	static void ex6() {
		System.out.println("Understanding independant operations");
		/*
		 * the results of an operation on one element of stream, should not impact the results of 
		 * another element of the stream
		 */
		List<String>animals=new ArrayList<>(Arrays.asList("Baboon","Chimpanzee","Anteater","Giraffe","Elephant"));
		/*
		 * you are not guranteed any order when  using parallel streams, so all strings could be acted upon at the same time
		 * , each of these strings are totally independant of each other, they are not dependant on each other
		 */
		System.out.println("first print");
		animals.parallelStream().map(s->s.toUpperCase()).forEach(System.out::println);
		System.out.println("thread amount is "+Thread.activeCount());//in my case it usually says 6
		/*
		 * as these are parallel streams you have no order, so you could have upper case printing before lower case
		 * and vice vearsa in no particular order
		 */
		System.out.println("second print");
		animals.parallelStream().
		map(
				(s)->{
					System.out.println(s);
					return s.toUpperCase();
				}
				
			).
		forEach(System.out::println);
	}
	static List<Integer>intList=new ArrayList<>();
	static void ex7() {
		/*
		 * we wish to avoid STATEFUL LAMBDA EXPRESSION. this is where one of the results in your stream depends on
		 * a result of another element in your stream.
		 * a STATELESS LAMBDA EXPRESSION is where a result does not depend on any state that may change during
		 * execution of a pipeline
		 */
		
		Stream.iterate(1, i->i*2).limit(12).forEach((i)->intList.add(i));//will enter numbers in order
		System.out.println(intList);
		intList=Stream.iterate(1, i->i*2).limit(12).collect(Collectors.toList());//will enter numbers in order
		System.out.println(intList);
		intList.clear();
		Stream.iterate(1, i->i*2).limit(12).parallel().forEach((i)->intList.add(i));//no order to how numbers are entered
		System.out.println(intList);
		intList.clear();
		/*
		 * this does NOT guarantee correct order always, there is a specific Overloaded collect method that you 
		 * should use with parallele streams
		 */
		intList=Stream.iterate(1, i->i*2).limit(12).parallel().collect(Collectors.toList());//there is an order to how numbers are entered
		System.out.println(intList);
		/*
		 * this is a thread safe arrayLIst, so you effectively lose the benefits of parallelStreams when you use this
		 * collection object
		 * with a parallel stream and a synchronized list you are guaranteed that all the numbers will be entered, but
		 * not the order
		 */
		System.out.println("using a synchronized list with paralllel Streams");
		List<Integer> data = Collections.synchronizedList(new ArrayList<>());
		
		List<Integer>numbers=new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		
		numbers.parallelStream()
		/*
		 * the values entered in the data synchronized list depend on what value i is at a position in the numbers list
		 * first element is 1
		 * second element is 2
		 * third element if 3
		 * fourth element is 4
		 * fifth element is 5
		 * sixth element is 6
		 * what number is entered into data list is dependant on the state of the numbers list (if its at the firsr element, it will
		 * insert number 2, second number 2 and so forth)
		 * as it's a parllel stream you can never know for sure, which of the six numbers it will be, as all numbers, if threads are
		 * available, will be processed at the same time.
		 * REMOVE STATEFUL OPERATIONS when using parallel streams, and also if possible for serial streams
		 */
		.map(
				i->{
					data.add(i);//STATEFUL LAMBDA EXPRESSION
					return i;
				}
			).
		forEachOrdered(i->System.out.print(", "+i));
		System.out.println();
		System.out.println(data);
		
		System.out.println("using a non synchronized list with parallel stream");
		List<Integer>data2=new ArrayList<>();
		
		numbers.parallelStream().
		/*
		 * we are using a non synchronized collection type arraylist, results CAN be lost
		 * as we can see forEAchOrdered produces always 6 numbers. However the issue is with the stateful lambda expression
		 * data1.add(i). AS when using an arraylis, the JVM manages a primitive array of the same size, as as elements are
		 * added to the arrayLIst the background array is increased in size, but if two elements are added to the same position at
		 * the same time, only one will be added and other lost
		 */
		map(
				i->{
					/*
					 * this might add 6 numbers, might add 5 numbers, might add 4 or less numbers
					 * the key here is that its NOT predictable how many numbers will be added at any one time
					 */
					data2.add(i);//STATEFUL LAMBDA EXPRESSION
					return i;
				}
			).
		//this shows that 6 numbers are produced by this stream, but the stateful lambda expression may not add all the numbers
		forEachOrdered(i->System.out.print(", "+i));
		System.out.println();
		System.out.println(data2);
	}
	static void ex8() {
		System.out.println("reductions with parallel streams");
		/*
		 * reductions are combining contents of a stream into a single object, however parallel reductions can be different
		 * to what you expect with serial streams.
		 */
		List<Integer>numbers=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
		Optional<Integer>optInt;
		/*
		 * this returns an Optional of type Integer, so we need to use the Get() method of the optional class
		 * to get the value. if there are any nummbers in this stream, it will get the first number in the stream, which
		 * is one
		 */
		System.out.println(numbers.stream().findAny().get());
		/*
		 * in theory, as this is a parallle stream, any number can be returned but in practise 4 is returned
		 */
		System.out.println(numbers.parallelStream().findAny().get());
		/*
		 * in theory this could be any number, you are not guaranteed this will be the number 1
		 */
		System.out.println(numbers.parallelStream().findFirst().get());
		/*
		 * any stream operation that is based on order in a parallel stream such as findfirst() 
		 * limit() skip()(limit and skip do operate and produce the same results as would be produced from a 
		 * serial stream) these operations may perform more slowly as you forcing something that is implementing
		 * parallel processing to behave in a single threaded manner
		 * 
		 */
		System.out.println("using skip");
		numbers.parallelStream().skip(2).forEach(System.out::println);
		System.out.println("using limit");
		numbers.parallelStream().limit(3).forEach(System.out::println);
		
		System.out.println("Unordered streams");
		List<Integer>data=Stream.iterate(1, i->i+1).limit(4000).collect(Collectors.toList());
		Examples ex1=new Examples();
		long start=System.currentTimeMillis();
		
		ex1.processAllData3(data);
		double finish=System.currentTimeMillis()-start;
		System.out.println("tasks completed in "+finish+" miliseconds");
		
		System.out.println("tasks completed in "+finish/1000+" seconds");
		
		/*
		 * certain methods of the Stream class are NOT available to the ParallelStream class
		 * two examples are ITERATE
		 * GENERATE
		 */
		System.out.println(Stream.iterate(1, n->n*3).limit(2000).parallel().filter(n->n%9==0).
		count());
		//both max and min work the same with serial streams
		System.out.println("max is "+numbers.parallelStream().max((a,b)->a-b));
	}
	
	public void processAllData3(List<Integer>data) {
		data.parallelStream()/*.unordered()*/.limit(2000).skip(15).map(a->processRecord3(a)).count();
		
		
	}
	
	public int processRecord3(int input) {
		try {
			Thread.sleep(10);
		}
		catch(InterruptedException e) {
			
		}
		return input-1;
	}
	
	static void ex9() {
		System.out.println("reduce with parallelStreams");
		/*
		 * reduce is a stream terminal operation that reduces our streams of objects to any Object we want
		 * with parallelStreams we have really only two effective overloaded reduce methods
		 */
		List<Integer>numbers=new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		/**
		 * reduce() combines a Stream into a single object
		 * IDENTITY - what you start with (could be the number to start the calculation, or the object you want all of the
		 * elements of stream to produce, i.e A Zoo object could be produced from a stream of Animals, so the identity
		 * would be a new Zoo object
		 * ACCUMULATOR - what you want to do with pairs of elements in the stream, in this case its a stream of Integers
		 * and we want to add the numbers in pairs. takes a BiFunction, takes two arguments and returns one object
		 * COMBINER - this is what we wish to do with all the items produced by the Accumulator, the accumulator int this case
		 * produces numbers that are the product of two of the number added up (i.e 1+0=1,2+3=5,4+5=9,+6). here we wish to
		 * add up all of the produces (1+5+9+6)=21
		 * Requirements for reduce() Arguments
			The identity must be defined such that for all elements in the stream u ,
				combiner.apply(identity, u) is equal to u .
			The accumulator operator op must be associative and stateless such that (a op b) op c
				is equal to a op (b op c) .
			The combiner operator must also be associative and stateless and compatible with the
				identity, such that for all u and t combiner.apply(u,accumulator.apply(identity,t))
				is equal to accumulator.apply(u,t) .
			basically what all these mean is that all the different variables should be compatible
		 */
		int sum=numbers.parallelStream().
				reduce(0, /*IDENTITY, basically the starting point for our reduction
				if we were producing a Zoo from a stream of  Animals, what we would have here
				is new Zoo()
				*/
						(a,b)->a+b,/*ACCUMULATOR this has to be Associative and stateless, you will NOT get the 
						expected answer if this is stateful or if this is NOT associative. Addition is Associative
						Accumulator takes two of the elements in pairs and does something to them, in this case it 
						adds the two of them up
						*/
						(c,d)->c*d);/*COMBINER takes the results from the Accumlulator and does something to the these 
						elements, in this case it adds them up. again you will not get the expected answer if this is
						stateful or not associative
						*/
		System.out.println("sum of list is "+sum);//
		System.out.println("serial stream reduce subtraction");
		/*
		 * it does not matter with serial streams if the Accumulator or Combiner are Associative, this will produce -21
		 */
		sum=numbers.stream().reduce(0, 
				(a,b)->a-b, 
				(c,d)->c-d);
		System.out.println("sum is "+sum);
		
		System.out.println(numbers.parallelStream().peek((n)->System.out.println("number is "+n)).
				reduce(0, //IDENTITY is fine
						(a,b)->/*
						Accumulator have to be stateless lambda expression and
						have to be Associative (addition is associative 1+4 is the same as 4+1
						subtraction is NOT associative, 1-4 is NOT the same as 4-1
						*/
							{
								return a-b;
							},
						/*
						 * combiner alos has to be stateless and associative
						 */
						(c,d)->c-d));
	//	System.out.println("sum is "+sum);
		numbers.parallelStream().forEach(System.out::print);
		
		System.out.println();
		
		System.out.println("print ParallelStream");
		List<String>strs=new ArrayList<>();
		strs.add("w");
		strs.add("o");
		strs.add("l");
		strs.add("f");
		strs.parallelStream().forEach(System.out::print);
		
		//System.out.println("strs2 is "+strs2);
		System.out.println();
		System.out.println("our strings");
		strs.parallelStream()
			.peek(System.out::print)
				.reduce("",
				(c,s1)->c+s1,(s2,s3)->s2+s3);
		System.out.println();
		String fullStr=strs.parallelStream().
				peek(System.out::println)
				.reduce("",
				(c,s1)->c+s1,(s2,s3)->s2+s3);
		System.out.println("is this a wolf");
		System.out.println(fullStr);
		
		System.out.println(strs.stream().reduce("x", (a,b)->a+b));//this produces xwolf
		System.out.println(strs.parallelStream().reduce("x", (a,b)->a+b,(c,d)->c+d));//but this produces xwxoxlxf
		System.out.println(strs.parallelStream().reduce("x",String::concat));//this also produces xwxoxlxf
		/*
		System.out.println(Arrays.asList("w","o","l","f")
				.stream()
				.reduce("X",(a,b)->a+b));*/	
	}
	
	static void ex10() {
		System.out.println("Combining result with collect");
		/*
		 * it is advised to use the three argument collect method when using with a parallel stream
		 * by having the .parallel() stream operation this makes this a parallel stream
		 */
		Stream<String>stream=Stream.of("w","o","l","f").parallel();
		/*
		 * collect takes threee arguements
		 * supplier - which is a supplier, and the object you will save the stream values too, in this case thread 
		 * safe collection ConcurrentSkipListSet, whihc is a thread safe TreeSet
		 * Accumulator - BiFunction - takes two elements and does something with these elements, in this case, takes a 
		 * set and a String and adds the string to the set
		 * Combiner - for combing all the strings to one set
		 */
		SortedSet<String>set=stream.collect(
				/*
				 * this organises letters in alphabetical order, so from w,o,l,f we get
				 * f,l,o,w
				 */
				()->new ConcurrentSkipListSet<>(), 
				(se,s)->se.add(s), 
				(se,s)->se.addAll(s));
		System.out.println(set);//produces [f, l, o, w]
		//stream.collect(supplier, accumulator, combiner)
		
		List<String>list=new ArrayList<>(Arrays.asList("w","o","l","f"));
		set.clear();
		/*
		 * this collect method is the recommended one you use when you are using parallelStreams
		 * as this is specifically designed for ParallelStreams
		 */
		set=list.parallelStream().collect(
				()->new ConcurrentSkipListSet<>(), 
				(se,s)->se.add(s), 
				(se,s)->se.addAll(s));
		System.out.println(set);//produces f,l,o,w
		
		
	}
	
	static void ex11() {
		System.out.println("using the one argument collect method");
		List<String>list=new ArrayList<>(Arrays.asList("w","o","l","f"));
		
		SortedSet<String>set=list.parallelStream().collect(Collectors.toCollection(()->new TreeSet<>()));
		System.out.println(set);
		List<String>list2=list.parallelStream().collect(Collectors.toList());
		System.out.println(list2);
	}
	
	static void ex12() {
		List<String>animals=new ArrayList<>(Arrays.asList("lions", "tigers","bears","leopards","wolves","sharks"));
		System.out.println("our list of animals is "+animals);
		
		/*
		 * ConcurrentMap is a thread safe Map
		 * takes a Function, which will be the key
		 * takes a function, which will be the value
		 * and a binaryOperator takes two arguements and returns one object, this is what produces 
		 * 5=bears and lions, if two values have teh same key, they will be combined with the word and
		 */
		ConcurrentMap<Integer,String>map=animals.
									parallelStream().
									collect(Collectors.toConcurrentMap(k->k.length(), v->v, (v1,v2)->v1+" and "+v2));
		System.out.println(map);
		Map<Integer,String>myMap=Stream.iterate(0, i->i+2).limit(10).
				collect(Collectors.toMap(i->i, i->"number"+i, (s1,s2)->s1+" ,"+s2));
		System.out.println(myMap);
		
		/*
		 * this simply creates a map of Integer keys to values which are List of Strings
		 * takes a function which will take a object and retrun an object, in this case it will takea 
		 * String, which is one of the Strings in the animals list and return an Integer, which will
		 * be the length of each string. So the key will be the amouunt of characters in the strings in the value, which is a
		 * list i.e
		 * 5=[lions, bears], 6=[wolves, tigers, sharks], 8=[leopards]
		 */
		ConcurrentMap<Integer, List<String>> map2 = animals.parallelStream().
				collect(
				Collectors.groupingByConcurrent(String::length));
				System.out.println(map2); // {5=[lions, bears], 6=[tigers]}
				System.out.println(map2.getClass());
	}
	
	
	

}
