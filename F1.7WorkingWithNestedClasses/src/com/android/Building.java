package com.android;
/**
 * this is dealing with Anonymous Inner classes which are classes that bound to a particular object and
 * are the object redefining a existing class
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**ordinary top level class which we will re define
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/ygOJwcOQ2yY">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a> */
class Employee{
	int age=34;
	String  name="pat";
	private double weight=2.34;
	/**no args constructor for Employee*/
	Employee(){
		System.out.println("Employee created with no args Constructor");
	}
	/**constructor for Employee that takes an int and a String*/
	Employee(int age,String name){
		this.age=age;
		this.name=name;
		System.out.println("employe create with constructor int String");
	}
	/**earnMoney method of the Employee class*/
	void earnMoney() {
		System.out.println(name+" Employee earning money");
	}
	/**doWork method of the Employee class*/
	void doWork() {
		System.out.println("Employee working");
	}
	/**getWeight method of the Employee class*/
	double getWeight() {
		return weight;
	}
}
/**Building is a top level class and in the constructor contains anonymous class implemeantion for a Employee
 * object called eddie
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/ygOJwcOQ2yY">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>*/
public class Building {
	Employee eddie;
	int size=400;
	//Building myBuilding;
	/**
	 * the syntax for an anonymous inner class is as follows
	 * Employee emp=new Employee(){//this is the body of the class
	 * 	everything, except a constructor can be placed inside these brackets, methods, overriden and overloaded
	 * other variables can all be placed inside the anonymous inner class
	 * }
	 
	 */
	Building(){
		int localInt=6;
		//this local variable is NOT NOW effectively final
		localInt=10;
		System.out.println("Building constructor called");
		//myBuilding=new Building();
		/**
		 * an anonymous inner class is a way to redefine a class where we
		 * can override methods or even declare new methods and variables
		 * the new definition of Employee class will only apply to the object eddie
		 */
		eddie=new Employee() 
		/*
		 * this is an anonymous class implementation eddie the employee
		 * object, which allows us to tailor the object to be specific
		 * to eddie
		 * this is not for all employees, but only for this employee
		 * eddie
		 */		
		{/*
		 * variables and methods first created inside an anonymous inner class
		 * are ONLY AVAILABLE inside the anonymous inner class
		 */
			int newVar=90;//only available inside the curly brackets
			/**
			 * you can't have a constructor in a Anonymous inner class, however
			 * you can have initialisers
			 */
			{
				System.out.println("you can't have constructors in a anonymous "
						+ " inner class, but you can have initialisers");
			}
			/**overriding a method of base Employee class in anonymous class implementation of 
			 * Employee
				 * you can override methods in an anonymous inner class,
				 * here we are overriding the earnMoney() method from
				 * the Employee class
				 */
			@Override
			void earnMoney() {
				System.out.println("this is eddies own EarnMoney method");
				System.out.println("newVar is "+newVar);
				payTax();
				doWork();
			
			}
			/**
			 * this method is unique to the Anonymous implementation of Employee class, so it cannot be
			 * called outside of the class
			 * in this inner class we can access all variables of the outer building class
			 * we can only access local variables if they are final or effectively final
			 */
			void payTax() {
				System.out.println("eddie paying Tax");
				/*
				 * we can access all variables of the outer class
				 * the outer class is buidling so we can access Size 
				 * and eddie
				 */
				System.out.println("size of buidling is "+size);
				/*
				 * we can access local variables as long as they are
				 * effectively final or final
				 * localInt is a LOCAL variable of the Constructor and it
				 * is NOT effectively final, so we can't access it
				 */
			//	System.out.println("localInt is "+localInt);
				/*
				 * we can access all variables of the Employee class
				 */
				System.out.println("name of Employee is "+name);
				System.out.println("age of Employee is "+age);
				/*
				 * the anonymous inner class does not have access to the
				 * private double weight, as you can only access this variable
				 * inside of the Employee class, not the anonymous inner class
				 * an anonymous inner class, does not have access to the
				 * private variables of the Employee class, but eddie the 
				 * Employee DOES HAVE a weight, we just can't access it in
				 * this anonymous class
				 */
			//	System.out.println("weight is "+weight);
				System.out.println("eddie getWeight "+getWeight());
			}
		};//end of Anonymous inner class
		//can only access newVar inside of the Anonymous inner class
		//eddie.newVar;//will not compile
		/*
		 * we can access earnMoney() as this was first defined in the 
		 * original Employee and not the anonymous class
		 */
		eddie.earnMoney();
		/*
		 * do not have access to this method, as this method was first defined
		 * inside the anonymous class
		 */
	//	eddie.payTax();
		/*
		 * this method exists only in the Employee class and is NOT overriden
		 * in the Anonymous class. As long a method first exists in the 
		 * Employee class any Employee, including eddie, can access it
		 */
		eddie.doWork();
	}//end of Building constructor
	/**
	 * this method is used to show the different in results when a "ordinarly" Employee object is sent to
	 * this method and a Anonymous class implementation Employee object is sent to this method
	 * A different earnMoney() method wil be called for each 
	  * To see video tutorial for this section of code
	  * <a href="https://youtu.be/ygOJwcOQ2yY">Video tutorial</a>
	  * For all 177 videos, which cover all the topics in this course go to
	  * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 * @param emp
	 */
	private void live(Employee emp) {
		/*
		 * whatever type of employee object that is sent to this method, will
		 * call the earnMoney() method, all Employee objects, regardless 
		 * whether they are anonymous inner classes, will have a earnMoney()
		 * method
		 * we will create another method, called callAnon, that will send
		 * different Employee object types to it
		 */
		emp.earnMoney();
	}//end of live method
	/*
	 * this method is sending different types of employee to the Live
	 * method
	 */
	void callAnon() {
		System.out.println("*******Buidling class callAnon method");
		System.out.println("sending eddie to live method");
		live(eddie);//eddie anonymous class implementation
		System.out.println("sending a Employee object with no args constructor");
		live(new Employee());//Employee class
		System.out.println("sending a Empmloyee with args constructor");
		live(new Employee(34,"mary"));//Employee class
		System.out.println("sending an employe with its own anon class");
		live(new Employee(45,"Yvonne") {
			//only available to anonymous inner class
			
			void leave() {
				System.out.println(name+" is leaving");
			}
			@Override
			void earnMoney() {
				System.out.println("this employee "+name+" is earning money");
				doWork();
				leave();
			}
		}//end of anonymous inner class
		);//end of calling the live method
		//this is the same as sending an employee with no args constructor
		live(new Employee() {
			
		});
		
	}//end of callAnon
	/**
	 * you can't create an instance of a abstract, you normally can't use
	 * the NEW keyword with an abstract, there is however ONE exception
	 * the following:
	 * Bungalow myBungalow=new Bungalow(){
	 * 		int heatMe(){
	 * 
	 * 		}
	 * 		void lightMe(){
	 *		 }
	 *}
	 *is legal as the abstract methods heatme and lightMe are being implemented in the Anonymous class
	 *implementation 
	  * To see video tutorial for this section of code
	  * <a href="https://youtu.be/ygOJwcOQ2yY">Video tutorial</a>
	  * For all 177 videos, which cover all the topics in this course go to
	  * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 */
	abstract class Bungalow{
		abstract int heatMe();
		abstract void lightMe();
		
	}
	/**
	 * class with anonymous class implementation of the abstract class Bungalow
	  * To see video tutorial for this section of code
	  * <a href="https://youtu.be/ygOJwcOQ2yY">Video tutorial</a>
	  * For all 177 videos, which cover all the topics in this course go to
	  * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 */
	class SemiDetached extends Bungalow{

