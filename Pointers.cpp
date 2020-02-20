#include "CommonFunctions.h"
/*
Pointers: Symbolic representation of addresses are called as pointers. They are basically used
to hold variables by references and create and manipulate data dynamically. Dynamically means 
when the program is executing.

How to use pointers?
Define a pointer variable.
Assign the pointer variable with an address of any variable belonging to the same type using
an operator called &. 
Accessing or manipulating the value stored in the variable using an operator called *. 
*/ 
//create a function that returns an array...
int* createIntArray(int size){
	int* array = new int[size];//array creation dynamically...	
	for(int i=0; i < size; i++){
		array[i] = getNumber("Enter the value for the array");
	}
	return array;
}
//pass an array as argument to a function....
int getSum(int* values, int size){
	int sum = 0;
	for(int i =0; i < size;i++){
		sum += values[i];
	}
	return sum;
}

void testFunc(int* value){
	*value += 123;
	cout<<"The value after modification is " <<*value<<endl;
}

void normalTestFunc(int value){
	value += 123;
	cout<<"The value after modification is " <<value<<endl;	
}
int main(){
	
	int var = 123;
	cout<<"The address of var is "<<&var<<endl;
	//creating a pointer:
	int* ptr =  &var;//pointing this variable to the address of another variable.
//	cout<<"The address: "<<ptr<<endl;
//	cout<<"The value: "<<*ptr<<endl;
//	cout<<"The Current address: "<<ptr<<endl;
//	cout<<"The Next address: "<<++ptr<<endl;
//	int array[] = {3,4,5,6};
//	ptr = array;//In this case, the ptr will point to the first value of the array.. 
//	cout<<"The value of ptr is " <<*ptr<<endl;
//	cout<<"The value of the next location is "<<*(++ptr)<<endl;
	//int size = getNumber("Enter the size of the Array that U want to create");
    //ptr = createIntArray(size);
//    for(int i =0; i < size;i++){
//    	cout<<"The value: "<<ptr[i]<<endl;
//	};

	
//for(int i = 0;i < size; i++){
//	cout<<"The value: "<<*(++ptr)<<endl;
//}
//  int numbers[] = {1,2,3,4}; 
//  int totalsize = sizeof(numbers);//get the size of the array
//  int intSize = sizeof(int);//get the size of each int 
//  int noOfElements = totalsize/ intSize;//total/each will give no....
//  
//  int totalSum = getSum(numbers, noOfElements);
//  cout<<"THe Sum of the values: "<<totalSum<<endl;
  normalTestFunc(var);
  cout<<"The value of var after returning from the function: "<<var<<endl;
  testFunc(&var);
  cout<<"The value of var after returning from the function: "<<var<<endl;
}
/*
POINTS:
asterisk(*) is used to declare a pointer
(&) is used to refer an address of a variable
asterisk(*) is also used to get or set the value of a pointer(dereferencing). 
void* is used to store any kind of address. 
All arithematic operators are applicable to pointer variables.
Pointers passed as arguments to the function will retain the value modified by the function 
after it returns from the function. This is called as PASS BY POINTER.  
In C++, bydefault args are passed by value and changes made in the function will not reflect 
in the passed variable. So we use PASS BY POINTER and PASS BY REFERENCE.  
*/




