package com.bundle;

import java.util.ListResourceBundle;
/*
 * this is our own properties class, your own properties class has to extend the 
 * ListResourceBundle abstract class. also each of these classes have to be a public class
 * which means they have to be in they're own class of the same name.
 * the advantage of these over properties files or the inbuilt java properties class is that both
 * key and value can be ANY DATA TYPE, also they do not have to match
 * ie key is a String
 * value is a Dog
 * key is a List of Integers
 * value is a Person
 */
public class Farm_en extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		String[][]twoDarray= {
				{"hello","hello and welcome to our farm"},
				{"open","the farm is now open for business"}
		};
		return twoDarray;
	}

}
