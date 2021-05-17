package com.android.plants;

import com.android.interfaces.Life;
/**
 * Flower implemetns the functional interface life
 * @author Owner
 * @see com.android.interfaces.Life
 *@see <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaduFH81xgAhqlZbx7nu-n9e">video Tutorial</a>
 */
public class Flower implements Life{

	@Override
	public void grow() {
		System.out.println("flower growing");
		
	}

}
