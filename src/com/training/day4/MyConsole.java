package com.training.day4;
import java.util.Scanner;
import java.util.Date;
//3 Streams: in(input to the program), out(output of this program), err(Error display)
public class MyConsole {
	private static Scanner sn = new Scanner(System.in);
	
	public static void print(Object data) {
		System.out.println(data);
	}
	
	public static void printError(Exception ex) {
		System.err.println("Error occured for " + ex.getClass().getName());
		if(ex.getCause() != null)
			System.err.println("System Generated message: " + ex.getCause().getMessage());
		System.err.println("Developer Generated Message: " + ex.getMessage());
		//ex.printStackTrace();//=>Gives the exception message along with the details of the line and the functions that triggered this exception.
	}
	
	
	
	public static String getString(String question) {
		print(question);
		return sn.nextLine();//Returns the scanned data from the Console entered by the user as string. 
	}
	
	public static int getNumber(String question) {
		return Integer.parseInt(getString(question));
	}
	
	public static double getDouble(String question) {
		return Double.parseDouble(getString(question));
	}
	
	public static Date getDate() {
		int dd = getNumber("Enter the Day of the month");
		int mm = getNumber("Enter the month of the Year as 0 to 11");
		int yr = getNumber("Enter the year as yyyy");
		return new Date(yr,mm, dd);
	}
	
	public static Date getDate(String question) {
		return new Date(getString(question));
	}
}
