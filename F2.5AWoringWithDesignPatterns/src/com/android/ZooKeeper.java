package com.android;

public class ZooKeeper {
	/**
	 * method that will use the HayStorage singleton to see if we have
	 * enough feed for each of our elephants.
	 * count is the amount of elephants we have to feed
	 * will return true if enough hay in shed and the elephants are fed,
	 * false if not
	  * To see video tutorial for this section of code
	  * <a href="https://youtu.be/LTNSQJKwCjM">Video tutorial</a>
	  * For all 177 videos, which cover all the topics in this course go to
	  * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	  * @param how many bales will be fed by the zookeeper to the Elephants, every elephant eats five bales of hay
	  * @return if the ZooKeeper sucessfully takes the amount of bales of hay from the shed and feeds them to the elephants this will retrun true, 
	  * otherwise return false
	 */
	public boolean feedElephant(int count) {
		/**
		 * each elephant eats 5 bales of hay a day, so amount *5 is the 
		 * amount of bales we need for the day
		 */
		int amountNeed=count*5;
		/**
		 * this may or may not create out HayStorage object, if its the first
		 * time the HayStorage class is being accessed then the hayStorage object
		 * called INSTANCE is created. if it was already created then this is just
		 * accessing the same object.
		 */
		HayStorage hayStorage=HayStorage.getInstance();
		hayStorage=HayStorage.getInstance();
		/**
		 * if the amount of hay that is needed is less than the amount the 
		 * zookeeper wishes to take out, add twice the amount the zookeeper needs
		 * i.e
		 * if we only have 10 bales of hay left, and the zookeeper wants 40 bales
		 * we will add 80 bales of hay, so the shed now contains 90 bales
		 */
		if(hayStorage.getHayQuantity()<amountNeed) {
			hayStorage.addHay(amountNeed*2);
		}
		/**
		 * this takes hay from the store
		 * this returns true if the hay is taken from the stroe and fed to the 
		 * Animals
		 * this returns false if the amount of hay requested is greater than the 
		 * amount in the store and the hay is not removed form the store
		 */
		boolean fed=hayStorage.removeHay(amountNeed);
		/**
		 * if fed is true, means elephants have been fed and the hay was
		 * sucessfully removed from the store
		 */
		if(fed)
			System.out.println("Elephants have been fed");
		return fed;
	}

}
