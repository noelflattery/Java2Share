package com.android.machines;

import com.android.animals.Animal;
import com.android.animals.Elephant;
import com.android.interfaces.Behaviour;
import com.android.interfaces.Manners;

/**
 * this is a class that has two generic types
 * T will be a Animal or one of its subclasses of Elephant, Zebra, Cow
 * V will be either a Whale or a Lemur
 * this class has has LOCAL generic types, which means there is a method talk() that has it's own
 * Generics, that apply ONLY to this method
 */
public class Android<T extends Animal, V extends Behaviour> {
/**constructor that takes no arguments*/
	public Android() {
		
	}
/**walk() method that takes a argument of type V which will be given a type when creating a Anroid
 * type V will apply to the whole class*/
	public T walk(V myV) {
		System.out.println("walk method called");
		myV.happy();
		myV.sad();
		myV.mad();
		return (T) new Animal();
	}
	/** this defines a type S with is LOCAL to the talk method, and it not available outside of the Talk() method
	 * this generic type ONLY applies to this method
	 * this can take ANY OBJECT, this is effectively an object reference
	 * if we had a method 
	 * {@code void talk(Object myObj)}
	 * our code would NOT COMPILE as this would conflict with the below method as they are both methods that have
	 * the same method signatture as both can take OBJECTS
	 */
	public<S> void talk(S myS){
		System.out.println("android talking");
		System.out.println("myS is a "+myS.getClass().getSimpleName());
	}
	/*
	 * java can't tell the difference between this method and the above method, as both
	 * can take ANY OBJECT
	 */
//	public void talk(Object myObj) {
	//	return null;
//	}
	/**
	 * can use generic types of a class within an instance method, this is using types T and V that were
	 * set when creating an object of the Android class
	 * can't use any of the generic types that were used when creating this class, that being T and V. However
	 * you can use LOCAL generics with a static method
	 * @param myT method parameter of class generic type T
	 * @param myV method parameter of class generic type V
	 */
	public void method1(T myT,V myV) {
		
	}
	/*
	 * can't use generic types of a class with a static method as you can call 
	 * statics without creating a member of the class and generic types are only 
	 * assigned when you create an object of the class
	 */
/*	static void method2(T myT) {//will NOT COMPILE FOR ABOVE REASONS
		
	}*/
	/**
	 * this is a static method that uses LOCAL generic types, of S, V and U. these generics have NO RELATIONSHIP
	 * with the generics used in the class declaration
	 *  {@code class Android<T extends Animal, V extends Behaviour>}
	 *  a static cannot use the above generics as those generics are tied to a particular instance of the class and 
	 *  statics apply to a class not to a object of a class
	 * @param <S> local generic to this method can be a Animal or subclass of Animal
	 * @param <V> local to this generic can be any object that implements Behaviour interface
	 * @param <U> local to this generic can be any object that implements Manners interface
	 * @param myS method parameter variable of local generic type S
	 * @param myV method parameter variable of local generic type V
	 * @param myU method parameter variable of local generic type U
	 */
	public static<S extends Animal,V extends Behaviour,U extends Manners>void method2
	(S myS,V myV,U myU){
		System.out.println("myS is "+myS.getClass().getSimpleName());
		myS.eat();
		myS.sleep();
		myS.stampede();
		/*
		 * can't do thsi as myS could be a sub class of Animal and you can't have a 
		 * sub class reference to a super class object
		 */
		//myS=new Animal();//will not compile
		
		myS=(S)new Animal();
		System.out.println("after casting");
		myS.eat();
		myS.sleep();
		System.out.println(myS.getClass().getSimpleName());
		myS=(S)new Elephant();
		
	}
	/*
	public static <S extends Animal>S returnS(int num){
		Animal myAnimal=new Animal();
		return (S) myAnimal;
	}*/

}
