/*
Arrays in C++ is a collection of continuous memory of values and can be accessed randomly using 
an integer called index. index starts from the first element with value 0 till the end of the 
content. Arrays are of the same type.
Arrays help in refering a group of elements of the similar type by one name and refer 
individually thro index using [](SubScript) operator.
*/

#include<iostream>
#include<string>
#include<cstring>
using namespace std;
void firstExample(){
	int elements[5];
	for(int i =0; i < 5; i++){
		elements[i] = i+ 1;
	}
	
	int values[5] = {3,4,5,6,7};//Initializing the values while creating the array...
	//U could also create array as pointer variable, will be covered later...
	
	int copies[] = {45,56,7,6,56,456,45,6, 536, 66};
	
	int size = sizeof(copies);
	int ele = sizeof(int);
	int no = size /ele;
	cout<<"The no of elements: "<< no<<endl;
	//Array creating without mentioning the size
	int start = 0;
	while(start < no){
		cout<<"The Value: " <<copies[start]<<endl;
		start++;//++ Operator is used to increment the value by 1.  
	}
	
}

void TwoDExample(){
	int array2D[3][4];
	for(int i =0; i <3 ; i++){
		for(int j =0; j <4;j++){
			array2D[i][j] = i + j;	
		}
	}
	//For Associative Arrays, U should use map in C++ STL...
	cout<<"Displaying in matrix format....\n";
	for(int i =0; i< 3; i++){
		for(int j =0; j< 4;j++){
			cout <<array2D[i][j] << " "; 
		}
		cout<<"\n";
	}
}

void charArrayExample(){
	char strFruit[100];
	strFruit[0]= 'A';
	strFruit[1]= 'p';
	strFruit[2]= 'p';
	strFruit[3]= 'l';
	strFruit[4]= 'e';
	cout<<strFruit<<endl;
	strcat(strFruit, " keeps the doc away");//C Function used to concatinate..
	cout<<strFruit<<endl;
	//Array of charecters is nothing but string....
}

void stringProgram(int no){
	
	string msg = "Apple a day";
	msg += " keeps the doc away ";
	cout<<msg<<endl;
	//string is a part of the C++ Std Libraries that is created to provide simpler syntaxes for 
	//the commonly used operations and data structures. string class gives modren string based
	//operations like concatinations, formating without using arrays. 
}
/*
POINT: If I have a set of functions that I wish to use across different files within my 
application, I could group those functions inside a Header File(A Text file with extension .h)
and refer that file across the other CPP files using #include "FileName". U should include
the filename using " " for user defined Header files. Header files that is provided by the Std
C++ library should not be placed within "". 
*/
int main(){
	firstExample();
	//TwoDExample();
	//charArrayExample();
	stringProgram(5);
//	int arr[4];
//	arr[0] = 123;
//	arr[3/2]= 234;//arr[1]
//	arr[4/2] = 546;
//	cout<<arr[345]<<endl;//would give garbage value...
	 
	//There is no out of bound checking in C++. The compiler might not give any error but the
	//output would be unexpected results..
	//PS: There is no property or function to get the size of an array in C++. 
	/*
	Advantages:
	U could access the elements within the array in a random manner. 
	U could refer good no of elements in a simplified manner. 
	Reading and writing the values into the elements can be done in a simplified loop. 
	Sorting of data will be easy as U could do it with less lines of code. 
	
	Disadvantages:
	Fixed in size, so at the time of declaration, U should be aware of the size. 
	Insertion and Deletion could be done but with lots of logic and memory handling which 
	will be tedious. 
	Arrays cannot be passed as args of a function or as a return type of a function.
	*/
}


