#ifndef ACCOUNTMANAGER_H
#define ACCOUNTMANAGER_H
#include "Account.h"
#define Count 10

/*
This class will contain the collection of accounts on which CRUD operations are 
conducted. This will have functions to add, remove, update and reads(find) Accounts.
The data of accounts will be stored as an array.... 
*/
class AccountManager
{
	private:
		Account accounts[Count];
		bool IsValidNo(int no){
			return true;
		}
	public:
		AccountManager();
		void AddNewAccount(Account acc);
		void DeleteAccount(int accNo);
		void UpdateAccount(Account acc);
		Account FindAccount(int accNo);
	protected:
};

#endif
