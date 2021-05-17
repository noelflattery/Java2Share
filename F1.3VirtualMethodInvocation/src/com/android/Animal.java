package com.android;
/**
 * abstract super class for Cow, Bird and Fish
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/WfuKKSwRNbw">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 */
public abstract class Animal {
/**
 * any class that extends the Animal HAS to override this 
 * feed method
 */
	public abstract void feed();
/*	void feed() {
		System.out.println("animal feeding");
	}*/
	/**
		 * myAnimal.feed() in this code 
		 * will always be a subclass of Animal, as only subclasses
		 * of the Animal class have a concrete feed method, and the
		 * Animal class is abstract. It will always be a Cow, a Fish
		 * or a Bird that is calling this method. You will ALWAYS be
		 * using a Overridden feed method, this is virtual method
		 * invocation
		 * @param myAnimal this will be any sub class of Animal that will call the overridden feed method
		 * for that Animal subclass
		 */
	public static void feedAnimal(Animal myAnimal) {
		
		myAnimal.feed();
	}
}
/**
 * Concrete subclass of abstract Animal class that must provide implementation for abstract feeed method
 * of the superclass
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/WfuKKSwRNbw">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 */
class Cow extends Animal{
/**
 * overrdding feed method of the Abstract superclass Animal, this also calls the @see {@link com.android.Cow#addHay()}
 * method which is unique to Cows and subclasses of Cows
 */
	@Override
	public void feed() {
		System.out.println("cow is about to feed");
		addHay();
		
	}
	/**
	 * this a method unique to Cows and subclasses of Cows and is called by feed method of the Cow class
	 * @see com.android.Cow#feed()
	 */
	private void addHay() {
		System.out.println("adding hay for the cow to eat");
	}
}
/**
 * sub class of Animal so has to override the abstract feed method and it also has it's own  addSeed
 * method which is avaiable to itself or subclasses of Bird
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/WfuKKSwRNbw">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 */
class Bird extends Animal{
/**
 * concrete overridden feed method of the super class Animal abstract feed method
 * this also calls the {@link com.android.Bird#addSeed()} which is a method unique to Birds
 */
	@Override
	public void feed() {
		System.out.println("bird is about to eat");
		addSeed();
		
	}
/**
 * this method is unique to Birds and subclasses of Bird and is called by the feed method of the bird class
 * @see com.android.Bird#feed()
 * @author NoelF
 */
	private void addSeed() {
		System.out.println("adding birdseed for the bird to eat");
	}
}
/**
 *  * sub class of Animal so has to override the abstract feed method and it also has it's own addFishFood()
 *  {@link com.android.Fish#addFishFood()}
 * method which is available to itself or subclasses of Fish
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/WfuKKSwRNbw">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author Owner
 *
 */
class Fish extends Animal{
	/**
	 * Overridden feed method that calls the {@link com.android.Fish#addFishFood()} method of the
	 * Fish class
	 */
	@Override
	public void feed() {
		System.out.println("fish is about to eat");
		addFishFood();	
	}
	/**
	 * this method is unique to Bish and subclasses of Fish and is called by the feed method of the Fish class
	 * @see com.android.Fish#feed()
	 */
	private void addFishFood() {
		System.out.println("adding fishFood for fish to eat");
	}
}