#include "CommonFunctions.h"

int getIDOfuser() {
	int no = getNumber("Enter the ID of the user");
	if (no > 10)
		throw "Too big to store as ID";
	else if (no < 5)
		throw "Not possible as Ids upto 5 are board members";
	print("The current iD given is ");
	return no;
}
int main() {
	RETRY:
	try {
		int id = getIDOfuser();
		cout << "The ID Entered by the User is " << id << endl;
	}
	catch (const char* msg) {
		cout << msg << endl;
		goto RETRY;
	}
}