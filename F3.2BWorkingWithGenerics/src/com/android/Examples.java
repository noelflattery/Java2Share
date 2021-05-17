package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.android.animals.Animal;
import com.android.animals.Ape;
import com.android.animals.Cow;
//import com.android.animals.Cow;
/*
 * this will import everything including the nested static classes, which is the 
 * CowBuilder class
 */
import com.android.animals.Cow.*;

import com.android.animals.Elephant;
import com.android.animals.Lemur;
import com.android.animals.Whale;
import com.android.animals.Zebra;
import com.android.generics.Box;
import com.android.generics.Bucket;
import com.android.generics.Container;
import com.android.generics.Crate;
import com.android.generics.Kettle;
import com.android.generics.Pan;
import com.android.generics.Pot;
import com.android.interfaces.Behaviour;
import com.android.interfaces.Life;
import com.android.interfaces.Manners;
import com.android.interfaces.Move;
import com.android.machines.Android;
import com.android.machines.Car;
import com.android.machines.Robot;
import com.android.machines.Vehicle;
import com.android.plants.Flower;
/**
 * class that contains more examples of object being created that have generics in the class declaration
 * @author Owner
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
public class Examples {
	/**
	 * Pot has the class declaration {@code class Pot<Animal>}, which would be of limited use
	 */
	static void ex1() {
		Pot<Zebra>potZebra=new Pot<>(new Zebra());
	}
	/**
	 * this demonstrates how to use interfaces that have generics (important to understand as these are the basis
	 * of functional programming, more of which discussed in chapter 4 in detail)
	 * The Move interface
	 * {@code interface Move<T,V>} 
	 * is implemented by the Robot class with explicit types 
	 * {@code class Robot implements Move<Cow,Zebra>}
	 * The move interface is also implemented with types supplied by the generics of the vehicle class
	 * {@code class Vehicle<U,X> implements Move<U,X>}
	 * this means that when create a Vehicle we are supplying the types that will be used in the generics for
	 * move
	 * i.e create a Vehicle with code 
	 * {@code Vehicle<String,Elephant>myVehicle}
	 * As vehicle implements the Move interface, that means the types U and X in Move will be set to be Elephant 
	 * and Vehicle respectively
	 * we also implment the Move interface with the Car class
	 * {@code class Car implements Move}
	 * this will set the variables U and X to be both object, if you don't supply any generic type when creating
	 * an object with generics the types will be set to be an object
	 * 
	 */
	static void ex2() {
		Robot robbie=new Robot();
		Cow myCow=new CowBuilder().build();
		/*
		 * this method can only take a Cow or a subclass  and a Zebra or a sub class of Zebra, 
		 * cannot take anything else
		 */
		robbie.walk(new CowBuilder().build(), new Zebra());
		robbie.fly(new CowBuilder().build());
		/*
		 * this uses the generic class 
		 * class Vehicle<U,X> impments Move<U,X>{
		 * to give the variable T and V in the Move interface values of String and 
		 * Elephant
		 */
		Vehicle<String,Elephant>myVehicle=new Vehicle<>();
		myVehicle.fly("hello");
		myVehicle.walk("hello",new Elephant());
		
		new Vehicle<String,Elephant>().fly("hello");
		/*
		 * the car class neither explicitly specifies the types to be used or uses a 
		 * generic class type
		 * supplied by the car. no where is a type specified so that means that types T 
		 * and V in the interface
		 * become object references when the fly() and walk() method are implemented in 
		 * the Car class
		 */
		Car myCar=new Car();
		myCar.fly("hello");//this will be an object reference to a String object
		/*
		 * here we have a object reference to a String object and a Object reference to a 
		 * Animal object
		 */
		myCar.walk("hello", new Animal());
	}
/**
 * If your generic is a type of interface, in this case the functional interface Manners, you have a number of
 * different kind of objects that can implement the interface
 * A class can implement an interface i.e 
 * {@code class Flower implements Life}
 * An anoymous class can implement Life
 * {@code new Flower() 
		{
			@Override
			public void grow() {
				System.out.println("anonymous class grow method");
			}
		};}
* You can have direct implementation of the interface
* {@code new Life() {
			@Override
			public void grow() {
				System.out.println(" grow method")			
			}	
		}}
*and you can have a lambda
*{@code ()->System.out.println("lambda grow method")}
*The classes used by this method are com.android.animals.Animal, com.android.animals.Ape, com.android.plants.Flower,
*com.android.interfaces.Life and com.android.interfaces.Manners
*
 */
	static void ex3() {
		Ape myApe=new Ape();
		myApe.sorry(new Elephant(), new Flower());
		//direct implementation ofa  interface
		Life myLife=new Life() {
			@Override
			public void grow() {
				// TODO Auto-generated method stub			
			}		
		};
		//anonymous class impl
		Flower myFlower=new Flower() 
		{
			@Override
			public void grow() {
				System.out.println("anonymous class grow method");
			}
		};
		//lambda implementation of a functional interface
		Life lifeLamb=()->System.out.println("lambda grow method");
		//taking a elephant and a anonymous class implementation of the Life interface
		myApe.sorry(new Elephant(),myFlower );
		//taking a Elephant and a lambda 
		myApe.sorry(new Elephant(), ()->System.out.println("lambda grow method"));
		//this implementation can only take an Elephant
	//	myApe.sorry(new Animal(), myFlower);
	}
	/**the class discussed here is the com.android.machines.Android
	 * as well as classes having generics individual methods can have they're own local generics, and these
	 * generic types are then only available to this method as they are LOCAL generic types
	 * there are number of ways to call these methods, for instance the talk() method signature of the android class is
	 * {@code <S> void talk(S myS)}
	 * creating a android object myAndroid we can call this method with
	 * {@code myAndroid.talk(new Zebra())}
	 * and also with
	 * {@code myAndroid.<Animal>talk(new Elephant())}
	 * static method cannot use the class generics, as those generics are tied to an instance of a class and 
	 * statics apply to class but they can have they're own local generics, so the method
	 * {@code static<S extends Animal,V extends Behaviour,U extends Manners>void method2
	(S myS,V myV,U myU)}
	*can be called with like the following
	*{@code Android.method2(new Zebra(), new Whale(), new Ape());}
	*and also with
	*{@code Android.method2(new Zebra(), new Whale(), new Ape());}
	 * 
	 */
	static void ex4() {
		Android myAndroid=new Android();
		myAndroid.walk(new Whale());
		/*
		 * method signature for this method is 
		 * <S> void talk(S myS){}
		 * so here we have a Object reference to a Zebra object
		 * if you dont' supply a type, you can pass in ANY object
		 */
		myAndroid.talk(new Zebra());
		//here we are saying the generic type is going to be Animal
		myAndroid.<Animal>talk(new Elephant());
		myAndroid.talk(new Flower());
		Android.method2(new Zebra(), new Whale(), new Ape());
		Android.<Zebra,Whale,Ape>method2(new Zebra(),new Whale(),new Ape());
	}
	

}
