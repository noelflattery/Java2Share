package com.android;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**for video click on
 * these examples will introduce us to Streams and to TERMINAL operations, Terminal operations cause the creation and intermediate
 * operations to run, but they will not run UNTIL there is a Terminal operation in your Stream
 * List of TERMINAL OPERATIONS 
 * 			toArray() see {@link com.android.Examples#ex8()}
			collect() see {@link com.android.Examples#ex10()}
			count() see {@link com.android.Examples#ex5()}
			reduce() see {@link com.android.Examples#ex10()}
			forEach() see {@link com.android.Examples#ex9() }
			forEachOrdered() see {@link com.android.Examples#ex9() }
			min() see {@link com.android.Examples#ex5()}
			max() see {@link com.android.Examples#ex5()}
			anyMatch() see {@link com.android.Examples#ex7()}
			allMatch() see {@link com.android.Examples#ex7()}
			noneMatch() see {@link com.android.Examples#ex7()}
			findAny() see {@link com.android.Examples#ex6()}
			findFirst() see {@link com.android.Examples#ex6()}
			collect() see {@link com.android.Examples#ex11()}
			terminal operations CANNOT be chained
 * we also cover some Stream creation operation which are
 * 			create() see {@link com.android.Examples#ex2() }
 * 			iterate() see {@link com.android.Examples#ex3() }
 *This class has methods that deal with Introduction Java 8 Steams, Java 8 streams operate on the principle of CHAINED methods.
 *  For instance we have a class called Animal
 * {@code	class Animal{
 * 				private String name;
 * 				private Animal(String name){
 * 					this.name=name;
 * 					}
 * 				public static Animal createAnimal(){
 * 						return new Animal();
 * 					}
 * 				public String getName(){
 * 						return name
 * 					}		
 * 	}
 * }the we have the following code {@code
 * Animal.createAnimal().getName().len()}
 * Animmal.createAnimal().	// returns a Animal which calls the method of the Animal class
 * getName(). 				//which returns a String which calls the method of the String class
 * len() 					//which returns an int, int is NOT an object so no methods can be called after this point
 * an Example of a Stream would be
 * Stream.of(34,45,67).forEach((Integer n)->S
 * Streams are usually made of three types of methods
 * A creation or initialization
 * Intermediate operations
 * Terminal Operations
 * methods that create a Stream, return a Stream object which means that ALL the methods of the Stream classes and interfaces
 * can be called after this. Some creational methods such as generate {@link com.android.Examples#ex2() } and iterate
 * {@link com.android.Examples#ex3()} will produce infinite amount of objects and need to be be used in conjunction with the
 * Intermediate limit() {@link com.android.Examples#ex2()}
 * Intermediate streams also return a Stream object, which means again ALL the methods of the Stream classes and interfaces
 * can be called after intermediate operations.
 * Terminal operations DO NOT RETURN A sTREAM, so no methods of the Stream classes and interface can be called AFTER
 * a Terminal operation. Terminal operations so effectively close a stream and can resolve to the streams producing 
 * actual values (Reductions, producing lists of Objects) or simply printing out values (using a forEach)
 * An example of stream is this Stream that produces 10 random numbers between 1 and 100 and prints them
 * out to the screen
 *{@code Stream.generate(()->(int)(Math.random()*100)).limit(10).forEach((Integer n)->System.out.println("number is "+n));}
 *explained as follows:
 *Stream.generate(()->(int)(Math.random()*100)				//creates the stream and returns that stream that can produce 
 *															//infinite random number between 1 and 100. This creation 
 *															//part always returns a Stream
 *
 *limit(10)									 				//returns a new stream that will be will limit the previous 
 *															//stream to producing only 10 numbers. All Intermediate
 *															//operations produce a Stream
 *
 *forEach((Integer n)->System.out.println("number is "+n)	//returns void, so no methods of any type can be called after
 *															//and this prints out each of the numbers produced by
 *															//by the previous stream (not all terminal operations return
 *															//void, but none return a Stream)
 *While this may look daunting at first, Streams, when you get used to them as there is of course a learning curve, are more intuitive
 *and allow complex problems to have more understandable and easier to comprehend solutions. As they are simply a series of steps, that
 *happen one after another and none happen until they all happen. Also if you build your stream, one operation at a time and test each 
 *operation, they are much easier to code than for instance a triple nested loop and also debug.
 *@see com.android.Main
 * @author noelf
 */
public class Examples {
	/**
	 * this method deals with basic creation of Streams by using the staic of() method 
	 * This method creates a Stream, but for anything to happen with the stream we have to have a terminal operator 
	 * CHAINED onto the stream. the code {@code
	 * Steam.of(100,200,300)}
	 * creates a stream of 3 Integers,  so if this returns a stream, that means it can call other stream methods, 
	 * one of those types of Stream methods is the Terminal operation {@code forEach(Consumer<T>)}. 
	 * forEach returns void, so that means no other stream methods can be called after this
	 * ForEach {@code 
	 * Stream.of(100,200,300).										//returns a Stream of type <Integer> so can call other 
	 * 																//stream method
	 * forEach(n->System.out.println("number doubled is "+(n*2)))  	//takes in a number n and doubles the number 
	 * 															  	//and returns void
	 * }. Stream creation and Stream intermediate operations, all return a Stream object, which means you can call another
	 * stream method after
	 */
	static void ex1() {
		Stream.generate(()->(int)(Math.random()*100)).limit(10).forEach((Integer n)->System.out.println("number is "+n));
		Arrays.asList(56,99,100,3000,500).forEach(n->System.out.println("number by 10 is "+(n*10)));
		System.out.println("ex1 creating streams");
		
		/*
		 * we will use this array to create a Stream of Integers, you can only 
		 * create Streams from arrays that contain only OBJECTS
		 */
		Integer[]values= {4,5,6};
		//can't be an array of ints
		int[]nums= {10,20,30};
		System.out.println("creating empty stream");
		Stream<String>empty=Stream.empty();
		System.out.println("creating stream of one element");
		Stream<Integer>singleElement=Stream.of(3);
		System.out.println(singleElement);
		System.out.println("creating a strem from an array");
		Stream<Integer>fromArray=Stream.of(values);
		//this is also creating a stream with the values 100,200,300
		Stream<Integer>fromArray2=Stream.of(100,200,300);
		System.out.println(fromArray);
		System.out.println("Foreach");
		/*
		 * Foreach is a Terminal operations that takes a consumer object
		 * consumer takes a object and returns nothing
		 * forEach here takes a consumer of type Integer, as fromArray is a stream
		 * with type Integer
		 */
		List<Integer>intList=new ArrayList<>();
		fromArray.forEach(
				(a1)->{
					System.out.println("number is "+a1);
					a1=a1*2;
					System.out.println("double our number is "+a1);
					intList.add(a1);
				}
				);
		
		System.out.println("first number in values is still "+values[0]);
		System.out.println(intList);
		
		List<String>fruits=Arrays.asList("apple","orange","banana","pineapple");
		/*
		 * this creates a stream from the List of strings called fruits
		 */
		/*Stream<String>fromFruits=*/
		System.out.println("uppercase text");
	//	List<String>listFruits=new ArrayList<String>();
		fruits.stream().limit(3).forEach(a->{
			a=a.toUpperCase();
			System.out.println(a);
			//listFruits.add(a);
		});
		Stream<String>fromFruits=fruits.stream();
		System.out.println(fromFruits);
		
		
		//fromFruits.forEach((str)->System.out.println(str+" tree"));
		fromFruits.forEach(System.out::println);
		/*
		 * this will not compile as forEach is a TERMINAL OPERATION, and once you
		 * perform a Terminal operation on a stream, you can no longer use it with
		 * any other opeartion
		 * this will generate an IllegalStateException, which is a runtimeexception
		 */
	//	fromFruits.forEach((str)->System.out.println(str));
		/*
		 * you have to redefine the stream if you want to use it again
		 */
		fromFruits=fruits.stream();
		fromFruits.forEach((str)->System.out.println(str+ " tree"));
		/*
		 * Parallel Streams utilises multiple CPU course if your  machine has them.
		 * ,if they are not parallel streams then they are said to be sequential (
		 * one after another)
		 */
		Stream<String>fromFruitPar=fruits.parallelStream();
		System.out.println(fromFruitPar);
		fromFruitPar.forEach((str)->System.out.println("johnny "+str+"seed"));
		/*
		 * creating a new stream<String> from fruits list of Strings
		 */
		fromFruits=fruits.stream();	
	}
	/**
	 * this method looks at the Stream method generate(), this is not a Terminal operation but is a means to Create a Stream.
	 *generate() takes a supplier, which takes no parameters and returns an object of whatever type we require. We wish
	 *to create a stream that will produce random numbers between 0 and hundred {@code 
	 *Stream.generate(()->(int)(Math.random()*100)) } the code
	 *()->(int)(Math.random()*100) is a supplier that generate() uses to produce an infinite series of numbers between 1 and 100.
	 *This only produces a Stream, not the actual numbers itself, the numbers will only be created if there is a terminal 
	 * operation. As the above produces a Stream that means it can call all the methods of the Stream class this can call
	 * a forEach Terminal operation, so we modify the above {@code
	 * Stream.generate(()->(int)(Math.random()*100)).forEach((n)->System.out.println("number is "+n))}
	 * this will print out the numbers in the format "number is 34", "number is 56", etc. However this is a Infinite Stream, as
	 *  thats what Stream.generate() produces is a Stream of Infinite objects, but the actual objects are not actually produced 
	 *  until a Terminal operation, in this case a forEach()
	 * we breifly look at how to limit a infinite Stream of objects to a set amount of items by using the intermediate operation
	 * limit(), an example of limit() with the above stream is this code, which produces just 10 random numbers
	 * between 1 and 100 and prints them out
	 * {@code Stream.generate(()->(int)(Math.random()*100)).limit(10).forEach(System.out::println)}
	 * @see com.android.Animal
	 */
	static void ex2() {
		;
		System.out.println("ex2");
		System.out.println("produce random numbers between 1 and 100");
		//(int)(Math.random()*100)
		System.out.println("random number is "+(int)(Math.random()*100));
		System.out.println("generate()");
		/*
		 * you can produce an infiinte stream very easily, can't create an infinite list
		 * generate takes a supplier, which takes no parameters and returns an object
		 * of type T, in this case it will return an Integer
		 * generate produces an infinite amount of objects, in this case an infinite
		 * amount of Integers between the numbers 0 and 100
		 * however this code does NOT run until a terminal operation is called
		 * on the stream
		 * generate takes a supplier object
		 */
		Stream<Integer>randoms=Stream.generate(
				()->{
					System.out.println("****randoms generated****");
					return (int)(Math.random()*100);
				}
				);
		System.out.println("test print");
		//randoms.forEach((s)->System.out.println(s));;
		/*
		 * this causes our randoms code to run and produces an infinite amount of
		 * Integers
		 */
	//	randoms.forEach(System.out::println);
		System.out.println("limit()");
		/*
		 * limit is a intermediate operation that does not run until the stream hits
		 * a terminal operation
		 */
		randoms.limit(5).forEach(System.out::println);;
		
		Stream<Animal>ranAnimal=Stream.generate(
				()->{
					int num=(int)(Math.random()*100);
					return new Animal(num,"andy");
				}
				);

		//will be used to create our stream of Animals
		Supplier<Animal>supAnimal=()->{
			int num=(int)(Math.random()*100);
			return new Animal(num,"andy");
		};
		/*
		 * this code will only run if a terminal operation runs on this the
		 * stream ranAnimal. if we do not include a limit() on this stream, then
		 * you will get an infinite amount of Animals
		 */
		ranAnimal=Stream.generate(supAnimal);
		System.out.println("Animals not created");
		/*
		 * as generate() produces an infinite stream of objects, unless we limit()
		 * generate this will produce an infinite print out
		 */
		//ranAnimal.forEach(System.out::println);
		ranAnimal=ranAnimal.limit(3);
		System.out.println("animals still not created");
		/*
		 * once your run a terminal operation on a Stream, the stream is closed
		 * and can't be operated on again by any operation
		 */
		ranAnimal.forEach(System.out::println);
		//ranAnimal.limit(3).forEach(System.out::println);
		System.out.println("animals have been created");
		/*
		 * this will generate an IllegalStateException, as this stream is 
		 * already closed
		 */
	//	ranAnimal.limit(2);
		/*
		 * this will produce three Animals
		 */
				Stream.
				generate(supAnimal)
				.limit(3)
				.forEach(
						(a)->System.out.println(a)
						);
		
		
	}
	/**
	 * this method shows the Stream method iterate, this is not a Terminal operation but a means to create a Stream of
	 * numbers. iterate() takes two arguments a Seed object and a Unary operator (one parameter and return type
	 * both of the same type)
	 * For instance this stream creates a Stream of 5 numbers starting at 2 and incrementing by 10 every time
	 * {@code Stream.iterate(2, n->n+10).limit(5).forEach(System.out::println);}
	 * a breakdown of the iterate is the following
	 * iterate(2		//first arguement is the starting point or seed
	 * ,n->n+10)		//a unary operator that takes in a number and adds 10 to that number to produce a new number
	 * this will produce the following sequence 2, 12, 22, 32 and 42
	 * iterate() like generate() produces an infinite stream, which is why we use it with a limit(5) to produce a stream that 
	 * produces only 5 numbers
	 */
	static void ex3() {
		Stream.iterate(2, n->n+10).limit(5).forEach(System.out::println);
		System.out.println("***ex3");
		System.out.println("iterate()");
		/*
		 * also used for creating streams
		 * iterate for streams takes two parameters, a seed which will be a starting
		 * value and a unary operator (unary operater takes a object and returns 
		 * an object of the same type)
		 * in this case we have a starting seed of the number 1 and add 2 to the 
		 * number each time, which produces an infinite stream of odd numbers,
		 * starting at 1-> 1+2=3,3+2=5, etc
		 * iterate() just like generate(), if not limited, will produce an infinite amount
		 * of objects, in this case numbers
		 */
		Stream<Integer>oddNumbers=Stream.iterate(1, n->n+2).limit(60);
		/*
		 * this will produce an infinite stream of odd numbers
		 */
		//oddNumbers.forEach(System.out::println);
		oddNumbers.limit(25).forEach(System.out::println);
		/*
		 * the above stream is  now closed so we cannot perform any more operations
		 * on it, if we try we get the runtimeException IllegalStateException
		 */
		//oddNumbers.limit(10);
		System.out.println("produce 25 random even numbers");
		Stream<Integer>evenNumbers=Stream.iterate(2, 
				(n)->{
					Integer number=(int)(Math.random()*1000);
					/*
					 * if the number modulus 2 is 0 then the number is even
					 * and return that number
					 * if the number modulus 2 is 1 the number is odd and we add
					 * 1 to the number to make it even
					 * (i.e 333 is odd, add one, becomes 334, which is even
					 * 
					 */			
					return number%2==0?number:number+1;
			/*		if(number%2==0)
						return number;
					else
						return number+1;*/
				}
				);
		//this will produce an infinite amount of even numbers
		//evenNumbers.forEach(System.out::println);
		//evenNumbers.limit(25).forEach(System.out::println);
	//	evenNumbers.filter((n)->n%10==0).forEach(System.out::println);;
		
		List<String>people=new ArrayList<>(Arrays.asList("noel","mary","shelly","colm"));
		/*
		 * filter takes a predicate and only objects that meet the crieria of the 
		 * predicate, will be produced, in this case only strings that have a 
		 * name length greater than four in the list of people will be created, which
		 * is the string "shelly"
		 */
		 people.stream().filter(s->s.length()>4).limit(4).forEach(System.out::println);
		 
	}
	/**
	 * this method does a recap of generate() and iterate() and has a brief introduction to intermediate operations
	 * {@code filter(Predicate<T>} //returns a new stream with only object that matches what the predicate is testing for
	 * also we show how to use this in conjunction with Limit()
	 */
	static void ex4() {
		Supplier<Animal>supAnimal=()->{
			int num=(int)(Math.random()*100);
			return new Animal(num,"andy");
		};
		/*
		 * each intermediate operation on a stream, creates a new stream and 
		 * effectively closes the stream it is operating on
		 */
		Stream<Animal>ranAnimal=Stream.generate(supAnimal);//creates stream A
		/*#
		 * this effectively closes the stream ranAnimal and creates a new Stream
		 * that we cannot access after this line of code as we have not assigned
		 * this stream to anything
		 * as there is no terminal operation, the code does not instantiate. 
		 * streams uses lazy instantation and will only execute at a Terminal operation
		 */
		ranAnimal.limit(20);//creates Stream B, effectively closes Stream A
		/*
		 * this generates a IllegalStateException as we have already operated on this
		 * stream which effectively closes teh stream
		 */
		ranAnimal.filter(a->a.age>20);
		/*
		 * this also produces a IllegalStateException as this stream has already been
		 * operated on and is effectively closed
		 */
	//	ranAnimal.forEach(System.out::println);
		/*
		 * this produces a new Stream A which is assinged to ranAnimal
		 */
		Stream.generate(supAnimal)
				.filter(a->a.age>20).
				limit(5).
				forEach(System.out::println);;
		/*
		 * this produces a new Stream B from from Stream A and effectively closes 
		 * Stream A
		 */
		ranAnimal=ranAnimal.filter(a->a.age>20);
		/*
		 * this produces a new Stream C from strem B and effectively closes Stream
		 * B
		 */
		ranAnimal=ranAnimal.limit(5);
		System.out.println("print out five Animals");
		/*
		 * executes stream C, which causes all our stream code to run and closes 
		 * stream C
		 */
		ranAnimal.forEach(System.out::println);
		
		Stream.generate(supAnimal).
		filter(
				a->a.age>20
				).
		limit(5).
		forEach(System.out::println);
		System.out.println("another five Animals");
		ranAnimal=Stream.generate(supAnimal).
				filter(
						a->a.age>20
						).
				limit(5);
		ranAnimal.forEach(System.out::println);
		System.out.println("creating 7 Animals");
		/*
		 * you can't assign this to anything as the final method call is what determines
		 * what the line of code as a whole returns. ForEach returns VOID, so this
		 * CANNOT BE assigned to any variable
		 */
		/*ranAnimal=*/
		List<Animal>animals=new ArrayList<>();
		animals.clear();
		/*
		 * this is generating 7 animals and then adding each Animal to ArrayList
		 * of Animals
		 */
		Stream.generate(supAnimal).
		filter(
				a->a.age>20
				).
		limit(7).
		forEach(
				(a)->{
					System.out.println(a);
					animals.add(a);
				}
				);
		System.out.println("animals is "+animals);
		
	}
	/**
	 * This method covers a type of Terminal operation that are categorised under the broad heading of Reductions. 
	 * Reductions are when we reduce a Stream of Object to ONE single value. 
	 * i.e count() counts the amount of objects in a stream and returns that number
	 * the method covered in this method are
	 * count()
	 * max()
	 * min()
	 * count() is the simpliest reduction and simply counts the amount of objects created in a stream as it is a often the
	 * case with stream we will not know how many objects a Stream creates, count() returns a long{@code
	 * Stream.generate(()->(int)(Math.random()*100)).limit(15).filter(n->n>50).count();}
	 * we use count here as we don't know how many numbers will be created after we filter those numbers greater than 50
	 * max() and min() return an Optional of type of the Stream, so a {@code Stream<Integer>} return a {@code Optional<Integer>}
	 * for max() or min()
	 * max() and min() both takes a comparator, which is usually a lambda that implements Comparator and returns 
	 * a {@code Optioanl<T>}, and it has to be an Optional as the stream may have nothing in it.
	 * we create comparator lambda for Integers (n1,n2)->n1.compareTo(n2)
	 * this can then be used like the following, to get the largest number from 5 numbers generated {@code
	 * Stream.generate(()->(int)(Math.random*100)).limit(5).max((n1,n2)->n1.compareTo(n2))}
	 * and min uses the same comparator to get the smallest number from 5 numbers generated{@code
	 * Stream.generate(()->(int)(Math.random*100)).limit(5).min((n1,n2)->n1.compareTo(n2))}
	 * we also use the Rat and Animal class in this method
	 * @see com.android.Animal
	 * @see com.android.Rat
	 */
	static void ex5() {
		System.out.println("*****Reductions");
		Stream.generate(()->(int)(Math.random()*100)).limit(15).filter(n->n>50).count();
		/*
		 * Reductions are special type of Terminal operation where all objects created
		 * by the stream are combined into a single value
		 */
		System.out.println("Count");
		/*
		 * counts the amount of objects in a stream, and it returns a long
		 */
		System.out.println("count is a reduction");
		Stream<Integer>numStream=Stream.generate(()->(int)(Math.random()*100))
				.limit(15);
		System.out.println("amount of objects created ");
		/*
		 * Terminal operation, executes the code and closes the stream
		 */
		System.out.println(numStream.count());
		numStream=Stream.generate(()->(int)(Math.random()*100));
		System.out.println("count on a infinite stream");
		/*
		 * this leads to a infinite hang, where your program will keep counting
		 * to infinity and never return a result
		 */
	//	System.out.println(numStream.count());
		
		/*
		 * this generates 20 random numbers and then filters out those 20 numbers to
		 * only number greater than 50. The numbers are NOT created at this point
		 * its only at the teriminal operation are these numbers created
		 */
		numStream=Stream.generate(()->(int)(Math.random()*100)).
				limit(20).
				filter(i->i>50);
				
		//numbers created here and closes the last stream
		System.out.println(numStream.count());
		/*
		 * count() returns a long, which can only be assigend to a long or a 
		 * compatible data type (Long wrapper or a double, as long can fit inside
		 * a double)
		 */
		long lNum=Stream.generate(()->(int)(Math.random()*100)).
				limit(20).
				filter(i->i>50).
				count();
		double dnum=lNum;
		
		System.out.println("min and max");
		numStream=Stream.of(234,56,11,2,6,99);
		/*
		 * Min method signature looks like this
		 * has to optional as if dealing with an infinite stream then there is no
		 * max or min and you can also produce empty streams by
		 * going Stream.empty();
		 * Optional<T>min(<? super T>comparator)
		 * this produces an infinite stream of Integers so there is no max or min
		 */
	//	Stream.iterate(2, n->n+2).forEach(System.out::println);
		/*
		 * min and max both take a Comparator which is a object that implements
		 * the Comparator interface, and the comparator interface only has one
		 * method <T>long compare(T t,T t2)

		 * here we take in two ints 
		 * n1 and n2
		 * and use the compareTo() method of the Integer class that takes an Integer 
		 * in this case and compares it with the Integer calling the method.
		 * The integer class implements the Comparable interface, and compareTo() isa
		 * method of the Comparable interface
		 */
		Comparator<Integer>compInt=(n1,n2)->n1.compareTo(n2);
		//both max and min takes the same comparator
		Optional<Integer>mini=numStream.min(compInt);
		System.out.println("minumum number is "+mini.get());
		numStream=Stream.of(234,56,11,2,6,99);
		mini=numStream.min((n1,n2)->n1-n2);
		System.out.println("minimum number is "+mini.get());
		System.out.println(mini.get());
		Optional<Integer>maxi=Stream.of(234,56,11,2,6,99).max((n1,n2)->n1.compareTo(n2));
		System.out.println("maxi is "+maxi.get());
		maxi=Stream.of(234,56,11,2,6,99).max((n1,n2)->n1-n2);
		System.out.println("maxi is "+maxi.get());
		
		Stream<Integer>noNum=Stream.empty();
		Optional<Integer>optNo=noNum.max((n1,n2)->n1-n2);
		System.out.println("optNo.get is ");
		//System.out.println(optNo.get());
		System.out.println("ifPresent");
		/*
		 * if optNo has a value, do something
		 * ifPresent takes a consumer object and returns void
		 */
		optNo.ifPresent(
				(n1)->{
					System.out.println(n1);
				}
		
				);
		/*
		 * returns a boolean, true if the optional has a value
		 * false if the optional has no value
		 */
		if(optNo.isPresent())
			System.out.println(optNo.get());
		else
			System.out.println("no value");
		/*
		 * if optNo has no value, which an optional can have, return 0
		 * orelseGEt takes a supplier object
		 * if the optional has no value it uses the supplier object to create a 
		 * object for it
		 * in this case if optNo has no value, it will assign the value "0" to 
		 * optNo
		 */
		System.out.println(optNo.orElseGet(()->0));
	/*
	 * this supplier object will be used to create Animals all called andy with
	 * random ages between 0 and 100
	 */
		Supplier<Animal>supAnimal=()->{
			int num=(int)(Math.random()*100);
			return new Animal(num,"andy");
		};
		
		List<Animal>zoo=new ArrayList<Animal>();
		/*
		 * this produces 10 Animals that are added to our list of Animals called
		 * Zoo
		 */
		Stream.generate(supAnimal).
		limit(5).
		forEach(
				(a)->{
					zoo.add(a);
					System.out.println(a);
				}
				);
		
		System.out.println("animal with max age is ");
		//this will get the Oldest animal, to get the value of an optional, use get()
		System.out.println(zoo.stream().max((a1,a2)->a1.age-a2.age).get());
		/*
		 * can't compareTo with Animal as Animal has NOT implemented the Comparable
		 * interface
		 */
		System.out.println(zoo.stream().min((a1,a2)->a1.age-a2.age).get());
		;
		Rat r1=new Rat(12,"zed",2.3);
		Rat r2=new Rat(12,"zed",2.3);
		Rat r3=new Rat(7,"adam",1.2);
		Rat r4=new Rat(5,"Carol",2.56);
		List<Rat>ratList=new ArrayList<>(Arrays.asList(r1,r2,r3,r4));
		System.out.println("minimum rat");
		//this gets the Optional of type Rat
		System.out.println(ratList.stream().min((rat1,rat2)->rat1.compareTo(rat2)));
		System.out.println("maximum rat");
		//this gets the actual Rat
		System.out.println(ratList.stream().
				max((rat1,rat2)->rat1.compareTo(rat2)).get());
		/*
		 * sets remove ducplicates
		 */
		Set<String>strSet=new HashSet<>();
		//only one apple added to this list
		strSet.addAll(Arrays.asList("orange","apple","banana","apple","pineapple"));
		;
		System.out.println(strSet);
		System.out.println(strSet.stream().min((s1,s2)->s1.compareTo(s2)).get());
		//both r1 and r2 rat have same name, age and weight, so can be said to be
		//equal, using the equals and hashcode method of the Rat class, so only
		//one Rat called zed will be added
		Set<Rat>ratSet=new HashSet<>();
		ratSet.addAll(ratList);
		System.out.println(ratSet.stream().max((s1,s2)->s1.compareTo(s2)).get());
		System.out.println(ratSet.size());
		
	}
	/**
	 * The method describes finaAny() and findFirst(), which are both Terminal Operations
	 * findAny() will display if there is any element in a stream, it returns an Optional of type of the Stream, so
	 * {@code Stream<Integer>} with findAny returns a {@code Optional<Integer>}
	 * findFirst() will return the first element in a stream if there is any elements in the stream, it returns an Optional
	 * of type of the Stream, so 
	 * {@code Stream<Integer>} will return a {@code Optional<Integer>}
	 * @see com.android.Animal
	 */
	static void ex6() {
		System.out.println("**ex6");
		System.out.println("findAny()");
		/*
		 * findAny will display if there is any element in a sttream
		 * it does not take any variables, but it returns an optional
		 * it is a terminal operation, but it is NOT a reduction as it does not
		 * reduce the stream to a single value and returns an Optional
		 */
		Stream<String>apes=Stream.of("monkey","gorilla","oran Utang");
		//this will return the string "monkey"
		apes.findAny().ifPresent(System.out::println);
		apes=Stream.empty();
		//this will return nothing as the stream 
		apes.findAny().ifPresent(System.out::println);
		apes=Stream.empty();
		//orElseGEt will return a string, not matter what
		//if there is no string in the apes stream, then this will return the string 
		//"chimp
		System.out.println(apes.findAny().orElseGet(()->{
			System.out.println("no monkey so return chimp");
			return "chimp";
		}));
		apes=Stream.of("monkey","gorilla","oran Utang");
		/*
		 * this will return "monkey" as there is values in this stream so findAny will
		 * return the first string it finds, which is "monkey"
		 */
		System.out.println(apes.findAny().orElseGet(()->{
			System.out.println("no monkey so return chimp");
			return "chimp";
		}));
		
		apes=Stream.of("monkey","gorilla","oran Utang");
		/*
		 * this will check if your stream is empty or not
		 */
		System.out.println(apes.findAny().isPresent());//true
		apes=Stream.empty();
		System.out.println(apes.findAny().isPresent());//false
		System.out.println("creating a randon series of infinite numbers");
		Stream<Integer>infiniteNums=Stream.generate(()->(int)(Math.random()*100));
		System.out.println(infiniteNums.findAny().get());
		
		System.out.println("****findFirst");
		/*
		 * returns a optional, has to optional as this may be an empty string
		 * and as far as i can see it's the same as findAny
		 */
		ArrayList<Animal>listAnimal=new ArrayList<Animal>();
		Stream.generate(()->new Animal()).
		limit(5).
		forEach((a)->{
			System.out.println("animal "+a+" is added to the arraylist");
			listAnimal.add(a);
		});
		System.out.println(listAnimal);
		System.out.println(listAnimal.stream().
				findFirst().
				orElseGet(null));	
	}
	/**
	 * the method covers the anyMatch(), allMatch() and noneMatch()
	 * anyMatch
	 * if any items in a stream matches what this predicate is look for, this 
	 * will return true (i.e looking for any Dog with the name of "spot")
	 * {@code boolean anyMatch(Predicate<? super T> predicate)}
	 * allMatch
	 * if ALL items in stream matches what this predicate is looking for, this
	 * will return true (i.e are all dogs in the stream called "spot"
	 * {@code boolean allMatch(Predicate<? super T>predicate)}
	 * noneMatch
	 * if no items in a stream matches what this preidcate is looking for, this
	 * will return true (i.e is there no dog called "spot" in this stream
	 * {@code boolean noneMatch(Predicate<? super T>predicate)}  
	 */
	static void ex7() {
		System.out.println("terminal operations anyMatch(),allMatch(),noneMatch()");
		
		List<String>list=new ArrayList<>();
		list.addAll(Arrays.asList("monkey","2","chimp"));
		Stream<String>infinite=Stream.generate(()->"chimp");
		Stream<String>streams=Stream.of("monkey","2","chimp");
		
		Predicate<String>pred=x->Character.isLetter(x.charAt(0));
		/*
		 * this checks the strings "monkey" "2" and "chimp" to see do they all beging
		 * with a character, they don't so this will return false
		 */
		System.out.println(list.stream().allMatch(pred));//false
		/*
		 * this checks the strings "monkey" "2" and "chimp" to seee do they all 
		 * NOT begin with a character, both "monkey" and "chimp" DO begin with a 
		 * character, so this also returns false
		 */
		System.out.println(streams.noneMatch(pred));//false and streams is now closed
		/*
		 * this checks the strings "monkey" "2" and "chimp" to see do ANY of the strings
		 * begin with a Character, both "monkey" and "chimp" do, so this will return
		 * true
		 */
		System.out.println(list.stream().anyMatch(pred));//true
		System.out.println("you can use anyMatch with an infinite stream");
		System.out.println(infinite.anyMatch(pred));//true
		infinite=Stream.generate(()->"chimp");
		/*
		 * can't answer this question as this would go on for infinity, so we have
		 * to kill the process for our code to continue
		 */
		//System.out.println(infinite.allMatch(pred));
		System.out.println(infinite.noneMatch(pred));//true
		
	//	pred=x->Character.isDigit(x.charAt(0));
		/*
		 * this will produce infinite amount strings that contain the int "2"
		 * whihc when tested against our predicate that checks to see if the first
		 * character is a letter, will return false. and if anyMatch, or NoneMach()
		 * can return false from a infinite stream, then this will contine on 
		 * forever (infinite processing)
		 */
		infinite=Stream.generate(()->"2");
		
		//System.out.println(infinite.anyMatch(pred));
	//	System.out.println(infinite.noneMatch(pred));
		/*
		 * this could be useful in GUI
		 */
		pred=x->Character.isDigit(x.charAt(0));
	}
	/**
	 * this method concerns the terminal operation toArray() this take all the elements of a Stream and puts them into
	 * an array of type of objects of the stream.
	 * toArray produces an array of objects, so if you wish to create a specific array of a specific type then you have to
	 * cast it to be that type 
	 * {@code Integer[]numArray=(Integer[]) Stream.generate(()->(int)(Math.random()*100)).limit(4).toArray();}
	 */
	static void ex8() {
		System.out.println("***ex8");
		System.out.println("toArray()");
		
		Object[]nameArray=Stream.of("mary","kate","pat").toArray();
		
		Integer[]numArray2=(Integer[]) Stream.iterate(2, n->n*2).limit(6).toArray();
		Stream<Integer>numStream= Stream.iterate(2, n->n*2).limit(6);
		
		
	}
	/**
	 * this method covers in more detail the forEach() Stream Terminal Operation. It is important to note that this is
	 * NOT A LOOP and there is in other programming languages a forEach loop (PHP for examples). forEach Traverses a Stream
	 * of objects and allows us to access each one of the Objects of a Stream. forEach returns void, which means as well
	 * as not being able to call any other Stream methods, it is not able to call ANY methods.
	 * forEach takes a consumer of type of the Stream, so for a stream of Integers you have a consumer of type Integer.
	 * an example of a forEach(), this code geneates 5 random numbers between 1 and 100 and uses the forEach to print
	 * out each of the numbers. The forEach takes a {@code Consumer<Integer>} and calls that Integer "n" and then prints
	 * out each number in the format "our number is 5", "our numbers is 45", etc
	 * {@code Stream.generate(()->(int)(Math.random()*100)).limit(5).forEach(n->System.out.prinln("our number is "+n)}
	 * this method also covers the terminal operation forEachOrdered() and it's usage in conjunction with parallel Streams. 
	 * go to
	 * <a href="https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html">click here</a>for more details
	 * Parallel streams can offer large performance increases for your application, through the principle of concurrency and
	 * rather than one object in your stream being dealt with in a ordered fashion, one at a time, A parallel stream can
	 * be operating on many objects in a stream at the same time. Parallel streams then cannot guarantee order in the
	 * output of your Steam, which is where forEachOrdered() comes in, and imposes predictable output in your streams.
	 * i.e stream produces a list of people sorted by age.
	 * ForEachOrdered() is a Terminal operation that takes a Consumer 
	 * A more detailed outlook on parallel streams is covered in section F7.5WorkingWithParallelStreams
	 */
	static void ex9() {
		System.out.println("**ex9");
		System.out.println("forEach()");
		/*
		 * forEach takes a Consumer, consumer takes a object and returns void
		 */
		Stream<String>animalStream=Stream.of("monkey","gorilla","bonobo");
		List<String>animals=new ArrayList<String>();
		animalStream.forEach(s->animals.add(s));
		animalStream=Stream.of("monkey","gorilla","bonobo");
		animalStream.forEach(animals::add);
		System.out.println("animals is "+animals);
		
		animals.stream().forEach((s)->{
			System.out.println("animal is "+s);
			System.out.println("animal lives in "+s+" house");
			/*
			 * this leads to the runtimeException 
			 * ConcurrentModificationException as you can't access
			 * a collection object by name directly inside a stream
			 */
			//animals.add(s);
			return;
		});
		/*
		 * you can call a forEach on a infinite stream and it will keep going
		 * forever
		 */
	//	Stream.generate(Animal::new).forEach((a)->System.out.println(a));
		/**
		 * FOREACH IS NOT A LOOP IN JAVA, there are forEach loops in other programming
		 * languagees
		 */
		System.out.println("forEachOrdered");
		/*
		 * this is for parallelStreams
		 * parallelStreams are much faster, if the machine your running your application
		 * on has multiple cores.
		 * you can call a forEachOrdered on a non parallel stream but it operates 
		 * exactly the same as on a parallel stream
		 */
		System.out.println("not sorted");
		
		animals.parallelStream().forEach((s)->System.out.println("not in order "+s));
		System.out.println("sorted");
		/*
		 * up to the forEachOrdered this is a parallel Stream with all the speed
		 * advantages, and from the forEachOrdered it is now a non parallel stream
		 */
		animals.parallelStream().forEachOrdered(s->System.out.println("in order "+s));
	}
	/**
	 * max(), min(), count() are all REDUCTION terminal operations, in that they reduce your stream to ONE value.
	 * max() takes the steam and returns the LARGEST object, wihch is ONE value
	 * min() takes the stream and returns the SMALLEST object, which is ONE value
	 * count() takes the steam and returns the amount of objects in the stream, which is ONE value
	 * there is also the terminal operation reduce(), which allows us to take a stream of objects and combine all these
	 * objects into one object in whatever way we want, 
	 * i.e takes many strings to produce a book, 
	 * takes many weekly wages from our 1000 employees to get the total amount paid out in wages for the year, which can
	 * also contain all tax, prsi, pension contributions, etc and all costs in this one object.
	 * This method covers three overloaded reduce methods
	 * First Overloaded reduce()
	 * {@code <T>  t reduce(T identity,BinaryOperator<T>accumulator)}
	 * this returns a object of type T and takes as two parameters,
	 * first paraemeter is an object of type T, which will be the starting point (i.e a String
	 * would start at a "", if calculating a sum of numbers, this would start at the number 0)
	 * , and a binary operator and the
	 * binary operator takes two object of the same type T and returns one
	 * object of type T
	 * so for instnace this could take a stream of Integers, and each number in the stream would be be the variable
	 * identity and the binaryOperator takes each numbers and adds it to a running total until all the numbers are
	 * added up to produce one number, this is an example 5 random Integers being produced and all the numbers
	 * added up to produce a total of all the number, sum will be the total of all numbers in the stream
	 * {@code Integer sum=Stream.generate(()->(int)(Math.random()*100))
								.limit(5)
								.reduce(0,(n1,n2)->n1+n2}
	 *Second overloaded reduce() {@code
	 *Optional<T> reduce(BinaryOperator<T>Accumulator)}
	 *this returns an Optional of type T, so that means you will have to use a get()method, or one of the other of the 
	 *Optional class to get the value.
	 *This terminal operation takes one argument, which is a binaryOperator of Type T, which takes two objects and returns
	 *one object, all the same type. Again we, as an example, take a Stream of Integers and add them all up with this
	 *Terminal operation, notice the get() as this terminal operation returns a {@code Optional<Integer>}
	 *{@code Integer total2=Stream.generate(()->(int)(Math.random()*100))
									.limit(5)
									.reduce((n1,n2)->n1+n2)
									.get();}
	 *Third Overloaded reduce()
	 * this third overloaded reduce method is for parallelStreams, but it will  work also on streams, 
	 * but you don't get the savings on time if you use this with ordinary streams.
	 * See section 7.5 WorkingWithParallelStrams for more information about Parallel Streams
	 * {@code <U> U reduce(U indenty,
	 * 				BiFunction<U,? super T,U>,
	 * 				BinaryOperator<U>accumulator)}
	 * This deals with the seperate topic of Parallel Streams, and this method will also be discussed further 
	 * section 7.5
	 */
	static void ex10() {
		System.out.println("***ex10");
		System.out.println("reduce");
		Integer total2=Stream.generate(()->(int)(Math.random()*100))
		.limit(5)
		.reduce((n1,n2)->n1+n2)
		.get();
		System.out.println("sum is "+total2);
		;
		/*
		 * three overloaded methods
		 * FIRST OVERLOADED REDUCE
		 * this returns a object of type T and takes as two parameters,
		 * first paraemeter is an object of type T, and a binary operator and the
		 * binary operator takes two object of the same type T and returns one
		 * object of type T
		 * 
		 * Stream<Integer>intStream=Stream.generate().
		 * limit(10).reduce(0,(n1,n2)->n1+n2);
		 */
		/*
		 * this is concatenating all the strings in the array to one string, the string 
		 * result
		 */
		System.out.println("concatnating strings with loops and arrays");
		String[]array=new String[] {"who's "," afraid "," of "," virginia", " wolf "};
		String result="";
		for(String s:array)
			result=result+s;
		System.out.println(result);
		/*
		 * the reduce takes two arguements
		 * takes a object of type T, in this case a String as first argument
		 * which is the starting point
		 * and a binaryOperator of Type T, again in this case a string, so this
		 * binary operator takes two strings and returns 1 string
		 */
		System.out.println("concatenating with Streams");
		String myString=Stream.of(array).
				/*
				 * we start with a space and end up with one string that is 
				 * " who's afraid of virginai wolf"
				 */
						reduce(" ",(s1,s2)->s1+s2);
		System.out.println(myString);
		/*
		 * SECOND OVERLOADED REDUCE
		 * Optional<T> reduce(BinaryOperator<T>Accumulator)
		 * this returns a Optional object of type T annd takes only ONE parameter, which
		 * is a BinaryOperator, takes in two object of type T and returns one object
		 * type T
		 * 
		 */
		Optional<Integer>optInt=Stream.iterate(1, n->n*10).
				limit(5).
				/*
				 * peek takes a consumer object and returns a new stream
				 * and is used for debugging (checking your code is producing the
				 * right output
				 */
				peek(System.out::println).
				reduce((n1,n2)->n1+n2);
		System.out.println(optInt.orElseGet(()->0));
		
		List<Integer>intList=new ArrayList<Integer>();
		/*
		 * this is creating 10 random numbers and adding those random numbers
		 * to the already created intList list of Integers
		 */
		System.out.println("generate 10 random numbers ");
		Stream.generate(()->(int)(Math.random()*100))
							.limit(10).
							peek(System.out::println).
							forEach((i)->{
								intList.add(i);
								}
							);
		System.out.println("treeset of ints");
		TreeSet<Integer>tInt=new TreeSet<>();
		Stream.generate(()->(int)(Math.random()*100))
				.limit(5).
				peek(System.out::println).
				forEach(
						(i)->tInt.add(i)
						);
		System.out.println("treeSet of ints is "+tInt);
		/*
		 * it's taking the treeset of random numbers and adding them all up
		 * if you want sum to be a definate value, you have to use the 
		 * reduce method that takes a Integer and a BinaryOperator<Integer>
		 */
		int sum=tInt.stream().reduce(0,(a,b)->a+b);
		System.out.println("our numbers are "+tInt);
		System.out.println("sum of which is "+sum);
		/*
		 * if you use this method, it produces an optional, so you have use
		 * orElseGet or use get in combination with a if statement or ternary operator
		 */
		Optional<Integer>optSum=tInt.stream().reduce((a,b)->a+b);
		System.out.println(optSum.orElseGet(()->0));
		/*
		 * only objects whose class implements the comparable interface can
		 * be inserted into a treeset and objects are then organised in treeset
		 * as deemed by the compareTo method, see Rat class
		 */
	//	TreeSet<Rat>ratSet=new TreeSet<>();
		/*
		 * animal does not implement Comparable, so you can't add a Animla to this
		 * set, however one of the subclasses of Animal may implement comparable
		 * so we can add subclasses to this treeSet. Badget extends Animal and
		 * implements comparable so it can be added to treeSet of Animals
		 */
	//	TreeSet<Animal>animalSet=new TreeSet<>();
	//	ratSet.add(new Rat());
		//this will give a classCastException
		//animalSet.add(new Animal());
		//this will compile fine as  badger extends Animal and implements Comparable
	//	animalSet.add(new Badger());
		List<Integer>numbers=new ArrayList<Integer>();
		Stream.
		generate(()->(int)(Math.random()*100)).
		limit(10).
		forEach(numbers::add);
		//this will multiply all the numbers in a stream
		BinaryOperator<Integer>biOp=(a,b)->a*b;
		
		Optional<Integer>total=numbers.stream().
				peek(System.out::println).
				reduce(biOp);
		System.out.println("total is "+total.get());
		//sum=0;
		sum=numbers.stream().
				peek(System.out::println).
				reduce(1,biOp);
		System.out.println("sum is again "+sum);
		/*
		 * this third overloaded reduce method is for parallelStreams, but it will
		 * work also on streams, but you don't get the savings on time if you use
		 * this with ordinary streams
		 * <U> U reduce(U indenty,
		 * 				BiFunction<U,? super T,U>,
		 * 				BinaryOperator<U>accumulator)
		 */
		sum=numbers.parallelStream().reduce(1, biOp,biOp);
		System.out.println("sum produced by parallel stream is "+sum);
		
		
	}
	/**
	 * this method covers the Collect() Terminal operation and is a reduction, in that it reduces your Stream to
	 * one object. There are two overloaded methods that at first glance look rather complex, but however in practice
	 * the second overloaded method is particular is relatively easy and straightforward to use. Collect() can be used
	 * to quickly place all the objects of your Stream into a new Collection object (List,Set,Queues) or Map, which is
	 * what is most often used for, however it can also be used to reduce all your streams to whatever single object you
	 * want.
	 *FIRST OVERLOADED METHOD
	 *{@code <R> R  collect(Supplier<R> supplier,
	 * 						BiConsumer<R,? superT>,
	 * 						BiConsumer<R,R> combiner)} 
	 * This returns a Object of type R, which will be all the objects in the stream combined into one returned object.
	 * First Parameter 
	 * is a Supplier and the object that we will use to combine all our objects, i.e a TreeSet that will have all 
	 * our Integers, a String that will contain all our strings combined into one String.
	 * Second parameter 
	 * is a BiComsumer() that takes as its first argument the first parameter (i.e a empty list) and the second argument 
	 * for this will be each object in the Stream. 
	 * Third parameter
	 * As this is for parallel streams, you could end up with many objects (many lists, many String, many TreeSets, ect)
	 * so for example if this method has to produce one list, and this method produced 4 separate lists up to this point, 
	 * this will take two arguments (t1 and t2), which will be the lists and we would use this third argument to combine
	 * all those lists into one list
	 * an example of this is
	 * {@code TreeSet<String>set2=Arrays.asList("hello","hello", "there","you","you")
	 * 									.parallelStream()
	 * 									..collect(
												()->new TreeSet(), 
												(t,s)->t.add(s),
												(t1,t2)->t1.addAll(t2)
												)}
	 *SECOND OVERLOADED METHOD
	 *{@code <R,A> R collect(Collector<? super T, A,R> collector)}
	 *This returns Collection or Map Object R.
	 *this takes as a parameter an object that implements the Collector interface with the types
	 *T - which will be the type of object added to our final Collection or Map object, i.e Integer
	 *A - what happens to each element in the stream in relation to the Map or collection object, i.e
	 *		object added to list, but you do not have to explicty say this in code and is done implicitly
     *R - the result type of the reduction operation, which will usually be a Collection or a Map .ie Set
     *whereas the above looks complicated in practice the coding is relatively straightforward
     *we create a List of Strings{@code 
     *List<String>names=new ArrayList<String>(Arrays.asList("noel","noel","pat","mary","mary","pat");}
     *and then we create a Set of String that will remove all duplicates using the above collect method {@code
     *Set<String>treeName=names.stream().collect(Collectors.toSet());}
     *there static methods (Collectors.toSet()) are one of many (Collectors.toList(), Collectors.toMap(), etc) that can
     *quickly add elements from a stream to a Collection or map. 
     *you can also create a particular type of Collection object, i.e a TreeSet {@code
     *Set<String>treeName=names.stream().collect(Collectors.toCollection(TreeSet::new));
     *}
	 */
	static void ex11() {

		
		Set<Integer>setInt=Arrays.asList(56,78,99,56,78).stream().collect(Collectors.toSet());
		List<String>names=new ArrayList<String>(Arrays.asList("noel","noel","pat","mary","mary","pat"));
		Set<String>treeName=names.stream().collect(Collectors.toCollection(TreeSet::new));
		System.out.println(treeName);
		System.out.println("ex11***");
		System.out.println("Collect");
		
	//	Stream.generate(()->(int)(Math.random()*100)).limit(5).collect(Collectors.toMap(keyMapper, valueMapper));//limit(5).collect(Collectors.toSet()));
		/*
		 * collect is something called a "mutable reduction", it's working on the
		 * same object so it's more efficient as you are using the same mutable object
		 * there are two overloaded Collect method, that do the same thing
		 * <R> R  collect(Supplier<R> supplier,
		 * 					BiConsumer<R,? superT>,
		 * 					BiConsumer<R,R> combiner)
		 * returns a variable of type R
		 * First parameter is the object that will end up being the combination of all the objects in the stream, i.e
		 * a TreeSet, that will have all the Strings of your Stream or a single String that will be a combination of
		 * all the Strings in your Stream.
		 * the second arguement is a BiConsumer, which takes two objects and uses these two objects to combine all objects
		 * in our stream to one object, which was defined in the first argument
		 * the third argument is used with Parallel Streams and will be explained in more detail in section 7.5, but it
		 * basically prevents duplicate objects being returned by this reduction.
		 * an example of takes a list of numbers, with duplicates, and put them into a TreeSet
		 * 
		 */
		StringBuilder sb=new StringBuilder("one");
		
		Stream<String>stream=Stream.of("who's "+"afraid "+"of "+" virginia"+" wolf");
		StringBuilder word=stream.collect(
				/*
				 * this is a supplier object, which sets the type R to be
				 * a stringBuidler obejct
				 */
									()->new StringBuilder(), 
									/*
									 * so a here is a StringBuilder and b is whatever
									 * type the Stream is, which is a String
									 */
									(a,b)->{
										System.out.println("a before is "+a);
										a.append(b);
										System.out.println("a is "+a);
									}
									/*
									 * this is merging two stringBuilder objects
									 * not too sure why
									 */
									, (b,c)->b.append(c));
		System.out.println(word);
		
		List<String>list2=Arrays.asList("w","o","l","f");
		/*
		 * this creates a Treeset, which orders our strings in alphabetical order
		 */
		TreeSet<String>set2=list2.parallelStream().
				/*
				 * first arguements creates a TreeSet
				 */
									collect(()->new TreeSet<>(),
											/*
											 * that means that t is a TreeSet
											 * and S is whatever the type of stream it
											 * its, it's a stream of Strings
											 */
											(t,s)->t.add(s),
											/*
											 * this is for ParallelStreams, if your
											 * have parallestreams instead of streams, 
											 * you will end up with a few hashSets being
											 * processed at the same time 
											 * (in a stream of 100 string one stream
											 * processes the first 25, another processes
											 * the second 25, and anohter the third 25 and
											 * another the fourth 25 values. so you would end
											 * up with 4 TreeSet) so this parameter is 
											 * used to merge the four TreeSets to our final
											 * one TreeSet
											 */
											(t1,t2)->t1.addAll(t2));
		System.out.println(set2);
		
		set2=list2.stream().collect(TreeSet::new,TreeSet::add,TreeSet::addAll);
		/*
		 * <R,A> R collect(Collector<? super T, A,R> collector)
		 */
	//	Stream<Integer>stream2=Stream.generate(()->(int)(Math.random()*100)).limit(5);
		Set<Integer>set3=Stream.generate(()->(int)(Math.random()*100))
								.limit(5)
								.collect(Collectors.toSet());
		/*
		 * this creates a TreeSet which will be populatled by the 5 random numbers
		 * and assigns this treeSEt to the variable set4
		 */
		TreeSet<Integer>set4=Stream.generate(()->(int)(Math.random()*100))
							.limit(5).
							peek(System.out::println)
							/*
							 * this creates a treeSEt of Integers and adds each 
							 * of the above numbers of the stream to the TreeSet
							 */
							.collect(Collectors.toCollection(()->new TreeSet()));
		System.out.println(set4);
		
		set4=Stream.generate(()->(int)(Math.random()*100))
				.limit(5).
				peek(System.out::println)
				/*
				 * this creates a treeSEt of Integers and adds each 
				 * of the above numbers of the stream to the TreeSet
				 * this does the EXACT same as the above
				 */
				.collect(Collectors.toCollection(TreeSet::new));
		
		List<Integer>myListStream=Stream.generate(()->(int)(Math.random()*100))
		.limit(5).
		peek(System.out::println)
		/*
		 * this creates a treeSEt of Integers and adds each 
		 * of the above numbers of the stream to the TreeSet
		 * this does the EXACT same as the above
		 */
		.collect(Collectors.toCollection(ArrayList::new));
		
		LinkedHashSet<Integer>lhsInt=Stream.generate(()->(int)(Math.random()*100))
				.limit(5).
				peek(System.out::println)
				/*
				 * this creates a treeSEt of Integers and adds each 
				 * of the above numbers of the stream to the TreeSet
				 * this does the EXACT same as the above
				 */
				.collect(Collectors.toCollection(LinkedHashSet::new));
		
		List<Integer>numbers=new ArrayList<>();
		Stream.generate(()->(int)(Math.random()*100))
		.limit(5).
		peek(System.out::println).forEach(numbers::add);
		
		
	}

}
