//AnotherExampleOfClass
#include"..\Customer.h"
#include"CommonFunctions.h"

//When U implement methods of a given class, U could implement the method outside
//the class using :: (Scope Resolution Operator)
void Customer::SetDetails(int cid, string cname, long int cphoneNo){
  id = cid;
  name = cname;
  phoneNo = cphoneNo;
}


int Customer::GetCustomerID(){
	return id;
}

string Customer::GetCustomerName(){
	return name;
}


