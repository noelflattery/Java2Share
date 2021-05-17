package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * class that contains all our sample code to do with the topics covered in this section
 * @author NoelF
 * @see com.android.Examples#ex1()
 * @see com.android.Examples#ex2()
 * @see com.android.Examples#ex3()
 * @see com.android.Examples#ex4()
 */
public class Examples {
	/**
	 * this method shows two approaches to the one problem, one using a loop based approach, and another using Streams.
	 * From this code it should become apparent that java 8 Streams offer a way to greatly reduce the amount of code, while
	 * at the same time being more intuitive and easier to understand (admittably there is a bit of a learning curve with
	 * java 8 streams)
	 * the code presents solutions to taking a list of names and then picking out those names with only 4 letters. This
	 * list is then sorted alphabetically and picks out only the top two names in the list. 
	 * Our first solution is using a more traditional loops based approach, which is cumbersome and not easily modified.
	 * Our second solution involves Stream and can be easily modified to either produce a list of names, that we can use
	 * at a later date or just print out the names to the screens without saving them.
	 * @see com.android.Examples#count
	 */
	static void ex1() {
		/*
		 * takes a list of names and pick out only those names with 4 letters in it and then pick out the top two when
		 * the list is sorted in alphabetical order
		 */
		System.out.println("using lists and loops");
		
		List<String>names=Arrays.asList("Noel","Mary","Andy","Pat","Shelly","Laura","Sean","Holt","Colm");
		//we need a new list that is going to hold our final list of strings
		List<String>filtered=new ArrayList<String>();
		//we use this loop to populate our filtered arrayList with names only 4 characters long
		for(String name:names) {
			if(name.length()==4)
				filtered.add(name);
		}
		/*
		 * filtered now contains "noel", "mary", "andy", "sean", "holt", "colm", but this list is NOT sorted
		 * strings implement comparable which means we can use teh Collections.sort method with a list of Strins
		 */
		Collections.sort(filtered);
		System.out.println("filtered is now "+filtered);
		/*
		 * this is now an arraylist that contains in this order the names
		 * Andy, Colm, Holt, Mary, Noel, Sean
		 * we wish to remove holt, mary,noel and sean from this list
		 */
		if(filtered.size()>2) {
			System.out.println("size of filtered list is "+filtered.size());
			
			int size=filtered.size()-1;
			/*
			 * this will start at index position 5 and work down until it gets to position 1, so it will remove items
			 * at the following  position in teh list
			 * filtered(5)
			 * filtered(4)
			 * filtered(3)
			 * filtered(2)
			 */
			for(int i=size;i>1;i--)
				filtered.remove(i);
		}
		System.out.println("our final list contains "+filtered);
		System.out.println("using streams to accomplish the same task");
		names.stream().
		filter(s->s.length()==4).
		sorted().limit(2).forEach(System.out::println);
		
		List<String>nList=names.stream().
				filter(s->s.length()==4).
				sorted().
				limit(2).
				collect(Collectors.toList());
		System.out.println("our list of strings is "+nList);
	}
	
