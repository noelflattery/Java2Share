package com.android;
/**this is a class that contains method that will return a different type of Food dependant on the type of 
 * Animal that needs to be feed, i.e Meat object for Lion, Fish for PolarBear
 * we have three overloaded getFood() methods
 * one takes a String
 * one takes a Animal object
 * One takes a Animaltype enum value
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/K0ur8DEb6FA">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
public class FoodFactory {
	/**
	 * each one of these static methods return a food object, what type of food is 
	 * dependant on what Animal is sent to this method, this is determined here at runtime
	 * via a case statement
	 * this method takes a String, depending on the string this will return one of these objects
	 * Hay, of two different quantities
	 * Vegetable
	 * Fish
	 * Meat
	 * this uses a String to determine what food object should be created
	 */
	public static Food getFood(String animalName) {
		System.out.println("using a string to determine food Type");
		/*
		 * we don't need a break in this switch statement as when we return we are first and
		 * foremoust exiting a method. This switch statement is THE FACTORY (which is a method
		 * that produces objectgs) different objects will be produced and the type of object
		 * is dependent on the string sent to this method at runtime
		 */
		switch(animalName) {
		case "Zebra":
			return new Hay(100);
		case "Rabbit":
			return new Vegetable(5);
		case "Goat":
			return new Hay(70);
		case "PolarBear":
			return new Fish(25);
		case "Lion":
			return new Meat(34);	
			default:
				System.out.println("this is not a valid food");
			/*
			 * issue with useing strings is that they are case sensitve and spelling sensitive
			 * i.e for "Zebra" is has to be the EXACT SAME SPELLING AND CASE, ZEBRA will not
			 * work "zebra" wil not work, or "ZeBrA" will not work or , "zbra". also this can
			 * take literally any string, so i could pass in the word "banana" and it would be
			 * accepted and compile
			 */
		}
		/*
		 * if none of the above match it will compile if you throw the below runtimeException
		 * as the method never gets to the end as it will crash
		 */
	//	throw new UnsupportedOperationException("Unsupported animal: "+animalName);
		return null;
	}
	/**
	 * this method uses the Animal type object to determine what food is produced, this is a 
	 * more enclosed systemt as this will limit you to the classes of Animal you have in the
	 * application (we have a Zebra, Lion, Goat,Rabbit,PolarBear classes and all of these are
	 * sub classes of Animal, so we can only use these types).
	 * again this will return a Food object based on the type of Animal sent to this method
	 */
	public static Food getFood(Animal myAnimal) {
		/*this is using the string name of the class in a case statement, it is commented out in the code*/
		String name=myAnimal.getClass().getSimpleName();
		System.out.println("the animal is a "+name);
		/*
		 * This method is probably better than the one below, as the only below will not catch
		 * subclasses of Zebra and rabbit, whereas this will
		 */
		if(myAnimal instanceof Zebra)
			return new Hay(45);
		if(myAnimal instanceof Rabbit)
			return new Vegetable(7);
		if(myAnimal instanceof Goat)
			return new Hay(12);
		if(myAnimal instanceof Lion)
			return new Meat(34);
		if(myAnimal instanceof PolarBear)
			return new Fish(45);
		return null;
	/*	switch(name) {
		case "Zebra":
			System.out.println("Zebra eating hay");
			return new Hay(100);
		case "Rabbit":
			System.out.println("Rabbit eating Vegetables");
			return new Vegetable(5);
		case "Goat":
			System.out.println("Goat eating hay");
			return new Hay(70);
		case "Lion":
			System.out.println("lion eating meat");
			return new Meat(15);
		case "PolarBear":
			System.out.println("PolarBear eating fish");
			return new Fish(26);
			default:
				System.out.println("unsupported Animal");
				return null;
		}*/
	//	return null;
	//	throw new UnsupportedOperationException("Unsupported animal: "+name);
		
		
	}
	/**
	 * this method uses an enum called AnimalType to determine what Food is produced. The 
	 * advantage of this method is that this is totally enclosed system and it can be
	 * nothing else bar these five Animal types
	 * again this produces a Food object that is dependant on the type of Animal sent to it
	 */
	public static Food getFood(AnimalType type) {
		//you can use enums directly in a switch statement
		switch(type) {
		case ZEBRA:
			System.out.println("Zebra eating hay");
			return new Hay(15);
		case RABBIT:
			System.out.println("Rabbit eating Vegetables");
			return new Vegetable(7);
		case POLARBEAR:
			System.out.println("PolarBear eating Fish");
			return new Fish(35);
		case GOAT:
			System.out.println("Goat eating hay");
			return new Hay(9);
		case LION:
			System.out.println("Lion eating meat");
			return new Meat(23);
			default:
				System.out.println("this is not a valid Animal");
				return null;
		}
		
	}

}
