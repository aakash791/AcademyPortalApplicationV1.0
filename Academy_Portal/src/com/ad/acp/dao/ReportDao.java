package com.ad.acp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ExceptionMessages;
import com.ad.acp.exception.ReportException;
import com.ad.acp.model.ReportModel;
import com.ad.acp.util.AcpUtil;

public class ReportDao {

	public static final Logger LOGGER=Logger.getLogger(ReportDao.class);
	
	public boolean submitReport(ReportModel reportModel) throws ReportException, AcpUtilException {

		LOGGER.info("Create Connection");
		boolean flag = false;
		Connection connection = AcpUtil.getConnection();

		try {
			LOGGER.info("in try: prepare sql query");
			PreparedStatement preparedStatement = connection.prepareStatement(AcpUtil.ADD_REPORT);

			preparedStatement.setString(1,reportModel.getBatid());
			preparedStatement.setString(2,reportModel.getFacid());
			preparedStatement.setInt(3, reportModel.getWeekRep());
			preparedStatement.setInt(4, reportModel.getMockTest());
			preparedStatement.setString(5, reportModel.getBhsRep());
			preparedStatement.setString(6, reportModel.getInnTitle());
			preparedStatement.setString(7, reportModel.getProDesc());
			preparedStatement.setString(8, reportModel.getProStatus());
			
			int res = preparedStatement.executeUpdate();

			PreparedStatement preparedStatement1 = connection.prepareStatement(AcpUtil.ADD_FACPOINT);
			preparedStatement1.setString(1,reportModel.getBatid());
			preparedStatement1.setString(2,reportModel.getFacid());
			preparedStatement1.setInt(3, reportModel.getPoints());
			
			LOGGER.info("execute sql query");
			int res1 = preparedStatement1.executeUpdate();

			if (res != 0 && res1 != 0) {
				flag = true;
			}
			
			LOGGER.info("close connection");
			preparedStatement1.close();
			preparedStatement.close();
			AcpUtil.closeConnection();

		} catch (SQLException e) {
			LOGGER.warn("in catch: ReportException");
			throw new ReportException(ExceptionMessages.SQL_MSG1);

		}
		
		LOGGER.info("retruning flag");
		return flag;
		
	}

}
