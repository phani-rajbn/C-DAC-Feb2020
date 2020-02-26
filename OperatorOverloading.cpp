#include<iostream>
#include<string>
using namespace std;
//In Cpp operators could be converted to perform sp tasks to suit our requirements. This way of changing the behavior of the operators to meet our requirements is called as Operator overloading. Like the way we overload the functions to do different jobs with the same name, operators are intended to do their regular tasks and also get overloaded to perform developer customized operations. 

class Bill {
private:
	int no;
	double amount;
public:
	Bill() : no(0),amount(0)
	{
			
	}

	Bill(int no, double amount):no(no), amount(amount) {
		
	}
	string toString() {
		string content = "Total Bill: " + to_string(amount) + "\n";
		content += "Bill No: " + to_string(no) + "\n\n";
		return content;
	}
	//operator is a keyword used to overload the specific operator. It takes args based on what operation U wish to perform. The return type of the operator will provide the data or the object on the left hand side of the operator. 
	Bill operator +=(double amount) {
		this->amount += amount;
		return *this;
	}

	Bill operator +(double amount) {
		this->amount += amount;
		return *this;
	}

	Bill operator -=(double amount) {
		this->amount -= amount;
		return *this;
	}
};
void main() {
	Bill bill(123, 4000);
	bill + 4000;
	bill += 4000;
	bill += 500;
	bill += 400;
	bill -= 500;
	cout << bill.toString();
}
/*
POINTS:
For operator overloading to work, atleast one of the operands should be user defined data type(class or a struct). 
Compiler automatically creates a default assignment operator with every class. Defaultly it assigns all the members of the right hand side to the left hand side for all value types. For pointer references, U should over load the assignment operator. This is similar to the concept of copy constructor. 
Only builtin operators can be overloaded. U cannot create UR own new operator and start overloading it. 
Original feature of the operators cannot be changed. U can overload an operator not override it. 
Certain operators cannot be overloaded: ::, ., *, ?, sizeof, typeid operators. 
*/