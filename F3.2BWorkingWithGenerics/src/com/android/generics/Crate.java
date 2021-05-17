package com.android.generics;
/**
 * T is a generic, so when we are creating a crate, we can can supply a type for T, if we
 * don't supply a type, then T becomes an Object
 * Crate<String>myCrate;
 * that means that type T, becomes a String
 * a Generic can ONLY be an object, not a primitive
 * T can be ANY OBJECT of ANY TYPE
 */
public class Crate <T>{
/**
 * we can create an object of type T, this object will be whatever generic type we create
 * our object with.
 * i.e we create a crate with an Elephant, type T will be an Elephant
 * the default value for this is null
 */
	private T contents;
	/*
	 * if i allow this constructor, you can create a Crate object, withoug giving a value
	 * to T contents, so this object would then be null and attempt to do anything with
	 * contents will cause a nullpointer Exception
	 */
//	public Crate() {
		/*
		 * if you create a Crate object with this constructor and you attempt to call
		 * any method using the variable contents, you will get  a nullpointer exception.
		 * becuase we have NOT set the value of T, so it will be given a default value of null
		 */
	//	System.out.println(contents);
	//	System.out.println(contents.getClass());//will result in NullPointerException
	//	System.out.println("create created with a "+contents.getClass().getSimpleName());
//	}
	/**
	 * to create a Crate object using this constructor we have to send an object of whatever
	 * type we said type T will be.
	 */
	public Crate(T contents){
		this.contents=contents;
		System.out.println("crate created with a "+contents.getClass().getSimpleName());
	}
	/*
	 * we can't go as T can be ANY TYPE OF object, which may or may not have a constructor that
	 * takes no arguements
	 */
//	private T contents=new T();
	/**
	 * you can use the Generic type in methods and constructors this is going to return
	 * an elephant
	 */
	public void returnMe(T myT) {
		contents=myT;
		/*
		 * this calls the toString method of whatever class we have said our generic is
		 * i.e we create Crate<Elephant>crateElephant;
		 * contents calls the toString method of the Elphants, which prints out 
		 * "nellie the Elephant is my name"
		 */
		System.out.println(contents.toString());
		/**
		 * if  your generic can be any object, that means you then only have access to methods
		 * that are common to ALL OBJECTS, which are methods of the Object class
		 * so this type of generic, 
		 * public class Crate<T>{}
		 * only has access to methods of the Object class (toSTring,hashCode,equals, etc)
		 */
		//myT.eat();//only available to Animals and they're subclasses
		
	//	return contents;
	}
}
