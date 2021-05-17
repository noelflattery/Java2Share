package com.android.animals;
/**sub class of Animal*/
public class Zebra extends Animal{
	/**name of Zebra*/
	String name;
	/**Constructor that takes no variables*/
	public Zebra(){
		System.out.println("Zebra created");
	}
	/**Overriding eat method in Animal class*/
	@Override 
	public void eat() {
		System.out.println("Zebra eating");
	}
	/**Overridding sleep method in Animal class*/
	@Override
	public void sleep() {
		System.out.println("Zebra sleeping");
	}

}
