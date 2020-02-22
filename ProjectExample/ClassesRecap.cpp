//classes Examples
//create a class called Account: accNo, holderName, phoneNo, balance;
#include"Account.h"
#include"CommonFunctions.h"

Account* pAccount;
/*
Advantages of using a pointer object:
Using one pointer object, we could create many no of instances.
U create a pointer variable and instantiate it later. This will be helpful when U
want to create global object and wish to use it across all the functions. 
*/

void createObject(){
	pAccount = new Account();
	pAccount->setAccNo(getNumber("Enter the Account No"));
	pAccount->SetaccName(getString("Enter the Account holder name"));
	pAccount->SetphonoNo(getNumber("Enter the Contact details"));
}

void displayObject(){
	cout<<"The Name of the Account Holder: " <<pAccount->GetaccName();
	cout<<"\nThe Contact phone No: "<<pAccount->GetphonoNo();
	cout<<"\nThe Current Balance: "<<pAccount->GetBalance();	
}

Account createNewAccount(){
	//take inputs from the user
	int accNo = getNumber("Enter the Account No");
	string name = getString("Enter the Account Holder Name");
	long int phoneNo = getNumber("Enter the phone no");
	double amount = getDouble("Enter the opening account Amount");
	Account acc(amount);//create the account object
	//set the values
	acc.SetaccName(name);
	acc.SetphonoNo(phoneNo);
	acc.setAccNo(accNo);
	return acc;
}

void displayDetails(Account acc){
	cout<<"The Name of the Account Holder: " <<acc.GetaccName();
	cout<<"\nThe Contact phone No: "<<acc.GetphonoNo();
	cout<<"\nThe Current Balance: "<<acc.GetBalance();	
}
 
void createAccount(){
	Account acc = createNewAccount();
	displayDetails(acc);
}



int main(){
   //createAccount();
   //createObject();
   //displayObject();
   
}
