#include<iostream>
using namespace std;
/*
Abstract classes are classes that contain one or more functions that are not implemented in them. These functions are intended to be implemented by their derived classes. As these classes are not implemented completely, they cannot be instantiated. 
A function can be created without an implementation if it is a pure virtual function. A virtual function assigned to 0 makes it pure virtual function
*/

class AbstractClass {
public:
	void normalFunc() { cout << "Normal func\n"; }
	virtual void testFunc() =0;//pure virtual function. 
};


class DerivedClass : public AbstractClass {
public:
	void testFunc() {
		cout << "test func implemented in derived class\n";
	}
};//The class that is derived from abstract classes, must implement all the abstract methods(Pure virtual methods) of the base class. Else even this class becomes abstract.  

int main() {
	AbstractClass* cls = new DerivedClass();
	cls->normalFunc();
	cls->testFunc();
}