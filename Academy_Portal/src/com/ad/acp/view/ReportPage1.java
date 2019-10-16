package com.ad.acp.view;

import java.util.Scanner;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.model.ReportModel;
import com.ad.acp.util.FetchBatRepCode;
import com.ad.acp.util.FetchFacRepId;

public class ReportPage1 {

	public ReportModel viewReportPage() throws  AcpUtilException {

		Scanner scanner=new Scanner(System.in);
		boolean flag=false;
		String input,batid = null,facid = null,bhsrep = null,inntitle = null,prodesc = null,prostatus = null;
		int weekrep = 0,mocktest = 0;
		
		//check current date
		
		
		System.out.println("SELECT BATCH CODE"); // NOPMD by 493736 on 6/27/15 5:33 PM
        //FETCH BATCH CODE 
		batid=FetchBatRepCode.viewBatRepCode();
		
		facid=FetchFacRepId.viewFacRepId(batid);
		System.out.println("FACULTY ALLOCATED:- ID: "+facid); // NOPMD by 493736 on 6/27/15 5:34 PM
		//DISPLAY FACULTY ID ALLOCATED
				
		System.out.println("SUBMITTED WEEKLY REPORTS"); // NOPMD by 493736 on 6/27/15 5:34 PM
		System.out.println("0"); // NOPMD by 493736 on 6/27/15 5:34 PM
		System.out.println("1"); // NOPMD by 493736 on 6/27/15 5:34 PM
		System.out.println("2"); // NOPMD by 493736 on 6/27/15 5:36 PM
		System.out.println("3"); // NOPMD by 493736 on 6/27/15 5:36 PM
		System.out.println("4"); // NOPMD by 493736 on 6/27/15 5:36 PM
		do {
			input=scanner.nextLine();
			if(input.matches("[0-4]")){
				weekrep=Integer.parseInt(input);
				flag=false;
			}else{
				System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:36 PM
				flag=true;
			}
		} while (flag);

		System.out.println("MOCK TEST CONDUCTED"); // NOPMD by 493736 on 6/27/15 5:36 PM
		System.out.println("0"); // NOPMD by 493736 on 6/27/15 5:37 PM
		System.out.println("1"); // NOPMD by 493736 on 6/27/15 5:37 PM
		System.out.println("2"); // NOPMD by 493736 on 6/27/15 5:37 PM
		System.out.println("3"); // NOPMD by 493736 on 6/27/15 5:37 PM
		do {
			input=scanner.nextLine();
			if(input.matches("[0-3]")){
				mocktest=Integer.parseInt(input);
				flag=false;
			}else{
				System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:37 PM
				flag=true;
			}
		} while (flag);
		
		System.out.println("BHS REPORT SUBMITTED (PRESS Y FOR YES AND N FOR NO)"); // NOPMD by 493736 on 6/27/15 5:38 PM
		//YES OR NO
		do {
			bhsrep=scanner.nextLine();
			if(bhsrep.equalsIgnoreCase("y") || bhsrep.equalsIgnoreCase("n")){
				flag=false;
			}else{
				System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:38 PM
				flag=true;
			}
		} while (flag);

		System.out.println("ENTER INNOVATION PROJECT TITLE"); // NOPMD by 493736 on 6/27/15 5:38 PM
		inntitle=scanner.nextLine();

		System.out.println("ENTER PROJECT DESCRIPTION"); // NOPMD by 493736 on 6/27/15 5:38 PM
		prodesc=scanner.nextLine();

		System.out.println("ENTER PROJECT STATUS (PRESS 1 FOR IN-PROGRESS AND 2 FOR COMPLETED)"); // NOPMD by 493736 on 6/27/15 5:38 PM
		do {
			input=scanner.nextLine();
			if(input.matches("[1-2]")){
				if(input.equals("1")){
					prostatus="IN-PROGRESS";
				}
				if(input.equals("2")){
					prostatus="COMPLETED";
				}
				flag=false;
			}else{
				System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:38 PM
				flag=true;
			}
		} while (flag);
		
		
		ReportModel reportModel=new ReportModel();
		reportModel.setBatid(batid);
		reportModel.setFacid(facid);
		reportModel.setWeekRep(weekrep);
		reportModel.setMockTest(mocktest);
		reportModel.setBhsRep(bhsrep);
		reportModel.setInnTitle(inntitle);
		reportModel.setProDesc(prodesc);
		reportModel.setProStatus(prostatus);
		
		
		
		return reportModel;
	}

}
