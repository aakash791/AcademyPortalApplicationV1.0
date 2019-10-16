package com.ad.acp.view;

import com.ad.acp.exception.ModuleException;

public class ModuleMessages {

	public static void displayModSuccessMsg() {
		System.out.println("MODULE REGISTRATION DONE");  
	}
	
	public static void displayModErrorMsg() {
		System.out.println("ERROR IN ADDING MODULE");  
	}
	
	public static void displayModExceptMsg(ModuleException moduleException) {
		System.out.println(moduleException.getMessage());  
	}
	
}
