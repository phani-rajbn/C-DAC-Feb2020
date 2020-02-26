#include<iostream>
#include<string>
using namespace std;

void SetDetails(int id, string name, long int address){
	cout<<"This is doing some job"<<endl;
}
class Customer{
	private:
		int id;
		string name;
		long int phoneNo;
		
	public:
		void SetDetails(int id, string name, long int phoneNo);
		long int GetPhoneNo(){ return phoneNo;}
		int GetCustomerID();
		string GetCustomerName();		
};
