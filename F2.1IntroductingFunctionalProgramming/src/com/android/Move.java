package com.android;
/**
 * this is a functional interface with a {@code Generic<T>} this means that
 * the method T run(T num) can take any object and return any object. however the parameter and the returned
 * type HAS to be the same or subclass of T
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/8cFj6gYDndk">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 * @param <T> type that can be any type that can be assigned when calling the method, type can be assigned when creating an object
 * of a class that implements the Move interface or as this is a Functional Interface can be assigned a type by a lambda
 */
@FunctionalInterface
public interface Move<T> {
	/**this abstract method takes a Integer and returns an Integer for instance*/
	T run(T num);

}
