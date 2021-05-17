package com.android;

import java.util.function.BiPredicate;
/**
 * Class Carpenter implements the BiPredicate interface, so it has to provide implmentation for Test method of the 
 * BiPredicate interface. When we create a Carpenterby {@code 
 * Carpenter<Double,String>astroDouble=new Astronaut<Double,String>()}
 * we are setting type T to be a Double and type U to be a String, which means the Consumer BiPredicate interface will also have the
 * types T to be a Double and type U to be a String
 * @author NoelF
 * @param <T> this is the type that will be supplied when creating a Carpenter which will then be the type T as well for the 
 * BiPredicate
 * @param <U> this is the type that will be supplied when creating a Capenter which will then be type U as well for the
 * BiPredicate
 * @see com.android.Examples#ex7() 
 */
public class Carpenter<T,U> implements BiPredicate<T,U> {

	@Override
	/**
	 * Overriding the Test method with Type T  and U been given they're types when we create an Carpenter Object
	 * @return should return an object of type Boolean
	 */
	public boolean test(T t, U u) {
		// TODO Auto-generated method stub
		return false;
	}

}
