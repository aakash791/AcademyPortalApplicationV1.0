package com.ad.acp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ExceptionMessages;

public class FetchFacRepId {

	public static String viewFacRepId(String batid) throws AcpUtilException {

		String fac_id = null;
		Connection connection = AcpUtil.getConnection();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(AcpUtil.VIEW_FACBAT);
			preparedStatement.setString(1, batid);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				fac_id = resultSet.getString(1);

			resultSet.close();
			preparedStatement.close();
			AcpUtil.closeConnection();
		} catch (SQLException e) {
			throw new AcpUtilException(ExceptionMessages.SQL_MSG1);
		}

		return fac_id;

	}

}
