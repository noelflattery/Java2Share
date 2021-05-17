package com.android.animals;

import com.android.interfaces.Behaviour;
/**
 * whale class implements Behaviour, which has three abstract methods to be overidden
 * @author NoelF
 * @see com.android.interfaces.Behaviour
 *
 */
public class Whale implements Behaviour{
/**overriden method of the Behaviour interface*/
	@Override
	public void sad() {
		System.out.println("Whale sad");
		
	}
	/**overriden method of the Behaviour interface*/
	@Override
	public void happy() {
		System.out.println("whale happy");
		swim();
		
	}
	/**overriden method of the Behaviour interface*/
	@Override
	public void mad() {
		System.out.println("Whale mad");
		
	}
	/**concrete method of the Whale class that is available to Whales or sub classes of whales*/
	public void swim() {
		System.out.println("whale swimming");
	}

}
