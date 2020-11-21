package com.training;
/*
 * This is an Example for Interfaces in Java. 
 * Interfaces are pure abstract base classes like the one U saw in C++. 
 * These interfaces will have only abstract methods and no implementations in them. 
 * The class which implements this interface will guarantee that it will implement all the methods of this interface. It is more like a contract. The contract says that it will implement all the methods if it is derived(implements) the interface. 
 * */
public class Ex03 {

	public static void main(String[] args) {
		//Assignment: Try to create a INteractive Console program that uses the object of the StudentDataCOmponent to perform operations in a Menu driven program. 
	}

}
/*
 * When a method is created in an interface, compiler will add public and abstract keyword to that method unless U mention otherwise. 
 * From Java 8 onwards, we have default interface methods where a method with a default modifier can be implemented in the interface itself and can be used in the application. Ex in Test.java
 * interfaces support multiple implementation in the same level. a Class can implement 2 interfaces at the same level. Ex in Test.java.
 * Since Java 8, we have static methods in Interface. It means that U can add a static method in an interface in Java and U could implement those methods. As these methods are not associated with any instance, U will not extend it or expect to be implemented by the implementor class, rather U only must be implementing those methods
 * An interface with only one method is called Functional interface. This interface and its method can be implemented thro nested objects. This can be done using new operator or using ()-> operator called Lambda Expression. 
 * */
interface DataComponent{
	void addStudent(int id, String name, String address, long phoneNo);
	void updateDetails(int id, String name, String address, long phoneNo);
	void deleteStudent(int id);
	Student[] getAllStudents();//U can return an array in java..
	
}

//implements is the one that tells whether U R extending an interface or the class. For class its extends and for interfaces it is implements. 
class StudentDataComponent implements DataComponent{
	Student [] students;
	public StudentDataComponent(int size) {
		students = new Student[size];//Array of students whose element value are default: null for reference types..
	}

	@Override
	public void addStudent(int id, String name, String address, long phoneNo) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i] = new Student(id, name, address, phoneNo);
				return;
			}
		}
	}

	@Override
	public void updateDetails(int id, String name, String address, long phoneNo) {
		for(int i = 0; i < students.length; i++) {
			if((students[i] != null) && (students[i].id == id)) {
				students[i].address = address;
				students[i].name = name;
				students[i].phoneNo = phoneNo;
				return;
			}
		}
	}

	@Override
	public void deleteStudent(int id) {
		for(int i =0 ; i < students.length;i++) {
			if((students[i] != null) && (students[i].id == id)) {
				//there is not way to explicitly delete an object in Java....
				students[i] = null;//Marking it null, makes this index vacant to allow student be added later...
				return;				
			}
		}		
	}

	@Override
	public Student[] getAllStudents() {
		return students;//This array might contain some locations in the array as null.....
	}

	
	
}
class Student{
	int id;
	String name, address;
	long phoneNo;	
	
	Student(int id, String name, String address, long phone){
		this.id = id; this.name = name; this.phoneNo = phone; this.address = address;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("The Name : %s\nThe Address: %s\nThe Phone: %d\n", name, address, phoneNo);
	}
	
}