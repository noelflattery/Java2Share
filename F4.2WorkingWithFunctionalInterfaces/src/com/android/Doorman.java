package com.android;

import java.util.function.Function;
/**
 * class Doorman implements the Function interface, so it has to provide implementation for the apply method
 * of the Function interface. when we create an Doorman{@code
 * 	Doorman<Integer,String>mrDoor=new Doorman<Integer,String>()}
 * we are setting type T to be an Integer and type R to be a string which means that the Function Interfaces types 
 * will then also be set to an Integer and String
 * @author NoelF
 * @param <T> this is the type that will be supplied when creating an Doorman and will apply to the first generic type of the
 * Function interface
 * @param <R>this is the type that will be supplied when creating an Doorman and will apply to the second generic type of the
 * Function interface
 * @see com.android.Examples#ex8()
 */
public class Doorman<T,R>implements Function<T,R> {

	@Override
	/**
	 * Overriding the apply method with Type T and R when we create a Doorman object, takes parameter of type T and returns and 
	 * object of type R
	 * @return returns an object of type R
	 */
	public R apply(T t) {
		// TODO Auto-generated method stub
		return null;
	}

}
