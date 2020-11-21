package com.training.day4;

abstract class Account{
	abstract void setDetails();
}
public class Ex07 {

	public static void main(String[] args) {
		final int id =0;
		final String name = "";
		Account sbAccount = new Account() {

			@Override
			void setDetails() {
				//id = 123;
				//name = "Phaniraj";				
			}
			
		};
		sbAccount.setDetails();

	}

}
