package com.ad.acp.bo;
import junit.framework.TestCase;

import org.junit.Test;

import com.ad.acp.model.ReportModel;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class ReportBoTest extends TestCase {
	

	@Test //public boolean getValidation(ReportModel)
	public void testGetValidation(){
		ReportBo e0Obj = new ReportBo();
		ReportModel e0Arg0 = new ReportModel();
		e0Arg0.setFacid("6xoyNtesfUNi64Gx76Z");
		e0Arg0.setBatid("DZ");
		e0Arg0.setWeekRep(82);
		e0Arg0.setMockTest(3);
		e0Arg0.setBhsRep("kRv3mTk0JutgpE8u7");
		e0Arg0.setInnTitle("4n3DyiE46ciZ6");
		e0Arg0.setProDesc("LzicAQ7");
		e0Arg0.setProStatus("G8Vp7hmjSzYXiT1");
		e0Arg0.setPoints(-32);
		

		try{
			boolean e0 = e0Obj.getValidation(e0Arg0);
			//TODO Based on your need, provide necessary assertion condition
		assertEquals(e0, new Object());
		}catch(Exception e){
			fail();
		}
	}
	

	@Test
	public void testSequence(){
		ReportBo e0Obj = new ReportBo();
		ReportModel e0Arg0 = new ReportModel();
		e0Arg0.setFacid("dSlX0cZ7O");
		e0Arg0.setBatid("JkLNrF6yUb6IEYnw");
		e0Arg0.setWeekRep(-47);
		e0Arg0.setMockTest(-61);
		e0Arg0.setBhsRep("em6aUZN4BCd6Eclbm5");
		e0Arg0.setInnTitle("H0TzWyzW2UE4");
		e0Arg0.setProDesc("U");
		e0Arg0.setProStatus("cclF18kvzjRihh1s6g1");
		e0Arg0.setPoints(-12);
		

		try{
			boolean e0 = e0Obj.getValidation(e0Arg0);
			//TODO Based on your need, provide necessary assertion condition
		assertEquals(e0, new Object());
		}catch(Exception e){
			fail();
		}
	}
	

}
