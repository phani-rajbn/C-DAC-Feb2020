package com.training.day4;

import java.util.*;//All the classes of the JCF will be made available...

import com.training.day4.MyConsole;

/*
 *Collections is a framework in Java to provide dynamic arrays and data structures to manage the data of the application. 
 *It can store and perform various operations like searching, sorting, inserting, deleting and manipulating. 
 *The Framework has many interfaces and ready to use classes on which U could perform the above operations. 
 *A Collection in Java is like a group upon which I can perform an operation on all the elements of that group thro a simple iteration.
 *List: Representing data in the form of a List where items could be added anywhere within it and perform iterations and other things. 
 *Queue: Represent data as a container that maintains data in the First-In-First-Out order. This interface is implemented by few classes like PriorityQueue. 
 *Set: Used to behave like List, but will store only unique data in it. It uses the hashCode and equals methods of the object to determine the uniqueness and equality of the object before it inserts into the collection. We have improvised Set called as SortedSet which is implemented in a class TreeSet. 
 *Map: Maintains data as Dictionaries where the data is stored like Associative arrays of PHP. 
 *
 * */

class Employee{
	int empId;
	String empName;
	String empAddress;
	
	public Employee(int id, String name, String address) {
		empId = id;
		empName = name;
		empAddress = address;
	}
	@Override
	public int hashCode() {
		return Integer.hashCode(empId);
	}
	
	@Override
	public String toString() {
		return String.format("The name: %s\nThe Address:%s\nThe ID:%d\n",empName, empAddress, empId);
	}
	//If 2 objects hashcode are same, then the Set will look to the equals method and its logic of object equivalence...
	@Override
	public boolean equals(Object obj) {
		//first check if the obj is of the type Employee...
		if(obj instanceof Employee) { //checks the type of the object...
			Employee temp = (Employee)obj;
			return this.empId == temp.empId;
		}
		return false;
	}
}
public class Ex08 {

	public static void main(String[] args) {
		//ArrayListExample();
		//hashSetExample();
		//hashSetOnObjects();
		//hashMapExample();
		queueExample();
	}

	private static void queueExample() {
		//Queue is an interface in Java Collections to store the data in the form of First-In First-Out basis. 
		//LinkedList and PriorityQueue are some of the classes that implement Queue.
		//LinkedList implements both List and Queue...
		Queue<String> flipKart = new LinkedList<String>();
		String input = "Y";
		do {
			if(flipKart.size() == 3)
				flipKart.remove();
			flipKart.add(MyConsole.getString("Enter the Item to view"));
			System.out.println("UR Recently viewed Items: ");
			for(String item : flipKart)
				System.out.println(item.toUpperCase());
			input = MyConsole.getString("Do U want to view other items?");
		} while (input.toUpperCase().equals("Y"));//equals will be used to check for reference types...
	}

	private static void hashMapExample() {
		//Map is a data structure to store data in the form of key-value pairs. In this collection, the key part will be unique and the value part may not be unique to the collection.  It is also called as Dictionary. 
		//U could use key to extract the value associated with the key in a map. Key almost behaves like an index of an array...
		//While working with Map, the key should be a reference type, it should not include primitive types:
		/*
		 * Map<String, Employee> employees = new HashMap<String, Employee>();
		 * employees.put("Phaniraj", new Employee(123, "Phaniraj", "Bangalore"));
		 * employees.put("Vinod", new Employee(123, "Vinod", "Bangalore"));
		 * employees.put("JoyDip", new Employee(123, "JoyDip", "Bangalore"));
		 * employees.put("Ram", new Employee(123, "Ram", "Bangalore"));
		 * System.out.println("The total team with us: " + employees.size());
		 * for(Map.Entry<String, Employee> emp : employees.entrySet()) {
		 * System.out.println(emp.getKey() + "= " + emp.getValue()); }
		 */
		Map<Integer, String> players = new HashMap<Integer, String>();
		players.put(10, "Sachin");
		players.put(19, "Rahul");
		players.put(1, "Sourav");
		players.put(4, "Kumble");
		players.put(5, "Sehwag");
		
		for(Map.Entry<Integer, String> player : players.entrySet())
			System.out.println(String.format("Player: %d, \t Name: %s", player.getKey(), player.getValue()));
	}

	private static void hashSetOnObjects() {
		/*
		 * If 2 objects hashcode is same, it does not mean they are equal, it only means that they belong to the same type. 
		 * SET will check for equals method only after the hashcodes of the comparing objects are same. 
		 * U must override both the hashcode as well as equals method to provide the logic of object equivalence to determine whether 2 objects are same or not.  
		 * */
		Set<Employee> empList = new HashSet<Employee>();
		empList.add(new Employee(123, "Phaniraj", "Bangalore"));
		empList.add(new Employee(124, "Gopal", "Bangalore"));
		empList.add(new Employee(125, "Binu", "Bangalore"));
		empList.add(new Employee(124, "Gopal", "Bangalore"));
		empList.add(new Employee(125, "Binu", "Bangalore"));
		System.out.println("The no of employees: " + empList.size());
		for(Employee emp : empList)
			System.out.println(emp.hashCode());
	}

	private static void hashSetExample() {
		//Set is similar to List, but does not allow duplicates within its collection. duplicates can be checked if the add method returns false. 
		Set<String> empNames = new HashSet<String>();
		System.out.println(empNames.add("Robert"));
		System.out.println(empNames.add("Luios"));
		System.out.println(empNames.add("Tom"));
		System.out.println(empNames.add("Harry"));
		System.out.println(empNames.add("Luios"));
		System.out.println(empNames.add("Tom"));
		System.out.println(empNames.add("Luios"));
		System.out.println(empNames.add("Tom"));
		System.out.println(empNames.add("Luios"));
		System.out.println(empNames.add("Tom"));
		System.out.println(empNames.add("Luios"));
		System.out.println(empNames.add("Tom"));
		System.out.println("The Emp Count: " + empNames.size());
		for(String name : empNames) System.out.println(name);
		
	}

	//The most simpliest and easiest way of collection usage: ArrayList is like array but has ability to add, remove, search ....
	private static void ArrayListExample() {
		/*
		 * Works like Array: elements will be added to the bottom of the list. However U could insert the elements in between also. 
		 * It will not check for duplicates. 
		 * */
		List<String> fruits = new ArrayList<String>();
		fruits.add("Apple");//It ensures that only string data can be added to it. Generic version is typesafe and easy to work with....
		fruits.add("Mango");
		fruits.add("Orange");//add adds the item to the bottom of the list....
		for(String item : fruits) System.out.println(item);
		//if(!fruits.remove("Oranges")) System.out.println("Oranges do not exist in the basket");
		String fruitThatHasBeenRemoved = fruits.remove(2);
		System.out.println("After removing.....");
		for(String item : fruits) System.out.println(item);
		System.out.println("The removed fruit: " + fruitThatHasBeenRemoved);
	}

}
