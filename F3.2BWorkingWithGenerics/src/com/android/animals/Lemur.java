package com.android.animals;
import com.android.interfaces.Behaviour;
/**
 * class implements the Behaviour interface, a interface with no generics
 * @author NoelF
 *@see com.android.interfaces.Behaviour
 */
public class Lemur implements Behaviour{
/**overriding of the Behaviour interface sad method*/
	@Override
	public void sad() {
		System.out.println("lemur sad");
		
	}
/**overriding of the Behaviour interface happy method*/
	@Override
	public void happy() {
		System.out.println("lemur happy");
		
	}
/**overriding of the behaviour interface sad method*/
	@Override
	public void mad() {
		System.out.println("lemur mad");
		
	}

}
