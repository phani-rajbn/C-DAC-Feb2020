package com.training;

/*   **********************************Program on Default methods in interfaces, new in Java 8*********************************
 * 
 * interface X{ void testX(); default void testXInDetail() {
 * System.out.println("X is tested in detail"); } }
 * 
 * 
 * 
 * class XTester implements X{ public void testX() {
 * System.out.println("X is tested"); }
 * 
 * 
 * }
 * 
 * class YTester implements X{ public void testX() {
 * System.out.println("X is tested"); }
 * 
 * public void testXInDetail() {
 * 
 * } } public class Test {
 * 
 * public static void main(String[] args) { X test = new XTester();
 * test.testX();
 * 
 * test.testXInDetail();
 * 
 * 
 * }
 * 
 * }
 */
/****************************************Multiple inheritance thro interfaces in Java******************************************/
/*
 * interface X{ void xFunc(); } interface Y{ void yFunc(); }
 * 
 * 
 * class XY implements X, Y{ int xy = 0; public void xFunc() { xy = 123;
 * System.out.println("x Func is writing to xy");} public void yFunc() {
 * System.out.println("y Func is reading xy: " + xy);} }
 * 
 * 
 * public class Test{ public static void main(String[] args) { X x = new
 * XY();//object slicing in C++.... x.xFunc();
 * 
 * Y y = (Y) x;//type casting... as x is an object of XY and it will have the
 * Yth version in it.... y.yFunc(); } }
 */

/**************************Static methods in Java 8 Interfaces*********************************************/
/*
 * interface Simple{ static void simpleExample() {
 * System.out.println("Static methods on an interface have a body"); }
 * 
 * } public class Test{ public static void main(String[] args) {
 * Simple.simpleExample(); } }
 */

/***********************************Nested Interfaces****************************************************/
@FunctionalInterface
interface X{
	void xFunc();
}

//class XImplementor implements X{
//	public void xFunc() {
//		System.out.println("X is implemented");
//	}
//}

public class Test{
	public static void main(String[] args) {
		/*
		 * X obj = new X() {
		 * 
		 * @Override public void xFunc() { System.out.println("X is implemented");
		 * 
		 * }
		 * 
		 * }; obj.xFunc();
		 */
		
		X obj = () ->{
			System.out.println("X is implemented");
		};//lambda Expressions in Java.
		obj.xFunc();
	}
}




















