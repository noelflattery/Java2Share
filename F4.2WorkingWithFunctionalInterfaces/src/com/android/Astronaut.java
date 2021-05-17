package com.android;

import java.util.function.Consumer;
/**
 * Class Astronaut implements the Consumer interface, so it has to provide implmentation for accept method of the 
 * Consumer interface. When we create a Astronaut by {@code 
 * Astronaut<Double>astroDouble=new Astronaut<Double>()}
 * we are setting type T to be a Double, which means the Consumer interface will then also be set to be a Double
 * @author NoelF
 * @param <T> this is the type that will be supplied when creating a Astronaut which wil then be the type of Consumer and this
 * will be the type from the Consumer accept method()
 * @see com.android.Examples#ex4() 
 */
public class  Astronaut<T>implements Consumer<T> {
	
	@Override
	/**
	 * Overriding the accept method with Type T which is given a type when creating an Astronaut
	 * @return returns nothing as this method is CONSUMING an object
	 */
	public void accept(T t) {
		// TODO Auto-generated method stub
		
	}

}
