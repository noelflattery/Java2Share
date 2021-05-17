package com.android;

import java.util.function.Predicate;
/**contains Main method that we use to call methods in Examples to show different aspects of 
 * predicate and Functional interfaces
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/8cFj6gYDndk">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 * @see com.android.Examples
 * @see com.android.Examples#ex1()
 * @see com.android.Examples#ex2()
 *
 */
public class Main {
	public static void main(String[]args) {
		//Examples.ex1();
		Examples.ex2();
	/*	
		Predicate pred=s->true;
		pred=(Object s)->{
			String mys=(String)s;
			if(mys.length()>10)
				return true;
			return false;
		};
		
		System.out.println(pred.test("hello"));;*/
	}

}
