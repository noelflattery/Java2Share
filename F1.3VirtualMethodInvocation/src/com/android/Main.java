package com.android;
/**
 * Virtual Method Invocation
 * A virtual method is a method that you expect and to be redefined in
 * a derived class. S
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/WfuKKSwRNbw">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 */
public class Main {
/**
		 * you can call a static method of a abstract class by using the
		 * name of the abstract class, this works because as a static 
		 * method is not tied to any individual object but instead is
		 * tied to the class. This method takes a sub class of Animal
		 * (can't take an Animal as Animal is a Abstract class),
		 * which in turn calls the right feed method for a Cow,A fish
		 * or a bird, which in turn also calls a private method in each
		 * one of the cow or fish or bird class
		 */
	public static void main(String[] args) {
		
		Animal.feedAnimal(new Cow());
		Animal.feedAnimal(new Fish());
		Animal.feedAnimal(new Bird());
		/*
		 * you can also call a static method by using the name
		 * of the subclasses of Animal class
		 */
		Bird.feedAnimal(new Cow());

	}

}
