package com.android;
//public class Accountant<T,V>implements BiConsumer<T,V>

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
/**
 * class Electrician  implements the BiFunction interface, so it has to provide implementation for the apply method
 * of the BiFunction interface. when we create an Electrician{@code
 * 	Electrician<Integer,String,Animal>myEmployee=new Accountant<Integer,String,Animal>()}
 * we are setting type T to be an Integer, type U to be a string and type V to be a Animaldwhich means that the BiComsuer 
 * Interfaces types  will then also be set to an Integer, String and Animal
 * @author NoelF
 * @param <T> this is the type that will be supplied when creating an Electrician and will apply to the first generic type of the
 * BiFunction
 * @param <U>this is the type that will be supplied when creating an Electrician and will apply to the second generic type of the
 * BiFunction
 * @param <V>this is the type that will be supplied when creating an Electrician and will apply to the third generic type of the 
 * BiFunction
 * @see com.android.Examples#ex9() 
 */
public class Electrician<T,U,V> implements BiFunction<T,U,V>{
	/**
	 * Overriding the apply method with Type T,U and V, T and U will be parameters, V will be the return type
	 * @return returns an object of type V
	 */
	@Override
	public V apply(T t, U u) {
		// TODO Auto-generated method stub
		return null;
	}

}
