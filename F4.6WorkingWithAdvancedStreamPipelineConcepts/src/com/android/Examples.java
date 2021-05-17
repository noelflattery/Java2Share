package com.android;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/**
 * this class contains all the code that deals with this topic
 * @see com.android.Examples#ex1()
 * @see com.android.Examples#ex2()
 * @see com.android.Examples#ex3()
 * @see com.android.Examples#ex4()
 * @see com.android.Examples#ex5()
 * @see com.android.Examples#ex6()
 * @see com.android.Examples#ex7()
 * @see com.android.Examples#ex8()
 * @see com.android.Examples#ex9()
 * @author NoelF
 *
 */
public class Examples {
	/**
	 * This class shows lazy instantiation of a Stream variable. This is where some initial creation and intermediate operation is carried out on a Stream, but
	 * not a Terminal operation, so nothing is produced until some Terminal operation is carried out on the Stream. 
	 * First we have a {@link com.android.Dog} class and it has a Stream variable {@code private Stream<Integer>myStream;}. There is an initialisation block
	 * {@code myStream=Stream.iterate(1, i->i*2).limit(10).peek(System.out::println); }
	 * but there is NO terminal operation, so nothing is produced at this point. It is only when a dog calls the {@link com.android.Dog#bark()} method that
	 * the stream is instantiated as only at this point is a Terminal forEach()operation called on the Stream {@code 
	 * myStream.filter(x->x%2==0).forEach((n)->System.out.println("number is "+n));		}
	 * The same happens for the {@link com.android.Human} class as it has a Stream variable {@code Stream<Shoes>myShoes}. There is an initialisation block {@code
	 * myShoes=Stream.generate(()->new Shoes((int)(Math.random()*10+1),Colour.BLACK)).
						filter((s)->s.size>6).
						filter(s->s.size<9);   }
		but there is NO terminal operation, so nothing is produced at this point. It is only when a human calls the {@link com.android.Human#makeShoes()} method
		the stream is instantiated as only at this point is a Terminal collect() operation called on the Stream {@code 
		shoeSet=myShoes.limit(shoeAmt).collect(Collectors.toSet());}
	 * @see com.android.Human
	 * @see com.android.Shoes
	 * @see com.android.Colour
	 * @see com.android.Dog
	 */
	static void ex1() {
		//creating a Dog and some stream operations are carried out but our stream in not initialised
		Dog spot=new Dog(2,"spot");
		//it is at this point where the Stream is initialised
		spot.bark();
		//creating a Human and some stream operations are carried out but out stream is not initialised
		Human myHuman=new Human(24,"helen",2);
		//it is at this point where the stream is initialised
		myHuman.makeShoes();
	//	myHuman.makeShoes();
		/*
		 * see Human class for lazy instantiation
		 */
	}
	/**
	 * this code deals with Optional Functional programming, which is simply using the Optional data types with with functional
	 * programming. An Optional can have a any data type, i.e in our code we can have {@code
	 * Optional<Shoes>optShoes;
	 * Optional<Human>optHuman;}
	 * or we can have built in java datatype such as OptionalInt, OptionalDouble, etc
	 * So for instance you have a have a Optional of type shoes, which will be the shoes with the largest shoe size {@code
	 * Stream.generate(()->new Shoes((int)(Math.random()*10+1),Colour.BLACK)).//produces random sized shoes
		distinct().//make sure all unique, use equals method of the Shoes class (this was addd after video produced)
		limit(7).//limit to 7 pairs of shoes
		peek(System.out::println).//will print them out to see shoes created
		max((s1,s2)->s1.size-s2.size);//will return an Optional<Shoe> type }
	 * Or we can have we can have one of the built in Optional types returned, here it's a OptionalInt returned {@code
	 * IntStream .generate(()->(int)(Math.random()*100)).limit(7).max();}
	 * So we can have object streams or streams of primitive type, that have terminal operations that return a Optional as one type
	 * of functional programming. We also can perform functional programming operations on the actual Optional object itself,some of these method return
	 * a optional, which then means we can call other methods of the Optional class in a chained fashion similar to functional programming with Streams.
	 * the main methods for Optionals we will cover here are 
	 * filter() 
	 * {@code Optional<T> filter(Predicate<? super T> predicate)} 
	 * which takes a predicate of the type of of the Optional, i.e checking if an optional String, optStr, has a length greater than 4 {@code
	 *  optStr.filter(s->s.length()>4)}
	 * map() 
	 * {@code public<U> Optional<U> map(Function<? super T, ? extends U> mapper)}
	 * which takes a Function that takes a type of the optional and returns either the same type or a different type of Optional, i.e taking in optional Integer
	 * , optInt, and converting it to a optional String {@code
	 * optInt.map(n->"this is the number"+n)}
	 * and flatMap {@code
	 * public<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper) }
	 * which takes a function and operates in much the same fashion as Map, and can be used as an alternative to Map
	 * the code using flatMap uses the method {@link com.android.Examples#calculator(String)} to illustrate flatMap
	 * @see com.android.Examples#calculator(String)
	 */
	static void ex2() {
		/*
		 * Optional Functional programming is mainly concerned with
		 * filter()
		 * map()
		 * and flatmap()
		 */
		Optional<Integer>optInt=Optional.of(12);
		optInt=Optional.empty();
		if(optInt.isPresent())
			System.out.println(optInt.get());
		/*
		 * we are attempting to check is a number is three characters long
		 * 001
		 */
		if(optInt.isPresent()) {
			Integer num=optInt.get();
			String string=""+num;
			if(string.length()==3) {
				System.out.println(string+" is three digits long");
			}
			else
				System.out.println(string+" is not three digits long");
		}//end of if
		System.out.println("using functional programming with Optional<T>, optionals for objects");

	//	optInt=Optional.empty();
		optInt.map(n->""+n).
		filter(s->s.length()==3).
		ifPresent(s->{
			System.out.println("number in string format is "+s);
			System.out.println("s is a "+s.getClass().getSimpleName()+" class");
		});
		
		List<Integer>nums=Stream.generate(()->(int)(Math.random()*100)).
				distinct().
				limit(5).
				peek(System.out::println).
				collect(Collectors.toList());
		
		Optional<Integer>optMax=nums.stream().max((n1,n2)->n1-n2);
		
		System.out.println(optMax);
	//	optMax=optMax.empty();
		System.out.println(optMax.get());
		System.out.println(optMax.orElse(0));
		System.out.println(optMax.orElseGet(()->(int)(Math.random()*100)));
		
		
		String str="123456";
		Optional<String>optStr=Optional.of(str);//this contains the string "123456"
		Optional<Integer>result=optStr.map(s->s.length());//this contains the number 6
		System.out.println(optStr);//this is Optional<String>
		System.out.println(result);//this is a Optional<Integer>
		System.out.println(optStr.get());
		System.out.println(result.get());
		
		result=optStr.map(String::length);
		
		str="Hello there";
		result=calculator(str);
		System.out.println("result is "+result.get());
		
		optStr=Optional.of("good Golly miss molly");
		
	//	result=optStr.map(s->calculator(s));
	//	result=optStr.map(Examples::calculator);
		/*
		 * if you want to convert from one optional type to another optional type
		 * .ie here from Optional<String> to Optional<Integer> you should use a flatMap instead of a 
		 * map
		 */
		result=optStr.flatMap(s->calculator(s));
		result=optStr.flatMap(Examples::calculator);
		
			
	}
	/**
	 * this takes in a string and returns an {@code Optional<Integer>} which is a the amount of characters in 
	 * the string sent to this method
	 * @param str String sent to the method
	 * @return amount of letters in the String sent to method
	 * @see com.android.Examples#ex2()
	 */
	static Optional<Integer>calculator(String str){
		Optional<String>optStr=Optional.of(str);
		//converts from a Optional<String> to a Optional<Integer>
		return optStr.map(String::length);
	}
	/**
	 * the code in this method and {@link com.android.Examples#ex4()} and {@link com.android.Examples#ex5()} all relate to the Terminal operation
	 * {@link java.util.stream.Stream#collect(java.util.stream.Collector)} and the various methods of {@link java.util.stream.Collectors} that
	 * a Collect can take. we first cover Collectors.toCollection() which can return any class that implements the Collection interface.
	 * we come accross our first instance of ToIntFunction and ToDoubleFunction, which can be confused with IntFunction and DoubleFunction. 
	 * The difference is ToIntFunction always RETURNS A PRIMITIVE INT and can take any type e.g 
	 * {@code ToIntFunction<String>toIntStr=s->s.length();    }
	 * a IntFunction always TAKES A INT as a parameter and can return any type
	 *  {@code IntFunction<String>intFunc=n->"this returns our String with a number "+n;}
	 * ToIntFunction and ToDoubleFunction are used with Collectors.averagingDouble() and Collectors.averagingInt(), both of which return a double.
	 * an example would be the following {@code
	 * Stream.iterate(5, n->n*5).
	 * limit(5).//creates list of 5,25,125,625,3125
	 * peek(System.out::println).//prints out list to check numbers
	 * collect(Collectors.averagingInt(n->n)); }//takes a ToIntFunction, which returns a primitive int, but the averagingInt method itself returns this
	 *as a double
	 * @see java.util.stream.Stream#collect(java.util.stream.Collector)
	 */
	static void ex3() {
		System.out.println("Collections and functional programming, using Collect");
		List<String>namesList=Arrays.asList("dog","cat","mouse","cow","sheep","pig");
		Stream<Integer>intStream=Stream.iterate(1, n->n+3).
									filter(n->n%2==1).
									limit(15);
		Stream<Double>douStream=Stream.iterate(2.0, n->n+5).
										filter(n->n%2==0).
										limit(15);
		Stream<String>strStream=namesList.stream();
	//	TreeMap<Integer,String>treeMapMine;
	//	System.out.println(intStream.collect(Collectors.toList()));
	//	System.out.println(intStream.collect(Collectors.toSet()));
	//	intStream.collect(collector)
		/*this is a simplier Collectors.toCollection implementation, which saves all the numbers to a TreeSet
		 */
		TreeSet<Integer>treeInts=intStream.collect(Collectors.toCollection(TreeSet::new));//streams is closed
		System.out.println(treeInts);
	//	TreeSet<Integer>treeInts=intStream.collect(Collectors.toCollection(TreeSet::new));
	//	System.out.println(treeInts);
		/*
		 * averagingDouble(ToDoubleFunction f)
		 * averagingInt(ToIntFunction f)
		 * averagingLong(ToLongFunction
		 * 
		 */
		/*
		 * s.length returns a primitive int which can be assigned to a primitive double
		 * toDoubleFunction returns a primitive double
		 */
		ToDoubleFunction<String>toDouStr=s->s.length();
		ToIntFunction<String>toIntStr=s->s.length();
//		IntFunction<String>intFunc=i->i+"";
		/*
		 * this takes ina  Dog and returns teh primitive int the dogs age
		 */
		ToIntFunction<Dog>toIntDog=d->d.age;
		
		double result=namesList.stream().collect(Collectors.averagingDouble(s->s.length()));
		System.out.println(result);
		System.out.println(Math.round(result));
		
		List<Dog>dogList=Stream.generate(()->new Dog((int)(Math.random()*100),"spot")).
				filter(d->d.age>1).
				filter(d->d.age<15).
				limit(10).
		//		peek(System.out::println).
				collect(Collectors.toList());
		System.out.println(dogList);
		/*
		 * this gets averagingInt takes a toIntFunction, which is it takes in a dog and returns an 
		 * int, 
		 * here it takes in a dog and returns the age of the dog, averagingINt then returns the average of
		 * all the ages of the dogs, which is double
		 */
		double averageAge=dogList.stream().collect(Collectors.averagingInt(d->d.age));
		System.out.println("average age of Dog is "+averageAge);
		
		/*
		 * this is generating our Dogs and then getting the average age of the dogs all on the fly
		 * the dogs created are not ASSIGNED to anything so as soon as the work is done, they are liable 
		 * for garbage collection and can't be accessed
		 */
		double averAge=Stream.generate(()->new Dog((int)(Math.random()*100),"spot")).
		filter(d->d.age>1).
		filter(d->d.age<15).
		limit(10).
		/*
		 * without this peek you would have no idea what sort of dogs were being created, all you will
		 * get is the average age of all dogs
		 */
	//	peek(d->System.out.println(" dog is "+d)).
		collect(Collectors.averagingInt(d->d.age));
		System.out.println("average age of dog is "+averAge);
		
		ToIntFunction<Dog>dogToInt=d->d.age;
		
		averAge=Stream.generate(()->new Dog((int)(Math.random()*100),"spot")).
				filter(d->d.age>1).
				filter(d->d.age<15).
				limit(10).
				/*
				 * without this peek you would have no idea what sort of dogs were being created, all you will
				 * get is the average age of all dogs
				 */
			//	peek(d->System.out.println(" dog is "+d)).
				collect(Collectors.averagingInt(dogToInt));
			
	}
	/**
	 * this code deals with Collectors.counting() and Collectors.joining()
	 * counting() is a simple method that returns a Long wrapper object, if we want to use this object as a primitive number we can use the 
	 * longValue(), intValue() methods of the wrapper class to return a primitive equivalent ie {@code
	 * Stream.generate(()->(int)(Math.random()*100)).//generates stream of random ints between 1 and 100
	 * limit(50).//limits to 50 numbers
	 * filter(n->n%2==0).//filters to only even numbers, so don't know how many numbers in stream at this point
	 * collect(Collectors.counting())).//counts the amount of Strings and returns the number as a Long wrapper
	 * longValue() //returns a primitive long version of the Wrapper Long     }
	 * The next method covered in this code is Collectors.join() which only works for Streams of Strings, and it used for contcatentating 
	 * a Stream string into one String.
	 * first overloaded method takes no argumenst and concatenates the String into one string {@code
	 * Stream.of("hello","there","people").collect(Collectors.joining())  }
	 * produces the String "hellotherepeople"
	 * Second overloaded method takes one String argument, a serperator or more commonly known as a delimiter which will be between every original 
	 * string in the new concatenate String i.e {@code
	 * Stream.of("apple","orange","banana").collect(Collectors.joining("-"))      }
	 * produces the String "apple-orange-banana"
	 * Third overloaded method takes a delimiter string, a prefix string and a suffix string i.e {@code
	 * Stream.of("beef","lamb","potato","chocolate").collect(Collectors.joining(", ","I eat "," a lot"))		}
	 * produces "I eat beef, lamb, potato, chocolate a lot"
	 */
	static void ex4() {
		System.out.println(Stream.of("beef","lamb","potato","chocolate").collect(Collectors.joining(", ","I eat "," a lot")));
		System.out.println(Stream.of("hello","there","people").collect(Collectors.joining()));
		Stream.iterate(4, n->n*n).limit(6).map(n->n+"").collect(Collectors.joining());
		System.out.println("Collectors.counting");
		/*
		 * you don't know how many numbers will be created when you do this
		 */
		System.out.println(Stream.generate(()->(int)(Math.random()*100)).
				limit(50).//maximum amount will be 50
				filter(n->n%4==0).
		//		peek(System.out::println).
				collect(Collectors.counting()));
		
		long lAmount=Stream.generate(()->(int)(Math.random()*100)).
				limit(50).//maximum amount will be 50
				filter(n->n%4==0).
		//		peek(System.out::println).
				collect(Collectors.counting()).longValue();
		System.out.println("Collectors.joining() only for Strings ");
		List<String>animals=Arrays.asList("dog","cat","mouse","cow","sheep","pig");
	//	Stream<String>strStream=Stream.of("dog","cat","mouse","cow","sheep","pig");
		/*
		 * first joining() method takes no arguements and returns a String that is a string containing
		 * all the Strings in the Stream, so this produces a stream of
		 * dogcatmousecowsheeppig
		 */
		System.out.println(animals.stream().collect(Collectors.joining()));
		String joined=animals.stream().collect(Collectors.joining());
		System.out.println("joined string is "+joined);
		System.out.println("second overloaded joining() method, takes one arguemnt, a string");
		/*
		 * each of our strings is going to be seperated by a comma and a space ", "
		 */
		joined=animals.stream().collect(Collectors.joining(", "));
		System.out.println("joined string with delimiter is "+joined);
		System.out.println("third overloaded joining method , takes three arguments , a delimiter, a prefix"
				+ " and a suffix");
		joined=animals.stream().collect(Collectors.joining(", ", "our list of Animals is ", 
				" which are all native to Ireland"));
		System.out.println(joined);
			
	}
	/**
	 * This covers the methods Collectors.maxBy(Comparator) and Collectors.MinBy(Comparator) both of which return an optional of the type
	 * of the Stream;
	 * minBy returns a Optional with the minimum value determined by the comparator passed as an argument 
	 * maxBy returns a Optional with the maximum value determined by the comparator passed as an argument i.e
	 * {@code
	 * Stream.generate(()->(int)(Math.random()*100)).//produces a stream of random numbers
	 * limit(10).//limits to 10 numbers
	 * peek(System.out::println).//prints out all 10 numbers
	 * collect(Collectors.maxBy((n1,n2)->n1.compareTo(n2))).//returns a Optional<Integer>
	 * get()//gets the number contained in the Optional which will be the number with the maximum value  }
	 * minBy() operates in the same way as maxBy(), and uses the same comparator to find the minimum value
	 */
	static void ex5() {
		System.out.println(Stream.generate(()->(int)(Math.random()*100)).limit(10).peek(System.out::println).collect(Collectors.maxBy((n1,n2)->n1.compareTo(n2))).get());;
		System.out.println("More Collector.methods we should know");
		/*
		 * this produces a list of dogs with ages less than 20
		 */
		List<Dog>dogList=Stream.generate(()->new Dog(generateRandom(),"spot")).
				filter(d->d.age<20).//distinct().
				limit(10).
				collect(Collectors.toList());
		System.out.println(dogList);
		/*
		 * this is going to produce 10 dog with ages less than 20 and weights between 1 and 50 but not including
		 * 1 and 50
		 * distinct here does not work as we are producing only DISTINCT dogs not distinct ages or
		 * weights
		 */
		List<Dog>dogList2=Stream.generate(()->new Dog(generateRandom(),"rex",Math.random()*100)).
								filter(d->d.age<20).//distinct().
								filter(d->d.weight>1).
								filter(d->d.weight<30).//distinct().
								limit(10).
								collect(Collectors.toList());
		System.out.println(dogList2);
		System.out.println(Dog.dogCounter+" dogs created to give us a list of 10 dogs");
		
		/*
		 * comparator for age of the dogs
		 */
		Comparator<Dog>dogAgeComp=(d1,d2)->d1.age-d2.age;
		//comparator for weight of the dogs
		Comparator<Dog>dogWeightComp=(d1,d2)->d1.weight.compareTo(d2.weight);
		System.out.println("maxBy");
		System.out.println("oldest Dog");
		/*
		 * MaxBy returns a Optional of tyep Dog
		 * Optional<Dog>
		 * and takes a comparator for what atribute of the dog we are trying to find a max for
		 * i.e oldest Dog
		 * heaviset dog
		 * this is going to get the oldest Dog
		 */
		Optional<Dog>dogOptAge=dogList.stream().collect(Collectors.maxBy(dogAgeComp));
		System.out.println("oldest dog is "+dogOptAge.get());
		Optional<Dog>dogOptWeight=dogList2.stream().collect(Collectors.maxBy(dogWeightComp));
		System.out.println("heaviest dog is "+dogOptWeight.get());
		System.out.println("minBy");
		dogOptAge=dogList.stream().collect(Collectors.minBy(dogAgeComp));
		System.out.println("youngest Dog is "+dogOptAge.get());
		dogOptWeight=dogList2.stream().collect(Collectors.minBy(dogWeightComp));
		System.out.println("lightest dog is "+dogOptWeight.get());
		
	}
	/**method used in {@link com.android.Examples#ex6()} and generates a randon number between 1 and 100 inclusive
	 * @return a int between the numbers 1 and 100 inclusive
	 */
	static int generateRandom() {
		return(int)(Math.random()*100+1);
		
	}
	/**we can create objects that hold information about streams, previously in section 4.5 we used SummaryStatics object which held information
	 * about a primitive stream, i.e IntSummaryStatistics for IntStream, DoubleSummaryStatistics for DoubleStream. 
	 * We can also use these classes to get information about Streams of objects, and using the methods Collectors.sumarizingInt() and
	 * Collectiors.summarizingDouble() firstly in conjuction with these summaryStatistics, getting information about ages of Dog from a stream of
	 * dogs {@code assume dogStream is a stream of 10 dogs with different weights
	 * DoubleSummaryStatistics dogStats=dogStream.collect(Collectors.summarizingDouble(d->d.weight));
	 * dogStats.getMax()//returns max weight, dogStats.getMin()//returns min weight dogStats.getCount()//returns count of weights
	 * dogStats.getSum()//returns sum of weights dogStats.getAverage()//returns average weight		}
	 * this code also covers summingDouble(), summingInt() which takes a to ToIntFunction and a ToDoubleFunction respectively and returns a primitive
	 * int and a primitive double respectively. i.e {@code
	 * dogStream.collect(Collectors.summingDouble(d->d.weight));//gets sum of all weights of the Dogs			}
	 * we also cover Collectors.toCollection() which is a terminal operation that allows us to save all of the objects of a stream to any 
	 * object that implements the Collection interface, which are lists, sets and queues (but not maps there is a seperate method for this)
	 * @see com.android.Dog
	 */
	static void ex6() {
		System.out.println("SummarizingDouble,SummarizingInt,SummarizingLong");
		
		List<String>animals=Arrays.asList("dog","cat","mouse","cow","sheep","pig");
		//SummaryStatistics sumStat;
		DoubleSummaryStatistics dogStats=Stream.of(new Dog(12,"spot",2.3),new Dog(23,"rex",4.5),new Dog(11,"benji",6.7)).
				collect(Collectors.summarizingDouble(d->d.weight));
		System.out.println(dogStats.getMax());
		System.out.println(dogStats.getMin());
		//IntSummaryStatistics intstr=animals.stream().collect(Collectors.summarizingInt(s->s.length()));
		/*
		 * the object statStr is a seperate object that stores information about the stream, after the stream
		 * is closed
		 */
		DoubleSummaryStatistics statStr=animals.stream().
				collect(Collectors.summarizingDouble(s->s.length()));//stream is closed at this point
		/*
		 * however statStr stores information about the stream that was just previously closed
		 */
		System.out.println("average length of Strings is "+statStr.getAverage());
		System.out.println("amount of strings in stream "+statStr.getCount());
		System.out.println("string with most characters "+statStr.getMax());
		System.out.println("string with least characters "+statStr.getMin());
		System.out.println("total amount of characters is "+statStr.getSum());
		
		System.out.println("summingDouble,summingInt,summingLong ");
		/*
		 * produces five dogs with randoma ages between 1 and 100 and random weights between 1.0 and 10.0
		 */
		List<Dog>dogList=Stream.generate(()->new Dog(generateRandom(),"spot",Math.random()*10)).
				limit(5).
				collect(Collectors.toList());
		System.out.println(dogList);
		
		//System.out.println("summingDouble");
		/*
		 * this will return the total weight of dogs
		 * summingDouble takes a toDoubleFunction, which is a function that takes a object and returns a
		 * primitive double, in this case it takes a Dog and returns a the weight of the Dog, and then the total
		 * weight of all dogs is calculated
		 */
		double dogWeight=dogList.stream().collect(Collectors.summingDouble(d->d.weight));
		System.out.println("weight of all dogs is "+dogWeight);
		//this will total up all the ages of a a dog and assign them to the primitive int variable dogAge
		int dogAge=dogList.stream().collect(Collectors.summingInt(d->d.age));
		System.out.println("total age of all dogs is "+dogAge);
		//returns a list of whatever type we state our list to be on the left hand side
		System.out.println("toList");
		//this will increment each number produce by a factor of 10 (multiply by 10)
		List<Integer>intList=Stream.iterate(1, n->n*10).
				limit(10).
				collect(Collectors.toList());
		System.out.println(intList);
		//returns a set of whatever type we state our set to be on the left hand side
		System.out.println("toSet");
		List<String>animalList=Arrays.asList("dog","cat","pig","pig","sheep","cow");
		Set<String>animalSet=animalList.stream().collect(Collectors.toSet());
		System.out.println(animalSet);
		
		intList.clear();
		/*
		 * you can use collect with an infinite stream, however this will NEVER finish as it's simply adding
		 * every number created to the list, so this process will be repeated forever. So you get an 
		 * infinite list been added too
		 */
	//	System.out.println("print statemetn before");
	//	intList=Stream.iterate(2, n->n+1).collect(Collectors.toList());
	//	System.out.println("print statment after ");
		System.out.println("toCollection");
		/*
		 * toCollection allows us to save our stream to any particular type of Collection object (any type
		 * of set,queue or list NOT MAPS)
		 */
		System.out.println("toCollection");
		/*
		 * have to put in distinct if you want exactly 7 number EVERY TIME, (remove distinct to see sometimes
		 * you will get 7, other times you will get 6 and sometimes you may even only get 5)
		 */
		TreeSet<Integer>treeInt=Stream.generate(()->generateRandom()).//this can produce the same numbers
				distinct().
				/*
				 * if we have this limit set to more than 100, we will get infinite processing as
				 * we have the disinct numbers from 1 to 100, which are 100 numbers and then it looks for
				 * more disinct numbers between 1 and 100, which do not exist but the program will keep 
				 * looking. change this to a number greatern than 100 to see infinite processing
				 */
				limit(7).//0 is the mimimum amount you can put
				collect(Collectors.toCollection(()->new TreeSet<Integer>()));
		System.out.println(treeInt);
		
		treeInt.clear();
		/*
		 * this is the exact same as the aboe
		 */
		treeInt=Stream.generate(()->generateRandom()).
						distinct().
						limit(7).
						collect(Collectors.toCollection(TreeSet::new));
		
		System.out.println(treeInt);
		//this contains dog dog, cat, mouse, cow, sheep, pig
		//System.out.println(animals);;
		LinkedList<String>linkedStr=animals.stream().collect(Collectors.toCollection(()->new<String>LinkedList()));
		System.out.println(linkedStr);
		
		ArrayDeque<String>dequeStr=animals.stream().collect(Collectors.toCollection(ArrayDeque::new));
		/*
		 * toCollection allows us to save the stream to any PARTICULAR type of collection (TreeSet,LinkedList,
		 * arrayDeque, etc(
		 */
	}
	/**
	 * to save a stream to a Map we cannot use Collectors.toCollection() as a Map does not implement Collection and this method can only be used
	 * with objects that implements the Collection interface (Lists, Sets, Queues). So instead we use Collectors.toMap(), of which there
	 * are three overloaded methods
	 * First overloaded method
	 * collect(Collectors.toMap(keyMapper function, valueMapper function)
	 * this takes a function that takes in an object of type of the Stream and returns a unique key for this entry in the Map
	 * the second argument is also a fuction that takes and object of type of the stream and returns a value for this entry in a Map
	 * i.e a Stream of Shoes with it's hashcode as a key and the pair of shoes as the value, the Stream will be consist of all unique shoes and
	 * be called shoeStream{@code 
	 * Map<Integer,Shoes>shoeMap=shoeStream.collect(Collectors.toMap(s->s.hashCode(), s->s));		}
	 * SECOND OVERLOADED METHOD
	 * overloaded toMap() method takes a function,function and BinaryOperator
	 * first argument creates the key
	 * second argumetn creates the value
	 * third arguement is what happens when you have two keys the same, we do an example again using the same stream of unique shoes and if two
	 * keys are the same we simply add up the two keys to create a new key{@code
	 * Map<Integer,Shoes>shoeMap=shoeStream.collect(Collectors.toMap(s->s.hashCode(), s->s,(n1,n2)->n1+n2)); 	 	}
	 * THIRD OVERLOADED METHOD
	 * overloaded toMap() method that takes a function, function, binaryOperator and a supplier
	  * first argument creates the key
	 * second argument creates the value
	 * third argument is what happens when you have two keys the same,
	 * fourth argument is the type of Map the stream of objects will be save too. we do an example again using stream of shoes.ie {@code
	 * TreeMap<Integer,Shoes>shoeMap=shoeStream.collect(Collectors.toMap(s->s.hashCode(), //function takes in a shoe returns a hashcode uses as key
	 * 																		s->s,//function takes in shoes and returns the same shoes
	 * 																		(n1,n2)->n1+n2),//if same keys just add up both keys to produce new key 	
	 * 																		TreeMap::new);//supplier creates our TreeMap	}
	 */
	static void ex7() {
		Map<Integer,Shoes>shoeMap=
				Stream.of(new Shoes(8,Colour.BLACK),new Shoes(9,Colour.RED),new Shoes(9,Colour.BLUE)).collect(Collectors.toMap(s->s.hashCode(), s->s));
		System.out.println("collecting streams into maps");
		System.out.println("Collectors.toMap");
		/*
		 * consists of key and a value, no duplicate keys allowed, if put in duplicate key, the values for 
		 * that key is overwritten
		 * so we end up with 
		 * 1=noel, 2=laura, 3=noel
		 */
		Map<Integer,String>myMap=new HashMap<Integer,String>();
		myMap.put(1, "noel");
		myMap.put(2, "mary");
		myMap.put(2, "laura");
		myMap.put(3, "noel");
		myMap.putIfAbsent(1, "pat");
		System.out.println(myMap);
		System.out.println("values are ");
		System.out.println(myMap.values());
		System.out.println("keys are ");
		System.out.println(myMap.keySet());//returns a set of the keys
		
		/*
		 * as maps contain both a key and a value ,this can become very complicated, very quickly
		 * you can't use 
		 * collect(Collectors.toCollection
		 * as Maps are not part of the Collection interface
		 */
		List<String>animals=Arrays.asList("dog","cat","mouse","cow","sheep","pig","ox","elephant"/*"pig"*/);
		System.out.println("animals is with duplicates "+animals);
		/*
		 * this is a list with all duplicates removed, which can be used for keys in a map
		 */
		List<String>animals3=animals.stream().distinct().collect(Collectors.toList());
		System.out.println("animals3 has no duplicates "+animals3);
		/*
		 * this map will take as its key the string in the above list and as its value it will take 
		 * the length of the string. as each one of these strings is unique, you can use them as non 
		 * repeating keys
		 * toMap() takes in two function methods, first function takes in a string and returns the string, 
		 * this will be our key. so this takes in dog and makes this a key, takes in "cat" and maked this a
		 * key
		 */
		Map<String, Integer>strMap=animals.stream().
				collect(Collectors.toMap(s->s,s->s.length()));
		System.out.println(strMap);
		TreeMap<String,Integer>tMap=new TreeMap<String,Integer>();
		tMap.putAll(strMap);
		System.out.println(tMap);
		
//		System.out.println(animals.iterator().next());;
		/*
		 * this map is created from a stream.iterate, which starts at 0 and increments by 1, it's limited to
		 * animals.size, which is 6. so we now have six numbers.
		 * these six numbers are each unique are used to give a key to each entery in the map.
		 * we now have the numbers 0,1,2,3,4,5. which we can use for to access each of the elements in the list
		 * of strings called animals, which we will then assign to be the values in each entry, so we
		 * end up with
		 * 0=dog, 1=cat, 2=mouse, 3=cow, 4=sheep, 5=pig
		 */
		Map<Integer,String>intMap=Stream.iterate(0, n->n+1).
				limit(animals.size()).
				/*
				 * the value can be generated from the key, as you here you get elemetns from a list
				 * by using the key in the get statement, but you don't HAVE TO generate a value based
				 * on a key
				 */
				collect(Collectors.toMap(n->n,n->animals.get(n)));
		System.out.println(intMap);
		//n->n,n->animals.get(n)
		
		List<String>animals2=Arrays.asList("dog","cat","mouse","cow","sheep","pig","pig");//
			/*	.stream().
				distinct().
				collect(Collectors.toList());*/
		/*
		 * strMap<String,Integer> 
		 * this stream has duplicate values, these values are what the map will use as the keys. 
		 * A map CANNOT have duplicate keys (if we used put keys would be input but the values would be
		 * overwritten), so if we attempt to create a map from this stream we would get java.lang.
		 * IllegalStateException duplicate key 3, as we have two keys the same string, the string"pig"
		 */
	/*	strMap=animals2.stream().
				collect(Collectors.toMap(s->s,s->s.length()));*/
		/*
		 * however it is easy to fix by just adding distinct(), and this shows how easy it is to modifiy
		 * streams as opposed to doing the same with loops
		 */
		strMap=animals2.stream().//peek(System.out::println).
				distinct().//peek((s)->System.out.println("string is "+s)).
				collect(Collectors.toMap(s->s,s->s.length()));
		
		System.out.println(strMap);
		
	//	animals.stream().peek(System.out::println);
		/*
		 * this creates a map with a unique key generated from the static int counter that increments
		 * by one each time. As the key is unique we do not have to use "distinct()" here as the values
		 * in the stream are not used to generate the keys
		 */
		Map<Integer,String>integerMap=animals2.stream().
										collect(Collectors.toMap(s->++count, s->s));
		
		System.out.println(integerMap);
		/*
		 * overloaded toMap() method takes a function,function and BinaryOperator
		 * first argument creates the key
		 * second argumetn creates the value
		 * third arguement is what happens when you have two keys the same
		 */
		//intMap<Integer,String>
		//animals=Arrays.asList("dog","cat","mouse","cow","sheep","pig");
		intMap.clear();
		System.out.println("second overloaded toMap functiona takes a function, function and BinaryOperator");
		/*
		 * the first takes as the key the lenght of the string, we will only have two keys, 3 and 5
		 * the second argumetn takes as the values the string in the Stream produced from animals, or
		 * it takes the strings in the animal list as values.
		 * third arguement, if two keys are the same we will merge the two values that are strings to one
		 * string
		 * for our list of 
		 * "dog","cat","mouse","cow","sheep","pig"
		 * adds 3 first as key and "dog" as value
		 * attempt to add 3 as key, but three already exists so concatenates "cat" onto existing value for
		 * the key 3, which was dog, so we end up with "dog,cat", does the same for "cow" and "pig" so we
		 * end up with 
		 * 3=dog,cat,cow,pig
		 * this ensures we don't lose any values, whereas if we used distinct we would just get
		 * 3=dog 5=moust
		 * 
		 */
		intMap=animals.stream().
				collect(Collectors.toMap((String k)->{
											return k.length(); //k is a string and returns an integer
											},
										(String v) -> {
											return v; //v is a string and returns a string
										},
										/*
										 * if the key value already exists, concatenate teh string values
										 * s1 and s2 are strings and returns a string
										 */
										(s1, s2) -> s1 + "," + s2));
		//we get {3=dog,cat,cow,pig, 5=mouse,sheep}
		System.out.println(intMap);
		System.out.println("third overloaded toMap methods takes a function, a function, a binaryOperator and"
				+ " supplier whihc returns the sort of Map we want");
		/*
		 * this will produce the following
		 * 2=ox, 3=dog,cat,cow,pig, 5=mouse,sheep, 8=elephant
		 * this sorts the map by key
		 */
		TreeMap<Integer,String>treeMap=animals.stream().
										collect(Collectors.toMap(k->k.length(), //arguement 1 sets key a function
												v -> v, //argument 2 sets value a function
												//argument 3 concatenates values if same key a binaryoperator
												(s1, s2) -> s1 + "," + s2, 
										//		()->new TreeMap<Integer,String>()));
												//argument 4 the type of Collection a supplier
												TreeMap::new));
		System.out.println(treeMap);	
		/*second sample to show overloaded Collectors.toMap() */
		Stream<Integer>intStream=Stream.iterate(1, n->n+3).
				filter(n->n%2==1).
				limit(15);
		/*
		 * this is creating a TreeMap from the stream of ints intStream and used Collectors.tomap and takes four argumetns
		 * keymapper which is a function that takes in an integer and returns an Integer, this create our key from the integers
		 * value Mapper which is a function that takes in Integer and returns a String, this creates our string value from our key
		 * mergeFunction which is a binary operator that takes in two integers and returns the sum of both Integers, if two keys are the same
		 * this will create a new key by adding up the two values
		 * Map Supplier which is a supplier that provides returns the Map type the key value pairs will be entered into.
		 * this is the most complicated overloaded toMap() method
		 */
		/*
		 **/
		TreeMap<Integer,String>myMap2=intStream.collect(Collectors.
				toMap(n->n, //keymapper is a function that takes an int and returns an int
						n->"this is "+n, //valuemapper is a function that takes an int and returns a String
						(n1,n2)->n1+n2, //mergeFunction if two keys are the same add up the keys to produce a new key
						TreeMap::new));//mapSupplier which is a supplier that provides the Map return type
		System.out.println(myMap2);
	}
	
