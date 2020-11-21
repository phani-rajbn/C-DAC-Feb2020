package com.training.day9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.training.day4.MyConsole;

//This is an example for updating a record....
public class Ex04 {

	public static void main(String[] args) {
		int id = MyConsole.getNumber("Enter the Id to update");
		String selectQuery = "SELECT * FROM employee where empid = ?";
		try {
			Connection con = DBUitl.getConnection();
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String name = rs.getString(2);
				String address = rs.getString(3);
				int salary = rs.getInt(4);
				
				name = MyConsole.getString("Enter the new name replacement for " + name);
				address = MyConsole.getString("Enter the new address replacement for " + address);
				salary = MyConsole.getNumber("Enter the new salary replacement for " + salary);
				
				String sqlStatement = "update employee set empname=?, empaddress=?, empsalary=? where empid=?";
				PreparedStatement ps2 = con.prepareStatement(sqlStatement);
				ps2.setString(1, name);
				ps2.setString(2, address);
				ps2.setInt(3, salary);
				ps2.setInt(4, id);
				ps2.execute();
				MyConsole.print("Employee updated Successfully");
			}else {
				MyConsole.print("No Employee by this id found to update");
			}
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
