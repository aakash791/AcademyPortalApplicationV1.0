package com.ad.acp.controller;

import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.ad.acp.bo.AwardBo;
import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.AwardException;
import com.ad.acp.model.AwardModel;
import com.ad.acp.view.AcpUtilMessages;
import com.ad.acp.view.AwardMessages;
import com.ad.acp.view.AwardPage1;
import com.ad.acp.view.GoBackPage;

public class AwardController {

	public static final Logger LOGGER=Logger.getLogger(AwardController.class);
	
	public void executeAwardController() {

		LOGGER.info("show award page");
		AwardModel awardModel = new AwardModel();
		AwardPage1 awardPage1 = new AwardPage1();
		try {
			awardModel = awardPage1.viewAwardPage1();
		} catch (AcpUtilException e1) {
			LOGGER.warn("in catch AcpUtilException");
			AcpUtilMessages.displayAcpUtilExceptMsg(e1);
		}

		StringTokenizer stringTokenizer = new StringTokenizer(
				awardModel.getFacid(), "#");
		LOGGER.info("get name of faculty");
		String fname = stringTokenizer.nextToken().toUpperCase();

		AwardBo awardBo = new AwardBo();
		try {
			if (awardBo.getValidation(awardModel)) {
				LOGGER.info("show success message");
				AwardMessages.displayAwaSuccessMsg(awardModel, fname);
				LOGGER.info("go back to menu");
				GoBackPage.backPage();
			} else {
				LOGGER.info("show error message");
				AwardMessages.displayAwaErrorMsg();
			}
		} catch (AwardException e) {
			LOGGER.warn("in catch AwardException");
			AwardMessages.displayAwaExceptMsg(e);
		}  catch (AcpUtilException e1) {
			LOGGER.warn("in catch AcpUtilException");
			AcpUtilMessages.displayAcpUtilExceptMsg(e1);
			
		}

	}

}
