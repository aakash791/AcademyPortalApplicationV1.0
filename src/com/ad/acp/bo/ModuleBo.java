package com.ad.acp.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ad.acp.dao.ModuleDao;
import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ExceptionMessages;
import com.ad.acp.exception.ModuleException;
import com.ad.acp.model.ModuleModel;
import com.ad.acp.util.AcpUtil;

public class ModuleBo { // NOPMD by 493736 on 6/29/15 10:28 AM

	public static final Logger LOGGER=Logger.getLogger(ModuleBo.class); 
	
	public boolean getValidation(ModuleModel moduleModel) throws ModuleException, AcpUtilException { // NOPMD by 493736 on 6/29/15 10:28 AM

		LOGGER.info("Generate Tech ID and Domain ID");
		boolean flag = false; // NOPMD by 493736 on 6/29/15 10:29 AM
		Connection connection = AcpUtil.getConnection(); // NOPMD by 493736 on 6/29/15 10:28 AM
		String tech_id = null, dom_id = null,id; // NOPMD by 493736 on 6/29/15 10:29 AM

		try {
			LOGGER.info("Fetch Last Tech ID");
			PreparedStatement preparedStatement = connection // NOPMD by 493736 on 6/29/15 10:28 AM
					.prepareStatement(AcpUtil.LAST_MID1);
			ResultSet resultSet = preparedStatement.executeQuery(); // NOPMD by 493736 on 6/29/15 10:28 AM
			if (resultSet.next()) {
				id = resultSet.getString(1);
				int temp = Integer.parseInt(id); // NOPMD by 493736 on 6/29/15 10:29 AM
				temp++;
				tech_id = String.valueOf(temp);
				if (tech_id.length() == 1) // NOPMD by 493736 on 6/29/15 10:29 AM
					tech_id = "00".concat(tech_id);
				if (tech_id.length() == 2) // NOPMD by 493736 on 6/29/15 10:29 AM
					tech_id = "0".concat(tech_id);
				LOGGER.info("Set new Tech_Id");
				tech_id = moduleModel.getTname().concat("#").concat(tech_id);
			} else {
				LOGGER.info("Set new Tech_Id");
				tech_id = moduleModel.getTname().concat("#").concat("001"); // NOPMD by 493736 on 6/29/15 10:28 AM
			}
			
			
			LOGGER.info("Fetch Last Domain ID");
			PreparedStatement preparedStatement1 = connection // NOPMD by 493736 on 6/29/15 10:28 AM
					.prepareStatement(AcpUtil.LAST_MID2);
			ResultSet resultSet1 = preparedStatement1.executeQuery(); // NOPMD by 493736 on 6/29/15 10:28 AM
			if (resultSet1.next()) {
				id = resultSet.getString(1);
				int temp = Integer.parseInt(id);
				temp++;
				dom_id = String.valueOf(temp);
				if (dom_id.length() == 1) // NOPMD by 493736 on 6/29/15 10:29 AM
					dom_id = "00".concat(dom_id);
				if (dom_id.length() == 2) // NOPMD by 493736 on 6/29/15 10:29 AM
					dom_id = "0".concat(dom_id);
				LOGGER.info("Set new Domain_Id");
				dom_id = moduleModel.getDomain().concat("#").concat(dom_id);
			} else {
				LOGGER.info("Set new Domain_Id");
				dom_id = moduleModel.getDomain().concat("#").concat("001"); // NOPMD by 493736 on 6/29/15 10:29 AM
			}

			LOGGER.info("closing connection");
			resultSet1.close();
			preparedStatement1.close();
			resultSet.close();
			preparedStatement.close();
			AcpUtil.closeConnection();
		} catch (SQLException e) {
			LOGGER.warn("in catch ModuleException");
			throw new ModuleException(ExceptionMessages.SQL_MSG1); // NOPMD by 493736 on 6/29/15 10:28 AM
		}
		
		moduleModel.setTechid(tech_id);
		moduleModel.setDomid(dom_id);

		LOGGER.info("calling addModule() of ModuleDao");
		if (ModuleDao.addModule(moduleModel)) {
			flag = true;
		}

		LOGGER.info("returning flag");
		return flag;
	}

}
