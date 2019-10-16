package com.ad.acp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ExceptionMessages;
import com.ad.acp.exception.ModuleException;
import com.ad.acp.model.ModuleModel;
import com.ad.acp.util.AcpUtil;

public class ModuleDao {

	public static final Logger LOGGER=Logger.getLogger(ModuleDao.class);
	
	public static boolean addModule(ModuleModel moduleModel) throws ModuleException, AcpUtilException {
		
		LOGGER.info("Create Connection");
		boolean flag = false;
		Connection connection = AcpUtil.getConnection();

		try {
			LOGGER.info("Prepare sql query");
			PreparedStatement preparedStatement = connection
					.prepareStatement(AcpUtil.ADD_TECH);

			preparedStatement.setString(1,
					String.valueOf(moduleModel.getTechid()));

			preparedStatement.setString(2,
					String.valueOf(moduleModel.getTname()));

			int res = preparedStatement.executeUpdate();

			PreparedStatement preparedStatement1 = connection
					.prepareStatement(AcpUtil.ADD_DOM);
			preparedStatement1.setString(1,
					String.valueOf(moduleModel.getDomid()));
			preparedStatement1.setString(2,
					String.valueOf(moduleModel.getDomain()));

			LOGGER.info("execute sql query");
			int res1 = preparedStatement1.executeUpdate();

			if (res != 0 && res1 != 0) {
				flag = true;
			}
			
			LOGGER.info("closing connection");
			preparedStatement1.close();
			preparedStatement.close();
			AcpUtil.closeConnection();

		} catch (SQLException e) {
			LOGGER.warn("in catch ModuleException");
			throw new ModuleException(ExceptionMessages.SQL_MSG1);

		}

		return flag;
	}

}
