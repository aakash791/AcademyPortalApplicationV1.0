package com.ad.acp.view;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ad.acp.model.ModuleModel;

public class ModulePage1 {

	public static final Logger LOGGER=Logger.getLogger(ModulePage1.class);
	
	public ModuleModel viewModulePage1() {

		LOGGER.info("Display Module Screen");
		Scanner scanner = new Scanner(System.in);
		String input, tname = null, domain = null, module = null;
		int ch = 0, duration = 0;
		boolean flag = false;

		System.out.println("**********************************");  

		System.out.println("ENTER TECHNOLOGY NAME");  
		System.out.println("1. C");  
		System.out.println("2. C++");  
		System.out.println("3. ASP.NET");  
		System.out.println("4. VB");  
		System.out.println("5. COBOL");  
		System.out.println("6. SQL");  
		System.out.println("7. PLSQL");  
		System.out.println("8. JAVA");  
		System.out.println("9. ADV_JAVA");  
		System.out.println("10. QTP");  
		System.out.println("11. SQL SERVER");  
		System.out.println("12. DATABASE CONCEPTS");  
		System.out.println("13. UNIX");  
		System.out.println("14. JUNIT");  
		do {
			input = scanner.nextLine();
			if (input.matches("[0-9]{1,}")) {
				ch = Integer.parseInt(input);
				switch (ch) {
				case 1:
					tname = "C";
					break;
				case 2:
					tname = "C++";
					break;
				case 3:
					tname = "ASP.NET";
					break;
				case 4:
					tname = "VB";
					break;
				case 5:
					tname = "COBOL";
					break;
				case 6:
					tname = "SQL";
					break;
				case 7:
					tname = "PLSQL";
					break;
				case 8:
					tname = "JAVA";
					break;
				case 9:
					tname = "ADV_JAVA";
					break;
				case 10:
					tname = "QTP";
					break;
				case 11:
					tname = "SQL SERVER";
					break;
				case 12:
					tname = "DATABASE CONCEPTS";
					break;
				case 13:
					tname = "UNIX";
					break;
				case 14:
					tname = "JUNIT";
					break;

				default:
					System.out.println("ENTER AGAIN");  
					break;
				}

			} else {
				System.out.println("ENTER AGAIN");  
			}
		} while (ch > 14 || ch < 1);

		System.out.println("ENTER DOMAIN NAME");  
		System.out.println("1. JAVA");  
		System.out.println("2. DOT_NET");  
		System.out.println("3. MAINFRAME");  
		System.out.println("4. TESTING");  

		do {
			input = scanner.nextLine();
			if (input.matches("[0-9]{1}")) {
				ch = Integer.parseInt(input);
				switch (ch) {
				case 1:
					if (tname.equals("PLSQL") || tname.equals("JAVA")
							|| tname.equals("ADV_JAVA")) {
						flag = false;
					} else {
						flag = true;
						System.out.println("ENTER AGAIN");  
						ch = -1;
					}
					domain = "JAVA";
					break;
				case 2:
					if (tname.equals("C#") || tname.equals("SQL SERVER")
							|| tname.equals("ASP.NET")) {
						flag = false;
					} else {
						flag = true;
						System.out.println("ENTER AGAIN");  
						ch = -1;
					}
					domain = "DOT_NET";
					break;
				case 3:
					domain = "MAINFRAME";
					break;
				case 4:
					domain = "TESTING";
					break;

				default:
					System.out.println("ENTER AGAIN");  
					break;
				}

			} else {
				System.out.println("ENTER AGAIN");  
			}
		} while (ch > 4 || ch < 1);

		System.out.println("ENTER MODULE TYPE");  
		System.out.println("1. MAJOR");  
		System.out.println("2. MINOR");  

		do {
			input = scanner.nextLine();
			if (input.matches("[0-9]{1}")) {
				ch = Integer.parseInt(input);
				switch (ch) {
				case 1:
					module = "MAJOR";
					break;
				case 2:
					if (tname.equals("C") || tname.equals("C++")
							|| tname.equals("DATABASE CONCEPTS")) {
						flag = false;
					} else {
						flag = true;
						System.out.println("ENTER AGAIN");  
						ch = -1;
					}
					module = "MINOR";
					break;

				default:
					System.out.println("ENTER AGAIN");  
					break;
				}

			} else {
				System.out.println("ENTER AGAIN");  
			}
		} while (ch > 2 || ch < 1);

		do {
			System.out  
					.println("ENTER DURATION IN HOURS (FOR MINOR --> 8-23 HOURS, FOR MAJOR --> ABOVE 24 HOURS)");
			input = scanner.nextLine();
			if (input.matches("[0-9]{1,2}")) {
				duration = Integer.parseInt(input);
				if (duration >= 8 && duration < 24 && module.equals("MINOR")) {
					flag = false;
				} else if (duration >= 24 && module.equals("MAJOR")) {
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
		
		LOGGER.info("setting ModuleModel values");
		ModuleModel moduleModel = new ModuleModel();
		moduleModel.setTname(tname);
		moduleModel.setDomain(domain);
		moduleModel.setDuration(duration);
		moduleModel.setModule(module);

		LOGGER.info("returning moduleModel");
		return moduleModel;

	}
}
