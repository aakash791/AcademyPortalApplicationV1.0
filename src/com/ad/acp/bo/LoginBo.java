package com.ad.acp.bo;

import org.apache.log4j.Logger;

import com.ad.acp.dao.LoginDao;
import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.LoginException;
import com.ad.acp.model.LoginModel;

public class LoginBo {

	public static final Logger LOGGER=Logger.getLogger(LoginBo.class);
	
	public boolean getValidation(LoginModel loginModel) throws LoginException,  AcpUtilException {  
	
		LOGGER.info("in loginBo getValidation()");
		boolean flag=false;  
		LoginDao loginDao=new LoginDao();  
		LOGGER.info("calling verifyadmin");
		if(loginDao.verifyadmin(loginModel)){
			flag=true;
		}
		LOGGER.info("in loginBo returning flag");
		return flag;
		
	}

}
