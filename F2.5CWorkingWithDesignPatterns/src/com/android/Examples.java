package com.android;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.android.Flower.Colour;
import com.android.Flower.Type;
import com.android.Human.HumanBuilder;
/*
 * this will import everything from the Employee class
 * including the nested static EmployeeBuilder class and 
 * the Title Enum
 */
import com.android.Employee.*;
/*
import com.android.Employee.EmployeeBuilder;
import com.android.Employee.Title;
*/

/**
 * class that contains code of how to deal with the builder pattern, the builder pattern is an 
 * alternative way to constructors to creating objects. we have a seperate class, which is called a 
 * builder class that returns a object of a class that we wish to created. A series of chained setter
 * methods are then called to give values to all, some, one or indeed none of the variables of a class
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/2LTVxGL9XOI">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
public class Examples {
	/**this method uses a Flower class and a FlowerBuilder class. the FlowerBuilder has setter methods
	 * that assign values to all the variables of the Flower class. The flowerBuilder class also has
	 * a builder method that returns the flower that has had the flowerBuilder setter method give values
	 * to it's variables
	 */
	static void ex1() {
		System.out.println("flower with just an age");
		//this is a flower with just an age
		Flower myFlower=new FlowerBuilder().setAge(12).build();
		System.out.println(myFlower);
		//this is a flower with no values for any of its variable
		myFlower=new FlowerBuilder().build();
		System.out.println(myFlower);
		Colour myColour=Colour.RED;
		
		myFlower=new FlowerBuilder().setAge(12).setWeight(2.4).
				setColour(myColour).setType(Type.ROSE).build();
		System.out.println(myFlower);
		myFlower=new FlowerBuilder().setAge(5).setType(Type.TULIP).setWeight(3.4)
				.setColour(Colour.YELLOW).setSmell(true).setPetals(12).setHeight(7).
				build();
		System.out.println(myFlower);
	}
	/**this is using the Builder Pattern to create immutable objects, the Animal class is a class
	 * that creates immutable objects, see section 2.5B WorkingWithDesignPatterns for further explanation
	 * We have a separate AnimalBuilder class that has setters to give values to internal variables int age and 
	 * String name variables. these setters do NOT directly assign values to the age and name variables of the Animal class,
	 * but are used in the final builder method to create a Animal object with the values passed on from the Setters
	 * of the AnimalBuilder class
	 */
	static void ex2() {
		/*
		 * this creates an Animal with an Age of 12 and name of "cow
		 */
		Animal myAnimal=new AnimalBuilder().setAge(12).setName("cow").build();
		System.out.println(myAnimal);
		/*
		 * this creates an Animal with the age of 0 and the name of 
		 * "" (blank string)
		 */
		myAnimal=new AnimalBuilder().build();
		System.out.println(myAnimal);
	}
	/**this method demonstrates more about using an immutable class with a Builder class, here we are again using
	 * the Animal and the AnimalBuilder class. Each time we use the Build method of the AnimalBuilder, it is
	 * important to realise that a DIFFERENT Animal is created each time
	 * using the same builder object is also a quick way to create copies, for instance in this example we create
	 * many cows using the same AnimalBuilder object, each of these cows will have an age of 12 and a name of 
	 * "bessie"
	 */
	static void ex3() {
		System.out.println("creating Immutable class objects with a Builder class");
		//this is creating a AnimalBuilder object
		AnimalBuilder cowBuilder=new AnimalBuilder();
		//common to chain methods with the Builder pattern
		/*
		 * we have not yet created our cow, this is just assigning the value of 12 to the int age
		 * variable inside the cowBuilder class and the value of "bessie" to the String name variable
		 * of the cowBuilder class
		 */
		cowBuilder.setAge(12).setName("bessie");
		/*
		 * the build() method of the AnimalBuilder class is what creates the Animal
		 */
		Animal cow=cowBuilder.build();//cow 1 created with age of 12 name of bessie
		cow=cowBuilder.build();//cow 2 created with age of 12 name of bessie
		System.out.println(cow);
		cow=cowBuilder.setAge(4).build();//cow 3 created with age of 4 name of bessie
		System.out.println(cow);
		List<Animal>herd=new ArrayList<Animal>();
		for(int i=0;i<50;i++) {
			cow=cowBuilder.build();
			herd.add(cow);
		}
		/*
		 * you do not have to create a AnimalBuilder reference when creating an Animal
		 * if you are going to be creating a Animal with the same name and age, then you
		 * could use a AnimalBuilder reference
		 */
		Animal sheep=new AnimalBuilder().setAge(3).setName("flossie").build();
		System.out.println(sheep);
		//this is an Animal of name "goat" and age of 0
		Animal goat=new AnimalBuilder().setName("goat").build();
		System.out.println(goat);
		//this is an Animal with a name of "" and a age of 15
		Animal pig=new AnimalBuilder().setAge(15).build();
		System.out.println(pig);
	}
	/**
	 * this method uses a Human class and an inner nested HumanBuilder class, which is the usual way that builders
	 * are used. This has the advantage that your code is more contained and also the Builder class can access
	 * private constructors of the outer Human class.
	 */
	static void ex4() {
		/*
		 * inside HumanBuilder we have a private Human called myHuman
		 * so every time we use hBuilder, we are referring to this particular Human
		 */
		HumanBuilder hBuilder=new HumanBuilder();
		//this is a seperate Human
		Human me=new HumanBuilder().setAge(46).setName("noel").setWeight(300.2).build();
		//this is referring to the Human created in the line
		//HumanBuilder hBuilder=new HumanBuilder();
		Human you=hBuilder.setAge(20).setName("mary").build();
		//this is also the same Human
		Human someOne=hBuilder.setAge(45).build();
	//	System.out.println(me);
		System.out.println(you);
		System.out.println(someOne);
		//they are the same object, so this is true
		System.out.println(you.equals(someOne));
		
		Human harry=new HumanBuilder().setDob(LocalDate.now().minusYears(30)).setName("harry").build();
		System.out.println(harry);
		int age=25;
		harry=new HumanBuilder().setAge(age).setDob(LocalDate.now().minusYears(age)).setName("mary").build();
		System.out.println(harry);
	}
	/**using an inner static builder class with an outer immutable class
	 * uses Employee and inner nested class EmployeeBuilder*/
	static void ex5() {
		Employee emp1=new EmployeeBuilder().setGender(true).setStartDate(LocalDate.now()
				.minusYears(3)).build();
		System.out.println(emp1);
		Employee emp2=new EmployeeBuilder().setName("mary").setStartDate(LocalDate.now()
				.minusMonths(9)).setRole(Title.MANAGER).setWages(45_000.56).setGender(true).
				build();
		System.out.println(emp2);
		
		EmployeeBuilder empBuild=new EmployeeBuilder();
		System.out.println("using EmployeeBuilder numerous times");
		//this creates a NEW employee with default values
		System.out.println(empBuild.build());
		//this creates a new employee with the name of pat and the rest default values
		System.out.println(empBuild.setName("pat").build());
		/*
		 * this creates a new employee with the title of GENERAL and wages of 90,000.12 and
		 * the name pat and the rest have default values
		 */
		System.out.println(empBuild.setRole(Title.GENERAL).setWages(90_000.12).build());
		
	}

}
