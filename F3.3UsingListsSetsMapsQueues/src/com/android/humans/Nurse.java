package com.android.humans;
/**
 * Nurse class that will be used in conjunction with method ex12
 * {@link com.android.Examples#ex12()}
 * @author NoelF
 */
public class Nurse {
/**name of Nurse*/
	String name;
/**
 * Constructor that takes a String name	
 * @param name is the name of hte Nurse
 */
	public Nurse(String name) {
		this.name=name;
	}
/**
 * will have same hashCode if have two nurses have the same name
 * @return will return a int number and will return the same number if two nurse have the same name (case sensitive
 * so "Mary" is NOT the same as "maRy"
 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
/**
 * if two nurses have the same name, this equals method will say that the nurses are the same
 * @param obj is the object the nurse calling this method is comparing itself too
 * @return returns true if same obj and nurse calling method are the same, returns true if have the same name
 * (case sensitive), returns false if otherwise
 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Nurse))
			return false;
		Nurse other = (Nurse) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Nurse [name=" + name + "]";
	}
	
	
	
	
}
