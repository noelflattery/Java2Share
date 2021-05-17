package com.android;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CREATING IMMUTABLE OBJECTS
 * create objects that can be shared across multiple classes but do not want 
 * their values modified. 
 * You can just copy the object and send it to a method, however this creates
 * a large overhead as you have duplicates of objects every time a method is
 * called. Also it's not thread safe.
 * five rules to creating an immutable class
 * use a constructor to set all properties of the object
 * mark all of the instance variables private and final
 * don't define any setter methods
 * don't allow refereced mutlable object to be modified or accessed directly
 * prevent methods from being overriden
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/v62ACKQMTls">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author noelf
 *
 */
public class Main {
	public static void main(String[]args) {
	//	Examples.ex1();
		Examples.ex2();

		
		
		
		
		
	}

}
