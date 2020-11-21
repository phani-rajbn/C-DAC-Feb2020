package com.training.day7;

import com.training.day4.MyConsole;

//Memory management in Java. 
/*
 * Memory management here means managing the memory in the heap area. 
 * Java itself manages the memory and needs no explicit coding by the programmer. In other words, programmers dont have any statements or keywords to destroy a memory. 
 * Garbage collector is a component within the JVM which is responsible for clearing of memory that is unused or kept as null but still the memory is not lost. 
 * GC will be invoked as soon as the process starts.  GC comes in action every time an object is created or destroyed. 
 * Java does not have code to delete an object, GC will delete the object when ever it feels that the JVM does not have enough memory for any new object to be created. 
 * Programmers cannot delete the object, GC does it and programmers don't know when the actual object is destroyed. So Java does not have destructors. However, U can provide a overriden function called finalize which will be implicitly invoked when the object is destroyed...
 * GC maintains a track of all the objects that could be deleted into a queue. Frequently it runs thru' the queue and finds objects that are unreferenced, there by immediately releasing the memory of those unused objects. For every such sweep of the queue, the object which survives is said to have surpassed a Generation. We have up to 6 generations of gc processes. 
 * Programmers must not include finalize method in their class, however if U wish to explicitly invoke a function at the time of the object deletion which is done by GC, U can override the finalize method and thru' which we could write the logic of any freeing of memory. This is helpful for associative objects.: objects that are members of another class. The coders are asked to call the finalize method in the finally block of their try...catch..
 * The purpose of the finally block is to call the finalize method of the object that is created in the try block.... 
 * From Java ll, java programmers can use the Dispose pattern that is followed in C#. 
 * U could implement an interface called Disposable and have a function called Dispose in it and provide the statements for the object deletion. Dispose pattern is well supported in RxJava(Reactive Java).
 * 
 * 
 * 
 * */
public class Ex02 {

	public static void main(String[] args) throws Throwable {
		for(int i =0; i < 50 ; i++) {
			SimpleClass cls = null;
			cls = new SimpleClass(Integer.toString(i));
			cls.finalize();//invoking a explicit function..
			//System.gc();//Calling GC is more like a request, not a command. When U call this function, a separate thread is created and this thread will run thro the finalization queue to free the unused memory. This is the example of a Deamon thread in ur application... 
		}
	}

}

class SimpleClass{
	String name;
	public SimpleClass(String name) {
		this.name = name;
		MyConsole.print("Object by name " + name + " is created");
	}
	
	@Override
	protected void finalize() throws Throwable {
		MyConsole.print("Object by name " + name + " is released from memory");
	}
}
