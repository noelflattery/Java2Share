package com.android;

import java.util.concurrent.RecursiveAction;
/*
 * this has a method void compute() which is the same as a Runnable object
 */
public class Manager extends RecursiveAction{
	//for dealing with our 10 weights
	private int start;//starting point, which will be 0
	private int end;//end point which will be 10
	private Double[]weights;//array of weights that each manager measures
	int id;
	
	static int counter=0;
	static int manageCounter=0;
	int animalCount=0;
	
	public Manager(Double[]weights,int start,int end) {
		counter++;
		id=counter;
		this.start=start;
		this.end=end;
		this.weights=weights;
	}

	/*
	 * this is your recursion method, so you have to a if Statement or something similar.
	 * the if part is the base case we working down too, in this case it will be one Manager weighing
	 * three Animals
	 * the else part is the recursive and will keep calling the compute method until it gets down to the 
	 * base case
	 */
	@Override
	protected void compute() 
	{
		/*
		 * if a Manager can weigh more than three Animals, this Manager will not be used to weigh the 
		 * animals as only Managers that weight 3 Animals at most will be used
		 */
		// TODO Auto-generated method stub
		if(end-start<=3) {//base case, only three most animals to be weighed
			manageCounter++;
		//	System.out.println("manager with id "+id);
			for(int i=start;i<end;i++) {
				weights[i]=Math.random()*100;
				animalCount++;
			//	System.out.println("animal  number is "+i+" weight is "+weights[i]);
			}
			System.out.println("manager with id of "+id+" weights "+animalCount+" start is "+start+" end is "+end);
		}
		/*
		 * this is the recursive part that works down to the base case
		 */
		else {
			/*
			 * if a manager attempts to weigh more than 3 animals, we split the work to two Managers, and keep doing this
			 * until we get to Managers that can weigh, at most 3 Animals
			 * we start off with a Manager that has a start point of 0 and end point of 10, we then get the middle 
			 * point of this Manager, which will be 5
			 * we then create a second generation of 2 Managers, the start point for the first one will be the start point
			 * of the first generation manager and the end point will be the middle of the first generation
			 * so this Manager will be start 0, end 5 - this manager can weight 5 animals
			 * and the other Manager will be the middle point of the first generation and end point of the first generation
			 * so this Manager will be start 5, end 10 - this Manager can weigh 5 Animals
			 * these two Managers will have a middle point of 2 and five, so our two Managers look like
			 * Manager 1 start 0, middle 2, end 5
			 * Manager 2 start 5, middle 7, end 10
			 * so this generation will also create two Managers for each, so this will create 4 further Managers which will
			 * look like the following
			 * Manage 3 start 0 end 2 - 2 Animals - 2-0
			 * Manager 4 start 2 end 5 - 3 animals -> 5-2
			 * Manager 5 start 5 end 7- 2 Animals -> 7-5
			 * Manager 7 start 7 end 10 - 3 Animals -> 10-7
			 * so each of these four Animals will NOT enter the else, as these Managers satisfy the condidtion
			 * end-start<=3
			 * 
			 */
			int middle=start+((end-start)/2);
			
			System.out.println("Start is "+start+" middle is "+middle+" end is "+end);
			
			invokeAll(new Manager(weights,start,middle),
					new Manager(weights,middle,end));

		}
		
	}

}
