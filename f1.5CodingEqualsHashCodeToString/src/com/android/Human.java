package com.android;

import java.time.LocalDate;
/**
	 * Human class that has a Overridden hascode and equals method and is the superclass
	 * of Employee
	 * To see video tutorial for this section of code
	 * <a href="https://youtu.be/DUtmq4UqNGs">Video tutorial</a>
	 * For all 177 videos, which cover all the topics in this course go to
	 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 */
public class Human {
	/**
	 * id to identify a human 
	 */
	int id;
	/**name of Human*/
	String name;
//	static int counter=0;
	/**constructor that takes a int age and a String name*/
	Human(int age,String name){
		this.id=id;
//		id=++counter;
		this.name=name;
	}
	/**constructor that takes no arguments*/
	Human(){
		
	}
	/**
	 * overridden hashCode method of the Human class, that uses all of the variables
	 * of human to produce a hash, which is a number
	 * @return a number created using the name, age and id (id will be 0 for all humans)
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/**
	 * overriden equals method of the Human class that uses all of the variables of a
	 * Human to determine if two humans are equal. if same name, age and id two humans will said to be equals, all other
	 * circumstances will said to be not equal.
	 * @param obj the object the human calling this method is comparing itself too
	 * @return return true if same name,age and id. return false in all other circumstances
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Human))
			return false;
		Human other = (Human) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
/**
 * subclass of Employee and also has its own overriden equals and hashCode method, if this class
 * had not hashCode or equals method, this class would use the equals and hashCode method of the 
 * super Human class
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/DUtmq4UqNGs">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
class Employee extends Human{
	/**weight of Employee*/
	double weight;
	/**date of birth of the Employee*/
	LocalDate dob;
	/**enum type for Occupation, these are the only type of Employee an Employee can be*/
	enum Occupation{
		DOCTOR,NURSE,SURGEON,CONSULTANT,ORDERLY
	}
	/**Employee will be a Doctor,Nurse, Surgeon, consultant or orderly*/
	Occupation occupation;
	/**Constructor that takes a int id, a String name, a double weight and a Occupation occupation*/
	Employee(int id,String name,double weight,Occupation occupation){
		super(id,name);
		this.weight=weight;
		//born 30 years ago from todays date
		dob=LocalDate.now().minusYears(30);
		this.occupation=occupation;
	}
	/**
	 * overriden hashCode method that uses all variables of the Employee class to create number
	 * @return returns a number calculated from id and name, which calls the super class hashCode, and date of birth and
	 * occupation
	 */
	@Override
	public int hashCode() {
		final int prime=31;
		//this produces a hashCode from the id and name
		int result=super.hashCode();
		
		result=prime*result+((dob==null)?0:dob.hashCode());
		result=prime*result+((occupation==null)?0:occupation.hashCode());
		long temp;
		temp=Double.doubleToLongBits(weight);
		result=prime*result+(int)(temp^(temp>>>32));
		return result;
	}
	/**
	 * equals() method for employee class that uses the hashCode to determine if two objects 
	 * are equal
	 * @param obj the object the employee calling this method will be comparing itself with
	 * @return will return true if both hashcodes are the same, false in all other circumstances
	 */
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(getClass()!=obj.getClass())
			return false;
		Employee other=(Employee)obj;
		/*
		 * if(this.hashCode()!=other.hashCode())
			return false;
		return true;
		 */
		/*
		 * the hashCode for Employee is produced from the id,name,
		 * weight,occupation and date of birth for each Employee. So
		 * Any employee that has the same id,name,weight,occupation,dob
		 * will produce the same hashcode. so this can be used to 
		 * determine if two employees have all the same variables
		 */
		return this.hashCode()==other.hashCode();
		
	}
}
