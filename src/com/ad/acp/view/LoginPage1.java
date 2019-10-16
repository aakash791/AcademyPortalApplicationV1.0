package com.ad.acp.view;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ad.acp.model.LoginModel;

public class LoginPage1 {

	public static final Logger LOGGER=Logger.getLogger(LoginPage1.class);
	
	public LoginModel viewLoginPage1() {
		
		LOGGER.info("show welcome screen");
		Scanner scanner=new Scanner(System.in);
		String username,password;
		System.out.println("************WELCOME***********"); // NOPMD by 493736 on 6/27/15 5:33 PM
		System.out.println("ENTER USERNAME: "); // NOPMD by 493736 on 6/27/15 5:33 PM
		username = scanner.nextLine();
		System.out.println("ENTER PASSWORD: "); // NOPMD by 493736 on 6/27/15 5:33 PM
		password = scanner.nextLine();
		LOGGER.info("setting username and password in LoginModel");
		LoginModel loginModel=new LoginModel();
		loginModel.setUsername(username);
		loginModel.setPassword(password);
		LOGGER.info("returning loginModel");
		
		return loginModel;
	}
}
