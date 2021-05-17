package com.android;

import java.util.ArrayList;
import java.util.List;
/**
 * this class contains our main method
 * this project deals with the instanceof keyword, and this is used to check if an object is an instance of a 
 * particular class, i.e
 * spot instanceof Dog
 * instanceof returns a boolean, true if the object is an instance of class, false if not. It is important to note
 * that this will only compiled if the statement COULD be true, there has to be some relationship in order for
 * the code to compile
 * instanceof also is used to check if a class implements a interface and any object of any class can be checked against
 * any interface using instanceOf
 * i.e spot instanceof List
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/r5lDPx1dtFg">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 * @see com.android.Animal
 * @see com.android.Dog
 * @see com.android.Cat
 * @see com.android.Fish
 * @see com.android.Lizard
 * @see com.android.Fish
 * @see com.android.Behaviour
 * @see com.android.HeavyAnimal
 * @see com.android.Hippo
 * @see com.android.PygmyHippo
 * @see com.android.Elephant
 * @see com.android.Cow
 *
 */
public class Main {
/**
 *instanceOf returns a boolean, but it will only compile for
 *something that COULD be true, there has to be some sort
 *of relationship in order for the code to compile 
 */
	public static void main(String[] args) {
		System.out.println("****InstanceOf");
		Dog spot=new Dog();
		System.out.println(spot instanceof List);
		System.out.println(spot instanceof Dog);
		/*
		 * instanceOf returns a boolean, but it will only compile for
		 * something that COULD be true, there has to be some sort
		 * of relationship in order for the code to compile
		 */
		/*
		 * this is a HeavyAnimal super class reference to a sub 
		 * class Hippo object. 
		 * HeavyAnimal is a superclass of the Hippo class
		 */
		HeavyAnimal heavyHippo=new Hippo();
		/*
		 * this is asking is the variable heavyHippo a 
		 * HeavyAnimal object, yes it is so it's true
		 */
		System.out.println(heavyHippo instanceof HeavyAnimal);
		/*
		 * this will also return true as this is a hippo object
		 */
		System.out.println(heavyHippo instanceof Hippo);
		/*
		 * this is a heavyAnimal reference so it COULD be a referring
		 * to a Elephant object as an elephant is a subclass of HeavyAnimal
		 * So there is a relationshiop between this object and the
		 * Elephant class. However this particular object is NOT AN
		 * ELEPHANT, so it will compile, but it will be false
		 */
		System.out.println(heavyHippo instanceof Elephant);//false
		/*
		 * there is no relationship between a cow and a Hippo or
		 * a HeavyAnimal, so this will NOT compile. instanceof can
		 * only be used for compatible types, or will only compile
		 * for something that COULD BE TRUE
		 */
	//	System.out.println(heavyHippo instanceof Cow);//WILL NOT COMPILE
		Hippo henry=new Hippo();
		/*
		 * this is a Hippo reference to a Hippo object, so this will
		 * NOT compile as Henry the Hippo, could NEVER be an Elephant,
		 * so this will not compile
		 */
		//System.out.println(henry instanceof Elephant);
		/*
		 * instanceOf only works with objects, does not work for
		 * primitives
		 */
	//	System.out.println(1 instanceof int);//will not compile
		/*
		 * will not compile as 1 is an int, its' NOT AUTOBOXED
		 */
	//	System.out.println(1 instanceof Integer);//WILL NOT COMPILE
		/*
		 * this will compile as the number 5 is autoboxed to become
		 * an Integer, which is an object and can be used with
		 * instanceof
		 */
		Integer number=5;
		System.out.println(number instanceof Integer);//true
		/*
		 * can check literal object, such as the string "hello"
		 */
		System.out.println("hello"instanceof String);//true
		System.out.println(new Animal()instanceof Animal);//true
		/*
		 * all objects are instances of the Object class, as every
		 * object inherits from the Object class. there is one case
		 * where
		 * someVaribleOfObject type instanceOf returns false and that
		 * is where a variable is set to null
		 */
		System.out.println("instanceOf Object class");
		System.out.println(henry instanceof Object);//true
		Animal nullAnimal=null;
		/*
		 * if you use instanceof with a null object, this is the only
		 * circumstance that will return false when checking to 
		 * instanceof Object
		 */
		System.out.println(nullAnimal instanceof Object);//false
		//every other object will return true for instanceof Object
		System.out.println(heavyHippo instanceof Object);//true
		System.out.println("nice day" instanceof Object);//true
		System.out.println(new ArrayList<Integer>() instanceof Object);
		/*
		 * you can't have a object of an interface i.e new Behaviour()
		 * however you can use instanceof with an interface
		 * you can check to see if ANY class you create
		 * implements ANY interface you create
		 * however any interface you create cannot be implemented
		 * by any of the pre packaged classes in java (i.e strings,
		 * arrays, etc), so this can never be true, so this will not
		 * compile
		 */
		System.out.println(henry instanceof Behaviour);//false
		System.out.println(new Cow() instanceof Behaviour);//false
		System.out.println(new PygmyHippo() instanceof Behaviour);//true
		System.out.println(henry instanceof List);//false
		
	//	System.out.println("hello"instanceof Behaviour);//will not compile
//	ArrayList<Integer>numbers=new ArrayList<>();
	//	numbers.add(5);
	//	System.out.println(numbers instanceof Behaviour);//will not compile
		int[]myArray={56,78,99};
	//	System.out.println(myArray instanceof Behaviour);//will not compile
		
		Animal.moveAnimal(new Dog());
		Animal.moveAnimal(new Cat());
		Animal.moveAnimal(new Fish());
		Animal.moveAnimal(new Bird());
		//will trow a runtimeException but it will compile
		Animal.moveAnimal(new Lizard());
	}

}
