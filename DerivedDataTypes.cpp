//DerivedDataTypes.cpp
/*
Data types that are derived from the primitive or builtin types are called as Derived Types
Functions, Arrays, pointers and references are the examples of derived types.
A Function is a set of statements that performs a computation based in inputs given to it in 
the form of arguments and provide the output from that operation as a return value of that function
All functions dont return a value. Functions without a return value are called Sub-routines.
If U want to put some commonly performed tasks into a group and use it quite frequently in ur
program, then U should make that as a function and use it in a single line instead of writing 
the same code again and again.  

POINTS to REMEMBER:
A Function must have a declaration, body and Calling mechanism.
The declaration tells the compiler about the parameters and their data types, order of placing
and the return type of the function. If the function does not return any value, it is void function
Every function U create must be called in the program either directly or indirectly. 
main is the only function that is called by the OS, not by the programmer.
return statement is used to terminate the function.  
In C++, functions can return any data type except Arrays. However U could use pointers in place.
It is good practise to declare the functions in a seperate file called Header file and implement
them inside a CPP file. But U could implement UR Functions in the header file also.  
*/
#include<iostream>
using namespace std;  
//This function is used to extract the max value from 2 variables given...
int getMax(int x, int y){
	if(x > y)
		return x;
	else
		return y;
}

void print(char* msg){
	cout<<msg<<endl;
}
int main(){
	print("An apple");
	print("A Mango");
	cout<<"The max value is " <<getMax(23,20)<<endl;//Using a function like a variable...
}
