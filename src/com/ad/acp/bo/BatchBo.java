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
	
	public boolean getValidation(BatchModel batchModel) throws AcpUtilException, BatchException { // NOPMD by 493736 on 6/27/15 3:48 PM

		LOGGER.info("Generate Batch Id");
		boolean flag = false; // NOPMD by 493736 on 6/27/15 3:49 PM
		Connection connection = AcpUtil.getConnection(); // NOPMD by 493736 on 6/27/15 3:48 PM
		String old_batch_id, new_batch_id = null, id, dom_name = null; // NOPMD by 493736 on 6/27/15 3:49 PM
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy"); // NOPMD by 493736 on 6/27/15 3:49 PM
		Date jd = new Date(); // NOPMD by 493736 on 6/27/15 3:49 PM

		try {
			LOGGER.info("fetch last Batch ID");
			PreparedStatement preparedStatement1 = connection // NOPMD by 493736 on 6/27/15 3:49 PM
					.prepareStatement(AcpUtil.DOM_NAME);
			preparedStatement1.setString(1, batchModel.getDomid());
			ResultSet resultSet1 = preparedStatement1.executeQuery(); // NOPMD by 493736 on 6/27/15 3:49 PM

			if (resultSet1.next()) // NOPMD by 493736 on 6/27/15 3:49 PM
				dom_name = resultSet1.getString(1);

			PreparedStatement preparedStatement = connection // NOPMD by 493736 on 6/27/15 3:49 PM
					.prepareStatement(AcpUtil.LAST_BATCHID);
			ResultSet resultSet = preparedStatement.executeQuery(); // NOPMD by 493736 on 6/27/15 3:49 PM
			if (resultSet.next()) {
				old_batch_id = resultSet.getString(1);
				int temp = Integer.parseInt(old_batch_id); // NOPMD by 493736 on 6/27/15 3:50 PM
				temp++;
				id = String.valueOf(temp);
				if (id.length() == 1) // NOPMD by 493736 on 6/27/15 3:49 PM
					id = "00".concat(id);
				if (id.length() == 2) // NOPMD by 493736 on 6/27/15 3:49 PM
					id = "0".concat(id);
				jd = new SimpleDateFormat("dd-MMM-yyyy").parse(batchModel // NOPMD by 493736 on 6/27/15 3:49 PM
						.getBatchStartDate());
				LOGGER.info("Set new batch ID");
				new_batch_id = dom_name.concat(simpleDateFormat.format(jd))
						.concat(id);
			} else {
				jd = new SimpleDateFormat("dd-MMM-yyyy").parse(batchModel // NOPMD by 493736 on 6/27/15 3:49 PM
						.getBatchStartDate());
				LOGGER.info("Set new batch ID");
				new_batch_id = dom_name.concat(simpleDateFormat.format(jd))
						.concat("001");
			}

			batchModel.setBatid(new_batch_id);
			BatchDao batchDao = new BatchDao(); // NOPMD by 493736 on 6/27/15 3:50 PM
			LOGGER.info("calling batchAlloc() of BatchDao");
			if (batchDao.batchAlloc(batchModel)) {
				flag = true; // NOPMD by 493736 on 6/27/15 3:50 PM
			}
			
			LOGGER.info("closing connection");
			resultSet.close();
			preparedStatement.close();
			resultSet1.close();
			preparedStatement1.close();
			AcpUtil.closeConnection();
		} catch (SQLException e) {
			LOGGER.warn("in catch BatchException");
			throw new BatchException(ExceptionMessages.SQL_MSG1); // NOPMD by 493736 on 6/27/15 3:49 PM

		} catch (ParseException e) {
			LOGGER.warn("in catch BatchException");
			throw new BatchException(ExceptionMessages.DATE_MSG1); // NOPMD by 493736 on 6/27/15 3:49 PM
		}
		LOGGER.warn("returning flag");
		return flag;

	}

	public boolean getValidation1(BatchModel batchModel) throws BatchException, AcpUtilException { // NOPMD by 493736 on 6/27/15 3:49 PM

		boolean flag = false; // NOPMD by 493736 on 6/27/15 3:50 PM
		BatchDao batchDao = new BatchDao(); // NOPMD by 493736 on 6/27/15 3:50 PM
		LOGGER.info("calling batchUpdate() of BatchDao");
		if (batchDao.batchUpdate(batchModel)) {
			flag = true;
		}

		LOGGER.warn("returning flag");
		return flag;
	}

}
