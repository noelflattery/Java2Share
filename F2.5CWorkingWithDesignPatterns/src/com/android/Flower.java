package com.android;

import com.android.Flower.Colour;
import com.android.Flower.Type;
/**
 * Flower class has a seperate Builder class to create Flower objects
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/2LTVxGL9XOI">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
public class Flower {
	/**
	 * Constructor that takes, as values, all the variables of its class
	 * @param age
	 * @param type
	 * @param weight
	 * @param height
	 * @param colour
	 * @param smell
	 * @param petals
	 */
	public Flower(int age, Type type, double weight, double height, Colour colour, boolean smell, 
			int petals) {
		super();
		this.age = age;
		this.type = type;
		this.weight = weight;
		this.height = height;
		this.colour = colour;
		this.smell = smell;
		this.petals = petals;
	}
	/**age of the flower*/
	int age;
	/**inner enum class of flower, we only have 5 types of flower*/
	enum Type{
		ROSE,TULIP,PANSY,BAGONIA,VIOLET
	}
	/**type of flower, can be one of five*/
	Type type;
	/**weight of flower*/
	double weight;
	/**height of flower*/
	double height;
	/**inner enum class of flower, we only have 7 colours*/
	enum Colour{
		RED,BLUE,GREEN,YELLOW,PURPLE,WHITE,PINK
	}
	/**colour of flower, can only be one of 7*/
	Colour colour;
	/**true if it has a smell, false if not*/
	boolean smell;
	/**amount of petals in flower*/
	int petals;
	/**how much flower costs to buy*/
	double price;
	/**flower constructor that takes no arguements*/
	Flower(){
		System.out.println("flower constructor called");
	}
	/**toString method that prints out all the variables of a flower*/
		@Override
	public String toString() {
		return "Flower [age=" + age + ", type=" + type + ", weight=" + weight + ", height=" + height + ", colour="
				+ colour + ", smell=" + smell + ", petals=" + petals + "]";
	}
}
/**
 * this is a class for building flowers, nameing convention is name of the
 * class of Objects it is creating, in this case
 * Flower
 * followed by the word
 * Builder
 * and you end up with 
 * FlowerBuilder
 * we have setters for each variable of the flower class we wish to give values to. each of these
 * setters return a flowerBuilder object (which allows us to chain the methods). we then have a final
 * builder method which returns a flower with all the variables we have set using the setter methods
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/2LTVxGL9XOI">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
class FlowerBuilder{
	/**
	 * when using the Builder class the first thing you need to do is
	 * to create and instance of the Object you will be creating. In this
	 * case we create a Flower, that calls the blank constructor in
	 * the Flower class
	 * this produces a flower that will have default values for all of it's 
	 * variables
	 * we normally make it private
	 */
			private Flower myFlower=new Flower();
		/**
		 * we need to create setters for each one of the Variables of 
		 * the Flower class. if you don't want to be able to set a value,
		 * then just dont' have a setter for it.	
		 * each setter HAS TO return a Builder object, in this case, each 
		 * setter has to return a FlowerBuilder Object. So each one of these 
		 * methods can be chained
		 * i.e
		 * new FlowerBuilder().setAge(10).setTypes(Types.Rose).
		 */
			public FlowerBuilder setAge(int age) {
				//this gives the Flower variable myFlower an age
				myFlower.age=age;
				//this returns the same flowerBuilder object that calls this
				//method
				return this;
			}
			/** 
			 * each one of these setters returns the same FlowerBuilder
			 * object that is calling this method. So each one of these methods
			 * can call ALL of the methods of the FlowerBuilder class
			 * setAge(10).setColour(Colour.RED)
			 * each one of these setters is giving some variable of the 
			 * flower created in this class (myFlower) a value
			 * for instance setAge is giving myFlower and age other than the 
			 * default of 0.
			 * returns same FlowerBuilder object and gives myFlower variable
			 * a type (rose, tulip, etc)
			 */
			public FlowerBuilder setType(Type type) {
				myFlower.type=type;
				return this;
			}
			/**
			 * returns same FlowerBuilder object and gives myFlower variable
			 * a weight
			 */
			public FlowerBuilder setWeight(double weight) {
				myFlower.weight=weight;
				return this;
			}
			/**
			 * returns same FlowerBuilder objects and gives myFlower variable
			 * a Height
			 */
			public FlowerBuilder setHeight(double height) {
				myFlower.height=height;
				return this;
			}
			/**
			 * returns same FlowerBuilder objects and gives myFlower variable
			 * a colour (RED,BLUE,etc)
			 */
			public FlowerBuilder setColour(Colour colour) {
				myFlower.colour=colour;
				return this;
			}
			/**
			 * returns same FlowerBuilder objects and gives myFlower variable
			 * a smell (true/false)
			 */
			public FlowerBuilder setSmell(boolean smell) {
				myFlower.smell=smell;
				return this;
			}
			/**
			 * returns same FlowerBuilder objects and gives myFlower variable
			 *a value for petals, which is the amount of petals on a flower
			 */
			public FlowerBuilder setPetals(int petals) {
				myFlower.petals=petals;
				return this;
			}
			/**
			 * returns same FlowerBuilder objects and gives myFlower variable
			 *a price, which is the price charged for this flower
			 */
			public FlowerBuilder setPrice(double price) {
				myFlower.price=price;
				return this;
			}
			/**
			 * by convention the last method in the Builder class is  called
			 * build
			 * this returns the Flower that all the setter methods have given
			 * it various variable values 
			 * i.e setWeight(12) would give the flower a weight of 12
			 * setColour(Colour.RED) would give the flower a colour of Red
			 * this returns the flower that has been modified by all of the
			 * setter methods
			 */
			public Flower build() {
				return myFlower;
			}
	
		}
