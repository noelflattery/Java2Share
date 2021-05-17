package com.android;
/**
 * Human class will be used to show the Invariant Design Principle
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @see com.android.Examples#ex1()
 * @author NoelF
 *
 */
public class Human {
	/**the name of a Human and we are  going to ensure every human has a non null name
	 */
	private String name;
	/**
	 * the age of a Human and every Human has a age greater than 0
	 */
	private int age;
	/**Constructor that taks a String and a int
	 * constructors call the setName() method with the string name sent to the constructor, which ensures
	 * that the name is not null and is not just a blank string
	 * Constructor calls the setAge() method with the int age sent to the constructor, which ensures the age 
	 * is greater than 0
	 * or we could assign a default name or a default age, and require that this name and age be replaced at a 
	 * later stage in the code
	 * @param name is the name of the Human
	 * @param age is the age of the Human
	 */
	Human(String name,int age){
		this.setName(name);
		this.setAge(age);
	}
	/**Setter for name that ensures that name is not null
	 * we can add more complex rules in the setters without effecting other users of the class
	 * as long as we don't change the method signature of the setters it will not effect other users of the 
	 * code
	 * @param name will be used to set the name of a Human
	 */
	private void setName(String name) {
		if(name==null||name.trim().length()==0) {
			//this a runtimeException so it will compile without a try/catch block
			throw new IllegalArgumentException("a name is required for our Human");
		//	this.name="Jane Doe";
		}
		else
			this.name=name;
	}
	/**
	 * setter for age that ensures age will be greater than 0 
	 * @param age will be used to set the age of a Human
	 */
	private void setAge(int age) {
		if(age<0) {
			throw new IllegalArgumentException("age cannot be a negative number,"
					+ "choose zer0 if younger than 1 year");
		//	this.age=0;
			}
		else
			this.age=age;
	}
	/**
	 * getter for the name variable
	 * @return the name of the Human
	 */
	public String getName() {
		return name;
	}
	/**
	 * getter for the age variable
	 * @return the age of the Human
	 */
	public int getAge() {
		return age;
	}
	
	
	
	

}
