package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.android.animals.Animal;
import com.android.animals.Cow;
//import com.android.animals.Cow;
/*
 * this will import everything including the nested static classes, which is the 
 * CowBuilder class
 */
import com.android.animals.Cow.*;

import com.android.animals.Elephant;
import com.android.animals.Lemur;
import com.android.animals.Whale;
import com.android.animals.Zebra;
import com.android.generics.Box;
import com.android.generics.Bucket;
import com.android.generics.Container;
import com.android.generics.Crate;
import com.android.generics.Kettle;
import com.android.generics.Pan;
import com.android.interfaces.Behaviour;
import com.android.interfaces.Life;
import com.android.plants.Flower;
/**
 * examples class that contains all the code for covering the topic 3.2AWorkingWithGenerics
 * for video tutorial go to 
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 * @author NoelF
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 *
 */
public class Examples {
	/**
	 * this is an inner private interface which means it can only be accessed inside of the 
	 * Examples class and we are using this to show advantage to generics and this is used in ex1 method
	 */
	private interface Grow{
		/**abstract method sprout*/
		void sprout();
		/**abstract method pollinate*/
		void pollinate();
	}
	/**private inner enum that has three types of COCONUT, MANGO and RASPBERRY
	 * enums can implement interface and here is implements the private inner interface Grow*/
	private enum Fruit implements Grow{
		/**Coconut will use the Sprout() and Pollinate() method of the enum Body*/
		COCONUT()
		/**Mango will use the sprout() and pollinate() method of the enum body*/
		,MANGO(),
		/**
		*Magon uses an anonymous inner class 
		*this cannot have a constructor but it can have an initialiser and it has it's own 
		*sprout() and pollinate() methods
			 */
		RASPBERRY(){
			
			{
				System.out.println("raspberry initialiser");
			}
			/**override sprout() method of the Grow interface*/
			@Override
			public void sprout() {
				System.out.println("raspberry sprouting");
			}
			/**override the pollinate() method of the Grow interface*/
			@Override
			public void pollinate() {
				System.out.println("raspberry pollinating");
			}
		};//end of raspberry inner class
		
		/**
		 * constructor that each one of the Fruit types call, as soon as we create ONE
		 * enum value, all of the types are created at this point.
		 * this constructor will only run three times
		 */
		Fruit(){
			System.out.println(this.toString().toLowerCase()+" Fruit created");
		}

