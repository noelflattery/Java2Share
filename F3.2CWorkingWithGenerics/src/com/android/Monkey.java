package com.android;
/**
 * Monkey class that has a Generic that can only be a class of obejct that implements the Glider Interface. Only two classes implement this interface,
 * Goose and Hanglider, so that means that type can only be a Goose or Hanglider, or a subclass of these classes. 
 * @param <T> this will be type supplied when creating a Monkey, this type can only be a class that implements the Glider interface. We only have
 * two classes that implement this interface, Goose and Hanglider, so type T can only be a Goose or a Hanglider
 * @author NoelF
 *@see com.android.Goose
 *@see com.android.Hanglider
 *@see com.android.Glider
 *@see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
public class Monkey<T extends Glider>{
	/**
	 * type that will be supplied when creating a Monkey, type T extends Glider, and only Goose and Hanglider implement the Glider interface, so this
	 * type can only be a Goose or Hanglider
	 */
	T myT;
	/**
	 * Constructor that takes a parameter of type T. Inside this constructor there are calls to the fly() and glide() methods of the Glider
	 * interface, to demonstrate that this type implements the Glider interface
	 * @param myT type that will be supplied when creating a Monkey, type T extends Glider, and only Goose and Hanglider implement the Glider interface,
	 * so this type can only be a Goose or Hanglider
	 */
	public Monkey(T myT){
		this.myT=myT;
		myT.fly();
		myT.glide();
	}

}
