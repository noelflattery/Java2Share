package com.android;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

//import javax.activation.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * /*
 * four key interfaces of JDBC
 * DRIVER: knows how to get a connection to the database
 * CONNECTION: knows how to communicate with the database
 * STATEMENT: knows how to run the SQL
 * RESULTSET: knows what was returned by a SELECT Query (select query is sql code that select certain
 * records from a database that satisfy certain criteria
 * i.e we have to tell mysql what database we are using
 * name of database is 
 * "myDatabase", 
 * and table in database is 
 * "Customers"
 * so a typical sql query, which you can use in java, would be
 * use mydatabase;//selects the database to use
 * show tables;//show all the tables in the database
 * select * from customers//this will select all the customers from the customers table
 *in customers table we have a city column which has a number of customers in galway
 * select * from customers where city='Galway'//get all customer details for customers that live in galway
 * 
 */

public class Examples {
	/*
	 * there are other ways to connect to databases, ODBC is one and many flavours of SQL (MySQL, MariaDB, MS SQL Server) and 
	 * also there are other database technologies from the very good (Oracle - very expensive but the best, IBM DB2,
	 * etc) 
	 * to the awful (MS Acess should be avoided as touted as a beginners database package but really difficult to
	 * use).
	 * Also with the advent of big data and data harvesting and increased computing power we have NoSQL, which is
	 * basically using raw computer power and any computer programming language to retrieve information from
	 * vast amounts of data held in unformatted and unorganised manner (All social media platforms use a this or 
	 * a variant)
	 * however for the Java 8 programmer 2 exam you will only be asked about JDBC, as databases themselves are a
	 * whole seperate area of computer science. How any programming language can interact with a organised
	 * series of records (as that is what a database is) or any external data source, is also a massive area that
	 * encompasses many different areas of computer science from as diverse areas as machine learning, AI to 
	 * Data Warehousing and legal and data privacy issues.
	 */
	/*
	 * The database we will be using for the first few examples is "mydatabase"
	 * open up MySQL workbench if you want to see the tables, and columns and records of this database
	 * when first connecting to a database using JDBC, we have to create a JDBC URL, which contains 
	 * information needed to connect to the relevant database
	 
		 */
	
	static void ex1() {

		String url="jdbc:mysql://localhost:3306/mydatabase";

	/*EXPLANATION OF URL
	 * jdbc: 
	 * this is the protocol we will use to connect to the database, other such protocols are
	 * ODBC. Protocols are just sets of rules, so this is saying we are connecting to a database using
	 * the rules set down by jdbc
	 * mysql:
	 * this is the name of the external application we are using jdbc to connect to. so this is EXTERNAL
	 * to our java code
	 * localhost:
	 * this is the name of the machine, on which mysql is running, thus becoming a database server. Now this
	 * is the same machine as we are running the java code on, so we put in the name "localhost", which is
	 * always the name given to the machine you are currently on. you can also put in 127.0.0.1 as this is 
	 * always the ip address of the machine you are currently on. this can be a remote database server on the
	 * other side of the world, if it was then whoever is maintaining would have to provide you with teh 
	 * address (can be ip number based or look like a web address). Java does not differentiate between MySQL 
	 * server running on your own machine or on a machine 1000's of miles away.
	 * :3306
	 * this is a port number. A port number is just a setting that tells anything that is connecting to
	 * a particular MySQL database to use this setting. 3306 is always reserved for MySQL database connections.
	 * mydatabase
	 * this is the actual name of the database
	 * other examples of URL strings are
	 * jdbc:postgresql://localhost/zoo
		jdbc:oracle:thin:@123.123.123.123:1521:zoo
	jdbc:mysql://localhost:3306/zoo?profileSQL=true
	 */
	/*
	 * every mysql database we connect to has a User and a password, which we have to provide in
	 * the code. again these should be provided by whoever is the database administrator. by default
	 * our username is "root" and password is blank, which we still define as "". a root user has complete control
	 * of the database and can delete databases, tables, records and add all as well. As a general rule if
	 * you are a database administrator you should not give root user access to everyone
	 */
	String userName="root";
	String password="";
	/*
	 * we then have to create a database Connection object (or to be more precise an object that implements
	 * the Connection interface)
	 * this can throw SQLException, which is a checked exception, so this has to be either in a try/catch block,
	 * a try with resources, or have the method in which the connection is in throw the exception. As a database is
	 * always EXTERNAL to a java application, just like when connecting to file, whether the database exists or 
	 * not is outside of java's control so it has to throw a checked exception.
	 */
	
	try{
		/*
		 * getConnection takes three variables
		 * the URL of the database you are  using
		 * the username you use to log on to the database
		 * the password we use to log on to the database
		 * you really should not be using DriverManager in proper coding,
		 * instead you should use Datasource. Datasource is not on the exam but this 
		 * will be covered in a seperate section as using Datasource is the way you
		 * SHOULD connect to a databse. 
		 */
		//have to cover this
		//Class.forName("com.mysql.cj.jdbc.Driver");
		/*
		 * Connection is one of the interfaces of JDBC, which means you can't create 
		 * a Connection object. here we use the DriverManager class, which implements
		 * Connection. The DriverManager class uses the factory pattern, which means
		 * it uses a static method, getConnection() in this case, to get a connection.
		 * getConnection takes three strings
		 */
		Connection con=DriverManager.getConnection(url,userName,password);
		System.out.println("connection is ");
		/*
		 * this is merely a connection object, we have not done anything with the connection object
		 * and this is a live connection to the "mydatabase" database
		 */
		System.out.println(con);
		/*
		 * should always close a connection when you are finished with it
		 * if you use try with resources this connection will be closed automatically
		 */
		con.close();
		
	}
	catch(Exception e) {
		System.out.println("exception is "+e);
	}
		
	}
	
	static void ex2() {
		/*
		 * we can create our connection in try with resources, so just like when we open a connection
		 * to a file, this will automatically close the connection.
		 */
		try(Connection con=connectMe()){
			System.out.println("we are sucessfully connected to "+con);
		}
		catch(Exception e) {
			System.out.println("exception in ex2 is caught and it's "+e);
		}
		
	}
	/*
	 * we use this method to create a connection to the database "mydatabase"
	 */
	static Connection connectMe() {
		String url="jdbc:mysql://localhost:3306/mydatabase";
		String userName="root";
		String password="";
		try {
			Connection con=DriverManager.getConnection(url, userName, password);
			/*
			 * if sucessful connection then returns a connection object
			 */
			return con;
		}
		catch(Exception e) {
			System.out.println("unable to make connection because of "+e);
			/*if not sucessfully connected then returns a null object
			 * 
			 */
			return null;
		}
	}
	
	static void ex3() 
	{/*
	getMySqlDataSource() returns a MysqlDataSource and we can call the getConnection() method of
	MysqlDataSource class to create a connect with the URL,username and password contained in the fields
	of the returned object
	*/
		try(Connection con=getMySqlDataSource().getConnection()){//try with resources, so connection is closed automatically
			System.out.println("connection in ex3 is "+con);
		}
		catch(Exception e) {
			System.out.println("exception is "+e);
			System.out.println("unable to make connection");
		}
		
	}
	/*
	 * this is the way you should connect to a database, you get all the settings from
	 * another file, never a good idea to have passwords and usernames in text format in
	 * code. this properties file can be on another machine and have all sorts of security 
	 * protocols attached to it, hence why is so much safer as looking at this code you
	 * have no idea what the username and password actually is
	 * this method returns an object that contains the URL, the username and the password
	 * needed to connect to the database
	 * DataSource is an  interface
	 */
	static MysqlDataSource getMySqlDataSource() {
		//for using the db.properties file allows us to get data from that file
				Properties props=new Properties();
				/*
				 * MysqlDataSource does not implement autoclosable so this cannot be put in a try
				 * with resources
				 * this class has a URL,a user and a password field, and also setters for each of these
				 * fields
				 */
				MysqlDataSource mysqlDS=null;
				try(//a try with resources so the connection to this file will be closed automatically
						//FilenInputStream implements AutoClosable
						FileInputStream fis=new FileInputStream("db.properties");
						)
					{
					/*
					 * the property file props, loads up all the text from db.properites using the 
					 * FileInputStream fis
					 */
						props.load(fis);
						mysqlDS=new MysqlDataSource();
						/*
						 * if you want to get anything from properties object, you use the "getProperty()" 
						 * method, which gets the value for the key you specify
						 */
						mysqlDS.setUrl(props.getProperty("MYSQL_DB_URL"));//which is jdbc:mysql://localhost:3306/mydatabase
						mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));//which is root
						mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));//which is a blank
				
						/*
						 * the getConnection() method of the MysqlDataSource class returns a connection
						 */
					//	Connection con=mysqlDS.getConnection();
					return mysqlDS;
				}
				catch(Exception e) {
					System.out.println("exception inside method "+e);
				}
				/*
				 * we use the returning MysqlDataSource object to create our connection object in the calling
				 * method
				 */
				return null;
				
	}
}
