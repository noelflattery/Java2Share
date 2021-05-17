/**
 * package that contains all of our classes
 */
package com.android;
/**Main class that contains our main method that calls all our Code
 * Java 8 introduced lambdas and functional interfaces. there are many built 
 * in functional interfaces, some of 
 * which we have already seen in the previous chapter when we were dealing with 
 * Collections and Maps
 * For exam purposes we only deal with certain functional interfaces, 
 * and all of them use generic types, which
 * uses the following syntax
 * first generic will be T, second generic type will be U if distinct 
 * (different) return type we use 
 * the following functional interfaces that are covered by this exam are the following: 
 * {@code Supplier<T> no parameters return type T, method T get()//see Employee class
 * Consumer<T> 1 parameter, return type void, method void accept(T t)//see Astronaut
 * BiConsumer<T,U> 2 parameters, return type void, method void accept(T t, U u)//see accountant
 * Predicate<T> 1 parameter, return type boolean, method boolean test(T t)//
 * BiPredicate<T,U> 2 parameters T U,return type boolean, method boolean test(T t, U u)//see Carpenter
 * Function<T,R> 1 parameter T, return type R, method R apply(T t)//see Doorman
 * BiFunction<T,U,R> 2 parameters T U, return type R, method R apply(T t, U u)//see electrician
 * UnaryOperator<T> 1 parameter T, return type T, method T apply(T t)//see fireman
 * BinaryOperator<T> 2 parameters T T, return type T methog T apply(T t T t2)//see Gp }
 * Main class contains our main method
 * @see com.android.Examples
 */
public class Main {
	/**
	 * contains calls to the examples class where all our code to do with this section is housed
	 * @see com.android.Examples
	 */
	public static void main(String[]args) {
		//Examples.ex1();
		//Examples.ex2();
		//Examples.ex3();
		//Examples.ex4();
		//Examples.ex5();
		//Examples.ex6();
		//Examples.ex7();
		//Examples.ex8();
		Examples.ex9();
		//Examples.ex10();
	//	Examples.ex11();
		
	}

}
