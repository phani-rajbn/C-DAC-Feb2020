package com.training.day7;

import com.training.day4.MyConsole;

//Multi Threading feature in java
/*NOTES:
 * What is a Process?: A process is an instance of an Application. Each process has its own address space where UR code, classes, environments, libraries and things that are requried to run a program will be loaded and executed. 
 * What is a Thread? Thread is the path of execution within a process. Every process must have at least one thread thro which the execution happens. If that thread gets terminated, UR process also gets terminated. The Thread that is created automatically when the process begins is called Main Thread. It is also UI Thread.
 * Every thread will have a function to execute. This is called as Thread function. For the main thread, the main function is the thread function. If the main ends, the thread execution stops and terminates, hense killing the process itself. 
 * Most of the Apps are OK with the UI thread doing the job of the application.  
 * Some apps would expect some functions to be invoked asynchronously. To achieve that, every technology would provide Apis to create new threads and each thread is designed to be invoked in its own path of execution, there fore UR code will run parallelly with the main thread.
 * Multi Threading is a feature of the OS and the programming languages like CPP, Java will create APIs to create and work with them. The languages with their frameworks will provide apis to abstract the complexity of creating these low level kernel objects and manage them.   
 * In Java a thread is an instance of a Thread Class.  A Thread Class could be any one which would either extend the base Thread class or implement a functional interface called RUNNABLE. 
 * In a given life cycle of a thread, it has 4 stages: Instantiation, Starting Process, Execution(Running process) and finally the Termination process. 
 * Technically only Runnable objects can run a thread. Runnable objects are those which belong to a class that either implements Runnable or extends Thread class. 
 * Once the thread runs, it will be very quick based on the Speed of UR processor and other hardware configs. Sometimes U wish to pause the thread for a given period of time, this can be done using a sleep method. Sleep is a static fn that makes the thread wait for a timed period. 
 * However U could suspend a thread infinitely or till the thread is again resumed. 
 * Most of the time, main thread will create other threads. In this scenario, the main thread is called as parent thread and the created thread is called as child thread or worker thread. 
 * In java, the main thread will wait for the worker thread to complete its tasks and then the main thread will terminate.  however U can make a thread a daemon thread where in this case, the main thread will not wait for the worker thread to complete. If the main thread has completed the task, it simply waits for the non-daemon threads and after of them have returned, the main thread will terminate. If there are any deamon threads that are still doing the job, the main would not wait for them , and the app will terminate.
 * Every thread is associated with a function that defines the functionality of this thread when it executes. These functions can take object as its arg. There will be only one arg. Object is the universal data type of Java, so U could pass any kind of data in the boxed format to it. The code however will unbox the data and perform the required operation.  
 * */
public class Ex01 {
	static final int size = 10;
	static void testFunc() throws InterruptedException {		
		for (int i = 0; i < size; i++) {
			MyConsole.print("Thread Function with beep #:" + i);
			Thread.sleep(1000);
		}
	}
	static void usingThreadClass() {
		MyCustomThread th = new MyCustomThread();
		th.start();
	}
	
	static void usingRunnableInterface() {
		RunnableClass cls = new RunnableClass();//U create an object of the class that implements the interface. 
		Thread th = new Thread(cls);//Pass that object into the constructor of the Thread class.
		th.start();//Thro the thread class, call its start method....
	}

	//When using Lambda, U will not create a new class, rather the implementation of the only function will be done using anonymous method....
	static void usingLambdaExpression() {
		Runnable runFunc = () ->{
			try {
				for (int i = 0; i < 10; i++) {
					MyConsole.print("Lambda Thread Function with beep #:" + i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Thread th = new Thread(runFunc);
		th.start();
	}
	static void usingMultipleThreads() {
		//MyCustomThread th = new MyCustomThread();
		RunnableClass cls = new RunnableClass();
		Thread th1 = new Thread(cls);
		th1.start();
		
		Thread th2 = new Thread(cls);
		th2.start();
		
		Thread th3 = new Thread(cls);
		th3.start();
		
		Thread th4 = new Thread(cls);
		th4.start();
		
	}
	public static void main(String[] args) throws InterruptedException {
		MyConsole.print("Main has started.....");
		//testFunc();//The main function will wait till the function returns. The App is in the pause mode until the function returns.
		//usingThreadClass();
		//usingRunnableInterface();
		//usingLambdaExpression();
		usingMultipleThreads();
		/*
		 * MyConsole.print("Main has continued doing some job....."); for (int i = 0; i
		 * < 5; i++) { Thread.sleep(1000);
		 * MyConsole.print("Main Thread Function with beep #:" + i); }
		 * MyConsole.print("Main has completed its job, now terminating!!!!!");
		 */
	} 
}

//UR Thread Class.....
class MyCustomThread extends Thread{
	//Any class that extends the Thread class must override a function called run. run function defines the functionality of the thread when it runs....
	@Override
	public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					MyConsole.print("Thread Function with beep #:" + i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

class RunnableClass implements Runnable{

	@Override
	public void run() {
		synchronized (this) {
			try {
				for (int i = 0; i < 10; i++) {
					MyConsole.print("Runnable Thread Function with beep #:" + i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//synchronized block will create a MUTEX object which means that if one thread or resource is consuming a data, any other thread has to wait till the holding thread completes its operations and switches the key to the next thread. 
		
	}
	
}
















