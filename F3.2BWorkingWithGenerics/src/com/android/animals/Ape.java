package com.android.animals;

import com.android.interfaces.Life;
import com.android.interfaces.Manners;
/**
 * here we give the Manners interface
 * {@code nterface Manners<T extends Animal,V extends Life>}
 *  a specific type of Elephant and type that implements the Life interface
 * that means type T in Manners will become a Elephant
 * and type V will be any object that implements the Life interface (which can be
 * a Flower, a Rose,a anonymous class implementation of Life interface or a lambda because
 * Life is a functional interface which means that type v can also be a lambda
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
public class Ape implements Manners<Elephant,Life>{
/**
 * Overriding the thankYou() method from the Manners interface with type V set to be an Elephant
 */
	@Override
	public void thankYou(Elephant t) {
		System.out.println("Ape thankYOu method");
		t.sleep();//call sleep method of elephant class
		t.eat();//eat method of Elephant class
		System.out.println(t);
		
	}
/**overriding the sorry() method from the Manners interface with type V set to be an Elephant and type V an 
 * object that implements the Life Interface, which can be a object of a class that implements Life, an 
 * anonymous class implementation of the Life interface or a Lambda as Life is a Functional Interface
 */
	@Override
	public void sorry(Elephant t, Life v) {
		System.out.println("Ape sorry method");
		v.grow();//the grow method of whatever object that implements the Life interface
		
		
	}

}
/**
 * here our generic types can be 
 * Any Animal or sub class of Animal which are Elephant, Zebra, Cow
 * and any object that implemetns the functional interface life, which will be 
 * Elephant, Zebra Cow, An anonymous class and as it's a funtional interface, a lambda
 */
class Chimp implements Manners<Animal,Life>{
	/**
	 * Overriding the thankYou() method from the Manners interface with type T set to be an Animal
	 */
	@Override
	public void thankYou(Animal t) {
		System.out.println("chimp thankyou method");
		t.eat();
		t.sleep();
		
	}
/**overriding the sorry() method from the Manners interface with T set to be an Animal and type V to be 
 * a object that implements Life (can be a class, anonymous class or a lambda)
 */
	@Override
	public void sorry(Animal t, Life v) {
		System.out.println("chimp sorry method");
		v.grow();
		
	}
	
}
