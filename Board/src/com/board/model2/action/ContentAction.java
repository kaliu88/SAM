package com.board.model2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model2.controller.CommandAction;
import com.board.model2.dao.BoardDao;

public class ContentAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		BoardDao boardDao = BoardDao.getInstance();
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		String page = request.getParameter("page");
		
		request.setAttribute("content", boardDao.getContentInfo(idx));
		request.setAttribute("page", page);
		
		return "content.jsp";
	}

}
