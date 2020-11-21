package com.training.day9;
//JDBC Program:

import java.sql.Connection;
import java.sql.DriverManager;

import com.training.day4.MyConsole;

/*
 * Limitations of the file io: no security, no scalability, data and the resource can easily be corrupted. 
 * JDBC stands for java database connectivity based on ODBC of Windows OS. JDBC is a set of apis for performing database centric operations using SQL as a communicating language.
 * JDBC has classes that encapsulate the complexities of the database program like IPC, language accessibility, data conversions, serialization and many more. It has classes to connect the database, commands to execute and read the data in the form of resultset. These APIs will encapsulate lot of internal operations that are required for the application.  
 * JDBC uses high level APIs called Drivers to interact with the database. These drivers are vendor specific. The APIs and these drivers are distributed for Java programmers in the form of Jar files. U need to download the jdbc jar file from mysql database. 
 * */
public class Ex01 {
	
	final static String url = "jdbc:mysql://localhost/sampledb";
	final static String user ="root";//provide the user name
	final static String pwd = "apple123";//provide the password...
	final static String select = "SELECT * FROM EMPLOYEE";
	final static String driver = "com.mysql.cj.jdbc.Driver";
	
	public static void main(String[] args) throws Exception {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pwd);
		if(con == null) MyConsole.print("Connection to the database failed");
		else MyConsole.print("Database connection succeeded");
	}

}
