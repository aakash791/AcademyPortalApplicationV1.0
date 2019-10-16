package com.ad.acp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ExceptionMessages;

public class FetchFacID {

	public static String viewFacultyId() throws AcpUtilException {

		boolean flag = false;
		String input, fac_id = null;
		Connection connection = AcpUtil.getConnection();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(AcpUtil.ALL_FACID);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getString(1)); // NOPMD by 493736 on 6/24/15 11:48 AM
			}
			do {
				Scanner scanner = new Scanner(System.in);
				input = scanner.nextLine();
				preparedStatement = connection
						.prepareStatement(AcpUtil.FETCH_FACID);
				preparedStatement.setString(1, input);
				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					fac_id = resultSet.getString(1);
					flag = false;
				} else {
					System.out.println("ENTER AGAIN"); // NOPMD by 493736 on 6/27/15 4:12 PM
					flag = true;
				}
			} while (flag);

			resultSet.close();
			preparedStatement.close();
			AcpUtil.closeConnection();
		} catch (SQLException e) {
			throw new AcpUtilException(ExceptionMessages.SQL_MSG1);
		}

		return fac_id;

	}

}
