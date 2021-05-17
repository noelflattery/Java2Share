package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
	 * the comparable interface has one method
	 * compareTo(), here we will be implementing the comparable interface and overriding the 
	 * compareTo() method 
	 * comparable interface looks like 
	 * {@code interface Comparable<T>{
	 * 		  	int compareTo(T arg) 
	 * 	}
	 * }
	 * for more details to do with comparable interface 
	 * <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html">Tclick here</a> 
	 * comparable is a functional interface, so we can create lambdas from this interface, 
	 * Comparator is a seperate interface and has a COMPARE() METHOD
	 * The comparator interface has the following Structure
	 * {@code  interface Comparator<T>{
		  		public int compare(T t,T t2)
		  }
		}
	 * for more details on Comparator interface
	 * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html">Tclick here</a> 
	 * to explain how compareTo works we will give the example of the String class. String class
	 * implements the Comparable
	 * say we are calling teh follwing
	 * str1.compareTo(str2)
	 * compareTo returns 0 if both the same String
	 * "apple".compareTo("apple");
	 * returns a NEGATIVE number if the string calling the method comes BEFORE the string sent to the 
	 * method
	 * "apple".compareTo("berry")
	 * returns a POSITIVE number if the string calling the method comes AFTER the string sent to the 
	 * method
	 * "berry".compareTo("apple");
		Objects, whose class implements comparable, can be used by ALL collection class objects and Maps to 
		arrange the order of objects in any collection.
		These objects are also the only objects taht can be inserted into a TreeSet and the only objects
		that can be a key in TreeMap
	 */
