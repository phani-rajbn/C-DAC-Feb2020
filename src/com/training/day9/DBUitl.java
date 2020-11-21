package com.training.day9;


import java.sql.*;
//This class is used by programmers for utilizing some feature...
public class DBUitl {
	private static String driverClassName;
	private static String url, user, pwd;
	
	//It is used to initialize the static variables. It is called once and only once during an execution of the program...
	static {
		driverClassName = "com.mysql.cj.jdbc.Driver";
		url = "jdbc:mysql://localhost/sampledb";
		user = "root";
		pwd = "apple123";
	}
	
	static Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName(driverClassName); 
		Connection con = DriverManager.getConnection(url, user, pwd);
		return con;
	}
	
}
