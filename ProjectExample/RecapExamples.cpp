#include<iostream>
using namespace std;

//write a function that takes 2 int as arguement and returns the sum of 
//the two numbers...
double sumOfNumbers(double v1, double v2){
	return v1 + v2;
}

void displayQuotientAndRemainder(int v1, int v2){
	double quotient =0.0;
	int remainder =0;
	
	quotient = v1 /v2;
	remainder = v1 % v2;
	cout<<"The Quotient of this operation is: "<<quotient;
	cout<<"\nThe Remainder of this operation is "<<remainder<<endl;
}

//Write a function that display all the factors of a given number. 
void DisplayFactors(int no){
	//implement the code...
	cout<<"The factors of "<<no<<" are: \n";
	for(int i =1 ; i <= no;i++){
		if(no % i == 0)
			cout<< i << endl;
	}
}

//write a function that takes a string as argument and returns the reverse of that string..
//PS: use the size() of the string class to get the length of the string...
string reverseFunc(string arg){
	string content = "";
	for(int i =arg.size() - 1; i >= 0; i-- ){
		content += arg[i];
	}
	return content;
}

//write a function to get the no of words of a given string. 
int getNoOfWords(char* sentence){
	int count =1;
	while(*sentence){
		if(*sentence == ' ' || *sentence == '\n'){
			++count;			
		}
		++sentence;
	}
	return count;
}
//Arrays based examples////////////////////////
//Write a function that gets the max value and min value of the array.
void displayMaxAndMinValue(){
	int elements [] = {23,34,32,32,3,234,523,4};
	int totalSize = sizeof(elements);
	int intSize = sizeof(int);
	int noOfElements = totalSize / intSize; 
	int maxValue =0 , minValue =elements[0];
	for(int i =0; i < noOfElements; i++){
		if(elements[i] < minValue)  
			minValue = elements[i];
		if(elements[i] > maxValue)
			maxValue = elements[i];	
	}
	cout<<"The Min Value: "<<minValue;
	cout<<"\nThe Max Value: " <<maxValue<<endl;
}




//Write a function that takes 2 args and should display the quotient and remainder of the 2
//numbers. Call this function in the testFunc. 



void testFunc(){
	displayMaxAndMinValue();
	//cout<<getNoOfWords("Write a function that takes 2 args");
	//cout<<reverseFunc("Apple");
	//DisplayFactors(60);
//	double result = sumOfNumbers(3,4);
//	if(result == 7)
//		cout<<"Success!!!";
//	else
//		cout<<"Failed!!!";	
//	displayQuotientAndRemainder(12,4);
//	displayQuotientAndRemainder(12,5);	
}
int main(){
	testFunc();
}


