#include<iostream>
#include<string>
using namespace std;
//This program has errors, should be resolved before executing it...
class Account {
public:
	int accNo;
	string name;
	string address;
	int balance = 0;
	virtual void credit(int amount) { balance += amount; }
	virtual void debit(int amount) { balance -= amount; }
	virtual void calculateInterest() = 0;

	Account() :balance(0) {

	}
};

class SBAccount :public Account {
public:
	SBAccount(int amount = 1000) {
		balance += amount;
	}
	virtual void calculateInterest() {
		int interest = balance * 1 / 12 * 6.5 / 100;
		credit(interest);
	}
};

class RDAccount : public Account {

};

class FDAccount : public Account {

};

Account* createAccount(string type) {
	if (type == "SB")
		return new SBAccount();
	/*else if (type == "RD")
		return new RDAccount();
	else if (type == "FD")
		return new FDAccount();*/
}

int main() {
	string type = "SB";
	Account* acc = createAccount(type);
	acc->credit(5000);
	acc->debit(200);
	acc->calculateInterest();
	cout << "The current balance: " << acc->balance;
	return 0;
}