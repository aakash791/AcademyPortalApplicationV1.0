package com.ad.acp.view;

import com.ad.acp.exception.FacultyException;

public class FacultyMessages {

	
	public static void displayFacSuccessMsg() {
		System.out.println("FACULTY REGISTERED SUCCESSFULLY"); // NOPMD by 493736 on 6/27/15 5:32 PM
	}
	
	public static void displayFacErrorMsg() {
		System.out.println("ERROR IN REGISTERING FACULTY"); // NOPMD by 493736 on 6/27/15 5:32 PM
	}
	
	public static void displayFacExceptMsg(FacultyException facultyException) {
		System.out.println(facultyException.getMessage()); // NOPMD by 493736 on 6/27/15 5:32 PM
	}
	
}
