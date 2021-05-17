package com.android;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Examples {
	
	static void ex1() {
		System.out.println("using try with resources to close all database resources");
		
		/*
		 * with a try with resources these will all be closed in reverse order
		 * resultSet closed first
		 * then statement 
		 * then connection
		 * can't redefine an existing resource ina  try with resources argument list
		 */
		Connection con2=connectMe("world");
		//this is the try with resources arguement list, can't redefine an existin resource inside the () brackets
		try(Connection con=connectMe("mydatabase");//closed last
			Statement stmt=con.createStatement();//closed second
			ResultSet rs=stmt.executeQuery("select * from customers");
				Statement stmt2=con2.createStatement()//closed first
			//	con2=connectMe("world");//will not compile
				){
				while(rs.next())
					System.out.println("name is "+rs.getString(2));
				/*
				 * anything that is in a try with resources block, cannot be reassigned
				 * can't use an existing variable in a try with resources, must be a new resource
				 */
			//stmt=con.createStatement("select * from orders");//will not compile as can't use a variable declared in 
			//a try with resources argument block, can't use reassing stmt
				/*
				 * can't use the con variable
				 */
			//	con=connectMe("world");
				/*
				 * you can redefine an existing resources, that was creating outside of the try/catch block
				 * inside the try blocks curly brackets/method bocy
				 */
				con2=connectMe("world");//will compile
				ResultSet rs2=stmt2.executeQuery("select name from country");
				while(rs2.next())
					System.out.println("name of country is "+rs2.getString(1));
		}
		catch(SQLException e) {
			System.out.println("unable to connnect in ex1 because of "+e);
		}
	}
	
	static void ex2() {
		try(Connection con=connectMe("mydatabase");
				Statement stmt=con.createStatement()){
			/*
			 * there is no "dog" colunm in the customers table
			 */
			ResultSet rs=stmt.executeQuery("select dog from customers");
			
		}
		catch(SQLException e) {
			//this is a human readable message
			System.out.println(e.getMessage());
			//every sql issue has a particular code, google to find code meaning
			System.out.println(e.getSQLState());
			//database type (in this case mysql) specific code
			System.out.println(e.getErrorCode());
		}
	}
	
	
	
static Connection connectMe(String database) {
	String url="jdbc:mysql://localhost:3306/"+database;
	String userName="root";
	String password="";
	try{
		Connection con=DriverManager.getConnection(url,userName,password);
		System.out.println("connected");
		return con;
	}
	catch(Exception e) {
		System.out.println("unable to make connection");
		return null;
	}
}
}


