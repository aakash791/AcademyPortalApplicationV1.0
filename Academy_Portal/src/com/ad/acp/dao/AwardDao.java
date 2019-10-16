package com.ad.acp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.AwardException;
import com.ad.acp.exception.ExceptionMessages;
import com.ad.acp.model.AwardModel;
import com.ad.acp.util.AcpUtil;

public class AwardDao {

	public static final Logger LOGGER=Logger.getLogger(AwardDao.class);
	
	public boolean awardCalculation(AwardModel awardModel) throws AwardException, AcpUtilException  {

		LOGGER.info("connection is created");
		boolean flag=false;
		Connection connection=AcpUtil.getConnection();
		int points = 0;
		String grade = null;
		
		 try {
			LOGGER.info("prepare sql query");
			PreparedStatement preparedStatement=connection.prepareStatement(AcpUtil.GET_POINTS);
			preparedStatement.setString(1, awardModel.getBatid());
			
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()){
				points=resultSet.getInt(1);
			}
			
			points+=awardModel.getPoints();
			
			
			if(points<50){
				grade="E";
			}else if(points>=50 && points<=60){
				grade="D";
			}else if(points>=61 && points<=70){
				grade="C";
			}else if(points>=71 && points<=80){
				grade="B";
			}else if(points>=81 && points<=100){
				grade="A";
			}
			
			LOGGER.info("set grades");
			awardModel.setGrade(grade);
			
			preparedStatement=connection.prepareStatement(AcpUtil.UPDATEPOINTS);
			preparedStatement.setInt(1, points);
			preparedStatement.setString(2, awardModel.getGrade());
			preparedStatement.setString(3, awardModel.getBatid());
			
			LOGGER.info("execute sql query");
			int res=preparedStatement.executeUpdate();
			
			if(res!=0){
				flag=true;
			}
			
			LOGGER.info("closing connection");
			resultSet.close();
			preparedStatement.close();			
		} catch (SQLException e) {
			LOGGER.warn("in catch AwardException");
			throw new AwardException(ExceptionMessages.SQL_MSG1);
		}
		 
		
		return flag;
	}

}
