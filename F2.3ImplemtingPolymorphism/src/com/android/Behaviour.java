package com.android;
/**
 * Behaviour interface with two abstract methods and implemented by {@link com.android.Human}, {@link com.android.Animal}and {@link com.android.Dog}class
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/y5yyze96L0A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
public interface Behaviour {
	/**abstract method sad and implementing concrete class has to provide a body for this method*/
	void sad();
	/**abstract method mad and implementing concrete class has to provide a body for this method*/
	void mad();

}
