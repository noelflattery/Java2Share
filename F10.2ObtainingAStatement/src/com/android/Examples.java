package com.android;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * REMEMBER FOR EACH NEW PROJECT WE HAVE TO INCLUDE THE MYSQL-CONNECTOR-JAVA LIBRARY IN THE BUILD
 * PATH
 * @author noelf
 *we will be running MySQL statements in java code, you only need to know a very basic level of MySQL 
 *for this, when you run a MySQL command in java you are OBTAINING A STATEMENT
 *you have to run an additional step to actual import the result of the query to your java code.
 *importing results from a MySQL statement uses RESULTSETS which will be covered in the next section.
 * * in real life coding situations you should not use statement directly, you should use a subclass
	 * called PREPARED STATEMENT 
	 * (these can be created in java code or can also be saved and called from
	 * a database using mysql code. these will be covered in a seperate chapter section along with using
	 * DATASOURCE
 *
 */
public class Examples 
{
	static void ex1() {
		System.out.println("obtaining a statement");
		/*
		 * theres is a overloaded createStatement() method that takes two arguements 
		 * this has an overloaded version that takes two arguements, however the version that
			 * takes no arguements is the one you use, as very few circumstances you need to use
			 * the two arguments, but the exam insists you know them.
			 * 
			 * First Argument
			 * ResultSet type and ResultSet concurrency mode. in reality you rarely will be using 
			 * ResultSet type by default is ResultSet.TYPE_FORWARD_ONLY, which means you get go
			 * through the data in the order it was retrieved.
			 * there are two other modes ResutlSet.TYPE_SCROLL_SENSITIVE and ResultSet.TYPE_SCROOL_INSENSTIVE
			 * TYPE_SCROLL_INSENSITIVE - this is what the data in the database looked like when you did the
			 * query, regardless if the query actually changes the data
			 * TYPE_SCROLL_SENSITIVE - this will show all data in the database, including any data that 
			 * the query itself changed.
			 * most database and database drives DO NOT support TYPE_SCROLL_SENSITIVE, so if you use it
			 * it is downgraded to TYPE_SCROLL_INSENSITIVE
			 * 
			 * Second Argument
			 * by default this arguement is ResultSet.CONCUR_READ_ONLY. this means you can't update
			 * the database, and this is what you will use virtually all of the time.
			 * the other option is ResultSet.CONCUR_UPDATEABLE, which means you can update, delete and edit 
			 * records. However this is not what is used when you want to update, delete or edit records. Instead
			 * we use the SQL commands INSERT, DELETE, UPDATE
			 *again CONCUR_UPDATEABLE is not supported by many databases or JDBC Drivers, 
		 */
		/*
		 * this is a try with resources so this connection will be closed automatically
		 */
		try(Connection con=connectMe("mydatabase")){
			System.out.println("con.createStatement()");
			/*
			 * 	/*
			 * the createStatement() method that takes no arguements is the only one you really need to use
			 * the Connection class has a method call createStatement, so we call the createStatement()
			 * on our connection object con, which connects to the mydatabase database
			 *
			 * this returns a statement object that is created from the connection to 
			 * mydatabase database
			 * this object stmt can now run mysql queries on the database mydatabase
			 */
			Statement stmt=con.createStatement();
			System.out.println("select statements");
			/*
			 * when using a non updateable SQL statement, we use the executeQuery() method of the 
			 * statement class, which takes as one of it's parameters a string, which will be a
			 * SQL statement 
			 * executeQuery returns a resultSet, which is a list of records that match the condition 
			 * you are looking for (i.e all female members of your club, all customers living in the
			 * city of Galway, etc)
			 * executeQuery is just for obtaining information from the database and not changing or 
			 * adding anything to the database
			 */
			//returns all customers in customers table
			//executeQuery() is a method of the statement class
			System.out.println("executeQuery()");//non updatable sql queries
			//select all columns and all rows from customers table in myDatabase
			ResultSet rs=stmt.executeQuery("select * from customers");
			//select all columns and all rows from customers where the customers are from Ireland
			rs=stmt.executeQuery("select * from customers where cust_country='Ireland'");
			/*
			 * this is an object that does contain all the customers in ireland the results are held inside
			 * this object. In the next section we will show you how to get the actual results in a resultSet
			 */
			System.out.println("resultset is "+rs);
			/*
			 * executeUpdate is for queries that delete, add or update records in a database
			 * executeUpdate returns an int which is the amount of rows in our database that are
			 * effected by this query.
			 * you will have to view the tables in mysql workbench to see the effects
			 * execute update can also be used to modify tables, add tables, create new databases or
			 * delete databases
			 * anything that changes a database in some way, is a executeUpdate() method
			 */
			System.out.println("executeUpdate()");
			/*
			 * executeUpdate returns an int which is the amount of rows in our database that are
			 * effected by this query.
			 * you will have to view the tables in mysql workbench to see the effects
			 */
		/*	int result=stmt.executeUpdate("insert into shorcust values('great_toy')");
			System.out.println("there are been "+result+" records inserted");*/
			
	/*		int result=stmt.executeUpdate("delete from shorcust where cust_name='great_toy'");
			System.out.println("there have been "+result+" records deleted from the shorcust table");*/
			/*
			 * we can also update records, for instance change all of the customers who are in the "USA" to
			 * "Germany"
			 * we use a table called custmessing
			 */
	/*		int result=stmt.executeUpdate("update custmessing set cust_country ='Germany' where cust_country='USA'");
			System.out.println(result +" records updated");*/
			
			int result=stmt.executeUpdate("update custmessing set cust_country ='USA' where cust_country='Germany'");
			System.out.println(result +" records updated");
			
			System.out.println("execute");
			/*
			 * this can be a update query or a execute query. execute returns a boolean
			 * if true it runs executeQuery()
			 * if false, runs executeUpdate()
			 */
			boolean isResultSet=stmt.execute("select * from customers");
			if(isResultSet) {
				/*
				 * if execute is a executeQuery() then you use stmt.getResultSet()
				 */
				ResultSet rs2=stmt.getResultSet();
				System.out.println("this code just ran a query to obtain all the customers");
			}
			else {
				/*
				 * if its a executeUpdate then there will be an amount of records modfied or inserted
				 * we use stmt.getUpdateCount()
				 */
				int resultAmount=stmt.getUpdateCount();
				System.out.println("a table has been updated and "+resultAmount+" records have been updated");
			}
			
		}
		catch(Exception e) {
			System.out.println("exception in ex1 is caught which is "+e);
		}
	}
	
	/*method for connecting to mydatabase database
	 * we will use this method to connect to the whatever database 
	 */
	static Connection connectMe(String mydatabase) {
		String url="jdbc:mysql://localhost:3306/"+mydatabase;
		String userName="root";
		String password="";
		try{
			Connection con=DriverManager.getConnection(url,userName,password);
			return con;
		}
		catch(Exception e) {
			System.out.println("unable to make connection");
			return null;
		}
	}
	
	

}
