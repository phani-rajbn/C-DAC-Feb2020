/*
Copy Constructor :
This is basically required when U wish to create a new object based on an existing object(object of the same class created previously).
Copy Constructor is called when :
U pass an object of a class as argument to the function.
Return an object from the function.
Initialize one object from another of the same type.
Copy constructor is be provided implicitly by the C++ compiler which U can override it if required.
*/
#include<iostream>
#include<string>
using namespace std;

class UserDetails {
public:
	string name, address;
	UserDetails(string name, string address)
	{
		this->name = name;
		this->address = address;
	}
};

class Employee {
public:
	static int NoOfTimes;
	int id;
	double salary;
	UserDetails* details;

public:	
	Employee(Employee& emp) {
		
		this->id = emp.id;
		this->salary = emp.salary;
		this->details = new UserDetails(emp.details->name, emp.details->address);
		NoOfTimes += 1;
		cout << "Copy constructor is invoked "<<NoOfTimes<<" Time(s)\n";
	}

	Employee(int id, double salary, UserDetails* details)
	{
		this->id = id;
		this->salary = salary;
		this->details = details;
		cout << "Employee is created\n";
	}

	void showDetails() {
		cout << "The Salary: " << salary << endl;
		cout << "The Employee ID: " << id << endl;
		cout << "The Name of the Employee: " << details->name << endl;
		cout << "The Address of the Employee: " << details->address << endl;
		
	}
};

int Employee::NoOfTimes = 0;

void showDetails(Employee emp) {
	emp.showDetails();
}

Employee createEmployee(int id, string name, string address, double salary) {
	Employee emp(id, salary, new UserDetails(name, address));
	return emp;
}
int main() {
	Employee emp(123, 45000, new UserDetails("Phaniraj", "Bangalore"));
	//showDetails(emp);//Passing an object as arg to a function...

	Employee temp(emp);//copying data of one object into another...
	temp.details->name = "NewSample Name";
	temp.details->address = "Mysore";
	showDetails(temp);
	showDetails(emp);

	//emp = createEmployee(123, "TestName", "TestAddress", 56000);
	//showDetails(emp);//Function returning an Employee as return type...

}