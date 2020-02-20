#include "CommonFunctions.h"

//The class is an UDT which can hold some data in it as well as functions that would manipulate
//the data in it. Usually the data will be hidden from other parts of the program. 
class Employee{	
private:	
	//the data of the class that is defined inside it are called data members of the class. 
	int empID;
	string empName;
	string empAddress;
public:
	void SetDetails(int no, string name, string address){
		empID = no;
		empName = name;
		empAddress = address;				
	}
	string getName(){
		return empName;
	}	
	string getAddress(){
		return empAddress;
	}
};
//The step of OOP is class. Class is a user defined type. 
int main(){
   Employee cls;//variable of a class is called as object or instance. 
   //cls.empID = 123;//thro the variable ofthe class we use . operator to access the members. 
	int id = getNumber("Enter the Id of the employee");
	string name = getString("Enter the Name of the Employee");
	string address = getString("Enter the Address, please");
    cls.SetDetails(id, name, address);
    print("Employee details are set!!!!");
    print("The Name of the Employee: " + cls.getName());
    print("The Address of the Employee: " + cls.getAddress());
}
