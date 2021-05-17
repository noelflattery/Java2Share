package com.android.animals;
/**sub class of Animal
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>*/
public class Elephant extends Animal{
	/**age of Elephant, only available to Elephant or subclasses of Animal*/
	public int age;
	/**constructor of elephant class that takes no arguements*/
	public Elephant(){
		System.out.println("Elephant created");
	}
	/**
	 * Overriding eat() method from super class Animal
	 */
	@Override
	public void eat() {
		System.out.println("Elephant eating");
	}
	/**
	 * Overriding sleep() method from the super class Animal
	 */
	@Override
	public void sleep() {
		System.out.println("Elephant sleeping");
	}
	/**
	 * Overriding the toString() method of the Object class
	 */
	@Override
	public String toString() {
		return "nellie the elephant is my name";
	}

}
