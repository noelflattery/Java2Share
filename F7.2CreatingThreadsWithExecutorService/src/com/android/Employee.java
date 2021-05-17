package com.android;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class Employee implements Callable{

	@Override
	public Object call() throws Exception {
		System.out.println("time in Employee is "+LocalTime.now());
		return null;
	}

}
