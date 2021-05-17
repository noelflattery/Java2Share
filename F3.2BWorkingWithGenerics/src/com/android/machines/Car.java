package com.android.machines;

import com.android.interfaces.Move;
/**
 * if no type information is supplied both T and V are going to be Objects
 * no type is provided so both T and V for Move will be Objects
 */
public class Car implements Move{
/**As no type was provided when implementing the Move interface, type T is said to be an object
 * this is overriding void fly(T t) method of the move interface*/
	@Override
	public void fly(Object t) {
		System.out.println("car flying");
		System.out.println(t.getClass().getSimpleName()+" is flying");
		
	}
/**As no type was provided when implementing the Move interface, type T is said to be an object and type
 * V to be an object
 * this is overriding void walk(T t, V v) method of the move interface
 */
	@Override
	public void walk(Object t, Object v) {
		System.out.println("car walking");
		System.out.println(t.getClass().getSimpleName()+" is walking");
		System.out.println(v.getClass().getSimpleName()+" is walking");
		
	}

}
