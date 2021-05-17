package com.android;

import java.util.ArrayList;
import java.util.List;
/**
	 * CREATING IMMUTABLE OBJECTS
	 * create objects that can be shared across mutiple classes but do not want
	 * they're values modified.
	 * copies of objects creates large overheads
	 * 1>>>use a constructor to set ALL of the properites of the object
	 * 2>>>Mark all of the instance variables to be private and final
	 * 3>>>don't define any setter methods
	 * 4>>>don't allow referenced mutable objects to modified or accessed
	 * 		directly
	 * 5>>>Prevent methods from being overridden
	 * To see video tutorial for this section of code
	 * <a href="https://youtu.be/v62ACKQMTls">Video tutorial</a>
	 * For all 177 videos, which cover all the topics in this course go to
	 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 */
public final class Animal {
	/**
	 * when you mark a class as final, you can't extends the class, which means
	 * you can't override the methods of the class.
	 * A final class DOES NOT prevent you from changing the variables of the
	 * class, marking a variable as final means you cannot change the value of the
	 * variable.
	 */
	private final String name;//string is immutable
	/**age of the animal which we mark as final to prevent the variables value being changed*/
	private final int age;//age is a int and int is sent by value
	/**
	 * we can't change who the emp1 is, it will always be the object first
	 * assigned to it, however we can change the "weight" and the "id" of 
	 * this object. we wish to ensure that the "weight" and "id" CANNOT be changed, so the
	 * getter for this variable will send a COPY of the object and not the orignal object
	 */
	private final Employee emp1;//Employee is a mutlable class
	/**list of favourite foods for each animal which we also mark as final
	 * when you mark an list as final you are only saying that the List itself is final however the 
	 * objects the list contains are not in themself final. so when we use a getter to view these
	 * objects in the list, ensure that you are sending a COPY of the objects and not the original
	 * list*/
	private final List<String>favouriteFoods;
	/**constructor for the animal class*/
	Animal(String name,int age,Employee emp1,List<String>favouriteFoods)
	{
		this.name=name;
		this.age=age;
		this.emp1=emp1;
		this.favouriteFoods=favouriteFoods;
	//	this.favouriteFoods.add("new food");
	}
	/**
	 * String class is immutable itself so you can return this without it being
	 * modified
	 */
	public String getName() {
		return name;
	}
	/**
	 * Primitives are not passed by reference so you  can return this without
	 * it being modified
	 */
	public int getAge() {
		return age;
	}
	/**
	 * this sends a copy of the Employee object, not the orginal object
	 * so if you change the name of this Employee it will not affect
	 * emp1
	 * this is a shallow copy
	 */
	public Employee getEmp1() {
		//shallow copy, only the values of the exising employee are copied
		Employee newEmployee=new Employee(emp1.weight,emp1.pps);
	/*	System.out.println("my weight is "+emp1.weight);
		System.out.println("my pps is "+emp1.pps);*/
		return newEmployee;
	}
	/*
	 * this is NOT A shallow copy, so do NOT use this if you want your class
	 * to immutable
	 */
/*	public Employee getEmpWrong() {
		return emp1;
	}*/
	/**
	 * if you have a list and it's in a immutable, you don't return the list
	 * you return THE VALUES of the list (shallow copy)
	 */
	public List<String>getFavouriteFoods(){
		//favouriteFoods is a list variable of the Animal class
		List<String>newList=new ArrayList<String>(favouriteFoods);
		return newList;
	}
/*	
	public List<String>getWrongList(){
		return favouriteFoods;
	//	return newList;
	}*/
	/**toString method of the Animal class which will print out the details of the Animal*/
	public String toString() {
		return emp1.weight+" is the weight "+emp1.pps+" is the pps"+favouriteFoods;
		
	}

}
