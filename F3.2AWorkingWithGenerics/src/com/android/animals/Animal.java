package com.android.animals;
/**super class Elephant, Cow and Zebra
 * @see @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>*/
public class Animal {
	/**weight of Animal*/
	public double weight;
	/**height of Animal*/
	public double height;
	/**eat() method of the Animal class*/
	public void eat() {
		System.out.println("Animal eating");
	}
	/**sleep() method of the Animal class*/
	public void sleep() {
		System.out.println("Animal sleeping");
	}
	/**stampede method of the Animal class, this is static so you cannot override it*/
	public static void stampede() {
		System.out.println("Animals stampeding");
	}

}