		@Override
		int heatMe() {
			System.out.println("semiDetached Heatme");
			return 0;
		}

		@Override
		void lightMe() {
			System.out.println("Semi detached LightMe");
			
		}
		
	}
	SemiDetached mySemi=new SemiDetached();
	/**
	 * the only place where you can use the keyword "new" with an abstract 
	 * class is an anonymous class that implements the abstract
	 * methods contained within the abstract Bungalow class
	 * this is an object that implements two Abstract methods
	 */
	Bungalow myBungalow=new Bungalow() {
/**
 * if you are using anonymous class implementation of an abstract class then
 * you HAVE to override the abstract methods contained within that abstract 
 * class. here the abstract class Bungalow contains the abstract methods heatMe()
 * and lightMe(), so we have to override BOTH of these methods
 */
		@Override//overriding the abstract int heatMe method
		int heatMe() {
			System.out.println("Bungalow heatMe method");
			lightMe();
			liveIn();
			return 0;
		}
/**overridding abstract method lightMe method of the abstract class Bungalow*/
		@Override//overrideing the abstract void lightMe method
		void lightMe() {
			System.out.println("Bungalow lightMe method");
			
		}
		/*
		 * method unique to anonymous inner class so only can be called inside
		 * anonymous inner class
		 */
		void liveIn() {
			System.out.println("living in my Bungalow");
		}
		
	};
	/*
	 * this method uses the different sorts of Bungalow we can have
	 * a anonymous class implemeantion of the abstract Bungalow class
	 * a concrete sub class implementation of the super abstract Bungalow
	 * class
	 */
	//inside Building class
	void callBungalow() {
		System.out.println("******callBungalow method");
		//myBungalow an anonymous class implemention of abstract class Bungalow
		myBungalow.heatMe();
		//mySemi is a concrete sub class of the abstract class Bungalow
		mySemi.heatMe();
	}
	/**
	 * inner interfaces, but for our purposes behave same way as a top level
	 * interface
	 * you can't create an interface object, because an interface is a purely
	 * abstract class, so you can't usually use the NEW keyword with a
	 * interface, however you can with an anonymous class implmentation
	 * of an interface, the same way you can of a abstract class
	 * the Anonymous class has to provide a body for 
	 * void agressive() and void passive()
	  * To see video tutorial for this section of code
	  * <a href="https://youtu.be/ygOJwcOQ2yY">Video tutorial</a>
	  * For all 177 videos, which cover all the topics in this course go to
	  * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 */
	//not a function interface
	interface Behaviour{
		void agressive();
		void passive();
	}
	/**
	 * this can be object whose class implements this interface
	 * or it can be anonymous inner class implmentation (same syntax as
	 * abstract classes
	 * you have to provide a body for agressive() and passive()
	 */
	Behaviour myBehave=new Behaviour() {
/**anonymous class implemeantion of the abstract agressive method from the Behviour interface*/
		@Override//this has to override the agressive method in Behaviour interface
		public void agressive() {
			System.out.println("myBehave agressive");
			
		}
/**anonymous class implementation of the abstract passive method from the Behaviour interface*/
		@Override//this has to override the passive method in Behaviour interface
		public void passive() {
			System.out.println("myBehave passive");
			delirious();
			
		}
		//this is its own method
		public void delirious() {
			System.out.println("myBehave delirious");
		}
		
	};
	
