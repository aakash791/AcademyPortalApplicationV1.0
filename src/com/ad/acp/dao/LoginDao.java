package com.ad.acp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ExceptionMessages;
import com.ad.acp.exception.LoginException;
import com.ad.acp.model.LoginModel;
import com.ad.acp.util.AcpUtil;


public class LoginDao {

	public static final Logger LOGGER=Logger.getLogger(LoginDao.class);
	
	public boolean verifyadmin(LoginModel loginModel) throws LoginException, AcpUtilException {

		LOGGER.info("In LoginDao verifyAdmin()");		
		boolean flag=false;
		Connection connection=AcpUtil.getConnection();
		
		try {
			LOGGER.info("prepare sql query");
			PreparedStatement preparedStatement=connection.prepareStatement(AcpUtil.GET_ADMIN);
			preparedStatement.setString(1, loginModel.getUsername());
			preparedStatement.setString(2, loginModel.getPassword());
			
			LOGGER.info("execute sql query");
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				flag=true;
			}
			
			LOGGER.info("closing all connection");
			resultSet.close();
			preparedStatement.close();
			AcpUtil.closeConnection();
		} catch (SQLException e) {
			LOGGER.warn("in catch (loginException)");
			throw new LoginException(ExceptionMessages.SQL_MSG1);
		}
		
		
		return flag;
	}

}
