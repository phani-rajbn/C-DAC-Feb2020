#include<iostream>
#include<string>
using namespace std;
/*
Types of function in a class:
Instance functions: basic member functions of the class which is invoked only thro the instance of the class. The data and the functions are relative to the instance of the class. one instance and its data will not affect the other instance if created. 
Static Functions: Static means the one that does not change its position. In OOP, Static means members that are associated to the class but not to the instance of that class. It is more like a singleton function: One reference across the program. Static members work for the class, not for any perticular object of the class. The Static  methods are invoked using Classname::MethodName().
PS: U could still use static methods thro instance in C++.
Const Functions: Const functions are created to ensure that the data and the members of that function are not modified. This is required for optimization when the function's job is only to retrieve the data but not to modify and retrieve it. Such member functions can never modify the object or its related data members.
Inline Functions: Inline functions are functions that are copied every where we use them inside a program like a preprocessor macro. When a function is called in a program, compiler will link that function to the actual definition of the function. Only when the execution happens, the runtime will shift to the location of the function, executes and comes back to the calling procedure. this will have a performance issue if the function is very small. So to optimize the function calling, small functions can be made with a modifier called  inline so that where ever the function is refered, compiler will copy the function to that location so that runtime does not need to move to the function location and come back. However inline is a request not a command.

Friend Functions:  If I want to call a private member outside a class , U would create a function called friend thro which we could access the private members thro it. 
*/
class Example {
private:
	string someDataForMySelf;
public:
	void simpleFunc();
	friend void getURPrivateData();// A Friend fn is not a member function of the class. 
};

void getURPrivateData() {//This function does not have :: operator
	Example ex;
	ex.simpleFunc();
	//Calling the private field with the object outside the class...
	cout << "The private value: " << ex.someDataForMySelf << endl;
}

inline void Example::simpleFunc() {
	someDataForMySelf = "Apple 123";
	cout << "Inline function for optimization\n";
}

class Test {
private:
	static int noOfTests; 
	string name;
public:
	Test(string tname) { 
		name = tname; 
		noOfTests += 1;
	}
	//A Const member function 
	string displayName() const {
		//name = "Test Name";//Will be compile error as the function is const and should not modify any of the members that it is working with....
		return name;
	}
	void printName() { 
		cout << "Test name: " << name << endl; 
		staticMethod();//calling static method inside the instance method... 
	}
	static void staticMethod() {
		//printName();//Calling the instance method inside a static method. It is illegal to call a non static method without an object inside a static function...		
		cout << "Static Function called\n";
		cout << "The total no of Tests currently is :" << noOfTests << endl;
	}
};

int Test::noOfTests = 0;

void main() {
	//Test::staticMethod();//method of a class invoked without an object...
	//Test t("Cpp");
	//string name = t.displayName();
	//cout << "The name: " << name << endl;
	//t.printName();	
	//Test t2("Java");
	//t2.printName();
	//t2.staticMethod();//But will have the same effect as using without an object

	////Creating a const object and calling the methods....
	//const Test t3("C#");
	//name = t3.displayName();
	////t3.printName();//U cannot call the non const function thro a const object...

	getURPrivateData();
}