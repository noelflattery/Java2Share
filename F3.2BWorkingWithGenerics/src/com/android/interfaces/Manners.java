package com.android.interfaces;

import com.android.animals.Animal;
/**
 * T can be a Animal or one of the subclasses of Animal which are
 * Elephant,Zebra,Cow. 
 * V can be a flower or a subclass of flower, Rose. both of these classes implement
 * the Life interface. V can also be a anonymous class implementation of the Life Interface object.
 * As Life is a Functional Interface, with only one abstract method, V can also be a Lambda
 * @see com.android.animals.Animal
 * @see com.android.interfaces.Life
 */
public interface Manners<T extends Animal,V extends Life> {
/**abstract thankYou() method that takes a generic type T*/
	void thankYou(T t);
/**abstract sorry() method that takes a Generic type T and V*/
	void sorry(T t,V v);
}