public class Examples {
	/**
	 * here we are using the compareTo() of the Comparator interface. All Numeric wrapper classes and Strings implement
	 * the Comparator interface, so both Strings and numbers have a compareTo method
	 * TreeSets is a object that implements the collection and Set interface, and cannot add to items that are said
	 * to be the same AND the objects inserted into a TreeSet have to implement the Comparable interface. TreeSet
	 * uses the objects compareTo method to order the items in the TreeSet
	 */
	static void ex1() {
		System.out.println("strings ");
		System.out.println("adam".compareTo("zee"));//returns a minus
		System.out.println("betty".compareTo("adam"));//returns a positive 
		System.out.println("betty".compareTo("betty"));//returns 0
		//returns positive as capital "Z" comes before lower case "a"
		System.out.println("adam".compareTo("Zee"));
		/*
		 * can't use null with compareTo, as null as no value and you can't compare nothing with
		 * something.
		 * if you can't use null with compareTo, that means you can't add null to TreeSet or as a Key
		 * in a TreeMap
		 */
		Set<Integer>mySet=new TreeSet<>();
		/*
		 * this will generate a NullPointerException
		 */
	//	mySet.add(null);
		Integer one=1;
		Integer two=2;
		Integer twentytwo=22;
		Integer minusFive=-5;
		System.out.println("comparing Integers");
		System.out.println(one.compareTo(two));//-1
		System.out.println(twentytwo.compareTo(one));//1
		System.out.println(twentytwo.compareTo(minusFive));//1
		System.out.println(one.compareTo(one));//0
		/*adds these numbers in no particular order, however as this is a TreeSet no duplicates are inserted
		 * then these numbers are autoboxed to be inserted as Integer wrapper objects. the Integer class implements
		 * comparable which means they can be inserted into a TreeSet, and the compareTo() method is used to 
		 * order the wrapper Integers in ascending order and we here up with 
		 * 
		 */
		mySet.addAll(Arrays.asList(7,99,8,3,1,2, 7, 7));
		System.out.println(mySet);
	}
	/**
	 * in this example both Rat and Ostrich implement the Comparable interface so can be added to a TreeSet
	 * and duplicate Rats or Ostrichs will not be entered and Rats will be order by 
	 * first name
	 * then age
	 * then weight
	 * Ostrichs will be ordered by
	 * first name
	 * then age
	 * then weight
	 * then id
	 * @see com.android.Rat
	 * @see com.android.Ostrich
	 */
	static void ex2() {
		System.out.println("rat class implements Comparable");
		
		Rat rat=new Rat("rory",3,12.4);
		Rat rat2=new Rat("rory",3,11.4);
		Rat rat3=new Rat("rory",2,12.4);
		Rat rat4=new Rat("angela",3,13.4);
		Rat rat5=new Rat("angela",3,13.4);
		Set<Rat>ratTree=new TreeSet<>();
		ratTree.addAll(Arrays.asList(rat,rat2,rat3,rat4,rat5));
		System.out.println(ratTree);
		
		Ostrich os1=new Ostrich("ollie",2,45.6);
		Ostrich os2=new Ostrich("ollie",2,45.6);
		Ostrich os3=new Ostrich("andy",3,54);
		Ostrich os4=new Ostrich("bill",3,67);
		Ostrich os5=new Ostrich("dermot",5,89);
		Ostrich os6=new Ostrich("dermot",3,99);
		Ostrich os7=new Ostrich("eddie",6,78);
		Ostrich os8=new Ostrich("eddie",6,74);
		Set<Ostrich>ostrichTree=new TreeSet<>();
		ostrichTree.addAll(Arrays.asList(os1,os2,os3,os4,os5,os6,os7,os8));
		System.out.println(ostrichTree);
	}
	/**
	 * whereas a class usually implements Comparable there is another interface we can use to put order
	 * on list and this is by using The Comparator interface, more details of which can be found here
	 * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html">Tclick here</a> 
	 * Comparator is a interface that has a compare() method
	 * The comparator interface has the following Structure
	 * {@code  interface Comparator<T>{
		  		public int compare(T t,T t2)
		  }
		}
	 * A class does not usually implement comparator and it's usually implemented with a seperate object that
	 * can be used to put order on a list. The Items then on the list do not have to implement comparator to be
	 * ordered as the Comparator object is ordering the list for us.
	 * what usually implements comparator interface is a lambda, and to a lesser extent anonymous inner class 
	 * implementation.
	 * To put order on lists(i.e arraylists) we can use the Collections.sort() method and we are concerned in
	 * this method with two overloaded methods, the first overloaded method takes a Collection object and the items
	 * in the collection object have to implement Comparable, 
	 * {@code collections.sort(Collections<Object implements Comparable>())}
	 * ie a list of Rats called ratList, Rats implement comparable, so a we could go
	 * {@code Collections.sort(ratList}
	 * the second overloaded method takes any object that implements the Collection interface which can contain
	 * any type of objects
	 *  AND a comparator object to sort the list, the Comparator object will usually be a lambda but you can use
	 *  an anonymous class as well, but lambdas are easier to use, when you get used to them
	 *  So we have a list of Ducks, called duckList, and ducks do NOT implement Comparable, so we use the 
	 *  Colections.Sort() method that takes a list and a comparator of type duck. this code will be explained
	 *  in the the code of the method
	 *  {@code Collections.sort(duckList(),(d1,d2)->d1.name.compareTo(d2.name)}
	 *  this method takes a list and the second object is a lambda implementation to sort ducks by they're 
	 *  names
	 *  @see com.android.Rat
	 *  @see com.android.Squirrel
	 */
	static void ex3() {
	//	Set<Integer>mySet=new HashSet<Integer>();
	//	mySet.addAll(Arrays.asList(567,200,240,3,-45,0,2));
		System.out.println("Comparators");
		/*
		 * TreeSet is a ordered list that does not allow duplicates
		 * its ordered by only allowing objects that implement the Comparable interface
		 * TreeMap the keys are a ordered list that does not allow duplicates
		 * the keys are ordered by only allowing objects that implement the Comparable interface
		 */
		List<Integer>listNum=new ArrayList<>();
		listNum.addAll(Arrays.asList(23,23,23,4,1,67,2,67,3,3,1002,-56,0));
		Set<Integer>mySet=new TreeSet<>();
		//Collections.sort(listNum);
		mySet.addAll(listNum);
		System.out.println(mySet);
		/*
		 * As well as using the comparable interface we could also use a seperate object of type 
		 * comparator to organise a list, (seperate method for using a comparator with a 
		 * set and hashMap and not used with queues)(not a treeSEt or treeMap). by using this
		 * a list of object does not need to implement the comparable interface
		 * interface Comparator<T>{
		 * 		public int compare(T t,T t2)
		 * }
		 * Comparable has a compareTo() method
		 * Comparator has a  COMPARE() method
		 */
		//classes usually do NOT implement Comparator
		/*
		 * more often than not, you use this by creating a anonymous inner class or a lambda, as this
		 * is a functional interface (only one abstract method)
		 */
		System.out.println("anonymous inner class implementation of Comparator");
		/*
		 * this is going to be used to organis a list of names, organised alphabetically and ignoring the
		 * case
		 */
		Comparator<String>byString=new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				return s1.compareToIgnoreCase(s2);
			}	
		};//end of anonymous class
		
		System.out.println("list of Strings");
		List<String>names=new ArrayList<>();
		names.addAll(Arrays.asList("bernie","ann","Ann","adam","Aidan","bernie","Ciara","Siobhan","mick",
				"shelly","LaURA","COLM"));
		System.out.println(names);
		/*
		 * only objects that implement comparable can use this particular method, String class does
		 * implement Comparable, and the compareTo() compares symbols first, numbers next, then
		 * upper case, then lower case
		 * this will organise names
		 */
		Collections.sort(names);
		//names is now sorted according to the rules of the compareTo method of the String class
		System.out.println(names);
		//clearing all strings
		names.clear();
		//adding original strings
		names.addAll(Arrays.asList("bernie","ann","Ann","adam","Aidan","bernie","Ciara","Siobhan","mick",
				"shelly","LaURA","COLM"));
		System.out.println(names);
		/*
		 * this uses the byString comparator, which just organises strings by alphabetical and ignores
		 * case
		 */
		Collections.sort(names, byString);
		System.out.println("ordered by alphabetical only");
		System.out.println(names);
		
		Squirrel sammy=new Squirrel("sammy",2,3);
		Squirrel sharon=new Squirrel("sharon",4,2);
		Squirrel samantha=new Squirrel("samantha",1,5);
		Squirrel sean=new Squirrel("sean",7,1);
	//	Squirrel sean2=new Squirrel("sean",5,2);//insert into squirrels list to see duplicates not removed
		
		List<Squirrel>squirrels=new ArrayList<>();
		squirrels.addAll(Arrays.asList(sammy,sharon,samantha,sean));
		System.out.println("squirrel list unordered");
		System.out.println(squirrels);
		System.out.println("Squirrels sorted by name uses compareTo in squirrel class");
		/*
		 * Collections.sort can only takes list of objects whose classes implement comparable
		 * Squirrel implments Comparable and the compareTo organises squirrels in a list by 
		 * names in alphabetical order
		 * N.B sorting does NOT remove duplicates names, see sean2
		 */
		Collections.sort(squirrels);
		System.out.println(squirrels);
		/*
		 * this sorts a list by weight of Squirrel
		 */
		Comparator<Squirrel>bySquirrelWeight=new Comparator<Squirrel>() {
			/*
			 * if this returns a minus number
			 * squirrel 1 comes before squirrel 2
			 * if returns a plus number
			 * squirrel 2 comes before squirrel 1
			 * if 0 they are the same and can be put in any order, but they will be together in the list
			 */
			@Override
			public int compare(Squirrel s1, Squirrel s2) {
				Integer s1Weight=s1.getWeight();
				Integer s2Weight=s2.getWeight();
				return s1Weight.compareTo(s2Weight);

			}	
		};//end of anonymous class
		
		squirrels.clear();//empties the list
		squirrels.addAll(Arrays.asList(sammy,sharon,samantha,sean));
		System.out.println("unsorted squirrels");
		System.out.println(squirrels);
		Collections.sort(squirrels, bySquirrelWeight);
		System.out.println("sorted by squirrel weight");
		System.out.println(squirrels);
		
		
		Comparator<Squirrel>bySquirrelHeight=new Comparator<Squirrel>() {
			/*
			 * if this returns a minus number
			 * squirrel 1 comes before squirrel 2
			 * if returns a plus number
			 * squirrel 2 comes before squirrel 1
			 * if 0 they are the same and can be put in any order, but they will be together in the list
			 */
			@Override
			public int compare(Squirrel s1, Squirrel s2) {
				Integer s1Height=s1.getHeight();
				Integer s2Height=s2.getHeight();
				return s1Height.compareTo(s2Height);

			}	
		};//end of anonymous class
		
		squirrels.clear();
		squirrels.addAll(Arrays.asList(sammy,sharon,samantha,sean));
		Collections.sort(squirrels, bySquirrelHeight);
		System.out.println("squirrels sorted by height");
		System.out.println(squirrels);
		/*
		Comparator<Squirrel>sqrComparator=new Comparator<Squirrel>() {

			@Override
			public int compare(Squirrel s1, Squirrel s2) {
				if(s1.equals(s2))
					return 0;
				if(!(s1.getName().equals(s2.getName())))
					s1.compareTo(s2);
				Integer weight1=s1.getWeight();
				Integer weight2=s2.getWeight();
				if(!(weight1.equals(weight2)))
					
				Integher
			}
			
		};*/
		
		Comparator<Rat>byRat=new Comparator<Rat>() {
			@Override
			public int compare(Rat r1, Rat r2) {
				/*
				 * you can add additional criteria in here
				 */
			//	if(!(r1.equals(r2))
					return r1.compareTo(r2);		
			}
		};
		
		Rat rat1=new Rat("roger",2,4.5);
		Rat rat2=new Rat("rachel",1,5.6);
		Rat rat3=new Rat("ray",3,7.8);
		Rat rat4=new Rat("ray",6,8.6);
		
		List<Rat>ratList=new ArrayList<Rat>();
		ratList.addAll(Arrays.asList(rat1,rat2,rat3,rat4));
		System.out.println("list of Rats");
		System.out.println(ratList);
		Collections.sort(ratList);
		System.out.println("sorted by compareTo");
		System.out.println(ratList);
		ratList.clear();
		ratList.addAll(Arrays.asList(rat1,rat2,rat3,rat4));
		System.out.println("sorted by compare");
		Collections.sort(ratList, byRat);
		System.out.println(ratList);
		/*
		 * Comparator is a function interface, so we usually use a lambda when creating a 
		 * compartor
		 */
		/*
		 * this will sort our list of Squirrels by weight 
		 * if s1 weight is 1 and s2 weight is 4
		 * we get 1-4= -3
		 * which means that s1 weight comes before s2 weight
		 * if s1 weight is 4 and s2 weight is 1
		 * we get 4-1=3
		 * which means that s1 weight comes AFTER s2 weight (we swap them)
		 */
		Comparator<Squirrel>byWeight=(s1,s2)->s1.getWeight()-s2.getWeight();
		
		squirrels.clear();
		squirrels.addAll(Arrays.asList(sammy,sharon,samantha,sean));
		Collections.sort(squirrels, byWeight);
		System.out.println(squirrels);
		/*
		 * this will be sorted in the opposite way, which is descending
		 */
		Comparator<Squirrel>byweightDesc=(s1,s2)->s2.getWeight()-s1.getWeight();
		squirrels.clear();
		squirrels.addAll(Arrays.asList(sammy,sharon,samantha,sean));
		Collections.sort(squirrels, byweightDesc);
		System.out.println(squirrels);
		
		ratList.clear();
		ratList.addAll(Arrays.asList(rat1,rat2,rat3,rat4));
		System.out.println("our list of Rats");
		System.out.println(ratList);
		Collections.sort(ratList);
		System.out.println("sorted rats in ascending order");
		System.out.println(ratList);
		/*
		 * this is just done in descening, which is the opposite of ascending. 
		 */
		Comparator<Rat>byRatLambda=(r1,r2)->r2.compareTo(r1);
		Collections.sort(ratList, byRatLambda);
		System.out.println("sorted rats in descending order");
		System.out.println(ratList);
			
	}
	/**
	 * this uses a class that does not implement the comparable interface, Duck class, and uses various comparators of 
	 * type Duck 
	 * {@code Comparator<Duck>}
	 * objects to sort a list of Ducks
	 * This method uses anonymous class implementation of Comparator but more attention will be paid to Lambda 
	 * Implementation of {@code Comparator<Duck>}
	 * this method also gives us an introduce the static methods compariing() and thenComparing() which used in
	 * conjunction with compare() offer a technques to refine your sorting using a comparator
	 * @see com.android.Duck
	 */
	static void ex4() {
		/*
		 * list of ducks that will be sorted by
		 * name
		 * then weight
		 * the height
		 * then by id
		 * Duck class does not implement  Comparable
		 * this is anonymous class implementation of Comparator
		 */
		Comparator<Duck>duckComparator=new Comparator<Duck>(){
			
			@Override
			public int compare(Duck d1, Duck d2) {
				/*
				 * the only option that can be true for this is if both d1 and d2 are the same
				 * duck (as every duck as a unique id)
				 */
				if(d1.equals(d2))
					return 0;
				//if not the same name, sort by name
				if(!(d1.getName().equals(d2.getName())))
					return d1.getName().compareTo(d2.getName());
				//if not the same weight, sort by weight
				if(!(d1.getWeight()==d2.getWeight()))
					return d1.getWeight()-d2.getWeight();
				//if not same height, sort by height
				if(!(d1.getHeight()==d2.getHeight()))
					return d1.getHeight()-d2.getHeight();
				//if gets to this point the only difference is that id's of the duck
				return d1.getId()-d2.getId();
			}
			
		};
		
		Duck d1=new Duck("daffy",12,4);
		Duck d2=new Duck("Andy",4,7);
		Duck d3=new Duck("daffy",7,4);
		Duck d4=new Duck("daffy",7,3);
		Duck d5=new Duck("Andy",4,7);
		
		List<Duck>duckList=new ArrayList<>();
		duckList.addAll(Arrays.asList(d1,d2,d3,d4,d5));
		/*
		 * the Duck class does not implement the comparable interface, so can't use this 
		 * Collections.sort method
		 */
	//	Collections.sort(duckList);
		Collections.sort(duckList, duckComparator);
		System.out.println(duckList);
		
		duckList.clear();
		duckList.addAll(Arrays.asList(d1,d2,d3,d4,d5));
		System.out.println("unsorted list of Ducks");
		System.out.println(duckList);
		
		/*
		 * will redefine our duckComparator as a lambda, a lambda with mulitple lines has to be enclosed
		 * in curly brackets
		 * The comparator interface has only one abstract method, however it also has a number of 
		 * static methods, which we will use here
		 */
		duckComparator=(dOne,dTwo)->{
			/*
			 * comparing(),thenComparing() and compare() are all static methods of the 
			 * comparator interface, and we can use them in place of the if statements we have 
			 * in the previous version of this comparator
			 */
			/*
			 * comparing() is a static method that defines what we will first sort by, in this case
			 * the name of the Duck
			 */
			Comparator<Duck>cs=Comparator.comparing(s->s.getName());
			/*2
			 * if the ducks have teh same name, we use this static method to say then we will sort by
			 * weight
			 */
			cs=cs.thenComparing(s->s.getWeight());
			/*
			 * then sort by height
			 */
			cs=cs.thenComparing(s->s.getHeight());
			/*
			 * then sort by id
			 */
			cs=cs.thenComparing(s->s.getId());
			/*
			 * this then applies the above comparator to the two ducks taht were defined as arguments
			 */
			return cs.compare(dOne, dTwo);
		};
		
		Collections.sort(duckList, duckComparator);
		System.out.println("duck list sorted by static methods of Comparator interface");
		System.out.println(duckList);
	}
	
	Comparator<Duck>dComparator=(dOne,dTwo)->{
		
		Comparator<Duck>cs=Comparator.comparing(s->s.getName());
		/*
		 * when using 
		 */
		cs=cs.thenComparing(s->s.getId());
		return cs.compare(dOne, dTwo);
	};

}
