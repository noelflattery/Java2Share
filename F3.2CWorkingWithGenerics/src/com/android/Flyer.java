package com.android;
/**this is the super interface that {@link com.android.Glider} inherits from. This interface is a Functional interface
 * as it has only one abstract method, void fly
 * @author NoelF
 * @see com.android.Examples
 *@see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
@FunctionalInterface
public interface Flyer {
	/**abstract method of hte fuctional interface flyer*/
	void fly();
}
/**this inherits from the functional interface Flyer, but  Glider is NOT a functional interface as it inherites the void fly() method, so
 * this interface actually contains two abstract methods
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 * @author NoelF
 */
//@FunctionalInterface
interface Glider extends Flyer{
	/**second abstract method of Glider, as Glider also inherits {@code void fly()} from Flyer
	 */
	void glide();
}
/**
 * class that implements the Flyer interface
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 * @author NoelF
 */
class Plane implements Flyer{
/**
 * this method overrides the {@code void fly() }method of the Flyer interface
 */
	@Override
	public void fly() {
		System.out.println("plane flying");
		
	}
	/**
	 * overridden toString method that simply prints out the String {@code "this is a plane"}
	 * @return returns a string that contains {@code "this is a plane"}
	 */
	@Override
	public String toString() {
		return "this is a plane";
	}
	
}
/**
 * Class that implements the Glider interface, so it will have to override both {@code void fly()} and {@code void glide()} methods
 * @author NoelF
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
class Goose implements Glider{
	/**
	 * this method overrides the {@code void fly() }method of the Glider interface, which itself inherits this method from the Flyer 
	 * interface
	 */
	@Override
	public void fly() {
		System.out.println("goose flying");
		
	}
/**
 * this method overrides the {@code void glide()} method of the Glider interface
 */
	@Override
	public void glide() {
		System.out.println("goose gliding");
		
	}
	/**
	 * Overrides the toString method and prints out {@code "this is a goose"}
	 * @return returns a stirng that contains "this is a goose"
	 */
	@Override
	public String toString() {
		return "this is a goose";
	}
	
}
/**
 * Class that implements the Glider interface, so it will have to override both {@code void fly()} and {@code void glide()} methods
 * @author NoelF
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
class Hanglider implements Glider{
	/**
	 * this method overrides the {@code void fly() }method of the Glider interface, which itself inherits this method from the Flyer 
	 * interface
	 */
	@Override
	public void fly() {
		System.out.println("hanglider flying");
		
	}
	/**
	 * this method overrides the {@code void glide()} method of the Glider interface
	 */
	@Override
	public void glide() {
		System.out.println("hanglider gliding");
		
	}
	/**
	 * Overrides the toString method and prints out {@code "this is a hanglider"}
	 * @return returns a stirng that contains "this is a goose"
	 */	
	@Override
	public String toString() {
		return "this is a hanglider";
	}
	
}
