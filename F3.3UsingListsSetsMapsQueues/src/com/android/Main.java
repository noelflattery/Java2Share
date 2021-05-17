package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import com.android.animals.Animal;
import com.android.animals.Rat;
import com.android.animals.Test2;

/**
 * we have only dealt with arraylists up to this point but there are other types of 
 * Collections.
 * Most of the lists implement the COLLECTION interface and this top level interface
 * has four sub interfaces which some of the list types implement. there are four
 * main sub interfaces of the Collection Interface.
 * LIST 
 * See {@link com.android.Examples#ex2()}
 * is a list of ordered collection of objects that allows duplicate entries. Elements
 * can be accessed by an int index
 * some of the classes that implements this interface are
 * ArrayList
 * LinkedList
 * Vector
 * Stack
 * (you can also create your own class that implements the List interface)
 * 
 * SET
 * see {@link com.android.Examples#ex7()}
 * A set is a Collection that DOES NOT allow duplicate entries
 * some of the classes that implement SET are
 * HashSet
 * LinkedHashSet
 * TreeSet
 * 
 * QUEUE
 *  See {@link com.android.Examples#ex5()}
 * Queue is a collection that orders it's elementss in a specific order for processing.
 * A typical queue processes it's elements in a first-in, first-out order but other
 * orderings are possible.
 * some of the classes that implement this interface are 
 * LinkedList
 * ArrayBlockingQueue
 * ArrayDeque (array deck)
 * PriorityQueue
 * (any class can implement multiple interfaces, which is why LinkedLIst is here as well)
 * 
 * MAP
 * See {@link com.android.Examples#ex11()}
 * A map is a collection that maps keys to values, with no duplicate keys allowed, but
 * multiple values are allowed. The elements in a  map are key/value pairs
 * (this is similar to what happens in a normalised database where each value in a 
 * database has a unique primary key to idenfity the recoord)
 * A map has two entries for every item in your collection, a key, which is unique and a
 * value which the key uniquely identifies.
 * A map is the only one, as far i know, that DOES NOT implement the Collection Interface
 *HashMap
 *@author NoelF
 */
public class Main {
/**
 * our main method
 * @param args
 */
	public static void main(String[] args) {
	//	Examples.ex1();
	//	Examples.ex2();
	//	Examples.ex3();
	//	Examples.ex4();
	//	Examples.ex5();
	//	Examples.ex6();
	//	Examples.ex7();
	//	Examples.ex8();
	//	Examples.ex9();
	//	Examples.ex10();
	//	Examples.ex11();
	//	Examples.ex12();
	//	Examples.ex13();
	//	Examples.ex14();
	//	Examples.ex15();
	//	Examples.muck();
		
		
		
		
	/*	HashSet<Animal>animalHash=new HashSet<>();
		Rat ronnie=new Rat(4,"ronnie");
		Rat rachel=new Rat(4,"rachel");*/
		/*
		 * we have overriden the equals method but NOT the hashCode method and HashSet uses both equals
		 * and HashCode() to determine if both objects are the same
		 */
/*		System.out.println("two rats same age "+ronnie.equals(rachel));
		System.out.println("rats added to Animal set"+animalHash.add(ronnie));
		System.out.println("rats added again to Animal set"+animalHash.add(rachel));
	*/	
	/*	HashSet<Rat>ratSet=new HashSet<>();
		System.out.println("rats added to Rat set "+ratSet.add(ronnie));
		System.out.println("rats added to Rat set "+ratSet.add(rachel));
		
		List<Integer>numbers=new ArrayList<Integer>();
		numbers.addAll(Arrays.asList(22,33,44,55,66,77,88));
		List<Integer>integers=new ArrayList<Integer>(numbers);
		List<Integer>numbers2=new ArrayList<Integer>();
		numbers2.addAll(numbers);
		Set<Integer>hashInt=new HashSet<>(numbers);
		System.out.println(numbers.equals(integers));
		System.out.println(numbers.equals(numbers2));
		numbers2.clear();
		ArrayList<Integer>arrayListInt=new ArrayList<Integer>();
		arrayListInt.addAll(Arrays.asList(20,30,40,50,60,70));
		numbers2.addAll( (Collection<? extends Integer>) arrayListInt.clone());//=(List<Integer>) arrayListInt.clone();
		System.out.println(numbers2.equals(arrayListInt));
		
		List<Animal>anList=new ArrayList<Animal>();
		anList.addAll(Arrays.asList(new Animal(),new Animal(2,"andy"),new Animal(3,"angela")));
		ArrayList<Animal>arrListAn=new ArrayList<>(anList);
		System.out.println(arrListAn.equals(anList));
		anList.clear();
		anList.addAll(arrListAn);
		System.out.println(anList.equals(arrListAn.clone()));
		System.out.println(anList.equals(arrListAn));
		
		*/
		
	/*	Test2 myTest=new Test2(3,"test");
		Test2 copyTest=null;
		try {
			copyTest=myTest.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception caught");
		}
		System.out.println(myTest.equals(copyTest));
		*/
		
		
		
		
		
		

	}

}

class Test<T extends Animal>{
	
	void method1(T myT) {
		System.out.println(myT.getClass().getSimpleName());
	}
}
