
#include<iostream>
using namespace std;
//virtual methods in C++ are those methods that make the function to be ound to the implementation thro late binding. When U mark a function as virtual, the pointer object of that class will not point to the method until runtime or until the object is being instantiated. Based on the object instantiaition, the pointer will point to the specific implementation. This feature is called as LATE BINDING. 
//To get the late binding feature, the Compilers use a concept called V-TABLE. For every class with one or more virtual functions, the compiler creates a table called V-Table. It is a table of pointers that point to the implementation of the virtual functions. So when the pointer variable is created, this vTable will be null. When its instantiated, the pointers will point to the implementation. The type of the object U have instantiated determines the implementation and so the specific version of the function gets called. 
//VTable is a table containing the addresses of all the virtual functions of the class. 
class TestClass {
public:
	void NormalFunc(){ cout << "Normal  Func\n"; }
	virtual void VirtualFunc() { cout << "Base  Version\n"; }
};


int main() {
	TestClass* ptr = new TestClass;
	ptr->NormalFunc();
}
/*
POINTS:
To get late binding feature, Compilers create VTables for each class with virtual function. 
Only base class method declaration needs virtual keyword, definition may not need. 
The virtual function retains its virtuality in all its derived classes. 
*/