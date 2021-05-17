package com.android;
/**
 * a static class inside a class is a 
 * NESTED CLASS
 * all other types of classes within a class are 
 * INNER CLASSES
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/ygOJwcOQ2yY">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
public class Doctor {
	/**age of Doctor*/
	int age=45;
	/**name of Doctor*/
	String name;
	static int statNum=0;
	
	/**No args constructor of Doctor class*/
	Doctor(){
		System.out.println("blank Doctor constructor called");
	}
	/**
	 * you have to create an instance of the Pay static nested class to 
	 * access the members of the static class
	 * you can access all of the members (regardless if they are private)
	 * if you are in the outer class, by first creating a Object of that
	 * nested static class
	 */
	Pay myPay=new Pay();
	/**Doctor constructor that takes a int and a String*/
	Doctor(int age,String name){
		this.name=name;
		this.age=age;
		/*
		 * can't access any of the methods or variables of the nested 
		 * class directly from it's outer class, because its static
		 */
		/*
		System.out.println(weekly);
		System.out.println(payId);
		payTax();*/
		System.out.println(myPay.weekly);
		//can access private in outer class
		System.out.println("prsi "+myPay.prsi);
		myPay.payTax();
		//accessing a static method in a NON static way
		myPay.payPrsi();
		
		/*
		 * you can access static members of a nested static class by just
		 * using the class name followed by the static member
		 * this is accessing static methods in a static way
		 */
		Pay.payPrsi();//payPrsi is a static method of the nested Pay class
		
		System.out.println("accessing nested static payId "+Pay.payId);
		
	}
	//NESTED CLASS, inner static class
	/**nested inner class Pay
	 * Static inner classes can only access static variables of the outer
	 * class directly, it cannot access the outer class instance variables
	 * directly
	  * To see video tutorial for this section of code
	  * <a href="https://youtu.be/ygOJwcOQ2yY">Video tutorial</a>
	  * For all 177 videos, which cover all the topics in this course go to
	  * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 */
	static class Pay{
		double weekly=4567.90;
		static String payId="3445678A";
		private double prsi=23.4;
		//blank pay class constructor
		Pay(){
			System.out.println("static pay class constructor called");
			//accessing static variables of the outer class
			System.out.println("accessing statNum "+statNum);
			/*
			 * can't access instance variables of the outer class because
			 * this is a static class and it does not belong to any 
			 * individual object, but belongs to the class as a whole
			 */
		//	System.out.println("age of doctor is "+age);
			/*
			 * can access it's own variables
			 */
			System.out.println("weekly is "+weekly);
			System.out.println(payId);
		}
		/**method to show rules about static methods
		 * the rules about static methods only accessing static variables of
		 * its own class directly and instance methods being able to access
		 * both static and non statics of it's own class still apply to 
		 * static classes
		 */
		void payTax() {
			/*
			 * If you want to access intance variables/methods of the outer 
			 * Doctor class you have to first create a Doctor object
			 */
			Doctor dr=new Doctor();
			System.out.println("age of doctor is "+dr.age);
		}
		static void payPrsi() {
			System.out.println("static payPrsi method");
		}
	}//end of static inner Pay class

}//end of Doctor class
