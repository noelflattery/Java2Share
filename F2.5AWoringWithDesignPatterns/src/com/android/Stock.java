package com.android;
/**
 * a example of a singleton that is a stock room for a supermarket which has three test products as 
 * illustration but could be expanded to accomodate more products
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/LTNSQJKwCjM">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 */
public class Stock {
	/**
	 * as this is a singleton there should only be one created at most, this keeps a count of singletons 
	 * created so this should be at most 1
	 */
	static int counter=0;
	/**
	 * this id will be the counter variable assigned to this and will be used to unqiuely identify 
	 * the singelton
	 */
	int stockId;
	/**
	 * enum that has as its type all the products that will be stored in the shop
	 */
	private enum Products{
		/**
		 * total amount of each item held in stock
		 */
		BREAD(2000),MILK(4000),BUTTER(3000);
		/**
		 * variable that holds total amount of each product
		 */
		private int amount;
		/**
		 * amount of product on the shelf, will be a quarter
		 * of the total amount
		 */
		private int shelf;
		/**
		 * amount of product in the stock, will be 3/4 of 
		 * the total amount to start off with
		 */
		private int inStock;
		/**
		 * if we have less than half of what was originally on
		 * the shelf we will restock our shelves back to what
		 * they were at the start of the day
		 */
		private int minShelfAmt;
		/**constructor for enum*/
		private Products(int amount){
			/**sets amount of stock*/
			this.amount=amount;
			/**
			 * quarter of the total is on the shelf to start
			 * off with
			 */
			shelf=amount/4;
			/**
			 * the remaining 3/4 will be in the stock room
			 */
			inStock=amount-shelf;
			/**
			 * once below this amount it will trigger a 
			 * restock of the shelves
			 * this is 1/8 of the total amount of stock
			 */
			minShelfAmt=shelf/2;
		}//end of products constructor
		/**
		 * each time a item is scanned by a customer
		 *  at the till will
		 * decrement the amount on shelf
		 */
		private void scan() {
			--shelf;
			/*
			 * has to be taken from total amount
			 */
			--amount;
			/*
			 * if after scanning the amount on the shelf is
			 * less than the minimum shelf amount then we 
			 * order our shelves to be restocked
			 */
			if(shelf<minShelfAmt)
				stockShelf();
		}
		/**
		 * will stock the shelf with the minimum shelf 
		 * amount , which will bring the amount of goods in 
		 * the shelf up to approximate the same amount there
		 * was at the start of the day
		 */
		private void stockShelf() {
			/*
			 * will add the minimum amount to whatever is
			 * already in the shelf
			 * i.e if there are 200 loaves of bread left on
			 * the shelves there will be 250 loaves added
			 * to the shelves to bring our total on the 
			 * shelf up to 450
			 */
			System.out.println("*****stocking shelf "+this.getClass().getSimpleName());
			shelf+=minShelfAmt;
			/*
			 * we take the amount from our storeRoom
			 */
			inStock-=minShelfAmt;
			//we also have to take this from our total amount
			amount-=minShelfAmt;
			/*
			 * if the amount in the store room is less
			 * than the minimum amount we want on the shelves
			 * then we will restock our store. at this stage
			 * this will be 1/4 of the inStock we had at the
			 * start of the day
			 */
			if(inStock<minShelfAmt)
				reStock();
		}
		/**reStocks the storeroom*/
		private void reStock(){
			inStock=inStock+minShelfAmt*3;
			amount+=inStock;
		}
	
	}//end of enum
	/**our bread product we have in our shop*/
	private Products bread=Products.BREAD;
	/**our milk product we have in our shop*/
	private Products milk=Products.MILK;
	/**our butter product we have in our shop*/
	private Products butter=Products.BUTTER;
	/**the consturctor that creates all of our stock in the shop*/
	private Stock() {
		System.out.println("Stock object created");
		counter++;
		stockId=counter;	
	}
	/**runs only once and only one Stock object created*/
	private static final Stock stockInstance=new Stock();
/**
 * if this is the first thing done with the class, this will create
 * our stockInstance object
 */
	public static Stock getStock() {
		return stockInstance;
	}
	/**we print out in detail all of the items in stockroom and in shelf in our shop*/
	public synchronized void printStock() {
		System.out.println("total bread"+bread.amount);
		System.out.println("on shelf "+bread.shelf);
		System.out.println("in stock "+bread.inStock);
		
		System.out.println("total milk"+milk.amount);
		System.out.println("on shelf "+milk.shelf);
		System.out.println("in stock "+milk.inStock);
		
		System.out.println("total butter"+butter.amount);
		System.out.println("on shelf "+butter.shelf);
		System.out.println("in stock "+butter.inStock);	
	}
	/**a simple method to demonstrate what happens when a product is bought 
	 * we only have thre products so this is an array of the
	 * amounts of 
	 * bread amt[0]
	 * milk amt[1]
	 * butter amt[2]
	 */
	public synchronized void buy(int[]amt) {
		for(int i=0;i<amt[0];i++)
			bread.scan();
		for(int i=0;i<amt[1];i++)
			milk.scan();
		for(int i=0;i<amt[2];i++)
			butter.scan();
		
		
	}
	
	
	
}
