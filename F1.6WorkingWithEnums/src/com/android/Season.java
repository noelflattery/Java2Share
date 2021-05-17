package com.android;

import java.io.Serializable;

/**
 * enums are a special type of class
 * enums are your own data types, so here we are going to create a 
 * data typ0e that has only four values
 * WINTER,SPRING,SUMMER,AUTUMN
 * Every enum value is implicitly static final and public
 * SPRING is ordinal() 0
 * SUMMER is ordinal()1
 * AUTUMN is ordinal()2
 * WINTER is ordinal()3
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/Dlr4DzeR0EE">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
public enum Season {
	/**
	 * SPRING is ordinal() 0
	 */
	SPRING,
	/**summer is ordinal()1*/
	SUMMER,
	/**Autumn is ordinal()2*/
	AUTUMN,
	/**Winter is ordinal()3*/
	WINTER
}

/*
 * enums can't extend or be extended
 * enums dont' allow inheritance
 * this will not compile
 */
/*//will not compile
enum noEnun extends Season{
	
}*/
//enums CAN implement an interface
/*
 * can't create a LOCAL enum (create an enun inside a method), you can
 * only create an enum inside a top level class or you can create a
 * enum inside a inner static class but not inside a normal inner class
*/
/**
 * this enum implements an interface called serializable (which will be covered in chapter 8)
 * this is just to show that a enum CAN implement an interface
 * Serializable is a interface which allows our classes to become
 * jar files (zipped format basically), this will be covered in details
 * in the last chapter when we come to databases
 * As enum is a class it also has a constructor, if no constructor is defined the default 
 * constructor is called. we have two constructors in this class. A no arguement constructor and a 
 * constructor that takes a String
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/Dlr4DzeR0EE">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
enum Season2 implements Serializable{
	//these are our four alloweable enum types
	//these these four call the no args constructor
	/**winter calls the no args constructor*/
	WINTER(),//call no args constructor
	/**calls the constructor that takes a string*/
	SPRING("low"),
	/**calls the constructor that takes a string*/
	SUMMER("high"),//call no args constructor
	/**calls the args constructor*/
	AUTUMN;//
	/**
	 * enums can have variables
	 * these variables can only be accessed inside of this enum
	 * this is the amount low, medium or high and is the the level of expected visitors (in real life coding
	 * situations this would be a enum as well)
	 */
	private String expectedVisitors;//this will be low, medium or high
	/**the average temperature for the season*/
	private double avgTemp;
	/**this is protected variable to show this can ony be accessed in same package or in derived class*/
	protected int num=5;
	public double dayLight;
	/**blank constructor called by WINTER AND SUMMER*/
	Season2(){
		expectedVisitors="low";
		avgTemp=23.4;
		dayLight=8.9;
		System.out.println(this);
		System.out.println("season2 enum blank constructor called");
	}
	/**constructor that is called by SPRING AND SUMMER and takes a String expectedVisitors*/
	Season2(String expectedVisitors){
		this.expectedVisitors=expectedVisitors;
		System.out.println(this);
		System.out.println("season2 enum constructor that takes a string called");
	}	
}
/**
 * enum that has 7 types, the 7 days of the week and has two constructors, one that takes no
 * arguments and another that takes a string
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/Dlr4DzeR0EE">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 */
enum Days{
	/**
	 * monday uses no args constructor
	 */
	MON(),
	/**uses no args constructor*/
	TUE,
	/**this is anonymous class implementation and it is overriding signIn method of the Days enum
	 * it also has it's own methd, payDay() which can only be called by this Days.WED
	 * if you type has a body {}, you can override the methods that
	 * exist in the enum main body, for instance 
	 * signIN
	 */
	WED(){
		/**
		 * this is overriding the signin method from the main body
		 * of the Days enum
		 */
		@Override
		public void signIn() {
			System.out.println("signIn for wednesday only");
		}
		/**
		 * only the wednesday type that has the payday method
		 */
		public void payDay() {
			System.out.println("this is the day i get paid");
		}
	},
	/**uses no args constructor*/
	THUR,
	/**uses no args constructor*/
	FRI,
	/**
	 *uses  the constructor that takes a string
	 */
	SAT("high"),
	/**uses constructor that takes a String*/
	SUN("low"){
		
	};
	/**amount of expected visitors for the season, will be low, medium or high*/
	private String expectedVisitors;//this will be low, medium or high
	/**average temperature for the season*/
	private double avgTemp;
	/**blank constructor for Days enum */
	Days(){
		expectedVisitors="medium";
		avgTemp=17.8;
		System.out.println(this);
		System.out.println("blank constructor for enum days called");
	}
	/**constructor that takes a string expectedVistors for Days enum*/
	Days(String expectedVisitors){
		this.expectedVisitors=expectedVisitors;
		System.out.println(this);
		System.out.println("constructor with a string for enum days called "
				+ " others word, the weekend");
	}
	/**
	 * all days of the week can call this method
	 * only WED overrides this method, all other days of the week
	 * uses this exact method when calling signIn
	 */
	public void signIn() {
		System.out.println(this+" general sign in method");
	}
	
}
/**enum consisting of months of the year 
 *  if you enum has an abstract method in it, each one of your enum
	 * types HAS to have a body, to override the abstract method in
	 * here we have a abstract method in the Months enum, with the 
	 * method signature
	 * abstract void absmethod();
	 * each one of the months, has to have a body, as we have an abstract
	 * method in the enum, and each type HAS TO override that abstract
	 * method
	  * To see video tutorial for this section of code
	  * <a href="https://youtu.be/Dlr4DzeR0EE">Video tutorial</a>
	  * For all 177 videos, which cover all the topics in this course go to
	  * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>*/
