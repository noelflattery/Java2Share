package com.android;

import java.io.Serializable;

public class Human implements Serializable{
	
	int age;
	String name;
	double weight;
	enum Job implements Serializable{
		DOCTOR,NURSE,TEACHER
	}
	Job myJob;
	
	Human(int age,String name,double weight,Job myJob){
		this.age=age;
		this.name=name;
		this.weight=weight;
		this.myJob=myJob;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((myJob == null) ? 0 : myJob.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Human))
			return false;
		Human other = (Human) obj;
		if (age != other.age)
			return false;
		if (myJob != other.myJob)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Human [age=" + age + ", name=" + name + ", weight=" + weight + ", myJob=" + myJob + "]";
	}
	
	
	
	

}
