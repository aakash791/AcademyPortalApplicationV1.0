package com.ad.acp.view;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ad.acp.model.FacultyModel;

public class FacultyPage1 {

	public static final Logger LOGGER=Logger.getLogger(FacultyPage1.class);
	
	
	public FacultyModel viewFacultyPage1() {

		LOGGER.info("Display Faculty Screen");
		Scanner scanner = new Scanner(System.in);
		String input, fname, qual = null, email, add, skill = null, title;
		int ch = 0, exp = 0;
		long contact = 0;
		boolean flag = false;
		
		System.out.println("**********************************");  
		do {
			System.out.println("ENTER FACULTY NAME ");  
			fname = scanner.nextLine();
			if (fname.trim().equals("") || !fname.matches("[A-Za-z ]+")) {
				flag = true;
				System.out.println("ENTER AGAIN !!");  
			} else {
				flag = false;
			}
		} while (flag);
		System.out.println("ENTER LAST HIGHEST QUALIFICATION");  
		System.out.println("1.HS");  
		System.out.println("2.BA");  
		System.out.println("3.MA");  
		System.out.println("4.BTECH");  
		System.out.println("5.MTECH");  
		System.out.println("6.BCOM");  
		System.out.println("7.MCOM");  
		System.out.println("8.PHD");  
		System.out.println("9.BCA");  
		System.out.println("10.MCA");  
		System.out.println("11.BSC");  
		System.out.println("12.MSC");  
		do {
			input = scanner.nextLine();
			if (input.matches("[0-9]{1,}")) {
				ch = Integer.parseInt(input);
				switch (ch) {
				case 1:
					qual = "HS";
					break;
				case 2:
					qual = "BA";
					break;
				case 3:
					qual = "MA";
					break;
				case 4:
					qual = "BTECH";
					break;
				case 5:
					qual = "MTECH";
					break;
				case 6:
					qual = "BCOM";
					break;
				case 7:
					qual = "MCOM";
					break;
				case 8:
					qual = "PHD";
					break;
				case 9:
					qual = "BCA";
					break;
				case 10:
					qual = "MCA";
					break;
				case 11:
					qual = "BSC";
					break;
				case 12:
					qual = "MSC";
					break;

				default:
					System.out.println("ENTER AGAIN");  
					break;
				}

			} else {
				System.out.println("ENTER AGAIN");  
			}
		} while (ch > 12 || ch < 1);

		System.out.println("ENTER YEAR OF EXPERIENCE");  
		do {
			input = scanner.nextLine();
			if (input.matches("[0-9]{1,2}")) {
				exp = Integer.parseInt(input);
				flag = false;
			} else {
				flag = true;
				System.out.println("ENTER AGAIN !!");  
			}
		} while (flag);

		System.out.println("ENTER CONTACT");  

		do {
			input = scanner.nextLine();
			if (input.matches("[0-9]{10}")) {
				contact = Long.valueOf(input);
				flag = false;
			} else {
				flag = true;
				System.out.println("ENTER AGAIN !!");  
			}
		} while (flag);
		do {
			System.out.println("ENTER EMAIL ADDRESS");  
			email = scanner.nextLine();
			if (email.trim().equals("")
					|| !email
							.matches("[A-Za-z-_0-9]{1,}[@]{1}[A-Za-z]{1,}[.]{1}[A-Za-z]{1,}")) {
				flag = true;
				System.out.println("ENTER AGAIN !!");  
			} else {
				flag = false;
			}
		} while (flag);
		do {
			System.out.println("ENTER FACULTY ADDRESS");  
			add = scanner.nextLine();
			if (add.trim().equals("")) {
				flag = true;
				System.out.println("ENTER AGAIN !!");  
			} else {
				flag = false;
			}
		} while (flag);

		System.out.println("ENTER FACULTY SKILL");  
		System.out.println("1.C");  
		System.out.println("2.C++");  
		System.out.println("3.ASP.NET");  
		System.out.println("4.VB.NET");  
		System.out.println("5.COBOL");  
		System.out.println("6.SQL");  
		System.out.println("7.PLSQL");  
		System.out.println("8.JAVA");  
		System.out.println("9.ADV_JAVA");  
		System.out.println("10.QTP");
		System.out.println("11.SQL SERVER");
		System.out.println("12.DATABASE CONCEPTS");
		System.out.println("13.UNIX");
		System.out.println("14.JNIT");
		do {
			input = scanner.nextLine();
			if (input.matches("[0-9]+")) {
				ch = Integer.parseInt(input);
				switch (ch) {
				case 1:
					skill = "C";
					break;
				case 2:
					skill = "C++";
					break;
				case 3:
					skill = "ASP.NET";
					break;
				case 4:
					skill = "VB";
					break;
				case 5:
					skill = "COBOL";
					break;
				case 6:
					skill = "SQL";
					break;
				case 7:
					skill = "PLSQL";
					break;
				case 8:
					skill = "JAVA";
					break;
				case 9:
					skill = "ADV_JAVA";
					break;
				case 10:
					skill = "QTP";
					break;
				case 11:
					skill = "SQL SERVER";
					break;
				case 12:
					skill = "DATABASE CONCEPTS";
					break;
				case 13:
					skill = "UNIX";
					break;
				case 14:
					skill = "JUNIT";
					break;
				default:
					System.out.println("ENTER AGAIN");  
					break;
				}

			} else {
				System.out.println("ENTER AGAIN");  
			}
		} while (ch > 14 || ch < 1);

		System.out.println("CERTIFICATION ? (YES/NO) PRESS Y FOR YES AND N FOR NO");  
		do {
			title = scanner.next().toUpperCase();
			if (title.trim().equals("") || !title.matches("[YN]")) {
				flag = true;
				System.out.println("ENTER AGAIN !!");  
			} else {
				flag = false;
			}
		} while (flag);
		
		LOGGER.info("setting FacultyModel values");
		FacultyModel facultyModel=new FacultyModel();
		facultyModel.setFname(fname);
		facultyModel.setQualification(qual);
		facultyModel.setExperience(exp);
		facultyModel.setContact(contact);
		facultyModel.setEmail(email);
		facultyModel.setSkill(skill);
		facultyModel.setAddress(add);
		facultyModel.setCertificate(title);
				
		LOGGER.info("returning faculty model");
		return facultyModel;
	}
}
