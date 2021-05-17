package com.android.generics;

import com.android.interfaces.Life;
/**
 * Life is an interface and type T has to implement the interface Life
 */
public class Pan <T extends Life>{
	/**
	 * this can be a class that implements the LIfe interface
	 * this can be a anonymous class that implements the LIfe interface
	 * or as Life is a functional interface, this can be a lambda
	 */
	private T myLife;
	/**
	 * constructor that takes a object that implements the Interface Life
	 * @param myLife
	 */
	public Pan(T myLife){
		this.myLife=myLife;
		myLife.grow();
	}

}
