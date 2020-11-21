/**
 * 
 */
package com.training.day5;

import java.util.*;

import com.training.day4.*;

/**
 * @author phani
 *This class demonstrates the usage of custom collections in our application...
 */
//Main Program(User interface)
public class Ex01 {
	public static void main(String[] args) {
		BookStore mgr = new BookStoreManager();
		try {
			mgr.addNewBook(new Book(111, "2 States", "Chetan Bhagat", 600));
			mgr.addNewBook(new Book(112, "India's Freedom Struggle", "Manohar Lohia", 500));
			mgr.addNewBook(new Book(113, "Discovery of India", "J. Nehru", 500));
			mgr.addNewBook(new Book(114, "The Mother I never knew", "Sudha Murthy", 1600));
		} catch (BookStoreException e) {
			MyConsole.printError(e);
		}
		//UR object or UR Class does not have a functionality to iterate its internal collection....
		/*
		 * for(Book bk : mgr) System.out.println(bk.bookTitle);
		 */
		
		Iterator<Book> it = mgr.iterator();
		while(it.hasNext()) {
			MyConsole.print(it.next().bookTitle);
		}//ensures that it does not go out of bounds, it is forward only and read only. 
	}
}

/////////////////////////Entity class to represent each book/////////////////////////////////////////////////////////////////
class Book{
	int bookID;
	String bookTitle;
	String author;
	int price;
	int copies = 10;
	
	public Book(int id, String title, String author, int price) {
		bookID = id;
		bookTitle = title;
		this.author = author;
		this.price = price;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Integer.hashCode(bookID);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Book) {
			Book temp = (Book)obj;//UNBOXING in Java.
			return temp.bookID == bookID;
		}else
			return false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%d,%s,%s,%d,%d", bookID, bookTitle, author,price, copies);
	}
}

///////////////////////Custom Exception/////////////////////////////////////////////////////////////////////////////////
class BookStoreException extends Exception{
	public BookStoreException() {
		
	}
	
	public BookStoreException(String message) {
		super(message);//calling the specific base class constructor if U have multiple overloaded base class constructors.
	}
	
	//For Sys generated Exception
	public BookStoreException(String msg, Throwable cause) {
		super(msg, cause);
	}	
}

/////////////////////////////////////////////Interface for Book Storage and Management//////////////////////////////////////////////
interface BookStore extends Iterable<Book>{
	void addNewBook(Book bk) throws BookStoreException;
	void updateBook(Book bk) throws BookStoreException;//tells the system that this function might throw this kind of Exception......
	void deleteBook(int id) throws BookStoreException;
	Book [] findBook(String title) throws BookStoreException;//return multiple books....
	Book findBook(int id) throws BookStoreException;//returns 1 book
}
/////////////////////////////////////////////Class Implemention/////////////////////////////////////////////////
class BookStoreManager implements BookStore{	
	//Data Structure: Set was choosen because we wanted to have unique books in our database....
	Set<Book> allBooks;
	public BookStoreManager() {
		this.allBooks = new HashSet<Book>();
		
	}
	@Override
	public void addNewBook(Book bk) throws BookStoreException {
		if(!this.allBooks.add(bk))
			throw new BookStoreException("This book already exists");
	}
	
	@Override
	public void updateBook(Book bk) throws BookStoreException {
		Book [] array = (Book[])allBooks.toArray();
		for (int i = 0; i < allBooks.size(); i++) {
			Book selected = array[i];
			if(selected.bookID == bk.bookID) {
				selected.bookTitle = bk.bookTitle;
				selected.author = bk.author;
				selected.copies = bk.copies;
				selected.price = bk.price;
				return;
			}
		}
		throw new BookStoreException("No book with ID " + bk.bookID + " found to update");
	}
	@Override
	public void deleteBook(int id) throws BookStoreException {
		Book [] temp = (Book[])allBooks.toArray();
		for (int i = 0; i <this.allBooks.size(); i++) {
			if(temp[i].bookID == id) {
				this.allBooks.remove(temp[i]);
				return;
			}
		}
		throw new BookStoreException("Book not found to delete");
		
	}
	@Override
	public Book[] findBook(String title) throws BookStoreException {
		List<Book> foundBooks = new ArrayList<Book>();
		for(Book bk : allBooks) {
			if(bk.bookTitle.contains(title))
				foundBooks.add(bk);
		}
		return (Book[])foundBooks.toArray();
	}
	@Override
	public Book findBook(int id) throws BookStoreException {
		/*
		 * for (Book book : allBooks) { if(book.bookID == id) return book; }
		 */
		Iterator<Book> it = allBooks.iterator();
		while(it.hasNext()) {
			Book temp = it.next();
			if(temp.bookID == id) {
				return temp;
			}
		}
			
		throw new BookStoreException("Book not found to show");
	}
	@Override
	public Iterator<Book> iterator() {
		return allBooks.iterator(); 
	}
}

/*POINTS:
 * A Collection Class is one whose object can be used in a foreach statement(Iterating feature). 
 * All Collection Classes and interfaces implement an interface called Iterable. 
 * Iterable has only one method called iterator which returns an Iterator interface object.
 * The Iterator interface object has methods like: hasNext():checks for the next element in the collection, next(): moves to the next element and returns the reference of it.
 * foreach interally does call next while it iterates the collection and U will access the current object refered by a variable before the : 
 * Iterable vs Iterator...
 * */
































