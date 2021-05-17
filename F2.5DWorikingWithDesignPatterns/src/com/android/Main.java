package com.android;

import java.util.Arrays;
/**class that contains our main method*/
public class Main {
/**
 * the Factory pattern is also referred to as the "Factory Method Pattern"
 * how do we create objects in which the precise type of object is not known until runtime.
 * some method of is needed in selecting which sub class to use (i.e subclass of Animal is
 * Lion and Goat and determine at runtime that we will be creating a meat object to feed
 * to the Lion)
 * this is a creational pattern that uses a Factory class to produce instances of objects
 * based on a set of input parameters.
 * Often implemented by using static methods, so do not need an instance of the Factory
 * class.
 * Also considered good practice to postfix the word "Factory" to the end of the Class name
 * i.e FoodFactory
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/K0ur8DEb6FA">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @param args
 */
	public static void main(String[] args) {
	//	Examples.ex1();
	//	Examples.ex2();
		Examples.ex3();
		

	}

}
