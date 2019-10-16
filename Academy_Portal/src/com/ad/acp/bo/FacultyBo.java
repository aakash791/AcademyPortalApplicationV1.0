package com.ad.acp.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ad.acp.dao.FacultyDao;
import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ExceptionMessages;
import com.ad.acp.exception.FacultyException;
import com.ad.acp.model.FacultyModel;
import com.ad.acp.util.AcpUtil;

public class FacultyBo {

	public static final Logger LOGGER=Logger.getLogger(FacultyBo.class);
	public boolean getValidation(FacultyModel facultyModel) throws FacultyException,  AcpUtilException { // NOPMD by 493736 on 6/29/15 10:22 AM

		LOGGER.info("Generating Faculty id");
		boolean flag = false; // NOPMD by 493736 on 6/29/15 10:23 AM
		Connection connection = AcpUtil.getConnection(); // NOPMD by 493736 on 6/29/15 10:23 AM
		String old_faculty_id, new_faculty_id = null, id; // NOPMD by 493736 on 6/29/15 10:23 AM

		try {
			LOGGER.info("Fetching last Faculty Id");
			PreparedStatement preparedStatement = connection // NOPMD by 493736 on 6/29/15 10:23 AM
					.prepareStatement(AcpUtil.LAST_ID);
			ResultSet resultSet = preparedStatement.executeQuery(); // NOPMD by 493736 on 6/29/15 10:23 AM
			if (resultSet.next()) {
				old_faculty_id = resultSet.getString(1);
				int temp = Integer.parseInt(old_faculty_id); // NOPMD by 493736 on 6/29/15 10:23 AM
				temp++;
				id = String.valueOf(temp);
				if (id.length() == 1) // NOPMD by 493736 on 6/29/15 10:23 AM
					id = "00".concat(id);
				if (id.length() == 2) // NOPMD by 493736 on 6/29/15 10:23 AM
					id = "0".concat(id);
				LOGGER.info("Set new faculty id");
				new_faculty_id = facultyModel.getFname().concat("#").concat(id);
			} else {
				LOGGER.info("Set new faculty id");
				new_faculty_id = facultyModel.getFname().concat("#")
						.concat("001");
			}
			LOGGER.info("calling addfacult() of FacultyDao");
			facultyModel.setFacid(new_faculty_id);
			FacultyDao facultyDao=new FacultyDao(); // NOPMD by 493736 on 6/29/15 10:23 AM
			if(facultyDao.addFaculty(facultyModel)){
				flag=true; // NOPMD by 493736 on 6/29/15 10:23 AM
			}
			
			LOGGER.info("closing connection");
			resultSet.close();
			preparedStatement.close();
			AcpUtil.closeConnection();
		} catch (SQLException e) {
			LOGGER.warn("in catch FacultyBo");
			throw new FacultyException(ExceptionMessages.SQL_MSG1); // NOPMD by 493736 on 6/29/15 10:23 AM
			
		}
		LOGGER.info("returning falg");
		return flag;

	}

}
