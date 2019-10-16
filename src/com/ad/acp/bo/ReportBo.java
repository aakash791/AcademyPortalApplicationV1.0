package com.ad.acp.bo;

import org.apache.log4j.Logger;

import com.ad.acp.dao.ReportDao;
import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ReportException;
import com.ad.acp.model.ReportModel;

public class ReportBo {  
	
	public static final Logger LOGGER=Logger.getLogger(ReportBo.class);

	public boolean getValidation(ReportModel reportModel) throws ReportException,  AcpUtilException {  

		LOGGER.info("Calulate Points");
		boolean flag=false;  
		int points = 0;  
		int weekrep = reportModel.getWeekRep();  
		String bhsrep = reportModel.getBhsRep();  
		int mocktest = reportModel.getMockTest();  
		String innpro = reportModel.getInnTitle();  
		String prostatus = reportModel.getProStatus();  

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
		if (innpro.equals("")) {  
			points = points + 0;
		} else if (prostatus.equalsIgnoreCase("in-progress")) {
			points = points + 2;
		} else if (prostatus.equalsIgnoreCase("completed")) {
			points = points + 5;
		}

		LOGGER.info("set Points");
		reportModel.setPoints(points);

		ReportDao reportDao=new ReportDao();  
		LOGGER.info("call submitReport() of reportDao");
		if(reportDao.submitReport(reportModel)){
			flag=true;			
		}
		
		LOGGER.info("returning flag");
		return flag;
	}

}
