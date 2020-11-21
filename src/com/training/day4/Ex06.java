package com.training.day4;
/*Inner Classes
 * Inner classes are also called as NESTED Classes where a class is declared within an other class. 
 * This is typically required to group ur classes as one unit other than a package. 
 * If there are private variables of a class and U want to use them in Ur class, then U could make Ur class as a inner class to the class whose private members U want to access. In this case, the class that U create is called inner class and the class in which U R creating is called outer Class. 
 * */
public class Ex06 {
private int empId;
	private String empName;
	private double empSalary;
	
	public Ex06(int id, String name , double salary) {
		this.empId = id;
		this.empName = name;
		this.empSalary = salary;
	}
	class Address{
		String street1;
		String street2;
		String City;
		
		void DisplayDetails() {
			String details = "";
			//Employee emp = new Employee(123, "Phaniraj", 45000);
			details = String.format("The Name : %s\nThe Address: %s\n%s\n%s\nThe Salary: %f", empName, this.street1, this.street2, this.City, empSalary);
			System.out.println(details);
		}
	}
	public static void main(String[] args) {
		Ex06 emp = new Ex06(123, "Phaniraj", 45000);
		Ex06.Address addr = emp.new Address();
		addr.street1 = "MG Road";
		addr.street2 ="Church St.";
		addr.City = "Bangalore- 560001";
		
		addr.DisplayDetails();
	}
}

