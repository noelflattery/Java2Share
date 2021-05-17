package com.android.animals;

import java.util.Collection;
import java.util.Iterator;

/**this a class that implements the Collection interface without providing a generic type
 * every class that implements Collection will have all of these overriden methods
 * you can put in generic when implementing this class
 * the Collection interface looks like the following
 * {@code Interface Collection<E>}
 */
public class Cat implements Collection{
/**overridden method of the Collection interface, every class that implements this class has to override this method
 */
	@Override
	public boolean add(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 */
	@Override
	public boolean addAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 */
	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 */
	@Override
	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 */
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 */
	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 */
	@Override
	public boolean removeAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 */
	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 */
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 */
	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
/**
 * this is a class that implements Collection and also has a Generic type T which is then used by all of the methods
 * the class implements from the Collection interface
 * @author Owner
 * @param <T> generic type can be provided for Collection when creating a Persian object, for instance
 * {@code Persian<String>myPersian}
 * then type T will be a String for all these methods
 */
class Persian<T>implements Collection<T>{
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 * and type T will be whatever type we say it is when we create a Persian Object
	 */
	@Override
	public boolean add(T arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 * and type T will be whatever type we say it is when we create a Persian Object
	 */
	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 * and type T will be whatever type we say it is when we create a Persian Object
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 * and type T will be whatever type we say it is when we create a Persian Object
	 */
	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 * and type T will be whatever type we say it is when we create a Persian Object
	 */
	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 * and type T will be whatever type we say it is when we create a Persian Object
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 * and type T will be whatever type we say it is when we create a Persian Object
	 */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 * and type T will be whatever type we say it is when we create a Persian Object
	 */
	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 * and type T will be whatever type we say it is when we create a Persian Object
	 */
	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 * and type T will be whatever type we say it is when we create a Persian Object
	 */
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
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 * and type T will be whatever type we say it is when we create a Persian Object
	 */
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	/**overridden method of the Collection interface, every class that implements this class has to override this method
	 * and type T will be whatever type we say it is when we create a Persian Object
	 */
	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