enum Months{
	/**enum type
	 * has to override abstract method abmethod in its body
	 */
	JAN(){
		/**overridden abstract method*/
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls blank constructor
		
	},
	/**enum type
	 * has to override abstract method abmethod in its body
	 */
	FEB(){
		/**overridden abstract method*/
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls blank constructor
		
	},
	/**enum type
	 * has to override abstract method abmethod in its body
	 */
	MAR(){
		/**overridden abstract method*/
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls blank constructor
		
	},
	/**enum type
	 * has to override abstract method abmethod in its body
	 */
	APR(12.4){
		/**overridden abstract method*/
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls constructor that takes a double
		
	},
	/**enum type
	 * has to override abstract method abmethod in its body
	 * and calls the constructor that takes a double
	 */
	MAY(19.5){
		/**overridden abstract method*/
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls constructor that takes a double
		
	},
	/**enum type
	 * has to override abstract method abmethod in its body
	 * and calls the constructor that takes a double
	 */
	JUN(21.5){
		/**overridden abstract method*/
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls constructor that takes a double
		
	},JUL(){
		/**overridden abstract method*/
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls blank constructor
		
	},
	/**enum type
	 * has to override abstract method abmethod in its body
	 * calls no args constructor
	 */
	AUG(){
		/**overridden abstract method*/
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls blank constructor
		
	},
	/**enum type
	 * has to override abstract method abmethod in its body
	 * calls no args constructor
	 */
	SEPT(){
		/**overridden abstract method*/
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls blank constructor
		
	},
	/**enum type
	 * has to override abstract method abmethod in its body
	 * and calls the constructor that takes a double
	 */
	OCT(9.8){
		/**overridden abstract method*/
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls constructor that takes a double
		
	},
	/**enum type
	 * has to override abstract method abmethod in its body
	 * and calls the constructor that takes a double
	 */
	NOV(7.6){
		/**overridden abstract method*/
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls constructor that takes a double
		
	},
	/**enum type
	 * has to override abstract method abmethod in its body
	 * and calls the constructor that takes a double
	 */
	DEC(1.2){
		/**overridden abstract method*/
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls constructor that takes a double
		/**enum type DEC has it's own method printMe, all other types DO not override this method*/
		@Override
		void printMe() {
			System.out.println("yahoo christmas");
		}
		
	};
	/**expected visitors for a season, will be low, medium or high*/
	private String expectedVisitors;//this will be low, medium or high
	/**average temperature for a season*/
	private double avgTemp;
	private double dayLight;
	/**no args constructor*/
	Months(){
		System.out.println("blank months constructor called");
		System.out.println(this);
	}
	/**constructor that takes a double as a argument*/
	Months(double avgTemp){
		System.out.println("constructor that takes a double avgTemp called");
		System.out.println(this);
	}
	/**
	 * this HAS TO BE overridden in each one of the enum types, so you
	 * have to have 12 absMethod(). each type HAS TO A BODY {}
	 */
	abstract void absMethod();
	/** a concrete method available to all months, same for every month*?
	void sunShining() {
		System.out.println("sunShining method available to all enum types");
	}
	/*
	 * all the enum month types, has a printMe method, however
	 * Decemeber decides to override this method
	 */
	void printMe() {
		System.out.println("expected visitors level is "+expectedVisitors);
	}
	/**all months will have this method and this implementation*/
	void sunShining() {
		System.out.println("the sun is shining");
	}
	
}
/**
 * interface to demonstrate how an enum implements an inteface
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/Dlr4DzeR0EE">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
interface Movement{
	/**abstract method of the Movement interface*/
	void run();
	/**abstract method of the Movement interface*/
	void walk();
}
/**
 * this is an enum that implements the movement interface
 *  these methods can be implemented either inside each one of the
	 * enum types or in greater enum body. however they have to be
	 * implemented in at least ONE of those places, but they can be 
	 * implmented in both, see walk() in mammal and main enum body
	 * and run() in reptile and main enum body.
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/Dlr4DzeR0EE">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 */
enum AnimalTypes implements Movement{
/**overrides the Walk method from the Movement interface and overrides the Fly() method from
 * the enum main body. it takes it's implementation ffor run from the main enum body
 */
	MAMMAL(){
		/**overrides the walk method from movement*/
		@Override
		public void walk() {
			System.out.println("mammal walk method");
		}
/**overrides the fly method from the main enum body*/
		@Override
		void fly() {
			// TODO Auto-generated method stub		
		}
	},
	/**overrides the run method from the movement interface and overrides the fly() method from the 
	 * enum main body. it takes implemeantion for walk from the enum main body
	 */
	REPTILE(){
		/**overrides the run method from movement*/
		@Override
		public void run() {
			System.out.println("reptile run method");
		}
		/**overrides the fly method from the main enum body*/
		@Override
		void fly() {
			// TODO Auto-generated method stub
			
		}
	},
	/**
	 * does not override run or walk() method so takes its implementation for these methods from the 
	 * enum main body
	 */
	AVIAN {
		/**overrides the fly method from the main enum body*/
		@Override
		void fly() {
			// TODO Auto-generated method stub
			
		}
	};
	/**
	 *this is the run method from the Movement interface being overriden in the main enum body
	 * if each one of your types has a run and a walk method you would
	 * not need the below run() and walk() method. 
	 * and if you did not have any overridden methods in any of the 
	 * types above, you would have to have the below
	 */
	@Override
	public void run() {
		System.out.println("general run method for AnimalTypes");	
	}
	/**same rule for walk as there is for run*/
	@Override
	public void walk() {
		System.out.println("general walk method for AnimalTypes");	
	}
	/**this is an abstract method in the main enum body
	 * if you have an abstract method in your enum, you have to 
	 * implement it in each one of the enum values. So this has to be
	 * implemented in MAMMAL,REPTILE and AVIAN
	 */
	abstract void fly();
	/*
	 * this will not compile as can't override in the same scope
	 * or can't override in same class (you CAN override in an inner 
	 * class)
	 */
/*	@Override
	void fly() {
		
	}*/
	
}



