package com.board.model2.dao;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.board.beans.Board;
import com.ibatis.sqlmap.engine.mapping.result.ResultMap;

public class BoardDao extends CommonDao{
	
	/*
	 * Model 2 sorce
	
	public static BoardDao getInstance()
	{
		BoardDao boardDao = new BoardDao();
		
		return boardDao;
	}
	
	public ArrayList<Board> getBoardList() throws SQLException
	{
		ArrayList<Board> boardArry = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try 
		{
			String sql = "select * from board order by idx desc";
			pstmt = openConnection().prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while(rs.next())
			{
				Board board = new Board();
				board.setIdx(rs.getInt("idx"));
				board.setCount(rs.getInt("count"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setRegdate(rs.getString("regdate"));
				board.setContent(rs.getString("content"));
				
				boardArry.add(board);
			}
			
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			pstmt.close();
			rs.close();
			closeConnection();
		}
		
		return boardArry;
	}
	
	public ArrayList<Board> getContentList(String idx) throws SQLException
	{
		ArrayList<Board> boardArry = new ArrayList<Board>();
		Board board = new Board();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try 
		{
			String sql = "select * from board where idx='"+idx+"'";
			pstmt = openConnection().prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while(rs.next())
			{
				board.setIdx(rs.getInt("idx"));
				board.setCount(rs.getInt("count"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setRegdate(rs.getString("regdate"));
				board.setContent(rs.getString("content"));
				
				boardArry.add(board);
			}
			
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			pstmt.close();
			rs.close();
			closeConnection();
		}
		
		return boardArry;
	}
	
	public void selectDelete(String idx) throws SQLException
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try 
		{
			String sql = "delete from board where idx ='"+idx+"'";
			pstmt = openConnection().prepareStatement(sql);
			rs = pstmt.executeQuery(sql);			
			
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			pstmt.close();
			rs.close();
			closeConnection();
		}
	}	
	 */
	
	public static BoardDao getInstance()
	{
		BoardDao dao = new BoardDao();
		dao.SetDB();
		
		return dao;	
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Board> getAticleList(int page) throws SQLException
	{
		ArrayList<Board> articleList = null;
		//articleList = (ArrayList<Board>)getDB().queryForList("getBoardList", null);

		//pagging 
		articleList = (ArrayList<Board>)getDB().queryForList("getBoardList", null , page,  10);
				
		return articleList;
	}
	
	
	public void deleteSelect(int idx)throws SQLException
	{
		getDB().delete("deleteSelect", idx);
		System.out.println("delete");
	}
	
	public Board getContentInfo(int idx)throws SQLException
	{
		ArrayList<Board> contentInfoList = (ArrayList<Board>)getDB().queryForList("getContentInfo", idx);
		
		int infoSize = contentInfoList.size();
		
		Board contentInfo = new Board();
		if(infoSize > 0)
			contentInfo = contentInfoList.get(0);
		
		return contentInfo;
	}
	
	public void writeBoard(Board board) throws SQLException
	{
		getDB().insert("writeBoard", board);
		System.out.println("write");
	}
	
	public void countAdd(Board infoBoard) throws SQLException
	{			
		getDB().update("countAdd", infoBoard);
		System.out.println("count ++");
	}
	
	public void insertArticle(Board article) throws SQLException
	{
		
		
	}
	
	 
	

}
