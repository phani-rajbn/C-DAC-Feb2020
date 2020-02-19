/*
DataTypes.cpp. Most of the data types in C++ are based on C data types. Whenever U declare a 
 datatype variable, it allocates certain memory whether U use it or not. So declare the variables
 only if it is essential. So the data that it stores and the duration of the storage matters a lot.  
if U want to store the data for a very long time, U could create the variables as global
variables. For short span of time,  U could create local variables. 
Data types in C++ are primary, user defined and derived data types
Primary: integer, charecter, boolean, float, double, wide charecter, void.
Derived data types: These types are derived (inherited) from the primitive types:
Function, Array, Pointer, Reference.
User defined Datatypes which are created by the User for his application requirements: 
structures, classes, union, enumerations, typedef defined data types.  
Refer the C++ documentation for the sizes and range for all the primitive types of C++. 
Each data type has a specific size and a range of data that it can hold. As a programmer U should
anticipate the data that UR variable would hold and then declare them accordingly. 
However U could use data type modifiers along with builtin types to modify the length of the 
data that type could hold:
signed, unsigned, short, long. 
short int : 2 Bytes  -32000 to 32000
unsigned short int:  0 to 65K+
long long int: 2^ 64 .
To determine the size of any data type U could use sizeof operator...
*/
#include<iostream>
using namespace std;

int main(){
	cout<<"The size of char: " <<sizeof(char)<< " bytes \n";
	cout<<"The size of int: " <<sizeof(int)<< " bytes \n";
	cout<<"The size of short int: " <<sizeof(short int)<< " bytes \n";
	cout<<"The size of long int: " <<sizeof(long int)<< " bytes \n";
	cout<<"The size of unsigned long int: " <<sizeof(unsigned long int)<< " bytes \n";
	cout<<"The size of double: " <<sizeof(double)<< " bytes \n";
	cout<<"The size of float: " <<sizeof(float)<< " bytes \n";
}


