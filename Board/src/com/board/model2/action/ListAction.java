package com.board.model2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model2.controller.CommandAction;
import com.board.model2.dao.BoardDao;

public class ListAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		BoardDao boardDao = BoardDao.getInstance();
		
		int page = 0;
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("boardArray", boardDao.getAticleList(page));			
		request.setAttribute("page", page);
		
		
		return "index.jsp";
	}

}
