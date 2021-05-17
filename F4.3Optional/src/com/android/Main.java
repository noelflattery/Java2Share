package com.android;

import java.util.ArrayList;
import java.util.Optional;
/**
 *class that contains the main method, which will be used to call the Code that deals with the
 *Optional type
 *in java 8 you can have a OPTIONAL type, which is a data type. this type is used with Java 8 Streams, which will be discussed
 *in more detail in Section 4.4
 *Optional data type can only have as it's generic a Object, cannot be a primitive (as is the case with all Generic types)
 *@author Owner
 *@see com.android.Main#average(int[]) 
 *
 */
public class Main {
	/**
	 * this is a optional that has a data type of Integer, so if this Optional has
	 * a value it will be a Integer
	 */
	static Optional<Integer>intOpt;
	/**
	 * this is a optional that has a data type of Double, so if this optional has a
	 * value, it will be an Integer
	 */
	static Optional<Double>dblOpt;
	/**
	 * this is a Optional that is given no data type, so if this optional has a value
	 * it will be an object (so if you assign a string to this optional, you will
	 * have a Object reference to a String object
	 */
	static Optional opt;
	//datat type is String
	/**
	 * this is an Optional of type String, so if this Optional has a value it will be a String
	 */
	static Optional<String>strOpt;
	/**
	 * initialiser which assigns values to our optionals
	 */
	{
		/*
		 * you can't assign a value directly to an optional
		 */
		//intOpt=3;//
		/*
		 * you can use the static method of() of the optional class to give a value
		 * to a Optional variable
		 * intOpt is a Optional of data type Integer, so you can only assign Integers
		 * to it
		 */
		intOpt=Optional.of(12);
		dblOpt=Optional.of(2.5);
		/*
		 * this was given no value which means it's an optional of Object type
		 * so any object can be assigned to it
		 */
		opt=Optional.of("hello");
		opt=Optional.of(new ArrayList<Integer>());
		
		strOpt=Optional.of("hello there ");		
	}
	/**
	 * you can't assign a value directly to a an optional
	 * you can use the static method of() of the optional class to give a value
	 * to a Optional variable
	 * intOpt is a Optional of data type Integer, so you can only assign Integers
	 * to it
	 * {@code intOpt=Optional.of(12);}
	 * if you wish to use optional as a number then you use the get() method of the Optional class
	 * {@code intOpt.get()}
	 * other methods to use are 
	 * isPresent(), which returns a boolean, true if there is a value, false if not
	 * orElse(), which will give a default value even if the optional has no value
	 * i.e {@code intOpt.orElseGet(23)//if intOpt has no value will give a value of 23}
	 * orElseGet() which takes a Supplier, so a call to this method could look like {@code
	 * intOpt.orElseGet(()->(int)(Math.random()*100)}
	 * @param args 
	 */
	public static void main(String[]args) {
		
		//intOpt.get();
		/*
		 * all our variables are given values in a instance initialiser, which only
		 * runs when we create an object of this class.
		 */
		Main myMain=new Main();

		/*
		 * this is NOT a number, it's a optional that MAY OR MAY NOT have a value
		 * so you can't do any mathematical operations on it
		 */
		System.out.println(intOpt);
		//System.out.println(intOpt++);
	//	System.out.println(4+intOpt);
		/*
		 * you also can't assign it to a int or Integer
		 */
	//	Integer num=intOpt;
		System.out.println("get() method");
		/*
		 * get returns the value of the Optional, which in this case is the 
		 * Integer 12
		 */
		System.out.println("value of intOpt is "+intOpt.get());
		//can use mathematical operators on it
		System.out.println(intOpt.get()+4);
		//can assign it to a variable
		int num=intOpt.get();
		System.out.println(++num);
		/*
		 * as this is an optional of type String, if we use the get() method we then
		 * have a string, which has access to all the methods of the String class
		 */
		strOpt.get().concat("another string");
		
		System.out.println("creating local Optional");
		Optional<Integer>optInt=Optional.of(23);
		//this is not a number
		System.out.println("print the optional "+optInt);
		System.out.println("using get "+optInt.get());
		num=optInt.get();
		System.out.println("num is now "+num);
		
		Optional<Double>optDbl=Optional.empty();
		//this will compile and print out "Optional.empty
		System.out.println(optDbl);
		/*
		 * if you use GET() on a empty optional, then you get the runtimeException
		 * NoSuchElementException, because there is NO VALUE to get. In this case
		 * there is NO double value to get
		 */
	//	System.out.println(optDbl.get());
		System.out.println("isPresent()");
		/*
		 * isPresent() is a method of the Optional class, which returns a boolean.
		 * true if the optional has a value, false if not
		 */
		System.out.println(optDbl.isPresent());//will return false as has no value
		System.out.println(optInt.isPresent());//will return true as has a value 
		/*
		 * if this Optional<Double> has a value, get the value, if not, 
		 * you could do this also as a Ternary operator
		 */
		if(optDbl.isPresent()) {
			System.out.println(optDbl.get());
		}
		else
			System.out.println("no value for this optional");
		
		String value=null;
		Optional o=(value==null)?Optional.empty():Optional.of(value);
		/*
		 * if the optional has a value, assign that value to dnum, otherwise assing
		 * 0.0. to dnum
		 */
		Double dnum=(optDbl.isPresent()?optDbl.get():0.0);
		
		Optional<Double>dblOpt=Optional.of(12.34);
		//this optoinal has no value
		optInt=Optional.empty();
		//this will generate an NoSuchElementException
		//System.out.println(optInt.get());
		System.out.println("orElse");
		/*
		 * if optInt has not value, this will use the value of 23. however optInt
		 * is still empty.. this just uses teh value 23 ONCE
		 */
		System.out.println(optInt.orElse(23));
		//optInt is still empty
		System.out.println(optInt);//prints off Optional.empty
		/*
		 * orElse operates the same as a Get() if a value for dblOpt exists, there
		 * is a value for dblOpt, which was 12.34, so this will return 12.34
		 */
		System.out.println(dblOpt.orElse(23.6));
		/*
		 * if dblOpt Optional has a value, assign that value to dnum, if it has NO
		 * value then assign 100 to dnum
		 */
		dnum=dblOpt.orElse(100.00);
		System.out.println(dnum);
		num=optInt.orElse(23);
		System.out.println(num);
		System.out.println("orElseGet");
		/*
		 * orElseGet gets the value of a Optional if the Optional has a value, if the 
		 * optional has no value, this will assign a new value to the Optional
		 */
		dblOpt=Optional.empty();//dblOpt now has no value
		//dblOpt.get();//generates NoSuchElementException
		/*
		 * uses a supplier
		 * /* @FunctionalInterface public interface Supplier<T>{
			 *  	public T get();
			 *  }
			 *  takes no paramters and returns one object
			 *  */
		System.out.println(dblOpt.orElseGet(
				()->Math.random()*100
				));
		System.out.println(dblOpt);
		
		System.out.println("sending numbers to method that returns an optional");
		
		System.out.println("calling average with a some numbers");
		System.out.println(average(10,20,30,40));
		System.out.println("average with one number");
		System.out.println(average(3));
		System.out.println("average with an array");
		System.out.println(average(new int[] {
		67,89,99,1000		
		}));
		System.out.println("average with no numbers");
		System.out.println(average());
		System.out.println(average().orElseGet(()->Math.random()*100));
			
	}//end of main method
	/**
	 * this returns an optional variable, which may or may not have a value. this
	 * takes a varArgs, which can be a number of ints, a single int, an array of ints
	 * or NO INTS. so if we sent no ints to this method (average() ), this can't 
	 * return an average of nothing. that is why we make the return an Optional
	 * as it may or  may not have a return value
	 * @param scores parameter that is a series of ints
	 * @return returns an Optional of type Double
	 */
	static Optional<Double>average(/*Optional<Integer>o*/int...scores){
		/*
		 * have to check if any numbers are sent to this method, 
		 */
		if(scores.length==0) {
			System.out.println("no numbers sent to this method");
			//returns a Optional variable with no values
			return Optional.empty();
		}
		System.out.println("numbers have been sent to this method");
		int sum=0;
		for(int score:scores)
			sum+=score;
		return Optional.of((double)sum/scores.length);
	}

}
