package com.ad.acp.controller;

import org.apache.log4j.Logger;

import com.ad.acp.bo.ReportBo;
import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ReportException;
import com.ad.acp.model.ReportModel;
import com.ad.acp.view.AcpUtilMessages;
import com.ad.acp.view.GoBackPage;
import com.ad.acp.view.ReportMessages;
import com.ad.acp.view.ReportPage1;

public class ReportController {

	public static final Logger LOGGER=Logger.getLogger(ReportController.class);
	
	public void executeReportController() {

		ReportModel reportModel = new ReportModel();
		ReportPage1 reportPage1 = new ReportPage1();
		try {
			LOGGER.info("show report page");
			reportModel = reportPage1.viewReportPage();
		} catch (AcpUtilException e1) {
			LOGGER.warn("in catch AcpUtilException ");
			AcpUtilMessages.displayAcpUtilExceptMsg(e1);
		} 

		ReportBo reportBo = new ReportBo();
		try {
			LOGGER.info("call getValidation() of ReportBo");
			if (reportBo.getValidation(reportModel)) {
				LOGGER.info("show success message");
				ReportMessages.displayRepSuccessMsg();
				LOGGER.info("go back to menu");
				GoBackPage.backPage();
			} else {
				LOGGER.info("show error message");
				ReportMessages.displayRepErrorMsg();
			}
		} catch (ReportException e) {
			LOGGER.warn("in catch ReportException ");
			ReportMessages.displayRepExceptMsg(e);
		}  catch (AcpUtilException e1) {
			LOGGER.warn("in catch AcpUtilException ");
			AcpUtilMessages.displayAcpUtilExceptMsg(e1);
		}

	}

}
