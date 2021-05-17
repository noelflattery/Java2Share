package com.android.animals;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
/**this class implements Set and we provide a generic type T, which can be a Animal or a sub class of Animal, when we
 * create a Ostrich. if we do not provide any type when creating a Ostrich, type T will be Animal througout the 
 * class
 * Set is a sub interface of Collection, so this class will have all the methods
 * of the Collection interface plus the methods unique to the set Interface.
 * Set do NOT allow duplicate entries, it determines what is a duplicate by using the equals() method
 *  T type of Animal that is defined when creating an Ostrich
 */
public class Ostrich<T extends Animal>implements Set<T> {
	//interface Set<V>{}
	/**
	 * Overridden method of the Set Interface every class that implements this class has to override all these method, 
	 * Type T will be a Animal or subclass of Animal that will be set when we create an Ostrich object
	 */
	@Override
	public boolean add(T arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}


