package com.android.animals;
/**simple class Zebra which is a sub class of Animal
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>*/
public class Zebra extends Animal{
/**variable of the Zebra class which is available to this class and subclasses of this class only*/	
	String name;
	
	/**constructor for Zebra that takes no variables*/
	public Zebra(){
		System.out.println("Zebra created");
	}
	/**Overriding eat method in Animal class*/
	@Override 
	public void eat() {
		System.out.println("Zebra eating");
	}
	/**Overriding sleep method in Animal class*/
	@Override
	public void sleep() {
		System.out.println("Zebra sleeping");
	}

}
