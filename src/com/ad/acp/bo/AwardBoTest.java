package com.ad.acp.bo;
import junit.framework.TestCase;

import org.junit.Test;

import com.ad.acp.model.AwardModel;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class AwardBoTest extends TestCase {
	

	@Test //public boolean getValidation(AwardModel)
	public void testGetValidation(){
		AwardBo e0Obj = new AwardBo(); 
		AwardModel e0Arg0 = new AwardModel();
		e0Arg0.setHours(84);
		e0Arg0.setPercent(Double.parseDouble("0.09610323774069629"));
		e0Arg0.setCertificate("DMHK7nM");
		e0Arg0.setGrade("3Lb0Nnuh0ZU1TM");
		e0Arg0.setHandson(-97);
		e0Arg0.setBatpercent(Double.parseDouble("0.5810968333917416"));
		e0Arg0.setBatid("isFxQZl4xbKh");
		e0Arg0.setFacid("xFdgSpNV9cTMlV0w");
		e0Arg0.setPoints(-43);
		

		try{
			boolean e0 = e0Obj.getValidation(e0Arg0); 
			//TODO Based on your need, provide necessary assertion condition
		assertNotSame(e0, new Object());
		}catch(Exception e){
			fail();
		}
	}
	
	@Test //public boolean getValidation(AwardModel)
	public void testGetValidation1(){
		AwardBo e0Obj = new AwardBo(); 
		AwardModel e0Arg0 = new AwardModel(); 
		e0Arg0.setHours(90);
		e0Arg0.setPercent(Double.parseDouble("90"));
		e0Arg0.setCertificate("Y");
		e0Arg0.setGrade("A");
		e0Arg0.setHandson(100);
		e0Arg0.setBatpercent(Double.parseDouble("50"));
		e0Arg0.setBatid("bat#001");
		e0Arg0.setFacid("fac#001");
		e0Arg0.setPoints(90);
		

		try{
			boolean e0 = e0Obj.getValidation(e0Arg0); 
			//TODO Based on your need, provide necessary assertion condition
		assertSame(e0, false); //make changes to db to make it true 
		}catch(Exception e){
			fail();
		}
	}

	
	

}
