package com.android;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Examples {
	
	static void ex1() {
		System.out.println("getting records from a resultSet");
		try(Connection con=connectMe("mydatabase")){//connect to mydatabase database
			Statement stmt=con.createStatement();//making a statement from the connection con
			/*
			 * this selects all the details (all columns or fields) from the customers table for
			 * each customer record
			 */
			ResultSet rs=stmt.executeQuery("select * from customers");//this runs query and assigns result to resultSet rs
			System.out.println(rs);
			/*
			 * the resultSet starts BEFORE the first record
			 * its starts before the first record "Village Toys"
			 * rs.next() also returns a boolean, true if there is another record, false if not
			 */
			rs.next();
			/*
			 * now the position of the resultSet is at the very first record "Village Toys"
			 * this will get customer name, which has a column name of "cust_name" in the table
			 * the datatype is string, so we have to use rs.getString() has an overloaded method that
			 * takes a string which is the column we wish to select
			 */
			System.out.println(rs.getString("cust_name"));
			/*
			 * we are still on the first row, here we are using the overloaded getString method on the same column
			 * as above, but this time we use the overloaded getString() method that takes an int, which is the column
			 * index
			 * 1 is the first column in the table, cust_id
			 * 2 is the second column in the table which is cust_name
			 */
			System.out.println(rs.getString(2));
			
			System.out.println(rs.getString("cust_contact"));//the customer John Smith
			System.out.println(rs.getString(8));//this is also the customer john smith
			/*
			 * this resets our resultSEt to before the first record
			 */
			rs.beforeFirst();
			/*
			 * this will keep on looping while there is anohter record
			 * rs.next returns true if there is another record, false if there is not another record
			 */
			System.out.println("All the customer names *****");
			/*
			 * this is going to store all of the customer id (column cust_id) as each of these
			 * values are the primary key for the record, and primary keys have to be unique, so these can 
			 *  can be the key in each of the hashMap entries.ie
			 *  cust_id is 1000000001 and is unique and uniquely the record in the database for "Village Toys"
			 *  so this can be a key in the key value pair in the hashMap.
			 *  we will use the customers name as a value
			 */
			Map<Integer,String>customerMap=new HashMap<>();
			while(rs.next()) {
				String name=rs.getString("cust_name");
				System.out.println(name);//the name of every customer
				/*
				 * if you don't know the datatype of a column, rs.getString() will work
				 * for every datatype
				 */
				System.out.println(rs.getString(1));//the unique id of every customer
				int id=rs.getInt("cust_id");
				System.out.println("the id is "+id);
				/*
				 * this has numbers in letters for some records, i.e
				 * uk7865, so this will give you a Java.lang.NumberFormatException
				 */
		//		System.out.println(rs.getInt("cust_zip"));
		/*
		 * add the cust_id for each customer records as the key (which will be unique)
		 * adds the cust_name for each customer record as the value in the key value pair		
		 */
				customerMap.put(id, name);
			}
			
			System.out.println("our hashmap containing our customer ids and the customer names is as follows");
			System.out.println(customerMap);
			System.out.println(customerMap.size());
			
			
			
			
		}
		catch(Exception e) {
			System.out.println("unable to make connection in ex1 and the exception is "+e);
		}
	}
	
	static void ex2() {
		System.out.println("creating country objects from the country table in the world database");
		//to hold countries of Europe
		List<Country>countriesEurope=new ArrayList<>();
		//to hold countries of the world
		List<Country>countryWorld=new ArrayList<>();
		
		try(Connection con=connectMe("world")){
			Statement stmt=con.createStatement();
			/*
			 * this will select all countries in Europe and then sort them by name
			 */
			ResultSet rs=stmt.executeQuery("select * from country where continent ='Europe' order by name");
			/*
			 * this will loop through all of the records of the resultSet
			 * before the first next() the postion in the resultSEt is before the first record
			 */
			while(rs.next()) {
				/*
				 * this will create a country from the code,name,continent,population,lifexpectancy,
				 * and surfaceArea fields of each record for every country in europe
				 */
				Country country=new Country(rs.getString(1),rs.getString("Name"),rs.getString(3),
						rs.getInt("Population"),rs.getDouble("LifeExpectancy"),rs.getDouble("SurfaceArea"));
				//this country is then added to our list of countries
				countriesEurope.add(country);
			}
			//this will select all of the countries of the world
			ResultSet rsCountry=stmt.executeQuery("select * from country");
			//this will populate our list of Countries countryWorld with all the countries of the world
			while(rsCountry.next()) {
				Country country=new Country(rsCountry.getString(1),
											rsCountry.getString("Name"),
											rsCountry.getString(3),
											rsCountry.getInt("Population"),rsCountry.getDouble("LifeExpectancy"),
											rsCountry.getDouble("SurfaceArea"));
				countryWorld.add(country);
			}
			
		}
		catch(SQLException e) {
			System.out.println("unable to connect in ex2, exception is "+e);
		}
		System.out.println("all of the countries of Europe****");
		System.out.println(countriesEurope);
		System.out.println("there are "+countriesEurope.size()+" countries in europe");
		/*
		 * we performa  filter operation on the list of countries in europe, to see which countries have a 
		 * population greater than 10 million
		 */
		countriesEurope.stream().
			sorted().//Country implements comparable and sorts of name of country
			filter(c->c.population>10_000_000).
			forEach(c->System.out.println("the country "+c.name+" has a population more than 10 milllion"));
		
		System.out.println("there are "+countryWorld.size()+" countries in the world");
		System.out.println("using Streams and databases to get the same result");
		/*
		 * produces a stream of countries based on the countryWorld list of country objects
		 * here used in conjunction with peek() will print out all the countries in europe with a population less
		 * than 10 million
		 * and then print out all the countires with a population greater than 10 million
		 * will produce an outcome like
		 * the country in europe Romania has a population more than 10 milllion
			this is a country in Europe Sweden
			the country in europe Germany has a population more than 10 milllion
			this is a country in Europe San Marino
			this is a country in Europe Slovakia
			this is a country in Europe Slovenia
		 */
		List<Country>lessThan10Mill=new ArrayList<>();
		countryWorld.stream().//produces a stream of all the countries in the world
		//c is a country, so we are filtering for countries only in europe
			filter(c->c.continent.equalsIgnoreCase("europe")).
			//this will print out all the countries in europe with a population less than or equal to 10 million
			peek(c->{
				if(c.population<=10_000_000)
					System.out.println("this is a country in Europe "+c.name);
				/*
				 * we could add these countres to they're own list
				 */
		//		lessThan10Mill.add(c);
			}).
		//filtering for countries then that have populations greater than 10 million	
			filter(c->c.population>10_000_000).
			//printing our countries that are in europe and have a population greater than 10 million
			forEach(c->System.out.println("the country in europe "+c.name+" has a population more than 10 milllion"));
	}
	
	
	static void ex3() {
		//creating a connection to "world" database
		try(Connection con=connectMe("world")){
			Statement stmt=con.createStatement();
			/*
			 * this returns the amount of countries in the country table
			 * this will return only ONE row, and it will contain the number 239
			 * whenever using the mysql command count,sum,min, max,avg you will only have one
			 * column and one row
			 */
			ResultSet rs=stmt.executeQuery("select count(*) from country");
			int countryAmt;
			if(rs.next()) {
				System.out.println("amount of countries in country table is "+rs.getInt(1));
				countryAmt=rs.getInt(1);
			}
			/*
			 * this is a more complex nested query, although you will not be expected to know complex nested
			 * queries for the exam, you will be expected to know that if you have the max() mysql statement
			 * this produces only one record
			 * this select the name of the country and population of that with the highest population which is
			 * 'China', '1277558000'
			 * this is one row/record with two columns/fields

			 */
			rs=stmt.executeQuery("select name, population from country where population =("
					+ "select max(population) from country)");
			if(rs.next()) {
				System.out.println("the country with the highest population is "+rs.getString(1));//name of country
				System.out.println("that population is "+rs.getInt("population"));
			}
			/*
			 * the country with the lowest population, we use the mySql function min()
			 */
			rs=stmt.executeQuery("select name, population from country where population =("
					+ "select min(population) from country)");
			if(rs.next()) {
				System.out.println("the country with the lowest population is "+rs.getString("name"));
				System.out.println("that population is "+rs.getInt("population"));
			}
			/*
			 * the total population of the planet, using sum() from mysql
			 */
			rs=stmt.executeQuery("select sum(population) from country");
			long population=0;
			if(rs.next()) {
				population=rs.getLong(1);
				System.out.println("the population of the planet is "+population);
			}
			/*
			 * the average population of country, using the avg() from mysql
			 */
			rs=stmt.executeQuery("select avg(population)from country");
			if(rs.next()) {
				int avePop=rs.getInt(1);
				System.out.println("the average population is "+avePop);
			}
			
		}
		catch(SQLException e) {
			System.out.println("connection failed in ex3 "+e);
		}
	}
	
	static void ex4() {
		System.out.println("getting a date from a column");
		try(Connection con=connectMe("mydatabase")){
			Statement stmt=con.createStatement();
			/*
			 * we are selecting dates from the orders table in the order_date column
			 * the order_date column uses the mysql date time data type, 
			 * this produces 5 records and one column
			 */
			
			ResultSet rs=stmt.executeQuery("select order_date from orders");
			while(rs.next()) {
				//this will get the date fom the order_date column which contains a mysql DateTime data type
				//java.sql.Date sqlDate=rs.getDate(1);
				//this will get the time from the order_date column which contains a mysql DateTime data type
				//LocalDate date=sqlDate.toLocalDate();
				
				/*
				 we use one line of code to accomplish getting a LocalDate from a mysql dateTime data type
				 rs.getDate(1) returns a mysql.Date object and then we call the toLocalDate() method of the
				 sql.Date class to convert this to a localDate
				 */
				LocalDate date=rs.getDate(1).toLocalDate();
				/*
				 * here we use two lines to accomplish getting the time from a mysql.time object
				 */
				java.sql.Time sqlTime=rs.getTime(1);//this create a sql.Time object
				LocalTime time=sqlTime.toLocalTime();//this sql.Time object calls toLocalTime() which returns a LocalTime object
				System.out.println("date is "+date);
				System.out.println("time is "+time);
				time=rs.getTime(1).toLocalTime();//this will convert to localTime over one line of code instead of two
				/*
				 * if you want to get the time and date, you have to use the sql.TimeStamp data type
				 */
				java.sql.Timestamp sqlTimeStamp=rs.getTimestamp(1);
				LocalDateTime dateTime=sqlTimeStamp.toLocalDateTime();
				System.out.println("local date time for this entry is "+dateTime);
				//this is the same as above, but truncated to one line of code
				dateTime=rs.getTimestamp(1).toLocalDateTime();
			}
			
		}
		catch(Exception e) {
			System.out.println("connection failed in ex4 "+e);
		}
	}
	
	static void ex5() {
		System.out.println("scrolling ResultSet");
		try(Connection con=connectMe("mydatabase")){
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select cust_id from customers");
			System.out.println("afterLast()");
			//this places the position in the resultSet to after the last result
			rs.afterLast();//returns void
			System.out.println("previous()");
			/*
			 * this will return true as long as there is a record before the current position it also moves the position
			 * of the resultset to the previous position, which will be in this case the last entry in the table
			 * which is the nubmer 
			 * '100000010'
			 */
			System.out.println(rs.previous());//true returns a voolean
			System.out.println("id on last row is "+rs.getInt(1));
			System.out.println(rs.first());//moves resultSet to first position in result
			System.out.println("id on first row is "+rs.getInt(1));//'1000000001'
		//	rs.previous();//this brings us to a position of before the resultset, and returns false
		//	System.out.println(rs.getInt(1));//this generates a java.sql.SQLException
			System.out.println(rs.last());//moves resultSet to last position in resultset
			System.out.println("id on last row us rs.last() is "+rs.getInt(1));
			/*
			 * if we want to get the postion to before the start of the resultSet, we use
			 * beforeFirst(), returns void
			 */
			rs.beforeFirst();//returns void
	//		rs.getInt(1);//this would return an sqlException as we are currently before the start of the resultSEt
			rs.next();
			System.out.println("now we can  get a result which is "+rs.getInt(1));
			
			System.out.println("absolute");
			/*
			 * absolute moves the resultset to a particular row absolute(0) is before the first row
			 * absolute(1) is the first row
			 * absolute returns a boolean, true if a record exists there, false if not
			 */
			System.out.println("rs.absolute() "+rs.absolute(0));//will return false as this is before the resultSet
			rs.next();//'1000000001'
			System.out.println(rs.getInt(1));
			System.out.println("go to record 3 "+rs.absolute(3));//returns true as record exists on this row
			System.out.println(rs.getInt(1));//third row contains the int 1000000003
			/*
			 * you can put in any number and it will not cause an exception, it will just return false if there
			 * is no row 456, there is'nt, we only have 11 records, so this returns false
			 */
			System.out.println(rs.absolute(456));
			
			System.out.println("rs.absolute(-1) will always be the last record "+rs.absolute(-1));
			System.out.println(rs.getInt(1));
			/*
			 * as we have 11 records, if we use rs.absolute(-11) we will get the first row
			 * 
			 */
			System.out.println("rs.absoute(-amount of records) will be the first record in the resultSEt");
			System.out.println(rs.absolute(-11));//first record
			System.out.println(rs.getInt(1));//1000000001
			System.out.println("relative()");
			/*
			 * moves you a certain amount of rows, relative to the current position
			 */
			rs.absolute(2);//row 2 id is '1000000002'
			System.out.println("rs.relative(2) is two positions forward relative to postiion 2, which will be position 4");
			System.out.println(rs.relative(2));//moves to position 4, returns true as a row exists here
			System.out.println(rs.getInt(1));//1000000004
			/*
			 * at postion 4 and want to move back to position 1, which contains 1000000001
			 * move back 3 postions relative to position 4 in the resultset
			 */
			System.out.println(rs.relative(-3));
			System.out.println(rs.getInt(1));//1000000001

		}
		catch(Exception e) {
			System.out.println("unable to connect to database in ex5 because of "+e);
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
			System.out.println("unable to make connection in the method connectMe and the exception is "+e);
			return null;
		}
		
	}

}
