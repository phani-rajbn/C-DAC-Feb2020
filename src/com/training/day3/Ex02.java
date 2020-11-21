package com.training;
//Abstract classes in Java:
/*
 * Abstract classes are those classes that have atleast one abstract method in it. 
 * Abstract methods don't have a body. They are only declared and expected to be implemented by the derived classes,
 * As the class U create as abstract has one or more methods that are not implemented, this class is incomplete, and hence not fit to be instantiated. Abstract classes cannot be instantiated. However using RTP, U could create an object of the Abstract class and instantiate it to the derived class and call its methods. 
 * Abstract classes can have normal methods. It can also have static methods. 
 * */
public class Ex02 {

	public static void main(String[] args) {
		BankAccount acc = new SBAccount();
		acc.Credit(4500);
		acc.calculateInterest();
		System.out.println("The current balance is " + acc.getBalance());		
	}

}

abstract class BankAccount{
	protected int balance;
	int accNo;
	String holderName;
	
	public BankAccount(int amount) {
		this.balance = amount;
	}
	
	void Credit(int money) { this.balance += money;}
	
	void Debit(int money) {
		if(balance >= money) balance -= money; 
	}
	
	int getBalance () { return balance;}
	
	abstract void calculateInterest();
}


class SBAccount extends BankAccount{
	double rateOfInterest = 6.0;
	double quarter = 0.025;//Quarterly interest...
	public SBAccount() {
		super(5000);//super is a keyword used to refer the immediate base class of the current one...
	}
	
	//override the method....
	
	void calculateInterest() {
		double interest = this.balance * rateOfInterest * quarter;
		this.balance += interest;
	}
	
}


























