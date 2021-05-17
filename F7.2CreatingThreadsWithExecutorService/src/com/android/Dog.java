package com.android;

import java.time.LocalTime;

public class Dog implements Runnable{

	@Override
	public void run() {
		System.out.println("time of dog runnable is "+LocalTime.now());
		System.out.println("dog run thread");
		
	}

}
