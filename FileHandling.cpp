#include<iostream>
#include<string>
#include<sstream>
#include<fstream>

using namespace std;
/*
Files in Cpp are mainly done using fstream, ifstream, ofstream available under the fstream.h header file. An interaction with the file happens thro streams. Stream is nothing but continuos flow. flow can be from UR program(output) or to UR program(input). 
ofStream: Used to get data out of Ur program into a file(Output)
ifstream: Used to push the daata to Ur program from a file(Input). 
fstream: one that performs both input and output. 

Any file IO operation will have the following activities:
pass the filename in the constructor of the class(ifstream or ofstream). 
call the open method to perform any operation. 
finally after the operation is done, call the close method.

*/
class Employee {
public:
	int empId;
	string name;
	string address;
	Employee(int id, string name, string address) {
		empId = id;
		this->name = name;
		this->address = address;
	}
	Employee() : empId(0), name(""), address("") {

	}
	string toString() {
		string line = "";
		string strId = to_string(empId);//to_string is a function of string.h to convert numbers to strings...
		line = strId + "," + name + "," + address;
		return line;
	}
};

//This function adds the employee object to the csv file to save the data....
void AddNewEmployee(Employee emp, string csv) {
	ofstream fos;
	fos.open(csv, ios::app);
	fos << emp.empId << "," << emp.name << "," << emp.address << endl;
	fos.close();
}
Employee* getAllEmployees(string csvfile) {
	Employee* employees = new Employee[2000];//1000 employees...
	ifstream fs;
	fs.open(csvfile);
	int index = 0;	
	string line = "";
	while (fs) {
		getline(fs, line);
		stringstream s(line);
		Employee e;
		string word;
		int i = 0;
		while (getline(s, word, ',')) {
			if (i == 0)
				e.empId = stoi(word);
			if (i == 1)
				e.name = word;
			if (i == 2)
				e.address = word;
			i++;
		}
		employees[index] = e;
		index++;
	}
	fs.close();
	return employees;
}

void readFromFile(string filename) {
	ifstream fIn;
	string line = "";
	fIn.open(filename);
	while (fIn) {
		getline(fIn, line);//getLine method reads a line from the Inputstream and puts the data into the line object. 
		cout << line << endl;//Display the line...
	}
	fIn.close();
}

void writeToFile(string filename) {
	ofstream oFs;
	string line = "";
	oFs.open(filename, ios::app);//app means appending a file...
	while (oFs) {
		getline(cin, line);
		if (line == "-1") {
			break;
		}
		oFs << line << endl;
	}
	oFs.close();
}
int main() {
	//string filename = "B:\\Programs\\CDAC-Feb2020\\OOP with C++\\Notes.txt";
	////readFromFile(filename);
	//writeToFile(filename);
	//return 0;
	string file = "B:\\Programs\\CDAC-Feb2020\\OOP with C++\\Examples\\SampleVcppApp\\SampleConApp\\Employees.csv";
	Employee* list = getAllEmployees(file);
	for (int i = 0; i < 1050; i++)
		cout << list[i].toString() << endl;
	cin;
	//Employee emp;
	//cout << "Enter the ID" << endl;
	//cin >> emp.empId;

	//cout << "Enter the Name" << endl;
	//cin >> emp.name;

	//cout << "Enter the Address" << endl;
	//cin >> emp.address;
	//AddNewEmployee(emp, file);
	return 0;
}