package com.android;
/**
 * class that is a super class of Dog, Cat, Fish, Bird, Lizard
 * will be used with to show examples of instanceof that return true and false
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/r5lDPx1dtFg">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 * @see com.android.Main
 */
public class Animal {
/**
 * checks to see if the animal sent to this method is only of one of
 * the designated subclasses of Animal. if it is a designated
 * Animal it then calls the appropriate method for that object
 * this method can ONLY take a Animal or subclass of an Animal.
 * Every Animal and subclass of Animla can also call this method
 * @param myAnimal this will be Animal or subclass of animal and we have a series of If statements that will 
 * use instanceof to check what type of Animal this is
 */
	static void moveAnimal(Animal myAnimal) {
		/*
		 * if this Animal is a Dog, this is a Animal reference to a 
		 * Dog object. So this object has no access to the bark()
		 * method, so we can cast this object to a Dog reference to
		 * a Dog object 
		 */
		//if a dog, cast reference to be a Dog and call bark method
		if(myAnimal instanceof Dog)
			((Dog)myAnimal).bark();
		else if(myAnimal instanceof Cat)
			((Cat)myAnimal).purr();
		else if(myAnimal instanceof Fish)
			((Fish)myAnimal).swim();
		else if(myAnimal instanceof Bird)
			((Bird)myAnimal).fly();
		else
			System.out.println("Animal not supported");
		//	throw new RuntimeException("unsupported Animal");
		
		
	}
}
/**
 * This is a subclass of Animal and will be shown in our code in {@link com.android.Main}, where we will be using this
 * subclass to use instanceOf and will be returning both True and False
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/r5lDPx1dtFg">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 */
class Dog extends Animal{
	/**
	 * this is a method that will be called in {@link com.android.Animal#moveAnimal(Animal)} if instanceof returns 
	 * true for {@code myAnimal instanceof Dog}
	 */
	void bark() {
		System.out.println("dog barking");
	}
}
/**
 * This is a subclass of Animal and will be shown in our code in {@link com.android.Main}, where we will be using this
 * subclass to use instanceOf and will be returning both True and False
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/r5lDPx1dtFg">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 */
class Cat extends Animal{
	/**
	 * this is a method that will be called in {@link com.android.Animal#moveAnimal(Animal)} if instanceof returns 
	 * true for {@code myAnimal instanceof Cat}
	 */
	void purr() {
		System.out.println("cat purring");
	}
}
/**
 * This is a subclass of Animal and will be shown in our code in {@link com.android.Main}, where we will be using this
 * subclass to use instanceOf and will be returning both True and False
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/r5lDPx1dtFg">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 */
class Fish extends Animal{
	/**
	 * this is a method that will be called in {@link com.android.Animal#moveAnimal(Animal)} if instanceof returns 
	 * true for {@code myAnimal instanceof Fish}
	 */
	void swim() {
		System.out.println("A fish swimming");
	}
}
/**
 * This is a subclass of Animal and will be shown in our code in {@link com.android.Main}, where we will be using this
 * subclass to use instanceOf and will be returning both True and False
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/r5lDPx1dtFg">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 */
class Bird extends Animal{
	/**
	 * this is a method that will be called in {@link com.android.Animal#moveAnimal(Animal)} if instanceof returns 
	 * true for {@code myAnimal instanceof Fish}
	 */
	void fly() {
		System.out.println("bird flying");
	}
}
/**
 * this is a subclass of Animal that will not be used in the code
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/r5lDPx1dtFg">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
class Lizard extends Animal{
	
}
