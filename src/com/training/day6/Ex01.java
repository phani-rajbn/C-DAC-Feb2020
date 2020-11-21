package com.training.day6;

import java.util.*;
import java.io.*;

public class Ex01 {

	public static void main(String[] args) {
		//bufferedReadingExample();
		//bufferedWritingExample();
		//BookStore api = new FileBookStore();
		//api.deleteBook(111);
	}

	private static void bufferedWritingExample() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("SampleExample.txt", true));
			writer.write("113,The Discovery of India,J. Nehru,750,5\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static List<Book> getAllBooks(){
		List<Book> allBooks = new ArrayList<Book>();//blank list....
		String filepath = "SampleExample.txt";
		try {
			FileReader fr = new FileReader(filepath);
			BufferedReader reader = new BufferedReader(fr);
			String line = "";
			while((line = reader.readLine()) != null) {
				String [] words = line.split(",");
				int id = Integer.parseInt(words[0]);
				String title = words[1];
				String author = words[2];
				int price = Integer.parseInt(words[3]);
				Book bk = new Book(id, title, author, price);
				allBooks.add(bk);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allBooks;
	}
	
	private static void bufferedReadingExample() {
		//This is an improvised version of the filereader where the data will be buffered which is faster and has additional APIS to read the data in a quicker manner. 
		//Read each line, convert it into an object of a class defined in Java and probably put the object in a collection and return as a return value of a function
		List<Book> allBooks = getAllBooks();
		for(Book ex : allBooks)
			System.out.println(ex);
		
	}

}

class Book{
	int id;
	String title;
	String author;
	int price;
	int copies = 10;
	
	public Book(int id, String title, String author, int price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String.format("The Title: %s\nThe Author: %s\nThe Cost: %d\nThe Current Copies: %d\n\n", title, author, price, copies);
	}
	
}

interface BookStore{
	void addNewBook(Book bk);
	void updateBook(Book bk);//tells the system that this function might throw this kind of Exception......
	void deleteBook(int id) ;
	Book [] findBook(String title) ;//return multiple books....
	Book findBook(int id);//returns 1 book
}

class FileBookStore implements BookStore{

	private String filename = "SampleExample.txt";
	private List<Book> allBooks = null;
	private void getData() {
		allBooks = Ex01.getAllBooks();
	}
	
	private void storeData() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));//We are not appending the data...
			if(allBooks.size() == 0)
				return;
			for(Book bk : allBooks) {
				writer.write(String.format("%d,%s,%s,%d,%d\n", bk.id, bk.title, bk.author, bk.price, bk.copies));
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void addNewBook(Book bk) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("SampleExample.txt", true));
			writer.write(String.format("%d,%s,%s,%d,%d\n", bk.id, bk.title, bk.author, bk.price, bk.copies));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateBook(Book bk) {
		//get the records into the collection from the file..
		//find the matching book in the collection, change the values...
		//rewrite the modified collection back to the file..
		try {
			throw new Exception("Do it URself!!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteBook(int id) {
		//get the records into the collection from the file..
		getData();
		//find the matching book in the collection, delete the object...
		for (int i = 0; i < allBooks.size(); i++) {
			if(allBooks.get(i).id == id) {
				allBooks.remove(i);
				break;
			}
		}		
		//rewrite the modified collection back to the file..
		storeData();
	}

	@Override
	public Book[] findBook(String title) {
		//get the books from the file
		getData();
		List<Book> tempList = new ArrayList<Book>();
		for(Book bk : allBooks) {
			if(bk.title.contains(title))
				tempList.add(bk);
		}
		Book [] selectedBooks = new Book[tempList.size()];
		tempList.toArray(selectedBooks);
		return selectedBooks;
	}

	@Override
	public Book findBook(int id) {
		getData();
		for(Book bk : allBooks) {
			if(bk.id == id)
				return bk;
		}
		return null;//When no book is found....
	}	
}
