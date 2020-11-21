package com.training.day4;

import java.text.NumberFormat;

//Exception Handling in Java
/*
 * try... catch...finally
 * finally block will be executed on all conditions. 
 * catch block will have handle the exception which is returned by the system as an object of a class derived from Exception.
 * throw and throws
 * throw keyword is used to raise an Exception. 
 * throws keyword is used in the function declaration to tell that this function might throw an Exception of that kind.
 * try must have a catch or a finally block or both. U can have multiple catch blocks within a try...  
 * */
public class Ex05 {

	public static void main(String[] args)  {
		/*
		 * try {
		 * System.out.println("Code that will run and occasionally get an Exception");
		 * throw new Exception("OOPS! Something wrong happened"); }catch(Exception ex) {
		 * System.out.println(ex.getMessage()); }finally { System.out.
		 * println("Execute on all conditons irrespective an exception occurs or not");
		 * }
		 */
		
		/*
		 * try { callMe("Trainee"); } catch (Exception e) {
		 * System.out.println(e.getMessage()); }
		 */
		
		//Common Scenaris of Java Exceptions:
		//ArithematicException
		/*
		 * try { int result = 500 / 0; System.out.println(result); } catch
		 * (ArithmeticException e) {
		 * System.out.println("Division by Zero is not allowed"); }
		 */
		//NumberFormatException:
		/*
		 * try { int result = MyConsole.getNumber("Enter a value");
		 * System.out.println("The result : " + result); } catch (NumberFormatException
		 * e) { NumberFormatException ex = new
		 * NumberFormatException("Invalid Format of a number, cannot convert");
		 * MyConsole.printError(ex); }
		 */
		
		//ArrayIndexOutOfBoundsException
		
		 try { String [] fruits = new String[4]; fruits[4] = "PineApple"; } catch
		 (ArrayIndexOutOfBoundsException e) { ArrayIndexOutOfBoundsException ex = new
		 ArrayIndexOutOfBoundsException("Index is out of the defined size in the array"
		 ); MyConsole.printError(ex); }
		 
		
		//NullPointerException....
//		try {
//			Customer cst = null;
//			MyConsole.print(String.format("This customer by name %s is from %s", cst.cstName, cst.cstAddress));
//		} catch (NullPointerException e) {
//			//NullPointerException ex = new NullPointerException("Data of the customer is not set");
//			MyProgramException ex = new MyProgramException("Data of the customer is not set", e);
//			MyConsole.printError(ex);
//		}
	}
	
	static void callMe(String name) throws Exception{
		if((name == "Trainer") || (name == "Trainee"))
			System.out.println("welcome");
		else
			throw new Exception("Not a valid person");
	}

}

class Customer{
	String cstName;
	String cstAddress;
}
