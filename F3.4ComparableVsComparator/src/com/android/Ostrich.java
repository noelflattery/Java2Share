package com.android;
/**
 * Ostrich class implements Comparable which means it has a CompareTo method and can be inserted into a 
 * TreeSet
 * Ostrich implements the Comparable interface and provides a type of {@code <Ostrich>}, which means that
 * the compareTo method will also take a Rat
 * {@code public int compareTo(Ostrich r)}
 * if a mehtod is implementing the comparable interface you should also override the hashCode and equals() method
 * (as if you don't your code will use the equals() method and hashCode() method of the Object class to determine
 * if two objects are the same)
 * this is used in Examples.ex2() method
 * @author Owner
 *{@link com.android.Examples#ex2()}
 */
public class Ostrich implements Comparable<Ostrich>{
	/**id to uniquely identify an ostrich*/
	int id;
	/**name of Ostrich*/
	String name;
	/**age of ostrich*/
	int age;
	/**weight of ostrich*/
	double weight;
	/**keeps count of the amount of ostrichs created and also give value to id*/
	static int counter=0;
	/**
	 * Constructor that takes a String name, int age and a double weight
	 * also increments the counter and uses this value to give id a value
	 * @param name is the name of the Ostrich
	 * @param age is the age of the Ostrich
	 * @param weight is the weight of the Ostrich
	 */
	Ostrich(String name,int age,double weight){
		this.age=age;
		this.name=name;
		this.weight=weight;
		id=++counter;
	}
	/**
	 * Overridden hashCode that is produced on the age, name, weight and id of the Ostrich
	 * @return produces a number based on the age, name,weight and id of the Ostrich
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	/**
	 * Overridden equals method that is says if a two Ostrichs have the same name,age,id and weight they will be said
	 * to be the same
	 * @return true is same Ostrich or if have same name, age,id and weight, false in all other circumstances
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Ostrich))
			return false;
		Ostrich other = (Ostrich) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
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
	/**
	 * this method will be called by one ostrich and sent another Ostrich,
	 *  which will then compare first by 
	 * name
	 * if they have the same name will then compare them by
	 * age
	 * if they have the same age will then compare them by 
	 * weight
	 * if they have the same weight then will compare them by
	 * id
	 * The method returns an number, and the following is an explanation of what the numbers means
	 * We have two Ostrichs, o1 and o2, o1 is calling the compareTo method on o2
	 * {@code o1.compareTo(o2)}
	 * and we will use for instance the metric of age
	 * if o1 is older than o2 or put another way {@code o1.age > o2.age}
	 * then method returns 1
	 * if o1 is younger than o2 or put another way {@code o1.age<o2.age}
	 * then method returns -1
	 * if o1 is the same age as o2 or put another way {@code o1.age==o2.age}
	 * then method returns 0
	 * with a TreeSet, if a o1.compareTo(o2) returns 0, o2, will NOT be inserted
	 * if o1.compareTo(o2) returns 1, o1 and o2 will be inserted and o1 will be placed in the set BEFORE o2
	 * if o1.compareTo(o2) returns -1, o1 and rs will be inserted and o1 will be place in the set AFTER o2
	 * @param o is the Ostrich the Ostrich calling the method is comparing itself with
	 * @return if two Ostrichs the same return 0, 
	 * if first Ostrich greater than second Ostrich, return 1
	 * if first Ostrich less than second Ostrich, return -1
	 */
	@Override
	public int compareTo(Ostrich o) {
		if(this.equals(o))
		return 0;
		//comparing strings
		if(!(name.equals(o.name)))
			return name.compareTo(o.name);
		Integer age1=age;
		Integer age2=o.age;
		if(!(age1.equals(age2)))
			return age1.compareTo(age2);
		Double weight1=weight;
		Double weight2=o.weight;
		if(!(weight1.equals(weight2)))
			return weight1.compareTo(weight2);
		Integer id1=id;
		Integer id2=o.id;
		return id1.compareTo(id2);
	//	return 0;
	}
/**
 * overridden method that prints out id, name age and weight of Ostrich
 * @return returns a string with id, name, age and weight
 */
	@Override
	public String toString() {
		return "Ostrich [id=" + id + ", name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	
	
	
	

}
