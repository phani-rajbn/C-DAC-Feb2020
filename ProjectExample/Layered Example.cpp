/*Single Responsibility Principle: The Layered Application development is what is 
called as the implementation of Single Responsibility principle. A Class should 
perform only one task or should be a part of an Application. It is more designed like 
divide and rule policy. 
In an App, U will have Classes that interacts with data storage, Classes that enforce
business rules, Classes that represent the entities, Classes that interact with the 
User. U will also have utility classes. 

Entity classes are those classes that are created to represent real world entities. Entities are
representation of real world stake holders of the Application. In a banking app, customer, 
employee, account, transaction, branch are some of the entity classes. They usually hold the data
and have small functions to manipulate them. 

Repository Classes are classes based on Repository pattern that will hold data in the form of
collection and will have functions to add, remove, update and delete the data that represents it. 
These classes are created to perform the CRUD operations on any kind of data source(File, DB, 
Memory etc.)
*/
#include "CommonFunctions.h"

class Book{
	private:
		int bookId;
		string bookTitle;
		string bookAuthor;
		double bookPrice;
	public:
		void print(){
			cout<<"The Title: "<<bookTitle<<"\n";
			cout<<"The Author: "<<bookAuthor<<endl;
			cout<<"The Cost: "<<bookPrice<<endl;	
		}
		/*
		  Constructor is a function that is used to create an object as per our requirement. 
		  In other words, U will be injecting the dependencies  required for the object to be
		  successfully useable. 
		  Constructor has the syntax of a function with no return type. Not even void. 
		  It will have the same name of the class with parenthesis. It can have args if required. 
		  U can create multiple constructors with different arguements.    
		*/
		Book(){
			//Default Constructor...
		}
		
		Book(int id, string title, string author, double price){
			bookId = id;
			bookTitle = title;
			bookAuthor = author;
			bookPrice = price;
		}
		
		string getTitle(){
			return bookTitle;
		}
		
		int getBookId(){ 
			return bookId;
		}
		
		string getAuthor(){
			return bookAuthor;
		}
		
		double getBookPrice(){
			return bookPrice;
		}						
};

class BookStore{
	private: 
	  Book* books;
	  int bookCount;
	public:
		BookStore(int size){
			books = new Book[size];
			bookCount = size;
		}
		void AddNewBook(Book book);
		void UpdateBook(Book book);
		Book* FindBook(int id);//Method overloading is a feature in OOP where u could create 2 
		//or more functions with same name but different in arg List if their intention is same. 
		Book* FindBook(string author);
		//add the new feature of deleting a book given an id....
};

void BookStore::AddNewBook(Book book){
   	for(int i =0; i < bookCount; i++ ){
   		if(books[i].getTitle() == ""){
   			books[i] = book;//U have set the details of the passed arg into the array....
			return;   	
		}else continue;	
	}
}

void BookStore::UpdateBook(Book bk){
	for(int i =0; i < bookCount;i++){
		if(books[i].getBookId() == bk.getBookId()){
			books[i] = bk;
			return;
		}else continue;
	}	
}


Book* BookStore::FindBook(string name){
	
}

Book* BookStore::FindBook(int id){
	for(int i =0; i < bookCount; i++){
		if(books[i].getBookId() == id){
			return &books[i];
		}
	}
}
BookStore* app;
string getMenu(){
	string menu ="~~~~~~~~~~Book Store app~~~~~~~~~~~\n";
	menu += "TO ADD NEW BOOK--------------->PRESS 1\n";
	menu += "TO FIND BOOK BY ID------------>PRESS 2\n";
	menu += "TO FIND BOOK By AUTHOR-------->PRESS 3\n";
	menu += "TO UPDATE BOOK---------------->PRESS 4\n";
	menu += "PS: PRESSING ANY KEY IS CONSIDERED AS EXIT\n";
	return menu;
}
void addBookOperation(){
	int id = getNumber("Enter the book ID");
	string name = getString("Enter the book name");
	string author = getString("Enter the Author");
	double price = getDouble("Enter the price");
	Book bk(id, name, author, price);
	app->AddNewBook(bk);
}
bool processMenu(int choice){
	switch(choice){
		case 1:
			addBookOperation();
			return true;
		case 2:					
		case 3:
		case 4:
			return true;
	}
	return false;
}

int main(){
	int size = getNumber("Please enter the no of books with ur store");
	app = new BookStore(size);
	bool processing = true;
	do{
		string menu = getMenu();
		int choice = getNumber(menu);
		processing = processMenu(choice);
	}while(processing);
	
}
