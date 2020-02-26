#ifndef ACCOUNT_H
#define ACCOUNT_H

#include<iostream>
#include<string>
using namespace std;

class Account
{
	private:
		int accNo;
		long int phoneNo;
		string accName;
		double accBalance;
	public:
		Account(int amount = 1000){
			
		}
		Account(int no, string name, long int phone, int amount = 1000) {
			accNo = no;
			accName = name;
			phoneNo = phone;
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
		void SetphoneNo(long int x)
		{
			phoneNo = x;
		}
		long int GetphoneNo()
		{
			return phoneNo;
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
