package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
/**class that hold examples that illustrates some of the common concepts of Collections
 * All Collections hold OBJECTS and cannot hold primitives, if you place a primitive in a Collection object
 * it is autoboxed to become a wrapper object and then placed in a Collect
 * i.e place an int into a arraylist, it's autoboxed to become a Integer wrapper and placed in the arraylist*/
public class Examples {
	/**introduction to the list interface and how class that implements the list interface can only take
	 * objects, and how it's resizable.
	 * usage of add() and addAll() is covered and also how when we create an list from an array you essentially
	 * have a list where you cannot change the size of this list, unlike a normal list.
	 */
	static void ex1() {
		/*
		 * All collections can only house Objects
		 */
		/*
		 * ArrayList class implements the List Interface
		 */
		List<String>fruits=new ArrayList<>();
		System.out.println("add");
		fruits.add("Apple");
		fruits.add("orange");
		System.out.println("addAll");
		/*
		 * this is for adding multiple elements to an arraylist
		 */
		String[]names= {"pat","mary","shelly"};
		/*
		 * addAll can only take collection objects, which are Lists, Queues,Sets and Maps
		 */
	//	fruits.addAll(names);
		fruits.addAll(fruits);//this will be a list of "apple","orang","apple","orange"
		/*
		 * Arrays.asList takes an array and converts it to a List, which we can then add
		 * to our existing list called fruits
		 */
		fruits.addAll(Arrays.asList(names));
		System.out.println(fruits);
		
		
		/*
		 * this is one way to add a number of string elements to our list at the one time
		 */
		fruits.addAll(Arrays.asList("banan","pineapple","raspberry","strawberry"));
		fruits.add("mango");
		System.out.println(fruits);
		
		List<Animal>animalList=Arrays.asList(new Animal("cow"),new Animal("sheep"),
				new Animal("pig"));
		System.out.println(animalList);
		
		/*
		 * this is a list that was created with an Array
		 * Arrays.asList(new Animal("cow"),new Animal("sheep"),
				new Animal("pig"));
			which means that its' backbone is an array, and you can't add a new element to an
			array (you can't change it size). so add() will not work for this List
		 */
		//this will throw UnsupportedOperationException
		//animalList.add(new Animal("chicken"));
		/*
		 * remove also does not compile, as again we are trying to resize the array that is 
		 * the backbone of this list, will also throw UnsupportedOperationException
		 */
		//animalList.remove(0);
		/*
		 * so if we want to add to a list, we first create the List and we assign it to
		 * class that implements the List interface, here we have a list interface to a 
		 * ArrayList object
		 */
		List<Animal>zoo=new ArrayList<>();
		/*
		 * then we can add groups of objects to this list using the Arrays.asList() method
		 * call
		 */
		zoo.addAll(Arrays.asList(new Animal("Monkey"),new Animal("lion"),new Animal("Penguin")));
		/*
		 * and we can add more objects to this class
		 */
		zoo.add(new Animal("swan"));
		System.out.println(zoo);
		
		List<String>places=new ArrayList<String>();			
	}//end of ex1
	/**more on list made from array and introduction to some Java 8 Streams functional programming
	 * that can be used to create lists and to filter them using removieIf and to create and filter lists
	 * using Stream.generate and filiter() and limit()
	 */
	static void ex2() {
		List<String>places=new ArrayList<String>();
		//we can add elements to places
		places.addAll(Arrays.asList("Galway","Dublin","Cork","Limerick","Belfast"));
		//we CANNOT add elements to towns
		List<String>towns=Arrays.asList("Roscommon","Mayo","Leitrim","Wexford");
		places.addAll(towns);
		System.out.println(places);
		//towns.remove(0);
		places.remove("Roscommon");
		System.out.println(places);
		places.removeAll(towns);
		/*
		 * this will remove the town's "Roscommon","Mayo","Leitrim","Wexford"
		 * 
		 */
		System.out.println(places);
		
		List<Integer>numbers=new ArrayList<Integer>();
		Stream.generate(()->(int)(Math.random()*100)).limit(20).forEach(a->numbers.add(a));
		//a arraylist of 20 random numbers between 1 and 100 is created
		System.out.println(numbers);
		/*
		 * removeIf takes a predicate, and tests for some condidtion for each number, and 
		 * if that condition is true for that number, then it removes the number from the 
		 * list
		 * here we are testing to see if each number is greater than 50, if it is, then it's 
		 * removed from the list
		 */
		numbers.removeIf(
				a->{
			
			return a>50;
			}
		);
		System.out.println(numbers);
		numbers.clear();
		Stream.generate(()->(int)(Math.random()*100)).limit(20).forEach(a->numbers.add(a));
		System.out.println(numbers);
		
		/*
		 * removeIf takes a preidcate and this is a shortened predicate
		 */
		numbers.removeIf(a->a>50);
		System.out.println("number less than 50");
		System.out.println(numbers);	
		numbers.clear();
		/*
		 * here we are using the Stream method filter() which takes a predicate and will filter
		 * out any items of the stream that match what we are looking for, so here
		 * if the number is greater than 50 and the number is odd (if the modulus 2 is greater
		 * than 0, which will mean its odd), this will return true and the number is removed
		 */
		Stream.generate(()->(int)(Math.random()*100)).filter(a->{
			if(a>50)
				return a%2>0;
			return false;})
		.limit(20).forEach(a->numbers.add(a));
		System.out.println(numbers);
	}
	/**
	 * this covers searching and sorting of arrays by using Arrays.sort() and Arrays.binarySearch() and how
	 * this only works with primitive numbers, chars and only those classes that implement the 
	 * Comparable interface(see Human class). InBuilt classes such as Strings and Wrapper classes all implement
	 * the Comparable interface so they can be used 
	 */
	static void ex3() {
		System.out.println("Searching and Sorting");
		int[]numbers= {6,9,1,8};
		for(int n:numbers)//print out in order they were inserted
			System.out.println(n);
		//List<Integer>list=Arrays.asList(3,4,5,6);
		/*
		 * this sorts the array in it's natural order (for numbers is ascending)
		 */
		Arrays.sort(numbers);
		for(int n:numbers)//print out in order they were inserted
			System.out.println(n);
		
		System.out.println("using BinarySearch");
		/*
		 * this method of the Arrays class searches for a particular naumber and returns 
		 * the position, in array numbering, of where the number is in our array
		 */
		System.out.println(Arrays.binarySearch(numbers, 6));//position 1
		System.out.println(Arrays.binarySearch(numbers, 8));//position 2
		/*
		 * 23 if it was in the array, would be at index position 4, which is the 
		 * 5th number in the list, so this will then show up as -5
		 */
		System.out.println(Arrays.binarySearch(numbers,23));
		/*
		 * 7 if it was in the array, would be at index position 2, which is the
		 * 3rd number in the list, so this will show up as -3
		 */
		System.out.println(Arrays.binarySearch(numbers, 7));
		/*
		 * binarySearch will work on a unsorted, however it has to search ALL of the
		 * numbers, its doing a basic linear search
		 * if you are going to use binarysearch, sort the array FIRST, then use
		 * binarySearch.
		 * binarySearch does not necessarily find the first instance of the number we are
		 * looking for
		 * i.e here we sort our array and it become
		 * 33334
		 * binarySearch splits the array in two, and searches the middlle number of the 
		 * array, and it is the number 3, which is at index position 2
		 * if you wanted to find the first 3, then don't use binarySearch
		 * 
		 */
		int[]numbers3= {3,3,3,4,3};
		Arrays.sort(numbers3);
		for(int n:numbers3)
			System.out.println(n);
		System.out.println("searching for 3");
		System.out.println(Arrays.binarySearch(numbers3, 3));
		/*
		 * sort and binarySearch works with all primitive numbers, chars, but not booleans
		 * sort and binarySearch ONLY works with classes of objects that imeplement the
		 * Comparable inteface
		 * String class implements the Comparable interface
		 * symbols first
		 * then numbers
		 * then capitals
		 * that alphabetical ascending
		 */
		String[]names= {"pat","mary","Zebedee","sean","angela","peter","1michelle","**"};
		Arrays.sort(names);
		for(String s:names)
			System.out.println(s);
		Animal[]zoo= {new Animal("Ostrich"),new Animal("Lion")};
		/*
		 * the Animal class DOES NOT implement the Comparable interface, so a array of
		 * Animals cannot be sorted using the Arrays.sort method, or by using any of the methds
		 * for the various collections that sort and search
		 */
		/*
		 * this generates a ClassCastException as the Animal class DOES NOT implement
		 * the Comparable interface (see MyList class for a class that implements the
		 * Comparable interface)
		 */
	//	Arrays.sort(zoo);
	//	System.out.println();
		
		List<Integer>integers=Arrays.asList(145,23,27,2,44,21);
		/*
		 * to use with ArrayLists we use Colletions.sort(
		 * there is a sort() method for list,sets and maps, but that takes something called
		 * a Comparator, which we have not covered yet, it's an alternative to the Comparable
		 * inteface
		 * Collections.sort takes any list,set or map
		 */
		Collections.sort(integers);
		System.out.println("sorted list");
		System.out.println(integers);
		/*
		 * we are only guranteed that this will find the number 2, if we have more than one
		 * number 2, it may be the first number 2 or it may not
		 */
		System.out.println(Collections.binarySearch(integers, 2));//0
		System.out.println(Collections.binarySearch(integers, 145));//5
		System.out.println(Collections.binarySearch(integers, 143));//-6	
	}
	/**using lists with Wrapper objects and specifically the remove() method uses the equals() method to first
	 * find a object in a list and then remove it from the list
	 */
	static void ex4() {
		System.out.println("Wrapper Classes");
		/*
		 * only objects can be added to classes that implement the comparable interface
		 * (lists,sets, maps), so when we attempt to add a primitve the primitive is actually
		 * autoboxed to become a wrapper object
		 */
		List<Integer>ints=new ArrayList<Integer>();
		/*
		 * 4 is autoboxed to become a Integer wrapper object
		 */
		ints.add(4);
		//lists allow duplicates
		ints.addAll(Arrays.asList(16,8,99,12,4,3,2,4,5));
		System.out.println(ints);
		//this removes the number at index position 2, which is 8
		ints.remove(2);//removes 8
		System.out.println(ints);
		
		ints.remove(new Integer(16));//this will remove the integer object that contains 16
		Integer myInt=12;
		//will print true
		System.out.println(ints.remove(myInt));;//this will remove the integer object that contains 12
		System.out.println(ints);
		/*
		 * if it does not find the nubmer to remove, it returns false
		 */
		System.out.println(ints.remove(myInt));
		
		Animal spot=new Animal("spot");
		Animal tibbles=new Animal("tibbles");
		Animal harry=new Animal("harry");
		
		List<Animal>animalList=new ArrayList<Animal>();
		animalList.addAll(Arrays.asList(spot,tibbles,harry));
		animalList.add(spot);
		animalList.add(tibbles);
		animalList.add(harry);
		/*
		 * remove uses the equals() method to find a match, 
		 */
		System.out.println("AnimalList");
		//that removes the first spot
		System.out.println(animalList.remove(spot));
		//second spot is still there
		System.out.println(animalList);
		//this will remove the second animal harry
		animalList.remove(1);
		System.out.println(animalList);
		Animal newAnimal=new Animal("spot");
		
		System.out.println(animalList.remove(newAnimal));
		System.out.println(newAnimal.equals(spot));
		;
		Human henry=new Human("henry");
		Human helen=new Human("helen");
		Human herbert=new Human("Herbert");
		List<Human>humanList=new ArrayList<Human>();
		humanList.addAll(Arrays.asList(henry,helen,herbert,henry,helen,herbert));
		System.out.println(humanList.remove(henry));
		/*
		 * Human class has it's own equals() method, if two names are the same of two 
		 * humans, then it returns true, and this will be removed from our list of
		 * humans
		 */
		System.out.println(humanList);
		/*
		 * new human with same name as human already in list
		 */
		Human newHuman=new Human("henry");
		/*
		 * using the equals method of the Human class will remove the human in the list with
		 * the name of henry
		 */
		System.out.println(humanList.remove(newHuman));
		
		System.out.println(humanList);
		
		
	}
	/**
	 * This is a brief intro to the next topic of Generics and how this pertains to Lists
	 */
	static void ex5() {
		/*before java 5 all you had was arraylists of OBJECTS and nothing else
		 * this list can contain ANY object, however you can't call any methods of
		 * the subclasses of object, you could only call methods of the Object.
		 * you would not know by looking at the code what this list contains (say it was
		 * STrings, Humans,Animals, etc). the only way you would know is if it was 
		 * documented somewhere
		 */
		List names=new ArrayList();
		/*
		 * after java 5, we have generics, which helps enforce the assumption that your 
		 * list contains a certain data type, in this case. it changes the references of
		 * the list, 5 and 6 had to do both <String> on both left and right hand side
		 */
		List<String>names2=new ArrayList<String>();
		/*
		 * after java 7 you could write the shortened version using the DIAMOND OPERATOR
		 * <>
		 * on the right hand side, however this can cause in certain circumstances, LOSS
		 * OF TYPE information, which will be covered in we come to generics in the next
		 * section
		 */
		List<String>names3=new ArrayList<>();
		
	}

}
