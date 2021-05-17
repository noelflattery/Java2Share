package com.android;
/**contains Main method that we use to call methods in Examples to show different Design Principles
 * A DESIGN PRINCIPLE
 * is an established idea or best practices that facilitates the software 
 * design process. 
 * we deal with 5 main ones
 * INVARIANTS
 * IS-A RELATIONSHIP
 * HAS-A REALATIONSHIP
 * OBJECT COMPOSITION
 * JAVABEAN
 * @author noelf
 * An invariant is a property of truth that is maintained even after the data
 * is being modified.
 * i.e every human that is born has an age greater than zero, same goes for
 * weight, height
 * every  human that is born, has a  name, which in programming terms is a
 * non null String
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @see com.android.Examples
 * @see com.android.Examples#ex1()
 * @see com.android.Examples#ex2()
 * @see com.android.Examples#ex3()
 * @see com.android.Examples#ex4()
 * @see com.android.Examples#ex5()
 */
public class Main {
/**main method we use to call each of the static methods in examples that deal with different Design priniciples*/
	public static void main(String[] args) {
		Examples.ex1();
		System.out.println(Math.random());

	}

}
