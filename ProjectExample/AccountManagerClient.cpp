#include"AccountManager.h"
#include"CommonFunctions.h"

AccountManager mgr;//global object....

string createMenu(){
	string menu = "~~~~~~~~~~~~~~~~~~CDAC BANK MANAGER SOFTWARE~~~~~~~~~~~\n";
	menu += "TO ADD NEW ACCOUNT------------------------->PRESS 1\n";
	menu += "TO UPDATE ACCOUNT-------------------------->PRESS 2\n";
	menu += "TO DELETE ACCOUNT-------------------------->PRESS 3\n";
	menu += "TO FIND ACC DETAILS------------------------>PRESS 4\n";
	menu += "PS: ANY OTHER KEY ENTERED IS CONSIDERED AS EXIT!!!!\n";
	return menu;
}

void addAccountFeature(){
	//code to take inputs from the user, create the account object and pass it into the AddNewAccount func
	//take inputs from the user
	int accNo = getNumber("Enter the Account No");
	string name = getString("Enter the Account Holder Name");
	long int phoneNo = getNumber("Enter the phone no");
	double amount = getDouble("Enter the opening account Amount");
	Account acc(accNo, name, phoneNo, amount);//create the account object
	mgr.AddNewAccount(acc);
}

void updatingFeature(){
  	int accNo = getNumber("Enter the Account No to Update");
	string name = getString("Enter the Account Holder Name  to Update");
	long int phoneNo = getNumber("Enter the phone no to Update");
	Account acc(accNo, name, phoneNo);//create the account object
	mgr.UpdateAccount(acc);
}
void deletingFeature(){
}
void findingFeature(){
	
}
bool processMenu(int choice){
	switch(choice){
		case 1:
			addAccountFeature();
			return true;
		case 2:
			updatingFeature();
			return true;
		case 3:
			deletingFeature();
			return true;
		case 4:
			findingFeature();
			return true;
		default:
			return false;	
	}
}
int main(){
	
	string menu = createMenu();
	int choice = getNumber(menu);
	processMenu(choice);
}
