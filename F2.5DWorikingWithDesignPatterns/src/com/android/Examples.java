package com.android;
/**class that contain our examples that deal with three overloaded methods of the FoodFactory class*/
public class Examples {
	/**this calls the first overloaded getFood method of the FoodFactory class
	 * Food getFood(String animalName) 
	 * this is the method that would have the most problems as you can pass any string to this and also remember
	 * that strings are case sensitive, so "rabbit" is a different string to "Rabbit"
	 * To see video tutorial for this section of code
	 * <a href="https://youtu.be/K0ur8DEb6FA">Video tutorial</a>
	 * For all 177 videos, which cover all the topics in this course go to
	 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 */
	static void ex1() {
		/*
		 * this calls the first type of FoodFactory method, which is a method that takes a
		 * String and returns a certain food type, depending on what the string is
		 */
		//this will create a Fish Food object
		Food food=FoodFactory.getFood("PolarBear");
		//this will call the Fish consumes() method
		food.consumes();
		//this will create a Vegetable food object
		Food food2=FoodFactory.getFood("Rabbit");
		//this will call the Vegetable consumers() method
		food2.consumes();
		/*
		 * the issue with a factory method that takes a string is that you can send it 
		 * any string you want
		 */
		food2=FoodFactory.getFood("Coal");
		food2=FoodFactory.getFood("rabbit");
	}
	/**this calls the second overloaded getFood method of the FoodFactory class
	 * Food getFood(Animal myAnimal)
	 * This takes an Animal is enclosed and you can only send it a subclass of Animals and nothing else so less scope 
	 * for issues with this. 
	 */
	static void ex2() {
		System.out.println("calling second overloaded FoodFactory method that takes an Animal");
		//this will create a hay food object
		Food food=FoodFactory.getFood(new Goat());
		//this will call the consumes method for Hay
		food.consumes();
		//this creates a Meat food object
		food=FoodFactory.getFood(new Lion());
		//this will call the consumes method for a meat
		food.consumes();
		/*
		 * this overloaded method CAN ONLY take Animals and the sub classes of Animals
		 */
		StringBuilder sb1=new StringBuilder("hello there");
		//will not compile
		///FoodFactory.getFood(sb1);
		System.out.println("calling third overloaded method that takes a AnimalType enum");
		food=FoodFactory.getFood(AnimalType.GOAT);//create Hay food object
		food.consumes();//calls consumes method for Hay food object
		food=FoodFactory.getFood(AnimalType.POLARBEAR);//creates Fish food object
		food.consumes();//calls consumes method for the Fish food object
	}
	/**this uses the Third overloaded method of the FoodFactory class
	 * Food getFood(AnimalType type) 
	 * this takes a AnimalType enum typ and can only be one of these values 
	 * POLARBEAR,RABBIT,GOAT,ZEBRA,LION
	 * again as it can only take these types it is more enclosed thatn one that takes a String and there is less scope
	 * for issues
	 */
	static void ex3() {
		System.out.println("calling third overloaded method that takes a AnimalType enum");
		Food food=FoodFactory.getFood(AnimalType.GOAT);//create Hay food object
		food.consumes();//calls consumes method for Hay food object
		food=FoodFactory.getFood(AnimalType.POLARBEAR);//creates Fish food object
		food.consumes();//calls consumes method for the Fish food object
	}

}
