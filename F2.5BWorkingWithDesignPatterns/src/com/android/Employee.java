package com.android;
/**
 * this class implements the cloneable interface which allows us to easily make copies of an object
 * by creating an employee
 * Employee emp1=new Employee(78.9,3459901)
 * and create a new employee by going
 * Employee emp2=emp1.clone()
 * this creates a new employee emp2 which has the same weight and pps number but is a DIFFERENT 
 * employee
 * if we did not implement the Cloneable interface we would not get a compilation error we would get
 * a CloneNotSupportedException
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/v62ACKQMTls">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author Owner
 *
 */
public class Employee implements Cloneable{
	/**
	 * this overrides the Clonable method of the Object class and we implement the clonable interface
	 * to tell java to create a copy of the object when we use this method. This throws the checked exception
	 * CloneNotSupportedException, so when we call this method it HAS to be try/catch block on the method
	 * calling this method has to have a throws exception itself.
	 * This method calls the clone method of the super Object class, which basicaly copies all the variables
	 * of employee to a new Employee object. You end up with a NEW employee with the same variables
	 */
	@Override
	protected Employee clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Employee) super.clone();
	}
	/**weight of Employee*/
	double weight;
	/**pps of Employee*/
	int pps;
	/**Constructor that takes a double and an int*/
	Employee(double weight,int pps){
		this.weight=weight;
		this.pps=pps;
	//	Employee emp1=this.clone();
	}
	/**toString method of Employee which prins our weight and pps number*/
	@Override
	public String toString() {
		return "Employee weight=" + weight + ", pps=" + pps;
	}
/*	Employee shallowCopy() {
		Object newEmployee=this.clone();
		Employee emp1=(Employee) newEmployee;
	//	return (Employee) this.clone();
	}*/
	
	
	
	

}
