package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * all Collections, that is SET, LISTS, QUEUES are NOT THREAD SAFE
 * also all classes that implements the Map interface are also NOT THREAD SAFE
 * The Concurrency API is a collection of interface that allow thread safe
 * sets, lists, queues and maps
 * @author noelf
 *
 */
public class Examples {

	static void ex1() {
		Map<String,Object>foodData=new HashMap<String,Object>();
		List<String>names=new ArrayList<>(Arrays.asList("noel","pat","mary","laura"));
		foodData.put("penguin", 1);
		foodData.put("flamingo",2);
		foodData.put("lion", 3);
		System.out.println(names);
		System.out.println(foodData);
		/*
		 * this generates ConcurrnetModificationException as the string "name" is used to iterate over
		 * a list of four strings called names, so if we remove one of those strings, this is now
		 * a list of 3 strings, which we can we iterate
		 */
		for(String name:names)
			names.remove(name);
		foodData.keySet();//returns a set of strings which are the keys of this hashMap
		/*
		 * this produces a ConcurrnetModificationException, as the string "key" can only iterate over
		 * a set of 3 strings. so if we remore one of those strings, it can no longer iterate over 
		 * the set that is lef
		 */
//		for(String key:foodData.keySet()) {
		//	if(key.contentEquals("penguin"))
//				foodData.remove(key);
//		}
				
	}
	//this hashmap is not in itself thread safe
	private static Map<String,Animal>zooAnimal=new HashMap<String,Animal>();
	static void ex2() {
		Examples ex1=new Examples();
		/*
		 * these methods are all synchronized so are thread safe methods
		 * so we are inserting values into the zooAnimal hashMap in a thread
		 * safe manner
		 */
		ex1.put2("spot", new Animal("Dog"));
		ex1.put2("tibbles", new Animal("Cat"));
		ex1.put2("leo", new Animal("Lion"));
		/*
		 * this is NOT a thread safe method, so multiple threads could insert values
		 * into this hashmap at the same time by using the put() method of hte 
		 * HashMap class
		 */
		zooAnimal.put("gerry", new Animal("giraffe"));
		System.out.println(zooAnimal);
		ExecutorService service=Executors.newFixedThreadPool(10);
		try {
			Future<Animal>myStrAnimal=null;
			/*
			 * the hashMap is not threadsafe, but the remove2 method IS THREAD SAFE
			 * so this will remove all entries in the zooAnimal hashMap
			 */
			for(String key:zooAnimal.keySet()) {
				service.submit(()->ex1.remove2(key));
			}
	
			Thread.sleep(100);
		}
		catch(Exception e) {
			
		}
		finally {
			
			if(!service.isShutdown())
				service.shutdown();
			System.out.println(zooAnimal);
		}
		
		
	}
	/*
	 * thread safe method for adding entries to the zooAnimal hashMap
	 */
	public synchronized void put2(String key,Animal value)
	{
		zooAnimal.put(key, value);
	}
	/*
	 * thread safe method for getting values from the zooAnimal hashMap
	 */
	public synchronized Animal get2(String key) {
		return zooAnimal.get(key);
	}
	/*
	 * thread safe method for remove entries from the zooAnimal hashMap
	 */
	public synchronized void remove2(String key) {
		zooAnimal.remove(key);
	}
	
