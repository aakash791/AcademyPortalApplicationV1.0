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

		System.out.println("**********************************"); // NOPMD by 493736 on 6/27/15 5:33 PM

		System.out.println("ENTER TECHNOLOGY NAME"); // NOPMD by 493736 on 6/27/15 5:33 PM
		System.out.println("1. C"); // NOPMD by 493736 on 6/27/15 5:33 PM
		System.out.println("2. C++"); // NOPMD by 493736 on 6/27/15 5:33 PM
		System.out.println("3. ASP.NET"); // NOPMD by 493736 on 6/27/15 5:33 PM
		System.out.println("4. VB"); // NOPMD by 493736 on 6/27/15 5:36 PM
		System.out.println("5. COBOL"); // NOPMD by 493736 on 6/27/15 5:36 PM
		System.out.println("6. SQL"); // NOPMD by 493736 on 6/27/15 5:36 PM
		System.out.println("7. PLSQL"); // NOPMD by 493736 on 6/27/15 5:36 PM
		System.out.println("8. JAVA"); // NOPMD by 493736 on 6/27/15 5:36 PM
		System.out.println("9. ADV_JAVA"); // NOPMD by 493736 on 6/27/15 5:37 PM
		System.out.println("10. QTP"); // NOPMD by 493736 on 6/27/15 5:37 PM
		System.out.println("11. SQL SERVER"); // NOPMD by 493736 on 6/27/15 5:37 PM
		System.out.println("12. DATABASE CONCEPTS"); // NOPMD by 493736 on 6/27/15 5:37 PM
		System.out.println("13. UNIX"); // NOPMD by 493736 on 6/27/15 5:37 PM
		System.out.println("14. JUNIT"); // NOPMD by 493736 on 6/27/15 5:38 PM
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
					System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:38 PM
					break;
				}

			} else {
				System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:38 PM
			}
		} while (ch > 14 || ch < 1);

		System.out.println("ENTER DOMAIN NAME"); // NOPMD by 493736 on 6/27/15 5:38 PM
		System.out.println("1. JAVA"); // NOPMD by 493736 on 6/27/15 5:38 PM
		System.out.println("2. DOT_NET"); // NOPMD by 493736 on 6/27/15 5:39 PM
		System.out.println("3. MAINFRAME"); // NOPMD by 493736 on 6/27/15 5:38 PM
		System.out.println("4. TESTING"); // NOPMD by 493736 on 6/27/15 5:38 PM

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
						System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:39 PM
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
						System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:39 PM
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
					System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:39 PM
					break;
				}

			} else {
				System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:39 PM
			}
		} while (ch > 4 || ch < 1);

		System.out.println("ENTER MODULE TYPE"); // NOPMD by 493736 on 6/27/15 5:39 PM
		System.out.println("1. MAJOR"); // NOPMD by 493736 on 6/27/15 5:39 PM
		System.out.println("2. MINOR"); // NOPMD by 493736 on 6/27/15 5:39 PM

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
						System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:40 PM
						ch = -1;
					}
					module = "MINOR";
					break;

				default:
					System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:40 PM
					break;
				}

			} else {
				System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:40 PM
			}
		} while (ch > 2 || ch < 1);

		do {
			System.out // NOPMD by 493736 on 6/27/15 5:40 PM
					.println("ENTER DURATION IN HOURS (FOR MINOR --> 8-23 HOURS, FOR MAJOR --> ABOVE 24 HOURS)");
			input = scanner.nextLine();
			if (input.matches("[0-9]{1,2}")) {
				duration = Integer.parseInt(input);
				if (duration >= 8 && duration < 24 && module.equals("MINOR")) {
					flag = false;
				} else if (duration >= 24 && module.equals("MAJOR")) {
					flag = false;
				} else {
					System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:40 PM
					flag = true;
				}
			} else {
				System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:40 PM
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
