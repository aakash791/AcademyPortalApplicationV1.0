package com.ad.acp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ExceptionMessages;
import com.ad.acp.model.BatchModel;

public class FetchBatchInfo {

	public static BatchModel viewBatchInfo(String batid) throws AcpUtilException {

		Connection connection = AcpUtil.getConnection();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		String domid = null, facid = null, start = null, end = null;

		BatchModel batchModel = new BatchModel();
		Date d = new Date();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(AcpUtil.VIEW_BATCH);
			preparedStatement.setString(1, batid);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				domid = resultSet.getString(1);
				facid = resultSet.getString(2);
				start = resultSet.getDate(3).toString();
				end = resultSet.getDate(4).toString();
			}

			resultSet.close();
			preparedStatement.close();
			AcpUtil.closeConnection();

		} catch (SQLException e) {
			throw new AcpUtilException(ExceptionMessages.SQL_MSG1);
		}

		try {
			d = simpleDateFormat2.parse(start);
			start = simpleDateFormat.format(d);

			d = simpleDateFormat2.parse(end);
			end = simpleDateFormat.format(d);

			batchModel.setBatid(batid);
			batchModel.setDomid(domid);
			batchModel.setFacid(facid);
			batchModel.setBatchStartDate(start);
			batchModel.setBatchEndDate(end);

		} catch (ParseException e) {
			throw new AcpUtilException(ExceptionMessages.DATE_MSG1);
		}

		return batchModel;

	}

}
