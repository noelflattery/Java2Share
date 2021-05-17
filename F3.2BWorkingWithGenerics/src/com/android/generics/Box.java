package com.android.generics;

import com.android.animals.Animal;
import java.util.stream.Stream;

/**
 * a Generic can be defined as a subclass of another class
 * here the generic we will say can be an Animal or a subclass of Animal
 * so methods first defined in the Animal class, can be used by this 
 * object, as well as those first defined in the object class
 * @see com.android.animals.Animal
 * 
 */
public class Box <T extends Animal>{
	/**Variable of type T, that will be a Animal or subclass of Aimal and will be provided for when we create a Box*/
	private T myAnimal;
	/**Constructor that takes a variable of Type T*/
	public Box(T myAnimal) {
		/*
		 * this is assigning whatever Animal we passed into the constructor to create
		 * the Box object
		 */
		this.myAnimal=myAnimal;
		/*
		 * this generic data type can only be a Animal, so that means we DO HAVE access to methods
		 * first defined in the Animal class, so we can call the eat(), sleep() and stampede()
		 * methods
		 * the Animal class and all of the subclasses of Elephant, Cow and Zebra all override
		 * the eat() and Sleep() method, so depending on what Animal we create our box, will 
		 * call that method for that particular Animal
		 */
		myAnimal.eat();
		myAnimal.sleep();
		myAnimal.stampede();
		/*
		 * we can also access the variables (public) of the Animal of weight and height
		 * directly
		 */
		System.out.println("height of Animal is "+myAnimal.height+" weight of Animal is "
				+myAnimal.weight);
		
	}
	
}
