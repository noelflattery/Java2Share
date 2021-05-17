package com.android.animals;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * class that implements the Map interface
 * each entry in Map has a Key and a Value, a key is something that unquiely identifies a entry and it corresponds
 * to a value. A duplicate value can appear in a map, but a duplicate key CANNOT
 * an example of  key value pair is a Car, which would be the value and the Car's registration, which would be the key
 * another example is a key value pair of a Employee, which would be the value, and the Employee's PPS number, 
 * which would be the key
 * closely resemble Primary key and values in realtional databases (see chapter 10 examples)
 * @author Owner
 * @param <K> generic type that is defined when creating a Rhino
 * @param <V> generic type that is defined when creating a Rhino
 */
public class Rhino<K,V>implements Map<K,V> {
//interface Map<K,V>{}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K arg0, V arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V remove(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

}

interface Mood{
	
}

interface Emotions extends Mood{
	
}
//this is NOT multiple inheritance, this is multiple implemenation
interface Movement extends Mood,List{
	
}
