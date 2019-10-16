package com.ad.acp.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.BatchException;
import com.ad.acp.model.BatchModel;
import com.ad.acp.util.FetchDomID;
import com.ad.acp.util.FetchFacID;

public class BatchPage2 {

	public BatchModel viewBatchPage2() throws BatchException, AcpUtilException {

		boolean flag = false;
		@SuppressWarnings("unused")
		Date d;
		Scanner scanner = new Scanner(System.in);

		String domid, facid, batch_start_date, batch_end_date;

		System.out.println("SELECT DOMAIN ID"); // NOPMD by 493736 on 6/27/15 5:30 PM
		domid = FetchDomID.viewDomainId();

		System.out.println("SELECT FACULTY ID"); // NOPMD by 493736 on 6/27/15 5:30 PM
		facid = FetchFacID.viewFacultyId();

		System.out.println("ENTER BATCH START DATE"); // NOPMD by 493736 on 6/27/15 5:30 PM

		do {
			batch_start_date = scanner.nextLine();

			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
				sdf.setLenient(false);
				d = sdf.parse(batch_start_date);

				flag = false;
			} catch (ParseException e) {
				System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:30 PM
				flag = true;
			}

		} while (flag);

		System.out.println("ENTER BATCH END DATE"); // NOPMD by 493736 on 6/27/15 5:30 PM
		do {
			batch_end_date = scanner.nextLine();
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
				sdf.setLenient(false);
				d = sdf.parse(batch_end_date);

				if (getMonths(batch_start_date, batch_end_date) >= 3 || !checkDate(batch_start_date, batch_end_date)) { 
					System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:31 PM
					flag = true;
				} else
					flag = false;
			} catch (ParseException e) {
				System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 5:31 PM
				flag = true;
			}

		} while (flag);

		BatchModel batchModel = new BatchModel();
		batchModel.setDomid(domid);
		batchModel.setFacid(facid);
		batchModel.setBatchStartDate(batch_start_date);
		batchModel.setBatchEndDate(batch_end_date);

		return batchModel;
	}

	public int getMonths(String s1, String s2) { // NOPMD by 493736 on 6/27/15 4:13 PM

		Calendar calendar1 = Calendar.getInstance();
		try {
			calendar1.setTime(new SimpleDateFormat("dd-MMM-yyy").parse(s1));
		} catch (ParseException e) {
		}
		Calendar calendar2 = Calendar.getInstance();

		try {
			calendar2.setTime(new SimpleDateFormat("dd-MMM-yyy").parse(s2));
		} catch (ParseException e) {

		}
		int m = 0;
		while (calendar1.get(Calendar.MONTH) != calendar2.get(Calendar.MONTH)) {
			m++;
			calendar1.add(Calendar.MONTH, 1);
		}
		return m;
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
