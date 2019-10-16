package com.ad.acp.bo;
import junit.framework.TestCase;

import org.junit.Test;

import com.ad.acp.model.FacultyModel;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class FacultyBoTest extends TestCase {
	

	@Test //public boolean getValidation(FacultyModel)
	public void testGetValidation(){
		FacultyBo e0Obj = new FacultyBo(); // NOPMD by 493736 on 6/29/15 10:28 AM
		FacultyModel e0Arg0 = new FacultyModel(); // NOPMD by 493736 on 6/29/15 10:28 AM
		e0Arg0.setAddress("SWfc0elVgW3kO");
		e0Arg0.setFacid("Jl0kKRY");
		e0Arg0.setFname("3qJaocea570Ky");
		e0Arg0.setExperience(-69);
		e0Arg0.setContact(Long.parseLong("8734737172592732485"));
		e0Arg0.setEmail("veyNk6rVS");
		e0Arg0.setSkill("h03R3VztQs");
		e0Arg0.setQualification("bUFI5Z9RbhkUd");
		e0Arg0.setCertificate("UdnZ");
		

		try{
			boolean e0 = e0Obj.getValidation(e0Arg0); // NOPMD by 493736 on 6/29/15 10:28 AM
			//TODO Based on your need, provide necessary assertion condition
		assertEquals(e0, new Object()); // NOPMD by 493736 on 6/29/15 10:28 AM
		}catch(Exception e){
			fail();
		}
	}
	

	@Test
	public void testSequence(){
		FacultyBo e0Obj = new FacultyBo(); // NOPMD by 493736 on 6/29/15 10:28 AM
		FacultyModel e0Arg0 = new FacultyModel(); // NOPMD by 493736 on 6/29/15 10:28 AM
		e0Arg0.setAddress("JMTCB");
		e0Arg0.setFacid("VoIarFs5aZ");
		e0Arg0.setFname("6IXFpT8z5QvL");
		e0Arg0.setExperience(-50);
		e0Arg0.setContact(Long.parseLong("-3397502265920341660"));
		e0Arg0.setEmail("dj7RIK");
		e0Arg0.setSkill("8BNV5C1ugUp4cS8");
		e0Arg0.setQualification("M1RnYpULdmA2DH");
		e0Arg0.setCertificate("8IW7syPXg");
		

		try{
			boolean e0 = e0Obj.getValidation(e0Arg0); // NOPMD by 493736 on 6/29/15 10:28 AM
			//TODO Based on your need, provide necessary assertion condition
		assertEquals(e0, new Object()); // NOPMD by 493736 on 6/29/15 10:28 AM
		}catch(Exception e){
			fail();
		}
	}
	

}
