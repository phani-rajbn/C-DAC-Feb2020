#pragma once
#include<iostream>
#include<string>
using namespace std;

void print(string msg) { cout << msg << endl; }

int getNumber(string question) {
	print(question);
	int answer = 0;
	cin >> answer;
	return answer;
}