	void callBehaviour() {
		/*
		 * this is an object that can only call methods of the Behaviour interface
		 * that are implemented in the anonymous inner class of the myBehave
		 * object
		 */
		myBehave.agressive();
		myBehave.passive();
	}
	/**
	 * a functional Interface is a interface with only ONE abstract method
	 * inside it
	 * this is an annotation and you will get an error if you have more than
	 * ONE abstract method inside it (comment in sad to see error)
	  * To see video tutorial for this section of code
	  * <a href="https://youtu.be/ygOJwcOQ2yY">Video tutorial</a>
	  * For all 177 videos, which cover all the topics in this course go to
	  * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 */
	@FunctionalInterface
	interface Mood{
		void happy();
	//	void sad();
	}//end of Mood interface
	//option 1 to implment the Mood interface
	/**
	 * have a class implement the interface
	  * To see video tutorial for this section of code
	  * <a href="https://youtu.be/ygOJwcOQ2yY">Video tutorial</a>
	  * For all 177 videos, which cover all the topics in this course go to
	  * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 */
	class Zebra implements Mood{

		@Override
		public void happy() {
			System.out.println("Zebra happy method");
			
		}	
	}//end of Zebra class
	/**
	 * Optiion two for implementing the Mood interface
	 * anonymous class implementation of the Mood interface
	 * this can be done with all interfaces
	 */
	Mood moodAnon=new Mood() {
		@Override
		public void happy() {
			System.out.println("anonymous implmentation of mood interface");	
		}	
	};
	/**
	 * option 3 with a functional interface, we can use LAMBDA notation
	 * we are trying to implment the only abstract method in Mood, which is 
	 * this 
	 * void happy();
	 */
	Mood moodLamb=()->{
		System.out.println("using long form lambda notation for happy method");
	};
	/**
	 * if you lambda has only one line of code, you do not have to put the
	 * curly brackets
	 */
	Mood moodLamb2=()->System.out.println("using short form lambda notation "
			+ "for happy method");

	void callMood() {
		moodLamb.happy();
		moodLamb2.happy();
	}
	
