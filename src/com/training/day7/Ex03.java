package com.training.day7;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import com.training.day4.MyConsole;

//Reflection:
/*
 * Reflection is a feature of identifying an object at runtime and get its information like its members and its details by reading the metadata of the object. It is similar to RTTI feature in C++.
 * We may need to know about the object at runtime and perform operations on it. This is done thru' Late binding. U obtain the info about a class at runtime and then create an object of it and perform operations. In this case, the object status will not be known at compile time, no intellisense from UR IDEs. java.lang.reflect is the package that contains APIs to read the metadata of the object and get its type information.  
 * All UR IDEs use reflection to get the info about the class that u create...
 * The concept is to reflect the types of UR program and so that U can use these objects to invoke the operations, hense the name REFLECTION...
 * REFLECTION allows to create objects dynamically using Runtime type identification and based on the object and its metadata. 
 * */

public class Ex03 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		Map<String, Integer> functions = new HashMap<String, Integer>();
		/*Class.forName is a function that is used to get the Class Object of the string*/
		Class<?> clsDetails = Class.forName("com.training.day7.MathClass");//U R getting the info about the class named MathClass defined in the package. Class is a name of the class defined in System.lang.reflect that represents the metadata of the given class..
		if(clsDetails == null) {
			MyConsole.print("No Class details found for the mentioned class");
			return;
		}
		MyConsole.print("The name of the class is " + clsDetails.getClass().getName());
		Method[] allMethods = clsDetails.getMethods(); 
		for(Method m : allMethods) {
			MyConsole.print(m.getName());
			Parameter[] pms = m.getParameters();
			for(Parameter p : pms) {
				MyConsole.print(String.format("Name: %s\n Data Type: %s\n", p.getName(), p.getType().getName()));
			}
		}
		String method = MyConsole.getString("Enter the method name to invoke");
		Class [] allParameters = new Class[2];//2 parameters..
		allParameters[0] = double.class;//Gives the class object of the double....
		allParameters[1] = double.class;

		Method selectedMethod = clsDetails.getMethod(method, allParameters);
		if(selectedMethod == null) {
			MyConsole.print("Not a valid method");
			return;
		}
		
		Object instance = clsDetails.newInstance();//another way of creating object in java....
		Object[] values = new Object[2];
		for(int i =0; i < 2; i++) {
			values[i] = MyConsole.getDouble("Enter the value for input");
		}
		Object result = selectedMethod.invoke(instance, values[0], values[1]);
		MyConsole.print(result);
	}
}
//Using the Reflection APIs, we will read the info about this class and perform operations based on the user interaction...
class MathClass{
	public double addFunc(double v1, double v2) {
		return v1 + v2;
	}
	
	public double subFunc(double v1, double v2) {
		return v1 - v2;
	}
}
