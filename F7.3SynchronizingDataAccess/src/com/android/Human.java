package com.android;

public class Human {
	int age;
	double weight;
	double height;
	enum Nationality{
		IRISH,POLISH,LITHUANIAN,CROATION,INDIAN,BRITISH,RUSSIAN
	}
	Nationality nation;
	
	
	Human(int age,double weight,double height,Nationality nation){
		this.age=age;
		this.weight=weight;
		this.height=height;
		this.nation=nation;
		
	}
	
	void setAge(int num) {
		age=num;
	}


	@Override
	public String toString() {
		return "Human [age=" + age + ", weight=" + weight + ", height=" + height + ", nation=" + nation + "]";
	}
	

}
