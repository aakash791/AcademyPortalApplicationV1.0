package com.ad.acp.view;

import com.ad.acp.exception.LoginException;

public class LoginMessages {

	public static void displayLogErrorMsg() {
		System.out.println("ERROR IN LOGGING...WRONG CREDENTIALS");  
	}
	
	public static void displayLogExceptMsg(LoginException loginException) {
		System.out.println(loginException.getMessage());  
	}
	
}
