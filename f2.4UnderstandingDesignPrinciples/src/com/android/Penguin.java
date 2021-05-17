package com.android;
/** this class deals with the design principle of Object Compositoin
 * this is a class that is made purely out of a other objects, so this class
 * if made purely out of OBJECT COMPOSITION
 * each Penguin object is made up of arrays of other objects, specifically Flippers and WebbedFeet
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
public class Penguin {
/**this is an array of Flippers objects*/
	private Flippers myFlippers[];//a penguin has two flippers
	/**this is an array of webbedFeet objects*/
	private WebbedFeet myWebbedFeet[];//a penguin has two webbedFeet
	/**Constructor for the Penguin class that takes not arguments and provides values for
	 * the myFlippers array and the myWebbedFeet array
	 */
	Penguin(){
		//an array of two flippers
		myFlippers=new Flippers[]{new Flippers(),new Flippers()};
		myWebbedFeet=new WebbedFeet[] {new WebbedFeet(),new WebbedFeet()};
				
	}
}//end of Penguin class
/**This class creates Filppers which is one of the class of objects that make up a Penguin
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>*/
class Flippers{
/**method of the Flippers class*/	
	public void flap() {
		System.out.println("flapping my flippers to swim");
	}
}//end of Flipper class
/**this class creates WebbedFeet which is one of the class of objects that make up a Penguin
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>*/
class WebbedFeet{
	/**method of the WebbedFeet*/
	public void kick() {
		System.out.println("kicking feet to swim");
	}
}//end of WebbedFeet class
