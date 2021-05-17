package com.android.generics;

import com.android.interfaces.Life;
/**
 * Life is an interface and type T has to implement the interface Life, Pan is also a Functional interface
 * which means you can use a lambda to implement the interface
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
public class Pan <T extends Life>{
	/**
	 * this can be a class that implements the LIfe interface
	 * this can be a anonymous class that implements the LIfe interface
	 * or as Life is a functional interface, this can be a lambda
	 */
	private T myLife;
	/**constructor that takes a object of type T that implements the Life interface*/
	public Pan(T myLife){
		this.myLife=myLife;
		myLife.grow();
	}

}
