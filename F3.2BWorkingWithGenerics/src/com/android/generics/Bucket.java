package com.android.generics;

import com.android.interfaces.Behaviour;
/**
 * this class takes a Generic data type, whose class implements the Behaviour interface.
 * notice its NOT implements its EXTENDS. Whether a class is using a generic type that is
 * a extends a class or implements an interface, we use the same keyword EXTENDS
 * @see com.android.interfaces.Behaviour
 */
public class Bucket <T extends Behaviour>{
	/**
	 * variable of type T will only have access to the methods in the Behaviour interface,
	 * which are happy(),mad(),sad()
	 * so this can be a Whale or a lemur
	 * @see com.android.animals.Whale
	 * @see com.android.animals.Lemur
	 */
	private T myBehave;
	/**Constructor that takes a object that implements the Behaviour interface*/
	public Bucket(T myBehave){
		this.myBehave=myBehave;
		myBehave.happy();
		myBehave.sad();
		myBehave.mad();
	}
	/**
	 * here myT will be whatever you set T to be when we create a Bucket
	 * @param myT will be a object that implements Behaviour
	 * @param num just a int to show this methd can also take variables without generics
	 */
	public void fill(T myT,int num) {
		System.out.println("bucket fill method ");
		System.out.println("bucket created with a ");
		//this will print out whatever type we have T set as when we create a object
		System.out.println(myT.getClass().getSimpleName());
	}

}
