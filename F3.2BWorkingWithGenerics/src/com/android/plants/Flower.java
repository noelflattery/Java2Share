package com.android.plants;

import com.android.interfaces.Life;
/**super class of Rose and implements Life interface used in ex3
 * @author Owner
 */
public class Flower implements Life{
/**overridden method of the Life interface*/
	@Override
	public void grow() {
		System.out.println("flower growing");
		
	}

}
/**sub class of Flower and implements life interface and used in ex3*/
class Rose extends Flower{
/**overridden method of the Life interface*/
	@Override
	public void grow() {
		System.out.println("Rose growing");
		
	}
	
}
