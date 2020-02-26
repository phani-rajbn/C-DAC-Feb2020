//CommonFunctions.h
#pragma once
#include<iostream>
#include<string>
using namespace std;

//prints the msg...
void print(string msg){
	cout<<msg<<endl;
}
//getString returns a string entered as input by the user after displaying the question
string getString(string msg){
	print(msg);
	string answer;
	cin >> answer;
	return answer;
}

int getNumber(string msg){
	int answer = 0;
	print(msg);
	cin >> answer;
	return answer;
}

double getDouble(string question){
	double res = 0.0;
	print(question);
	cin>>res;
	return res;
}


