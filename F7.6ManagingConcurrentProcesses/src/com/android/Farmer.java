package com.android;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class Farmer {
	static int counter=0;
	
	private void removeAnimals() {
		System.out.println("removing Animals "+counter);
	}
	
	private void cleanPen() {
		System.out.println("cleaning the pend "+counter);
	}
	
	private void addAnimals() {
		System.out.println("adding animals "+counter);
	}
	
	public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
	//	counter++;
		try {
			//counter++;
			/*
			 * four threads will call the removeAnimals method
			 */
				removeAnimals();
				/*
				 * only when all 4 threads have finished removeAnimals AND called 
				 * the await method. four threads have to check in with C1, so our code will
				 * not progress until four threads have checked in with c1
				 */
				c1.await();
		
				cleanPen();
				/*
				 * only when all 4 threads have checked in with await(), will the farmers progress onto
				 * addAnimals. Also as soon as the four threads check int with c2, the runnable object of
				 * c2 will run and will print out "pen cleaned"
				 */
				c2.await();
		
				addAnimals();
		}
		catch(InterruptedException | BrokenBarrierException e) {
			System.out.println(e);
		}
		
	
	}

}
