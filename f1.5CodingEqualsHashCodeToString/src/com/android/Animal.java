package com.android;
/**
	 * superclass for Dog, Cat, Cow, Pig and Butterfly
	 * Animal class overrides ()toString and equals()
	 * some of the subclasses further override the equals method and used in ex1
	  * To see video tutorial for this section of code
	  * <a href="https://youtu.be/DUtmq4UqNGs">Video tutorial</a>
	  * For all 177 videos, which cover all the topics in this course go to
	  * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 * @see com.android.Examples#ex1()
	 */
public class Animal {
	/** age of Animal*/
	int age;
	/**name of Animal*/
	String name;
	//blank constructor
	/**Constructor that takes no arguements that will be called by some of it's sub classes*/
	Animal(){
		
	}
	//constructor that takes an int and a string
	/**Constructor that takes a int age and a String name and will be called by some of it sub classes*/
	Animal(int age,String name){
		this.age=age;
		this.name=name;
	}
	/**
	 * overriden toString method, if none of the subclasses have a toString method this will be 
	 * the toString() that a subclass will use, this will print out the age and name of the Animal
	 * @return string with age and name in it
	 */
	@Override
	public String toString() {
		return "age is "+age+" name is "+name;
	}
	/**
	 * Overriden equals method that is more complex than {@link com.android.Cards} and if two Animal have the same
	 * age and name they will said to be equal
	 * @param obj the object the Animal calling the method is comparing itself with
	 * @return true if two animals being compared have the same name and age, false in all other circumstances */
	@Override
	public boolean equals(Object obj) {
		/*
		 * if both objects are the same object then return true
		 * this also checks to see if obj is null, as if obj is null
		 * then they are not the same object.
		 * andy the animal is calling this method, a null Animal object
		 * CANNOT call equals method, so if obj is null, then they're they
		 * are not the same, and this will fail
		 */
		if (this == obj)
			return true;
		/*
		 * if objectg sent to method is not an Animal then they are
		 * not equal and return false
		 */
		if (!(obj instanceof Animal))
			return false;
		/*
		 * if they are the object type, in this case an Animal. we are
		 * going to cast obj to be of type Animal. As obj is at this point
		 * Object obj=new Animal();
		 * so we cannot access the age and name of this animal
		 * so we cast it
		 * to end up with
		 * Animal other=Animal
		 */
		Animal other = (Animal) obj;
		/*
		 * if the age of the Animal that calls equals is not the same
		 * as the age of the Animal sent to the method, the method exits
		 * and returns false. if they are the same, it simply goes to 
		 * the next if statement
		 */
		if (age != other.age)
			return false;
		/*
		 * if the name of the Animal calling the equals
		 * method is null, then the else if will NOT be
		 * called. if the name of the other animal is
		 * not null then then exit method with a value 
		 * of false
		 */
		
		if (name == null) {
			if (other.name != null)
				return false;
		} 
		/*
		 * this only runs if the animal calling the method
		 * has a name that is NOT null. if name was null
		 * the line
		 * name.equals
		 * would have generated a nullpointerException
		 */
		else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
/**
 * subclass of Animal and this class also overrides the equals method. if we had no equals method in
 * this class the Dog class would use the equals() method of the Animal class
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/DUtmq4UqNGs">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 */
class Dog extends Animal{
	/**Constructor that takes no arguments*/
	Dog(){
		
	}
	/**constructor that takes a int age and String name and calls the constructor of it's super class Animal
	 * @param age age of Dog
	 * @param name name of Dog
	 * @see com.android.Animal#Animal(int,String)*/
	Dog(int age,String name){
		super(age,name);
	}
/**
 * equals method of the Dog class
 * this uses the variables of the dog class to see if they are equal, it uses a slightly different method
 * to the other sub classes and all are valid. if two Dogs have the same age, they will said to be equal, this does
 * NOT take name into account
 * @param obj the object the Dog calling the method is comparing itself with
 * @return returns true if same age, returns false in all other circumstances
 */
	@Override
	public boolean equals(Object obj) {
		/*
		 * if the object we are comparing with is NOT A DOG, then return
		 * false. Obj is a object reference which means it COULD be any
		 * object, which is why instanceof 	WILL compile, as it COULD 
		 * be a dog
		 */
		if(!(obj instanceof Dog))
			return false;
		/*
		 * if the method has not exited at this point, we can say that
		 * obj IS A DOG OBJECT.
		 * however at this point, we have a Object reference to a Dog
		 * object and we can't access the variables of the Dog class unless
		 * it is a Dog reference. So we cast this object to be a Dog, so
		 * we can then access the age and name of the Dog
		 */
		Dog otherDog=(Dog)obj;
/*
 * this will cause a NullPointerException if you compare two dogs that
 * and either one of them was create using the no args constructor.
 * because name for one of the dogs would be null, and a null object
 * cannot call a method
 * if name is null
 * name.equals causes a nullpointerException
 * it is VERY IMPORTANT to always check for null values in the equals
 * method.
 * need to check that the object you are comparing with is not null
 * i.e the dog
 * or if the object has a variable thats an object is not null
 * i.e name of a dog is a string
 */
	//	return otherDog.age==age&&otherDog.name.equals(name);
		/*
		 * this will return true if they have the same name and age.
		 * however this has an issue, as if we create two Dog using the
		 * no argument constructor then that means we have two dogs that
		 * look like this
		 * age=0
		 * name=null
		 * so according to this code below, these two dogs will be equal.
		 * If you create many dogs with the no args construcutor this
		 * equals method will always return true
		 */
		return otherDog.age==age&&otherDog.name==name;
		//return true;
	}
}
/**
 * Cat class is a subclass of Animal
 * the Cat class DOES NOT override the equals method, so the Cat class will use the equals() method
 * from the Animal class {@link com.android.Animal#equals(obj)}
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/DUtmq4UqNGs">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 */
class Cat extends Animal{
	/**
	 *constructor that takes a int age and String name and calls the constructor of it's super class Animal
	 * @param age age of Cat
	 * @param name name of Cat
	 * @see com.android.Animal#Animal(int,String)*/
	Cat(int age,String name){
		super(age,name);
	}	
}
/**
 * subclass of Animal and this class also overrides the equals method. if we had no equals method in
 * this class the Cow class would use the equals() method of the Animal class
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/DUtmq4UqNGs">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
class Cow extends Animal{
	/**
	 *constructor that takes a int age and String name and calls the constructor of it's super class Animal
	 * @param age age of Cow
	 * @param name name of Cow
	 * @see com.android.Animal#Animal(int,String)*/
	Cow(int age,String name){
		super(age,name);
	}
	/**
	 * two cows will be said to be equal if they have the same age,so here
	 * we can see how the programmer can take any meaning of equals
	 * you can make the equals method simple or more complex according to your needs, we are not taking the name of the 
	 * cow into account here
	 * @param obj the object our cow calling this method is comparing itself too
	 * @return true if two cows have the same age, false in all other circumstances
	 */
	public boolean equals(Object obj) {
		if(!(obj instanceof Cow))
			return false;
		Cow bessie=(Cow)obj;
		return bessie.age==age;
	}
}
/**
 * Sheep class is a Subclass of Animal and overrides the equals method, this equals method also uses the equals method
 * of the Super Animal class 
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/DUtmq4UqNGs">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @see com.android.Animal#equals(obj)
 * @author NoelF
 */
class Sheep extends Animal{
	/**weight of the wool from the sheep*/
	double woolWeight;
	/**Constructor that takes a int age, String name and a double woolWeight and also calls a particular constructor of the 
	 * Animal class 
	 * @param age is the age of the Sheep
	 * @param name is the name of the Sheep
	 * @param woolWeight is the weight of the wool for each sheep
	 * @see com.android.Animal#Animal(int,String)
	 */
	Sheep(int age,String name,double woolWeight){
		super(age,name);
		this.woolWeight=woolWeight;
	}
	/**
	 * if you are using a superclass equals method, and you wish to use
	 * it in a subclass, you have to check for all of the variables
	 * of the subclass that are unique FIRST before you use the super
	 * class equals method. here we check first if the object is a 
	 * sheep, then we check to see if they do NOT have the same weight
	 * of wool, we then check the age and name with the super Animal 
	 * class equals() method
	 * @see com.android.Animal#equals(obj)
	 * @param obj is the object the sheep calling this method is comparing itself too
	 * @return return true if have same age,name and woolWeight
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Sheep))
			return false;
		Sheep other=(Sheep)obj;
		if(woolWeight!=other.woolWeight)
			return false;
		return super.equals(obj);
	}
}
/**
 * Pig class is a Subclass of Animal and overrides the equals method, this equals method also uses the equals method
 * of the Super Animal class 
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/DUtmq4UqNGs">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @see com.android.Animal#equals(obj)
 * @author NoelF
 */
class Pig extends Animal{
	/**
	 * consturtor that takes a int age and a String name and also call a particular constructor of hte super class
	 * Animal 
	 * @param age is the age of the pig
	 * @param name is the name of the Pig
	 * @see com.android.Animal#Animal(int,String)
	 */
	Pig(int age,String name){
		super(age,name);
	}
	/***
		 * the only difference between this equals() method and the
		 * superclass Animal equals method, is that we need to ensure
		 * that the object being tested is also a pig. So if obj is
		 * NOT a pig, the method exits and returns false. if it is a
		 * Pig the code contines and  uses the super Animal class 
		 * equals method to check the age and name of the pig.
		 * @param obj the object the pig calling this method is comparing itself with
		 * @return true if same age and and name and a pig, and false in all other circumstances
		 */
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Pig))
			return false;
		return super.equals(obj);
	}
}
/*
class Pig extends Animal{
	Pig(int age,String name){
		super(age,name);
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Pig))
			return false;
		return super.equals(obj);
	}
	
}*/
/**
 * This is not a subclass of animal so it uses the Object classes equals and hashCode method
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/DUtmq4UqNGs">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
class Butterfly {
	/**name of Butterfly*/
	String name;
	/**Constructor that takes a String name
	 * @param name is the name of the butterfly*/
	Butterfly(String name){
		this.name=name;
	}
}
