package com.training.day6;
/*
 * If u want to communicate b/w 2 processes or 2 machines within a known network, U should go for Socket Programming. Socket based Classes are available under java.net.*.
 * Technically, the 2 processes will be running in their own JRE's, in this case the server JRE and the client JRE. 
 * A builtin class called Socket is used to communicate with its servers by creating this object using another class called ServerSocket. 
 * Client Apps which consume/want to access this socket must be aware of 2 things: Location of the socket represented by an URL. Port no at which this socket is made available . Usually machine name will be the address and the port no will a 4 digit no. Once a port no is registered into the OS for a certain use, it cannot be used by other applications and processes. 
 * If the machine is local, the address would be localhost and portno would be the numeric no. Every IPC based App uses an unique port no thro' which clients will access it. Once the port no is allocated to one server, Os ensures that the same no cannot be used on other Application or other server. 8080 is the port no for Apache, 4200 for angular nodejs. 
 * Server sockets have the responsibility of creating server side components that make ur service, handle connections made to it by the clients. It will have methods  to accept, open, close the communication from its clients. 
 * Sockets are created even on the client side, they are called as Client sockets. Socket programming streams are available in java.io package
 * */
import java.net.*;//For sockets and its server components....
import java.io.*;//SocketStreams

public class Ex03 {

	public static void main(String[] args) {
		//basicSocketExample();
		try {
			ServerSocket ss = new ServerSocket(4444);
			Socket s = ss.accept();//The socket object is the one thro which communication would happen....
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String inMsg = "", outMsg = "";
			while(!inMsg.equals("End")){
				inMsg = din.readUTF();
				System.out.println(inMsg);
				outMsg = reader.readLine();
				dos.writeUTF(outMsg);
				dos.flush();
			}
			din.close();
			dos.close();
			s.close();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void basicSocketExample() {
		try {
			ServerSocket ss = new ServerSocket(4444);
			Socket s = ss.accept();//The socket object is the one thro which communication would happen....
			DataInputStream din = new DataInputStream(s.getInputStream());
			String inputs = din.readUTF();
			System.out.println(inputs);
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
