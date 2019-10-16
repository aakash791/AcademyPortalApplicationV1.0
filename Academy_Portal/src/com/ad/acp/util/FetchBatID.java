package com.ad.acp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ExceptionMessages;

public class FetchBatID {

	public static String viewBatID(String facid) throws AcpUtilException {

		Connection connection = AcpUtil.getConnection();
		String batid = null;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(AcpUtil.GET_BATID);
			preparedStatement.setString(1, facid);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				batid = resultSet.getString(1);
			}

			resultSet.close();
			preparedStatement.close();
			AcpUtil.closeConnection();
		} catch (SQLException e) {
			throw new AcpUtilException(ExceptionMessages.SQL_MSG1);
		}

		return batid;
	}

}
