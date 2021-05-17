package com.android;

public class ZooKeeper 
{
	static int counter=0;//this keeps count of tasks done
	
	private void removeAnimals() {
		System.out.println("removing animals "+counter);
	}
	private void cleanPen() {
		System.out.println("cleaning pen "+counter);
	}
	private void addAnimals() {
		System.out.println("adding animals "+counter);
	}
	
	public void performTasks() {
		counter++;
		removeAnimals();
		
		cleanPen();
		
		addAnimals();
	}

}
