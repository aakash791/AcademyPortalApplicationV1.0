package com.ad.acp.view;

import com.ad.acp.exception.AwardException;
import com.ad.acp.model.AwardModel;

public class AwardMessages {

	public static void displayAwaSuccessMsg(AwardModel awardModel, String fname) {
		System.out.println(fname + " HAS BEEN RECOGNIZED WITH " // NOPMD by 493736 on 6/27/15 4:12 PM
				+ awardModel.getGrade() + " FOR BATCH "
				+ awardModel.getBatid());
	}
	
	public static void displayAwaErrorMsg() {
		System.out.println("ERROR IN CALCULATION OF GRADES"); // NOPMD by 493736 on 6/27/15 4:12 PM
	}
	
	public static void displayAwaExceptMsg(AwardException awardException) {
		System.out.println(awardException.getMessage()); // NOPMD by 493736 on 6/27/15 4:12 PM
	}
	
}
