#include "Customer.h"

int main() {
	Customer cst;
	cst.SetDetails(123,"TestName", 23434455);
	cout<<"The Name: "<<cst.GetCustomerName();
}
