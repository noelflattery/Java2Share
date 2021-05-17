package com.android;

import java.util.function.Predicate;
/**
 * we first come accross a functional interface called Predicate
 * all installations of java come with a prepackaged interface call
		 * predicate, which has one abstract method inside it, called
		 * test. As this interface only has one abstract method, this means
		 * that Predicate is a FUNCTIONAL INTERFACE and can be used with
		 * lambdas
		 * {@code public interface Predicate<T>{
		  		public boolean test(T t);
		  }				}
		 * predicate can be implemented by using a anonymous inner class, however as it only has ONE
		 * interface inside it, it is called a FUNCTIONAL INTERFACE. this function interface can be implemented
		 * by LAMBDAS
		 * this is long form lambda, and on the right side we are overriding the boolean test(T t) method
		 * {@code Predicate<Integer>predInt=(Integer a)->{//takes in an int
		  		System.out.println("long form lambda");
		  		return a>18;//retruns a boolean
		 * }			}
		 * short form lambda
		 *from the{@code generic<Double>} we can deduce that variable (n) is a double, and the double n>10.0 will
		 *return either true or false {@code
		 * Predicate<Double>predDoub=(n)->n>10.0			}
		 * 
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/8cFj6gYDndk">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 *see com.android.Examples
 */
public class Examples {
	/**This method covers the following topics
	 * Implementation of the functional interface using anonymous class
	 * also using long form lambda notation
	 * and short form lambda notation
	 */
	static void ex1() {
		
		//with this predicate the test method becomes
		//publc boolean test(Integer t)
		Predicate<Integer>myPred;
		//public boolean test(String t)
		Predicate<String>strPred;
		/*
		 * if you do not supply it with a type, t becomes a Object
		 * and the test method becomes
		 */
		//public boolean test(Object t)
		Predicate objPred;
		/*
		 * Anonymous class implementation of Predicate interface
		 */
		Predicate<Integer>intPred=new Predicate() {
			/*
			 * the problem here is that arg0 is a object class reference
			 * to an Integer object. so if we want this object to behave like
			 * an Integer (i.e multiplication, division etc) we have to 
			 * cast this object to be  an Integer
			 */
			@Override
			public boolean test(Object arg0) {
				Integer myInt=(Integer)arg0;
				if(myInt>=18)
					return true;
				return false;
			}//end of test method	
		};//end of anonymous inner class
		
		System.out.println("greater or equal to 18 "+intPred.test(19));
		System.out.println("greater or equal to 18 "+intPred.test(17));
		/*
		 * we will replace the above anonymous class with a lambda, as 
		 * Predicate is a Functional interface and has only ONE abstract 
		 * method inside it. only intefaces with oone abstract method inside
		 * them can be functional interfaces
		 */
		//long form lambda
		Predicate<Integer>intPred2=(Integer a)->{
			/*
			 * if more than one statement in a lambda, you HAVE to have 
			 * curly braces
			 */
			System.out.println("long form lambda implementation of Test method");
			/*
			 * if number is greater or equal to 18 return true, otherwise
			 * return false
			 */
			if(a>=18) {
				System.out.println("you are an adult");
				return true;
			}
			System.out.println("you are a child");
			return false;
		};
		
		System.out.println(intPred2.test(19));
		//medium form lambda
		/*
		 * when you give a type on the left hand side, you do not have to
		 * give a type on the right hand side, as it knows that "a" is an
		 * Integer
		 * if you don't put in a type on the left or right hand side, the 
		 * data type of A is assumed to be an object
		 */
		Predicate<Integer>intPred3=(a)->{
			if(a>=18)
				return true;
			return false;
		};
		intPred3.test(19);
		System.out.println("short form lambda expression");
		/*
		 * if you only have one line of code, in your lambda body, you do not
		 * have to have curly braces on the right hand side
		 */
		Predicate<Integer>shortPred=a->a>=18?true:false;
	}
	/**
	 * we cover more about predicates and show how predicates can be sent and used with methods like
	 * any other variable
	 * we show implementation of the user defined  functional interface Behaviour and Move Interface using
	 * anonymous class and lambdas
	 */
	static void ex2() {
		System.out.println("creating our two Animals");
		Animal rabbit=new Animal("rabbit",true,false);//can hop but not swim
		Animal fish=new Animal("fish",false,true);//can swim but not hop
		/*
		 * calling the static print method that takes a Animal and a 
		 * Predicate<Animal> object
		 * this method takes an Animal object and a predicate, which
		 * is a method that implements test(Object obj) of the predicate
		 * interface
		 * a is an Animal
		 * a.canHop() returns either true or false
		 */
		Animal.print(rabbit, a->a.canHop());//will print "rabbit can hop"
		Animal.print(rabbit,
						(Animal a)->{
							return a.canSwim();
									}
						);//will print "rabbit cannot swim"
		//you can have a predicate as a variable
		Predicate<Animal>hopPred=a->a.canHop();//this is a predicate variable
		Predicate<Animal>swimPred=a->a.canSwim();//this is a predicate variable
		System.out.println("fish predicate Tests");
		Animal.print(fish, hopPred);
		Animal.print(fish, swimPred);
		
		//redefining hopPred can only take an Animal and return a boolean
		hopPred=a->a.canSwim();//will compile
		hopPred=(Animal a)->{//will compile
			System.out.println("more complex hopPred lambda");
			return true;
		};
		/*
		 * this will not compile compile as hopPred was created with the
		 * generic type of Animal, so the parameter has to be an Animal, if 
		 * you say what the type is.
		 * if you put in the type name, and it's NOT a animal, this will 
		 * not compile
		 */
		//hopPred=(String s)->true;
		/*
		 * you can declare a predicate without a data type, but you will have
		 * issues with this. If you do not define a type on the left hand
		 * side, "obj" will be a object of type Object and will have only access
		 * to methods of the Object class, for instanece the equals method.
		 */
		Predicate objPred=obj->obj.equals(rabbit);//obj is an object
		/*
		 * you have no access to any methods of the Animal class, as this
		 * was created with no generic type, so is given the type of 
		 * object. 
		 * if you do not give a type to the predicate lambda upon creation,
		 * you are then implementing the test method with the following
		 * method signature
		 * public boolean test(Object obj)
		 * so that means that object obj, can only be a object reference, so
		 * it only has access to the methods of the object class. It does
		 * not have any access to the methods of the Animal class.
		 * by giving our predicate a data type, it will know what class "obj"
		 * is, which in our casea we want it to be an ANIMAL and then would
		 * be able to call canHop() and canSwim() methods of the Animal class
		 */
		//objPred=obj->obj.canHop();
		//this also does NOT compile for the same reason as above
	/*	objPred=Obj->{
			obj.canHop();
			return true;
		};*/
		//this predicate lambda has access to all methods of Animal class
		Predicate<Animal>animalPred;
		animalPred=(a)->{
			a.canHop();
			a.canSwim();
			return true;
		};
		/*
		 * Behaviour is a functional interface
		 * and has One ABSTRACT method
		 * void sad()
		 * this has no generic in it, as this method does return
		 * or take any variable
		 */
		Behaviour myBehave=()->{
			System.out.println("behaviour sad lambda");
		};
		
		Move<Integer>intMove=a->a*2;
		System.out.println(intMove.run(12));
		intMove.run(12);
		Move<String>strMove=s->s+" is our String";
		;
		System.out.println(strMove.run("noel"));
		
		Behaviour behaveHuman=new Human();
		behaveHuman.happy();
		Move moveHuman=new Human();
		moveHuman.run("hello");
		/*
		 * so you can have an interface reference to three things
		 * an interface reference to an anonymous class implmentation
		 * of the interface, this works for all types of interfaces
		 * an interface reference to a lamba immplenming the interface
		 * (this only works for FUNCTIONAL INTERFACES)
		 * an interface reference to an anonymous class implmenting that
		 * interface, this works for all types of interface
		 */
	}

}
