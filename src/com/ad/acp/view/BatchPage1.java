package com.ad.acp.view;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ad.acp.bo.BatchBo;
import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.BatchException;
import com.ad.acp.model.BatchModel;

public class BatchPage1 {  

	public static final Logger LOGGER=Logger.getLogger(BatchPage1.class);
	
	public void viewBatchPage1() throws AcpUtilException, BatchException {
		
		LOGGER.info("Show Batch screen");		
		Scanner scanner = new Scanner(System.in);
		int ch = 0;
		String input;
		BatchModel batchModel = new BatchModel();
		LoginPage2 loginPage2=new LoginPage2();
		BatchBo batchBo = new BatchBo();
		System.out.println("*****************");  
		System.out.println("1. BATCH ALLOCATION");  
		System.out.println("2. BATCH UPDATE");  
		do {
			input = scanner.next();
			if (input.matches("[1-2]{1}")) {
				ch = Integer.parseInt(input);
				switch (ch) {
				case 1:
					BatchPage2 batchPage2 = new BatchPage2();
					batchModel = batchPage2.viewBatchPage2();

					if (batchBo.getValidation(batchModel)) {
						LOGGER.info("show success message");
						BatchMessages.displayBatSuccessMsg1();
						if (GoBackBatchPage.backBatchPage())
							LOGGER.info("Go back to batch menu");
							loginPage2.viewLoginPage2();

					} else {
						LOGGER.info("show error message");
						BatchMessages.displayBatErrorMsg1();
					}
					break;
				case 2:
					BatchPage3 batchPage3 = new BatchPage3();
					batchModel = batchPage3.viewBatchPage3();

					if (batchBo.getValidation1(batchModel)) {
						BatchMessages.displayBatSuccessMsg2();
						if (GoBackBatchPage.backBatchPage())
							LOGGER.info("Go back to batch menu");
							loginPage2.viewLoginPage2();
					} else {
						LOGGER.info("show error message");
						BatchMessages.displayBatErrorMsg2();
					}
					break;
				default:
					LOGGER.info("show error message");
					System.out.println("ENTER AGAIN");  
					break;
				}
			} else {
				ch = -1;
				LOGGER.info("show error message");
				System.out.println("ENTER AGAIN");  
			}
		} while (ch < 1 || ch > 2);

	}

}
