package com.ad.acp.bo;

import org.apache.log4j.Logger;

import com.ad.acp.dao.ReportDao;
import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ReportException;
import com.ad.acp.model.ReportModel;

public class ReportBo { // NOPMD by 493736 on 6/29/15 10:29 AM
	
	public static final Logger LOGGER=Logger.getLogger(ReportBo.class);

	public boolean getValidation(ReportModel reportModel) throws ReportException,  AcpUtilException { // NOPMD by 493736 on 6/29/15 10:29 AM

		LOGGER.info("Calulate Points");
		boolean flag=false; // NOPMD by 493736 on 6/29/15 10:30 AM
		int points = 0; // NOPMD by 493736 on 6/29/15 10:30 AM
		int weekrep = reportModel.getWeekRep(); // NOPMD by 493736 on 6/29/15 10:29 AM
		String bhsrep = reportModel.getBhsRep(); // NOPMD by 493736 on 6/29/15 10:29 AM
		int mocktest = reportModel.getMockTest(); // NOPMD by 493736 on 6/29/15 10:29 AM
		String innpro = reportModel.getInnTitle(); // NOPMD by 493736 on 6/29/15 10:29 AM
		String prostatus = reportModel.getProStatus(); // NOPMD by 493736 on 6/29/15 10:29 AM

		// @weeklyReport
		if (weekrep == 0) {
			points = points + 0;
		} else if (weekrep == 1 || weekrep == 2) {
			points = points + 5;
		} else if (weekrep == 3 || weekrep == 4) {
			points = points + 10;
		}
		// BHSReport
		if (bhsrep.equalsIgnoreCase("yes")) {
			points = points + 5;
		} else {
			points = points + 0;
		}

		// @MockTestReport
		if (mocktest == 0) {
			points = points + 0;
		} else if (mocktest == 1) {
			points = points + 5;
		} else if (weekrep == 2) {
			points = points + 8;
		} else if (weekrep == 3) {
			points = points + 10;
		}

		// InnovationProjectReport
		if (innpro.equals("")) { // NOPMD by 493736 on 6/29/15 10:29 AM
			points = points + 0;
		} else if (prostatus.equalsIgnoreCase("in-progress")) {
			points = points + 2;
		} else if (prostatus.equalsIgnoreCase("completed")) {
			points = points + 5;
		}

		LOGGER.info("set Points");
		reportModel.setPoints(points);

		ReportDao reportDao=new ReportDao(); // NOPMD by 493736 on 6/29/15 10:30 AM
		LOGGER.info("call submitReport() of reportDao");
		if(reportDao.submitReport(reportModel)){
			flag=true;			
		}
		
		LOGGER.info("returning flag");
		return flag;
	}

}
