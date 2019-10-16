package com.ad.acp.controller;

import org.apache.log4j.Logger;

import com.ad.acp.bo.ModuleBo;
import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ModuleException;
import com.ad.acp.model.ModuleModel;
import com.ad.acp.view.AcpUtilMessages;
import com.ad.acp.view.GoBackPage;
import com.ad.acp.view.ModuleMessages;
import com.ad.acp.view.ModulePage1;

public class ModuleController {
	
	public static final Logger LOGGER=Logger.getLogger(ModuleController.class);
	
	public void executeModuleController() {
		
		LOGGER.info("Show Module Page");
		ModuleModel moduleModel=new ModuleModel();
		ModulePage1 modulePage1=new ModulePage1();
		moduleModel=modulePage1.viewModulePage1();
		
		ModuleBo moduleBo=new ModuleBo();
		try {
			LOGGER.info("calling getValidation() of moduleBo");
			if(moduleBo.getValidation(moduleModel)){
				LOGGER.info("show success message");
				ModuleMessages.displayModSuccessMsg();
				LOGGER.info("going back to menu");
				GoBackPage.backPage();
			}else{
				LOGGER.info("show error message");
				ModuleMessages.displayModErrorMsg();
			}
		} catch (ModuleException e) {
			LOGGER.warn("in catch ModuleException");		
			ModuleMessages.displayModExceptMsg(e);
		}  catch (AcpUtilException e1) {
			LOGGER.warn("in catch AcpUtilException");
			AcpUtilMessages.displayAcpUtilExceptMsg(e1);
		}
		
	}
}
