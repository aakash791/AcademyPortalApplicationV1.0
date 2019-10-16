package com.ad.acp.view;

import com.ad.acp.exception.ReportException;

public class ReportMessages {

	public static void displayRepSuccessMsg() {
		System.out.println("REPORT DETAILS HAVE BEEN SAVED INTO THE SYSTEM");  
	}
	
	public static void displayRepErrorMsg() {
		System.out.println("ERROR IN SUBMITTING REPORT");  
	}
	
	public static void displayRepExceptMsg(ReportException reportException) {
		System.out.println(reportException.getMessage());  
	}
	
}
