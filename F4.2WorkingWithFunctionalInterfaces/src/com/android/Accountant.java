package com.android;

import java.util.function.BiConsumer;
/**
 * class Accountant implements the BiConsumer interface, so it has to provide implementation for the Accept method
 * of the Biconsumer interface. when we create an Accountat{@code
 * 	Accountant<Integer,String>myEmployee=new Accountant<Integer,String>()}
 * we are setting type T to be an Integer and type V to be a string which means that the BiComsuer Interfaces types 
 * will then also be set to an Integer and String
 * @author NoelF
 * @param <T> this is the type that will be supplied when creating an Accountant and will apply to the first generic type of the
 * BiConsumer
 * @param <V>this is the type that will be supplied when creating an Accountant and will apply to the second generic type of the
 * BiConsumer
 * @see com.android.Examples#ex5() 
 */
public class Accountant<T,V>implements BiConsumer<T,V> {
	
	@Override
	/**
	 * Overriding the accept method with Type T and V been given it's types when we create an Accountant Object
	 * @return returns nothing as this method is CONSUMING two objects
	 */
	public void accept(T t, V u) {
		// TODO Auto-generated method stub
		
	}

	

}
