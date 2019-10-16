package com.ad.acp.view;

import java.util.Scanner;

public class GoBackPage {

	public static void backPage() {
		
		int ch = 0;
		String input;
		Scanner scanner = new Scanner(System.in);
		LoginPage2 loginPage2 = new LoginPage2();
		System.out.println("GO BACK(1) OR EXIT(2) (PRESS 1 OR 2)");  
		do {
			input = scanner.nextLine();
			if (input.matches("[1-2]")) {
				ch=Integer.parseInt(input);
				if (ch == 1)
					loginPage2.viewLoginPage2();
				if (ch == 2)
					System.exit(0);
			} else {
				ch = -1;
				System.out.println("ENTER AGAIN");  
			}
		} while (ch > 2 || ch < 1);

	}
	
}
