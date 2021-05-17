package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import com.android.*;//Employee.Occupation;

//import com.android.Human.*;
/**
 * This class is used for running different overriden methods of the object class specifically
 * toString(), equals() and hashCode() and is called from the main method in main class
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/DUtmq4UqNGs">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @see com.android.Main
 */
public class Examples {
	/**
		 * this demonstrates the toString() method
		 * toString() method is a method of object class and is called
		 * automatically whenever a object of any type is placed within
		 * a print statement. you can also explicitly call the toString()
		 * i.e Animal andy=new Animal();
		 * System.out.println(andy.toString());
		 * every object then has a toString method, and every class can 
		 * override the toString() method of the object class. 
		 * the arraylist class overrides the toString() of the object 
		 * class and will print out all of the contents of this list 
		 * @see com.android.Animal
		 * @see com.android.Cards		 
		 * */	
	static void ex1() {
		System.out.println("Overriding toString method");
		//public String toString(){}
		List<String>names=Arrays.asList("noel","laura","shelly");
	
		System.out.println(names.toString());
		//same as above
		System.out.println(names);
		
		Cards myCards=new Cards();
		/*
		 * Cards does not have a overriden toString() method so it will
		 * use the Object class toString method, which basically just
		 * prints out the address
		 */
		System.out.println(myCards);
		
		Animal andy=new Animal();
		Animal angela=new Animal(3,"angela");
		System.out.println(andy);
		System.out.println(angela);
		/*
		 * Animal class DOES have a toString method, that prints out
		 * all the details of the Animal. So the toString method of the
		 * list calls the toString for each Animal and will print out
		 * all the details of the Animal
		 */
		List<Animal>animals=Arrays.asList(andy,angela,new Animal(4,"anthony"));
		System.out.println("list of Animals");
		System.out.println(animals);
		/*
		 * Cards class does NOT have a toString method, so this will
		 * just display the addresses of the Cards objects in the 
		 * list
		 */
		List<Cards>cardsList=Arrays.asList(new Cards(),new Cards(),new Cards());
		System.out.println("list of cards");
		System.out.println(cardsList);
	}
		/**
		 * public boolean equals(Object obj) is a method of the Object
		 * class and again every object that is created in java will 
		 * inherit this method. This method is used to check if two objects
		 * are the same.
		 * if the two objects are the same this will method will return true,
		 * false if not the same. If a class does NOT override this method it 
		 * will takes it's implementation from the the Object class. This returns
		 * true if they are both the same object, and false in all other 
		 * circumstances. 
		 * if a class overrides the equals() method, it is up to the programmer
		 * to determine what will constitute if two objects are the same and 
		 * return true i.e we may determine that two people are the same if they
		 * have the same name and age and disregard the address of two people,
		 * or we may determine that if the have all the same variables they are
		 * equal.
		 * So equals can be used to only check certain variables of a object if 
		 * that is what the program requires. equals is usually overridden in
		 * conjunction with hashcode, hashcode can be used in the equals method
		 * @see com.android.Animal
		 * @see com.android.Cards
		 * @see com.android.Dog
		 * @see com.android.Cat
		 * @see com.android.Pig
		 * @see com.android.Sheep
		 */
	static void ex2() {
		System.out.println("overriding Equals method");
	
		/*
		 * == is for checking if two primitives have same value or if two objects
		 * refrences the same object
		 */
		int num=5;
		int num2=5;
		int num3=10;
		System.out.println(num==num2);//true
		System.out.println(num2==num3);//false
		Animal andy=new Animal();
		Animal angela=andy;
		Animal anthony=new Animal();
		//is the andy object the same object as the angela object, it is
		System.out.println(andy==angela);//true
		System.out.println(angela==anthony);//false
		System.out.println("checking strings");
		/*
		 * String class has its own overriden equals() method which
		 * returns true if the CONTENTS of the string are the same, 
		 * it does not matter if they are different strings
		 */
		String s1=new String("lion");//not in pool
		String s2=new String("lion");//not in pool
		String s3="lion";//in the pool
		String s4="lion";//checks pool for "lion"
		System.out.println(s3==s4);//true
		System.out.println(s1==s2);//false
		System.out.println(s1.equals(s2));//true
		System.out.println(s1.equals(s3));//true
		System.out.println("checking cards");
		/*
		 * at this point, the cards class has no overriden equals()
		 * method, so it uses the equals() method from the object class.
		 * which just checks to see if they are the same object
		 */
		Cards myCard=new Cards();
		Cards myCard2=new Cards();
		Cards myCard3=myCard;
		System.out.println(myCard==myCard2);//false
		System.out.println(myCard.equals(myCard2));//false
		System.out.println("checking stringBuilders");
		/*
		 * StringBuilder does NOT have its own equals() method, so it
		 * uses the Object class equals() method, only checks if they
		 * are the same object
		 */
		StringBuilder sb1=new StringBuilder("lion");
		StringBuilder sb2=new StringBuilder("lion");
		System.out.println(sb1.equals(sb2));//false
		System.out.println("using toString to find if two Stringbuilders "
				+ "are the same");
		System.out.println(sb1.toString().equals(sb2.toString()));
		
		Dog spot=new Dog();
		System.out.println(spot.equals("hello"));
		System.out.println("comparing Dogs");
		Dog dog1=new Dog(1,"spot");
		Dog dog2=new Dog(1,"spot");
		Dog dog3=new Dog(2,"rex");
		Dog dog4=dog1;
		System.out.println("dog1 and dog2 "+dog1.equals(dog2));//true
		System.out.println("dog2 and dog3 "+dog2.equals(dog3));
		System.out.println("dog4 and dog1 "+dog4.equals(dog1));
		
		/*
		 * these dogs will eitehr be true or cause a nullPointerException
		 * see Dog class for explanation
		 */
		Dog noDog1=new Dog();//a dog with age of 0 and a name of null
		Dog noDog2=new Dog();//a dog with age of 0 and a name of null
		System.out.println(noDog1.equals(noDog2));
		
		Dog noName=new Dog(1,null);
		Dog noName2=new Dog(1,null);
		
		System.out.println(noName.equals(noName2));
		
		String str1="hello";
		String str2=null;
		Animal animal1=new Animal(1,null);
		Animal animal2=new Animal(1,null);
		//it returns and thats that
		System.out.println(animal1.equals(animal2));
		animal1=animal2;
		System.out.println(animal1.equals(animal2));
		animal1=new Animal(2,"andy");
		animal2=new Animal(2,"andy");
		System.out.println(animal2.equals(animal1));
		animal2=new Animal(2,"angela");
		System.out.println(animal1.equals(animal2));
		
		spot=new Dog(1,"spot");
		Cat tibbles=new Cat(1,"spot");
		
		System.out.println("comparing dog and Cat");
		System.out.println(spot.equals(tibbles));
		System.out.println("comparing cat and dog");
		//uses the equals method of the Animal class, 
		//so will return
		//true as these are both Animals with the same variables
		System.out.println(tibbles.equals(spot));
		System.out.println("comparing pigs");
		Pig murty=new Pig(1,"spot");
		Pig pippa=new Pig(1,"spot");
		tibbles=new Cat(1,"spot");
		/*
		 * this pig calls the equals method, that will always return false
		 * if comparing with an Animal that is NOT a pig, tibbles is a
		 * cat, so this will be false. this uses the Pig equals() method
		 * which checks first that they are both pigs, so this will always
		 * be false
		 */
		System.out.println(murty.equals(tibbles));//false
		//both pigs with same name and age
		System.out.println(murty.equals(pippa));//
		System.out.println("comparing cat with a pig");
		/*
		 * this uses the Animal class equals method, which does not take
		 * into account whether the Animals are different species, it only
		 * checks to see if they are both Animals and both have the same
		 * name and age, so this will return true
		 */
		System.out.println(tibbles.equals(murty));//true
		
		Sheep sheep1=new Sheep(1,"shawn",2.56);
		Sheep sheep2=new Sheep(1,"shawn",2.56);
		Sheep sheep3=new Sheep(1,"shawn",3.2);
		System.out.println("comparing Sheep");
		System.out.println(sheep1.equals(sheep2));
		System.out.println(sheep1.equals(sheep3));
		System.out.println(sheep1.equals(tibbles));
	
	}
		/**
		 * Hashcode is a method of the object class that is usually 
		 * overriden with the equals method and can be used in conjunction
		 * with the equals method to uniquely identify an object.
		 * it is used in particular with HashMaps and sets which are 
		 * covered in detail in chapter 3. A hash is a number that is
		 * produced usually from the variables of a object (which can 
		 * be used to identify the object)
		 * @see com.android.Employee
		 */
	static void ex3() {
		System.out.println("HashCode");
	
		String name="noel";
		System.out.println("string hashcodes");
		/*
		 * the string class has it's own overriden hashCode() method
		 */
		System.out.println("hascode of noel is "+name.hashCode());
		name="mary";
		System.out.println("hashcode of mary is "+name.hashCode());
		name="MARY";
		System.out.println("Hashcode of MARY is "+name.hashCode());
		
		List<String>names=new ArrayList<String>();
		//will be 1
		System.out.println("hashcode of names is "+names.hashCode());
		names.add("noel");
		names.add("mary");
		names.add("MARY");
		System.out.println("hashCode of names is "+names.hashCode());
		List<String>names2=new ArrayList<String>();
		//order does matter
		names2.add("noel");
		names2.add("mary");
		names2.add("MARY");
		System.out.println("hashCode of names2 is "+names2.hashCode());
		//all empty lists have a hashcode of 1
		List<Animal>animalList=new ArrayList<Animal>();
		System.out.println(animalList.hashCode());
		/*
		 * the arraylist class uses the hashcode method of whatever
		 * data type it contains to determine if both lists are the same.
		 * in this case, the list hashcode is produced by the string hashes
		 * of each string in the list.
		 * lists with the same objects in them, will have the same
		 * hashcode
		 */
	//	Employee eddie=new Employee(123,"eddie",234.2,Occupation.NURSE);
		
	//	Employee emp2=new Employee(123,"eddie",234.2,Occupation.NURSE);
//		System.out.println(eddie.hashCode());
	//	System.out.println(emp2.hashCode());
	//	double weight=12345.689;
	
	}
	/**
	 * Brief explanation of Bitshifting, which some of our hashcode methods use to produce a
	 * hash (which is simply a number)
	 */
	static void ex4() {
		int num=60;
	/*
	 * this is the binary number 111100
	 */
		System.out.println("binary version of 60 is "
	 +Integer.toBinaryString(num));
		System.out.println("right bit shift >>");
		/*
		 * the right shift operator >>, moves all of the right most
		 * bits 2 places in this situation
		 * so the number 111100
		 * becomes
		 * 1111
		 */
		System.out.println("60 right bit shift 2 is "+(num>>2));//15
		//11110000
		System.out.println("60 left shift 2 is "+(num<<2));//240
		/*
		 * zero fill right shift basically does the same thing as
		 * the right shift operatotr, but it fills up the bits with 
		 * zeros
		 * this produces 001111 (don't know how to get eclipse to 
		 * get to display this
		 */
		System.out.println(Integer.toBinaryString(num>>>2));//15 which is 001111
		System.out.println("bitwise XOR");
		num=60;
		int num2=15;
		/*
		 * 1 and 0 is the only one that gives us 1
		 */
		System.out.println("60 in binary "+Integer.toBinaryString(num));
		System.out.println("15 in binary 00"+Integer.toBinaryString(num2));
		System.out.println("60 XOR 15     "+Integer.toBinaryString(num^num2));
	}
	

}
