package com.android;
/**class that runs code that shows examples of Singleton
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/LTNSQJKwCjM">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>*/
public class Examples {
	/**
		 * Singleton pattern
		 * create a single object that is shared across multiple classes. this
		 * can remove a large amount of confusion (several different objects
		 * that are essentially the same object but can have different 
		 * properties)
		 * in our case a HayStorage and a MeatStorage object.
		 * Our zoo has Animals and ZooKeepers and each of these classes 
		 * uses the same HayStorage(which would be a shed in real life) and MeatStorage
		 * (which would be a large fridge) object to keep track of
		 * how much hay and meat we have in stock. We can add meat and hay, and
		 * we can take away meat and hay
		 * we can do the exact same process for the stock in shop
		 * singleton remove the need to pass around the object
		 * this uses a static initialiser to instantiate a HayStorage object, 
		 * HayStorage object uses a private constructor called by a static method to create a 
		 * HayStorage singleton object
		 * we also can create a MeatStorage object, based on the same principles as the HayStorage but using
		 * a static initializer block to instantiate the singleton
		 * We create a VegetableStorage object, based on the same principles as HayStorage and MeatStorage
		 * but this uses lazy instantiation
		 */
	static void ex1() {
		
		System.out.println("SINGLETON PATTERN");
		//this creates the HayStorange instance object inside the HayStorage class
	//	HayStorage.getInstance();
		//this merely access the HayStorage instance object already created
	//	HayStorage.getInstance();
	//	HayStorage.getInstance();
	//	HayStorage.statMethod();
	//	HayStorage.statMethod();
		ZooKeeper zed=new ZooKeeper();
		zed.feedElephant(10);
		zed.feedElephant(20);
		
		MeatStorage zooFridge=MeatStorage.getInstance();
		//should not really use an instnace variable to call a static method, but here just showing that
		//we are accessing the same MeathStorage object throughout
		System.out.println(zooFridge.getInstance());//id is 1 and we start off with 200 kg of meat
		System.out.println(MeatStorage.getInstance());//smae fridge so we get same id and aount of meat
		zooFridge.addMeat(500);//still same fridge object with id of 1 and now has 700 kilos of meat
		zooFridge.removeMeat(100);//still same fridge object with id of 1 and now has 600 kilos of meat
		System.out.println(MeatStorage.getInstance());
		
		/*
		 * using lazy instantation of of a singleton
		 */
		VegetableStorage vegShed=VegetableStorage.getInstance2();
		//adds 10 kilos of vegetables so there is now 110 kilos in the vegShed
		vegShed.addVegetable(10);
		//110 kilos in the singleton
		System.out.println("amount of kilos in storage is "+vegShed);
		//vegShed2 is referencing the same singleton as vegShed
		VegetableStorage vegShed2=VegetableStorage.getInstance();
		//same singleton so this has 110 kilos in it
		System.out.println("using a different reference "+vegShed2);	
	}
	/**
	 * demonstrating another example of a singleton which will be the amount of stock held in a shop
	 * a quarter of the stock will be held on the shelves and three quarters of the stock will be held in
	 * the stock room
	 */
	static void ex2() {
		Stock myStock=Stock.getStock();
		myStock.printStock();
		
		int amt[]= {100,5,20};
		myStock.buy(amt);
		myStock.buy(amt);
		myStock.buy(amt);
		myStock.buy(amt);
		myStock.buy(amt);
		myStock.buy(amt);
		myStock.buy(amt);
		myStock.buy(amt);
		myStock.buy(amt);
		myStock.buy(amt);
		myStock.buy(amt);
		myStock.buy(amt);
		myStock.buy(amt);
		myStock.buy(amt);
		myStock.buy(amt);
		System.out.println("******after buying");
		myStock.printStock();
	}

}