	/*
	 * an alternative to the above technique is to to use specific thread safe collections
	 * we can use the Concurrency API (this is just a collection of interfaces that makes classes thread safe)
	 * these interfaces include performance enhancments that avoid unnecessary synchronization.
	 * so this is what we can  use to manage access to our collections across multiple threads
	 * the first type we will use is the CONCURRENTHASHMAP, the only difference from a normal
	 * hashMap is that the object type is a ConCurrentHashMap
	 */
	private static Map<String,Object>farm=new ConcurrentHashMap<String,Object>();
	/*
	 * this has all the same methods as the hashMap, but all of these methods are thread safe
	 * apart from they being thread safe, all the methods operate the exact same way
	 */
	static String statKey;
	static void ex3() {
		//this put() method is thread safe
		farm.put("1", "cow");
		farm.put("2", "sheep");
		farm.put("3", "pig");
		farm.put("4", "chicken");
		//this get() method is thread safe
		System.out.println("get of ConcurrentHashMap "+farm.get("3"));
		System.out.println("before remove ");
		System.out.println(farm);
		/*
		 * this is a thread safe version of the remove method
		 */
		for(String key:farm.keySet())
			farm.remove(key);
		System.out.println("after remove");
		System.out.println(farm);
		
		ExecutorService service=Executors.newFixedThreadPool(10);
		farm.put("1", "cow");
		farm.put("2", "sheep");
		farm.put("3", "pig");
		farm.put("4", "chicken");
	
	}
	/**
	 * you should use a concurrent collection class anytime you are going to have multiple threads modify a collection
	 * object outside of a synchronized block or method.
	 * if your collection is immutable or read only (in other words you can't change the collection) then a conncurrent 
	 * collection class is not needed
	 * it is considered good practise to pass a concurrent(thread safe) collection using a non concurrent interface reference
	 * void method(Map<String,Object>myMap){}
	 * and we would pass the following to this method
	 * Map<String,Object>farm=new ConcurrentHashMap<String,Object>();
	 * method(farm)
	 * list of Concurrent classes
	 * CLASS NAME						JAVA COLLECTIONS FRAMWORK INTERFACE
	 * 
	 * ConcurrentHashMap				ConncurrentMap				
	 * 
	 * ConcurrentLinkedDeque			Deque
	 * 
	 * ConcurrentLikedQueue				Queue
	 * 
	 * ConcurrentSkipListMap			ConcurrentMap
	 * 									SortedMap
	 * 									NavigableMap
	 * 
	 * ConcurrentSkipListSet			SortedSet
	 * 									NavigableSet
	 * 
	 * CopyOnWriteArrayList				List
	 * 
	 * CopyOnWriteArraySet				Set
	 * 
	 * LinkedBlockingDeque				BlockingQueue
	 * 									BlockingDeque
	 * 
	 * LinkedBlockingQueue				BlockingQueue
	 * 
	 * All these collections operate in much the same way as they're non synchronized version
	 * the only difference is how you actually the object itself i.e
	 * Set<String>myskipSet=new ConcurrentSkipListSet();
	 */
	static void ex4() {
		System.out.println("ConcurrentHashMap");
		/*
		 * implements the Map interface
		 */
		Map<String,Integer>map=new ConcurrentHashMap<>();
		map.put("zebra", 243);
		map.put("lion", 56);
		System.out.println(map.get("zebra"));
		/*
		 * ConcurrentHashMap also implements the ConcurrentMap interface, so we can also create a ConcurrentHashMasp
		 * this is a more specific hashMap so will be more thread safe
		 * you would use this if you want to make sure this operates correctly in multi threaded enviroment
		 */
		ConcurrentMap<Integer,String>map2=new ConcurrentHashMap<>();
		//thread safe queue
		System.out.println("ConncurrentLinkedQueue");
		Queue<Integer>queue=new ConcurrentLinkedQueue<>();
		System.out.println("Offer");//you can only add at the end of queue
		queue.offer(31);
		queue.offer(45);//this goes after 31
		queue.offer(100);//after 45
		queue.add(10);
		
		System.out.println(queue);
		System.out.println("you can only leave at the head of queue");
		System.out.println("peek");
		//this only retrieves the value at the head of the queue
		System.out.println(queue.peek());//31
		System.out.println("poll");
		//poll retrieves the value 31 and removes it from the queue
		System.out.println(queue.poll());//
		System.out.println(queue);
		/*
		 * thread safe deque, deque can add at end and beginning and can remove from end and beginning
		 * double ended queue
		 */
		System.out.println("ConcurrentLinkedDeque");
		Deque<Integer>deque=new ConcurrentLinkedDeque<>();
		/*
		 * can add from both ends
		 */
		deque.offer(12);//puts at end of deque
		deque.push(100);//puts at start of deque
		deque.offer(45);//puts at end of deque
		deque.push(120);//puts at start of deque
		/*
		 * can remove from both ends
		 * all methods of the queue are also available for deque
		 */
		System.out.println(deque);//[120, 100, 12, 45]
		System.out.println(deque.pop());//display first number and removes from deque
		System.out.println(deque.pollLast());//displays last element and removecs deque
		System.out.println(deque);
	}
	
