package com.android.animals;
/**
 * super class of Dog
 * @author Owner
 *
 */
public class Animal {
	/**keeps count of animals created*/
	static int animalCount=0;
	/**age of Animal*/
	int age;
	/**name of Animal*/
	String name;
	/**id to identify Animal*/
	int id;
	/**Constructor of Animal class that takes a int age and a String name and increments our counter by
	 * 1 and creates a new Animal inside of it */
	public Animal(int age,String name){
		this.age=age;
		this.name=name;
		animalCount++;
		id=animalCount;
		Animal andy=new Animal();
		
	}
	/**constructor of Animal class that takes no arguements*/
	public Animal(){
		animalCount++;
		id=animalCount;
	}
	/**toString method of the animal class 
@return a string that prints out the name and age
	 * */
	@Override
	public String toString() {
		return "name is "+name+" age is "+age;
	}
	
	

}
