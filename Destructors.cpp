#include<iostream>
using namespace std;

//destructors: Sp function invoked when the object is destroyed from the memory. We create such functions to explicitly remove the memory of contained objects within the class.  
class Test {
public:
	Test() { cout << "Constructor is called\n"; }
	~Test() { cout << "object is about to be destroyed\n"; }
};

void createAndDestroyObjects() {
	Test* t;
	for (int i = 0; i < 20; i++)
	{
		t = new Test();//IN the stack....
		delete t;//Explicitly tell the object to be destroyed. Only if the object is created dynamically...
	}
}
int main() {
	createAndDestroyObjects();
	return 0;
}