package com.android;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * this is a Enum type of 6 colours of blue, black, brown, white, red and green
 * and will be used in {@link com.android.Human} class to give a colour to all pairs of shoes a Human will have
 * @author NoelF
 * @see com.android.Human
 * @see com.android.Shoes
 */
enum Colour{
		BLUE,BLACK,BROWN,WHITE,RED,GREEN
	}
/**This class is used in conjunction wiht {@link com.android.Examples#ex1()}
 * this class is used to show lazy instantiation of a Stream of objects, which will we then use to create a Set of those same 
 * objects. The variable {@link com.android.Human#myShoes} will be a Stream of shoes, and will be used to create a Set of
 * shoes for every Human, called {@link com.android.Human#shoeSet}. Inside an initialisation block we create a Stream and 
 * do some intermediate operations on the Stream, but no terminal operations occur at this point, so nothing is produced at
 * this point. Its only when a Human class calls the {@link com.android.Human#makeShoes()} method that a terminal operation 
 * is called on the stream, and it's only at this point is a stream of shoes is produced. The Terminal operation collect() 
 * creates a set of shoes from the stream of shoes and assigns them to the shoeSet varibable
 * @author NoelF
 * @see com.android.Shoes
 * @see com.android.Examples#ex1()
 */
public class Human {
	/**name of the Human*/
	String name;
	/**age of the Human*/
	int age;
	/**amount of pairs of shoes a Human has, will be used with the intermediate operation limit() to tell our Stream how 
	 * many pairs of shoes needs to be created
	 */
	int shoeAmt;
	/**our Stream of shoes that will be lazily instantiated by the {@link com.android.Human#makeShoes()} method and will be used
	 * to create our set of shoes {@link com.android.Human#shoeSet}
	 */
	Stream<Shoes>myShoes;
	/**
	 * our collection of pairs of shoes which will be created from the Stream {@link com.android.Human#myShoes}
	 */
	Set<Shoes>shoeSet;
	/**
	 * an instantiation block where .generate() and the intermediate operation filter are used, but NO terminal operations
	 * are used at this point so nothing is produced.
	 */
	{
		myShoes=Stream.generate(()->new Shoes((int)(Math.random()*10+1),Colour.BLACK)).
				filter((s)->s.size>6).filter(s->s.size<9);
				
	}
	/**
	 * a constrcutor that takes a int age, String name and a int shoeAmt
	 * @param age is the age of the Human
	 * @param name is the name of the Huan
	 * @param shoeAmt is the amount of pairs of shoes the Human will have, and the stream {@link com.android.Human#myShoes} will use the intermediate 
	 * operation limit() in the {@link com.android.Human#makeShoes()} to determine how many pairs of shoes will be created for this HUman
	 */
	Human(int age,String name,int shoeAmt){
		this.age=age;
		this.name=name;
		this.shoeAmt=shoeAmt;
	}
	/**the Stream {@link com.android.Human#myShoes} and its initialisation does NOT have a terminal operation, so no result will be seen until a terminal
	 * operation is performed on this Stream. This method calls the collect() Terminal operation on the Stream, which causes all the operations to happen
	 * to the stream and it is only at this point that all operations are seen to run. What we have is {@code
	 * Stream.generate(()->new Shoes((int)(Math.random()*10+1),Colour.BLACK)).//creates a stream of shoes, all black with sizes 1 to 10
				filter((s)->s.size>6).//filters to shoes with a size greater than 6
				filter(s->s.size<9).//filters to shoes with a size less than 9
				limit(shoeAmt).//this is from makeShoes() method and this is the amount of pairs of shoes a Human will have, shoeAmt is provided by the constructor
				collect(Collectors.toSet());//saves our Stream to a set of Shoes, which is a Terminal operation and causes all of other operations to be performed
	 * }
	 * this is lazy instantiation, our shoes are NOT created until we call the terminal operation in 
	 * this method.
	 * @see com.android.Shoes
	 */
	void makeShoes() {
		/*
		 * we have a set to hold all of the shoes created by the stream, if the set is empty that means
		 * the stream has not yet had a terminal operation on it
		 */
	//	if(shoeSet.isEmpty())
			shoeSet=myShoes.limit(shoeAmt).collect(Collectors.toSet());
			System.out.println(shoeSet);
		/*
		 * if a terminal opeation has been run on the stream, we recreated the stream
		 */
	/*	shoeSet=Stream.generate(()->new Shoes((int)(Math.random()*10+1),Colour.BLACK)).
				filter((s)->s.size>7).filter(s->s.size<9).
				limit(shoeAmt)
				.collect(Collectors.toSet());*/	
	}

}
/**
 * this is a class that will be used by the {@link com.android.Human} class to create all the shoes a Human will wear and will help demonstratoe
 * lazy instantiation of a Stream
 * @author NoelF
 * @see com.android.Human
 */
class Shoes{

	/**size of the pair of shoes*/
	int size;
	/**colour of shoe, uses the {@link com.android.Colour} enum type*/
	Colour shoeColour;
	/**
	 * Constructor that takes two variables a int size and a enum type Colour shoeColour
	 * @param size the size of the pair of shoes
	 * @param shoeColour the colour of the pair of shoes
	 */
	Shoes(int size,Colour shoeColour ){
		this.size=size;
		this.shoeColour=shoeColour;
	}
	/**
	 * Overridden toString method that prints out the shoe's size and colour
	 */
	@Override
	public String toString() {
		return "Shoes [size=" + size + ", shoeColour=" + shoeColour + "]";
	}
	/**
	 * hashCode that generates a hash for a pair of shoes based on the size and shoeColour of the pair of shoes
	 * @return returns a number based on size and shoe colour
	 */
		@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shoeColour == null) ? 0 : shoeColour.hashCode());
		result = prime * result + size;
		return result;
	}
		
	@Override
	/**
	 * if both pairs of shoes have the same name and colour they will be said to be equal, in all other circumstances they will 
	 * said to be not equal
	 * @param obj the object the shoe calling the method is comparing itself with
	 * @return returns true if same colour and size, false in all other circumstances
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shoes other = (Shoes) obj;
		if (shoeColour != other.shoeColour)
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	
}
