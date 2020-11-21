package com.training.day9;

import java.sql.Connection;
import java.sql.Statement;

import com.training.day4.MyConsole;

public class Ex05 {

	public static void main(String[] args) {
		int id = MyConsole.getNumber("Enter the ID of the employee to delete");
		String deleteStatement = "DELETE FROM employee WHERE empid=" + id;
		try {
			Connection con = DBUitl.getConnection();
			Statement st = con.createStatement();
			st.executeUpdate(deleteStatement);
			MyConsole.print("Employee is deleted successfully");
			con.close();
		} catch (Exception e) {
			MyConsole.printError(e);
		}
	}
}
