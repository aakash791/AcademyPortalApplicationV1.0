package com.ad.acp.bo;
import junit.framework.TestCase;

import org.junit.Test;

import com.ad.acp.model.LoginModel;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class LoginBoTest extends TestCase {
	

	@Test //public boolean getValidation(LoginModel)
	public void testGetValidation(){
		LoginBo e0Obj = new LoginBo();
		LoginModel e0Arg0 = new LoginModel();
		e0Arg0.setPassword("VZQPhqmsa0tg");
		e0Arg0.setUsername("h9DQZCVt");
		

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
		LoginBo e0Obj = new LoginBo();
		LoginModel e0Arg0 = new LoginModel();
		e0Arg0.setPassword("");
		e0Arg0.setUsername("cJAvFZ");
		

		try{
			boolean e0 = e0Obj.getValidation(e0Arg0);
			//TODO Based on your need, provide necessary assertion condition
		assertEquals(e0, new Object());
		}catch(Exception e){
			fail();
		}
	}
	

}
