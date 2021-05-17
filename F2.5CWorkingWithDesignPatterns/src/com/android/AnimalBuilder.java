package com.android;
	/**
	 * THE BUILDER PATTERN
	 * How to create an object that requires numerous values to be set at the time the object
	 * is instantiated
	 * As applications develop your classes will be getting more atributes so you will need to add these
	 * atributes to the class, which means we have to add to our constructors or create new constructors
	 * if a constructor grows too large this can be referred to as
	 * Telescoping constructor anti-pattern
	 * a anti-pattern is a common solution to recurring problem that tends to lead to unmanageable or difficult
	 * to use code
	 * so if 50 different developers only add on new parameter to a constructor, each change is small, but taken together
	 * make it unmanageable
	 * The BUILDER pattern is a creational pattern in which parameters are passed to a builder object, often through
	 * method chaining and an object is generated with a final build call, often used with immutable objects, but it can
	 * be used with mutable objects as well
	 * if you have many constructors you can create an object where not all the values have been instantiated
	 * the Builder pattern ensures that the object will have values for all its parameters
	 * commonly used with immutable classes
	 * this approach leads to far more manageable code, if a new optional field is added to Animal, then existing code
	 * that creates objects using the AnimalBuilder class does not need to be changed
	 * Builder classes are tightly coupled with the Animal class
	 * in practice a builder class is often packaged alongside it's target class, either as a static inner class
	 * of its target class or within the same java package (advantage of this is if one changed, the other can be 
	 * quickly updated). Another advantage is you can choose to make the constructor, in this case of the Animal class,
	 * private or default, thus forcing the user to use to rely on the builder object
	 * To see video tutorial for this section of code
	 * <a href="https://youtu.be/2LTVxGL9XOI">Video tutorial</a>
	 * For all 177 videos, which cover all the topics in this course go to
	 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 */
public class AnimalBuilder {
	/**
	 * this uses the Immutable Animal class to create an Animal object
	 * when we are using a Builder class to create an object of an 
	 * Immutable class, we first DON'T create an object of the 
	 * Animal class. if we gave our Animal object's variables a value
	 * (say age and name) here, we could NOT then change the values, as 
	 * both age and name are FINAL
	 * what we do instead is we declare private versions of all the variables
	 * the Animal class will use to create an object of itself
	 * Animal has two variables name and age
	 * so what we are going to do, is create A animal from these two variables
	 */
	private String name;
	/**int that will be assigned to the age variable of the Animal class*/
	private int age;
	/**setter that assigns a value to the int age variable of the AnimalBuilder class, this will be used by the 
	 * builder method of this class to give a value to the final int age of the Animal class
	 * @param age
	 * @return
	 */
	public AnimalBuilder setAge(int age) {
		this.age=age;
		return this;
	}
	/**setter that assigns a value to the string name variable of the AnimalBuilder class, this will be used by the
	 * builder method of this class to give value to the final String name of the animal class
	 * @param name
	 * @return
	 */
	public AnimalBuilder setName(String name) {
		this.name=name;
		return this;
	}
	/**this method takes the int age and String name variables of the AnimalBuilder class, that may or may not
	 * have been given a value by the setter of this class, and assign values to the final variables of the Animal by
	 * returning a Animal using the values provided. This method also ensures that values will be provide to the 
	 * name and age variables of Animal. If the getters are not used to provide values, then a value of 0 will be 
	 * provided for the age and a value of a blank string "" will be provided for name
	 * @return
	 */
	public Animal build() {
		/*
		 * this prevents nullPointerException, because if name is null, we
		 * can't call any methods of the String class with this object and it
		 * will crash our program
		 */
		if(name==null)
			name="";
		if(age<0)
			age=0;
		/*
		 * if you are creating an object of the immutable class, the last thing
		 * you do, is create that object
		 */
		return new Animal(name,age);
	}
	

}
