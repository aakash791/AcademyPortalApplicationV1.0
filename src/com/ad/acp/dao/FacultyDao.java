package com.ad.acp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ExceptionMessages;
import com.ad.acp.exception.FacultyException;
import com.ad.acp.model.FacultyModel;
import com.ad.acp.util.AcpUtil;

public class FacultyDao {

	public static final Logger LOGGER=Logger.getLogger(FacultyDao.class);
	
	public boolean addFaculty(FacultyModel facultyModel) throws FacultyException, AcpUtilException {
		
		LOGGER.info("Creating Connection in FacultyDao addFaculty()");
		boolean flag=false;
		Connection connection=AcpUtil.getConnection();
		
		try {
			LOGGER.info("Preparing SQL query");
			PreparedStatement preparedStatement=connection.prepareStatement(AcpUtil.ADD_FACULTY1);
			preparedStatement.setString(1, facultyModel.getFacid());
			preparedStatement.setString(2, facultyModel.getFname());
			preparedStatement.setString(3, facultyModel.getQualification());
			preparedStatement.setInt(4, facultyModel.getExperience());
			preparedStatement.setLong(5, facultyModel.getContact());
			preparedStatement.setString(6, facultyModel.getEmail());
			preparedStatement.setString(7, facultyModel.getAddress());
			
			int res=preparedStatement.executeUpdate();
			
			PreparedStatement preparedStatement1=connection.prepareStatement(AcpUtil.ADD_FACULTY2);
			preparedStatement1.setString(1, facultyModel.getFacid());
			preparedStatement1.setString(2, facultyModel.getSkill());
			preparedStatement1.setString(3, facultyModel.getCertificate());
			
			LOGGER.info("execute query");
			int res1=preparedStatement1.executeUpdate();
			
			if(res!=0 && res1!=0){
				flag=true;
			}
			LOGGER.info("closing connection");
			preparedStatement1.close();
			preparedStatement.close();
			AcpUtil.closeConnection();
		} catch (SQLException e) {
			LOGGER.warn("in catch FacultyDao");
			throw new FacultyException(ExceptionMessages.SQL_MSG1);
		}
		return flag;
	}

}
