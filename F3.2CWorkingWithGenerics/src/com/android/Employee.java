package com.android;
/**used with {@link com.android.Examples#ex7()} and {@link com.android.Bank} class
 * we create our Employee with a type, e.g Animal, that means that type V will be
 * Animal anywhere inside the Employee
 * @param<V> generic type that will be given when we create an Employee, this type has no restrictions and can be any object type
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
public class Employee<V> {
	/**Variable of Type V whose type will be determined when we create an Employee*/
	V myV;
	/**
	 * constructor that takes one variable of type T that will be determined when we create a Employee object
	 * @param myV variable of type V that will be given a type when we create an Employee
	 */
	public Employee(V myV) {
		this.myV=myV;
	}
/**
 * this method can only take a bank with a type that is of type V or a sub class of 
 * V. e.g we have set the type V to be a Animal, that means this can only take a bank
 * that was created with a type of Animal,Dog,Poodle or Cat {@code
 * Bank<Animal>myBank;
 * Bank<Dog>myBank;
 * Bank<Poodle>myBank;
 * Bank<Cat>myBank;}
 * if we create a bank, with any other type, we cannot use the pay method with this
 * type of bank.
 * @see com.android.Bank
 */
	public void pay(Bank<? extends V>myBank) {
		System.out.println("pay method");
		System.out.println(myBank.myT.getClass().getSimpleName());
		
	}
	/**
	 * this method can only take a bank that was created with a type of V or a superclass
	 * of V. ie if type is set to Animal, we can only use a bank created with Animal or
	 * a Object
	 */
	public void work(Bank<? super V>myBank) {
		System.out.println("work method");
	//	System.out.println();
	}
	/**
	 * This method takes an object of type T as a parameter and returns an object of type T
	 * @param <T> will be the type supplied when we create a Bank object
	 * @param myT will be a variable of whatever type we supply when creating a Bank object
	 */
	public<T> void deposit(T myT) {
		T t;
	}
}
/**
 * used with {@link com.android.Examples#ex7()}
 * @author NoelF
 *Class with a generic type T, which will be given when we create a Bank object
 * @param <T> generic type that will be given when we create an Employee, this type has no restrictions and can be any object type
 * @see com.android.Examples#ex7()
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
class Bank<T>{
	/**variable of type T that will be given a type when we create a Bank object*/
	T myT;
	/**constructor that takes a one parameter of type T
	 * @param myT is a parameter of type T whose type will be determined when we create a Bank object
	 */
	public Bank(T myT){
		this.myT=myT;
	}
}
