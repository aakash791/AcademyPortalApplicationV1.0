package com.ad.acp.view;

import com.ad.acp.exception.AwardException;
import com.ad.acp.model.AwardModel;

public class AwardMessages {

	public static void displayAwaSuccessMsg(AwardModel awardModel, String fname) {
		System.out.println(fname + " HAS BEEN RECOGNIZED WITH "  
				+ awardModel.getGrade() + " FOR BATCH "
				+ awardModel.getBatid());
	}
	
	public static void displayAwaErrorMsg() {
		System.out.println("ERROR IN CALCULATION OF GRADES");  
	}
	
	public static void displayAwaExceptMsg(AwardException awardException) {
		System.out.println(awardException.getMessage());  
	}
	
}
