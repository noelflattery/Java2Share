package com.android;

public class Animal {
	String type;
	static int counter;
	Animal(String type){
		this.type=type;
		counter++;
	}
	@Override
	public String toString() {
		return "Animal [type=" + type + " counter is "+counter;
	}

	
}
