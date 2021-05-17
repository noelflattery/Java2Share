package com.android;
/**
 * class that is used to show examples of bad peek() code, which is a peek() that changed objects of a 
 * stream
 * for video tutorial of this code go to 
 * <a href="https://www.youtube.com/watch?v=UNu8I-eu40Y&list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-&index=60">video Tutorial</a>
 * @see com.android.Examples#ex7()
 * @author NoelF
 */
public class Employee {
	/** age of Employee*/
	private int age;
	/**name of Employee*/
	private String name;
	/**Consturctor that takes a int age and a String name*/
	public Employee(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	/**
	 * getter for the Employee's age
	 * @return age of Employee
	 */
	public int getAge() {
		return age;
	}
	/**
	 * setter for the Employee's age
	 * @param age sets the age of Employee
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * getter for Employees name
	 * @return name of Employee
	 */
	public String getName() {
		return name;
	}
	/**
	 * setter for name
	 * @param name sets name of Employee
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * overridden toString method that prints out age and name of Employee
	 * @return a string that contains the age and name
	 */
	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + "]";
	}
	
	

}
