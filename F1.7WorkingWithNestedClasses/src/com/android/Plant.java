package com.android;
/**
 * an inner class, CANNOT be a super class of it's outer class
 * here we have an inner class called "Life", and if Plant attempts
 * to extend it, it will not compile as it does recognise. the inner class
 * is PART OF THE PLANT, so logically it can't extend it
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/ygOJwcOQ2yY">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
public class Plant/* extends Life */{
	boolean flower=true;
	int age=3;
	/**
	 * if you have a instance variable, that is a object of the class you
	 * are currently in and it is given a value of a new object of that class,
	 * you will get a StackOverflowError.
	 * here we have a Plant instance variable, myPlant, inside the Plant
	 * class, if we go
	 * Plant myPlant=new Plant()
	 * what happens is the constructor is called to create a new plant, but
	 * the first that happens is that a new plant is created inside that plant
	 * which creates another plant, and on and on it goes
	 */
	Plant myPlant;//=new Plant();
/**constructor for Plant*/
	Plant(){
		System.out.println("Plant constructor called");
		//causes stackOverFlowError
		/*
		 * this also results in a stackOverFlowError, as the same thing is
		 * happening, a plant is created, which leads to another plant 
		 * being created, and on and on it goes
		 */
	//	myPlant=new Plant();
	
	}
	
	void aMethod() {
		Plant newPlant=new Plant();
		myPlant=new Plant();
	}

		
	
	
/*	public Plant(Plant myPlant, boolean flower, int age) {
	super();
	this.myPlant = myPlant;
	this.flower = flower;
	this.age = age;
}*/
	
	/**grow method of Plant class*/
	void grow() {
		System.out.println("plant growing ");
	}
	/*reproduce method of Plant*/
	void reproduce() {
		System.out.println("plant growing");
	}
	/**germinate method of Plant class*/
	void germinate() {
		System.out.println("plant germinating");
	}
	/** Tree is a sub class of Outer Plant class
	 * this is a sub class of the outer class
	 * To see video tutorial for this section of code
	 * <a href="https://youtu.be/ygOJwcOQ2yY">Video tutorial</a>
	 * For all 177 videos, which cover all the topics in this course go to
	 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 */
	class Tree extends Plant{
		
		//constructor for Tree class
		Tree(){
			System.out.println("Tree constructor called");
		//	grow();
		}
		/**overridng the germinate method of the plant class
		 * * you can create an anonymous inner class whose class extends
			 * the outer class.
			 * here we are inside the Tree class, and the Tree extends
			 * the Plant class, and we can create a Anonymous Inner
			 * tree class object
*/
		@Override 
		void germinate() {
			/*
			 
			 */
			Tree myTree=new Tree() {
				
			};
		}
		
		@Override
		void grow() {
			System.out.println("the Tree grow method");
			Tree myTree=new Tree();
		}
	}//end of inner Tree class
	/**method to call inner class objects of this class*/
	void callInners() {
		System.out.println("callInners method");
		/*
		 * you can create an instance of a inner class inside it's outer
		 * class
		 */
		Tree myTree=new Tree();
		myTree.grow();
		
		Tree anonTree=new Tree() {
			@Override
			void grow() {
				System.out.println("anonTree grow method");
				shedLeaves();
			}
			@Override
			void reproduce() {
				System.out.println("anonTree reproduce method");
			}
			
			void shedLeaves() {
				System.out.println("anonTree shedding leaves");
			}
		};
		
		anonTree.grow();
	}//end of callInners method
	/**not used in final code
	 * To see video tutorial for this section of code
	 * <a href="https://youtu.be/ygOJwcOQ2yY">Video tutorial</a>
	 * For all 177 videos, which cover all the topics in this course go to
	 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>*/
	class Life{
		
	}

}//end of Plant class
