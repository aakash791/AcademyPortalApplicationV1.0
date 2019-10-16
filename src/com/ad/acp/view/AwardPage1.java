package com.ad.acp.view;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.model.AwardModel;
import com.ad.acp.util.FetchAwaDomName;
import com.ad.acp.util.FetchBatID;
import com.ad.acp.util.FetchFacID;

public class AwardPage1 {

	public static final Logger LOGGER=Logger.getLogger(AwardPage1.class);
	
	public AwardModel viewAwardPage1() throws AcpUtilException {

		LOGGER.info("show award menu");	
		Scanner scanner = new Scanner(System.in);
		boolean flag = false;
		String input, facid = null, batid = null, /*facupgarde = null,*/ certificate = null, dname;
		double percent = 0, batpercent = 0;
		int hours = 0,handson = 0;

		System.out.println("SELECT FACULTY ID");  
		// FETCH FACULTY ID
		facid=FetchFacID.viewFacultyId(); 

		batid=FetchBatID.viewBatID(facid);
		System.out.println("BATCH ID:- "+batid);  
		// SHOW BATCH ID
	

		dname = FetchAwaDomName.viewAwaDomName(facid);
		
		System.out.println("ENTER STUDENT FEEDBACK PERCENTAGE");  
		do {
			input = scanner.nextLine();
			if (input.matches("[0-9]+[.]{0,1}[0-9]*")) {

				percent = Double.parseDouble(input);
				if (percent >= 1 && percent <= 100) {
					flag = false;
				} else {
					System.out.println("ENTER AGAIN");  
					flag = true;
				}
			} else {
				System.out.println("ENTER AGAIN");  
				flag = true;
			}
		} while (flag);

		System.out.println("ENTER EXTRA HOURS");  

		do {
			input = scanner.nextLine();
			if (input.matches("[0-9]+")) {
				hours = Integer.parseInt(input);
				flag = false;
			} else {
				System.out.println("ENTER AGAIN");  
				flag = true;
			}
		} while (flag);

		System.out.println("ENTER BATCH PASS PERCENTAGE(%)");  
		do {
			input = scanner.nextLine();
			if (input.matches("[0-9]+[.]{0,1}[0-9]*")) {

				batpercent = Double.parseDouble(input);
				if (batpercent >= 1 && batpercent <= 100) {
					flag = false;
				} else {
					System.out.println("ENTER AGAIN");  
					flag = true;
				}
			} else {
				System.out.println("ENTER AGAIN");  
				flag = true;
			}
		} while (flag);

		/*System.out.println("SELECT FACULTY SKILL");
		System.out.println("1.SQL");
		System.out.println("2.PLSQL");
		System.out.println("3.JAVA");
		System.out.println("4.ADVANCE JAVA");
		do {
			input = scanner.nextLine();
			if (input.matches("[1-4]")) {
				flag = false;
				int ch = Integer.parseInt(input);
				if (ch == 1)
					facupgarde = "SQL";
				if (ch == 2)
					facupgarde = "PLSQL";
				if (ch == 3)
					facupgarde = "JAVA";
				if (ch == 4)
					facupgarde = "ADVANCED JAVA";
			} else{
				flag = true;
				System.out.println("ENTER AGAIN");
			}

		} while (flag);*/

		System.out  
				.println("CERTIFICATION DONE? (PRESS Y FOR YES AND N FOR NO)");
		do {
			input = scanner.nextLine();
			if (input.equalsIgnoreCase("y")) {
				certificate = "Y";
				flag = false;
			} else if (input.equalsIgnoreCase("n")) {
				certificate = "N";
				flag = false;
			} else {
				flag = true;
				System.out.println("ENTER AGAIN");  
			}
		} while (flag);

		System.out.println("ENTER HANDSON COMPLETION ");  
		do {
			input = scanner.nextLine();
			if (input.matches("[0-9]+")) {

				handson = Integer.parseInt(input);
				if (handson >= 1 && handson <= 200) {
					if (dname.equalsIgnoreCase("JAVA") && handson<=100) {
						flag = false;
					}else if (dname.equalsIgnoreCase("DOT_NET") && handson<=150) {
						flag = false;
					}else if (dname.equalsIgnoreCase("MAINFRAME") && handson<=50) {
						flag = false;
					}else if (dname.equalsIgnoreCase("TESTING") && handson<=175) { 
						flag = false;
					}else{
						System.out.println("ENTER AGAIN");  
						flag=true;
					}
				} else {
					System.out.println("ENTER AGAIN");  
					flag = true;
				}
			} else {
				System.out.println("ENTER AGAIN");  
				flag = true;
			}
		} while (flag);

		LOGGER.info("set awardModel");
		AwardModel awardModel = new AwardModel();
		awardModel.setBatid(batid);
		awardModel.setFacid(facid);
		awardModel.setPercent(percent);
		awardModel.setHours(hours);
		awardModel.setBatpercent(batpercent);
		//awardModel.setFacupgarde(facupgarde);
		awardModel.setCertificate(certificate);
		awardModel.setHandson(handson);

		LOGGER.info("return awardModel");
		return awardModel;

	}
}
