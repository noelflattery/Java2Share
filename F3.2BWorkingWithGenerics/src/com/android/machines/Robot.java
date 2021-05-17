package com.android.machines;

import com.android.animals.Cow;
import com.android.animals.Zebra;
import com.android.interfaces.Move;
/**Robot implemetns the Move interface 
 * {@code interface Move<T,V>}
 * with Robot we specify T to be a Cow and V to be a Zebra
 * so wherever in the Robot class we have T in the Move interface, it will become a Cow in Robot
 * and wherever in Robot class we have V in the Move interface, it will become a Zebra in Robot
 */
public class Robot implements Move<Cow,Zebra> {
/**overrides the void fly(T t) method of the Move interface, with type T set to be a Cow*/
	@Override
	public void fly(Cow t) {
		System.out.println("robot fly method");
		System.out.println(t.getClass().getSimpleName()+ "is flying");
		
	}
/**overrides the void walk(T t,V v) method of the Move interface, with type T set to be a Cow and type V set to be
 * a Zebra
 */
	@Override
	public void walk(Cow t, Zebra v) {
		System.out.println("robot walk method");
		System.out.println(t.getClass().getSimpleName()+" is walking");
		System.out.println(v.getClass().getSimpleName()+" is walking");
		
	}
	/*
	 * a method can have its own type, the type supplied only applies to the length of
	 * the method and is not avaiable outside of the method
	 */

}
