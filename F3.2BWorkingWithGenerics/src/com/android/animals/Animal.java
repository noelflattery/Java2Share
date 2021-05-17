package com.android.animals;
/**super class of Cow, Elephant and Zebra
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>*/
public class Animal {
	/**weight variable of Animal class*/
	public double weight;
	/**height variable of Animal class*/
	public double height;
	/**eat method of Animal class*/
	public void eat() {
		System.out.println("Animal eating");
	}
	/**sleep method of Animal class*/
	public void sleep() {
		System.out.println("Animal sleeping");
	}
	/**stampede method of Animal class*/
	public static void stampede() {
		System.out.println("Animals stampeding");
	}

}
