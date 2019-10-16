package com.ad.acp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.ad.acp.exception.AcpUtilException;
import com.ad.acp.exception.ExceptionMessages;

public class AcpUtil {

	public static Connection connection = null;
	public static final String GET_ADMIN = "SELECT USERNAME FROM LOGIN WHERE USERNAME=? AND PASSWORD=?";
	public static final String LAST_ID = "SELECT RIGHT(FAC_ID,3) AS ID FROM FACULTY_REGISTRATION ORDER BY ID DESC";
	public static final String ADD_FACULTY1 = "INSERT INTO FACULTY_REGISTRATION VALUES(?,?,?,?,?,?,?)";
	public static final String ADD_FACULTY2 = "INSERT INTO FACULTY_SKILL VALUES(?,?,?)";
	public static final String LAST_MID1 = "SELECT RIGHT(TECH_ID,3) AS ID FROM TECHNOLOGY_MASTER ORDER BY TECH_ID DESC";
	public static final String LAST_MID2 = "SELECT RIGHT(DOM_ID,3) AS ID FROM DOMAIN_MASTER ORDER BY DOM_ID DESC";
	public static final String ADD_TECH = "INSERT INTO TECHNOLOGY_MASTER VALUES(?,?)";
	public static final String ADD_DOM = "INSERT INTO DOMAIN_MASTER VALUES(?,?)";
	public static final String ALL_DOMID = "SELECT DOM_ID FROM DOMAIN_MASTER";
	public static final String FETCH_DOMID = "SELECT DOM_ID FROM DOMAIN_MASTER WHERE DOM_ID=?";
	public static final String DOM_NAME = "SELECT MOD_DOMAIN_DESC FROM DOMAIN_MASTER WHERE DOM_ID=?";
	public static final String ALL_FACID = "SELECT FAC_ID FROM FACULTY_REGISTRATION WHERE FAC_ID NOT IN (SELECT FAC_ID FROM BATCH_ALLOCATION1)";
	public static final String FETCH_FACID = "SELECT FAC_ID FROM FACULTY_REGISTRATION WHERE FAC_ID=?";
	public static final String LAST_BATCHID = "SELECT RIGHT(BAT_ID,3) AS ID FROM BATCH_ALLOCATION1 ORDER BY ID DESC";
    public static final String ADD_BATCH1="INSERT INTO BATCH_ALLOCATION1(BAT_ID, DOM_ID, FAC_ID, BAT_START_DATE, BAT_END_DATE) VALUES(?,?,?,?,?)";
	public static final String VIEW_BATCH="SELECT DOM_ID,FAC_ID, BAT_START_DATE, BAT_END_DATE FROM BATCH_ALLOCATION1 WHERE BAT_ID=?";
    public static final String ADD_CLOSED_DATE="UPDATE BATCH_ALLOCATION1 SET BAT_CLOSED_DATE=? WHERE BAT_ID=?";
	public static final String ADD_REPORT="INSERT INTO REPORT_DETAILS1 VALUES(?,?,?,?,?,?,?,?)";
    public static final String ADD_FACPOINT="INSERT INTO FACULTY_POINTS1(BAT_ID,FAC_ID,CREDIT_POINTS) VALUES(?,?,?)";
    public static final String VIEW_FACBAT="SELECT FAC_ID FROM BATCH_ALLOCATION1 WHERE BAT_ID=?";
    public static final String VIEW_BATCODE="SELECT BAT_ID FROM BATCH_ALLOCATION1 WHERE BAT_CLOSED_DATE IS NULL OR DATEDIFF(BAT_CLOSED_DATE,BAT_END_DATE)>=7";
	public static final String FETCH_BATCODE="SELECT BAT_ID FROM BATCH_ALLOCATION1 WHERE BAT_ID=?";
    public static final String GET_DOMNAME="SELECT MOD_DOMAIN_DESC FROM DOMAIN_MASTER INNER JOIN BATCH_ALLOCATION1 ON DOMAIN_MASTER.DOM_ID=BATCH_ALLOCATION1.DOM_ID WHERE BATCH_ALLOCATION1.FAC_ID=?";
	public static final String GET_BATID="SELECT BAT_ID FROM BATCH_ALLOCATION1 WHERE FAC_ID=?";
	public static final String GET_FACID="SELECT FAC_ID FROM BATCH_ALLOCATION1";
	public static final String GET_POINTS="SELECT CREDIT_POINTS FROM FACULTY_POINTS1 WHERE BAT_ID=?";
	public static final String UPDATEPOINTS="UPDATE FACULTY_POINTS1 SET CREDIT_POINTS=? , GRADE=? WHERE BAT_ID=?";
    
	public static Connection getConnection() throws AcpUtilException  {

		ResourceBundle rb = ResourceBundle.getBundle("db");

		try {
			Class.forName(rb.getString("driver"));
			connection = DriverManager.getConnection(rb.getString("url"),
					rb.getString("user"), rb.getString("pass"));
		} catch (ClassNotFoundException e) {

			throw new AcpUtilException(ExceptionMessages.SQL_MSG2);
		} catch (SQLException e) {

			throw new AcpUtilException(ExceptionMessages.SQL_MSG1);
		}

		return connection;
	}

	public static void closeConnection() throws AcpUtilException  {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new AcpUtilException(ExceptionMessages.SQL_MSG1);
		}
	}

}
