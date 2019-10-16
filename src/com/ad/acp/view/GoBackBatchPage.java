package com.ad.acp.view;

import java.util.Scanner;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.BatchException;

public class GoBackBatchPage {
	
	public static boolean backBatchPage() throws BatchException, AcpUtilException {
		
		int ch = 0;
		String input;
		Scanner scanner = new Scanner(System.in);
		BatchPage1 batchPage1=new BatchPage1();
		boolean flag=false;
	
		System.out.println("GO BACK TO BATCH MENU(1) OR MAIN MENU(2) EXIT(3) (PRESS 1 , 2 OR 3 )");  
		do {
			input = scanner.next();
			if (input.matches("[1-3]")) {
				ch=Integer.parseInt(input);
				if (ch == 1)
					batchPage1.viewBatchPage1();
				if (ch == 2)
					flag=true;
				if (ch == 3)
					System.exit(0);
			} else {
				ch = -1;
				System.out.println("ENTER AGAIN");  
			}
		} while (ch > 3 || ch < 1);
		
		return flag;
	}
}
