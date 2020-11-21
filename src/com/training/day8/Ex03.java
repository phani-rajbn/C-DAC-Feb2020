package com.training.day8;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

//Client App that consumes the socket to send files to the server...
public class Ex03 {

	public static void main(String[] args)throws IOException {
		ServerSocketChannel serverSocket = null;
		SocketChannel client = null;
		serverSocket = ServerSocketChannel.open();
		serverSocket.socket().bind(new InetSocketAddress(1234));
		client = serverSocket.accept();
		System.out.println("The connection to the server is set");
		Path path = Paths.get("/media/phani/Data/Temp.txt");
		FileChannel fileC = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while(client.read(buffer) != -1) {
			buffer.flip();
			fileC.write(buffer);
			buffer.clear();
		}
		fileC.close();
		System.out.println("File is saved");
		client.close();
		
	}

}
