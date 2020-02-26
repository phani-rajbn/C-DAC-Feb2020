//Recap example
#include"CommonFunctions.h"

void display(int x){
	cout<<"Calling from Display method:";
	cout<<"The value is "<<x<<endl;
}
void exampleOnPointers(){
	int x = 123;
	int* ptr = &x;
	cout<<"ptr: "<<ptr<<endl;//Address
	cout<<"Address of x: "<<&x<<endl;
	cout<<"The value at this address is "<<*ptr<<endl;
	display(*ptr);
}


class Fruit{
private:
	string name;//inaccessible....
	
public:
	Fruit(){
		name = "Kashmir Apples";
	}
	
	Fruit(string fName){
		name = fName;
	}
	string getName(){
		return name;
	}	
	
	void setName(string info){
		name = info;
	}	
};
//Function we have created that takes fruit as arg....
void displayFruit(Fruit f){
	cout<<"The Fruit Name: "<<f.getName()<<endl;	
}
Fruit* f;//U only created an address but it is not pointing to anything...
//global function.....
void setFruitDetails(){
	string answer = getString("Enter the name of the fruit:");
	f = new Fruit(answer);.
	//f.setName(answer);
}


int main(){
//	exampleOnPointers();
	Fruit* basket = new Fruit("Washington Apples");
	cout<<"The Location of basket: "<<basket<<endl;
	displayFruit(*basket);
	
	basket = new Fruit("Nagpur Oranges");
	displayFruit(*basket);
	
//	Fruit apple("Ooty Apples");
//	apple.setName("Washington Apples");
//	//apple.setName("Kashmir Apples");
//	displayFruit(apple);
}
