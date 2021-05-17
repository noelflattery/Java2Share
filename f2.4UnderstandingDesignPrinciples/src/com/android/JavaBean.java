package com.android;
/**
 * JavaBean is a standard for creating classes that store data and adhere to
 * the principles of Encapsulation.
 * the rules are as follows:
 * properties are private
 * getter for properties and getters for non boolean properties begin with the
 * word "get"
 * getter for boolean properties may begin with "is" or "get"
 * setter methods begin with set
 * the method name for a getter or setter must have a prefix of set/get/is followed
 * by the first letter of the property in uppercase and rest of the property name
 * in lowercase
 * This is just a standard that is used widely in sofware development, eclipse
 * does most of this naturally for you.
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
public class JavaBean {
/**private attributes playing boolean, adhering to JavaBean Design Principle*/
	private boolean playing;
/**private int attribute id, ahdering to JavaBean Design Principle*/
	private int id;
/**private double attribute weight, adhering to JavaBean Design Principle*/
	private double weight;
/**private Boolean Wrapper attribute running, adhering to the JavaBean Design Principle
 * this is a Boolean WRAPER OBJECT, so the correct getter is getRunning()*/
	private Boolean running;
	/** getting the value of the private attribute playing
	 * playing is a boolean so we can use get or is
	 * @return
	 */
	public boolean isPlaying() {
		return playing;
	}
	/**
	 * getting the value of the private double variable weight
	 * @return
	 */
	public double getWeight() {
		return weight;
	}
	/**getting the value of the private Boolean wrapper OBJECT running
	 * this is a Boolean WRAPPER OBJECT, so it is GET, not is
	 * @return
	 */
	public boolean getRunning() {
		return running;
	}
	/**public setter for the private int atribute id*/
	public void setId(int id) {
		this.id=id;	}
}
