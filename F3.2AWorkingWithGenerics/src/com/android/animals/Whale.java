package com.android.animals;

import com.android.interfaces.Behaviour;
/**
 * class that will be used in conjuction with the Bucket class which has 
 * as it's class declaration 
 * {@code class Bucket <T extends Behaviour>}
 * A bucket object can be created with a Whale as Whale implements Behaviour
 * @see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 * @author Owner
 */
public class Whale implements Behaviour{
/**Overriding the sad method of the Behaviour interface*/
	@Override
	public void sad() {
		System.out.println("Whale sad");
		
	}
/**Overriding the happy method of the Behaviour interface*/
	@Override
	public void happy() {
		System.out.println("whale happy");
		swim();
		
	}
/**Overriding the mad method of the Behaviour interface*/
	@Override
	public void mad() {
		System.out.println("Whale mad");
		
	}
/**method of the Whale class, this method will only be available to whales and subclasses of whales*/	
	public void swim() {
		System.out.println("whale swimming");
	}

}
