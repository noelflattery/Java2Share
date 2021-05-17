package com.android;

public class Examples {
/**this deals with Invariants 
 * An invariant is a property of truth that is maintained even after the data
 * is being modified.
 * i.e every human that is born has an age greater than zero, same goes for
 * weight, height
 * every  human that is born, has a  name, which in programming terms is a
 * non null Strin
 * see {@link com.android.Human}class for Invariant (every Human has to have a name that will NOT be null, every Human has
* to have an age greater than zero). we also should NOT be able to change the name back to null or the age to a number less than 0
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/IaMvmosbdo8">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 */
	static void ex1() {
	
		
		try {
			//valid arguments will print out  "our Human is created"
			Human harry=new Human("harry",5);
			System.out.println("our Human is created");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//invalid String
			Human helen=new Human(null,34);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			//invalid String
			Human harriet=new Human(" ",34);
			System.out.println("human with spaces created");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			//invalid string
			Human harriet=new Human("",34);
			System.out.println("human with no length string created");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//invalid int
			Human harriet=new Human("harriet",-1);
			System.out.println("human with minus age created");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			//only gets to invalid string
			Human harriet=new Human("",-1);
			System.out.println("human with both values invalid");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**This deals with the IS-A relationship
		 * see employee file for all these classes
		 * The object eddie is an employee
		 * the accountant andy is a Employee and a Accounant and an object
		 * the Astronaut annie is a Astronaut and a Employee and an object
		 * and when a class
		 * implements an interface, it is said also to be a "IS-A" relationship
		 * so Astronaut IS-A Movement()
		 */
	static void ex2() {
		System.out.println("IS-A relationship");
		
		Employee eddie=new Employee();
		Accountant andy=new Accountant();
		Astronaut annie=new Astronaut();
		annie.fly();
		annie.walk();
	}
	/**
		 * this deals with HAS-A relationship
		 * A fish has scales
		 * a bird has feathers
		 * a Horse has a tail
		 * a Howler monkey has a tail
		 * a object has a particular property or value
		 * if a super class object has a public or protected attribute or if the super class is in the
		 * same package and this attribute is package level access then
		 * the sub class also has this attribute
		 * Bird and Horse are both in the Primate file
		 */
	static void ex3() {
		
		//Bird is in primate File, all Birds have feathers, which is a HAS-A
		//relationship
		Bird tweety=new Bird();
		//all Horses have tails
		Shetland shergar=new Shetland();
		
		Howler howard=new Howler(false);
	}
		/** This deals with Object Composition
		 * Object composition is the process of constructing classes using 
		 * references to other clases
		 * see Penguin class
		 * if can be an alternative to inheritance, or it can compliment 
		 * inheritnace,and both techniques do have they're place in 
		 * propr software development
		 */
	static void ex4() {
		System.out.println("Object composition");

		Penguin percy=new Penguin();
	}
	/**
	 * JavaBean is the DesignPrincple of creating properly encapsulated classes, 
	 * this can be seen in operation in the JavaBean class
	 */
	static void ex5() {
		JavaBean myJavaBean=new JavaBean();
	}

}
