package com.board.model2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.board.db.sqlconfig.IBatisDBConnector;
import com.ibatis.sqlmap.client.SqlMapClient;

public class CommonDao {
	/*
	 * model2 DB Connection
	 * 
	private final String driverName = "oracle.jdbc.driver.OracleDriver";
	private final String url	= "jdbc:oracle:thin:@localhost:1521:ORCL";
	
	private Connection con = null;
	public Connection openConnection()
	{
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, "system", "enovia");
			System.out.println("Oracle 연결완료");
			
		} catch (Exception e) {
			// TODO Auto	-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public void closeConnection() throws SQLException
	{
		if(!con.isClosed())
			con.close();
	}
	*/
	
	/*
	 * IBatis DB 연결
	 */
	
	private SqlMapClient myDB;
	
	public void SetDB()
	{
		//IBatisDBConnector test = new IBatisDBConnector();
		myDB = IBatisDBConnector.getSqlMapInstance();
	}
	
	protected SqlMapClient getDB()
	{
		return myDB;
	}
}
