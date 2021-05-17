package com.android;

public class Animal {
	int age;
	String name;
	
	Animal(int age,String name){
		this.age=age;
		this.name=name;
	}

	@Override
	public String toString() {
		return "\nAnimal age is" + age + ", name is " + name + "]";
	}

	
}
