package com.android;

import java.util.ArrayList;
import java.util.List;
/**
 * class that illustrates examples for creating immutable objects
 * @author Owner
 *we create a Animal immutable object using a string, an int, an employee and a list of string which are 
 *the fruits an Animal eats.
 *there is an intentional omission in this code in that Employee object, that is part of Animal object
 *is not in itself a immutable object, one of the techniques to overrome this is to have the Employee class
 *implement the Clonable interface and override the clone() method of the Object class, which we will
 *see in action in ex2
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/v62ACKQMTls">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
public class Examples {
	static void ex1() {
		Employee eddie=new Employee(12.5,12345);

		/*
		 * a list based on an array, cannot have objects added to it
		 * so if i go Arrays.asList("banana","orange",
				"apple","pineapple")
				you create list you cannot add too
		 */
		List<String>fruits=new ArrayList<>();
		fruits.add("apple");
		fruits.add("orange");
		fruits.add("banana");
		fruits.add("pineapple");
		Animal andy=new Animal("andy", 45, eddie, fruits
				);
		Employee newEmployee=andy.getEmp1();
		System.out.println(andy);
		newEmployee.pps=7777777;
		newEmployee.weight=123456.89;
		System.out.println(andy);
		/*
		 * this sends back orignal employee, which we we can then modify
		 */
		//Employee anotherEmp=andy.getEmpWrong();
		System.out.println(andy);
	//	anotherEmp.weight=11111.11;
	//	anotherEmp.pps=99999999;
		//the emp1.weight and pps are now changed
		System.out.println(andy);
		
		List<String>newList=andy.getFavouriteFoods();
		newList.add("beef");
		System.out.println(andy);
		/*
		 * this sends back the original list, which we can then modify
		 */
	//	List<String>wrongList
		//System.out.println(wrongList);
	//	wrongList.add("word");
		/*
		 * the word "word" is now added to the list
		 */
		System.out.println(andy);
	}
	/**
	 * this method illustrates how Employee implements the Clonable interface and usage of the Object class
	 * clone() method. A clone is a copy of an object, so in this case it's another employee with the same
	 * id and weight as a original Employee, but its a DIFFERENT Employee
	 */
	static void ex2() {
		Employee emp2=new Employee(23.4,23114);
		Employee emp3;
		try {
			emp3=emp2.clone();
			//same weight and pps number
			System.out.println("emp2 is "+emp2);
			//same weight and pps number
			System.out.println("emp3 is "+emp3);
			//but not the same employee
			System.out.println(emp2.equals(emp3));
		}
		catch(Exception e) {
			System.out.println("exception is "+e);
		}
	}

}
