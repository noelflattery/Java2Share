package com.android;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/**Main class that contains our main method which calls all the methods in the {@link com.android.Examples} class
 * @author NoelF
 */
public class Main {
static int num=5;
/**main method that calls all the methods that deal with the topics of this section
* @see com.android.Examples#ex1()
* @see com.android.Examples#ex2()
* @see com.android.Examples#ex3()
* @see com.android.Examples#ex4()
* @see com.android.Examples#ex5()
* @see com.android.Examples#ex6()
* @see com.android.Examples#ex7()
* @see com.android.Examples#ex8()
* @see com.android.Examples#ex9()
* */
	public static void main(String[] args) {
		num=7;
	//	Examples.ex1();
	//	Examples.ex2();
	//	Examples.ex3();
	//	Examples.ex4();
	//	Examples.ex5();
	//	Examples.ex6();
	//	Examples.ex7();
		Examples.ex8();
	//	Examples.ex9();
	//	Stream.iterate(1, i->i*2).limit(5).forEach(System.out::println);
//		List<Integer>intList=IntStream.rangeClosed(1, 200).limit(5).boxed().collect(Collectors.toList());
	//	List<Integer>lotto=IntStream.generate(()->(int)(Math.random()*100)).filter(n->n<32&&n>0).limit(6).boxed().collect(Collectors.toList());
		//System.out.println(lotto);
		//.mapToObj(n->new Dog(n,"spot",n+2)).forEach(System.out::println);;
		//Collections.shuffle(intList);
		//System.out.println(intList);
	}

}
