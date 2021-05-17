package com.android;

import java.util.function.BinaryOperator;
/**
 * Class GP implements the BinarOperator interface, so it has to provide implementation for apply method of the 
 * BinaryOperator interface. When we create a GP by {@code 
 * GP<Double>doctor=new GP<Double>()}
 * we are setting type T to be a Double, which means the BinaryOperator interface will then also be set to be a Double
 * @author NoelF
 * @param <T> this is the type that will be supplied when creating a GP which will then be the type of BinaryOperator and this
 * will be the type from the BinaryOperator accept method()
 * @see com.android.Examples#ex11() 
 */
public class GP<T>implements BinaryOperator<T> {

	@Override
	/**
	 * Overriding the apply method with Type T when we create a GP object, takes two T parameters and returns a T object
	 * @return returns an object of type T
	 */
	public T apply(T t, T u) {
		// TODO Auto-generated method stub
		return null;
	}

}
