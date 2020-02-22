#include "AccountManager.h"

AccountManager::AccountManager()
{
}

//Implementing the function of a class outside it using :: operator.
void AccountManager::AddNewAccount(Account acc){
	for(int i = 0; i < Count; i++){
		if(accounts[i].GetaccName() == ""){
			accounts[i] = acc;
			return;
		}
	}
} 

void AccountManager::UpdateAccount(Account acc){
	//iterate thro the collection
	for(int i =0; i < Count; i++){
		if(accounts[i].getAccNo() == acc.getAccNo()){//find the first occurance of that acc which matches the id of the acc passec as arg
			accounts[i]= acc;//set the new values
			return;//exit the funtion as we dont want to continue iterating further...
		}
	}	
}

void AccountManager::DeleteAccount(int accNo){
	for(int i =0; i < Count; i++){
		if(accounts[i].getAccNo() == accNo){//find the first occurance of that acc which matches the id of the acc passec as arg
			accounts[i].setAccNo(0);//set the new values
			accounts[i].SetaccName("");
			accounts[i].SetphonoNo(0);
			accounts[i].Debit(accounts[i].GetBalance());//make the balance as 0..
			return;//exit the funtion as we dont want to continue iterating further...
		}
	}
}

Account AccountManager::FindAccount(int accNo){
	for(int i =0; i < Count; i++){
		if(accounts[i].getAccNo() == accNo){//find the first occurance of that acc which matches the id of the acc passec as arg
			return accounts[i];//exit the funtion as we dont want to continue iterating further...
		}
	}
}

