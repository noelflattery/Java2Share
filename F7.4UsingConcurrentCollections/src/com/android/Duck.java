package com.android;

public class Duck implements Comparable<Duck> {
	
	String name;
	Duck(String name){
		this.name=name;
	}
	
	@Override
	public int compareTo(Duck d) {
		/*
		 * this is using the compareTo() method of the string class to organise the ducks 
		 * by name alphabetically, however this one will do numbers first, then uppercase, then 
		 * lowercase alphabetically
		 * if this returns 0, the duck will have the same name as an existing Duck and will NOT be
		 *  added to the TreeSet
		 */
		return name.compareTo(d.name);
		//this will ignore case and only organise by alphabetically
	//	return name.compareToIgnoreCase(d.name);
	}

	@Override
	public String toString() {
		return "Duck [name=" + name + "]";
	}
}
	
