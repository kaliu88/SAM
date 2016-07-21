package com.board.model2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.model2.controller.CommandAction;
import com.board.model2.dao.BoardDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class insertAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr"); 		
		
		MultipartRequest multiRequest = null;
		
		int sizeLimit = 10 * 1024 * 1024;
		
		String savePath = request.getSession().getServletContext().getRealPath("/upload");
		
		try 
		{
			multiRequest = new MultipartRequest(request, savePath, sizeLimit, "euc-kr", new DefaultFileRenamePolicy());
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String title = multiRequest.getParameter("title");
		String content = multiRequest.getParameter("content");
		String regdate = multiRequest.getParameter("regdate");
		String writer	= multiRequest.getParameter("writer");
		String filename = multiRequest.getParameter("fileName");
		String regIP = request.getRemoteAddr();	
		
		Board writeBoard = new Board();
		
		writeBoard.setTitle(title);
		writeBoard.setWriter(writer);
		writeBoard.setRegdate(regdate);
		writeBoard.setContent(content);
		writeBoard.setRegip(regIP);
		writeBoard.setFilename(filename);
		
		
		BoardDao dao = BoardDao.getInstance();
		dao.writeBoard(writeBoard);
		
		return "insert.jsp";
	}

}
