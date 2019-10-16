package com.ad.acp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ExceptionMessages;
import com.ad.acp.model.BatchModel;
import com.ad.acp.util.AcpUtil;

public class BatchDao {

	public static final Logger LOGGER=Logger.getLogger(BatchDao.class);
	
	public boolean batchAlloc(BatchModel batchModel) throws  AcpUtilException {

	    LOGGER.info("Create Connection");	
		boolean flag=false;
		Connection connection=AcpUtil.getConnection();
		
		try {
			LOGGER.info("create SQL query");
			PreparedStatement preparedStatement=connection.prepareStatement(AcpUtil.ADD_BATCH1);
			preparedStatement.setString(1, batchModel.getBatid());
			preparedStatement.setString(2, batchModel.getDomid());
			preparedStatement.setString(3, batchModel.getFacid());
			java.sql.Date sd=new java.sql.Date(new SimpleDateFormat("dd-MMM-yyyy").parse(batchModel.getBatchStartDate()).getTime());
			preparedStatement.setDate(4,sd);
			java.sql.Date sd1=new java.sql.Date(new SimpleDateFormat("dd-MMM-yyyy").parse(batchModel.getBatchEndDate()).getTime());
			preparedStatement.setDate(5,sd1);
			
			LOGGER.info("execute query");
			int res=preparedStatement.executeUpdate();
			
			if(res!=0){
				flag=true;
			}
			LOGGER.info("closing connection");
			preparedStatement.close();
			AcpUtil.closeConnection();
			
		} catch (SQLException e) {
			LOGGER.warn("in catch AcpUtilException");
			throw new AcpUtilException(ExceptionMessages.SQL_MSG1);
		} catch (ParseException e) {
			LOGGER.warn("in catch AcpUtilException");
			throw new AcpUtilException(ExceptionMessages.DATE_MSG1);
		}
		LOGGER.warn("returning flag");
		return flag;
	}
	
	public boolean batchUpdate(BatchModel batchModel) throws  AcpUtilException {

		  LOGGER.info("Create Connection");	
		boolean flag = false;
		Connection connection = AcpUtil.getConnection();
		Date d = new Date();
		try {
			LOGGER.info("create SQL query");
			PreparedStatement preparedStatement = connection
					.prepareStatement(AcpUtil.ADD_CLOSED_DATE);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"dd-MMM-yyyy");

			d = simpleDateFormat.parse(batchModel.getBatchClosedDate());

			java.sql.Date sd = new java.sql.Date(d.getTime());
			preparedStatement.setDate(1, sd);
			preparedStatement.setString(2, batchModel.getBatid());

			LOGGER.info("execute query");
			int res = preparedStatement.executeUpdate();
			if (res != 0) {
				flag = true;
			}

			LOGGER.info("closing connection");
			preparedStatement.close();
			AcpUtil.closeConnection();
		} catch (SQLException e) {
			LOGGER.warn("in catch AcpUtilException");
			throw new AcpUtilException(ExceptionMessages.SQL_MSG1);

		} catch (ParseException e) {
			LOGGER.warn("in catch AcpUtilException");
			throw new AcpUtilException(ExceptionMessages.DATE_MSG1);
		}

		LOGGER.warn("returning flag");
		return flag;
	}

}
