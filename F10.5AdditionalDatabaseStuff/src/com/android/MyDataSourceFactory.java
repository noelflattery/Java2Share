package com.android;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MyDataSourceFactory {
	
	
	public static DataSource getMySQLDataSource() {
		//properties class is a class that is used to maintain a list of key value pairs that relate
		//to variables needed to connect to a databaswe
		Properties props=new Properties();
		//for loading the text from db.properties into the props properties object
	//	FileInputStream fis=null;//we can use a FileInputStream to do this
		FileReader fr=null;//or we can use a FileReader to do this
		
		MysqlDataSource mysqlDS=null;
		
		try(FileInputStream fis=new FileInputStream("db.properties");){
			props.load(fis);
			mysqlDS=new MysqlDataSource();
			mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
			mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
			mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
		//	mysqlDS.getUser();
			return mysqlDS;
		}
		catch(Exception e) {
			System.out.println("exception in mydatabaseSourceFactory class is "+e);
		}
		return null;
	}
	

}
