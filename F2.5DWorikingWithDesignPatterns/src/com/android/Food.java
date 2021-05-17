package com.android;
/**
 * super abstract class for our food types Hay, Vegetable, Fish and Meat
 * This food types are all eaten by certain types of Animal
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/K0ur8DEb6FA">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
public abstract class Food {
	/**amount of food each animal takes */
	private int quantity;
	/**constructor for food object*/
	public Food(int quantity) {
		this.quantity=quantity;
	}
	/**gets the quantity of food for the Animal*/
	public int getQuantity() {
		return quantity;
	}
	/**
	 * each type of Food is consumed in a different way, every class that extends Food
	 * has to have it's own consumes() method
	 */
	public abstract void consumes();
}
/**subclass of Food used for feeding Goats and Zebras
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/K0ur8DEb6FA">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>*/
class Hay extends Food{
/**Constructor for the Hay Class that takes one int quantity argument*/
	public Hay(int quantity) {
		super(quantity);
		// TODO Auto-generated constructor stub
	}
/**overriden consumes method of the Food class*/
	@Override
	public void consumes() {
		System.out.println("animal is eating "+getQuantity()+" amount of hay");
		
	}	
}
/** subclass of Food for feeding rabbits
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/K0ur8DEb6FA">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>*/
class Vegetable extends Food{
/**constructor for Vegetable class that takes an int quantity arguement*/
	public Vegetable(int quantity) {
		super(quantity);
		// TODO Auto-generated constructor stub
	}
/**overriden consumes method of the Food class*/
	@Override
	public void consumes() {
		System.out.println("animal is eating "+getQuantity()+" vegetables");
		
	}
	
}

/**subclass of Food for feeding polar bears
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/K0ur8DEb6FA">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>*/
class Fish extends Food{
/**Constructor for the Fish Class that takes one int quantity argument*/
	public Fish(int quantity) {
		super(quantity);
		// TODO Auto-generated constructor stub
	}
	/**overriden consumes method of the Food class*/
	@Override
	public void consumes() {
		System.out.println("animal is eating "+getQuantity()+" Fish");
		
	}	
}

/**subclass of Food for feeding lions
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/K0ur8DEb6FA">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>*/
class Meat extends Food{
/**Constructor for the Meat Class that takes one int quantity argument*/
	public Meat(int quantity) {
		super(quantity);
		// TODO Auto-generated constructor stub
	}
	/**overriden consumes method of the Food class*/
	@Override
	public void consumes() {
		System.out.println("animal is eating "+getQuantity()+" meat");
		
	}
	
}
