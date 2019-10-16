package com.ad.acp.controller;

import org.apache.log4j.Logger;

import com.ad.acp.bo.FacultyBo;
import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.FacultyException;
import com.ad.acp.model.FacultyModel;
import com.ad.acp.view.AcpUtilMessages;
import com.ad.acp.view.FacultyMessages;
import com.ad.acp.view.FacultyPage1;
import com.ad.acp.view.GoBackPage;

public class FacultyController {

	public static final Logger LOGGER=Logger.getLogger(FacultyController.class);
	
	public void executeFacultyController() {

		
		FacultyModel facultyModel = new FacultyModel();
		FacultyPage1 facultyPage1 = new FacultyPage1(); // SHOW FACULTY MENU PAGE
		LOGGER.info("Show Faculty menu");												
		facultyModel = facultyPage1.viewFacultyPage1();

		FacultyBo facultyBo = new FacultyBo();
		try {
			LOGGER.info("calling getValidation() of facultyBo");
			if (facultyBo.getValidation(facultyModel)) {
				LOGGER.info("show success message");
				FacultyMessages.displayFacSuccessMsg();
				LOGGER.info("going back");
				GoBackPage.backPage();

			} else {
				LOGGER.info("display error message");
				FacultyMessages.displayFacErrorMsg();
			}
		} catch (FacultyException e) {
			LOGGER.warn("in catch FacultyException");
			FacultyMessages.displayFacExceptMsg(e);

		} catch (AcpUtilException e1) {
			LOGGER.warn("in catch AcpUtilException");
			AcpUtilMessages.displayAcpUtilExceptMsg(e1);
		}
	}

}
