package com.android.generics;
/**
 * you can also create a class of a defined class type, in this case you can only created
 * a Pot object with a Animal type, this can be a Animal or a sub class of Animal
 * The only advantage and usage of this i can see, is that we don't have to import the 
 * Animal class
 */
public class Pot <Animal>{
	/**String variable myStr*/
	String myStr;
	/**Animal variable myAnimal*/
	Animal myAnimal;
	/**constructor that takes only a Animal*/
	public Pot(Animal myAnimal){
		this.myAnimal=myAnimal;
	}
	

}
