package com.android;

import java.util.Random;
import java.util.concurrent.RecursiveTask;
/*
 * RecursiveTask<Double> is the same as Submit<Double> as it has a double Compute() method
 */
public class Employee extends RecursiveTask<Double>{
	
	private int start;
	private int end;
	private Double[]weights;
	static int counter=0;//this will get total amount of Employees created
	static int empCounter=0;//this will get the total amount of Employees used for weighing Animals
	
	public Employee(Double[]weights,int start,int end) {
		counter++;
		this.start=start;
		this.end=end;
		this.weights=weights;
	}

	@Override
	protected Double compute() {
		if(end-start<=3) {
			//keep a count of how many employees do the actual weighing
			empCounter++;
			//this will be the total weight of all the animals
			double sum=0;
			for(int i=start;i<end;i++) {
				//this generates random numbers between 1 and 100, and we then cast them to be doubles
				weights[i]=(double)new Random().nextInt(100);
				System.out.println("animal weighed "+weights[i]);
				//this provides a running total and final total for compute
				sum+=weights[i];
			}
			System.out.println("this employee has weighed "+sum+" weights");
			return sum;
		}
		else {
			int middle=start+((end-start)/2);
			System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
			/*
			 * we can't use invokeAll() as this does not return any value, we are still creating twice the amount of
			 * employees as the previous generation of employees (first gen 1 employee, second gen 2 Employees, 3rd gen 4
			 * employees), however we use forking and joining for this instead
			 */
			RecursiveTask<Double>otherTask=new Employee(weights,start,middle);
			/*
			 * this creates another thread, so we will have a thread per employee
			 * The fork() method
			instructs the fork/join framework to complete the task in a separate thread, while the
			join() method causes the current thread to wait for the results.
			 */
			otherTask.fork();
			/*
			 * this creates our second Employee, so insteand of creating two employees with invokeAll() we are creating
			 * two employees with a combination of Fork and Join.
			 * your program will not progress onto the next Employee/Calculation of total wieght for employee, until the 
			 * previous one has been completed
			 * this will add up all of the totals from each employee, if we did nto include otherTask.join() it would only
			 * return the total weighed by the last employee
			 */
			return new Employee(weights,middle,end).compute()+otherTask.join();
			
		}
		// TODO Auto-generated method stub
		
	}

}
