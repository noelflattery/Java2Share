package com.android;

import java.sql.SQLException;
import java.time.format.DateTimeParseException;

public class Main {
	
	public static void main(String[]args) {
/*		try {
			Examples.ex1();
		}
		catch(SQLException |DateTimeParseException e) {
			System.out.println("caught in main "+e);
		}
	/*	catch(Exception e) {
			System.out.println("caught in main "+e);
		}*/
		
		try {
			Examples.ex2();
		}
		catch(Exception e) {
			System.out.println("caught in main "+e);
			
		}
		System.out.println("program continues");
	}

}
