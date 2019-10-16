package com.ad.acp.bo;
import junit.framework.TestCase;

import org.junit.Test;

import com.ad.acp.model.ModuleModel;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class ModuleBoTest extends TestCase {
	

	@Test //public boolean getValidation(ModuleModel)
	public void testGetValidation(){
		ModuleBo e0Obj = new ModuleBo();
		ModuleModel e0Arg0 = new ModuleModel();
		e0Arg0.setTechid("00");
		e0Arg0.setDomid("1QO7q5JvgeBpk8JaKi");
		e0Arg0.setTname("dG");
		e0Arg0.setDomain("pdQx");
		e0Arg0.setModule("g5cd");
		e0Arg0.setDuration(90);
		

		try{
			boolean e0 = e0Obj.getValidation(e0Arg0);
			//TODO Based on your need, provide necessary assertion condition
		assertNotSame(e0, new Object());
		}catch(Exception e){
			fail();
		}
	}
	

	@Test
	public void testSequence(){
		ModuleBo e0Obj = new ModuleBo();
		ModuleModel e0Arg0 = new ModuleModel();
		e0Arg0.setTechid("Hc8Pv");
		e0Arg0.setDomid("GiQHcY8h4dLg155VBE");
		e0Arg0.setTname("bJVAaoh");
		e0Arg0.setDomain("GyDTObZ");
		e0Arg0.setModule("wifbaErjm4FJ");
		e0Arg0.setDuration(31);
		

		try{
			boolean e0 = e0Obj.getValidation(e0Arg0);
			//TODO Based on your need, provide necessary assertion condition
		assertEquals(e0, new Object());
		}catch(Exception e){
			fail();
		}
	}
	

}
