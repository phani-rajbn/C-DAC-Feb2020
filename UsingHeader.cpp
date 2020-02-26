#include "CommonFunctions.h"
//For user defined files, U should include the header file within "". Std C++ header files 
//are including without "" and within <> braces. 

int main(){
	print("WELCOME TO EMPLOYEE REGISTRATION SYSTEM");
	int no = getNumber("Enter the Age");
	double salary = getDouble("Enter the Salary");
	string name = getString("Enter the Name");
	print("The name entered is " + name);
	cout<<"The Age entered is " <<no<<endl;
	cout<<"The Salary is " <<salary<<endl;
}
