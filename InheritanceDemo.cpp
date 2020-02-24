#include<iostream>
#include "InheritanceDemo.h"
using namespace std;
//Inheritance is a feature of OOP which allows to extend a class to add more features to it. A class is closed for modification but is open for extension. Any existing classes are not recommended to be modified but could extend it into another class and add the new features to the new class instead of adding them to the existing ones. 
//The class whose properties and functions are inherited is called as Base class, Super Class or Parent class. The Class which acquires the features is called as Child class, derived class or Sub class.
//All the members of the class except private are inherited. 
/*
Purposes:
Code reusability: Existing class to be customized to Ur requirements. 
Method Overriding: Modifying one or more functions to suit Ur needs. 
Extendability: Want to add one or more functions to the existing system.
*/

class BaseClass {
public:
	void testFunc() { cout << "Test Func implemented\n"; }
};

class DerivedClass : public BaseClass {
public:
	void anotherFunc() { cout << "Another Func implemented\n"; }
};

void objectVersion()
{
	BaseClass cls;
	cls.testFunc();//Base class has only function...

	DerivedClass cls2;
	cls2.testFunc();//from the base class..
	cls2.anotherFunc();//from the derived class...
}

void pointerVersion() {
	BaseClass* pBase = new BaseClass();
	pBase->testFunc();

	DerivedClass* pDerived = new DerivedClass();
	pDerived->testFunc();
	pDerived->anotherFunc();

	pBase = new DerivedClass();//base class pointer is instantiated to the derived class. 
	pBase->testFunc();//This is called as UPCASTING. Upcasting is using a Base class reference or pointer to refer a Sub class or derived class object. In this case, if there are any new functions of the derived class, it will not be available for the base class pointer. 

}


int main() {
	//objectVersion();
	pointerVersion();
}


/*
POINTS to remember:
While creating the derived class, ensure that the base class is already implemented. 
Access modifier for the implementation tells that the members of the base class are inherited into the derived class as public, private or protected. 
public means accessible from anywhere, private means accessible within the class and protected means accessible within its class and its derived classes. 
*/