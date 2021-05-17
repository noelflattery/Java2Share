package com.android;

import java.time.LocalDate;

/**
 * we are going to use a inner static nested class to create a Human object, this advantage
 * of this is that you can make your Human constructor private and this can be accessed inside
 * the inner static class
 * Human is a Mutable class, and we present a scenario where the Human had originally only three variables of
 * age, name and weight. We then created a constructor with only these three variables asked for. At a later date
 * another programmer added the variables height and dob, which are not in any 
 * constructor. We do not need to add these to a constructor, we simply use setters in the inner static builder
 * class
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/2LTVxGL9XOI">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
public class Human {//Human is a MUTABLE class
	/**orginal variable of Human class which is the age of the Human*/
	private int age;
	/**original variable of Human class which is the name of the Human*/
	private String name;
	/**original variable of Human class which is the weight of the Human*/
	private double weight;
	/**
	 * we add these variables at a later date, so all we need to add in is setters in the
	 * HumanBuilder class for both of these variables.
	 */
	private double height;
	/**date of birth of Human, no constructor includes this variable, a setter in the Builder class can be used 
	 * to give this a value
	 */
	private LocalDate dob;
	/**this will count the amount of Humans created*/
	static int humanCounter=0;
	/**
	 * we can choose to use the this constructor or not as this is a MUTABLE class
	 * if it was IMMUTABLE, we would HAVE TO use this constructor.
	 * We can also make this constructor private, so it cannot be accessed outside of the Human class. However
	 * the inner static HumanBuilder class CAN access this constructor so it can use this constructor to create
	 * Human objects.
	 * this constructor only gives values to the original three variables of age, name and weight and also increments
	 * the humanCounter variable
	 */
	private Human(int age,String name,double weight) {
		this.age=age;
		this.name=name;
		this.weight=weight;
		humanCounter++;
	}
	/**our inner static builder HumanBuilder class uses this constructor to create an initial Human object, again
	 * an inner static class has no problem wiht accessing a private constructor of it's outer class. This
	 * Constructor takes no arguments and increments the HumanCounter variable by one
	 */
	private Human() {
		System.out.println("Human no args constructor called");
		humanCounter++;
	}
	/**this is our overriden toString method that prints out all the details of each Human*/
	@Override
	public String toString() {
		return "age is "+age+" name is "+name+" weight is "+weight+" height is "+height+" "
				+ "date of birth is "+dob;
	}
	
	public void run() {
		
	}
	/**
	 * this is a nested class of the Human class (inner static classes are also called 
	 * nested classes)
	 * like the other builder classes this has setter methods for each of the variables of the Human class
	 * which can give values to each one of the variables of the Human class. each one of these setters return
	 * an object of the HumanBuilder with final builder method that returns the Human object who's variables
	 * have been set by the various setters in the HumanBuilder class
	 * To see video tutorial for this section of code
	 * <a href="https://youtu.be/2LTVxGL9XOI">Video tutorial</a>
	 * For all 177 videos, which cover all the topics in this course go to
	 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 */
	static class HumanBuilder{
		/**
		 * this is a Builder for the Human class, Human class is MUTABLE, which means the first
		 * thing we do is create a private instance of the Human class
		 * this will be the object that will be returned by the method build() and we
		 * will have setters for all of the variables of the Human class
		 */
		private Human myHuman=new Human();
		static int statInt=0;
		int id;
		/**setter for age in the Human class, this returns a HumanBuilder object which means this can be 
		 * chained with other setters of this class*/
		public HumanBuilder setAge( int age) {
			/*
			 * id is a instance variable of hte HumanBuilder class, and we are inside a 
			 * instance method so we CAN access the variable id
			 */
			id=3;
			//we can also access statics of the HumanBuilder class in an instance method
			statInt++;
			//this int age is a LOCAL variable
			/*
			 * if i pass in a minus number, this will give age a new value of 1
			 */
			if(age<=0)
				age=1;
			/*
			 * cannot access age directly as this is a static nested class, so we first create
			 * a Human object, then we access the age of that Human
			 */
			myHuman.age=age;
			return this;
		}
		/**setter for name of Human, this returns a HumanBuilder object which means this can be chained with other
		 * setters of this class
		 * @param name
		 * @return
		 */
		public HumanBuilder setName(String name) {
			/*
			 * if i pass in a null string, this will assign the value "joan Doe" to the 
			 * name of the Human myHuman
			 */
			if(name==null)
				name="joan doe";
			myHuman.name=name;
			return this;
		}
		/**setter for weight of Human, this returns a HumanBuilder object which means this can be chained with other
		 * setters of this class
		 * @param weight
		 * @return
		 */
		public HumanBuilder setWeight(double weight) {
			/*
			 * if weight is a minus or 0 then will assign the value 0.1 to the weight of 
			 * the Human myHumaan
			 */
			if(weight<=0)
				weight=0.1;
			myHuman.weight=weight;
			return this;
		}
		/**setter for height of Human,, this returns a HumanBuilder object which means this can be chained with other
		 * setters of this class
		 * @param height
		 * @return
		 * */
		public HumanBuilder setHeight(double height) {
			// I don't want a zero or minus height, so if minus or zero sent to method
			//will change to 1.0
			if(height<=0)
				height=1.0;
			myHuman.height=height;
			return this;
		}
		/**setter for the dob(date of birth), again returns a HumanBuilder object
		 * @param dob
		 * @return
		 */
		public HumanBuilder setDob(LocalDate dob) {
			myHuman.dob=dob;
			return this;
		}
		
		static void statMethod() {
			//id=9;
		}
		/**
		 * This method returns the private myHuman variable which the various setters have given value to
		 * it's variables
		 * as this is an inner static class it can only access static variables of it's outer class 
		 * directly, humanCounter is a static variable of the outer class which can be accessed inside
		 * the inner static class
		 * also can't access outer non static methods directly, we can only access those method through a 
		 * Human object
		 * statics do NOT belong to an individual object, but to a class and many objects of a class share these
		 * variables
		 * @return
		 */
		public Human build() {
			/*
			 * this is a static variable of the outer Human class, which we can access
			 * directly. As nested static classes can access all static variables of the 
			 * outer class directly, the outer class here is Human, so we can access all
			 * of the static variables and methods of the Human class
			 * humanCounter is a static variable of the Human class, so we can access it
			 * directly here
			 */
			System.out.println("amount of Humans created is "+humanCounter);
			/*
			 * there is no LOCAL variable age
			 * there is no instance variable of the HumanBuilder() class called age
			 * it next looks in the outer class for a STATIC variable called age, there is
			 * NO static variable in the outer Human  class called age, there is only an 
			 * instance variable called age, which this static class has no access too
			 */
			//System.out.println(age);
			//but we could acess the age of a Human through a Human object like so
			System.out.println("age of this human is "+myHuman.age);
			return myHuman;
		}
		
	}//end of nested HumanBuilder class
	
}//end of Human class
