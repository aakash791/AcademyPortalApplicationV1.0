package com.ad.acp.controller;

import org.apache.log4j.Logger;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.BatchException;
import com.ad.acp.view.AcpUtilMessages;
import com.ad.acp.view.BatchMessages;
import com.ad.acp.view.BatchPage1;

public class BatchController {

	public static final Logger LOGGER=Logger.getLogger(BatchController.class);
	
	public void executeBatchController() {

		
		BatchPage1 batchPage1 = new BatchPage1();

		try {
			LOGGER.info("show batch page");
			batchPage1.viewBatchPage1();
		} catch (BatchException e) {
			LOGGER.warn("in catch BatchException");
			BatchMessages.displayBatExceptMsg(e);
		} catch (AcpUtilException e1) {
			LOGGER.warn("in catch AcpUtilException");
			AcpUtilMessages.displayAcpUtilExceptMsg(e1);
		}

	}

}
