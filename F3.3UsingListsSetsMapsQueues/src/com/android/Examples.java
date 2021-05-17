package com.android;

import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.android.animals.Animal;
import com.android.animals.Behaviour;
import com.android.animals.Cat;
import com.android.animals.Collie;
import com.android.animals.Dinosaur;
import com.android.animals.Dinosaur.Type;
import com.android.animals.Dog;
import com.android.animals.FieldMouse;
import com.android.animals.Hamster;
import com.android.animals.Hippo;
import com.android.animals.Mouse;
import com.android.animals.Rat;
import com.android.humans.Fireman;
import com.android.humans.Human;
import com.android.humans.Nurse;
/**class that contains all our comprehensive code samples for Collections and HashMap*/
public class Examples {
	
	/**
	 * you can create your own Collection classes
	 * see Cat class to see implementation of the Collection interface
	 * see Hippo class to see implementation of the List interface
	 * See Ostrich class to see the implementation of the Set interface
	 * see Falcon class to see the implementation of the Queue interface
	 * see Rhino class to see the implementation of the Map interface
	 * All classes in com.android.animals
	 * this method shows a introduction to some collection interface methods
	 * @see com.android.animals.Hippo
	 * @see com.android.animals.Ostrich
	 * @see com.android.animals.Falcon
	 * @see com.android.animals.Rhino
	 */
	static void ex1() {
		System.out.println("***ex1");
		/*
		 * Cat class did not specify a generic in teh class declaration 
		 * Cat class implements Collection, so methods in this class will take
		 * a Object
		 */
		Cat tibbles=new Cat();
		/*
		 * you can't create a Cat with a generic type as a generic type was not
		 * included in the class declaration
		 */
		/*
		 * Hippo DID specify a generic which is then passed to the Collection interface
		 * and that becomes the type used in methods of the Collection interface
		 * i.e add()
		 */
		Hippo<String>harry=new Hippo<>();
		harry.add("hello");
		harry.add("banana");
		//this will not compile
		//harry.add(new Cat());
		/*
		 * if you dont' specify a type then the generic is a OBJECT and we can add
		 * ANY object to this hippo
		 */
		Hippo helen=new Hippo();
		helen.add("hello");//adding string
		helen.add(new Animal());//adding a Animal
		helen.add(new ArrayList<Integer>());//adding an arrayList
		
		System.out.println("add() method");
		//this is an arrayList of Strings
		List<String>strList=new ArrayList<>();
		strList.add("one");
		strList.add("apple");
		strList.add("sheep");
		/*
		 * can also add at a particular index position
		 */
		System.out.println(strList);
		/*
		 * remember it's array Numbering, so starts at 0
		 */
		strList.add(1, "orange");
		strList.add("orange");
		/*
		 * puts in "orange" between "one" and "apple"
		 */
		System.out.println(strList);
		
		System.out.println("introduction to Set");
		/*
		 * A hashset does NOT allow duplicates
		 * HashSet implements the Set interface
		 */
		Set<String>strSet=new HashSet<>();
		//add returns a boolean, true if inserted, false if not
		System.out.println(strSet.add("orange"));//true
		System.out.println(strSet.add("orange"));//false
		System.out.println(strSet.add("apple"));//true
		System.out.println(strSet.add("Orange"));//true
		
		System.out.println(strSet.add(null));//true
		//can't have duplicates even duplicate nulls
		System.out.println(strSet.add(null));//false
		Animal nullAnimal=null;
		/*
		 * even this object is null, you can't add it to this set as the type is
		 * String, so it can only something of reference String
		 */
	//	System.out.println(strSet.add(nullAnimal));//will not compile
		
		String nullStr=null;
		/*
		 * this will return false as we already have null in this set
		 */
		System.out.println(strSet.add(nullStr));
		System.out.println("print out our set");
		System.out.println(strSet);
		
		System.out.println("remove");
		//removes first instance of orange in strList
		strList.remove("orange");
		System.out.println(strList);
		strSet.remove(null);
		//this will remove null from the set
		System.out.println(strSet);
		//can remove from a particular position, this will remove second orange
		strList.remove(3);
		System.out.println(strList);
		/*
		 * remove() returns a boolean, true if the object is found and removed
		 * false if not
		 */
		System.out.println(strList.remove("pineapple"));
		/*
		 * if you try to remove from a index position that does not exist you 
		 * will get IndexOutOfBoundsException. strList only has three objects in it
		 * so it only goes as far as 2
		 */
		//strList.remove(12);//this generates IndexOutOfBoundsException
		
		System.out.println("****isEmpty() and Size()");
		System.out.println("size of strList is "+strList.size());
		System.out.println("size of strSet is "+strSet.size());
		System.out.println("is strList empty "+strList.isEmpty());//false
		System.out.println("is strSet empty "+strSet.isEmpty());//false
		List<Integer>myList=new ArrayList<>();
		System.out.println("is myList empty "+myList.isEmpty());//true
		
		System.out.println("***clear");
		/*
		 * deletes all elements in a collection
		 */
		List<Integer>numList=new ArrayList<>();
		numList.addAll(Arrays.asList(23,45,66,888,999,10000));
		System.out.println(numList);
		numList.clear();
		System.out.println(numList);
		strSet.clear();
		System.out.println(strSet);
		//can only add Collections of Strings (List,Sets, Queues)
		strSet.addAll(Arrays.asList("orange","apple","banana","apple","pineapple"));
		System.out.println(strSet);
		//this is  using the equals() method of the Dog class
		//if returns true, the Dog will NOT be inserted into list
		Set<Dog>dogSet=new HashSet<>();
		Dog dog1=new Dog("spot",1);//is inserted
		Dog dog2=new Dog("spot",1);//is inserted
		Dog dog3=new Dog("rex",2);//is inserted
		Dog dog4=dog1;//is NOT INSERTED
		dogSet.addAll(Arrays.asList(dog1,dog2,dog3,dog4));
		System.out.println(dogSet);
		System.out.println("contains**");
		/*
		 * returns a boolean true if the collection contains a particualr object
		 * false if not
		 */
		System.out.println(dogSet.contains(dog1));//true
		Dog lassie=new Dog("lassie",5);
		System.out.println(dogSet.contains(lassie));//false
		System.out.println(strList.contains("one"));//true	
	}
/**
 * this covers the List interface
 *clik on 
 * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/List.html">The list interface </a>for details 
 * for details of {@code interface List<E>}
 * LIST
 * is a list of ordered collection of objects that allows duplicate entries. Elements
 * can be accessed by an int index
 * some of the classes that implements this interface are
 * ArrayList
 * LinkedList
 * Vector
 * Stack
 * (you can also create your own class that implements the List interface)
 * List interface extends Collection and Collection extends Iterable.
		 * we can have a Iterable referernce to a ArrayList object
		 * So we can have a Collection reference to a arrayList object
		 * we can have a List reference to a ArrayList Object
		 * @see com.android.animals.Animal
		 * @see com.android.animals.Dog
		 * @see com.android.animals.Mouse
		 * @see com.android.animals.Collie
	 */
	static void ex2() {
		/*
		 * see 
		 * https://docs.oracle.com/javase/8/docs/api/java/util/List.html
		 * for details of interface List<E> 
		 * details of all known in built java classes and super interfaces of 
		 * List included
		 */
		System.out.println("**ex2");
		System.out.println("****ArrayLists");
		/*
		 * List Implementation
		 * List interface extends Collection and Collection extends Iterable.
		 * we can have a Iterable referernce to a ArrayList object
		 * So we can have a Collection reference to a arrayList object
		 * we can have a List reference to a ArrayList Object
		 */
		//this object only has access to the Iterable interface methods
		//forEach() and iterator() are the main ones from this interface
		Iterable<Integer>iterList=new ArrayList<>();
		/*
		 * this object has access to all of the Iterable interface methods and
		 * the Collection interface methods
		 * i.e add(),addAll(),clear(),contains(), Stream()
		 */
		Collection<String>strCollection=new ArrayList<>();
		/*
		 * this object has acccess to all of the methods of Iterable,Collection and
		 * List interface. 
		 * i.e set(), get();
		 */
		List<Dog>dogList=new ArrayList<>();
		/*
		 * this object has access to all of the methods of Iterable, Collection, 
		 * List AND Serializable, Clonable and RandomAccess Interfaces
		 * (Serializable will be covered when we come to databases
		 * Clonable will also be covered in subsequent sections)
		 */
		ArrayList<String>strArrList=new ArrayList<>();
		/*
		 * this determines that this is a List of Integers
		 */
		List<Integer>numList=new ArrayList<>();
		//4 is autoboxed to become an Integer and added to the list
		numList.add(4);
		numList.add(Integer.getInteger("345"));
		Double.parseDouble("34.5");
		Integer.parseInt("23");
		numList.add(new Integer(346));
		//numList.add(23.4);
		byte myByte=56;
		//numList.add(myByte);//will not compile
		numList.add((int)myByte);
		/*
		 * will not compile as there is no relationship between a byte primitive 
		 * and a Integer wrapper
		 */
		//numList.add((Integer)myByte);
		
		List<Animal>animalList=new ArrayList<>();
		/*
		 * this list can take Animals and subclasses of Animals, as long as your
		 * reference is a Animal or sub class of Animal then this can be added
		 * to the list
		 */
		animalList.add(new Animal());
		animalList.add(new Dog());
		animalList.add(new Collie());
		animalList.add(new Mouse("mickey",2));
		Animal dogAnimal=new Dog();
		animalList.add(dogAnimal);
		/*
		 * you can't add a behaviour reference to a Dog object as it's NOT A Anial
		 * reference
		 */
		Behaviour behaveDog=new Dog();
		//animalList.add(behaveDog);//will not compile
		List<Behaviour>behaveList=new ArrayList<>();
		behaveList.add(new Dog());
		behaveList.add(behaveDog);
		/*
		 * this can also take anonymous class implementation of Behaviour interface
		 * and it is a function interface so it can take a lambda
		 */
		behaveList.add(()->System.out.println("lambda sad method"));
		/*
		 * this list can only take a Dog reference object or a subclassed reference
		 * object, of which there is only one , a collie
		 */
		List<Dog>kennel=new ArrayList();
		kennel.add(new Dog());
		kennel.add(new Collie());
		
		//this is a Animal reference to a Dog object
		dogAnimal=new Dog();
		//kennel.add(dogAnimal);//will not compile
		kennel.add((Dog)dogAnimal);
		System.out.println("print me");
		//this is a list of objects, that can take ANY OBJECT
		//I have no diamond operater type on the left hand sid
		List myList=new ArrayList<Integer>();
		//i can only call methods of the object class on each of these objects
		myList.add("hello");
		myList.add(23.5);
		myList.add(new Animal());
		System.out.println("AddAll");
		/*
		 * add all takes a object that implements the Collection interface, so 
		 * all Sets, Lists and Queues can be the parameter that is sent to this
		 * method
		 * kennel is a list, list implements the Collection interface
		 */
		kennel.addAll(kennel);
		Set<Dog>setDog=new HashSet<>();
		setDog.addAll(Arrays.asList(new Dog(),new Dog(),new Dog()));
		;
		kennel.addAll(setDog);	
	}
	/**
	 * this method deals with Iterators, which are objects that have the sole purpose to go through a Collection
	 * which is any class that implements the collection interface. Any class that implements the Collection 
	 * interface can use an Iterator. Iterator can add and take elements away from a Collection as it is 
	 * going throught the values in a Collection object
	 * you create a specific iterator for a specific collection object and some of the methods you can use are
	 * hasNext(), which returns a boolean and while this is true we keep iterating over a collection, it is
	 * asking have we another value after the current value in a collection, if true we can use
	 * next() which returns the next value in the list so it moves on to the next object in a collection
	 * @see com.android.animals.Dog 
	 */
	static void ex3() {
		Set<Dog>dogSet=new HashSet<Dog>();
		Iterator<Dog>dogSetIter=dogSet.iterator();
		while(dogSet.iterator().hasNext())
		System.out.println("***ex3");
		System.out.println("iterator");
		/*
		 * an iterator is a Object that is used to go through a collection object
		 */
		List<Dog>kennel=new ArrayList<>();
		kennel.addAll(Arrays.asList(new Dog("spot",2),
				new Dog("rex",3),new Dog("lassie",5),new Dog("benji",10)));
		
		for(Dog d:kennel)
			System.out.println(d);
		/*
		 * Using a listiterator to go through values in a list, you create a 
		 * ListIterator from an existing list
		 * first rule, the type of the ListIterator has to match the type of the
		 * list
		 * you create the actualy object by having the list call the ListIterator()
		 * method which creates a ListIterator
		 */
		ListIterator<Dog>dogIterator=kennel.listIterator();
		System.out.println(dogIterator);//this just prints the object reference
		System.out.println("hasNext");
		/*
		 * hasNext returns a boolean value which indicates if there is another record
		 * in the kennel list of Dogs, 
		 * the iterator starts before any dogs, so hasNext will be true, as this will
		 * be the first Dog
		 * hasNext does not move the loop onto the next dog, it's only a check to 
		 * see is there anohter dog in the list
		 */
		while(dogIterator.hasNext()) {
			
			System.out.println("index of next Dog is "+dogIterator.nextIndex());
		//	System.out.println("dog inside while loop");
			/*
			 * next() DOES move you onto the next dog, first time in the loop, this
			 * will return the FIRST DOG. so it moves the loop from the position of
			 * before the first Dog, to the First Dog.
			 * next moves you onto the next Dog, and returns the same Dog.
			 */
			System.out.println(dogIterator.next());
			/*
			 * hasNext DOES NOT MOVE you onto the next dog, it merely checks to see
			 * that the list contains a Dog after the current Dog
			 */
			System.out.println(dogIterator.hasNext());
			//this would move us onto the next Dog
			/*
			 * if you have no next() method inside this loop, you will get an
			 * infinite loop as you will be stuck at point before the first Dog
			 * forever
			 */
			System.out.println(dogIterator.nextIndex());
			;
			/*
			 * index postion finishes at 4
			 */
		}
	//	System.out.println(dogIterator.);
		System.out.println("dogs going backwards");
		while(dogIterator.nextIndex()>0) {
			System.out.println(dogIterator.previous());
		}
		//index position finishes at -1
		System.out.println(dogIterator.previousIndex());
		
		while(dogIterator.hasNext()) {
			System.out.println(dogIterator.next());
		}	
	}
	/**more on iterators and how noSuchElementException is generated and how to avoid infinite loops when using
	 * Iterators
	 * @see com.android.animals.Dog class
	 */
	static void ex4() {
		//a list of numbers
		List<Integer>numbers=new ArrayList<>();
		//add all these numbers to the list
		numbers.addAll(Arrays.asList(12,23,34,45,56,66,77,88));
		//creates an iterator for collections of Integers
		ListIterator<Integer>intIter=numbers.listIterator();
		System.out.println("numbers in forward order");
		while(intIter.hasNext()) {
			System.out.println("number is "+intIter.next());
		}//after this loop we are at the end of the list
		/*
		 * this results in a NoSuchElementException, which is a runtimeException
		 * as we are at the end of the list, so there is no next element
		 */
	//	System.out.println(intIter.next());//generates exception
		/*
		 * at this point the iterator points to the LAST number on the list
		 * which is index position 7, and iterator number of 8
		 * the final number of the iterator will be the total amount of numbers
		 * in the list the iterator is based on, which is 8 numbers
		 */
		System.out.println("numbers in reverse order");
		while(intIter.hasPrevious()) {
			System.out.println("number is "+intIter.previous());
		}
		/*
		 * the above takes us to the beginning of the list and there is 
		 * NO number before the beginning of the list, so this again retursn
		 * NoSuchElementException, which a runtime Exception
		 */
	//	System.out.println(intIter.previous());
		/*
		 * this will reset your iterator back to the start of the list
		 */
		intIter=numbers.listIterator();
		System.out.println("first five numbers");
		while(intIter.nextIndex()<5) {
			System.out.println("number is "+intIter.next());
		}
		
		System.out.println("next number is "+intIter.next());
		//resets the iterator back to the beginning of the numbers list
		intIter=numbers.listIterator();
		
		Dog spot=new Dog("spot",12);
		Dog rex=new Dog("rex",5);
		Dog lassie=new Dog("lassie",6);
		List<Dog>kennel=new ArrayList<>();
		
		kennel.addAll(Arrays.asList(spot,rex,lassie,new Dog("benji",40)));
		System.out.println(kennel);
		ListIterator<Dog>dogIter=kennel.listIterator();
		while(dogIter.hasNext()) {
			/*
			 * first time in loop, will got to first dog, spot and 
			 * prints spots name
			 */
			System.out.println("name of Dog is"+dogIter.next().name);
			/*
			 * then goes the the NEXT dog, and will get the age of 
			 * the second Dog, which will be 5
			 */
			System.out.println("age of Dog "+dogIter.next().age);
		}
		dogIter=kennel.listIterator();//resets iterator
		
		while(dogIter.hasNext()) {
			/*
			 * we create a local Dog variable and assign the dog produced
			 * from dogIter.next to this variable
			 */
			Dog temp=dogIter.next();
			System.out.println("name of Dog is "+temp.name);
			System.out.println("age of Dog is "+temp.age);
		}
		
		dogIter=kennel.listIterator();//resets our iterator
		/*
		 * if you have a while loop, that relys on hasNext and you are at the start of 
		 * your list, if you do not have a next() method, your loop will be infinite.
		 * next() is the command that causes your loop to forward by one
		 * similarily if you are at the end of your list and you don't have a previous()
		 * your loop will also be infinite
		 */
	//	while(dogIter.hasNext()) {
			/*
			 * this ends up with an infinite loop
			 */
	//		System.out.println("dog is "+dogIter.next());
	//		System.out.println("dog is "+dogIter.previous());
	//		System.out.println("print me");
	//	}	
		intIter=numbers.listIterator();
		System.out.println(numbers);	List<Integer>linkedInt=new LinkedList<>();
	}
	/**this covers the Queue Interface
	 * see 
	 * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html">The Queue Interface</a> 
	 * for further details
	 * the class declaration is as follows
	 * {@code interface Queue<E>}
	 * QUEUE
	 * Queue is a collection that orders it's elements in a specific order for processing.
	 * A typical queue processes it's elements in a first-in, first-out order but other
	 * orderings are possible.
	 * some of the classes that implement this interface are 
	 * LinkedList
	 * ArrayBlockingQueue
	 * ArrayDeque (array deck)
	 * PriorityQueue
	 * (any class can implement multiple interfaces, which is why LinkedLIst is here as well)
	 * this method will be covering the ArrayDeque class, see
	 * <a href= "https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html">this link</a> for more details
	 * the class declaration is as follows
	 * {@code Class ArrayDeque<E>}
	 * see code in ex5 for more explanations and worked code examples
	 * 
	 */
	static void ex5() {	
		/*
		 * see
		 * https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html
		  fore details of class ArrayDeque<E>
		 * 
		 * see
		 * https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
		 * for details of the interface Queue<E>
		 */
		System.out.println("***ex5");
		System.out.println("****ArrayDeque****");
		/*
		 * can be used instead of stacks (first in, last out, last in, first)
		 * implements Collection, Queue, Deque and Iterable
		 * Collection base class
		 * Queue extends Collection
		 * Deque extends Queue
		 */
		Collection<String>CollectDeque=new ArrayDeque<>();
		Queue<Hippo>ququeDeque=new ArrayDeque<>();
		Deque<Dog>arrayDeque=new ArrayDeque<>();
		ArrayDeque<Cat>cararrDeque=new ArrayDeque<>();
		//does NOT implement the list interface
		//List<Integer>noDeque=new ArrayDequue<>();//will not compile
		
		Deque<String>strDeque=new ArrayDeque<>();
		//duplicates are allowed
		strDeque.addAll(Arrays.asList("hello","apple","orange","apple","orange","banana"));
	//	System.out.println();
		strDeque.add("tomoato");
		System.out.println(strDeque);
		/*
		 * you cannot add a null value to a ArrayDeque, unlike a list
		 * you will get a null pointer exception
		 */
	//	strDeque.add(null);
		/*
		 * you can't add a elements at a particular location in the list
		 * i.e have a list of strings called  frutis want to at a  fruit at index position
		 * 3
		 * strDeque.add(3,"pineapple");
		 */
		System.out.println(strDeque);
		System.out.println("push");
		/*
		 * push adds an element at the beginning of the list
		 * push retursn void
		 */
		strDeque.push("turnip");
		/*
		 * push operates like a real queue
		 */
		System.out.println(strDeque);
		/*
		 * add puts it at the end of the deque
		 */
		strDeque.add("kumquot");
		System.out.println(strDeque);
		System.out.println("offer");
		/*
		 * offer() is the same as add and it the string "carrot" is added to the end of the 
		 * arrayDeque
		 * offer() returns a boolean, true if inserted, false if not
		 */
		System.out.println(strDeque.offer("carrot"));
		System.out.println(strDeque);
	//	System.out.println(strDeque.peek());
		System.out.println("**pop***");
		System.out.println("pop removes first element from the list and returns that elements");
		System.out.println(strDeque.pop());
		//turnip is removed from the arrayDeque strDeque
		System.out.println(strDeque);
		ArrayDeque<String>emptyDeq=new ArrayDeque<>();
		/*
		 *if you try to pop from a empty deque, you will get a NoSuchElemetnException, which is a
		 *runtime exception
		 */
		//emptyDeq.pop();
		System.out.println("***poll***");
		/*
		 * Poll does the same as popping and removes the first element and returns that elements
		 * this will print out the string "hello"
		 * and then remove it from the strDeque arrayDeque
		 */
		System.out.println(strDeque.poll());
		/*
		 * the difference between pop() and poll() is pop() returns a NoSuchElementException if used
		 * on a empty arraydeque, and poll returns null if used on empty arraydeque
		 */
		System.out.println(emptyDeq.poll());
		System.out.println(strDeque);
		System.out.println("pollLast");
		/*
		 * this returns the last item in the Deque and then removes it from the Deque
		 */
		System.out.println(strDeque.pollLast());//this displays the string "carrot"
		//we can now see "carrot" is removed from the deque
		System.out.println(strDeque);
		/*
		 * there is also a pollfirst() which as far as i know is the same as poll
		 */
		System.out.println("***Remove****");
		/*
		 * just like poll and just like pop, it returns the first element in the list and then removes
		 * it from teh arrayDeque
		 */
		System.out.println(strDeque.remove());//will display String "apple"
		System.out.println(strDeque);//"apple" is remove from deque
		/*
		 *if you use remove() on a empty arrayDeque, you will get a NoSuchElementException, like 
		 *pop()
		 */
		//emptyDeq.remove();
		System.out.println("***peek()***");
		//this allows us to see the first elemetn, and DOES NOT delete the String from the ArrayDeque
		System.out.println(strDeque.peek());
		System.out.println(strDeque);
		//will display last element
		System.out.println(strDeque.peekLast());
		System.out.println(strDeque.peekFirst());
		
		List<Integer>numbers=new ArrayList<>();
		numbers.addAll(Arrays.asList(20,456,3456,123,20,99,100,3456789));
		/*
		 * the constructors for all sets, queues and lists can take a LIst, set or Queue
		 * here we create an ArrayDeque from an exisitn list called numbers.
		 * any Set, List, Queue and sub classes can take a Object that implements the Collection
		 * interface
		 */
		ArrayDeque<Integer>deqNumbers=new ArrayDeque<>(numbers);
		/*
		 * here we create a set of Integers from an existing list called numbers
		 * this will remove the duplicate number 20
		 */
		Set<Integer>setNumbers=new HashSet<>(numbers);
		System.out.println("setNumbers");
		System.out.println(setNumbers);
		/*
		 * this will remove the duplicate entry 20 and also arrange your values in ascending order
		 */
		TreeSet<Integer>treeNumbers=new TreeSet<>(numbers);
		System.out.println(treeNumbers);
		/*
		 * here we create a list of Integers rom an exising list called numbers
		 */
		List<Integer>listNumbers=new ArrayList<>(numbers);
		int sum=0;
		/*
		 * while our arrayDeque is NOT empty
		 */
		while(!(deqNumbers.isEmpty()))
			/*
			 * add the number to our sum and then remove it from the arrayDeque deqNumbers
			 */
			sum=sum+deqNumbers.poll();
		
		System.out.println("sum is "+sum);
		System.out.println(deqNumbers);
		
		ArrayDeque<Dog>kennel=new ArrayDeque<>();
		List<Dog>dogList=Arrays.asList(new Dog(),new Dog("spot",3),new Dog("rex",5),new Dog("lassie",10));
		kennel.addAll(dogList);
		System.out.println(dogList);//list of Dogs
		System.out.println(kennel);//ArrayDeque of Dogs
		kennel=new ArrayDeque<>(dogList);
		System.out.println(kennel.equals(dogList));
		System.out.println(kennel.peekLast());//last dog in queue
		System.out.println(dogList.get(3));//last dog in list
		/*
		 * this is comparing the last Dog in our kennel queue to the last Dog
		 * in our List of Dogs, we can see that they are the same Dog
		 */
		System.out.println(kennel.peekLast().equals(dogList.get(3)));
		/*
		 * these are all "SHALLOW COPIES" ITS ONLY the REFERENCE THAT IS COPIED
		 */
		ArrayDeque<Dog>kennel2=new ArrayDeque<>(dogList);
		//NOT THE SAME COLLECTION OBJECT
		System.out.println(kennel2.equals(dogList));
		System.out.println(kennel2);
		System.out.println(dogList);
		//BUT CONTAIN THE SAME DOGS, AND WILL RETURN TRUE
		System.out.println(kennel2.peekLast().equals(dogList.get(3)));	
	}
	/**
	 * This method shows information pertaining to linkedLists, go to
	 *  <a href="https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html">click here</a> for detailed information
	 * The class declaration is 
	 * {@code Class LinkedList<E>}
	 * Implements Collection, Queue, Deque and List
	 * all methods of List and Deque are then available to this class so allows duplicates and null elements
	 * and elements can be added anywhere in a LinkedList
	 * see ex6 for code and working examples
	 */
	static void ex6() {
		System.out.println("***ex6");
		System.out.println("linkedList****");
		/*
		 * see
		 * https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html
		 * for details of class LinkedList<E>
		 */
		/*
		 * implements collection, Queue, Deque and List
		 * Collection base Interface
		 * Queue extends Collection
		 * Deque extends Queue
		 * also implements List
		 * 
		 * LinkedList implements both the Queue/Deque and List interface
		 * all methods of List and Deque are then available to this class so allows duplicates and null elements
		 * and elements can be added anywhere in a LinkedList
		 */
		LinkedList<String>strLinked=new LinkedList<>();
		strLinked.add("apple");
		strLinked.add("banana");
		strLinked.offer("orange");//added to end
		strLinked.push("pineapple");//added to start
		strLinked.add(1,"mango");//added at position 1
		strLinked.set(2, "pineapple");
		System.out.println(strLinked);
		//get is from List interface
		System.out.println(strLinked.get(1));//mango
		//can add null, can't do this with a queue
		strLinked.push(null);
		strLinked.remove(1);//from list will remove at postion 1
		strLinked.remove();//remove first item from list
	}
	/**
	 * This covers an Introduction to the Set Interface, go to
	 * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Set.html">click here</a> for detailed information
	 * the class declaration is 
	 * {@code Interface Set<E>}
	  * SET
	 * A set is a Collection that DOES NOT allow duplicate entries
	 * some of the classes that implement SET are
	 * HashSet
	 * LinkedHashSet
	 * TreeSet
	 * Set also implements the Collection interface
	 */
	static void ex7() {
		System.out.println("***ex7");
		System.out.println("******SET INTERFACE*****");
		System.out.println("Set interface does NOT ALLOW duplicates elements and elements are returned in "
				+ " no particular order");
		System.out.println("extends The collection interface");
		System.out.println("the classes we cover are ");
		System.out.println("HASHSET");
		System.out.println("LINKEDHASHSET");
		System.out.println("TREESET");
		System.out.println("*****HashSet****");
		/*
		 * implements Collection and Set interface
		 * Collection super interface
		 * Set Interface extends Collection
		 */
		//you can have a Set reference to a HashSet object
	//	Set<String>strHash=new HashSet<>();
		HashSet<String>strHash=new HashSet<>();
		//hashSet DOES NOT impose any particular order 
		System.out.println(strHash.addAll(Arrays.asList("noel","NOEL","mary","shelly","mary")));
		//the second "mary" will not be added, and the order cannot be guaranteed
		System.out.println(strHash);
		//"noel" will NOT be added and this will return FALSE
		System.out.println("added to list "+strHash.add("noel"));
		
		List<String>names=new ArrayList<String>();
		names=Arrays.asList("harry","noel","shelly","laura","colm","NOEL","MARY","shelly");
		//this will not add strings that already exist in strHash
		strHash.addAll(names);
		System.out.println(strHash);
		//can add null
		System.out.println("adding null "+strHash.add(null));
		//can't add second null
		System.out.println("adding second null "+strHash.add(null));
		
		HashSet<Integer>intHash=new HashSet<Integer>();
		intHash.addAll(Arrays.asList(234,4,67,4,99,120,99));
		System.out.println("intHash is "+intHash);	
		/*
		 * if you are adding many elements to a HashSet you not know how many elements will be added to yoru 
		 * set (duplicates are not added), so size() here is more important for this class that previous 
		 * collection classes
		 */
		int size=intHash.size();//size before we add elements
		intHash.addAll(Arrays.asList(4,4,99,123,9,67,121,119,121));
		int diff=intHash.size()-size;
		System.out.println("amount of numbers added to list "+diff);
	}
	/**
	 * HashSet is a implementation of the Set Interface, go to 
	 * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html">click here</a> for detailed information
	 * The class Declaration is 
	 * {@code Class HashSet<E>}
	 * HashSet uses hashCode() and equals methods to determine if two objects are the same or equal. HashSet does NOT 
	 * allow us to add two objects that have the same hashcode or if equal() returns true. To illustrate this we create
	 * a HashSet of Animals, and Animal does overriden the object class equals() or hashCode() methods
	 * and a HashSet of Rats, HashSet of Dogs and HashSet of Dinosaurs, and each of these classes have overriden one, or both
	 * of these methods
	 * @see com.android.animals.Animal
	 * @see com.android.animals.Rat
	 * @see com.android.animals.Dog
	 * @see com.android.animals.Dinosaur
	 */
	static void ex8() {
		System.out.println("***ex8");
		/*
		 * HashSet uses hashCode() and equals methods to determine if two objects are the same or equal. HashSet does NOT 
		 * allow us to add two objects that have the same hashcode or if equal() returns true.
		 * Animal does NOT override the hashCode() or equals() method
		 * method, so it will use the HashCode() and equals() method implementation from
		 * the object class. the same objects have the same hashcode and equals() returns true
		 * , however a copy of the object has a different
		 * hashCode if you are using the Object class hashCode method and equals method returns false
		 */
		HashSet<Animal>animalHash=new HashSet<>();
		/*
		 * these two Animals have the same age and name, but the equals() and hashCode() method are NOT overriden
		 * so it will use the HashCode method from the object class. It will also use the equals method from the 
		 * Object class and will return true if they are the same object. the hashcode produces the same hash(number)
		 * if both objects are the same object and true if they are the same object
		 */
		System.out.println("animal added "+animalHash.add(new Animal(1,"andy")));//will be added
		System.out.println("animal added "+animalHash.add(new Animal(1,"andy")));//will be added
		//andy and angela are the same Animal
		Animal andy=new Animal();
		Animal angela=andy;
		
		System.out.println(andy.equals(angela));
		
		System.out.println("animal added "+animalHash.add(andy));//will be added
		System.out.println("animal added "+animalHash.add(angela));//will NOT be added
		//two Rats with the same age
		Rat ronnie=new Rat(4,"ronnie");
		Rat rachel=new Rat(4,"rachel");
		//both rats are equal
		System.out.println("two rats same age "+ronnie.equals(rachel));
		//both rats have same hashcode, which is produced from the age
		/*
		 * if two Rats have the same hashCode and return true when used against each other with the equals()
		 * method, then they will NOT BE added the set
		 */
		System.out.println(ronnie.hashCode());//hash of 164
		System.out.println(rachel.hashCode());//has of 164
		System.out.println("ronnie the rat added "+animalHash.add(ronnie));//will be added
		System.out.println("rachel the rat added "+animalHash.add(rachel));//will NOT be added
		
		HashSet<Rat>ratSet=new HashSet<>();
		//both rats have same age
		System.out.println("rachel added to ratSet "+ratSet.add(rachel));//will be added
		System.out.println("ronnie added to ratSEt "+ratSet.add(ronnie));//will NOT be added
		/*
		 * if you override only equals() or only hashCode() then both of the above Rats, WILL BE added to 
		 * Sets. As if i don't override either equals() or hashCode(), it will then use the non overriden method
		 * from the object class. which returns true for equals() if and only if same object and returns same
		 * hashCode, if and only if they are the same object
		 */
		/*
		 * equals() and hashCode() are both overriden in the Dog class, and equals returns true if they have the same
		 * name and age. 
		 * if they have the same age and name, then they will have the same hashCode()
		 * only one Dog will be added, as both references are the same Dog
		 */
		Dog lassie=new Dog();
		Dog prince=lassie;
		
		HashSet<Dog>kennel=new HashSet<>(Arrays.asList(
				lassie,//1 added to set
				prince,//2 NOT added to set as prince is the same Dog as lassie
				new Dog(),//3 NOT ADDED	as same name and age as Dog 1
				new Dog("spot",2),// 4 added to set
				new Dog("rex",4),//5 added to set
				new Dog("spot",2),//6 NOT added as dog same age and  name as Dog 4
				new Dog()//7 NOT added as same age and name as Dog 1
				));
		System.out.println("amount of dogs added to set is "+kennel.size());
		
		Dinosaur tRex=new Dinosaur(23,"TRex",607.8,23.2,Type.CARNIVORE);
		Dinosaur tRex2=new Dinosaur(23,"TRex",607.8,23.2,Type.CARNIVORE);
		Dinosaur tRex3=tRex2;
		Dinosaur bronto=new Dinosaur(12,"Brontosaurus",1200.2,40.0,Type.HERBIVORE);
		Dinosaur trici=new Dinosaur(12,"Triceratops",400.12,40.2,Type.OMNIVORE);
		/*
		 * Sets, and in particular HashSets, do not have any particular order. so the order may or may be 
		 * the order the items were input. can't guarantee the order
		 */
		Set<Dinosaur>dinoSet=new HashSet<>();
		System.out.println("adding dinosaur");
		System.out.println(dinoSet.add(tRex));//added
		System.out.println(dinoSet.add(tRex2));//not added
		System.out.println(dinoSet.add(tRex3));//not added
		System.out.println(dinoSet.add(bronto));//added
		System.out.println(dinoSet.add(trici));//added
		System.out.println(dinoSet.add(trici));//not added
		System.out.println(dinoSet.add(null));//added
		System.out.println(dinoSet.add(null));//not added
		/*
		 * every hamster has a unique id, so hamsters with the same age,name and weight will be entered
		 * into the hashSet
		 */
		Hamster hamster1=new Hamster(2,"harry",2.5);
		Hamster hamster2=new Hamster(2,"harry",2.5);
		Hamster hamster3=hamster1;
		
		Set<Hamster>hamsterSet=new HashSet<>();
		System.out.println("adding hamsters");
		System.out.println(hamsterSet.add(hamster1));
		System.out.println(hamsterSet.add(hamster2));
		System.out.println(hamsterSet.add(hamster3));
		List<Hamster>hamsterList=new ArrayList<>();
		hamsterList.addAll(hamsterSet);
		hamsterList.clear();
	}
	/**
	 * implements the Set and Collection Inteface and is a subclass of HashSet, go to
	 * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashSet.html">click here</a> for detailed information
	 * The class Declaration is 
	 * {@code Class LinkedHashSet<E>}
	 * implements the Set and Collection Inteface and is a subclass of HashSet
	 * similar to hashSet in that you cannot enter in duplicate entries, however the items are 
	 * ORDERED IN WHATEVER WAY THEY WERE ENTERED. So order is guaranteed in the way they were entered.
	 * this DOES NOT IMPLEMENT THE LIST INTERFACE
	 * as it's a sub class of HashSet it uses both equals() and hashCode() to determine if objects
	 * are the same
	 * @see com.android.animals.Animal
	 * @see com.android.animals.Dog
	 * */
	static void ex9() {
		System.out.println("***ex9*****");
		System.out.println("*****LinkedHashSet******");
		/*
		 * implements the Set and Collection Inteface and is a subclass of HashSet
		 * similar to hashSet in that you cannot enter in duplicate entries, however the items are 
		 * ORDERED IN WHATEVER WAY THEY WERE ENTERED. So order is guaranteed in the way they were entered.
		 * this DOES NOT IMPLEMENT THE LIST INTERFACE
		 */
		Set<Animal>animalLHS=new LinkedHashSet<>();
		/*
		 * this uses the hashCode and the equals method from the object class, so all new objects are added
		 */
		System.out.println(animalLHS.add(new Animal()));//added
		System.out.println(animalLHS.add(new Animal()));//added
		/*
		 * uses teh hashcode and the equals method from the Dog class, so objects with the same name and 
		 * age are NOT added
		 */
		System.out.println(animalLHS.add(new Dog("spot",2)));//added
		System.out.println(animalLHS.add(new Dog("spot",2)));//not added
		
		System.out.println(animalLHS);
		
		List<Dog>dogList=new ArrayList<Dog>();
		dogList.addAll(Arrays.asList(new Dog("spot",2),new Dog("rex",4),new Dog("lassie",3),new Dog("benji",2),
				new Dog("spot",2)));
		Set<Dog>dogLHS=new LinkedHashSet<Dog>();
		dogLHS.addAll(dogList);
		System.out.println(dogLHS);
		
		Iterator<Dog>dogIter=dogLHS.iterator();
		System.out.println("iterator");
		
		while(dogIter.hasNext())
			System.out.println(dogIter.next());
		//no get or set in Sets, easiest way to get an item from a LinkedHashSet, is to copy all elements to a 
		//list
		List<Dog>dogList2=new ArrayList<Dog>();	
		dogList2.addAll(dogLHS);
		Dog prince=new Dog("prince",12);
		System.out.println(dogLHS.add(prince));
		System.out.println(dogLHS);
		/*
		 * the only waya you can remove from a set is by object reference, so this removes the Dog
		 * prince
		 */
		System.out.println(dogLHS.remove(prince));
		System.out.println(dogLHS);
		
		Dog spot=new Dog("spot",2);
		Dog lassie=new Dog("lassie",3);
		Dog benji=new Dog("benji",4);
		Dog lady=new Dog("lady",4);
		List<Dog>kennelList=new ArrayList<>();
		kennelList.addAll(Arrays.asList(spot,lassie,benji,lady));
		Set<Dog>dogSet=new LinkedHashSet<Dog>();
		dogSet.addAll(Arrays.asList(new Dog(),new Dog("ruby",5),new Dog("babe",8)));
		dogSet.add(spot);
		dogSet.add(benji);
		dogSet.add(lady);
		dogSet.add(lassie);
		System.out.println(dogSet);
		/*
		 * this checks dogSet to see if it contains the four dogs on the kennelList, returns a boolean, 
		 * and this set DOES contain all four dogs, so this will return true
		 */
		System.out.println(dogSet.containsAll(kennelList));
		/*
		 * this will remove all four dogs of kennelList from the set of Dogs dogSet
		 * if there are only two of the dogs from kennellList in dogSet, those two dogs WILL BE removed
		 * any dogs from kennelList will be removed from dogSet
		 */
		System.out.println(dogSet.removeAll(kennelList));
		
		System.out.println(dogSet);
		
		System.out.println(dogSet.removeAll(kennelList));	
	}
	/**
	 * implements the following interface, {@code Collection<E>}, Set, NavigableSet,SortedSet
	 *Iterable, Comparable
	 *both Navigableset and sortedset are both sub interfaces of set, go to
	 *<a href="https://docs.oracle.com/javase/8/docs/api/java/util/TreeSet.html">click here</a> for detailed information
	 *the class declaration is 
	 *{@code Class TreeSet<E>}
	 * prints out in ascending order by default, so numbers prints out 
		 * 1,2,3
		 * strings and characters  print out
		 * non numeric first /?*!
		 * then numbers 123
		 * then capital letters A B C
		 * then lower case letters a b c
		 * so a treeset with letters, numbers and symbols could be sorted like the following:
		 *??
		 *12
		 *A
		 *a
		 *only objects that implement the comparable interface can be added to treeset, all numeric wrappers
		 *and the String implement the Comparable. the only abstract method in the Comparable interface is
		 *the method compareTo(). this method is used to determine order and the TreeSet uses this overloaded
		 *method to determine order (covered in detail in the next section) 
		 *Mouse and FieldMouse both implement Comparable, and Mouse and FieldMouse do Not
		 *@see com.android.animals.Animal
		 *@see com.android.animals.Mouse
		 *@see com.android.animals.FieldMouse
		 *@see com.android.animals.Dog
	 */
	static void ex10() {
		System.out.println("****ex10");
		System.out.println("***TreeSet");
		/*
		 * implements the following interface
		 * Collection<E>, Set, NavigableSet,SortedSet
		 * Iterable, Comparable
		 * Navigableset and sortedset are both  sub interfaces of set
		 * prints out in ascending order by default, so numbers prints out 
		 * 1,2,3
		 * strings and characters  print out
		 * non numeric first /?*!
		 * then numbers 123
		 * then capital letters A B C
		 * then lower case letters a b c
		 *??
		 *12
		 *A
		 *a
		 *only objects that implement the comparable interface can be added to treeset, all numeric wrappers
		 *and the String implement the Comparable. the only abstract method in the Comparable interface is
		 *the method compareTo(). this method is used to determine order and the TreeSet uses this overloaded
		 *method to determine order (covered in detail in the next section)
		 */
		TreeSet<String>stringTs=new TreeSet<>();
		stringTs.addAll(Arrays.asList("zed","12","adam","!he","Betty","aidan","adam"));
		System.out.println(stringTs);
		
		List<Integer>numbers=new ArrayList<>();
		numbers.addAll(Arrays.asList(56,2,34,56,12,9,12,3,1000,450,9,6,3,449,448,1));
		TreeSet<Integer>intTree=new TreeSet<>();
		intTree.addAll(numbers);
		System.out.println(intTree);
		
		TreeSet<Double>doubleTree=new TreeSet<Double>();
		doubleTree.addAll(Arrays.asList(2.3,2.34,2.0,2.3488,-4.5,0.3,0.3,0.3003));
		System.out.println(doubleTree);
		/*
		 * like all sets duplicates are NOT ALLOWED
		 * the order is SET, it's set by only objects that implement the comparable interface
		 * can be added to a TreeSet
		 */
		doubleTree.add(56.78);//will be added
		doubleTree.add(56.78);//will not be added
		
		//TreeSet<Animal>animalTree=new TreeSet<>();
		/*
		 * Mouse implements Comparable and only an object whose class implements comparable can be
		 * added to a treeset. the mouse class can organise by the name of the mouse(string) or the age
		 * of the mouse (which is an Integer)
		 */
		Mouse mickey=new Mouse("mickey",10);
		Mouse jerry=new Mouse("jerry",7);
		Mouse maggie=new Mouse("maggie",2);
		Mouse mary=new Mouse("mary",4);
		Mouse mouse1=mary;
		TreeSet<Mouse>mouseTree=new TreeSet<Mouse>();
		mouseTree.addAll(Arrays.asList(mouse1,mary,maggie,jerry,mickey));
		System.out.println(mouseTree);
		/*
		 * this treeSet CANNOT TAKE an Animal object, as Animal does NOT IMPLEMENT comparable
		 */
		TreeSet<Animal>animalTree=new TreeSet<>();
		/*
		 * this creates the runtimeException ClassCastException, as TreeSets can ONLY take objects whose
		 * class implements Comparable. The Animal class DOES NOT implement Comparable
		 */
		//System.out.println(animalTree.add(new Animal()));
		/*
		 * Dog does NOT implement the Comparable interface, so can't be added, generates 
		 * ClassCastException
		 */
		//System.out.println(animalTree.add(new Dog()));
		/*
		 * Mouse does implement the Comparable interface and it is an Animal, so it can be added
		 */
		System.out.println(animalTree.add(mickey));
		/*
		 * FieldMouse is a subclass of mouse, which means it also implements the Comparable interface, and
		 * it is a animal
		 */
		System.out.println(animalTree.add(new FieldMouse("freddie",4)));
		/*
		 * none of Dogs subclasses currently implement Comparable, however some sub class in the future
		 * MAY implement comparable, and then objects of that sub class will be able to be added to this
		 * TreeSet
		 * you can create a TreeSet of any type, even if that type does not implement the
		 * comparable interface
		 */
		TreeSet<Dog>dogTree=new TreeSet<>();
		/*
		 * this can take any object whose class implements the Comparable interface
		 */
		TreeSet<Object>objTree=new TreeSet<>();
		/*
		 * this is now a TreeSet of Object reference to a TreeSet of Integer Objects object
		 * so you from this point onward, you CANNOT add anything but Integers
		 */
		System.out.println(objTree.add(12));
		//this will not compile and give us class Cast exception
	//	System.out.println(objTree.add("hello there "));
		
		System.out.println("Iterator with TreeSet");
		System.out.println(intTree);
		Iterator intIt=intTree.iterator();
		/*
		 * when you are working with Sets, you do not hava  hasPrevious() or previous()
		 */
		while(intIt.hasNext())
			System.out.println("number iterator is "+intIt.next());
		
		System.out.println("Descending order");
		/*
		 * this will progress through our set in descending order
		 * both listIterator and iterator can take a generic, that means that
		 * this will be a Iterator that will return Integers
		 */
		Iterator<Integer>descIntIt=intTree.descendingIterator();
		while(descIntIt.hasNext())
			System.out.println("decending order number is "+descIntIt.next());
		//new iterator at beginning of set
		Iterator<Integer>it=intTree.iterator();
		while(it.hasNext()) {
			/*
			 * as we have said that this iterator is a of type Integer, we do NOT have to cast
			 * it.next() to a be Integer. if we did not ASSIGN a type to this iterator we would
			 * have a Object refrence to a Integer object, and we would have to cast like
			 * int num=(Integer)it.next();
			 */
			int num=it.next();
			if(num%2>0) {
				it.remove();
			}
		}//end of loop
		System.out.println("intTree is now");
		/*
		 * set contains only even numbers
		 */
		System.out.println(intTree);
		/*
		 * sets the iterator back to the beginning of the set
		 */
		it=intTree.iterator();
		/*
		 * this changes the set the iterator is based
		 */
		System.out.println(intTree.add(300));
		System.out.println(intTree);
		/*
		 * the iterator it is based on the set intTree that has ONLY THE NUMBERS 
		 * 2, 6, 12, 34, 56, 448, 450, 1000
		 * we add a number to the set intTree, the number 300, so it becomes
		 * 2, 6, 12, 34, 56, 300, 448, 450, 1000
		 * so the iterator will not longer work, this will compile but we get the runtimeException
		 * ConcurrentModificationException
		 */
		/*while(it.hasNext())
			System.out.println("number is "+it.next());*/
		intTree.remove(300);
		System.out.println(intTree);
		/*
		 * even though we have now removed the nubmer 300 from the set, the iterator still does 
		 * NOT work, as it was based on the Oringinal set
		 */
	/*	while(it.hasNext())
			System.out.println("number is "+it.next());*/
		intTree.add(33);
		intTree.add(3333);
		it=intTree.iterator();
		System.out.println(intTree);
		while(it.hasNext()) {
			/*
			 * as we have said that this iterator is a of type Integer, we do NOT have to cast
			 * it.next() to a be Integer. if we did not ASSIGN a type to this iterator we would
			 * have a Object refrence to a Integer object, and we would have to cast like
			 * int num=(Integer)it.next();
			 */
			int num=it.next();
			if(num%2>0) {
				it.remove();
				
			}
		}
		System.out.println(intTree);
		/*
		 * ListIterator do NOT WORK on sets of any description
		 * ListIterator works on all Lists and Queues
		 * Iterator DOES WORK on sets
		 */
		Set<Integer>mySet=new HashSet<>();
		Iterator myIt=mySet.iterator();
	//	ListIterator myListIt=mySet.ListIterator();
		/*
		 * Iterator does NOT HAVE previous or hasPreviou()
		 * Iterator also does NOT HAVE add()
		 */
		List<String>fruits=new ArrayList<>();
		fruits.addAll(Arrays.asList("banana","apple","cherry","pineapple","strawberry","orange","mango"));
		Iterator fruitIt=fruits.iterator();
		ListIterator<String>fruitListIt=fruits.listIterator();
		String fruit;
		while(fruitListIt.hasNext()) {
			fruit=fruitListIt.next();
			if(fruit.equals("cherry")) {
				fruitListIt.add("blueBerry");
				fruitListIt.previous();
			}
		}
		
		System.out.println(fruits);
		fruitListIt=fruits.listIterator();
		while(fruitListIt.hasNext()) {
			System.out.println(fruitListIt.next());
			//this is the end of the List
		}
		/*
		 * this will cause the runtimeException NoSuchElementException
		 */
		//fruitListIt.next();
		System.out.println(fruits);
		fruits.add("turnip");
		/*
		 * this will cause a ConcurrentModificationException as our list of strings now has 9 strings 
		 * in it instead of the 8
		 * that existed when this listIterator was created
		 */
	//	while(fruitListIt.hasPrevious())//will generate exception
		//	System.out.println(fruitListIt.previous());
		fruitListIt=fruits.listIterator();//this listIterator is based on 9 strings
		System.out.println(fruits);
		fruits.set(4, "Apple");
		System.out.println(fruits);
		while(fruitListIt.hasNext())
			System.out.println("fruit is "+fruitListIt.next());
		
		TreeSet<Integer>integers=new TreeSet<Integer>();
		//this produces a random number between 0 and 10
		System.out.println((int)(Math.random()*10));
		/*
		 * this produces 0,1,2,3,4,5,6,7,8,9
		 */
		while(integers.size()<10)
			integers.add((int)(Math.random()*10));
		integers.clear();
		int counter=0;
		/*
		 * this tries to create a set of 11 numbers, but we can only use the numbers 0 to 9 
		 * and as it is a set we can't have duplicates, so this will be an infinite loop and will
		 * get stuck when it gets to 9
		 * this will result in an infinite loop
		 */
		/*while(integers.size()<=10) {
			integers.add((int)(Math.random()*10));
			
			System.out.println(counter++);
		}*/
			
		
		System.out.println(integers);
			
	}
	/**
	 * Map inteface DOES NOT EXTEND THE COLLECTION INTERFACE
		 * A map has a key and a value
		 * i.e
		 * key car reg 191G23456
		 * value porche 911
		 * key pps 99866542D
		 * value John Smith who lives in galway
		 * keys HAVE TO BE unique, duplicate keys NOT allowed, duplicate values are allowed
		 * keys are used to uniquely identify one of the items on your map.
		 * we will be focussing on HashMap, LinkedHashMap, TreeMap
		 * TreeMap are sorted by the SortedMap interface
		 * TreeMap, HashMap and LinkedHashMap are not synchronized, not thread safe
		 * we first deal with Hashmap, go to 
		 *<a href="https://docs.oracle.com/javase/8/docs/api/java/util/Map.html">click here</a> for detailed information
		 * class declaration is
		 * {@code Interface Map<K,V>}
		 * HashMaps have to have unique keys, but can have duplicate values. if you attempt to insert a new key
		 * value pair and the key already exists in the hashmap, the existing value pair will be overrwritte with
		 * the new value
		 * i.e pps number 123456 Key for Mary Kelly
		 * we insert pps number 123456 and the value Paddy lally, the new value "Paddy lally" will be inserted replacing
		 * replacing Mary kelly
		 * see method ex11 for worked examples of HashMaps
	 */
	static void ex11() {
		System.out.println("****ex11");
		System.out.println("Maps");
		/*
		 * Map inteface DOES NOT EXTEND THE COLLECTION INTERFACE
		 * A map has a key and a value
		 * i.e
		 * key car reg 191G23456
		 * value porche 911
		 * key pps 99866542D
		 * value John Smith who lives in galway
		 * keys HAVE TO BE unique, duplicate keys NOT allowed, duplicate values are allowed
		 * keys are used to uniquely identify one of the items on your map.
		 * we will be focussing on HashMap, LinkedHashMap, TreeMap
		 * TreeMap are sorted by the SortedMap interface
		 * TreeMap, HashMap and LinkedHashMap are not synchronized, not thread safe
		 */
		System.out.println("**HashMap");
		System.out.println("consists of a key and a value, no primitives allowed, null is allowed");
		//interface Map<K,V>
		/*
		 * the string is the name of the person, key
		 * the Double is the wages of the Person, value
		 */
		Map<String,Double>salary=new HashMap<>();
		/*
		 * we insert values into a Map by using the Put() method
		 */
		System.out.println("***put");
		salary.put("noel", 120_000.0);//"noel" is the key, 120,000 is the value
		salary.put("mary",80_000.0);//"mary" is the key, 80,000 is the the value
		System.out.println(salary);//this will display both
		/*
		 * put() returns the values of the key, if no value exists for "sheila", which it does'tn
		 * as this is a new key value pair, this will return null
		 */
		System.out.println(salary.put("sheila", 90_000.0));
		System.out.println(salary);
		/*
		 this will display 90,000, as this WAS the value for the key "sheila", however this put
		 will CHANGE THE value for the key "sheila"
		 you can't have two sheila KEYS, what happens is that the value for sheila gets overwritten
		 she gets a new value
		 */
		System.out.println(salary.put("sheila", 100_000.0));
		/*
		 * we see here that the value for "sheila" is now 100,000
		 */
		System.out.println("salary notice shelia "+salary);
		//also displays the previous values
		System.out.println(salary.replace("sheila", 25_000.0));
		System.out.println(salary);
		/*
		 * duplicate values ARE ALLOWED
		 */
		salary.put("tom", 100_000.0);
		salary.put("laura", 100_000.0);
		System.out.println("salary is now");
		System.out.println(salary);
		/*
		 * HashMaps are not in any particular order
		 * if you want to get a particular value, you use get in conjuction with the key
		 * so in this case we use the name to get the wages
		 */
		System.out.println("wages of sheila "+salary.get("sheila"));
		System.out.println("wages of me are "+salary.get("noel"));
		//this returns null
		System.out.println(salary.get(1));
		//this also returns null
		System.out.println(salary.get("banana"));
		/*
		 * this will be added but you can only have one null as a key
		 */
		salary.put(null, 345.00);
		salary.put(null,234.00);
		System.out.println(salary);
		/*
		 * can have multiple null values
		 */
		salary.put("kevin",null);
		salary.put("mick",null);
		System.out.println(salary);
		System.out.println("putIfAbsent");
		salary.put("kevin", 150_000.0);
		salary.put("mick", 75_000.0);
		/*
		 * putIfAbsent will NOT change the values if the key already exists in the map
		 * here the key "mick" already exists, so it will the value will NOT be changed to 100.00
		 * this will also return the current value for the key "mick", which is 75,000
		 */
		System.out.println(salary.putIfAbsent("mick", 100.00));
		/*
		 * the key "padraic" does not currently exist in the map, so this WILL BE ADDED to the map
		 */
		System.out.println(salary.putIfAbsent("padraic", 50_000.0));
		System.out.println(salary);
		System.out.println();
	//	salary.put("mick", 100_000.0);
	//	System.out.println(salary);	
	}
	/**
	 * more on hashmaps and dealing with keys and values of hashMaps, specifically also dealing with keys
	 * are of objects of our own classes and how these classes use the hashCode() and equals() method to determine
	 * if the objects are the same.
	 * This method also shows how to traverse a hashMaps keys and values
	 * this method also shows how to use Java 8 streams to traverse hashMaps, which require a lot less code than
	 * by using loops (Java 8 Streams have a bit of a learning curve, but when a programmer gets used to them they
	 * undoubtably make your life a hell of a lot easier)
	 * see code in ex12 for worked examples
	 * @see com.android.humans.Fireman
	 * @see com.android.humans.Nurse
	 * @see com.android.animals.Dog
	 */
	static void ex12() {
		System.out.println("hashMap of Fireman");
		//this is a map of with a Integer key
		//a Fireman value
		Map<Integer,Fireman>fireMen=new HashMap<>();
		for(int i=1;i<6;i++)
			fireMen.put(i, new Fireman());
		System.out.println(fireMen);
		System.out.println("we have "+fireMen.size()+" firemen");
		//this is NOT the position, this is the key for the second fireman
		System.out.println(fireMen.get(2));
		//the key 2, refers now to a new Fireman called sam, with an id of 6
		System.out.println(fireMen.put(2, new Fireman("sam")));
		//this will call the toString method for the Fireman with the key of 2
		System.out.println(fireMen.get(2).toString());
		System.out.println(fireMen);
		/*
		 * a map with a Fireman key
		 * and a double value
		 */
		Map<Fireman,Double>payRoll=new HashMap<>();
		Fireman bruce=new Fireman("bruce");
		payRoll.put(new Fireman() , 34_000.0);
		payRoll.put(bruce, 50_000.0);
		payRoll.put(new Fireman("mary"), 75_000.0);
		payRoll.put(bruce, 100_000.0);
		payRoll.putIfAbsent(bruce, 250_000.0);
		Fireman fred=new Fireman("fred");
		System.out.println(payRoll.put(fred, 200_000.0));//will display null
		System.out.println(payRoll.put(fred, 10_000.0));//will display 200,000 and give new value of 
		//10,000 to fred
		/*
		 * the value 25,000 is NOT put in for fred, as the key fred the fireman already exists
		 * and this will display the current value for fred
		 */
		System.out.println(payRoll.putIfAbsent(fred, 25_000.0));
		System.out.println("wages of bruce "+payRoll.get(bruce));
		
		System.out.println(payRoll);
		//a key or a value can be any object, including a set, map
		//this is a huma and a set of Dogs
		Map<Human,Set<Dog>>mapsList;
		//this is a set of Animals and a human value
		Map<Set<Animal>,Human>listMaps;
		//this is a human key and a map<String,Double> value
		Map<Human,Map<String,Double>>mapMaps;
		//this is a Human key and a Set of Animal value
		Map<Human,Set<Animal>>mapHumanAnimals;
		//this is map of Human keys and a set value of objects that are Dogs or super classes of Dogs
		Map<Human,Set<? super Dog>>funkyMap;
		/*
		 * what determines is a key is unique, is the equals() and the hashcode()
		 * in Nurse class we have overriden the equals and the hashcode such that if two nurses
		 * have the same name they will have:
		 * the same hashcode
		 * return true when equals is run against both of them
		 */
		Nurse nurse1=new Nurse("helen");
		Nurse nurse2=new Nurse("mary");
		Nurse nurse3=new Nurse("helen");
		/*
		 * a hashMap with a Nurse key, which means each nurse has to be unique and will be determined
		 * that is it unique by the equals and the hashCode() method in the Nurse class
		 * it has a Double value
		 */
		Map<Nurse,Double>nurses=new HashMap<>();
		/*
		 * what determines if a nurse key is already in the hashMap is the name
		 * nurse1 is called helen, so this value and key will be input
		 * nurse2 is a called mary, so this value and key will be input
		 * nurse3 is also called HELEN, so this is determined to be the same as nurse1 (as the
		 * equals and hashcode method only uses name) so two nurse called "helen" cannot be used
		 * as keys, so the second value of 100,000.00 is put in for the nurse called "helen"
		 */
		nurses.put(nurse1, 25_000.0);
		nurses.put(nurse2, 56_000.0);
		nurses.put(nurse3, 100_000.0);
		/*
		 * putIfAbsent does not put in a value if the a nurse names "helen" already is in the
		 * hashMap
		 */
	//	nurses.putIfAbsent(nurse3, 1_000_000.00);
		
		System.out.println(nurses);
		System.out.println(nurses.get(nurse1));
		System.out.println(nurses.get(nurse3));
		
		Dog dog1=new Dog();//this key will be inputted
		Dog dog2=new Dog();//this key will NOT be inputted, because has same name and age as first dog
		Dog dog3=new Dog("spot",1);//this key will be inputted
		Dog dog4=new Dog("spot",1);//this key will NOT BE INPUT
		Map<Dog,String>dogMap=new HashMap<Dog,String>();
		
		dogMap.put(dog1, "dog1");//Key and value input
		dogMap.put(dog2, "dog2");//key not input, value is input
		dogMap.put(dog3, "dog3");//key and value is input
		dogMap.put(dog4, "dog4");//key not input, value is input
		
		System.out.println(dogMap);
		
		Map<Integer,String>namesMap=new HashMap<>();
		namesMap.put(1, "ann");
		namesMap.put(2, "bríd");
		namesMap.put(3, "mary");
		namesMap.put(4, "paddy");
		namesMap.put(5, "kathleen");
		for(int i=1;i<=namesMap.size();i++)
			System.out.println("namesMap "+namesMap.get(i));
		
		namesMap.put(5000, "noel");
		namesMap.put(7, "ann");
		namesMap.put(123, "colm");
		namesMap.put(99, "shelly");
		namesMap.put(101, "laura");
		namesMap.put(99, "denise");
		
		System.out.println(namesMap);
		
		System.out.println("keySet()");
		/*
		 * this returns a SET containing all of the keys for namesMap
		 * in this case, it will be a SEt of Integers
		 */
		System.out.println("all the keys"+namesMap.keySet());
		/*
		 * this returns a Collection of the values for namesMap
		 * in this case, it will be a Collection of Strings
		 */
		System.out.println("values()");
		System.out.println("all the values "+namesMap.values());
		/*
		 * the order of the keys and values WILL match
		 */
		for(Integer i:namesMap.keySet())
			System.out.println("key is "+i);
		for(String s:namesMap.values())
			System.out.println("value is "+s);
		//this will get the value colm
		System.out.println("value of key 123 is "+namesMap.get(123));
		
		for(Integer k:namesMap.keySet()) {
			//the values for each key
			System.out.println("key is "+k+" and value is "+namesMap.get(k));
		//	System.out.println("key is "+k);
			System.out.println(k.hashCode());//hashCode for Integer is just the number
		//	syso
		}
		
		Map<Fireman,Double>fireWages=new HashMap<>();
		Fireman sam=new Fireman();
		fred=new Fireman();
		fireWages.put(sam, 50_000.0);
		fireWages.put(fred, 50_000.0);
		/*
		 * Map.Entry is an interface that has three methods getKey(),getValue() and setValue()
		 * we use this structure for going through a HashMap and get the key, getting the value and changing
		 * the value for a particular entry
		 * getKey here will return whatever the data type we have said our key is, in this case
		 * an Integer
		 * getValue will return the value and the data type we have said our value is, in this case
		 * a String
		 * Map.Entry<K,V>
		 */
		Map.Entry<Integer,String>myEntry=new Map.Entry<Integer,String>() {

			@Override
			public Integer getKey() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getValue() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String setValue(String value) {
				// TODO Auto-generated method stub
				return null;
			}
			
			
		};//end of anonymous inner class
		
	//	Map.Entry<Integer,String>myEntry	
		System.out.println("entrySet");
		/*
		 * produces a set made up of objects that implement the Map.Entry interface, that takes here
		 * a Integer and a string
		 * namesMap.entrySet() produces the object that is a set of Map.Entry<Integer,String> objects
		 * that are based on namesMap()
		 */
		Set<Map.Entry<Integer, String>>myWierdSet=namesMap.entrySet();
	System.out.println(namesMap.entrySet()	);
	/*
	 * this structure does NOT allow you to remove records
	 */
	for(Map.Entry<Integer, String>entry:namesMap.entrySet()) {
		//this will get the key of every entry in our hashMap
		System.out.println("key is "+entry.getKey());
		//this will get the value of every entry in our hashMap
		System.out.println("value is "+entry.getValue());
		//if the value is "ann", it will change the value to "kate"
		if(entry.getValue().equals("ann"))
			entry.setValue("kate");
		/*
		 * you can't remove an entry from any collection or map while iterating through it using a 
		 * Loop, you can only remove entries with an Iterator
		 */
	//	if(entry.getValue().equals("mary"))
			/*
			 * this gives you a ConcurrentModifciationException as you can't remove items from a 
			 * Collection (list,queue,Set) or Map as you are iterating through one of these using
			 * a loop. for this you have to use a Iterator
			 */
			//entry.getKey() returns 3, so that reads namesMap.remove(3)
		//	namesMap.remove(entry.getKey());
		
	}//ann has now being replaced by Kate
	/*
	 * this is a SET
	 */
		System.out.println(namesMap.entrySet());
		//setValue() modifies the value in the hashMap
		//THIS IS A HASHMAP
		System.out.println(namesMap);
		
		Iterator<Map.Entry<Integer, String>>iterator=namesMap.entrySet().iterator();
		/*
		 * using this iterator, we will delete the key value pair, 3=mary
		 */
		while(iterator.hasNext()) {
			/*
			 * iterators starts before entrySet, so first time will got to first element in list
			 * and sets that string element to be str
			 */
			String str=iterator.next().getValue();
			//if str is "mary"
			if(str.equals("mary"))
				//remove the record
				iterator.remove();
		}
		System.out.println(namesMap);
		
		System.out.println("putAll");
		System.out.println("you can add a existing HashMap to a hashMap by using putAll()");
		
		Map<Integer,String>moreNames=new HashMap<>();
		moreNames.put(333, "josie");
		moreNames.put(1, "patsy");
		/*
		 * putAll adds the contents of One hashMap to another, if a key already exists, the value will
		 * NOT BE ADDED 
		 * ***NOTICE 1, PATSY HAS THE SAME ID AS 1, KATE, its still 1, kate after the putAll
		 */
		moreNames.putAll(namesMap);
		System.out.println(moreNames);	
		/*
		 * using Streams to iterate through a HashMap
		 * a LOT LOT EASIER
		 */
		System.out.println("Streams");
		moreNames.entrySet().stream().forEach(e->System.out.println(e.getKey()+":"+e.getValue()));
		System.out.println("using filter with streams");
		moreNames.entrySet().stream().filter(a->a.getKey()>10).forEach(a->System.out.println(a.getValue()));
		System.out.println("print out all kates");
		moreNames.entrySet().stream().filter(a->a.getValue().equals("kate")).
		forEach(a->System.out.println(a.getKey()+" : "+a.getValue()));
		System.out.println("without Streams");
		moreNames.forEach((k,v)->System.out.println("key is "+k+" value is "+v));
		 
	}
/**
* LINKED hashSEt, items are displayed in order they entered, LINKED MEANS they are displayed in
* the order they are inserted
* LinkedHashMap are displayed in the order they were entered, go to
* <a href="https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html">click here</a> for detailed information
 * class declaration is {@code Class LinkedHashMap<K,V>}
 * @see com.android.animals.Dog
 */
	static void ex13() {
		System.out.println("linkedHashMap");
		Dog spot=new Dog("spot",2);
		Dog rex=new Dog("rex",7);
		Dog benji=new Dog("benji",5);
		Dog lassie=new Dog("lassie",3);
		/*
		 * LINKED hashSEt, items are displayed in order they entered, LINKED MEANS they are displayed in
		 * the order they are inserted
		 * LinkedHashMap are displayed in the order they were entered
		 */
		Map<Integer,Dog>dogLinked=new LinkedHashMap<>();
		dogLinked.put(spot.hashCode(), spot);
		dogLinked.put(rex.hashCode(), rex);
		dogLinked.put(benji.hashCode(), benji);
		System.out.println(dogLinked);
		
		dogLinked.put(benji.hashCode(), lassie);
		System.out.println(dogLinked);
		dogLinked.put(benji.hashCode(), new Dog("prince",25));
		System.out.println(dogLinked);
		
		Map<Integer,String>linkedAnimal=new LinkedHashMap<>();
		int counter=0;
		linkedAnimal.put(++counter, "pig");
		linkedAnimal.put(++counter, "sheep");
		linkedAnimal.put(++counter, "chicken");
		
		System.out.println(linkedAnimal.values());
		System.out.println(linkedAnimal.keySet());
		System.out.println(linkedAnimal.entrySet());
		
	}
	/**
	 * Tree maps are maps with all the same advantages of MAPS, but the KEY  has to implement the
	 * comparable interface (Integers, all numbers, Strings, etc implement the comparable interface)
	 * I.E if you have a  numeric type as a a key, then your records will be stored in ascending order
	 * according to the key
	 * this class implements
	 * {@code Map<K,V>}
	 * {@code NavigableMap<K,V>}
	 * {@code SorteMap<K,V>}
	 * classes that do not implement comparable cannot be added to as a value the Tree map, but you can create a 
	 * TreeMap with a key type that does not implement Comparable i.e
	 * we create a TreeMap, which WILL COMPILE
	 * {@code TreeMap<Animal,Integer>animalTreeMap //this will compile}
	 * we cannot add the following, because Animal does NOT implement comparable and only classes that implement
	 * comparable can be entered as a Value
	 * {@code animalTreeMap.put(new Animal(),34)//will not compile }
	 * however we have the Rat class which DOES IMPLEMENT COMPARABLE and Rat is a subclass of Animal
	 * {@code animalTreemap.put(new Rat}
	 * go to 
	 <a href="https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html">click here</a> for detailed information
	 class declaration is {@code Class TreeMap<K,V>}
	 @see com.android.humans.Fireman FireMan does NOT implement comparable, but you can create a Treemap with the
	 Fireman as a key as a subclass of Fireman could implement Comparable
	 @see com.android.animals.Animal Animal does NOT implement comparable, but you can create a TreehMap with the 
	 Animal as a key as a subclass of Animal could implement comparable, as Rat does
	 @see com.android.animals.Rat Rat DOES implement comparable so Rat can be added as a key to TreeMap
	 */
	static void ex14() {
		System.out.println("******TreeMap");
		/*
		 * Tree maps are maps with all the same advantabes of MAPS, but the KEY  has to implmenent the
		 * comparable interface (Integers, all numbers, Strings, etc implement the comparable interface)
		 * I.E if you have a  numeric type as a a key, then your records will be stored in ascending order
		 * according to the key
		 * this class implements
		 * Map<K,V>
		 * NavigableMap<K,V>
		 * SorteMap<K,V>
		 */
		Map<Integer,String>animalTm=new TreeMap<Integer,String>();
		animalTm.put(5, "camel");
		animalTm.put(1, "horse");
		animalTm.put(3, "sheep");
		animalTm.put("cow".hashCode(), "cow");
		animalTm.put("chicken".hashCode(), "chicken");
		
		System.out.println(animalTm);
		/*
		 * only those classes that implement the comparable interface can be added as a key in a TreeMap, however
		 * it's not an error to create a TreeMap whose type does not implement the Comparable interface.
		 * this line of code WILL compile
		 */
		Map<Fireman,Integer>fireInt=new TreeMap<>();
		/*
		 * this will genereate a classCastException as Fireman does not implement Comparable
		 */
	//	fireInt.put(new Fireman(), 1234);
		
		Map<Animal,Integer>animalInt=new TreeMap<>();
		/*
		 * this will not be added as Animal does NOT IMPLEMENT the comparable interface
		 */
		//animalInt.put(new Animal(), 788);
		/*
		 * this WILL be added as Rat DOES IMPLEMENT comparable interface and does extend Animal so can be
		 * added to a TreeMap<Animal,Integer>
		 * objects that are keys in a TreeMap, HAVE TOO implment the comparable interface, like objects that
		 * are inserted in TreeSet does
		 */
		animalInt.put(new Rat(1,"ronnie"), 56);
		//animalTm<Integer,String>
		System.out.println(animalTm);
		//will display in reverse order
		Map<Integer,String>reverseAnimal=new TreeMap<>(Collections.reverseOrder());
		reverseAnimal.putAll(animalTm);
		System.out.println(reverseAnimal);
	}
	/**
	 * this shows some methods common to all Collection and Map objects
	 * this section also acts as a further introduction to Functional programming as some of these methods
	 * use java 8 built in funtional Interfaces, each of the functional interfaces mentioned in the code will
	 * be briefly explained, a more in depth explanation of these functional interfaces will be described in 
	 * section 2.4 WorkingWithFunctionalInterfaces
	 ForEach method
	 * this is a method that works for all classes that implement the Collection interface and maps, it uses
	 * a Consumer functional interface object to go through each of the items in our list (consumer functional
	 * interface will be dealt with in detail in section 4.2 WorkingWithFunctionalInterfaces)
	 * A forEach for a map takes takes a bi-consumer functional interface object to go through the items in the 
	 * map(Bi-consumer functional interface will be dealt with in detail in section 4.2 WorkingWithFunctionalInterfaces)
	 * ReplaceAll method
	 * takes a unary operator functional interface and replaces all items in the list that match what is 
	 * passed to this method
	 * RemoveAll takes a list and removes all items on that list from another list, i.e we have a list of the names
	 * noel, pat, mary, harry, kate, pat, pat, noel, mary called list1
	 * and another list of noel, pat call list2. removeAll will remove all items of list2 from list1, so list1 will
	 * remove all instances of noel, and pat
	 */
	static void ex15() {
		List<Integer>intList=new ArrayList<>();
		intList.addAll(Arrays.asList(23,45,67,45,89,99,100));
		System.out.println("forEach");
		/*
		 * works for all objects that imeplement the collection interface (List,Set,Queue) and maps
		 * goes through each item in the list and performs some action, without changing the orginal 
		 * list
		 * a forEach for a list, Set or queue takes a consumer, takes a object and returns void
		 */
		intList.forEach(a->System.out.println("double  the number "+(a*2)));
		Map<Integer,String>nameMap=new HashMap<>();
		nameMap.put(3, "mary");
		nameMap.put(7, "kate");
		nameMap.put(15, "pat");
		/*
		 * a forEach for a Map takes a bi-Consumer, A bi consumer takes two objects and return void
		 * this forEach is called by a hashMap that is like the following
		 * Map<Integer,String>nameMap
		 * so k will be a Integer
		 * and v will be a string
		 */
		nameMap.forEach((k,v)->System.out.println("key is "+k+" value is "+v));
		
		System.out.println("replaceAll");
		/*
		 * replaceAll, replaces all of the values in a Set,List or 	Queue
		 */
		System.out.println("before change");
		System.out.println(intList);
		/*
		 * it takes a unary operator, which is it takes an object of a type and returns an object
		 * of the same type.
		 * here it takes an int and returns an int
		 * this multiplies all our numbers by three, so our list now has numbers that are the orginal
		 * numbers multiplied by 3
		 */
		intList.replaceAll(a->a*3);
		System.out.println("After change");
		System.out.println(intList);
		System.out.println("divide all by 3");
		intList.replaceAll(a->a/3);
		System.out.println(intList);
		intList.add(23);
		
		System.out.println("removeAll");
		/*
		 * removeAll searches the list intList for the all the numbers that are contained in newList
		 * 23,89,1000
		 * only 23 and 89 exist in both lists, so only these two numbers are removed
		 */
		System.out.println(intList);
		List<Integer>newList=Arrays.asList(23,89,1000);
		/*
		 * intlist has 23 in it twice, and both instances of 23 are removed
		 */
		intList.removeAll(newList);
		System.out.println(intList);
		System.out.println("removing duplicates, add to set");
		intList.addAll(Arrays.asList(23,45,45,23,23));
		System.out.println(intList);
		Set<Integer>setInt=new HashSet<>(intList);
		System.out.println(setInt);
		Set<Integer>treeInt=new TreeSet<>(intList);
		System.out.println(treeInt);
		
		System.out.println("****toArray");
		/*
		 * puts the contents of a collection to a an array
		 */
		int size=treeInt.size();
		
		Integer[]intArray=treeInt.toArray(new Integer[size]);
		for(Integer i:intArray)
			System.out.println("array is "+i);
		
		Map<Integer,String>myMap=new HashMap<>();
		for(Integer i:treeInt)
			myMap.put(i,"str"+i);
		System.out.println(myMap);
		System.out.println("maps****");
		/*
		 * this removes the entry with the key of 67 and the value of "str67"
		 */
		myMap.remove(67);
		System.out.println(myMap);
		/*
		 * this type of remove, will ONLY remove this entry, if the key and value match a key and value
		 * in the map. it does NOT, as the key 99, has the value "str99"
		 */
		myMap.remove(99,"banana");
		System.out.println(myMap);
		/*
		 * will only replace the value if teh existing value is "banana", its' not so not replaced
		 */
		myMap.replace(99, "banana", "orange");
		System.out.println(myMap);
		myMap.replace(99, "str99", "banana");
		System.out.println(myMap);
		myMap.replace(100, "peach");
		System.out.println(myMap);
		//replace does NOT put in new values, so this is not input
		myMap.replace(120, "apple");
		System.out.println(myMap);
		/*
		 * replaceAll changes ALL OF THE VALUES
		 * here it changes each value to the following
		 * 99=99str, 100=100str, 23=23str, 45=45str
		 */
		myMap.replaceAll((k,v)->{
		//	v=k+"str";
			return k+"str";
		});
		System.out.println(myMap);
		

	}
	
				
}
