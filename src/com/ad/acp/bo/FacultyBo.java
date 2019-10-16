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
	public boolean getValidation(FacultyModel facultyModel) throws FacultyException,  AcpUtilException {  

		LOGGER.info("Generating Faculty id");
		boolean flag = false;  
		Connection connection = AcpUtil.getConnection();  
		String old_faculty_id, new_faculty_id = null, id;  

		try {
			LOGGER.info("Fetching last Faculty Id");
			PreparedStatement preparedStatement = connection  
					.prepareStatement(AcpUtil.LAST_ID);
			ResultSet resultSet = preparedStatement.executeQuery();  
			if (resultSet.next()) {
				old_faculty_id = resultSet.getString(1);
				int temp = Integer.parseInt(old_faculty_id);  
				temp++;
				id = String.valueOf(temp);
				if (id.length() == 1)  
					id = "00".concat(id);
				if (id.length() == 2)  
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
			FacultyDao facultyDao=new FacultyDao();  
			if(facultyDao.addFaculty(facultyModel)){
				flag=true;  
			}
			
			LOGGER.info("closing connection");
			resultSet.close();
			preparedStatement.close();
			AcpUtil.closeConnection();
		} catch (SQLException e) {
			LOGGER.warn("in catch FacultyBo");
			throw new FacultyException(ExceptionMessages.SQL_MSG1);  
			
		}
		LOGGER.info("returning falg");
		return flag;

	}

}
