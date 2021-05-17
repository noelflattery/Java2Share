package com.android.generics;

import com.android.animals.Animal;
import com.android.animals.Elephant;
import com.android.animals.Zebra;

import java.util.stream.Stream;

/**
 * a Generic can be defined as a subclass of another class
 * here the generic we will say can be an Animal or a subclass of Animal
 * so methods first defined in the Animal class, can be used by this 
 * object, as well as those first defined in the object class
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
public class Box <T extends Animal>{
	/**this will be a variable of whatever type we say T will be, type T can only be a Animal or subclass of
	 * Animal, only three classes are subclasses of Animal, Cow, Elephant and Zebra
	 * so if we say
	 * {@code Box<Zebra>zedBox}
	 * type T will be a Zebra and myAnimal will be a Zebra and anywhere else in the Box class type T will be a 
	 * Zebra */
	private T myAnimal;
	
	/**constructor that takes an argument of Type T*/
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
