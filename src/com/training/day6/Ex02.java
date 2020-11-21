package com.training.day6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

//Serialization:
/*Serialization is a mechanism of converting an object to a bytestream and can be stored into a file.  The bytestream can be read from another application if it is in the same Filesystem. The bytestream is a non appendable data stream where U can store the whole state of the object and retrieve the object back to the same state from which it was saved. 
 * Saving the data into the bytestream is called Serialization and retriving the data from the Bytestream is called Deserialization. 
 * Saving of the bytestream could be done to a file, memory, pipes, serial ports, sockets and many more. our example stores to a file. 
 * 3 Steps of serialization:
 * What to serialize: The objects of a class that implements an interface called Serializable
 * format of serialization: ByteStream. however U could use XML also
 * Where to serialize: File, memory, pipe....
 * When serialization happens, the whole state of the object, type info, metadata and its package info will also be stored. If U want an object to be put into some kind of storage state, and U wish to bring it back to the same state since it was stored: then serialization is the way for it. 
 * The main problem with serialization, data of the file can easily be corrupted. So for better state management, we go for database programming. JDBC..
 * */
public class Ex02 {

	public static void main(String[] args) {
		Patient p = new Patient();
		//serialization(p);
		p = deserialization();
		if(p == null)
			System.out.println("Deserialization for this object failed");
		else
			System.out.println(p);		
	}

	private static Patient deserialization() {
		try {
			FileInputStream fi = new FileInputStream("P1.bin");
			ObjectInputStream os = new ObjectInputStream(fi);
			Object obj = os.readObject();//BOXED Value
			if(obj instanceof Patient) {
				Patient p = (Patient)obj;//UNBOXING....
				os.close();
				return p;
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void serialization(Patient p) {
		p.docName ="Ramesh";
		p.billAmount = 600;
		p.name ="Gopal";
		p.phoneNo = 98767544;
		p.pId = 111;
		
		//Class that used for Serialization.
		try {
			FileOutputStream fs = new FileOutputStream("P1.bin");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(p);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Patient details are store to the file thro serialization");
	}

}

//Serializable interface is a member less interface which is to be implemented by the class so that it gives sp instruction to the jvm about the object so that it could be serialized to a bytestream . 
class Patient implements Serializable{
	int pId;
	String name;
	long phoneNo;
	String docName;
	Date date = new Date();//Default System date....
	double billAmount;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s is treated by %s on %s", name, docName, date.toLocaleString());
	}
}
class PatientException extends Exception{}
interface PatientDatabase{
	void addPatient(Patient p) throws PatientException;
	void updatePatient(Patient p) throws PatientException;
	void deletePatient(int id) throws PatientException;
	Patient [] getAllPatients();
	
}

//Implement this interface into a class that performs these operations using serialization....














