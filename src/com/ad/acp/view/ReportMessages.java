package com.ad.acp.view;

import com.ad.acp.exception.ReportException;

public class ReportMessages {

	public static void displayRepSuccessMsg() {
		System.out.println("REPORT DETAILS HAVE BEEN SAVED INTO THE SYSTEM"); // NOPMD by 493736 on 6/27/15 5:33 PM
	}
	
	public static void displayRepErrorMsg() {
		System.out.println("ERROR IN SUBMITTING REPORT"); // NOPMD by 493736 on 6/27/15 5:33 PM
	}
	
	public static void displayRepExceptMsg(ReportException reportException) {
		System.out.println(reportException.getMessage()); // NOPMD by 493736 on 6/27/15 5:33 PM
	}
	
}
