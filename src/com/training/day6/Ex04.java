package com.training.day6;
//Client socket to communicate with the server....
import java.io.*;
import java.net.*;

public class Ex04 {

	public static void main(String[] args) {
		//basicSocketClientExample();
		try {
			Socket s = new Socket("localhost", 4444);
			String inMsg = "", outMsg = "";
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			while(!inMsg.equals("STOP")) {
				inMsg = reader.readLine();
				dos.writeUTF(inMsg);
				dos.flush();
				outMsg = dis.readUTF();
				System.out.println("Server: " + outMsg);
			}
			dos.close();
			dis.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void basicSocketClientExample() {
		try {
			Socket s = new Socket("localhost", 4444);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF("Some content to communicate to the server");
			dos.flush();//clearing the buffer to the destination....	
			dos.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