	static void ex5() {
		System.out.println("Blocking queues");
		/*
		 * blocking classes implement the blocking interfaces and the ones we cover are 
		 * LinkedBlockingDeque and LinkedBlockingQueue both implement the BlockingQueue interface.
		 * these are like regular except they are thread safe and also include methods that wait a specific
		 * amount of time to complete a particular operation.
		 * methods of note are**************
		 * boolean offer(E e,long timeOut, TimeUnit unit)
		 * e is the type of object in your queue
		 * timeout is the amount of time
		 * timeUnit is the unit of time you want to use i.e nanoseconds to days
		 * adds item to the queue and will wait the specified time if the queue is not ready, if this
		 * goes over the set amount of time, this returns false. returns true if sucessfully added
		 * **********************
		 * poll(long timeOut,TimeUnit unit)
		 * retrireves and removes an item from the queue, waiting the specified time, returns null 
		 * if time elapses before the item if available
		 * 
		 * both of these methods can throw a checked exception InterruptedException, so they either
		 * have to be thrown by the method or in a try/catch block
		 */
		System.out.println("LinkedBlockingQueue");
		try {
			BlockingQueue<Integer>blockQueue=new LinkedBlockingQueue<>();
			
			System.out.println(blockQueue.offer(39));//return true as will be inserted
			/*
			 * this will add number 345 to the queue and wait for 4 seconds if necessary for space
			 * to become avaiable. returns false if time elapses before 345 is inserted into the queue.
			 * this will return true
			 */
			System.out.println(blockQueue.offer(345, 4, TimeUnit.SECONDS));
			System.out.println(blockQueue.offer(100, 4, TimeUnit.SECONDS));
			System.out.println(blockQueue.offer(200, 4, TimeUnit.SECONDS));
			System.out.println(blockQueue);
			if(blockQueue.offer(345, 4, TimeUnit.SECONDS))
				System.out.println("do some code");
			//remove at start of queue
			System.out.println(blockQueue.poll());//will display 39 and remove from queue
			/*
			 * retrives and removes the head of the queue, wihc by now will be the number 345 and will
			 * wait for 4 seconds if necessary for the queue to be ready to remove the number. returns 
			 * null if the time elapses
			 */
			System.out.println(blockQueue.poll(4, TimeUnit.SECONDS));//will display 345 and remove from queue	
		}
		catch(Exception e) {
			System.out.println("e is "+e);
			
		}
		
		System.out.println("LinkedBlockingDeque");
		/*
		 * as this class extends both queue and deque, all the methods of those classes are also 
		 * available to this and also all of the methods of the BlockingQueue
		 */
		try {
			BlockingDeque<Integer>blockDeque=new LinkedBlockingDeque<>();
			blockDeque.offer(34);//insert at end of queue
			blockDeque.push(50);//no overloaded push method
			blockDeque.offer(120, 4, TimeUnit.MILLISECONDS);//end of deque
			blockDeque.offerLast(56, 4, TimeUnit.MINUTES);//end of deque
			blockDeque.offerFirst(234, 3, TimeUnit.MICROSECONDS);//start of deque
			System.out.println(blockDeque);
			
			System.out.println(blockDeque.poll());
			/*
			 * retrieves and removes head of deque, waiting 950 milliseconds if needed
			 */
			System.out.println(blockDeque.poll(950, TimeUnit.MILLISECONDS));
			/*
			 * removes head of deque and waits 200 nanoseconds if needed
			 */
			System.out.println(blockDeque.pollFirst(200, TimeUnit.NANOSECONDS));
			/*
			 * removes last element of deque and waits 1 second if needed
			 */
			System.out.println(blockDeque.pollLast(1, TimeUnit.SECONDS));
			System.out.println(blockDeque);
			
		}
		catch(Exception e) {
			
		}
	}
	
