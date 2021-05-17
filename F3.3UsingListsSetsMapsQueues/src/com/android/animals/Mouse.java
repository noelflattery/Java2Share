package com.android.animals;
/**
 * sub class of Animal that implements Comparabe
 * @author Owner
 *
 */
public class Mouse extends Animal implements Comparable<Mouse>{
	/** name of mouse, hides the name variable from the Animal super class*/
	private String name;
	/**age of mouse, hides the age variable from the Animal super class*/
	private Integer age;
	/**id of mouse, hides the id variable from the Animal super class*/
	private int id;
	/**counter for mouse class, the counter for the Animal class will still run as the counter for Animal is
	 * incremented in the Animal class constructors, so this counter keeps a count of only the MICE CREATED
	 */
	static int counter=0;
	/**
	 * Constructor that takes a String and a int
	 * @param name is the name of the mouse
	 * @param age is the age of hte mouse
	 */
	public Mouse(String name,Integer age){
		this.name=name;
		this.age=age;
		id=counter++;
	}
	/**implements the comparable interface and uses the metric of the names in alphbetica order, i.e
	 * andy the mouse come before bert the mouse
	 * @param mickey the mouse we are comparing to the mouse calling the method
	 * @return returns a 0 if both Mice are said to be the same name, 1 if mouse's name calling the
	 * method comes before the mouse sent to the method, returns -1 if the mouse's name calling the method comes
	 * after the mouse sent to the method (how this is determined is up to the programmer)
	 */
	@Override
	public int compareTo(Mouse mickey) {
		// TODO Auto-generated method stub
		return name.compareTo(mickey.name);//will list mice by name alphabetically
	//	return age.compareTo(mickey.age);//will list mice by age in ascending order 1,2,3
	}
	/**
	 * overridden toString method
	 * @return displays the name and age of each mouse
	 */
	@Override
	public String toString() {
		return "Mouse [name=" + name + ", age=" + age + "]";
	}
	
	
	

}
