#include"AccountManager.h"
int main(){
	AccountManager mgr;//create the object.....
	Account acc;
	acc.setAccNo(123);
	acc.SetaccName("Phaniraj");
	acc.SetphonoNo(23445456);
	mgr.AddNewAccount(acc);
	
	Account acc2;
	acc2.setAccNo(124);
	acc2.SetaccName("Banu Prakash");
	acc2.SetphonoNo(22331123);
	mgr.AddNewAccount(acc2);
	
	Account acc3;
	acc3.setAccNo(124);
	acc3.SetaccName("Gopal");
	acc3.SetphonoNo(554345);
	mgr.AddNewAccount(acc3);
	
	Account acc4;
	acc4.setAccNo(125);
	acc4.SetaccName("Anand");
	acc4.SetphonoNo(654366);
	mgr.AddNewAccount(acc4);
	
	acc = mgr.FindAccount(125);
	cout<<acc.GetaccName();
	
}
