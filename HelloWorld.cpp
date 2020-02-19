//helloWorld.cpp
#include<iostream>
using namespace std;
/*
C++ programs will use functions created by the C++ Developer Teams and other 3rd party developer
community.These functions are distributed as Libraries and Header files. U as a programmer will
use the header files by including them before any line of code is executed in UR file. U 
instruct the System to load those files before any processing of the program begins. This is 
called as preprocessor instruction which is a statement preceded by #. 
#include is one such preprocessor instruction which means to include a specified file, class or 
a component. 
iostream is a file Component that contains all the std IO based functions that can be used 
typically in any C++ based Console programs. So #include<iostream> means to ask the Compiler to 
include a file called iostream that contains lots of functions and classes to perform input and 
output operations using C++. 
*/
//main is global function. Is the entry point of the Application.
//This is the minimal function of C++ program.
//{} represents the scope or area of work within a program. Anything U declare within this block 
//is not available outside this block.
//namespace is a conceptual block in C++ used to group functions and classes(types) to avoid
//naming conflicts. if U want to use classes and functions of a certain namespace frequently, 
//then u could use the namespace before any function or a statement declaration within the file.

//C++ has one class to interact keyboard with the OS called as istream. to display on the std 
//output device it has a class called ostream. 
//cout is the statement used to display text or content on the std output device of the OS. 
//in this case, the Console window is the std output device for Windows OS. cout is basically 
//an object of the ostream class. It is used to produce the output on the std Output device 
//that is associated with the OS. The cout is supported with a set of operators which have 
// a sp meaning when used within the program. << is one such operator used to extract the data 
//and place it in the ostream of the OS..endl is instructing to end the line. Alternatively
//U could use /n which is similar to C.    
 
/*std input stream(cin): keyboard is the std input device of the Computer. cin is the instance 
  or object of the istream class and is used to read input from the input devie. The >> extraction
   of the inputs are pushed into the program thro the cin object which is entered using 
   keyboard. 
Any inputs made into the program has to be stored so that it could read or retrived sometime 
later. That storage memory or location is called as variable. The variable is declared along with
the type of the data that it can hold. The term variable is because the location can be filled
with other values at later point of time.  

endl will flush the stream after it executes. It is same as writing cout<<"\n"<<flush. So cout <<"\n" seems 
mor eperformance wise better than cout<<endl unless flushing of the stream is required. flushing 
is required when U are about to close the stream or close the Application and U dont want any 
left over data to be struck in the stream itself, flushing would clear all the data to its 
destination which U dont do frequently.
endl is a manipulator while \n is a charecter. 
\n occupies memory of 1 byte. 
U cannot write endl in b/w the string statements. 
endl is supported in C++ but \n is supported both in C as well as C++...    
*/
//>> is called as extraction operator and << is called as insertion operator in C++.   

int main(){
	int age;
	cout<<"Enter UR Age"<<endl;
	cin>>age;
	cout<<"UR Age entered is " <<age<<endl;	
	
	cout<<"I am entering my Age"<<endl;
	age = 43;
	cout<<"My Age is " <<age<<endl;	
}   
 

