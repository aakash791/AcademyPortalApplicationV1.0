package com.ad.acp.view;

import com.ad.acp.exception.LoginException;

public class LoginMessages {

	public static void displayLogErrorMsg() {
		System.out.println("ERROR IN LOGGING...WRONG CREDENTIALS"); // NOPMD by 493736 on 6/27/15 5:32 PM
	}
	
	public static void displayLogExceptMsg(LoginException loginException) {
		System.out.println(loginException.getMessage()); // NOPMD by 493736 on 6/27/15 5:32 PM
	}
	
}
