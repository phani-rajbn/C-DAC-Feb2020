package com.training.day4;
//Some programs suggest to log the Exception messages to a logger in the constructor code...
public class MyProgramException extends Exception {

	public MyProgramException() {
		// TODO Auto-generated constructor stub
	}

	public MyProgramException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MyProgramException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MyProgramException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MyProgramException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
