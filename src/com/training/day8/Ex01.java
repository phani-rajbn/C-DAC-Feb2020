package com.training.day8;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

//NIO: Non blocking IO also called as NIO introduced in java 4 is an alternate way of handling IO operations in an asynchronous manner. This is required if U R interacting with a REST Service or any client or server that handles callback functions and async programming.
//Most of the APIs are same as the regular IO. Main difference is the IO is based on Streams and NIO is based on buffers. 
//Blocking IO streams will make a file or a resource locked while reading or writing. This creates a blocking situation for other programs that try to read and write to the file. In the non-blocking IO, data is read into CHANNELS. Channels are units that hold the buffer of the data.. The channels allow to read the data dynamically without blocking the UI or the resource. Channels are a buffered piece of memory that gets filled in and as the previous buffer data is read/written.  This ensures that the file is not blocked during the complete process of read/write. 
//3 Terms: Channels, Buffers and Selectors. 
//Buffers: Fixed piece of memory used to store the data before it is being read into a channel. Buffers ensure that the defined size of the data is preloaded to speed up the process of read/write. It can be configured using config files. Depending on the type of inputs, u have different kinds of buffers: ByteBuffer, CharBuffer, DoubleBuffer, FloatBuffer etc. 
//Channels: Similar to streams of IO, but they allow data over network as well as within the machine and processes. In Streams, the read is data directly from the file(blocking it), but channels read the data from the buffers that it is associated, this is what makes it a NON-BLOCKING IO. Here too, we have different kinds of Channels: FileChannel, DatagramChannel, SocketChannel, TCPChannel and many more. 
//Selectors:Selectors are objects that can be used to monitor the multiple channels for various kinds of events like data arrival, connection opened, closed and so forth.... With selectors, we have interact with multiple channels at a time. 

//Give U info about ur directories...
public class Ex01 {

	public static void main(String[] args) {
		try {
			//channelsExample();
			//bufferReadingExample();
			directoryFileInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void directoryFileInfo() {
		File folder = new File("src/com/training/day7");
		for(File entry : folder.listFiles()) {
			if(entry.isFile()) {
				System.out.println("The name : " + entry.getName());
				System.out.println("The Path : " + entry.getAbsolutePath());
				File parent = entry.getParentFile();
				if(parent.isDirectory()) {
					System.out.println(parent.getPath());
				}
			}
		}
		
	}

	private static void bufferReadingExample() throws IOException {
		Path file= Paths.get("MyChannel.txt");
		InputStream is = Files.newInputStream(file);
		BufferedReader bReader = new BufferedReader(new InputStreamReader(is));
		System.out.println("Reading the file from the source:");
		System.out.println(bReader.readLine());
		bReader.close();
		is.close();
		//Try reading the complete file using a while loop till the readLine returns null
	}

	static void transferData(ReadableByteChannel source, WritableByteChannel dest) throws IOException{
		ByteBuffer buffer = ByteBuffer.allocate(20* 1024);
		while(source.read(buffer) != -1) {
			buffer.flip();
			while(buffer.hasRemaining()) {
				dest.write(buffer);
			}
			buffer.clear();	
		}

	}

	private static void channelsExample() throws FileNotFoundException, IOException {
		FileInputStream fs = new FileInputStream("MyChannel.txt");
		ReadableByteChannel source = fs.getChannel();
		
		FileOutputStream fo = new FileOutputStream("MyOutputChannel2.txt");
		WritableByteChannel dest = fo.getChannel();		
		transferData(source, dest);
		source.close();
		dest.close();
		System.out.println("Completed the operation");
	}

}
