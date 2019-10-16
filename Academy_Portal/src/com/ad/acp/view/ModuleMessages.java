package com.ad.acp.view;

import com.ad.acp.exception.ModuleException;

public class ModuleMessages {

	public static void displayModSuccessMsg() {
		System.out.println("MODULE REGISTRATION DONE"); // NOPMD by 493736 on 6/27/15 5:33 PM
	}
	
	public static void displayModErrorMsg() {
		System.out.println("ERROR IN ADDING MODULE"); // NOPMD by 493736 on 6/27/15 5:33 PM
	}
	
	public static void displayModExceptMsg(ModuleException moduleException) {
		System.out.println(moduleException.getMessage()); // NOPMD by 493736 on 6/27/15 5:33 PM
	}
	
}
