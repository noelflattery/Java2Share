package com.android;

public class Examples {
	
	static void ex1() {
		System.out.println("Control flow Invariant");
		Seasons mySeason=Seasons.WINTER;
		/*
		 * If we include this line of code
		 * mySeason=Seasons.WINTER
		 * we will get an assertion error with the message "Premises is closed in winter"
		 * however if we have assertions turned off (which you should in production code) this will 
		 * FAIL SILENTLY (this means it fails but your not notified about it)
		 */
		
		switch(mySeason) {
		case SPRING:
			System.out.println("we open in spring at 10 o'Clock");
			break;
		case SUMMER:
			System.out.println("We open in summer at 8");
			break;
		case AUTUMN:
			System.out.println("we open in Autumn at 11");
			break;
			default:
				assert false: "Premises is closed in winter";
		}
	}//end of ex1
	
	
	static void ex2() {
		System.out.println("class invariants");
		/*
		 * this is checking the state of an object i.e weight, age, height, etc
		 */
		int age=-12;
		/*
		 * if age is less than 0, then this will produce an AssertionError with the message
		 * "an age HAS to be more than 0"
		 */
	//	assert age>0:"an age HAS to be more than 0";
		/*
		 * even though we are showing this as a class invariants example, you should not 
		 * use Assertions to check for valid arguments, it is better to use a 
		 * IllegalArgumentException. 
		 * As remember Assertions will be turned off in production code whereas Exceptions will not
		 */
		class Rectangle{
			int width;
			int height;
			/*
			 * a rectangle HAS to have a width and height greater than 0
			 */
			
			public Rectangle(int width,int height) {
				this.width=width;
				this.height=height;
				/*
				 * isValid will return false if either width or height have a value of 0 or less than 0
				 * so if it is "assert false", this will generate an AssertionError and print out 
				 * "not a valid rectangle, both width and height have to be greater than 0"
				 * if they are valid heights and weights, this will be ignored and our rectangle will be created
				 * assertions do not allow you to fix a situation
				 */
				assert isValid():"not a valid rectangle, both width and height have to be greater than 0";
				/*
				 * this is using IllegalArgumentException which is thrown if the widht or height is 0 or lower,
				 * this is a better option as exceptions are not turned off in production code.
				 * exceptions are all about fixiing situations
				 */
		/*		if(isValid())
					System.out.println("rectangle created");
				else
					throw new IllegalArgumentException();*/
			}
			
			private boolean isValid() {
				//boolean myBool=(width>0 && (height>0);
			//	System.out.println(myBool);
				return (width>0 && height>0);
			}
		}
		
		Rectangle one=new Rectangle(5,12);
	}

}

enum Seasons{
	SPRING,SUMMER,AUTUMN,WINTER
}