	/**
	 * this is a variable that will be used with {@link com.android.Examples#ex2()}. this will be incremented
	 * within a stream and be used to produce Strings that depends on if this number is even or odd
	 * @see com.android.Examples#ex2()
	 */
	static int count;
	/**
	 * This method deals with the importance of the ORDER of operations in streams. The importance of limiting 
	 * infinite streams to a finite amount is shown and how some operations, such as sorted() cannot be carried
	 * out on a infinite stream. This type of issue does not produce a compilation error or an exception, but 
	 * results in an infinite hang, as it tries to sort an infinite amount of objects, which can never be completed.
	 * Also covers having peek() in different locations in a stream.
	 * @see com.android.Examples#count
	 */
	static void ex2() {
		System.out.println("order of Stream operations");
		/*
		 * the order of stream operations DOES MATTER, as can be shown in this example
		 */
		
		System.out.println("sort then limit");
		/*
		 * you can't sort an infinite stream, you need to limit it FIRST then sorted
		 */
		Stream.generate(//generate will produce a infinite amount of strings unless limited
				()->{
					count++;
					if(count%2>0)
						return "eddie";
					return "etna";
				}
				).sorted().//this is attempting to sort an infinite list, so this will continue foreve
				limit(4).//this limits our infinite amount of strings to 4
				forEach(System.out::println);
				
		
		Stream.generate(//generate will produce a infinite amount of strings unless limited
				()->{
					count++;
					if(count%2>0)
						return "eddie";
					return "etna";
				}
				).limit(4).//limits to 4, which will be eddie, eddie, etna,etna
				sorted().//then we sort it
				forEach(System.out::println);//then we print it
		
		Stream.generate(()->{count++;if(count%2>0)return "eddie";return "etna";}).limit(4).sorted().forEach(System.out::println);//then we print it
		
		/*
		 * this creates an infnite stream of numbers, starts at 1, and increments by 1
		 */
		Stream.iterate(1, x->x+1).
		//this limits the strem to 5 numbers, which will be 1,2,3,4,5
		limit(5).
		//allows only odd numbers
		filter(x->x%2==1).
		//at this point our stream now produces 1,3,5
		forEach(System.out::println);
		
		System.out.println("second stream of numbers");
		
		Stream.iterate(1, x->x+1).
		//this limits the strem to 5 numbers, which will be 1,2,3,4,5
		limit(5).
		/*
		 * where you put the peek, DOES matter, if we put in the peek  before teh filter, this will print out all
		 * five numbers
		 */
	//	peek(System.out::println).
		filter(x->x%2==1).
		/*
		 * put a peek in after the filter you only get three numbers 1,3,5
		 */
		peek(x->System.out.println("peek after filter "+x)).
		//at this point our stream now produces 1,3,5
		forEach((x)->System.out.println("number is "+x));
	}
	/**
	 * this method deals with more practical issues that can occur when using streams and using the intermeidate 
	 * operations peek(), limit(), sorted(), filter(), distinct() and the terminal operations forEach(), count() and
	 * collect() in the one stream and the effect again order has on the output produced.
	 * the method {@link com.android.Examples#generateNum()} is used in this method to generate random numbers between 1 and 100.
	 * this also uses the {@link com.android.Dog} class to create a TreeSet of Dogs, and as Dog implements Comparable this is 
	 * valid code as only a class whose object implements comparable can be added to a TreeSet, or has a Comparator defined for that
	 * A TreeSet of type {@link com.android.Cat} is also created and as this class does not implement comparable, we create a 
	 * seperate {@code Comparator<Cat>} to sort the cats and them place them in a TreeSet
	 * particular object
	 * @see com.android.Examples#generateNum()
	 * @see com.android.Dog
	 * @see com.android.Cat
	 */
	static void ex3() {
		System.out.println("printing a Stream");
		List<String>names=Arrays.asList("Noel","Mary","Andy","Pat","Shelly","Laura","Sean","Holt","Colm");
		System.out.println("method 1 of printing out a stream");
		System.out.println("using forEach");
		names.stream().forEach(System.out::println);
		System.out.println("method 2");
		System.out.println("converting to a collection object");
		System.out.println(names.stream().collect(Collectors.toList()));
		System.out.println("method 3");
		System.out.println("using peek to print out stream");
		names.stream().peek(System.out::println).count();
		System.out.println("prints out first four names and sorts them");
		/*
		 * this produces a stream of "Noel","Mary","Andy","Pat","Shelly","Laura","Sean","Holt","Colm"
		 */
		names.stream().
		//this produces a stream of "Noel","Mary","Andy","Pat"
		limit(4).
		//this sorts to Andy, Mary, Noel, Pat
		sorted().
		//this prints off Andy, Mary, Noel, Pat
		forEach(System.out::println);
		
		System.out.println("sort names first then print out first four");
		//this produces a stream of "Noel","Mary","Andy","Pat","Shelly","Laura","Sean","Holt","Colm"
		names.stream().peek(System.out::println).
		//this sorts the stream to Andy, Colm, Holt, Laura,Mary, Noel, Pat, Sean, Shelly
		sorted().peek((x)->System.out.println("sorted is "+x)).
		//this limits to Andy, Colm, Holt and laura
		limit(4).//peek((x)->System.out.println("first 4 is "+x)).
		count();
		//this prints out Andy, Colm, Holt and lauras
	//	forEach(System.out::println);
		
		int num=(int)(Math.random()*100);
		//generates a potential infinite stream of dogs all with the name spot and an age between 0 and 99 inclusive
		List<Dog>dogList=Stream.generate(()->new Dog("spot",generateNum())).
				//this filters our stream to only dogs with an age less than 50
							filter(d->d.age<50).
							distinct().//this ensures that every dog is Unique, and can be added to our hashSet
							//this filters our stream to only 10 Dogs
							limit(10).
							//as Dog implemetns the comparable interface you can use sorted() with a Stream of Dogs
							sorted().
							//this saves the dogs to hashSet whihc is assigned to teh dogSet hashSet variable
							collect(Collectors.toList());
		
		TreeSet<Dog>dogTree=Stream.generate(()->new Dog("spot",generateNum())).
				//this filters our stream to only dogs with an age less than 50
				filter(d->d.age<50).
				distinct().//this ensures that every dog is Unique, and can be added to our hashSet
				//this filters our stream to only 10 Dogs
				limit(10).
				//only objects that implement the comparable intgeface can be added to a treeSet
				//or have a comparator defined for them
				collect(Collectors.toCollection(TreeSet::new));
		System.out.println("treeSEt of Dogs is "+dogTree);
		
		System.out.println(dogList.size());
		System.out.println(dogList);
		//cat class does not implemetn comparable so we create a comparator for the Cat class
		Comparator<Cat>catComp=(c1,c2)->c1.age.compareTo(c2.age);
	
		//the comparator is used in the sorted() method and returns a sorted stream, which can be used to become a TreeSet
		TreeSet<Cat>catTree=Stream.generate(()->new Cat(generateNum(),"tibbles")).
				filter(c->c.age<50).//only those less than 50
				sorted(catComp).//sorts them by age
				limit(10).//limits to 10
				collect(Collectors.toCollection(TreeSet::new));//puts all cats into a new TreeSet
	//	System.out.println(catTree);
	}
	//Collections.sort(names, byString)
	/**
	 * a method to generate a pseudo random number, this is our own random number gerneator as opposed to using 
	 * the random class {@link com.android.Examples#ex4()}
	 * @return an int that will be a pseudo random number between 1 and 100
	 * @see com.android.Examples#ex3
	 */
	static int generateNum() {
		return (int)(Math.random()*100);
	}
	/**
	 * this method investigates random number generators and they're usage with Streams, in particular using the
	 * Random class and how to generate numbers within a specific range.
	 */
	static void ex4() {
		/*
		 * this can generate a pseudo random number
		 * psuedo means it looks random, but it's not really. if you know the algorithm for generated this number, so will be
		 * able to work this number at any time.
		 * as far as i know i think it generates a random number based on the time on your the machine you compile the code.
		 */
		Random rand=new Random();
		//this will generate a randon number between -2.1 and +2.1 billion
		int num=rand.nextInt();
		System.out.println(num);
		//will produces a random number between 0 and 99 inclusive
		num=rand.nextInt(100);
		//this produces a randon number between 1 and 100 inclusive
		num=rand.nextInt(100)+1;
		
		Stream.generate(()->new Random().nextInt(100)+1).
		filter(x->x%2==0).
		limit(5).
		forEach(System.out::println);
	}

}
