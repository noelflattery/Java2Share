package com.android.interfaces;
/**
 * this is a functional interface and it only has ONE abstract method inside it
 * As this is a functional interface we can use lambdas to implement this interface
 * you can have as many as you like default and static methods in a functional interface
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 * @author Owner
 *
 */
@FunctionalInterface
public interface Life {
	/**
	 * the only abstract method of the functional interface life, any lambda has to implement this method
	 */
	void grow();
	/**
	 * does not matter how many  default or static methods are contained within a 
	 * functional interface, all that matters is that you have only ONE abstract
	 * method
	 */
	default void defMethod() {
		
	}
	/**deafult method of life interface*/
	default void defMethod2() {
		
	}
	/**static method of the life interface*/
	static void statMethod() {
		
	}
	/**static method of the life interface*/
	static void statMethod2() {
		
	}

}
