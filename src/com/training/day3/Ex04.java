package com.training;
//final classes and final methods...
public class Ex04 {

	public static void main(String[] args) {
		Fruit f = new Fruit();
		f.fruitName();
		
		

	}

}
//final classes are sealed classes where there are not allowed to be extended to another class. it is an exact opposite of Abstract classes. 
final class Fruit{
	void fruitName(){
		System.out.println("FruitName: Apple");
	}
}

class SummerFruit {
	void fruitName() {
		System.out.println("FruitName: Mango");
	}
}
//Assigment: There is final methods. Show me an example on using final methods.
