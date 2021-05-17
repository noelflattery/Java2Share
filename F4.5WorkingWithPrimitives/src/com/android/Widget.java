package com.android;
/**class used in {@link com.android.Examples#ex1} and will be used to demonstrate mapToInt, which will convert a Stream of
 * widges to a IntStream
 * @author NoelF
 *@see com.android.Examples#ex1
 */
public class Widget {
	/**inner enum with five types
	 * RED,BLUE,GREEN,BLACK and WHITE
	 * @author NoelF
	 *
	 */
	enum Colour{
		/**
		 * First type of Colour Enum
		 */
		RED
		/**
		 * Second type of Colour enum
		 */
		,BLUE,
		/**
		 * Third type of Colour enum
		 */
		GREEN,
		/**
		 * Fourth type of Colour enum
		 */
		BLACK,
		/**
		 * fifth type of Colour enum
		 */
		WHITE
	}
	/**Colour of the Widget, can only be red, blue,green, black or white*/
	private Colour colour;
	/**weight of widget*/
	private int weight;
	/**
	 * getter for the colour variable
	 * @return the enum type colour for the widget
	 */
	public Colour getColour() {
		return colour;
	}
	/**
	 * getter for the weight variable
	 * @return the weight of the widget
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * constructor that takes a enum type colour and a int weight
	 * @param colour is the colour of the widget
	 * @param weight is the weight of the widget
	 */
	Widget(Colour colour,int weight){
		this.colour=colour;
		this.weight=weight;
	}

}
