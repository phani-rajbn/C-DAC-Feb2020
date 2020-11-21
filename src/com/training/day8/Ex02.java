package com.training.day8;
//How to use Sockets for NIO Environments:

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;


public class Ex02 {

	public static void main(String[] args) throws Exception {
		SocketChannel server = SocketChannel.open();
		SocketAddress socketAddress = new InetSocketAddress("localhost", 1234);
		server.connect(socketAddress);
		
		Path path = Paths.get("/media/phani/Data/Temp.txt");
		FileChannel fileC = FileChannel.open(path);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while(fileC.read(buffer) != -1) {
			buffer.flip();
			server.write(buffer);
			buffer.clear();
		}
		fileC.close();
		System.out.println("File sent");
		server.close();
	}

}
