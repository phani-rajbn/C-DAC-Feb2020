package com.training.day5;
//java.io: 

import java.io.*;
import com.training.day4.MyConsole;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//basicIOOperation();
		//fileIOOperation();
		//BufferedStreamExample();
	}
	
	

private static void fileIOOperation() {
		try {
			fileReading();
			//fileWriting();
		} catch (IOException e) {
			MyConsole.printError(e);
		} 
		
	}
	private static void fileWriting() throws IOException{
		FileWriter writer = new FileWriter("SampleExample.txt", true);//true appends the file if it already exists...
		int id = MyConsole.getNumber("Enter the ID of the Book");
		String title = MyConsole.getString("Enter the Title of the book");
		int price = MyConsole.getNumber("Enter the price of the book");
		String author = MyConsole.getString("Enter the name of the Author");
		Book bk = new Book(id, title, author, price);
		writer.write(bk.toString()+ "\n");
		writer.close();
	
}
	private static void fileReading() throws IOException {
		FileReader fr;
		fr = new FileReader("SampleExample.txt");
		int index =0; 
		while((index = fr.read()) != -1) {
			System.out.print((char)index);
		}
		fr.close();		
	}
//09945205684: 

	private static void basicIOOperation() {
		System.out.println("Simple Message on the std output device(Console)");
		System.err.println("Error Messages are displayed with red fontcolor");
		int accValue =0;
		try {
			accValue = System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Reads only one charecter and returns an Ascii value of that charecter...
		System.out.println(String.format("The Ascii value: %d \nThe Char value: %s", accValue, (char)accValue));
		
	}
}
/*
 * Java IO is used to perform all kinds of IO operations on storage devices like files, Streams, memory, and even databases. Java uses Streams to perform IO operations. 
 * Stream is a sequence of data(bytes) that flows from a source to its destination. Streams comprise of bytes. As everything of the streams are of bytes, so reading and writing from or to any source of any kind could be same. Reading a text file and Reading a Image file will be almost the same. But the image files are huge, so we call them as BLOB(Binary Large Objects). 
 * Java gives 3 Streams: in(System.in), out(System.out), err(System.err).
 * For basic operations, U could use these streams to perform operations. 
 * To display on the default output device: System.out and perform printing operation. 
 * To take input U could use System.in and take inputs to Ur application.
 * Anything that goes out of Ur app is called output, and anything that comes to ur app is called input.
 * The classes of the IO are available under a package called java.io.
 * Most of the streams are derived from 2 abstract classes: InputStream and OutputStream. 
 * For each kind of IO operation, we have a pair of classes, one for input and other for output. 
 * InputStream->FileInputStream, BufferedInputStream, ObjectInputStream, DataInputStream.....
 * OutputStream->Similar output counterparts.... 
 * When a stream is created,, it must be opened, worked and finally close...    
 * */

















