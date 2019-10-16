package com.ad.acp.view;

import com.ad.acp.exception.BatchException;



public class BatchMessages {

	public static void displayBatSuccessMsg1() {
		System.out.println("BATCH ALLOCATION IS DONE");  
	}
	
	public static void displayBatSuccessMsg2() {
		System.out.println("BATCH IS CLOSED");  
	}
	
	public static void displayBatErrorMsg1() {
		System.out.println("ERROR IN ALLOCATING BATCH");  
	}
	
	public static void displayBatErrorMsg2() {
		System.out.println("ERROR IN UPDATING BATCH");  
	}
	
	public static void displayBatExceptMsg(BatchException batchException) {
		System.out.println(batchException.getMessage());  
	}
	
}
