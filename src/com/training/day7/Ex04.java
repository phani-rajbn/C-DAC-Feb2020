package com.training.day7;

//Strings are immutable. Once created, U cannot change it.
//Mutabe strings : StringBuilder and StringBuffer 
/*
 *STringBuilder represents Mutable strings. In this case, the string object will be appended, deleted or modified on the same string instead of creating new strings again and again. 
 *StringBuilder and StringBuffer are almost the same except in the terms of threading. StringBuider is not synchronized but stringBuffer is synchronized and guaranteed to be safe on mulit threading apps. 
 * */
public class Ex04 {

	public static void main(String[] args) {
		//stringDemo();
		StringBuilder str =new StringBuilder("Some String");
		str.append(" appended with new data");
		str.insert(5,  "Content inserted ");
		System.out.println(str.toString());
		System.out.println("The current length: " + str.length());
		CharSequence substring = str.subSequence(10, 30);
		System.out.println(substring.toString());
	}

	private static void stringDemo() {
		int x = 123;
		String test = "Apple123";//Creates a string object and allocates memory with the data...
		test += " Mango123";//Creates a new string and pushes the data of the old string into this new one and allows the old string to be garbage collected. 
		System.out.println(test);
		test += "This is a Simple Exmple of " + x  + " is being concatinated in this demo";//use string.format....
		System.out.println(test);
	}

}
