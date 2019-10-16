package com.ad.acp.view;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ad.acp.controller.AwardController;
import com.ad.acp.controller.BatchController;
import com.ad.acp.controller.FacultyController;
import com.ad.acp.controller.ModuleController;
import com.ad.acp.controller.ReportController;

public class LoginPage2 {

	public static final Logger LOGGER=Logger.getLogger(LoginPage2.class);
	
	public void viewLoginPage2() {
		
		LOGGER.info("Displaying welcome screen");
		Scanner scanner=new Scanner(System.in);
		String input=null;
		int ch=0;
		System.out.println("**************Welcome*************");  
		System.out.println("-----------MENU-----------");  
		System.out.println("1. FACULTY REGISTRATION");  
		System.out.println("2. ADD MODULE");  
		System.out.println("3. BATCH ALLOCATION/UPDATION");  
		System.out.println("4. REPORT MANAGEMENT");  
		System.out.println("5. AWARD AND CREDIT POINTS");  
		System.out.println("6: EXIT");  
		System.out.println("---------------------------");  
		do {
			input = scanner.next();
			LOGGER.info("choice is given");
			if (input.matches("[0-9]{1}")){
				ch = Integer.parseInt(input);
				switch (ch) {
				case 1:
					LOGGER.info("execute facultyController()");
					FacultyController facultyController = new FacultyController();
					facultyController.executeFacultyController();
					break;
				case 2:
					LOGGER.info("execute moduleController()");
					ModuleController moduleController=new ModuleController(); 
					moduleController.executeModuleController();
					break;
				case 3:
					LOGGER.info("execute batchController()");
					BatchController batchController=new BatchController(); 
					batchController.executeBatchController();
					break;
				case 4:
					LOGGER.info("execute reportController()");
					ReportController reportController=new ReportController();
					reportController.executeReportController();
					break;	
				case 5:
					LOGGER.info("execute awardController()");
					AwardController awardController=new AwardController();
					awardController.executeAwardController();
					break;	
				case 6:
					LOGGER.info("program exit");
					System.out.println("<<<<PROGRAM EXITING>>>>");
					System.exit(0);
	 			default:
	 				LOGGER.info("wrong choice given");
					System.out.println("ENTER AGAIN");  
					break;
				}
			}
			else{
				LOGGER.info("wrong choice given");
				System.out.println("ENTER AGAIN");  
			}
			} while (ch > 6 || ch < 1);
	}
}
