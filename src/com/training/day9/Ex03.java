package com.training.day9;
//This program is to show the demo on Insertion using PreparedStatement...

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.training.day4.MyConsole;

public class Ex03 {

	public static void main(String[] args) {
		String name = MyConsole.getString("Enter the name of the Employee");
		String address = MyConsole.getString("Enter the City of the Employee");
		int salary = MyConsole.getNumber("Enter the salary of the person");
		
		//String insertStatement = String.format("Insert into employee(empname, empaddress, empsalary) values('%s', '%s', %d)", name, address, salary);
		String insertStatement = "Insert into employee(empname, empaddress, empsalary) values(?,?,?)";
		try {
			Connection con = DBUitl.getConnection();
			PreparedStatement ps = con.prepareStatement(insertStatement);
			//In the above statement, the sql Command with ??? are sent to the server and comes back with a unique id representing a pre compiled SQL statement on the server so that its execution becomes fast.
			//U set the values to those ? using index starting with 1....
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setInt(3, salary);
			int rowsAffected = ps.executeUpdate();//This will return a value of the number of rows affected after the query execution..
			if(rowsAffected == 1)
				MyConsole.print("Employee added to the database");
			con.close();			
		}catch(SQLException sqlEx) {
			MyConsole.print(sqlEx.getMessage());
		}catch(ClassNotFoundException clsEx) {
			MyConsole.print(clsEx.getMessage());
		}
	}

}
