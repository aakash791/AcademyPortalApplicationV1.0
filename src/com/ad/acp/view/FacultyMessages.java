package com.ad.acp.view;

import com.ad.acp.exception.FacultyException;

public class FacultyMessages {

	
	public static void displayFacSuccessMsg() {
		System.out.println("FACULTY REGISTERED SUCCESSFULLY");  
	}
	
	public static void displayFacErrorMsg() {
		System.out.println("ERROR IN REGISTERING FACULTY");  
	}
	
	public static void displayFacExceptMsg(FacultyException facultyException) {
		System.out.println(facultyException.getMessage());  
	}
	
}
