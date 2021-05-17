package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListResourceBundle;

public class Zoo_en extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{"hello","Hello there and welcome to the zoo"},
			{"open","The zoo is open"}
		};
	}

}

class Zoo_fr extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{"hello","bonjour mon ami"},
			{"open","le zoo est ouvert"},
			{"close",new Integer(4)}	
		};
	}
	
}
