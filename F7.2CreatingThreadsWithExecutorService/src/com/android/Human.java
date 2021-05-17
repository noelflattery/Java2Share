package com.android;

import java.util.concurrent.Callable;

public class Human implements Callable<Human>{

	@Override
	public Human call() {
		System.out.println("human call method");
		return new Human();
	}

}
