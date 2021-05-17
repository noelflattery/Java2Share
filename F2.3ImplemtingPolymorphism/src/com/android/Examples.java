package com.android;

public class Examples {
	/**
	 * this will show polymorphic methods that can take any object that implements a certain interface
	 * it can be a object of a class that implements the interface
	 * a anonymous class implementation of an interface
	 * if it's a functional interface it can be a lambda short or long form
	 * also method shows how to provide a type for a generic in an interface
	 * To see video tutorial for this section of code
	 * <a href="https://youtu.be/y5yyze96L0A">Video tutorial</a>
	 * For all 177 videos, which cover all the topics in this course go to
	 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 * @see com.android.Animal
	 * @see com.android.Human
	 * @see com.android.Dog
	 * @see com.android.Behaviour
	 * @see com.android.Movement
	 * @see com.android.Mammal
	 */
	static void ex1() {
		/*
		 * this polymorphic method takes any object with a Behaviour
		 * reference. This can be an object of a class that implements
		 * the interface or An anonymous inner class
		 */
		System.out.println("animal sent to takeAny");
		Animal.takeAny(new Animal());
		System.out.println("human sent to takeAny");
		Animal.takeAny(new Human());
		System.out.println("Dog sent to takeAny");
		Animal.takeAny(new Dog());
		System.out.println("Anonymous inner class sent to takeAny");
		Animal.takeAny(new Behaviour() {
			/*
			 * we are overriding the sad and mad() methods of the
			 * Behaviour interface inside this anonymous inner
			 * class
			 */
			@Override
			public void sad() {
				System.out.println("anonymous sad method");
			}
			@Override
			public void mad() {
				System.out.println("anonymous mad method");	
			}		
		}
		);//end of takeAny method call
		/*
		 * you do not have to provide the generic type here
		 * as Movement has the following class definition
		 * class Mammal implements Movement<Integer>
		 * this means that type t, inside the method
		 * void walk(Integer t), t of of type Integer
		 */
		Movement moveMammal=new Mammal();
		moveMammal.walk(12);
		//we don't have to put in the generics here, but if we do
		//we have to make sure we are using the right
		//i.e <Integer> works for Cow and Mammal
		Movement<Integer>moveCow=new Cow();
		moveCow.walk(10);
		Movement<Dog>moveEmployee=new Employee();
		moveEmployee.walk(new Dog());
		/*
		Movement<Object>moveFish=new Fish();
		moveFish.walk(12);
		*/
		/*
		 * this will not compile as the generic type is set inside
		 * Employee to be a DOG, and if you say the generic type is
		 * anything else, you will get an error
		 * if you leave out the <Integer> this will compile
		 */
		//Movement<Integer>moveIntEmp=new Employee();//will not compile
		
		//moveCow.walk(23);
		//Mammal.takeMovement(new Mammal(), 45);
		
		Movement<Integer>moveLambda=(t)->{
			System.out.println("walk method in lambda called");
			System.out.println("t is of type "+t.getClass().getSimpleName());
			t=t*t*4;
			System.out.println("t is "+t);
		};
		moveLambda.walk(12);
		System.out.println("calling Mammal.takeMove() method");
		Mammal.takeMovement(moveCow, 12);
		Mammal.takeMovement(moveMammal, 100);
		Mammal.takeMovement(moveEmployee, new Dog());
		/*
		 * if you sent anything other than what the method is expecting
		 * i.e a Movement reference to a cow object and a Integer instead
		 * we have a Movement reference to a cow object and a Double,
		 * this will NOT compile
		 */
		//Mammal.takeMovement(moveCow, 12.2);
		//Mammal.takeMovement(moveMammal, "hello");
		//Mammal.takeMovement(moveEmployee, new Animal());
		
		Mammal.takeMovement(moveLambda, 20);
		
	}
	/**
	 * more on using generics with interfaces and classes and also the effect references has on
	 * what an object can and cannot access
	 * @see com.android.Train
	 * @see com.android.Transport
	 * @see com.android.Boat
	 * @see com.android.Human
	 * @see com.android.Needs
	 * @see com.android.Car
	 */
	static void ex2() {
		Aeroplane aero1=new Aeroplane();
		Train<Integer>train1=new Train<>();
		Train<String>train2=new Train<>();
		System.out.println("interface reference to a class object");
		Transport<Integer>transCar=new Car();
		/*
		 * only methods of the interface Transport AND object class are
		 * available to this object
		 */
		transCar.drive(12);
		transCar.hashCode();
		/*
		 * commute is only accessible to Car referenced objects
		 */
		//transCar.commute();//will not compile
		
		Transport<String>transBoat=new Boat();
		transBoat.drive("patsy");
		transBoat.hashCode();
		/*
		 * this is only accessible to Boat reference objects
		 */
		//transBoat.sail();
		/*
		 * this is a Boat reference to a Boat object and has access to ALL
		 * of the Boat class methods
		 */
		Boat myBoat=new Boat();
		myBoat.sail();
		/*
		 * if you don't put in a data type, boat still recognised this
		 * object as giving it a data type of String, but there is another
		 * issue with it, which will be covered by generics section in next
		 * chapter
		 */
		Transport boatTrans=new Boat();
		boatTrans.drive("sally");
		/*
		 * if you put in any other data type other than <String> this 
		 * WILL NOT COMPILE
		 */
		//Transport<Integer>noTrans=new Boat();
		Human myHuman=new Human();
		myHuman.name="harry";
		/*
		 * Transport reference to a Aeroplane object and only has access
		 * to the void drive(Human t) method
		 */
		Transport<Human>aeroTrans=new Aeroplane();
		aeroTrans.drive(myHuman);
		/*
		 * only Aeroplane referenced objects have access to the Aeroplane
		 * fly() method, this will not compile
		 */
		//aeroTrans.fly();	
		System.out.println("interface reference to a lambda");
		/*
		 * a lamba only compiles for a function interface, so only interfaces
		 * with ONE abstract methods can be lambdas
		 */
		System.out.println("long form lambda");
		Transport<Integer>transLamb1=(Integer i)//parameter list o void drive(Integer t)
				->//this seperates parameter list from body
		{//this is body of void drive(Integer t){}
			/*
			 * if you have more than one line of code in your lambda, you
			 * have to have curly brackets for the body of your lambda
			 */
			System.out.println("transLamb1 drive method called");
			System.out.println("i is "+i.getClass().getSimpleName());
		};
		/*
		 * all this object can do really is call the void drive(Integer t)
		 * method (of course i can also call all methods of the object 
		 * class). you have to send this method an Integer
		 */
		transLamb1.drive(12);
		Transport<String>transLamb2=(s)
				->
		System.out.println("translamb2 drive method called "+s);//end of lambda
		transLamb2.drive("banana");
		/*
		 * don't have to put in brackets for "d", it knows "d" is a double
		 * and don't have to put in curly brackets for body
		 */
		Transport<Double>transLamb3=d->System.out.println(d+" is the double");
		//implementing the above lambda
		transLamb3.drive(2.0);
		/*
		 * if there is no parameter in your method that lambda is implementing
		 * you HAVE TO have a blank set of braces
		 * i.e
		 * abstract void eat();
		 * lambda for it would have to look like
		 * ()->system.out.println("eat me");
		 * if you have more than one parameter in your method, you HAVE TO
		 * have a blank set of braces
		 * abstract void drink(String name,Double weight)
		 * (s,n)->system.out.pringln("drink me");
		 */
		Needs<String,Double>needlamb=(s,d)->System.out.println(s+" s"+d+" d");
		/*
		 * Transport reference to Car object 1st parameter
		 * second parameter HAS TO BE AN INTEGER
		 * pass in anything other than an integer and we get a 
		 * ClassCastException (change 12 to 12.3 to see exception)
		 */
		takeTransport(transCar,12);
		/*
		 * transport reference to a Aeroplane object 1st parameter
		 * second parameter HAS TO be a HUMAN
		 * pass in anything else than a Human and we get a 
		 * ClassCastException 
		 */
		takeTransport(aeroTrans,myHuman);
		/*
		 * transport reference to a lambda that implements the Transport 
		 * interface and sets the type to be <Double>
		 * second parameter HAS TO BE DOUBLE
		 */
		takeTransport(transLamb3,2.0);
		/*
		 * this is a car reference to a Car object, and the Car class DOES
		 * IMPLEMENT Transport, so that means we can send this object to this
		 * method. this method can take ANY object that implements the 
		 * Transport interface, regardless of it's reference
		 */
		Car myCar=new Car();
		takeTransport(myCar,45);
	}
	/**
	 * this method is taking a Transport referenced object t1(which can be
	 * the lambdas implementing the Transport interface or any of the Transport
	 * reference to the Objects of a class that implments that interface).
	 * anything that has a Transport reference, can sent to this method
	 * so ANY of the above Transport references can be sent to this method.
	 * the second parameter is what the abstract drive(T t) method takes 
	 * as a parameter
	 * @param t1
	 */
	/**
	 * 
	 * @param t1 first parameter that is an object that implements the Transport Interface
	 * @param t is a object just to show that you can have other parameters 
	 */
	static void takeTransport(Transport t1,Object t) {
		t1.drive(t);
	}
	/**more on how rerfences can affect what an object can and cannot access
	 * @see com.android.Human
	 * @see com.android.Behaviour
	 * @see com.android.Dog
	 * @see com.android.Animal*/
	static void ex3() {
		/*
		 * Human is in Animal file and does not extend anything, EXCEPT 
		 * Object
		 */
		Human myHuman=new Human();
		/*
		 * this is a Human reference to a Human object, when casting it's 
		 * not the Object you are changing, it's the REFERENCE. if you change
		 * the reference you change what methods are available to it, wiht a
		 * Human reference you have access to all the  methods of the Human 
		 * class
		 */
		myHuman.mad();
		myHuman.sad();
		myHuman.talk();
		myHuman.hashCode();
		myHuman.toString();
		/*
		 * this object is still a Human object, however it only has access to 
		 * Object class methods or any object class methods that were overriden
		 * in the Human class.
		 */
		Object humanObject=new Human();
		//humanObject.mad();//was not defined in Object class will not compile
		//humanObject.talk();//was not defined in Object class will not compile
		
		Object objHuman=myHuman;
		objHuman.toString();
		//objHuman.mad()//will not compile
	
		/*
		 * the above is a Object reference to an exising Human Object, again we
		 * can only access methods first defined in the Object class
		 */
		
		Behaviour behaveHuman=myHuman;
		/*
		 * the above is a Behaviour reference to an existing object
		 */
		behaveHuman.sad();
	///	behaveHuman.talk();
		/*
		 * this is a an object reference to a Human object, which means
		 * you can cast this object to a Human reference
		 * this object has no access to sad(), mad() or talk()
		 */
		System.out.println(humanObject);
		//humanObject.mad();//will not compile
		/*
		 * newHunman is a Human reference to a Human Object
		 * we cast it to make it a Human reference
		 */
		Human newHuman=(Human)humanObject;
		newHuman.sad();
		newHuman.mad();
		newHuman.talk();
		System.out.println("casting Dogs");
		Dog spot=new Dog();//in animal class, has own method bark()
		/*
		 * spot is a Dog reference to a Dog object, so has access to all
		 * methods of the Dog class
		 */
		spot.bark();
		/*
		 * this is a Super class Animal reference to a sub class Dog Object,
		 * which is allowed
		 * this object does not have access to bark
		 */
		Animal anDog=new Dog();
		anDog.mad();
		anDog.sad();
		//does not have access to bark
		//anDog.bark();
		/*
		 * anDog is a Animal reference, and that is all the Dog myDog reference
		 * sees, so this is a sub class reference Dog to a super class Animal
		 * object
		 * can't have a sub class reference to super class object
		 */
		//Dog myDog=anDog;//will not compile
		/*
		 * anDog is a Animal reference to a Dog object, so it can be cast to
		 * be of reference Dog, because it is a Dog boject
		 */
		Dog myDog=(Dog)anDog;
		try {
			spot=(Dog)new Animal();
		}
		catch(Exception e) {
			System.out.println("the exception is "+e.getClass().getSimpleName());
		}
		
	}
	
	

}
