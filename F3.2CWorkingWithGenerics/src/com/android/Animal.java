package com.android;
/**
 * class to create Animals use in {@link com.android.Examples#ex1()} and {@link com.android.Examples#ex2()} and 
 * {@link com.android.Examples#ex6()}. This is the superclass of Dog, all subclasses of Dog and Cat
 * @author NoelF
 * @see com.android.Examples
 *@see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
public class Animal {
	/**age of Animal*/
	int age;
	/**prints out a simple message
	 * @return the String {@code This is an Animal"}
	 */
	@Override
	public String toString() {
		System.out.println();
		return "This is an Animal";
		
	}
	/**Move method of the animal class that is overidden in the Dog class
	 */
	public void move() {
		System.out.println("Animal moving");
	}

}
/**
 * sub class of Animal
 * @author NoelF
 *@see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
class Dog extends Animal{
	/**age cannot be overidden as it's a final variable*/
	final public int age=0;
	/**simple toString method that prints out {@code "this is a Dog"}
	 */
	@Override
	public String toString() {
		//age=age+15;
		return "this is a dog";
	}
	/**overridden move method */
	public void move() {
		System.out.println("Dog moving");
	}
	
}
/**sub class of Dog 
 * @author NoelF
 *@see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
class Poodle extends Dog{
	/**toString method of the Poodle class that prints out {@code "this is a poodle"}
	 */
	@Override
	public String toString() {
		return "this is a poodle";
	}
}
/**sub class of Animal
 * @author NoelF
 *@see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
class Cat extends Animal{
	/**toString method of the Cat class that prints out {@code "this is a Cat"}*/
	@Override
	public String toString() {
		return "this is a Cat";
	}
}
