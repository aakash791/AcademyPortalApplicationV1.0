package com.ad.acp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ExceptionMessages;

public class FetchAwaDomName {

	public static String viewAwaDomName(String facid) throws AcpUtilException {
		
		Connection connection=AcpUtil.getConnection();
		String dname = null;
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(AcpUtil.GET_DOMNAME);
			preparedStatement.setString(1, facid);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()){
				dname=resultSet.getString(1);
			}
			
			resultSet.close();
			preparedStatement.close();
			AcpUtil.closeConnection();
		} catch (SQLException e) {
		
			throw new AcpUtilException(ExceptionMessages.SQL_MSG1);
			
		}
		
		return dname;
	}

}
