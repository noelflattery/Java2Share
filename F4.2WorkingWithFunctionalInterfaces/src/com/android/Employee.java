package com.android;

import java.util.function.Supplier;
/**
 * class Employe implements the Supplier interface, so it has to provide implementation for the get Method
 * of the Supplier interface. when we create an Employee by {@code
 * 	Employee<Integer>myEmployee=new Employee<Integer>()}
 * we are setting type T to be an Integer, which means that the Supplier Interfaces type will then also be set to an Integer
 * @author NoelF
 *
 * @param <T> this is the type that will be supplied when creating a Employee which will then be the type of Supplier and this
 * will be the type returned from the Suppliers get() method
 * @see com.android.Examples#ex3() 
 */
public class Employee<T>implements Supplier<T> {
/**
 * Overriding the Get method with Type T been given it's type when we create an Employee Object
 * @return should return an object of type T, but here we just return null
 */
	@Override
	public T get() {
		// TODO Auto-generated method stub
		return null;
	}

}
