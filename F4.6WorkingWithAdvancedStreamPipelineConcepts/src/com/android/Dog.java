package com.android;

import java.text.NumberFormat;
import java.util.stream.Stream;
/**This class is used in conjunction wiht {@link com.android.Examples#ex1()}
 * this class is used to show lazy instantiation of a Stream variable inside of this class
 * the variable {@link com.android.Dog#myStream} is a Stream variable and some creating and intermediate
 * operations are carried out inside an initialization block, however at this point there is NO terminal operations, so
 * at this point nothing is produced. it is only when a Dog object calls the {@link com.android.Dog#bark()} method
 * is a Terminal operation called on this stream, and as this point our stream of 10 numbers is produced and printed out
 * to screen
 * This is also used with {@link com.android.Examples#ex6()} to use summarizingDouble, SummarizingInt, summarizingLong
 * @author NoelF
 *@see com.android.Examples#ex1()
 */
public class Dog {
	/**age of Dog*/
	int age;
	/**name of dog*/
	String name;
	/**weight of dog*/
	Double weight;
	/**this is a variable that is a {@code Stream<Integer>}
	 * Streams are just another data type, so a class can have as one of it's atributes a Stream
	 * which can be private, public, protected, final or static
	 */
	private Stream<Integer>myStream;
	/**
	 * this is an initialisation block where creation and intermediate operations are carried out on the Stream variable
	 * myStream
	 */
	{
		/**
		 * this code DOES NOT run, until a terminal operation is called on the stream
		 * this is called lazy instantiation. so the stream of 10 numbers, will not be created
		 * until a terminal operation is called on this stream
		 */
		myStream=Stream.iterate(1, i->i*2).limit(10).peek(System.out::println);
	}
	/**
	 * Dog constructor that takes two parameters, a int age and a String name
	 * @param age is the age of the Dog
	 * @param name is the name of the Dog
	 */
	Dog(int age,String name){
		this.age=age;
		this.name=name;
	//	System.out.println("Dog created");
//		myStream.forEach((i)->System.out.println("number is "+i));
	}
	/**counter that will be incremented when the {@link com.android.Dog#Dog(int, String, double)} constructor that takes a int
	 * String and double is called
	 */
	static int dogCounter=0;
	/**
	 * Dog constructor that takes three parameters, a int age, a String name and a double weight
	 * @param age is the age of the Dog
	 * @param name is the name of the Dog
	 * @param weight is the weight of the Dog
	 */
	Dog(int age,String name,double weight){
		this.age=age;
		this.name=name;
		this.weight=weight;
		dogCounter++;
	}
	/**
	 * the variable {@link com.android.Dog#myStream} and it's intialisation block does not contain a Terminal operation, so no result
	 * will be seen until a terminal operation is run. This method calls the Terminal Operation on the myStream operation,
	 * so all the operations will be seen to run when this method is called, when this method is called, what you have is {@code
	 *  myStream=Stream.iterate(1, i->i*2).//starts at 1 and multiplies the number by 2 each time, so get 1,2,4,8,etc
	 *  limit(10)//limits to 10 numbers we get 1,2,4,8,16,32,64,128,256,512
	 *  .peek(System.out::println)//prints out the stream at this point
	 * .filter(x->x%2==0).//this is the part of the steam in the bark() method and filters for only even numbers
	 * forEach((n)->System.out.println("number is "+n))//terminal operation that prints out 2,4,8,16 }
	 */
	void bark() {
		System.out.println("the bark methods calls a terminal operation on the Dog Stream");
		myStream.filter(x->x%2==0).forEach((n)->System.out.println("number is "+n));
	}
	
	
	
  //  nf.setMaximumFractionDigits(2)
	/**
	 * overridden toString method that prints out the age, name and weight of a Dog
	 * @return a string containing the age, name and weight of a Dogs
	 */
	@Override
	public String toString() {
		//NumberFormat allows to create a numberFormatter
		NumberFormat nf= NumberFormat.getInstance();
		//this numberFormatter is set to two decimal places
        nf.setMaximumFractionDigits(2);
        //use the formatter nf withs its method format() to print out doubles with only 2 decimal places
		return "Dog [age=" + age + ", name=" + name + "]"+"weight is "+nf.format(weight);
	}
	
	

}
