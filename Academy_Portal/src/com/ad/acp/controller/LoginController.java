package com.ad.acp.controller;

import org.apache.log4j.Logger;

import com.ad.acp.bo.LoginBo;
import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.LoginException;
import com.ad.acp.model.LoginModel;
import com.ad.acp.view.AcpUtilMessages;
import com.ad.acp.view.LoginMessages;
import com.ad.acp.view.LoginPage1;
import com.ad.acp.view.LoginPage2;

public class LoginController {

	public static final Logger LOGGER=Logger.getLogger(LoginController.class);
	
	public void excuteFrontController() {
		
		LOGGER.info("executing login controller");
	
		LoginModel loginModel = new LoginModel();
		LoginPage1 loginPage1=new LoginPage1(); 
		LOGGER.info("showing login screen");
		//VIEW LOGIN SCREEN
		loginModel=loginPage1.viewLoginPage1();
		
		LoginBo loginBo = new LoginBo();
		try {
			LOGGER.info("in try (login controller) calling getValidation()");
			if (loginBo.getValidation(loginModel)) {
				LOGGER.info("Showing Menu");
				LoginPage2 loginPage2=new LoginPage2();         //SHOW MENU 
				loginPage2.viewLoginPage2();
			} else {
				LOGGER.info("show error message");
				LoginMessages.displayLogErrorMsg();
			}
		} catch (LoginException e) {
			LOGGER.warn("in catch (login controller)");
			LoginMessages.displayLogExceptMsg(e);
		}catch (AcpUtilException e1) {
			LOGGER.warn("in catch (AcpUtil exception)");
			AcpUtilMessages.displayAcpUtilExceptMsg(e1);
		}

	}

}
