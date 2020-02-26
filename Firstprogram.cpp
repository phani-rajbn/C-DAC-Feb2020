#include<iostream>
using namespace std;
//U should include the required libraries before U write any code.

//main is the begining of the Program's execution and when the main ends, the
//app will terminate. The running system shuts down the program. Exiting 
//main function is done using return keyword...
//main must have return type as int only. if the main returns 0. it means that 
//program has ended in a proper manner. Any -ve value is considered as exit with 
//some abnormality. 
//Some compilers will have an implicit return 0. Most of the OSs 
//interpret a return value of 0 to mean "Program completed successfully".
//main can optionally have parameters like command line arguments.  

//main is the function that will call other functions within the program. 
//usually main will be short, functions that are called in main will be longer 
//and might internally call other functions and opens a huge application execution.

//function is a semantically grouped set of statements or instructions which can be called 
//by one line and that group would be very frequently used inside the program. 


 
int main() {
	//Display something on the output window:
	cout<<"Some Text here\n";
	return 0;//Exit the program in a normal fashion...
}
