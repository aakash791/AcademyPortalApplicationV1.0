package com.ad.acp.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.ad.acp.dao.BatchDao;
import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.BatchException;
import com.ad.acp.exception.ExceptionMessages;
import com.ad.acp.model.BatchModel;
import com.ad.acp.util.AcpUtil;

public class BatchBo {

	public static final Logger LOGGER=Logger.getLogger(BatchBo.class);
	
	public boolean getValidation(BatchModel batchModel) throws AcpUtilException, BatchException { 

		LOGGER.info("Generate Batch Id");
		boolean flag = false; 
		Connection connection = AcpUtil.getConnection();  
		String old_batch_id, new_batch_id = null, id, dom_name = null;  
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy");  
		Date jd = new Date();  

		try {
			LOGGER.info("fetch last Batch ID");
			PreparedStatement preparedStatement1 = connection  
					.prepareStatement(AcpUtil.DOM_NAME);
			preparedStatement1.setString(1, batchModel.getDomid());
			ResultSet resultSet1 = preparedStatement1.executeQuery();  

			if (resultSet1.next())  
				dom_name = resultSet1.getString(1);

			PreparedStatement preparedStatement = connection  
					.prepareStatement(AcpUtil.LAST_BATCHID);
			ResultSet resultSet = preparedStatement.executeQuery();  
			if (resultSet.next()) {
				old_batch_id = resultSet.getString(1);
				int temp = Integer.parseInt(old_batch_id);  
				temp++;
				id = String.valueOf(temp);
				if (id.length() == 1)  
					id = "00".concat(id);
				if (id.length() == 2)  
					id = "0".concat(id);
				jd = new SimpleDateFormat("dd-MMM-yyyy").parse(batchModel  
						.getBatchStartDate());
				LOGGER.info("Set new batch ID");
				new_batch_id = dom_name.concat(simpleDateFormat.format(jd))
						.concat(id);
			} else {
				jd = new SimpleDateFormat("dd-MMM-yyyy").parse(batchModel  
						.getBatchStartDate());
				LOGGER.info("Set new batch ID");
				new_batch_id = dom_name.concat(simpleDateFormat.format(jd))
						.concat("001");
			}

			batchModel.setBatid(new_batch_id);
			BatchDao batchDao = new BatchDao();  
			LOGGER.info("calling batchAlloc() of BatchDao");
			if (batchDao.batchAlloc(batchModel)) {
				flag = true;  
			}
			
			LOGGER.info("closing connection");
			resultSet.close();
			preparedStatement.close();
			resultSet1.close();
			preparedStatement1.close();
			AcpUtil.closeConnection();
		} catch (SQLException e) {
			LOGGER.warn("in catch BatchException");
			throw new BatchException(ExceptionMessages.SQL_MSG1);  

		} catch (ParseException e) {
			LOGGER.warn("in catch BatchException");
			throw new BatchException(ExceptionMessages.DATE_MSG1);  
		}
		LOGGER.warn("returning flag");
		return flag;

	}

	public boolean getValidation1(BatchModel batchModel) throws BatchException, AcpUtilException {  

		boolean flag = false;  
		BatchDao batchDao = new BatchDao();  
		LOGGER.info("calling batchUpdate() of BatchDao");
		if (batchDao.batchUpdate(batchModel)) {
			flag = true;
		}

		LOGGER.warn("returning flag");
		return flag;
	}

}
