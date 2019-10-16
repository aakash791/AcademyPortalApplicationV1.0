package com.ad.acp.view;

import com.ad.acp.exception.AcpUtilException;

public class AcpUtilMessages {

	public static void displayAcpUtilExceptMsg(AcpUtilException acpUtilException) {
		System.out.println(acpUtilException.getMessage()); // NOPMD by 493736 on 6/27/15 4:12 PM
	}
}
