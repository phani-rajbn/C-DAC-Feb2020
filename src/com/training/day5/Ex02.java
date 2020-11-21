package com.training.day5;

import java.util.*;//All the collection classes....

public class Ex02 {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("Ramnath", 650));
		students.add(new Student("Govind", 550));
		students.add(new Student("Robert", 500));
		students.add(new Student("Allen", 575));
		students.sort(new StudentComparer(Criteria.Score));//List will implicitly call the object's compare function that is implemented if the Class implements Comparable. 
		for(Student s : students)
			System.out.println(s);
	}
}

class Student implements Comparable<Student>{
	String name;
	int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s: %d", name, score);
	}

	
	 @Override public int compareTo(Student arg0) { // -1, 0, 1: -1 when the current object is less than the comparing object, 0 if they are same or equal, 1 if the current object is more than the comparing object
		 if(this.score < arg0.score) 
			 return 1; 
		 else if(this.score > arg0.score)
			 return -1; 
		 else return 0; 
	 }
	 
}

enum Criteria{
	Name, Score
}
class StudentComparer implements Comparator<Student>{

	private Criteria condition;
	
	public StudentComparer(Criteria condition) {
		this.condition = condition;
	}
	@Override
	public int compare(Student arg0, Student arg1) {
		switch(condition) {
			case Name:
				return arg0.name.compareTo(arg1.name);
			case Score:
				return Integer.compare(arg0.score, arg1.score);
			}
		return 0;
	}
}
/*
 * An ability to compare itself with another object is done by implementing an interface Comparable(One comparison). 
 * An ability to compare 2 objects is done by implementing an interface called Comparator(Multiple conditional Comparison).  
 * */


























