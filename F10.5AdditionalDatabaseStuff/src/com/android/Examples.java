package com.android;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;


public class Examples {
	/*
	 * this is using a properites file to provide URL, Username and password (SHOULD NEVER STORE PASSWORDS
	 * ANYWHERE IN REAL TEXT, ONLY STORE THE HASH OF THE PASSWORD)
	 */
	static void ex1() {
		try(Connection con=getMySQLDataSource().getConnection();
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from customers")){
			
			System.out.println("connection in ex3 is "+con);
			while(rs.next())
				System.out.println("name is "+rs.getString(2));
		}
		catch(Exception e) {
			System.out.println("exception is "+e);
			System.out.println("unable to make connection");
		}
		
	}
	/*
	 * this method we will use to use the db.properties file to connect to the databases
	 */
	static DataSource getMySQLDataSource() {
		//for using the db.properties file
				Properties props=new Properties();
				//for getting input from properties file
//				FileInputStream fis=null;
				/*
				 * MysqlDataSource does not implement autoclosable so this cannot be put in a try
				 * with resources
				 */
				MysqlDataSource mysqlDS=null;
				try(//a try with resources so the connection to this file will be closed automatically
						//FilenInputStream implements AutoClosable
						FileInputStream fis=new FileInputStream("db.properties");
						)
					{
					
						props.load(fis);
						mysqlDS=new MysqlDataSource();
						mysqlDS.setUrl(props.getProperty("MYSQL_DB_URL"));
						mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
						mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
				
						/*
						 * the getConnection() method of the MysqlDataSource class returns a connection
						 */
					//	Connection con=mysqlDS.getConnection();
					
				}
				catch(Exception e) {
					System.out.println("exception inside method "+e);
				}
				/*
				 * we use the returning MysqlDataSource object to create our connection object in the calling
				 * method
				 */
				return mysqlDS;
		
	}
	
	static void ex2() {
		/*
		 * getUser() getURL() getPassword() are all methods of the MysqlDataSource class
		 * which is a subclass of DataSource. So if we declare ds to be a Datasource
		 * instead of a MysqlDataSource, there is no way this code will be able to display
		 * ANY of the values needed to connect to a database, as the methods to do so are
		 * not available to Objects with a DataSource reference
		 */
		DataSource ds=MyDataSourceFactory.getMySQLDataSource();
		/*
		 * no access to these methods as this is a super class DataSource referece to a 
		 * sub class MySQLDataSource object, so this object only has access to methods of the 
		 * super DataSource class, getURL(),setURL(), etc are only available to MySQLDataSource 
		 * class referenced objects
		 */
	//	ds.getURL();
	//	ds.getUser();
	//	ds.setURL()
		
		try(Connection con=ds.getConnection();
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from customers");){
			while(rs.next())
				System.out.println(rs.getString(2));
			
		}
		catch(Exception e) {
			System.out.println("exception in ex2 is the exception "+e);
		}
	}

}
