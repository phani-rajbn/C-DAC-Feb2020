package com.training.day9;
import java.sql.*;

import com.training.day4.MyConsole;
//executeQuery is used when U want to extract data from the database in the form a SELECT Statement. 
//executeUpdate is used when U want to send some data to the database but wont expect any result: INSERT-DELETE-UPDATE.
public class Ex02 {
	private static String strQuery = "SELECT * FROM employee";
	//Read the data from the database..
	public static void main(String[] args) {
		readData();
		
	}
	private static void readData() {
		try {
			Connection con = DBUitl.getConnection();
			MyConsole.print("Connection Succeeded");
			Statement st = con.createStatement();//Statement is a class to represent the query U make to the database. createStatement returns a valid Statement object thru' which U make queries 
			ResultSet rs = st.executeQuery(strQuery);//Set of results that U have acquired from the SELECT statement....
			while(rs.next()) {
				MyConsole.print(rs.getInt(1));//1st column's data...
				MyConsole.print(rs.getString(2));
				MyConsole.print(rs.getString(3));
				MyConsole.print(rs.getInt(4));
				MyConsole.print("\n\n");
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
