package com.android;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Random;
import java.util.Set;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.android.Widget.Colour;
/**
 * class that contains all our sample code to do with the topics covered in this section. As already stated, Streams
 * can only contain objects, if you add an attempt to add an int to a stream, it is autoboxed to become an Integer. 
 * There are specialised Streams that can deal directly with primitive values, specifically there are
 * IntStream for primitive ints
 * DoubleStream for primitive doubles
 * LongStream for primitive longs
 * these stream classes also then have additional methods not available to other types of Stream, which will be covered
 * in this code.
 * These classes have methods that return 
 * @author NoelF
 * @see com.android.Examples#ex1()
 * @see com.android.Examples#ex2()
 * @see com.android.Examples#ex3()
 * @see com.android.Examples#ex4()
 * @see com.android.Examples#ex5()
 * @see com.android.Examples#ex6()
 */
public class Examples {
	/**
	 * introduction to the specialised streams that deal with primitve number types. As these streams can handle primitive data types, you
	 * can use specialised methods such as max(), min(), sum() and average() which all return an optional of wrapper type of whatever
	 * type of stream it is. i.e {@code IntStream.of(34,56,99).max() will return a Optional<Integer>}
	 * also a lot of the methods of streams are also available to these specialist streams, i.e generate(), iterate()
	 * and a coding example would be {@code
	 * IntStream.generate(()->(int)(math.random()*100))}
	 * will produce an infinite streams of ints, not Integers
	 * this class also uses the {@link com.android.Widget} class to illustrate the mapToInt() method
	 * @see com.android.Widget
	 */
	static void ex1() {
		
		LongStream.of(56,7888889,2).filter(n->n>50).sum();
		/*
	 * Streams only work with Objects, they DO not work with primitives, you have a Stream of Integers, not ints
	 * however streams can still work with primitives, as just like in list, sets, queues, when you add an Int for instance
	 * to a Stream of Integers that Int is autoboxed to become a Integer
	 */
		Stream<Integer>stream=Stream.of(23,45,67);
		List<Integer>intList=Arrays.asList(56,999,67);
	
		Integer sum=stream.reduce(0, (s,n)->s+n);
		System.out.println("sum is "+sum);
		/*
		 * there are particular streams that can deal with primitives
		 * for primitive ints there is 
		 * Intstream
		 * for primitive doubles there is 
		 * Doublestream
		 * for large primitive whole numbers you have
		 * Longstream
		 */
		stream=Stream.of(23,45,67);//Stream of Integers
		//System.out.println(stream.min(comparator));
		//this is a stream of the three primitive numbers 23,45,67
		IntStream intStream=IntStream.of(23,45,67);
		/*
		 * max is a terminal operation that closes the Stream and returns something called 
		 * OptionalInt, OptionalInt is for INT primitives that may or may not have a value
		 */
		System.out.println(intStream.max());//This is not a number, this is a OptionalInt[67]
		intStream=IntStream.of(23,45,67);
		//getAsInt converts the OptionalInt produced by intStream.max to a int
		System.out.println(intStream.max().getAsInt());//this is a number
		
		/*
		 * this optional is for an INTEGER is for a Integer that may or may have a value
		 */
		Optional<Integer>optInteger;//=stream.reduce(0, (s,n)->s+n);
		
		Widget w1=new Widget(Colour.BLACK,10);
		Widget w2=new Widget(Colour.RED,5);
		Widget w3=new Widget(Colour.WHITE,15);
		Widget w4=new Widget(Colour.RED,25);
		List<Widget>widgets=Arrays.asList(w1,w2,w3,w4);
		//declared int sum on line 24
		/*
		 * you can't directly create a IntStream from a List, however you can create a IntStream from a Stream.
		 * so we you can do, is first create a Stream from a List, and then use MAPTOINT to create an IntStream
		 */
		
		 sum = widgets.stream()
				 //this will be the widgets that are red
                 .filter(w -> w.getColour() == Colour.RED)
                 //mapToInt produces a IntStream, in this case the weights of all the red widgets
                 .mapToInt(w -> w.getWeight())
                 //this is the sum of the weights of the red widgets
                 .sum();
		 System.out.println("sum is "+sum);
		 //this doest the same as above
		 Integer total=widgets.stream().
				 filter(w->w.getColour()==Colour.RED).
				 map(w->w.getWeight()).
				 reduce(0, (a,b)->a+b);
		 System.out.println("total is "+total);
		 
		 /*
		  * mapToInt returns an IntStream, which we can then apply all of the methods of the IntStream class to
		  * it. this takes in a Object and returns an int
		  */
		 Stream<Integer>streamI=Stream.iterate(1, x->x*2).limit(10);
		 /*
		  * this is taking in our stream of 10 Integers, printing them out, then converting to a Stream of Ints
		  * and calling the sum() method of IntStream class
		  */
		 System.out.println(streamI.peek(System.out::println).mapToInt(x->x).sum());;
		 System.out.println("using iterate with IntStream");
		 //the product of this is an int, as sum returns an int
		System.out.println(IntStream.iterate(0, x->x+10).peek(System.out::println).limit(10).sum());;
		
		
		
		intStream=IntStream.iterate(0, x->x+10).limit(10);
		
		intStream=IntStream.generate(()->(int)(Math.random()*100)+1).limit(10);
		/*
		 * this will NOT compile as all collection objects are collections of Objects
		 * List<Integer>
		 * Set<Integer>
		 * ArrayDeque<Integer>
		 * and intStreams produces INTS
		 */
	//	List<Integer>nums=intStream.collect(Collectors.toList());	
		
		System.out.println("max");
		//max returns an OptionaInt, which is NOT a number
		System.out.println(intStream.peek(System.out::println).max());
		
		intStream=IntStream.generate(()->(int)(Math.random()*100)+1).limit(10);
		System.out.println("second max");
		//max returns a OptionaInt, so we have to getAsInt to return a number
		System.out.println(intStream.peek(System.out::println).max().getAsInt());
		System.out.println("sum returns an Int");
		intStream=IntStream.generate(()->(int)(Math.random()*100)+1).limit(10);
		System.out.println(intStream.peek(System.out::println).sum());//this is a INT
		System.out.println("MIN");
		intStream=IntStream.generate(()->(int)(Math.random()*100)+1).limit(10);
		System.out.println(intStream.peek(System.out::println).
							min().
							getAsInt());
		System.out.println("AVERAGE");
		intStream=IntStream.generate(()->(int)(Math.random()*100)+1).limit(10);
		//average by default returns a primitive double, but you can cast it to be an int
		System.out.println(intStream.peek(System.out::println).
				average().
				getAsDouble());
		//generates 10 numbers between 1 and 100 inclusive and gets the Max which is a OptionalINt
		OptionalInt optI=IntStream.generate(()->(int)(Math.random()*100)+1).
									limit(10).
									max();
		//generates 10 numbers between 1 and 100 inclusive and gets the average which is a OptionalDouble
		OptionalDouble optD=IntStream.generate(()->(int)(Math.random()*100)+1).
										limit(10).
										average();
		OptionalLong optL;
		
		System.out.println(optD);
		/*
		 * this is getting the average of Empty stream
		 */
		optD=IntStream.empty().average();
		System.out.println(optD);//OptionalDouble.empty
		optI=IntStream.empty().max();
		System.out.println(optI);//OptionalInt.empty
		optI=IntStream.empty().min();
		System.out.println(optI);//OptionalInt.empty
		System.out.println(IntStream.empty().sum());//0
		
	//	intStream=IntStream.generate(()->(int)(Math.random()*100)+1).limit(10);
		             
		Arrays.asList(56,78,99,120,56,111,2390,1,-12).//creates a list
		stream().//creates a stream from this list
		mapToInt(n->n).//creates a IntStream from the Stream<Integer>
		max().//creates a Optional<Integer> 
		ifPresent(System.out::println);//calls ifPresent() method of Optional<Integer>
		/*can also convert an intstream to a Stream<Integer>*/
		Arrays.asList(56,78,99,120,56,111,2390,1,-12).
		stream().//creates Stream<Integer>
		mapToInt(n->n)//creates an IntStream
		.boxed().//creates a Stream<Integer> from the IntStream
		forEach(System.out::println);//forEach of the Stream<Integer>
	}
	/**
	 * This method deals with the speicalist stream for dealing with primitive doubles and uses this to illustrate how to use these 
	 * Streams. As DoubleStream operate in much the same way as IntStream and LongStream, the methods and techniques used here can also apply
	 * to IntStream and LongStream. As methods such as sum() and average() return a OptionalDouble data type for DoubleStream and a OptionalInt
	 * for Intstream and a OptionalLong for LongStream, we will show examples of how to correctly use these specialist optiona types. 
	 * MapToInt, will be shown how to convert from a Stream of Objects, to a Stream such as IntStream that deals with primitive ints. Equalivent
	 * MapToDouble and MapToLong methods also exist and all take a specialist function called IntFucnction, DoubleFunction, LongFunction.
	 */
	static void ex2() {
		System.out.println("Examples ex2");
		/*
		 * as already state there are three primitive Stream types
		 * IntStream used for int, short,byte and char
		 * LongStream use for the primitive type long
		 * DoubleStream used for primitive type doubles and floats
		 */
		//creating an empty stream
		DoubleStream empty=DoubleStream.empty();
		/*
		 * as these types of streams can only take primitives, you can't create a Intstream for instance from
		 * a List of Integers (as lists only contain objects not primtives). However you can create a 
		 * a Stream from a array of primtive variables
		 */
		double[]dArray= {3,4.5,6.78,3.2,102.456};
		List<Double>dList=Arrays.asList(3.0,4.5,6.78,3.2,102.456);
		/*
		 * you can create a stream of primitive doubles from an array of primitive doubles
		 */
		DoubleStream dStream=DoubleStream.of(dArray);
		/*
		 * but you can't directly create a stream of double primitives from a List of Wrapper DOUBLES
		 */
		//dStream=DoubleStream.of(dList);//will not compile
		System.out.println("sum of doubles is "+dStream.sum());//this returns a double
		
		dStream=DoubleStream.of(dArray);
		//this returns an OptionalDouble
		System.out.println("average of doubles is "+dStream.average());//OptionalDouble[23.9872]
		System.out.println("average of doubles is "+DoubleStream.of(dArray).
													average().
													getAsDouble());//23.9872
		System.out.println("sum of doubles is "+DoubleStream.of(dArray).
				sum());;
			/*
			 * this will generate NoSuchElementException, as there is no value as this is based on a 
			 * empty DoubleStream. there is NO get() method for DoubleStream,IntStream and LongStream	
			 */
	//	System.out.println(DoubleStream.empty().average().getAsDouble());
		
		OptionalDouble optD = DoubleStream.of(dArray).average();
		optD=DoubleStream.empty().average();//.getAsDouble();
		System.out.println("optD");
		System.out.println(optD);
		optD=DoubleStream.empty().average();
		/*
		 * if in doubt use orElse, which just assigns 0.0 as the double for optD
		 * or orElseGet, which uses a supplier to generate a double or in this case a Double.NaN which
		 * is a NotANumber, what a NaN will do is your program will not crash, but NaN if use anywhere in a 
		 * calculation will alway result in NaN
		 * 1+Nan*4-6 the answer will be NaN
		 */
		//System.out.println(optD.getAsDouble());//this will genereate NoSuchElementException
		System.out.println("optD is "+optD.orElse(0.0));
		System.out.println("optD is "+optD.orElseGet(()->Double.NaN));
		optD=DoubleStream.of(dArray).average();
		//this will print out 23.9872
		System.out.println("optD is "+optD.orElse(0.0));
		//this will also print out 23.9872
		System.out.println("optD is "+optD.orElseGet(()->Double.NaN));
		/*
		 * when you have NaN in a calculation it will always produces NaN
		 */
		System.out.println(1+Double.NaN*12);//NaN
		
		System.out.println("random number generator");
		/*
		 * Streams that use primitives can also use Iterate() and generate(), and just like in other 
		 * streams can produce infinite streams
		 * this would produce an infinite amount of primitive doubles
		 */
		DoubleStream randomDs=DoubleStream.generate(()->Math.random());
		randomDs.limit(5).forEach(System.out::println);
		/*
		 * you can also use iterate
		 * iterate takes a seed and a unarary operator
		 * seed will be a double and the unary operator will take an double and return a double
		 */
		System.out.println("fractions");
		//starts at 0.5 and divides by 2, becomes 0.25 and divides by 2
		DoubleStream fractions=DoubleStream.iterate(0.5, d->d/2).
											limit(4);
		
		System.out.println(fractions.peek(System.out::println)
									.sum());
		double dnum=2;
		System.out.println("multiples");
		DoubleStream.iterate(dnum, d->d*2).limit(10).forEach(System.out::println);
		
		System.out.println("15 random doubles");
		DoubleStream.generate(()->Math.random()).limit(15).forEach(System.out::println);
		System.out.println("generating 5 random numbers between the numbers 3 and 30, not including 3 and 30");
		IntStream.generate(()->{
							int num=(int)(Math.random()*100);
							while(num<4 || num >29)
								num=(int)(Math.random()*100);
							return num;
							}			
				).distinct().
				limit(5).
				forEach(System.out::println);
		System.out.println("using range to print in range 3 to 30, including 3 but not including 30");
		/*
		 * range takes a int which is number we start from and will be included and takes a second
		 * is the number we go UP TO but do NOT include. the last number in this stream will be the 
		 * number 29
		 */
		System.out.println(IntStream.range(3, 30).peek(System.out::println).sum());
		System.out.println("using rangeclosed to print 3 to 30, including both 3 and 30");
		//use any or all match to get only 6 numbers between 4 and 30
		System.out.println(IntStream.rangeClosed(3, 30).
				peek(System.out::println).
				sum());
		System.out.println("5 numbers between 4 and 30");
		

		
		Stream<String>strStream=Stream.of("penguin","seal","dolphin","whale","fish","shark");
		System.out.println("our strings and the length of the strings");
		System.out.println((int)(strStream.peek(System.out::print).//this is Stream
				/*
				 * mapToInt takes in ToIntFunction, which is a function lambda for Ints
				 * int that that it takes an object and returns an int
				 * in this case it takes a string and returns the amount of characters in the string
				 * which is an int
				 */
							mapToInt(x->x.length()).//this is a IntStream
							peek(System.out::println).//this is a IntSream
							average().getAsDouble()));//this is a OptionalDouble
		
		Random rand=new Random();
	//	System.out.println(rand.nextInt(2,30));
		List<Integer>numbers=Stream.generate(()->(int)(Math.random()*100)+1).
							distinct().
							filter(x->x%2==0).
							limit(15).
							collect(Collectors.toList());
		/*
		 * you can't create a IntStream from a Collection object (List,Set or a queue)
		 * however what you can do is first create a stream from a collection object and then use
		 * one of the mappers to create your  IntStream, DoubleStream or LongStream
		 * in this case we use take our numbers List of Integer and create a stream
		 * then we use MAPTOINT to create a Intstream from this stream and we can then use all of the
		 * methods of the IntStream class
		 */
		System.out.println("taking our 15 random numbers in a stream and converting them to a IntStream");
		System.out.println(numbers.stream().//this is a stream
							mapToInt(x->x*2).//this is now an Intstream
							peek(System.out::println).//this is an Instream
							sum());
		IntStream ranges=IntStream.rangeClosed(2, 20).filter(x->x%2==1);
		System.out.println("converting from IntStream to Stream of Integers");
		List<Integer>listIntegers=ranges.mapToObj(x->x).//this produces a Stream of Integers
								peek(System.out::println).//stream of Integers produces
								collect(Collectors.toList());//Stream of Integers added to list
		//ranges.collect(Collectors.toList());
				
	}
	/**
	 * this method deals again with using optional with primitive streams. As a IntStream for instance could be empty, when calling methods
	 * such as average, it will return a OptionalInt which may or may not have a value, as you can't get average of a nothing. Each of the 
	 * specialist optional types of OptionalInt, OptionalDouble, OptionalLogn will be covered, along with the "getAs" methods, i.e 
	 * OptionalDouble has a getAsDouble(), which converts a optional if it has a value to a double primitive. This also covers the 
	 * rangeClosed() method of these primitive streams which allows us to get a range of numbers between set values
	 */
	static void ex3() {
		System.out.println("Using Optionals with Primitve Streams");
		/*
		 * this is a Optional for Objects, we have to give the Optional a type, if we dont' this will
		 * be a Optional of type Object. this is an optional of type Double
		 */
		Optional<Double>optDouble=Optional.of(3.45);
		/*
		 * this is an optional of type Object
		 * if you don't supply a type, your optional will be of type Object
		 */
		Optional optNoType=Optional.of(3.45);
		System.out.println(optDouble);
		System.out.println(optDouble.get());
		optDouble=Optional.empty();
		/*
		 * this genereates a NoSuchElementException
		 */
		//System.out.println(optDouble.get());
		System.out.println(optDouble.orElse(0.0));
		System.out.println(optDouble.orElseGet(()->Math.random()));
		System.out.println(optDouble.orElseGet(()->Double.NaN));
		//produces a stream of numbers divisible by 15 and between 10 and 100
		IntStream stream=IntStream.rangeClosed(10, 100).filter(n->n%15==0);
		/*
		 * average returns an OptionalDouble
		 * this is a different data type to a Optional<Double>, which is for wrapper Double objects
		 * and OptionalDouble is for primitive doubles
		 */
		System.out.println("OptionalDouble ");
		//average is a terminal operation and closes the Stream
		OptionalDouble optDbl=stream.peek(System.out::println).average();
		/*
		 * the stream is closed but you can call all the methods of the OptionalDouble class on the
		 * variable optDbl
		 */
		System.out.println(optDbl);
		System.out.println(optDbl.getAsDouble());
		System.out.println(optDbl.orElse(Double.NaN));
		System.out.println(optDbl.orElseGet(()->Math.random()));
		
		
		LongStream longs=LongStream.rangeClosed(1, 30).filter(l->l%3==0);
		OptionalLong optLong=longs.max();//this is a terminal operation
		/*
		 * we cannot perform any more operations on this stream, as a the terminal operation max() has already
		 * occured on this stream
		 */
	//	longs.max();//this generates IllegalStateException
		/*
		 * if i want to use another operation on the stream after it is closed, you will have recreate it
		 * 
		 */
		longs=LongStream.rangeClosed(1, 30).filter(l->l%3==0);
		longs.min();
		System.out.println(optLong);
		System.out.println(optLong.getAsLong());
		System.out.println(optLong.orElse(123));
		System.out.println(optLong.orElseGet(()->(long)Math.random()));
		/*
		 * just like an ordinary stream a IntStream, LongStream or a DoubleStream can produce infinite 
		 * streams
		 */
		System.out.println(Math.PI);
		DoubleStream doubles=DoubleStream.generate(()->Math.PI);//.forEach(System.out::println);;
		/*
		 * this will produce an infinite Stream of the nubmer 3.141592653589793
		 */
		//doubles.forEach(System.out::println);
	}
	/**
	 * max(),min(),average() of the primitive Stream classes (IntStream,DoubleStream,LongStream) are all TERMINAL operations, which
	 * means no stream operations can happen after these methods are called. In fact if you use a terminal operation of the IntStream class
	 * for instance and use a getter, this will be a primitive data type and no further methods can be called. For instance we produce
	 * a IntStream and get the average of this IntStream and use a getAsInt, which we do with the following code {@code
	 * IntStream.generate(()->(int)(Math.random()*100)).limit(10).min().getAsInt();     }
	 * this produces a primitive int, so no further methods can be called after this point, this code produces 10 numbers and then calls the
	 * sum() method of the IntStream class, this returns a primitive int, so again NO methods can be called on this stream after sum(){@code
	 * IntStream.generate(()->(int)(Math.random()*100)).limit(10).sum(); 		}
	 * Summary statistics are a class of objects that hold such information as average(), sum(), min(), max(), count() that can be done
	 * even after a stream is closed. There are seperate SummaryStatistcs classes for each primitive type. so we have a 
	 * IntSummaryStatistics for IntStream, a DoubleSummaryStatistics for DoubleStream and a LongSummaryStatistics for LongStream. These objects are
	 * based on a existing stream and holds information about that stream.
	 * We produce a Stream of 5 numbers between 20 and 80 {@code
	 * IntStream ints2=IntStream.rangeClosed(20, 80).limit(5);}
	 * and them produce a IntSummaryStatistics object from this IntStream {@code
	 * IntSummaryStatistics statInts2=ints2.summaryStatistics();			}
	 * the summaryStatistics() method is a TERMINAL operation, which means no further operations can be carried out on this stream, however
	 * the statInts2 object can call it's own max(), min(), sum(), average() and count() method as it holds this information about the stream
	 * that was closed. 
	 * we get this information using the following syntax {@code
	 * statInts2.getMax(), statInts2.getMin(), statInts2.sum(), statInts2.average(), statInts2.count()		}
	 */
	static void ex4() {
		System.out.println("Summary Statistics ");
		IntStream ints=IntStream.rangeClosed(1, 1000).filter(i->i%85==0).limit(10);
		//we can get the max, but this is a terminal operation, so it closes the stream
		System.out.println(ints.max().getAsInt());
		//you can do no further operation on this stream
		//System.out.println(ints.min().getAsInt());//can't do terminal operations on a closed stream
		//can't do intermediate operations on a closed stream
	//	ints.filter(i->i%2==0);
		/*
		 * we can use Summary Statistics to perform max, min, average, sum, getCount and these are
		 * not methods of the Stream class, but a seperate class entirely
		 * IntSummaryStatistics for IntStream
		 * DoubleSummaryStatistics for DoubleStream
		 * LongSummaryStatistics for LongStream
		 */
		ints=IntStream.rangeClosed(1, 1000).filter(i->i%85==0).limit(10);
		/*
		 * ints.summaryStatistics is a terminal operations so no more operations can be performed on
		 * the ints Stream
		 */
		IntSummaryStatistics statInts=ints.summaryStatistics();
		
		System.out.println("getCount()");
		System.out.println("count of ints is "+statInts.getCount());
		System.out.println("max of ints is "+statInts.getMax());
		System.out.println("min  of ints is "+statInts.getMin());
		System.out.println("average of ints is "+statInts.getAverage());
		System.out.println("sum of ints is "+statInts.getSum());
	//	System.out.println("class of object in the stream "+statInts.getClass());
		
		DoubleSummaryStatistics statDoubles=DoubleStream.generate(()->Math.random()).
											limit(15).
											summaryStatistics();
		System.out.println("count of doubles is "+statDoubles.getCount());
		System.out.println("max of doubles is "+statDoubles.getMax());
		System.out.println("min  of doubles is "+statDoubles.getMin());
		System.out.println("average of doubles is "+statDoubles.getAverage());
		System.out.println("sum of doubles is "+statDoubles.getSum());
	
		
		
		LongSummaryStatistics statLong;
	}
	/**
	 * Streams for primitives have all the methods that you have for Object primitives (i.e filter, generate, peek, forEach). These methods
	 * take versions of Consumer, supplier, predicate, BiPredicate,etc functional interfaces specific to the type of primitive Streams. So for 
	 * instance a Generate for a Stream of String, would Take {@code Supplier<String>}. A Supplier, for usage with methods of the IntStream class 
	 * is a IntSupplier, and no type is needed to be supplied for this type of Supplier as this will be just returning a primmitive int. For example {@code
	 * IntSupplier intSup=()->(int)(Math.random()*100)		}
	 * An IntStream.generate() method takes a Intsupplier, so we can go {@code
	 * IntStream.generate(intSup).limit(50)}
	 * to produce a primtive stream of 50 numbers between 1 and 100. LongStream has LongSupplier, LongConsumer, etc DoubleStream has LongSupplier,
	 * LongConsumer, etc. This method and {@link com.android.Examples#ex6} feature the different functional interface for streams that handle primitives.
	 * We start with BooleanSupplier, which has very limited usage, as there is no streams for dealing with primitive booleans, only a {@code
	 * Stream<Boolean>}
	 * for dealing with wrapper booleans
	 */
	static void ex5() {
		System.out.println("functional interfaces for primitives");
		System.out.println("Boolean supplier");
		/*
		 * Boolean supplier is a functional interface, that is a specialist SUPPLIER that take in no
		 * parameters and returns a primitive boolean
		 * the method inside the functional interface is getAsBoolean
		 */
		BooleanSupplier b1=()->true;
		BooleanSupplier b2=()->false;
		BooleanSupplier b3=()->(int)(Math.random()*10)>5;
		/*
		 * this is the implemenation of the BooleanSupplier interface and the abtract method
		 * boolean getAsBoolean();
		 */
		BooleanSupplier b4=()->{
			boolean bool=(int)Math.random()*10>5;
			if(bool)
				System.out.println("number greater than 5");
			else
				System.out.println("number less than 5");
			return bool;
		};
		//this just prints off the address
		System.out.println(b1);
		System.out.println(b4);
		//this will run the code inside b4
		System.out.println(b4.getAsBoolean());		
	}
	/**
	 * this method deals with 
	 * DoubleSuplier, IntSupplier and LongSupplier and we show how to use IntSupplier with IntStream.generate()
	 * DoubleConsumer, IntConsumer, LongConsumer and we show how to use IntConsumer with forEach()
	 * DoublePredicate,IntPredicate,LongPredicate and we show how to use DoublePredicate with filter()
	 * DoubleFunction, Intfunction, LongFunction and we show how to use IntFunction with mapToObj()
	 * DoubleUnaryOperator,IntUnaryOperator,LongUnaryOperator and we show how to use IntUnaryOperator with map()
	 * DoubleBinaryOperator,IntBinaryOprator,LongBinaryOperator and we show how to use IntBinaryOperator with reduce()
	 * no BiConsumer equalivent for primitve doubles, ints and primitive longs
	 * no BiPredicate equalivent for primitive doubles, ints or primitive longs
	 * no BiFunction equalivent for primitive doubles, ints or primitive longs
	 * 
	 */
	static void ex6() {
		System.out.println("functional Interfaces for double,int and long");
		/*
		 * will do examples for primitive doubles and the exact same applies to int and long, except the
		 * name will be begin with "int" or "long"
		 * i.e
		 * doubleConsume is a consumer for a primitive double
		 * intConsume is a consumer for a primitive int
		 * longConsume is a consumer for a primitive long
		 */
		System.out.println("supplier, DoubleSupplier,IntSupplier,LongSupplier");
		
		Supplier<Double>sup=()->Math.random();
		/*
		 * you do not have to specify a type as DoubleSupplier is returning a primitive double no matter what.
		 * and also types<> can ONLY BE objects and primitive double is NOT an object
		 * these are suppliers for primitives
		 * getAsDouble is the abtract method which looks like this
		 * double getAsDouble()
		 */
		DoubleSupplier doubleSup=()->Math.random();
		//the method for the DoubleSupplier is getAsDouble
		System.out.println(doubleSup.getAsDouble());
		
		IntSupplier intSup=()->(int)(Math.random()*100);
		System.out.println(intSup.getAsInt());
		//can be used like the following
		IntStream.generate(intSup).limit(5);
		
		System.out.println("DoubleConsumer,IntConsumer,LongConsumer");
		/*
		 * consumer takes in an object and returns void
		 * DoubleConsumer takes in a primitive double and returns void
		 * IntConsumer takes in a primitive int and returns void
		 * LongConsumer takes in a primitive long and returns void
		 * the method is accept
		 * void accept(double d)
		 * no generics needs as the DoubleConsumer ALWAYS returns a primitive double
		 */
		DoubleConsumer doubleConsumer=(d)->System.out.println("number is "+d);
		doubleConsumer=System.out::println;
		doubleConsumer.accept(3.45);
		int localInt=78;
		int changeInt=45;
		
		String name="noel";
		
		weight=123;
		/*
		 * the only variable you cannot access inside a functional interface is a local variable that is
		 * NOT effectively final
		 */
		IntConsumer intConsumer=(i)->{
			System.out.println("number is "+i);
			System.out.println("age is a variable "+weight);
			System.out.println("localInt is local effectively final variable "+localInt);
	//		System.out.println("cannot access local variable that are NOT effecitively final "+changeInt);
		};
		/*the above consumer can be used like the following in forEach*/
		IntStream.rangeClosed(10, 200).limit(50).forEach(intConsumer);
		
		weight=98;
		
		changeInt=78;
		intConsumer.accept(56);
		/*
		 * there is also a LongConsumer
		 */
		System.out.println("DoublePredicate,IntPredicate,LongPredicate");
		/*
		 * predicate takes an object and returns a boolean primitive
		 * DoublePredicate takes a primitive double and returns a boolean
		 * IntPredicate takes a int and returns a boolean
		 * LongPredicate takes a primitive long and returns a boolean
		 * relatively simple functional interface that test a long,int and double
		 * we do not have to define a generic type as this will ALWAYS take a primtive double and always
		 * returns a boolean
		 */
		DoublePredicate doublePred=(d)->d>0.5;
		/*
		 * the method is test
		 * boolean test(double d)
		 */
		double dnum=Math.random();
		System.out.println(dnum);
		System.out.println(doublePred.test(dnum));;
		/*the above DoublePredicate can be used like the following*/
		DoubleStream.generate(()->Math.random()).filter(doublePred);
		
		System.out.println("DoubleFunction,IntFunction,LongFunction");
		/*
		 * function takes a object and returns a object, can be the same type or different
		 * DoubleFunction takes a Double and returns an object
		 * IntFunction takes a Int and returns an object
		 * LongFunction takes a long and returns an object
		 * uses apply
		 * <T> t apply(double d)
		 */
		/*
		 * this takes in an double and returns an Integer
		 * DoubleFunction always takes a double but it return any type
		 */
		DoubleFunction<Integer>doubleFunc=d->(int)(d*2);
		//takes in a int and returns a String
		IntFunction<String>intFunc=i->i+"";
		//returns a primitive double and returns a StringBuilder object with the primitive inside it
		DoubleFunction<StringBuilder>doubleFunc2=d->new StringBuilder(d+"");
		System.out.println(doubleFunc2.apply(2.34).getClass().getSimpleName());
		/*takes the IntFunction intFunc and produces a stream of Strings*/
		IntStream.rangeClosed(20, 80).limit(9).mapToObj(intFunc).forEach(System.out::println);

		System.out.println("DoubleUnaryOperator,IntUnaryOperator,LongUnaryOperator");
		/*
		 * primitive equalivent of UnaryOpeator for int, primitive doubles and primtives longs, 
		 * ordinary unaryOperator takes in a object and returns object of same type
		 * DoubleUnaryOperator takes in a primitive Double returns primitive double
		 * IntUnaryOpeartor takes in a int and returns an int
		 * LongUnaryOpeartor takes in a primitive long and returns a long
		 */
		DoubleUnaryOperator doubleUn=(d)->d*2;
		System.out.println(doubleUn.applyAsDouble(4.5));
		
		IntUnaryOperator intUn=(i)->i*10;
		System.out.println(intUn.applyAsInt(123));
		/*the Map method takes a IntUnaryOperator*/
		IntStream.rangeClosed(20, 80).peek(System.out::println).map(intUn).forEach((n)->System.out.println());;
		
		System.out.println("DoubleBinaryOperator,IntBinaryOprator,LongBinaryOperator");
		/*
		 * binary operator takes in two objects and returns one objects
		 * DoubleBinaryOperator takes in two primitive doubles returns a primitive double
		 * IntBinaryOpeartor takes in two ints and returns a int
		 * LongBinaryOperator takes in a primitive long and returns a primitive long
		 */
		DoubleBinaryOperator doubleBinar=(d1,d2)->d1*d2;
		IntBinaryOperator intBinar=(i1,i2)->i1+i2;
		
		System.out.println(doubleBinar.applyAsDouble(2.3, 4.56));
		System.out.println(intBinar.applyAsInt(123, 456));
		/* reduce method takes a IntBinaryOperator*/
		IntStream.rangeClosed(10, 1000).limit(12).reduce(intBinar);
		/*
		 * no BiConsumer equalivent for primitve doubles, ints and primitive longs
		 * no BiPredicate equalivent for primitive doubles, ints or primitive longs
		 * no BiFunction equalivent for primitive doubles, ints or primitive longs
		 */	
	}
	
//	int age=34;
	static int weight=5;
	
	
	

}
