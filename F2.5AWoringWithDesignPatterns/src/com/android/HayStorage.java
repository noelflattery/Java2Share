package com.android;
/**
 * this is a class that creates a singleton that will store the amount of hay stored for the Zoo
 * different zookeepers can add or take bales of hay from HayStorage, but it will be the same
 * HayStorage object, a real world HayStorage object would be a single Hay Shed that a zoo uses to store
 * the hay for all of they're animals.
 * this class uses a static method calling a private user created constructor to create the HayStorage object
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/LTNSQJKwCjM">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
public class HayStorage {
	/**this will show how many HayStorage objects have been created and we use this to check that no more
	 * than one HayStorage object is ever created
	 */
	private static int counter=0;
	/**this will be used to uniquely identify our singleton and if one is created this variable should
	 * only read 1, once a singleton is created counter is incremented by 1 and assigned to the variable
	 * id, so this should be at a max 1 if this is a singleton
	 */
	private int id;//uniquely identify the singleton
	
	String myStr;//this is null
	/**showing a non static initialiser that runs BEFORE a constructor, 
	 * as this runs Before a constructor again this should only be run ONCE, so this is another check
	 * to see if only one Singleton is created
	 */
	{
		System.out.println("non static initialiser called");
	}
	/**
	 * this initialiser can only access statics directly and will ALWAYS onlye
	 * run ONCE. Any interaction with the HayStorage class, for the first time,
	 *  will cause this initialiser to run. this is the structure we will use to create a
	 *  singleton using the MeatStorage class
	 */
	static {
		System.out.println("static initialiser called");
	}
	/**
	 * the amount of Hay bales we have in store at any one time.
	 * we will start off with the quantity of 100 (we could get this initial
	 * value from a database to start off at start of the day and the value
	 * at the end of the day will be stored in the database)
	 * this is the quantity at the start of the day
	 * this is the amount of bales in our Shed(HayStorage object)
	 */
	private int quantity=100;
	/**
	 * private constructor ensures we can't create a new singleton object 
	 * outside of the class. As this is now the ONLY way to create a HayStorage
	 * object we can't create a HayStorage object directly outside of the class
	 * we increment our counter inside the constructor to so the counter should be at a max of 1
	 * if a haystorage is a singleton
	 */
	private HayStorage() {
		//if this is a true singleton, we should only see this message ONCE
		System.out.println("HayStorage object created");
		/*
		 * this increments our counter, and sets the id of singleton to be
		 * whatever the counter is. so if the id of the singleton is more than
		 * 1, its means more than one object has been created and it's 
		 * not a singleton
		 */
		counter++;
		//id should be 1
		id=counter;
	}
	/**
	 * this is a final object, which means you can't change what the instance
	 * object refers too. it will always refere to the same HayStorage()
	 * object instance. However we can change the the vaiables of a Final
	 * object, so we CAN change the quantity of the HayStorage object.
	 * here we are instantiating the HayStorage singleton directly.
	 * it private, which means we can't access it outside of the class, so
	 * we won't be able to modify it outside of the class. Its static so
	 * when we access the class, for the very first time, this static will
	 * be given a value, however this happens ONCE and only ONCE. as this is a
	 * static initialised value it will run the first time the class is accessed
	 * in any way. this will NOT run again.
	 * another reason to make it static is you can't create an instance outside
	 * of this class, so we can't access this variable via an instance method,
	 * as instance methods can only be access by objects of the HayStorage class.
	 * So we are accessing this via a static method
	 * "instance" is just a variable name
	 */
	private static final HayStorage instance=new HayStorage();

	/**
	 * when accessing via a static method,for the first time, we go
	 * HayStorage.getInstance(). Statics are instatiated the VERY FIRST TIME WE ACCESS A CLASS IN ANY WAY
	 * this causes ALL the statics in this class to be given values, including
	 * private static final HayStorage instance=new HayStorage();
	 * every subsequent call of 
	 * HayStorage.getInstance() 
	 * will NOT cause the statics in the class to be given values, it will
	 * use whatever values the statics currently  have
	 * your singleton needs to have three things to work
	 * **Constructor must be private
	 * **you have to create an object of the class inside the singleton class
	 * that is private static and final
	 * **you have to have a static method that access the private static final
	 * variable (first time it runs it will create singleton, subsequent times
	 * it is run it will just access the singleton
	 * @return this returns the singleton
	 */
	public static HayStorage getInstance() {
		System.out.println("getInstance called");
		//this wil show amount of objects created
		System.out.println("id of object is "+counter);
		return instance;
	}
	/**
	 * this method adds more hay to the quantity of hay already in the 
	 * HayStorage object.
	 * synchronized is for use in Threads and ensures that no two threads can
	 * access the same method at the same time
	 * (threads are covered in chapter 7, threads are lines of control 
	 * that run through your program,
	 * up to this we have used singles threads, but you can have multiple 
	 * lines of control going through your
	 * program at the one time).
	 * this also means that the object calling this method is 
	 * locked and can't be accesed by other methods when 
	 * this method is in progress, meanin the amount can't be 
	 * modified while this method is using the object.
	 * If a static method is synchronized it means that the static 
	 * variables and static methods used by it are 
	 * locked, NOT the non static variables and not static methods
	 * @param amount the amount of hay added to shed
	 */
	public synchronized void addHay(int amount) {
		System.out.println(amount+" hay added");
		quantity+=amount;	
	}
	/**
	 * when a zookeeper gives some hay to one of the Animals this method 
	 * is called. If the amount the Zookeeper wants to use is greater than the
	 * quantity of hay in our shed, then this will return false and the 
	 * Zookeeper will not be allowed to take out that amount of Hay.
	 * making your method synchronized minimises the chances of more than one thread accessing
	 * your method at one time (if more than one thread can access this method then its possible this
	 * could result in two different zookeepers trying to remove hay bales at the same time.
	 * @param amount the amount of hay to be removed from the shed
	 * @return will return true if hay removed successfully false if not
	 */
	public synchronized boolean removeHay(int amount) {
		if(quantity<amount) {
			System.out.println("there is not enough hay in the store for "
					+ "the amount requested");
			return false;
		}
		/*
		 * if the amount of ahy the zookeeper wants does NOT EXCEED the amount
		 * of hay in the shed then he takes that amount from the hay in the
		 * shed and returns true
		 */
		quantity-=amount;
		System.out.println(amount+" hay removed");
		return true;
	}
	/**
	 * return the quantity of hay in the HayStorage object, or our hay shed
	 * in the zoo
	 * quantity is a private variable, so we acess it via a public method
	 * @return returns the amount of hay in the shed
	 */
	public synchronized int getHayQuantity() {
		return quantity;
	}
	
	static void statMethod() {
		System.out.println("statMethod called");

	}

}
