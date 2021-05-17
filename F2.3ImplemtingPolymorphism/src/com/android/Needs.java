package com.android;
/**
 * this is a functional interface and has one method drink that takes two generic types, type T and type
 * V
 * a class can implement this interface
 * a anonymous class can implement this interface
 * and as it's a functional interface, a lambda can also implement this interface
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/y5yyze96L0A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @param <T> will be given its type by whatever is implementing this functional interface
 * @param <V> will be given its type by whatever is implementing this functional interface
 */
@FunctionalInterface
public interface Needs<T,V> {
	/**
	 * type T can be any type we desire and can be defined when creating a lambda or using a class
	 * to implement the interface. however as this is a functional interface, it will more than likely
	 * be used in conjunction with a lambda
	 * @param name this will be given a type by whatever object implements this interface
	 * @param weight this will given a type by whatever object implements this interface
	 */
	void drink(T name,V weight);

}
