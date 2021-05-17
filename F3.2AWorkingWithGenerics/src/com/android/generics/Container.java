package com.android.generics;
/**This class has three Generic types
 * a class can have as many generics as you want, here this class has three
 * generics T, U, V
 * these can be any object type you want, they can be three the same or three different or whatever object you want
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
public class Container <T,U,V>{
	/**
	 * as these three data types have no limits on them (i.e extends) it means they
	 * can be any objects, so they only have access to methods first defined in the 
	 * Object class
	 */
	T myT;
	/**generic type to be defined when creating a container object*/
	U myU;
	/**a generic type to be defined when creating a container object*/
	V myV;
	/**constructor that takes three variables, which are three generic types that we define when we create a container
	 * object
	 * @param myT
	 * @param myU
	 * @param myV
	 */
	public Container(T myT,U myU,V myV){
		this.myT=myT;
		this.myU=myU;
		this.myV=myV;
		System.out.println("constructor that takes three variables");
		System.out.println("myT is a "+myT.getClass().getSimpleName()+myT);
		
		System.out.println("myU is a "+myU.getClass().getSimpleName()+myU);
		System.out.println("myV is a "+myV.getClass().getSimpleName()+myV);
	}
	/**constructor that takes no variables*/
	public Container(){
		System.out.println("constructor that takes no variables");
	//	System.out.println(myT.getClass().getSimpleName());
	}
	/**
	 * this is a method that has a return type of T
	 * and takes two variables of type U and V
	 * @param u
	 * @param v
	 * @return
	 */
	public T returnT(U u,V v) {
		return myT;
	}

}
