package com.board.db.sqlconfig;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public final class IBatisDBConnector {
	private static SqlMapClient mySQLMap;
	
	static
	{
		try 
		{
			String resource = "com/board/db/sqlconfig/SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);				
			mySQLMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static SqlMapClient getSqlMapInstance()
	{
		return mySQLMap;
	}
}
