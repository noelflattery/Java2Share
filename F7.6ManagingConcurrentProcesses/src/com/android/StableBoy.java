package com.android;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class StableBoy {
	AtomicInteger counter=new AtomicInteger(0);
	
	private void removeAnimals() {
		System.out.println("removing horses "+counter);
	}
	
	private void cleanPen() {
		System.out.println("cleaning the stable "+counter);
	}
	
	private void addAnimals() {
		System.out.println("adding horses "+counter);
	}
	
	public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
		counter.addAndGet(1);
		try {
			removeAnimals();
			c1.await();	
			cleanPen();
			c2.await();
			addAnimals();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
