package com.android;
/**
 * VegetableStorage uses Lazy Instantiation of a singleton
 * which is delaying the instantation of a the singleton until the static
 * getInstance() method is called
 * vegetableStorage could be said to be a Vegetable shed
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/LTNSQJKwCjM">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
public class VegetableStorage {
	/**
	 * a singleton using Lazy Instantation CANNOT be final
	 *  as only make it final if you can DEFINATELY SAY that this
	 * variable will be given a value.
	 * we are relying on the getInstance() method to give value to this variable.
	 * if you are relying on a method call to to give a value to a variable,
	 * it means that this variable MIGHT NOT be given a value as the method
	 * might not be called
	 */
	private static VegetableStorage instance;
	/**amount of kilos of vegetable in the vegetable shed*/
	private int quantity=100;
	/**private constructor to create a VegetableStorage object, make it private so we can't create
	 * this object outside of the VegetableStorage object
	 */
	private VegetableStorage() {
		System.out.println("VegetableStorage object created");
	}
	/**
	 * if our method calls is NOT synchronized then this is not thread safe as two different threads could then
	 * call the same method at the same time and this could result in two different singletons being created
	 * synchronized ensures that this is a UNIQUE SINGLETON
	 */
	public static synchronized VegetableStorage getInstance() {
		/*
		 * first time we cal this method instance will be NULL,so if instance is
		 * null it will create our VegetableStorage singleton, otherwise it's 
		 * not n ull and will return the VegetableStorage singleton that is 
		 * already created
		 */
		if(instance==null) {
			System.out.println("lazy instantiation of the VegetableStorage "
					+ " singleton");
			instance=new VegetableStorage();
		}
		return instance;
	}
	/**
	 *  * in practise the above method can be a memory intensive as 
	 *  you only really
	 * have to call synchronisation for the above when first creating 
	 * the singleton object
	 * we do this by the following, as if we used the getInstance 
	 * method a few thousand time
	 * that means with the previous  version we would have to 
	 * use synchronised methods thousands
	 * of times as opposed to this just a few times when first 
	 * creating a singleton
	 * THIS IS CALLED DOUBLE CHECKED LOCKING 
	 * https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
	 * for additional ways to create a singleton
	 *  we use the following syntax if we want a block to put a lock on 
			 * the object so it 
			 * cannot be accessed by another thread, this is much more 
			 * efficient than using synchronized for 
			 * the whole method. so the synchronization will only happen 
			 * first time when our instance a value of 
			 * null
			 * this is synchronizing the VegetableStorage class, which is
			 * in effect locking the VegetableStorage static singlenton called
			 * instance
			 * if you want to synchronize a block of code, inside a 
			 * static method you go
			 * Synchronized(nameOfClassCurrentlyIn.class)
			 * {
			 * 		the singleton is locked only while inside these
			 * 		curly brackets
			 * }
	 */
	public static VegetableStorage getInstance2() {
		
		if(instance==null) {
		
			synchronized(VegetableStorage.class) {
				if(instance==null) {
					instance=new VegetableStorage();
				}
			}//lock ends
		}
		return instance;
	}//end of method
	/**toString of the VegetableStorage object*/
	public String toString() {
		return "there are "+quantity+" kilos of vegetables";
	}
	/**
		 * this is the syntax we use for instance methods when we want to 
		 * synchronize a block of code inside the method
		 */
	public void addVegetable(int amount) {
		
		synchronized(this) {
			quantity+=amount;
		}
	}

}