	static int count=0;
	/**
	 * this code deals with three overloaded Collectors.groupingBy() and Collectors.partitioningB(). GroupingBy allows us to produce lists from a Stream
	 * of objects and group those lists in whatever criteria we desire, this will then be save as a map, the key will be whatever grouping criteria we use
	 * and the value will be a list of objects that match the criteria
	 *  for example we have a list of 8 strings of varying length, {@code
	 * "dog","cat","mouse","cow","sheep","pig","elephant","antelope")		}
	 * we then with to produce a stream from this list and then group the strings by the amount of letters in each string. The key will be the length of the
	 * String, the value will be a list of Strings that have that amount of characters in them. So the above list would produce a map like of three entries like
	 * the following {@code
	 * 3=[dog, cat, cow, pig], // we have key value of 3, and the value is a list of three Strings in our stream that have three characters
	 * 5=[mouse, sheep], //we have key value of 5, and the value is a list of 2 strings in our stream that have 5 characters
	 * 8=[elephant, antelope]//we have key value of 8, and the value of is a list of 2 strings in our Stream that have 8 characters	}
	 * We have three overloaded Collectors.groupingBy() method
	 * OVERLOADED METHOD 1
	 * using our stream of Strings example from above and calling the Stream "animals", takes one argument a function, in this 
	 * case it takes in a String, which is each one of the Strings and returns an int, which is the amount of characters in each String. the method itself
	 * returns a  {@code Map<Integer,List<String>> object } and the method signature looks like{@code
	 * Collectors.groupingBy(Function<String, Integer> classifier)	}
	 * and the actual calling of the method looks like the following {@code
	 * Map<Integer,List<String>>tMapList=animals.stream().collect(Collectors.groupingBy(s->s.length()))		}
	 * OVERLOADED METHOD 2
	 * Again using our stream of Strings. The previous method can only produce a key and the value will always be a List of Objects, in the previous example
	 * this was a list of Strings. This overloaded Collectors.groupingBy() still produces a map, but allows our value to be a different collection object, i.e a
	 * set, a queue. This method takes two arguments the first is a function, the same as in the first overloaded method, the second is object that will be the
	 * returned which will be the value Collector object. So the a simplified message signature for the Stream of Strings would be (the actual message signature
	 * is rather involved to say the least).
	 * {@code Collectors.groupingBy(Function<String,Integer>,Collector))	}
	 * and the actual calling of the method looks like the following {@code
	 * Map<Integer,Set<String>>tMapSet=animals.stream().
										collect(Collectors.groupingBy(s->s.length(),Collectors.toSet()));}
		This produces a map with the key being the the amount of characters in a String, and the value being a set with of all those strings with that amount
		of characters in a string. So we can see the main difference here is that the value can be any type of Collection object, here we have Set of Strings.
	 * OVERLOADED METHOD 3
	 * The two previous overloaded methods will create a Map, and the first one will produce a from a Stream of Strings {@code
	 * Map<Integer,List<String>>}
	 * the second overloaded method can produced any type of collection object that will be the value, so from the stream of strings you could produced {@code
	 * Map<Integer,Set<String>>} or {@code Map<Integer,ArrayDeque<String>>	} or any other object that implements Collection (List,Set,Queue). 
	 * So both of these method return a MAP, and can return nothing else. This overloaded method allows us to produce different types of Maps, this overloaded
	 * method takes three parameters. The first argument is a function, same as the previous two overloaded methods, the second argument is supplier which 
	 * will supply the type of Map you want returned by the whole method, the third argument is a Collector that produces a Collection object that will
	 * hold the values of the map.  So again we have a simplified method signature for the Stream of Strings would be (as again the actual message signature
	 * is long and extremely involved and to be honest you don't really need to know it) {@code
	 * Collectors.groupingBy(Functions<String,Integer>
	 * ,Supplier<? extends Map>, //this will be type of Map produced by the whole method
	 * Collector//this will return a Collection object that will hold the values in our final Map	}
	 * the actual calling of the method could look like the following: {@code
	 * TreeMap<Integer,TreeSet<String>>tTreeMapTree=animals.stream().
				collect(Collectors.groupingBy(
						String::length, //same as s->s.length(), the key will be the length of String, the value will be a collection of Strings
						TreeMap::new, //same as ()->new TreeMap<Integer,TreeSet<String>>(), the type of Map returned by the whole method
						Collectors.toCollection(TreeSet::new)));//same as ()->new TreeSet<String>(), the value will be a TreeSet of Strings
	 * }this produces a TreeMap, with an Integer as a key, which will be the amount of characters in a String, and a value which will be TreeSet of 
	 * Strings which will have the same amount of characters as the key Integer value
	 * PARTITIONING
	 * partitions are created by the Collector.partitioningBy() method and are simply special form of Grouping of which there are only two possible groups,
	 * the boolean true or false. The first method takes a predicate, which will divide your streams up into a Map of two lists and one have a key of true and 
	 * one a key of false. This code will produce a map with all Strings with a length greater than or equal to 4 with a  {@code
	 * Map<Boolean,List<String>>partMap=animals.stream().
				collect(Collectors.partitioningBy(s->s.length()>=4));
	 * } the second overloaded partitioningBy() method takes a predicate and Collector downStream object, which is again usually the type of collection we
	 * want each of our values to be stored in. As the previous method only allowed our values to be stored in lists, this method allows us to store our 
	 * values in any type of Collection, here we store our values in a Set with this method call {@code 
	 * Map<Boolean,Set<String>>partMapSet=animals.stream().
				collect(
						Collectors.partitioningBy(s->s.length()>=4, Collectors.toSet())
						);}
	the second argument here is what determines that the values in our map will be Set of Strings. However Collectors can produce more than just Collection
	objects and have many method that can produce a wide variety of data types, for instance {@code
	Map<Integer,Long>longIntMap=animals.stream().collect(
				//String::length is the key, and what we are grouping by
				//Collectors.counting() is the amount of strings in each of these groups
				Collectors.groupingBy(String::length,Collectors.counting()));	}
	will produce a Map with the amount of characters in a String and a value which be the amount of Strings that have that amount of characters in a String.
	So from our list of Strings {@code "dog","cat","mouse","cow","sheep","pig","elephant","antelope"}
	the Map produced is {@code
	* 3=4, 5=2, 8=2
	}* which is
	* 4 strings with 3 characters
	* 2 String with 5 characters
	* 2 strings with 8 characters
	
	 * 
	 * 
	 */
	static void ex8() {
	/*	List<Dog>dogList=Stream.generate(()->new Dog(((int)(Math.random()*10+1)),"spot",Math.random()*10)).limit(30).collect(Collectors.toList());
		Map<Integer,List<Dog>>dogMap=dogList.stream().collect(Collectors.groupingBy(d->d.age));
		System.out.println(dogMap.size());
		dogMap.forEach((k,v)->System.out.println());*/
//		dogMap.forEach((k,v)->System.out.println());
//		System.out.println(dogList);
	//	Double.
		Supplier<? extends Map>supList;
		List<String>animals=Arrays.asList("dog","cat","mouse","cow","sheep","pig","elephant","antelope");
		Stream<String>strStream=Stream.of("dog","cat","mouse","cow","sheep","pig");
		System.out.println("groupingBy");
		animals.stream().collect(Collectors.toCollection(ArrayDeque::new));
		/*
		 * returns a group of lists (collection objects) that are grouped in whatever format we want
		 * here we are going to return lists of Strings and the first list will contain all the strings
		 * with 3 characters in it
		 * second list will be the list with five characters
		 * this produces a map of Integer and Lists of Strings
		 * key 3 will be the list that contains dog,cat,cow,pig
		 * key 5 will be the list that contains mouse,sheep
		 * key 8 will be the list that contains elephant and Antelope
		 */
		//this is a map of Integer keys and values which are each a list of Strings
		//this groupingBy returns a maps of Lists by default
		/*
		 * this groupingBy returns a hashMap that is going to have as a key any object type
		 * and a as a value a List of any object type
		 */
		Map<Integer,List<String>>tMapList=animals.stream().collect(Collectors.groupingBy(s->s.length()));
		//this prints out {3=[dog, cat, cow, pig], 5=[mouse, sheep], 8=[elephant, antelope]}
		System.out.println(tMapList);
		System.out.println(tMapList.get(3));//[dog, cat, cow, pig]
		System.out.println(tMapList.get(5));//[mouse, sheep]
		System.out.println(tMapList.get(8));//[elephant, antelope]
		System.out.println("this gets the dog "+tMapList.get(3).get(0));
		int size=tMapList.get(8).size()-1;
		//gets last string on the list that has strings with 8 characters in the string
		System.out.println("this gets the last item antelope "+tMapList.get(8).get(size));
		
		System.out.println("set of Keys");
		//this returns a set of all the keys
		System.out.println(tMapList.keySet());
		Map<Integer,Double>myMap=Stream.iterate(1, n->n+10).
									limit(10).
									collect(Collectors.toMap(k->k, v->Math.random()*v));
		System.out.println(myMap);
		/*
		 * myMap<Integer,Double> has a Integer key and a Double value. to get all teh values of a map
		 * we use .values(), which returns a collection object containing all the values. in this case this
		 * returns a collection of doubles
		 */
		List<Double>dList=myMap.values().
				//when you a collection object, you can create a stream
								stream().
								//when you have a stream you can create any collection object, here we create a list
								collect(Collectors.toList());
		System.out.println("list of double values is "+dList);
		System.out.println("treeset of Integer keys "+myMap.keySet().//produces a set of Integers, which are teh keys
															stream().//this produces a stream of integers
															//puts all the integers into a treeSet
															collect(Collectors.toCollection(TreeSet::new)));
		
		tMapList.clear();
		tMapList=animals.stream().
						collect(Collectors.groupingBy(s->s.length()));
		System.out.println(tMapList.keySet());
		//this will display them in orders
		System.out.println(tMapList.keySet().
									stream().
									collect(Collectors.toCollection(TreeSet::new)));
		List<List<String>>listList=tMapList.values().
											stream().
											collect(Collectors.toList());
		/*
		 * this gets the first list in our list of lists of strings, and then gets the first string 
		 * in that list, which is a dog
		 */
		System.out.println(listList.get(0).get(0));
		TreeSet<String>values=tMapList.values()//this produces a collection of Lists of Strings
									.stream()//this produces a stream of Lists of Strings
									/*
									 * this produces just a streams of Strings from our stream of Lists
									 * of strings
									 */
									.flatMap(l->l.stream()).
									collect(Collectors.toCollection(TreeSet::new));
		System.out.println("our set of values is now "+values);
		System.out.println("second overloaded groupingBy method");
		/*
		 * this groupingBy is when we want to return a particular type of collection, as the GroupingBy that
		 * only takes one arguement can only return a Map of Lists as values, the key can be any type 
		 * you want
		 * this will not work, as this groupingBy generates a List<String> not  Set<String>
		 */
	/*	Map<Integer,Set<String>>tMapSet=animals.stream().
												collect(Collectors.groupingBy(s->s.length()));*/
		/*
		 * this groupingBy takes two parameters, first is a function which creates our key and group all of
		 * the values according to key, in this case all string with length 3 will be one group, 
		 * of length 5 will be another, and of length 8 will be another group
		 * the second argument is somethign called a "downStream Collector"
		 */
	/*	Map<Integer,TreeSet<String>>tMapSet=animals.stream().
				collect(Collectors.groupingBy(s->s.length(),Collectors.toCollection(TreeSet::new)));*/
		Map<Integer,Set<String>>tMapSet=animals.stream().
										collect(Collectors.groupingBy(s->s.length(),Collectors.toSet()));
		tMapSet=animals.stream().
				collect(Collectors.groupingBy(s->s.length(),Collectors.toSet()));
		
		tMapSet=animals.stream().
				collect(Collectors.groupingBy(s->s.length(),Collectors.toCollection(TreeSet::new)));
		
		
		System.out.println(tMapList);
		System.out.println("third overloaded groupingBy");
		/*
		 * takes three arguements
		 * first arguement is function that specifies key and grouping
		 * second arguement is the specific type of Map you wish this to be , supplier that creates teh map
		 * third is the type of collection you want as values in your map
		 * this creates a TreeMap of TreeSets of Strings, that have Integers as the keys
		 */
		TreeMap<Integer,TreeSet<String>>tTreeMapTree=animals.stream().
				collect(Collectors.groupingBy(
						String::length, //same as s->s.length()
						TreeMap::new, //same as ()->new TreeMap<Integer,TreeSet<String>>()
						Collectors.toCollection(TreeSet::new)));//same as ()->new TreeSet<String>()
		System.out.println(tTreeMapTree);
		
		System.out.println("Partitioning ");
		/*
		 * Partiitioning is a special type of grouping and with this there are only two possible groups, 
		 * true or false
		 */
		System.out.println("partitionBy");
		/*
		 * partitionBy takes a preidcate
		 * true- those strings longer than 4 characters long
		 * false - those with strings 4 or less
		 * the key is always a boolean
		 * the value is a collection of objectgs
		 */
		Map<Boolean,List<String>>partMap=animals.stream().
				collect(Collectors.partitioningBy(s->s.length()>=4));
		System.out.println(partMap);
		System.out.println("overloaded partitiion method");
		/*
		 * takes a predicate and  downstream collector, which is just the collection type we want
		 * our Map to contain
		 */
		Map<Boolean,Set<String>>partMapSet=animals.stream().
				collect(
						Collectors.partitioningBy(s->s.length()>=4, Collectors.toSet())
						);
		
	
		Map<Integer,Long>longIntMap=animals.stream().collect(
				//String::lenght is the key, and what we are grouping by
				//Collectors.counting() is the amount of strings in each of these groups
				Collectors.groupingBy(String::length,Collectors.counting())
				);
		
	//	animals.stream().collect(Collectors.groupingBy(classifier, mapFactory, downstream))
		/*
		 * this produces 
		 * 3=4, 5=2, 8=2
		 * which is
		 * 4 strings with 3 characters
		 * 2 String with 5 characters
		 * 2 strings with 8 characters
		 */
		System.out.println(longIntMap);
		/*
		 * techniques dealing with complicated functional programming
		 * 1)Start over with a simple statement and keep adding to it. 
		 * By making one tiny change
			at a time, you will know which code introduced the error.
			2)Extract parts of the statement into separate statements. For example, 
			try writing Collectors.groupingBy(String::length, Collectors.counting());. 
			If it compiles, you know that the problem lies elsewhere. If it doesn’t 
			compile, you have a much shorter statement to troubleshoot.
			3)Use generic wildcards for the return type of the final statement, for 
			example, Map<?,?>. If that change alone allows the code to compile, you’ll 
			know that the problem lies with the return type not being what you expect.
		 * */
	/*	Map<Integer,Long>mLongInt=animals.stream().
				collect(Collectors.groupingBy(s->s.length(),Collectors.counting()));*/
		
	}
/**
Collectors.groupingBy() as we have seen in the previous code allows us to group our streams in whatever criteria we want, here we cover the method
Collectors.mapping() which allows us to format the values produced by Collectors.groupingBy() in whatever way we want. This method is used as the 
second argument in Collectors.groupingBy(function(v,k>, Collectors) and is best explained by an example, we have a stream of Strings {@code
"dog","cat","mouse","cow","sheep","pig", "elephant","dolphin" }
which again we call "animals". We want to produce a Map that will consist of the Amount of characters in a String as the key, and the values will be the
all the animals with that amount of characters in the string, this will produce {@code
 3=[dog, cat, cow, pig], 5=[mouse, sheep], 7=[dolphin], 8=[elephant}
* 3 characters in dog,cat,cow,pig
* 5 characters in mouse and sheep
* 7 characters in dolphin
* 8 characters in elephant
* so the code that does this is as follows: {@code
* Map<Integer,List<String>>strMap=animals.stream().
				collect(Collectors.groupingBy(
						String::length,//this is what we are grouping our strings by, which will be the key
						//this is for producing the value
						Collectors.mapping(
								
								//  this takes in a string and returns a string							 
								s->s//this is a function, takes in a string returns a string
								//saves them to a collection of strings
								, Collectors.toList()
								)	//end of Collectors.mapping
						)//end of groupingBy
					);//end of Stream	}
* Collectors.mapping takes two argument, first argument is a mapper, which is a
* function, it takes in the strings and produces a String which will be the Strings of the Stream
* second argument is a downstream collector which is a reduction, which
* is what all the character will be stored in. so all the characters will be 
* stored in a List of characters. this is the type of VALUE in the hashMap
 */
	static void ex9() {
		Collectors myCollection;
		System.out.println("Collectors.mapping");
		List<String>animals=Arrays.asList("dog","cat","mouse","cow","sheep","pig", "elephant","dolphin");
		/*
		 * this will have as a key the amount of characters in a string
		 */
		Map<Integer,List<Character>>charMap=animals.stream().
				collect(Collectors.groupingBy(
						String::length,//this is what we are grouping our strings by, which will be the key
						//this is for producing the value
						Collectors.mapping(
								/*
								 * Collectors.mapping takes two arguement, first arguement is a mapper, which is a
								 * function, it takes in the strings and produces a character, the character
								 * will be the first character in the string
								 */
								s->s.charAt(0)//this is a function, takes in a string returns a character
								/*
								 * second arguement is a downstream collector which is a reduction, which
								 * is what all the character will be stored in. so all the characters will be 
								 * stored in a List of characters. this is the type of VALUE in the hashMap
								 * 
								 */
								, Collectors.toList()
								)	//end of Collectors.mapping
						)//end of groupingBy
					);//end of Stream
		/*
		 * this produces the following
		 * 3=[d, c, c, p], 5=[m, s], 7=[d], 8=[e]
		 * 3 has dog,cat,cow,pig
		 * 5 has mouse, sheep
		 * 7 has dolphin
		 * 8 has elephant
		 */
		System.out.println(charMap);
		
		Map<Integer,List<String>>strMap=animals.stream().
				collect(Collectors.groupingBy(
						String::length,//this is what we are grouping our strings by, which will be the key
						//this is for producing the value
						Collectors.mapping(
								/*
								 * this takes in a string and returns a string
								 */
								s->s//this is a function, takes in a string returns a string
								//saves them to a collection of strings
								, Collectors.toList()
								)	//end of Collectors.mapping
						)//end of groupingBy
					);//end of Stream
		/*
		 * this produces the following
		 * 3=[dog, cat, cow, pig], 5=[mouse, sheep], 7=[dolphin], 8=[elephant
		 */
		System.out.println(strMap);
		
		Map<Integer,Optional<Character>>charMapOrder=animals.stream().collect(
				Collectors.groupingBy(
						String::length,//key
						Collectors.mapping(//value
								/*
								 * has a to be a characater as this is waht was defined in our map
								 * on left hand side
								 */
								s->s.charAt(0),
								/*
								 * this has to be an optional as this is what was defined in our map
								 * on left hand side
								 */
								Collectors.minBy(Comparator.naturalOrder())
								)
						)
				
				);//end of stream
		/*
		 * this returns 
		 * 3=Optional[c], 5=Optional[m], 7=Optional[d], 8=Optional[e]
		 * which is got from this list
		 * 3=[d, c, c, p], 5=[m, s], 7=[d], 8=[e]
		 * so for 3 the first character in alphabetical order is c
		 * for 5 the charactger in natural alphabetical order is m
		 * for 7 it's d
		 * for 8 it's e
		 */
		System.out.println(charMapOrder);
				
		
		
	
				
	
	}

}
