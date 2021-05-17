package com.android;

public class Human {
	enum Gender{
		Male,Female
	}
	
	String name;
	Gender myGender;
	
	Human(String name,Gender myGender){
		this.name=name;
		this.myGender=myGender;
	}

}
