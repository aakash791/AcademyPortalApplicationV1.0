package com.ad.acp.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.BatchException;
import com.ad.acp.model.BatchModel;
import com.ad.acp.util.FetchBatchInfo;

public class BatchPage3 {

	public BatchModel viewBatchPage3() throws BatchException, AcpUtilException {

		boolean flag = false;
		@SuppressWarnings("unused")
		Date d;
		Scanner scanner = new Scanner(System.in);

		BatchModel batchModel = new BatchModel();

		String batid, batch_closed_date;

		System.out.println("ENTER BATCH ID");  
		batid = scanner.nextLine();

		batchModel = FetchBatchInfo.viewBatchInfo(batid);

		System.out.println("ENTER BATCH CLOSED DATE");  

		do {
			batch_closed_date = scanner.nextLine();

			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
				sdf.setLenient(false);
				d = sdf.parse(batch_closed_date);

				if (checkDate(batch_closed_date,
						batchModel.getBatchEndDate())) {
					flag = true;
					System.out.println("ENTER AGAIN");  
				} else
					flag = false;
			} catch (ParseException e) {
				System.out.println("ENTER AGAIN : DATE NOT IN FORMAT");  
				flag = true;
			}

		} while (flag);

		batchModel.setBatchClosedDate(batch_closed_date);

		return batchModel;
	}

	public boolean checkDate(String s1, String s2) {

		boolean b = false;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			Date d1;

			d1 = sdf.parse(s1);
			Calendar c = Calendar.getInstance();
			c.setTime(d1);
			long abc = c.getTimeInMillis();

			Date d2 = sdf.parse(s2);
			c.setTime(d2);
			long def = c.getTimeInMillis();

			if (abc > def) {
				b = false;
			} else {
				b = true;
			}
		} catch (ParseException e) {
			
		}
		return b;

	}

}
