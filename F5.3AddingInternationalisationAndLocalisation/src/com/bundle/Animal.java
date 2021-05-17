package com.bundle;

public class Animal {
	//inner enum
	public enum Type{
		DOG,CAT,COW,SHEEP
	}
	//variables
	int age;
	Type name;
	static int count=0;
	//constructor
	public Animal(int age,Type name){
		this.age=age;
		this.name=name;	
	}
	
	public String toString() {
		return "age is "+age+" and type is "+name;
	}

}
