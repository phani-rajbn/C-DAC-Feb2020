#include<iostream>
#include<string>
#include<ctime>
using namespace std;
//
//string myto_string(int no) {
//	char strContent[40];
//	sprintf_s(strContent, "%d", no);
//	return strContent;
//}
//
//string myto_string(double no) {
//	char strContent[40];
//	sprintf_s(strContent, "%fd", no);
//	return strContent;
//}



string getDate() {
	time_t now = time(0);
	/*
	tm* tm;
	tm = localtime(&now);
	*/
	tm tm;

	localtime_s(&tm, &now);
	string value = "";
	int dd = tm.tm_mday;
	int mm = tm.tm_mon;
	int yy = 1900 + tm.tm_year;
	string append = mm < 10 ? "0" : "";
	value = to_string(dd) + "/" + append + to_string(mm) + "/" + to_string(yy);
	return value;

}



int main() {
	cout<<getDate()<<"\n";
	time_t now = time(0);
	char strContent[200];
	ctime_s(strContent, 200, &now);
	cout << strContent<< endl;//C style date and Time function....
}