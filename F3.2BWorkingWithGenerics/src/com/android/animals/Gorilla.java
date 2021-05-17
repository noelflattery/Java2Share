package com.android.animals;

import com.android.interfaces.Life;
import com.android.interfaces.Manners;
/**this class implements Manners {@code interface Manners<T extends Animal,V extends Life>}
 * Gorilla knows that type T and type V of Manners interface has to be a Animal
 * for type T and a object that implements the Life interface for type V
 */
public class Gorilla implements Manners{
/**overridding method of the Manners interface*/
	@Override
	public void thankYou(Animal t) {
		// TODO Auto-generated method stub
		
	}
/**overriding method of the Manners interface*/
	@Override
	public void sorry(Animal t, Life v) {
		// TODO Auto-generated method stub
		
	}

	

}
