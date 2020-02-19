#include<iostream>
using namespace std;

void print(char* msg){
	cout<<msg<<endl;
}
int getNumber(char* question){
	int no;
	cout<<question;
	cin >> no;
	return no;
}

char getChar(char* question){
	char answer;
	cout<<question;
	cin >> answer;
	return answer;
}


int addFunc(int v1, int v2){
	return v1 + v2;
}
int process(int first, int second, char operand){
	int resultValue = 0;
	switch(operand){
		case '+':
			resultValue = addFunc(first, second);
			break;
		case '-':
			resultValue = first - second;
			break;
		case 'X':
			resultValue = first * second;
			break;
		case '/':
			resultValue = first / second;
			break;				
	}
	return resultValue;
}
int main(){
	int firstValue, secondValue, resultValue;
	char operand;
	firstValue = getNumber("Enter the First Value");
	secondValue = getNumber("Enter the Second Value");
	operand = getChar("Enter the operator as + or - or X or /:");
	resultValue = process(firstValue, secondValue, operand);
	cout<<"The Result of this Operation is: "<<resultValue <<endl; 	
}
