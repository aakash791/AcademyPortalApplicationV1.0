package com.ad.acp.view;

import com.ad.acp.exception.BatchException;



public class BatchMessages {

	public static void displayBatSuccessMsg1() {
		System.out.println("BATCH ALLOCATION IS DONE"); // NOPMD by 493736 on 6/27/15 4:13 PM
	}
	
	public static void displayBatSuccessMsg2() {
		System.out.println("BATCH IS CLOSED"); // NOPMD by 493736 on 6/27/15 4:13 PM
	}
	
	public static void displayBatErrorMsg1() {
		System.out.println("ERROR IN ALLOCATING BATCH"); // NOPMD by 493736 on 6/27/15 4:13 PM
	}
	
	public static void displayBatErrorMsg2() {
		System.out.println("ERROR IN UPDATING BATCH"); // NOPMD by 493736 on 6/27/15 4:13 PM
	}
	
	public static void displayBatExceptMsg(BatchException batchException) {
		System.out.println(batchException.getMessage()); // NOPMD by 493736 on 6/27/15 4:13 PM
	}
	
}
