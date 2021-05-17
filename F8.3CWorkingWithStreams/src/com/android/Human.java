package com.android;

import java.io.Serializable;

public class Human implements Serializable{
	int age;
	String name;
	double weight;
	/*
	 * Dog does NOT implement serializable, so if a human has Dog,  you have to mark that dog
	 * as being transient. If you do not mark this object as transient then your code will simply exit
	 * without your Human object being serialized
	 * transient tells the compiler NOT TO attempt the serialize this object, so then our code will
	 * compile correctly
	 */
	transient Dog spot;
	/*
	 * this will be serialized because the Cat class implements Serializable
	 */
	Cat tibbles;
	//constructor 
	/*
	 * this is a static and will NOT be included in the serialized file
	 */
	static int counter=0;
	
	Human(int age,String name,double weight){
		this.age=age;
		this.name=name;
		this.weight=weight;
		spot=new Dog();
		tibbles=new Cat();
	}

	@Override
	public String toString() {
		return "Human age is " + age + ", name is " + name + ", weight is " + weight+" "+tibbles+" "+spot;
	}
	
	

}
