package com.android;
/**not used in this project*/
public class Boat {
	public boolean holeInBoat=false;
/**
 * used to show our own exception classes
 * @throws BoatException
 */
	void crash()throws BoatException{
		/*
		 * if boat crashes there is a hole in the boat
		 */
		holeInBoat=true;
		System.out.println("there is a hole in the boat");
	}
}
/**
 * how we create an exception class
 */
class BoatException extends Exception{
	
}
