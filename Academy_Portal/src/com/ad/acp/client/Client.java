package com.ad.acp.client;

import com.ad.acp.controller.LoginController;

public class Client {

	public static void main(String[] args) {

		LoginController loginController=new LoginController();
		loginController.excuteFrontController();
		
	}

}
