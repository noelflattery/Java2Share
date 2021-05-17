package com.android.animals;

public class Dinosaur {
	int age;
	String name;
	double weight;
	double height;
	public enum Type{
		CARNIVORE,HERBIVORE,OMNIVORE
	}
	Type type;
	
	public Dinosaur() {
		
	}

	public Dinosaur(int age, String name, double weight, double height, Type type) {
		super();
		this.age = age;
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Dinosaur))
			return false;
		Dinosaur other = (Dinosaur) obj;
		if (age != other.age)
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	

}
