package com.ad.acp.bo;
import junit.framework.TestCase;

import org.junit.Test;

import com.ad.acp.model.BatchModel;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class BatchBoTest extends TestCase {
	

	@Test //public boolean getValidation(BatchModel)
	public void testGetValidation(){
		BatchBo e0Obj = new BatchBo(); // NOPMD by 493736 on 6/27/15 3:53 PM
		BatchModel e0Arg0 = new BatchModel(); // NOPMD by 493736 on 6/29/15 10:22 AM
		e0Arg0.setFacid("");
		e0Arg0.setDomid("iaTmqtOyh1UNQkZEzT1");
		e0Arg0.setBatid("");
		e0Arg0.setBatchStartDate("7");
		e0Arg0.setBatchEndDate("EaBiidr2dLyngkx");
		e0Arg0.setBatchClosedDate("HZJjP");
		

		try{
			boolean e0 = e0Obj.getValidation(e0Arg0); // NOPMD by 493736 on 6/27/15 3:51 PM
			//TODO Based on your need, provide necessary assertion condition
		assertEquals(e0, new Object()); // NOPMD by 493736 on 6/27/15 3:51 PM
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public boolean getValidation1(BatchModel)
	public void testGetValidation1(){
		BatchBo e0Obj = new BatchBo(); // NOPMD by 493736 on 6/29/15 10:22 AM
		BatchModel e0Arg0 = new BatchModel(); // NOPMD by 493736 on 6/27/15 3:51 PM
		e0Arg0.setFacid("jZpK");
		e0Arg0.setDomid("NQ4aQJbWtfDNXmQ");
		e0Arg0.setBatid("Ad");
		e0Arg0.setBatchStartDate("Ns1O1h1nXYxgoRzO");
		e0Arg0.setBatchEndDate("wok0hJqRYDL");
		e0Arg0.setBatchClosedDate("mpELtxr");
		

		try{
			boolean e0 = e0Obj.getValidation1(e0Arg0); // NOPMD by 493736 on 6/27/15 3:51 PM
			//TODO Based on your need, provide necessary assertion condition
		assertEquals(e0, new Object()); // NOPMD by 493736 on 6/27/15 3:52 PM
		}catch(Exception e){
			fail();
		}
	}
	

	@Test
	public void testSequence(){
		BatchBo e0Obj = new BatchBo(); // NOPMD by 493736 on 6/27/15 3:53 PM
		BatchModel e0Arg0 = new BatchModel(); // NOPMD by 493736 on 6/27/15 3:53 PM
		e0Arg0.setFacid("xrY8WnJFZ");
		e0Arg0.setDomid("cRW1kIzw2XRrhC");
		e0Arg0.setBatid("L09ZLw");
		e0Arg0.setBatchStartDate("SeIhQCIe7");
		e0Arg0.setBatchEndDate("gCqkVl72N");
		e0Arg0.setBatchClosedDate("");
		

		try{
			boolean e0 = e0Obj.getValidation(e0Arg0); // NOPMD by 493736 on 6/27/15 3:51 PM
			//TODO Based on your need, provide necessary assertion condition
		assertEquals(e0, new Object()); // NOPMD by 493736 on 6/27/15 3:51 PM
		}catch(Exception e){
			fail();
		}
		BatchModel e1Arg0 = new BatchModel(); // NOPMD by 493736 on 6/29/15 10:22 AM
		e1Arg0.setFacid("tbnNw6n9WgKMbwG");
		e1Arg0.setDomid("qJjhgSKauXG3WBc");
		e1Arg0.setBatid("f5u");
		e1Arg0.setBatchStartDate("PnKw1MQ");
		e1Arg0.setBatchEndDate("z");
		e1Arg0.setBatchClosedDate("IbUKPiStD2ne0");
		

		try{
			boolean e1 = e0Obj.getValidation1(e1Arg0); // NOPMD by 493736 on 6/27/15 3:51 PM
			//TODO Based on your need, provide necessary assertion condition
		assertEquals(e1, new Object()); // NOPMD by 493736 on 6/29/15 10:22 AM
		}catch(Exception e){
			fail();
		}
	}
	

}
