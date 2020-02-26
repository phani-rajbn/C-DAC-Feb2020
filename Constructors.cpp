#include<iostream>
#include<string>
using namespace std;
/*
Constructors are sp functions that is executed when we create an object. It is implicitly invoked. So in this function we write any set of statements that could make an object usable. U could inject the dependencies required for the object construction so that U could use the object without any other explicit function calls. 
C++ does not provide any implicit constructors. As a programmer U should provide the constructors for the object creation. 
They have the same name as the class and will not have any return types. They can be overloaded. Overloading of constructors are done for flexibility in object creation. 
They follow the inheritance chain hierarchy.
There are 3 types of constructors: Default, parameterized and Copy Constructor.
Copy Constructors is a feature in C++ that is used to construct a new object if U want to copy the data from one to the other.
*/
/*Constructors and Destructors: 
If a class is instantiated, the primitive members(Plain old datatypes) of the class will be initialized thro Initialization list. But when it comes to the UDTs like classes, U must initialize the object before the constructor is invoked. The right place to execute statements before  the constructor is called is the Initialization List. 
It is good to always have a default constructor for a given class along with other parameterized constructors. 

*/
class Infotainment{ 
	string name;
public:
	Infotainment() :name("") {

	}
	Infotainment(string name) : name(name){
		//this->name = name;
	}
	void play() {
		cout << "The Infotainment " << name << " is playing music\n";
	}
};

class Car {
	string name;
	Infotainment device;
public:
	Car(string name, Infotainment info) : device("") {
		this->name = name;
		device = info;
	}

	void Run() {
		device.play();
		cout << "Car is in Run Mode, Drive safely\n";
	}
};

int main() {
	Infotainment entertainment("Sony");
	Car car("HONDA WRV", entertainment);
	car.Run();
}