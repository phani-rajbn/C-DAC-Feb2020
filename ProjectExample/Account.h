#ifndef ACCOUNT_H
#define ACCOUNT_H

#include<iostream>
#include<string>
using namespace std;

class Account
{
	private:
		int accNo;
		long int phonoNo;
		string accName;
		double accBalance;
	public:
		Account(int amount = 1000) {
			accBalance = amount;
		}
		void setAccNo(int no){
			accNo = no;
		}
		
		int getAccNo(){
			return accNo;
		}
		double GetBalance(){
			return accBalance;
		}
		void SetaccName(string x)
		{
			accName = x;
		}
		string GetaccName()
		{
			return accName;
		}
		void SetphonoNo(long int x)
		{
			phonoNo = x;
		}
		long int GetphonoNo()
		{
			return phonoNo;
		}
		
		void Credit(double amount){
			accBalance += amount;
		}
		
		void Debit(double amount){
			if(amount < accBalance){
				accBalance -= amount;
			}else{
				throw "Insufficient Funds";
			} 
		}
};//Made all the functions as inline so that the code  is implemented in the header file...
 
#endif
