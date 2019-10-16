package com.ad.acp.bo;

import org.apache.log4j.Logger;

import com.ad.acp.dao.AwardDao;
import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.AwardException;
import com.ad.acp.model.AwardModel;

public class AwardBo { // NOPMD by 493736 on 6/27/15 3:46 PM

	public static final Logger LOGGER=Logger.getLogger(AwardBo.class);
	
	public boolean getValidation(AwardModel awardModel) throws AwardException, AcpUtilException { // NOPMD by 493736 on 6/27/15 3:46 PM

	
		LOGGER.info("calculate points");
		boolean flag=false; // NOPMD by 493736 on 6/27/15 3:46 PM
		int points=0;

		
		double student=awardModel.getPercent(); // NOPMD by 493736 on 6/27/15 3:46 PM
		double batpercent=awardModel.getBatpercent(); // NOPMD by 493736 on 6/27/15 3:46 PM
		int hours=awardModel.getHours(); // NOPMD by 493736 on 6/27/15 3:46 PM
		//awardModel.getFacupgarde();
		String cert=awardModel.getCertificate(); // NOPMD by 493736 on 6/27/15 3:46 PM
		int handson =awardModel.getHandson(); // NOPMD by 493736 on 6/27/15 3:46 PM

		if(student>=90 && student<=100){
			points+=20;
		}else if(student>=70 && student<=89){
			points+=10;
		}else if(student>=60 && student<=69){
			points+=5;
		}
		
		if(batpercent==100){
			points+=10;
		}else if(batpercent>=90 && batpercent<=99){
			points+=8;
		}else if(batpercent>=75 && batpercent<=89){
			points+=5;
		}

		if(hours>=100){
			points+=5;
		}else if(hours<100){
			points+=3;
		}
		
		if(cert.equalsIgnoreCase("y")){
			points+=10;
		}
		
		if(handson>=100){
			points+=10;
		}else if(handson>=50){
			points+=2;
		}
		
		LOGGER.info("set points");
		awardModel.setPoints(points);
		
		AwardDao awardDao=new AwardDao(); // NOPMD by 493736 on 6/27/15 3:47 PM
		LOGGER.info("call awardCalculation() of awardDao");
		if(awardDao.awardCalculation(awardModel)){
			flag=true;
		}
		LOGGER.info("returning flag");
		return flag;
	}

}