	/**
	 * here we see an issue, there is nothing wrong with the code, however
	 * we have not supplied a TYPE, so this means this will be an ArrayList
	 * of Objects. so that means we won't be able to access any of the methods
	 * of these objects, that does not already exist in the object class.
	 * i.e a dog has a walk() method, but we won't be able to access the walk()
	 * method as this will be like this
	 * Object spot=new Dog(), no access to Dog methods
	 */
	List myList=new ArrayList<>();//List of objects
	//here we supply a type, has to be an object, of Integer
	//only have to supply on left hand side, most times  you do not have
	//to supply on right hand side
	List<Integer>intList=new ArrayList<Integer>();
	/**
	 * there is a built in functional interface in java called 
	 * Predicate, which has ONE abstract method called test()
	 * public boolean test(Object t)
	 */
	//a here is an object
	Predicate myPred=(a)->{
		/*
		 * a only has access to methods of the Object class
		 */
		return true;
	};
	/**a here is an Integer, this is the long form lambda*/
	Predicate<Integer>myPred2=(Integer a)->{
		if(a>18)
			return true;
		return false;
	};
//	Predicate<Integer>pred=a->a>10?true:false;
	/**
	 * anonymous inner class implementation of the Predicate interface method
	 * boolean test(Object t)
	 */
	Predicate<Integer>predInt=new Predicate() {
		/*
		 * even though we supplied it wiht a type, anonymous class implementation
		 * does not recognise this object as an Integer, so we have to 
		 * Cast it
		 */
		@Override
		public boolean test(Object t) {
			Integer num=(Integer)t;
			if(num>18)
				return true;
			return false;
		}	
	};
	//a is a STring
	//has a test() method, takes an object, returns a boolean
	/**
	 * THE TYPES GIVEN TO THE LAMBDA CAN BE ANY TYPE YOU WANT
	 * i.e {@code
	 * Predicate<String>
	 * Predicate<Dog>
	 * Predicate<IOException>}
	 */
	Predicate<Integer>pred=a->a>18?true:false;
	//has a test() method, takes two objects (can be same or different), 
	//returns boolean
	BiPredicate<Integer,String>biPred=(a,b)->true;
	/**
	 * has a accept method, that takes an object and return void
	 * here this takes in a number and prints off a double of it
	 */
	Consumer<Integer>consume=(a)->System.out.println(a*2);
	/**
	 * BiConsumer has an accept method, that takes two objects (can be same
	 * type or different) and returns void
	 */
	BiConsumer<Integer,String>biConsume=(a,b)->System.out.println(a+b);
	/**
	 * Function has a apply method, which takes and object and returns an
	 * object (both objects can be the same or different
	 * a is an Integer, return "hello there" a String
	 */
	Function<Integer,String>function=(a)->"hello there";
	/**
	 * BiFunction has a apply method which takes in two objects and returns
	 * one object. here it takes in a Integer and a String, which is a,b
	 * and returns a Double, which is 2.3
	 */
	BiFunction<Integer,String,Double>biFunction=(a,b)->2.3;
	/**
	 * Supplier has one method get which takes in nothing and returns a 
	 * Object. here it returns an list
	 */
	Supplier<List>supplier=()->Arrays.asList(23,45,67);
	/**
	 * UnaryOperator has one method get, which takes in an object and returns
	 * an object, both objects HAVE to be the same type
	 */
	UnaryOperator<Integer>unary=a->a*2;
	/**
	 * BinaryOperator has one method get, which takes in two objects, and returns
	 * one objectg, all objects HAVE to be the same type
	 */
	BinaryOperator<Integer>binary=(a,b)->a*b;
	/**a method to show an example of a functional programming*/
	void callFunctional() {
	//	List<Integer>numbers=Arrays.asList(23,56,89,2,5,1);
		Arrays.asList(23,56,89,2,5,1).stream().map(a->a*2).
		sorted().forEach(System.out::println);
	}
/**sway method of the Building class*/
	void sway() {
		System.out.println("building swaying");
	}

	/**
	 * can't create a anonymous inner class as a instance
	 * variable if you are currently inside that class.
	 * you can of other top level classes
	 */
	Human myHuman=new Human() {
		
	};
	
	
	/*
	 * 
	 */
/*	Apartment myApartment=new Apartment() {
		
	};*/
	
/*	Building myBuilding=new Building() {
		
	};*/
	void callBuildings() {
		
	}

}//end of Building class
