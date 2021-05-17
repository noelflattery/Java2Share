package com.android.generics;

import com.android.animals.Animal;
import com.android.interfaces.Behaviour;

/**
 * can have more than one generic type,  here we have three generic types
 * T will be a type that extends the Animal class
 * V will be a type that implements the Behaviour interface
 * E can be any type of Number (Number is a superclass of all wrapper number classes 
 * Integer,Double,Float,Byte,Short,Long
 */
public class Kettle <T extends Animal ,V extends Behaviour,E extends Number>{
/**
 * T can be a Animal or it subclasses which are Elephant, Zebra and 
 * Cow
 */
	T myT;
	/**
	 * myV can be a class that implements the Behaviour interface, which 
	 * are Whale and Lemur
	 * can be a also anonymous class implementation of the Behaviour 
	 * interface
	 */
	V myV;
	/**
	 * myE can be any class
	 */
	E myE;
	/**
	 * takes three values of type T, V and E, which will be supplied when a Kettle object is created
	 * @param myT
	 * @param myV
	 * @param myE
	 */
	public Kettle(T myT,V myV,E myE){
		this.myT=myT;
		this.myV=myV;
		this.myE=myE;
		/*
		 * this is a Animal so can call all methods that are common accross all 
		 * Animals
		 */
		myT.eat();
		myT.sleep();
		/*
		 * this is a object that will implement the Behaviour interface, so will be
		 * only able to call methods of the Behaviour interface
		 */
		myV.mad();
		myV.sad();
		myV.happy();
		/*
		 * myE only has access to methods first defined in the Object class
		 */
		
		
		
	}
}