	static void ex6() {
		System.out.println("SkipList");
		/*
		 * ConcurrentSkipSet and ConcurrentSkipListMap are concurrent thread safe versions of 
		 * TreeSet and TreeMap
		 * TreeSet only allow objects that implement the comparable interface or uses a comparator
		 */
		TreeSet<Integer>tInt=new TreeSet<>();//does not allow duplicate entries
		tInt.add(1200);
		tInt.add(50);
		tInt.add(12);
		tInt.add(100);
		tInt.add(12);
		System.out.println(tInt);
		/*
		 * Human does not implement comparable, so a Human cannot be added to TreeSet, however you can
		 * create a TreeSet of Humans, as a sub class of Human could implement the Comparable Interface
		 */
		TreeSet<Human>humanTree=new TreeSet<>();//this causes no exception
	//	humanTree.add(new Human());//this causes a classCastException
		
		Duck ant=new Duck("ant");
		Duck zed=new Duck("zed");
		Duck bert=new Duck("bert");
		Duck duck2=new Duck("zed");
		/*
		 * this returns 0, and as we have no equals or hashCode method inside the Duck class this is 
		 * all we have to determine if two ducks are the same. If this method returns 0, the two ducks are
		 * said to be the same and duck2 will NOT be added to the TreeSet
		 */
		System.out.println(zed.compareTo(duck2));
		TreeSet<Duck>duckTree=new TreeSet<>(Arrays.asList(ant,zed,bert,duck2));
		System.out.println(duckTree);
		/*
		 * the key in a TreeMap, has to be unique, cannot be repeated. and organises the entries by the
		 * key
		 *  so the key in a TreeMap has to be
		 * object of a class that implements the Comparable interface. Integer implements the comparable
		 * interface so this will compile and run. the value can be any object, and you can have repeating
		 * values
		 */
		Map<Integer,String>myMap=new HashMap<>();
		myMap.put(2, "John");
		myMap.put(1, "mary");
		myMap.put(3, "mary");
		myMap.put(1, "pat");//this will overwrite the key value pair of 1,mary
		System.out.println(myMap);//will print 1=pat, 2=John, 3=mary
		Map<Animal,String>myAnimalMap=new TreeMap<>();
	//	myAnimalMap.put(new Animal("dog"), "spot");//generates classCastException
	//	myAnimalMap.put(new Animal("dog"), "rex");
	//	System.out.println(myAnimalMap);
		Map<Duck,Integer>duckMap=new TreeMap<>();
		//this map will be organised by the key, which is a duck, which implements the Comparable interface
		//and organises by Duck name alphabetically
		duckMap.put(new Duck("daffy"), 11);
		duckMap.put(new Duck("andy"), 50);
		System.out.println(duckMap);
		
		System.out.println("Concurrent (Thread safe) version of Treeset is ConcurrentSkipListSet");
		NavigableSet<String>set=new ConcurrentSkipListSet<>();
		/*
		 * only objects that implement the comparable interface can be added to a 
		 * ConcurrentSkipListSet and the same rules for TreeSet apply to it, but it is thread 
		 * safe and all the methods of this class are also thread safe
		 */
		set.addAll(Arrays.asList("zed","Zed","bee","ant","Caroline","angela","123","+","bee"));
		System.out.println(set);
		/*
		 * same rules for TreeMap as ConcurrentSkipListMap, except that this collection object
		 * is Thread safe and can only be accessed by one thread at a time
		 */
		NavigableMap<Integer,String>navMap=new ConcurrentSkipListMap<>();
		NavigableMap<Duck,String>navMap2=new ConcurrentSkipListMap<>();
		/*
		 * all the methods of this class are thread safe
		 */	
	}
	
