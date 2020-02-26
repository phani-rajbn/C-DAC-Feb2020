#include<iostream>
#include<string>
using namespace std;
/*
One of the features of OOP is Polymorphism. It means having multiple forms of the same thing. In C++ polymorphism is of 2 types: CompileTime and Runtime Polymorphism. Compile Time polymorphism is achieved thro method overloading. 
Runtime polymorphism is done thro method overriding. 
Method overriding is a feature of allowing the derived class to modify the base class method without altering the signature of the base function. A signature includes the name, args as well as the return type.
The base class must provide permission for the function to be modified by the derived classes by using a modifier in the function declaration as virtual.  
*/
//Method overriding: 

class Baseclass {
public:
	void baseFunc() { cout << "Base Func\n"; }
	virtual void virtualFunc() { cout << "Virtual method, could be modified by the derived\n"; }//this function can be changed(overriden) in the derivied class.
};

class Derivedclass : public Baseclass {
public:
	void virtualFunc() { cout << "Virtual method from derived\n"; }
};


Baseclass* createObject(string arg) {
	Baseclass* ex;
	if (arg == "Base")
		ex = new Baseclass();
	else
		ex = new Derivedclass();
	return ex;
}

void main() {
	/*Baseclass* ptr = new Baseclass();
	ptr->virtualFunc();

	ptr = new Derivedclass;
	ptr->virtualFunc();*/
	string version;
	cout << "Enter the class U want to instantiate: base or else?\n";
	cin >> version;
	Baseclass* ptr = createObject(version);
	ptr->virtualFunc();
	//Same object invoking the same method but giving different functionalities is called as RUNTIME POLYMORPHISM....
}
