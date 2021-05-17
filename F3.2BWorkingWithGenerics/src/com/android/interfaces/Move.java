package com.android.interfaces;

import com.android.animals.Cow;
import com.android.animals.Zebra;

/**this interface has two generics T and V
 * three classes implement the Move interface
 * Robot implements and specifies the generic type to be used 
 * {@code class Robot implements Move<Cow,Zebra>}
 * Vehicle implements and uses it's own generics to supply a type
 * {@code class Vehicle<U,X> implements Move<U,X>}
 * Car implments but does not specify any type
 * {@code class Car implements Move}
 */
public interface Move<T,V> {
	/**fly method that has a generic type T*/
	void fly(T t);
	/**walk method that has two generic types T and V*/
	void walk(T t,V v);

}