	static void ex7() {
		System.out.println("CopyOnWriteCollections");
		/*
		 * CopyOnWriteArrayList and CopyOnWriteSet implement the list and set interface respectively.
		 * these operate differently to other concurrent classes in that these classes copy all of the 
		 * elements to a new underlying structure anytime an element is added,modified or removed
		 * from a collection.
		 * although the data is copied to a new underlying structure our reference to the object
		 * does not change.
		 * if an iterator is established prior to any modification then it will not see any changes
		 * and will merely iterate over the original elements prior to modification.
		 */
		List<String>list=new ArrayList<>(Arrays.asList("noel","tom","mary","shelly","laura","jack"));
		Iterator myIter=list.iterator();
		while(myIter.hasNext())
			System.out.println(myIter.next());
		/*
		 * this will print out nothing, because after the pervious loop the iterator is at the end of the 
		 * list
		 */
		System.out.println("prints nothing");
		while(myIter.hasNext())
			System.out.println(myIter.next());
		/*
		 * ListIterator goes both ways
		 */
		System.out.println("listIterator");
		ListIterator myListItr=list.listIterator();
		while(myListItr.hasNext())
			System.out.println(myListItr.next());//this goes forward to end of list
		System.out.println("go the other way");
		while(myListItr.hasPrevious())
			System.out.println(myListItr.previous());//this goes backward to start of list
		System.out.println("**myIter");
		
		myIter=list.iterator();
		/*
		 * if you add any item to the list and then try to use this iterator to iterate over the list
		 * you will get a ConcurrentModificationException, as this list is not thread safe, so the iterator
		 * is not thread safe
		 */
		//list.add("satan");
		/*
		 * if you remove any item from the list and then try to use this iterator you also get a 
		 * ConcurrentModificationException, as not thread safe
		 */
		//list.remove("tom");
		/*
		 * this will NOT cause a ConcurrentModificationException this will cause the iterator to iterate over
		 * the OLD LIST which contained the strings
		 * "noel","tom","mary","shelly","laura","jack"
		 */
		list=new ArrayList<>(Arrays.asList("str","str","str"));
		while(myIter.hasNext())
			System.out.println(myIter.next());
		
		list=new ArrayList<>(Arrays.asList("noel","tom","mary","shelly","laura","jack"));
		/*
		 * this also produces a ConcurrentModificationException as list is still NOT THREAD SAFE
		 */
	/*	for(String s:list)
			list.add("new String");*/
		List<Integer> copyList = new CopyOnWriteArrayList<>(Arrays.asList(4,3,52));
		System.out.println("copyList");
		/*
		 * by using a thread safe CopyOnWriteArrayList you CAN add and remove objects from the list
		 * here for every number in this list, we will add a number 99, so the number 99 well be addded three times.
		 * However you will NOT be able to see the changes in the loop. it's only AFTER the loop, we will see that
		 * 99 has been added three times to the loop
		 */
		for(Integer i:copyList) {
			copyList.add(99);
			System.out.println(i);
		}
		System.out.println(copyList);
		/*
		 * we can remove from the list
		 * if the nubmer is 99, this will be removed from the list
		 */
		for(Integer i:copyList) {
			if(i==99)
				copyList.remove(i);
			System.out.println(i);
		}
		System.out.println(copyList);
		
		Iterator<Integer>copyIter=copyList.iterator();
		copyList.add(1000);
		/*
		 * this code will run, but the iterator is still based on the orginal list of 
		 * 4,3,52 and will not display the number 1000, even though copyList now has this
		 * number it int
		 */
		while(copyIter.hasNext())
			System.out.print(copyIter.next()+",");//4,3,52,
		System.out.println();
		System.out.println(copyList);//4, 3, 52, 1000
		
		/*
		 * the CopyOnWrite classes can use a lot of memory since a new collection structure needs to allocated
		 * anytime the collection is modified. They are commonly used in multi-threaded environment where reads
		 * are more common than writes
		 */
			
	}
	
	static void ex8() {
		System.out.println("Synchronized version of existing non-Current collections");
		List<Integer>list=Stream.generate(()->(int)(Math.random()*100)+1).limit(10).collect(Collectors.toList());
		//this is the easier way to convert a non thread safe collection type to a thread safe collection type
		List<Integer> copyList = new CopyOnWriteArrayList<>(list);
		System.out.println(list);
		/*
		 * this returns a synchronized version of the list arraylist, this synchronizes  the get and the SEt methods
		 * of this object. So only one thread can add an item to this list at at time and only one thread can modify
		 * any item in this list at a time, however the iterators are NOT synchronized
		 */
		List<Integer>syncList=Collections.synchronizedList(list);
		Iterator<Integer>myIter=syncList.iterator();
		//may threads CAN use the add() method, which means that the add() method is NOT thread safe
		
/*		while(myIter.hasNext())//causes ConcurrentModificationException
			System.out.println(myIter.next());*/
		synchronized(syncList) {
			syncList.add(1000);
			while(myIter.hasNext())
				System.out.println(myIter.next());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