		/**
		 * Coconut and Mango will use this sprout method
		 */
		@Override
		public void sprout() {
			System.out.println("fruit sprouting");
			
		}
		/**Coconut and Mango will use this pollinate method*/
		@Override
		public void pollinate() {
			System.out.println("fruit pollinating");	
		}
		/**
		 * an enum can have any inner class, only the enum objects can use this
		 */
		private class StrawBerry{
			
		}
		/**
		 * Grow is an interface with two abstract methods in it, so you can't create a 
		 * lambda for it, here we have anonymous class implementation of the Grow interface
		 */
		Grow myGrow=new Grow(){

			@Override
			public void sprout() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void pollinate() {
				// TODO Auto-generated method stub
				
			}//end of Anonymous class implmentation of the Grow interface
			
		};
	}//end of enum
	/** this is introductory code to generics
	 * when we create a Arraylist we do the following
	 * {@code ArrayList<String>names=new ArrayList<String>()}
	 * the angled brackets {@code<>}are supplying a type for a Generic, Generics allow us to supply a TYPE
	 * to an object when we run the code, so when we go
	 * {@code List<String>names=new ArrayList<String>()}
	 * List has a what is known as a generic type, which can be any object, of any type. Here we are saying, when 
	 * we run the code, that this type of List is going to be a list of Strings. this List can then only takes
	 * Strings (or subclasses of strings if they existed, but they don't as String is final and immutable)
	 * if we created a 
	 * {@code List<Number>listNum}
	 * this is then a list that can only take a Number wrapper object OR a subclass of Number. Number is the 
	 * superclass of all wrapper number objects, so this can take Doubles, Integers, Floats, etc*/
	static void ex1() {
		/*
		 * when we do this, we supply a type to the List interface and that type is String,
		 * we can only now add Strings to this list, if we attempt to add anything else it
		 * will not compile
		 */
		List<String>names=new ArrayList<String>();
		String fruit="banana";
		names.add(fruit);
		names.add("apple");
		names.add(new String("Orange"));
		//can't add a enum type, will not compile
		//names.add(Fruit.COCONUT);
		/*
		 * every class has a toString() method, so whereas you can only add a string to a 
		 * list of Strings, any class can call it's toString method and add that to a list
		 * of strings
		 */
		names.add(Fruit.COCONUT.toString().toLowerCase());
		/*
		 * Number is a super class of all the wrapper number classses, the generic of the 
		 * List interface is set up to take a type or a sub class of the supplied type.
		 * in this case it can take a Number wrapper type or a sub class of the number 
		 * wrapper type, which is any of the number wrapper classes (INTEGER,DOUBLE,FLOAT,ETC)
		 */
		List<Number>numbers=new ArrayList<Number>();
		/*
		 * 1 is autoboxed to become an INTEGER WRAPPER, integer is a sub class of NUMBER
		 */
		numbers.add(1);
		/*
		 * 2.3 is autoboxed to become a DOUBLE WRAPPER, Double is a sub class of NUMBER
		 */
		numbers.add(2.3);
		/*
		 * Can't add a INTEGER wrapper to a list of DOUBLE wrapper objects
		 */
		List<Double>doubles=new ArrayList<Double>();
		//will not compile
	//	doubles.add(1);	
	}
	/**
	 * Generic types can only be OBJECTS, cannot be primitives, that is why you can't have an arraylist of ints, they
	 * are autoboxed to become Integers.
	 * see com.android for all Animal and MythicalCreatures we can create 
	 * and com.android.generics for all containers (Box, Bucket, Crate, etc) we can create
	 * the line
	 * {@code Crate<Elephant>crateElephant=new Crate<Elephant>(nellie)}
	 * creates a Crate object and sets the generic type T inside the Crate class to
	 * be an Elephant, the diamond operator on the left does this
	 * {@code Crate<Elephant>crateElephant}
	 * on the right hand side, we go
	 * {@code new Crate<Elephant>}
	 * here {@code <Elephant>} is optional for now, you could just put in {@code <>}
	 * there is only one constructor in the Crate class
	 * Crate(T contents)
	 * so we have to sent it an object of type, in this, Elephant
	 * whatever type we define T to be, we have to send it to the constructor, in this
	 * case
	 */
	static void ex2() {
		Elephant nellie=new Elephant();
		
		Crate<Elephant>crateElephant=new Crate<Elephant>(nellie);
		
		Crate<String>crateString=new Crate<>("hello");
		/*
		 * if you dont' supply Crate with a type, it will assume that type T is an 
		 * Object. No Diamond operators means that type T, will be an object
		 */
		Crate crateObj=new Crate(new Object());
		//this calls the toString method of the elephant class
		crateElephant.returnMe(new Elephant());
		
		List<Integer>numbers=Arrays.asList(12,67,88,99);
		
		Crate<List>crateList=new Crate<List>(numbers);
		//calls the toSTring method of the List interface
		crateList.returnMe(numbers);
		
	}
	/**
	 * this is using the Box class which has a class declaration as follows
	 * {@code class Box <T extends Animal>}
	 * which means type T can only be a Animal or subclass of Animal, if we pass any other type rather than
	 * an Animal or sub class of Animal then that will NOT compile
	 * the subclasses of Animal are Cow, Elephant and Zebra
	 */
	static void ex3() {
		System.out.println("using extends with Generics");
		Cow myCow=new CowBuilder().setAge(3).setHeight(2.3).setWeight(240).build();
		System.out.println("Creating Box objects");
		//myAnimal inside box will be Animal (Animal reference to Animal object
		Box<Animal>boxAnimal=new Box<>(new Animal());
		//myAnimal inside box with be a Zebra (Animal reference to Zebra object)
		Box<Zebra>boxZebra=new Box<>(new Zebra());
		//myAnimal inside boxe will be a Cow
		Box<Cow>boxCow=new Box<>(myCow);
		//myanimal inside Box will be a cow, that we created with the new Cowbuilder object
		Box<Cow>boxCow2=new Box<>(new CowBuilder().setAge(34).setHeight(15).setWeight(400).build());
	}
	/**
	 * this is using the Bucket class, which has a class declaration as follows
	 * {@code class Bucket <T extends Behaviour>}
	 * which means type T can only be a Object that implements the Behaviour interface, if we pass any other type
	 * that does NOT implement the Behaviour interface then the code will NOT compile.
	 * We have two classes that implement Behaviour, Whale and Lemur, so we can create a Bucket with a Lemur or Whale. We
	 * can also create a Bucket object with an object that uses Anonymous class implementation of the Behaviour 
	 * interface
	 * Behaviour interface can be seen in the com.android.interfaces package
	 */
	static void ex4() {
		Behaviour behaveWhale=new Whale();
	//	behaveWhale.happy();
	//	behaveWhale.mad();
	//	behaveWhale.sad();
		//no access to swim() method as this is a Behaviour reference
	//	behaveWhale.swim(;)
		/*
		 * this creates a Bucket and sets the Generic type in the Bucket class T, to be a
		 * Whale. T myBehave, is now a Whale myBehave; reference
		 * anywhere inside the Bucket class you have T, it now means Whale
		 * remember <T extends Behaviour>, which means we can only use objects of a class
		 * that implements the Behaviour interface
		 */
		Bucket<Whale>bucketWhale=new Bucket<Whale>(new Whale());
		bucketWhale.fill(new Whale(), 4);
		Bucket<Lemur>lemurBucket=new Bucket<Lemur>(new Lemur());
		lemurBucket.fill(new Lemur(), 4);
		/**
		 * anonymous class implementation of the Behaviour interface
		 */
		Behaviour anonBehave=new Behaviour() {
			/**
			 * this object CANNOT call this method outside of these curly
			 * braces
			 */
			public void dummy() {
				System.out.println("dummy method called");
			}
			
/**
 * these three overriden methods from the behaviour interface only exist for this
 * object called anonBehave
 * this is the overriden method sad method of the Behaviour interface
 */
			@Override
			public void sad() {
				System.out.println("anonymous class implemenation of sad method in behaviour");
				dummy();
			}
/**overridden happy method of the Behaviour interface*/
			@Override
			public void happy() {
				System.out.println("Anonymlus class implementation of the happy method in behaviour");
/**Overridden mad method of the Behaviour interface	*/			
			}
			@Override
			public void mad() {
				System.out.println("anonymous class implementation of the mad method in Behaviour");
				
			}		
		};//end of anonBehave
		anonBehave.happy();
		anonBehave.mad();
		anonBehave.sad();
		/*
		 * cannot access the void dummy() method outside of the anonymous inner class
		 */
	//	anonBehave.dummy();
		/*
		 * this sets our generic to be an any object that implements the Behaviour interface,
		 * Whale implements Behaviour
		 * Lemur implements Behaviour
		 * anonBehave implements Behaviour
		 */
		System.out.println("***Bucket with a interface type generic");
		Bucket<Behaviour>bucketBehave=new Bucket<>(new Whale());
		bucketBehave=new Bucket<>(new Lemur());
		bucketBehave=new Bucket<>(anonBehave);	
	}
	/**
	 * This uses the Pan class which has a class definition of
	 * {@code class Pan <T extends Life>}
	 * the life interface (in com.android.interfaces) is a functional interface, which means it can use lambdas to 
	 * implement this interface
	 * this code creates a Pan object with class that implements the life interface, which a flower object does
	 * this code creates a Pan object with a Lambda that implements the life interface
	 * you can create a Pan object with Flowers and only subclasses of Flowers
	 * however you can create a Pan object to any other class that implements the Life interface
	 */
	static void ex5() {
		System.out.println("***Ex5");
		/*
		 * lambda implementation of the Life Functional interface
		 */
		Life anotherLife=()->System.out.println("grow method of anotherLife lambda");
		Flower rose=new Flower();
		/*
		 * this sets the generic T myLife, to be any object that implements the Function
		 * interface life, which can be a 
		 * Flower or any other class that implements the life interface
		 * a anonymous class
		 * a lambda
		 * this Pan object is created with a Life lambda
		 */
		anotherLife.grow();
		rose.grow();
		System.out.println("creating Pan with Life reference and rose object");
		Pan<Life>panFlower=new Pan<Life>(rose);
		System.out.println("crating pan with life reference and lambda");
		Pan<Life>lifePan=new Pan<Life>(anotherLife);
		//class that implements LIfe
		lifePan=new Pan<>(new Flower());
		System.out.println("creting pan with life reference and Anonymous class");
		Life anonLife=new Life() {

	
			@Override
			public void grow() {
				System.out.println("anonymous class life implementation");
				
			}	
					
			public int wilt() {
				return 1;
			}
			Life innerLife=()->System.out.println("inner lambda called");
		};//end of anonymous class
		//a anonymous class that implements Life
		anonLife.grow();
		lifePan=new Pan<>(anonLife);
		/*
		 * Type T myLife inside the Pan class, can only be a Flower, so you can only 
		 * send a flower to the constructor. 
		 * whereas if we say
		 * Pan<Life>
		 * we can sent 	ANY OBJECT that implements the Life interface, which can be any
		 * class that implements the LIfe interface, any lambda that implements the
		 * Life interface
		 * any anonymous class that implements the Life interface.
		 */
		/*
		 * the only difference between this two objects, is that the first will ONLY
		 * TAKE flowers or sub classes of flowers
		 */
		Pan<Flower>flowerPan=new Pan<>(new Flower());
		/*
		 * this can take any class that implements LIfe and lambda and anoymous classes,
		 * however this is virtually a copy of the above, as its the same result
		 * and same implementation
		 */
		Pan<Life>flowery=new Pan<>(new Flower());
		
		flowerPan=new Pan<>(new Flower());
		//will not take a lambda
		//flowerPan=new Pan<>(anotherLife);
		//will not take an anonymous inner class
	//	flowerPan=new Pan<>(anonLife);
	}
	/**
	 * here we use the Container class in the com.android.generics which has a class declaration like the following
	 * {@code class Container <T,U,V>}
	 * T,U and V can be any types we want them to be
	 * This also explains why to use the diamond operator {@code <>} on the right hand side of a variable
	 * declaration
	 */
	static void ex6() {
		/*
		 * this gives a type to T of Integer, to U of String and to V of Animal
		 */
		Container<Integer,String,Animal> myContainer =
		new Container<>(12,"Hello there",new Animal());
		//will compile
		Container container2=new Container(49,"Hello there",new Animal());
		//will compile
		Container container3=new Container<>(49,"Hello there",new Animal());
		//will compile
		Container container4=new Container<>(49,"Hello there",new Animal());
		/*
		 * this has no right hand side Diamond operator, so you can pass in 
		 * ANY sort of object in any order (still has to be three objects as our
		 * constructors takes three objects)
		 */
		Container<Integer,String,Animal>Container5=
				/*
				 * 49.6 is NOT an Integer
				 * new Lemur is NOT a String
				 * "hello" is NOT a Animal
				 */
				new Container(49.6,new Lemur(),"hello");
		/*
		 * however if you fail to put in the diamond operator on the right that means
		 * you can actually have any types in any order instead of the specified types
		 * of 
		 * INTEGER,STRING, ANIMAL
		 */

		/*
		 * as soon as you put in teh diamond operator on the right hand side it forces
		 * you to have the correct types on the right hand side
		 * of 
		 * INTEGER,STRING, ANIMAL
		 * so this WILL NOT COMPILE
		 */
		/*Container<Integer,String,Animal>Container6=
				new Container<>(5.6,new Lemur(),"banana");*/
	}
	/**
	 * this uses the Kettle class in com.android.generics that has a class declaration 
	 * {@code class Kettle <T extends Animal ,V extends Behaviour,E extends Number>}
	 * an example of a declaration would be 
	 * {@code Kettle<Zebra,Whale,Integer>myKettle=new Kettle<>(new Zebra(),new Whale(),23)}
	 */
	static void ex7() {
		
		/*
		 * first arguement of the constructor can be Animal or subclass of Animal, so it can
		 * be a Animal,Elephant,Zebra or Cow
		 * Second arguement can be any object that implements the Behaviour interface, so
		 * it can be a class that implements Behaviour - Whale and Lemur 
		 */
		Kettle<Zebra,Whale,Integer>myKettle=new Kettle<>(new Zebra(),new Whale(),23);
		/*
		 * first arguement will be an Animal, which can be a subclass of Animal
		 * second 
		 * Second arguement is a Behaviour referenced object, which can be a Lemur, Whale or
		 * an anonymous inner class, there its a Lemur
		 * third argument is a double, so has a double on the right hand side
		 */
		Kettle<Animal,Behaviour,Double>myKettle2=new Kettle<>(new Zebra(),new Lemur(),45.0);
		/*
		 * anonymous class implementation of the Behaviour interface
		 */
		Behaviour myBehave=new Behaviour() {

			@Override
			public void sad() {
				System.out.println("myBehave sad");			
			}

			@Override
			public void happy() {
				System.out.println("myBehave happy");		
			}

			@Override
			public void mad() {
				System.out.println("myBehave mad");		
			}	
		};//end of anonymous class
		/*
		 * this takes a class that extends or is a Animal
		 * takes anonymous class implementation of the Behaviour inteface
		 * and a Integer
		 */
		Kettle<Animal,Behaviour,Integer>myKettle3=
				new Kettle<Animal,Behaviour,Integer>(new Elephant(),myBehave,23);
		
	
	}

}
