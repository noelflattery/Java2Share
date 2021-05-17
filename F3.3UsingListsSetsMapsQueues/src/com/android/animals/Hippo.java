package com.android.animals;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
/**this class implements List and we provide a generic type T when we create a Hippo
 * list is a sub interface of Colllection, so this class will have all the methods
 * of the Collection interface plus the methods unique to the List Interface.
 * Here we supply the class with a generic (the list interface has one generic in it)
 * so here we will implement the List interface with whatever generic we may supply
 * when creating our hippo. If we do not supply a generic with the creation of 
 * the Hippo, type T will be an Object
 * the list interface class declaration is as follows
 * {@code interface List<T> extends Collection<T}
 * Lists allow duplicates and like all other Collection objects can only contain themselves objects and primitives
 * are not allowed
 * T type that is defined when creating a Hippo
 */
public class Hippo<T>implements List<T> {
/**
 * Overridden method of the List Interface every class that implements this class has to override this method, 
 * Type T will be whatever type we say it is when we create a Hippo object
 */
	@Override
	public boolean add(T arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public void add(int arg0, T arg1) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public boolean addAll(int arg0, Collection<? extends T> arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public T get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public ListIterator<T> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public T remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public T set(int arg0, T arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public List<T> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Overridden method of the List Interface every class that implements this class has to override this method, 
	 * Type T will be whatever type we say it is when we create a Hippo object
	 */
	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
