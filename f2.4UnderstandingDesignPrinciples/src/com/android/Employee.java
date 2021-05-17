package com.android;
/**
 * Super class of Accountant and Astronaut and used to illustrate the IS-A RELATIONSHIP
 * Employee, like every other class in Java, extends Object
 * so a Employee object IS-A object
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
public class Employee {

}
/**this class extends Employee and Employee, like every other class in java, extends Object
 * If we create an Accountant called Andy
 * Andy IS-A Accountant, Andy IS-A Employee, Andy is a Object
 * class uses the deafult constructor
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
class Accountant extends Employee{
	
}
/**
 * Any class that implements a interface is said to have a IS-A relationship
 * so the Astronaut class implements this intefaces so any Astronaut IS-A Movement
 * class uses default constructor
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @see com.android.Astronaut
 * @author NoelF
 *
 */
interface Movement{
	/**Abstract method of the movement interface*/
	void walk();
	/**abstact method of the movement interface*/
	void fly();
}
/**
 * This class extends Employee, and Employee extends Object
 * This class also Implements the Movement inteface
 * So we create an Astronaut called Ann
 * Ann IS-A Accountant, Ann IS-A Employee, Ann IS-A object, Ann IS-A Movement
 * Astronaut uses default constructor
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
class Astronaut extends Employee implements Movement{
/**overriden walk method of the Movement interface*/
	@Override
	public void walk() {
		System.out.println("Astronaut walking");
		
	}
/**overriden fly method of the Movement interface*/
	@Override
	public void fly() {
		System.out.println("Astronaut flying");
		
	}
	
}
