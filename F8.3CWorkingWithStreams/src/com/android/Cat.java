package com.android;

import java.io.Serializable;

public class Cat implements Serializable{
	
	String name;
	
	Cat(){
		name="tibbles";
	}

	@Override
	public String toString() {
		return "Cat name=" + name + "]";
	}
	

}
