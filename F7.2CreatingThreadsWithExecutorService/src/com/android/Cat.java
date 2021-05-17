package com.android;

public class Cat {
	
	Cat(){
		System.out.println("cat constructor called");
		/*
		 * this is a static thread that is contained in examples and here we are adding the second
		 * task to the thread
		 */
		Examples.statService.execute(()->System.out.println("print out cat executor"));
		/*
		 * if i left this command in, you would be NOT able to add any more tasks to this thread and you would
		 * get a RejectedExecutionException as the thread would already have been closed
		 */
	//	Examples.statService.shutdown();
	}

}
