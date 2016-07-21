package com.board.model2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.model2.controller.CommandAction;
import com.board.model2.dao.BoardDao;
import com.board.util.BoardUtil;

public class CountAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int idx = 0;
		
		if(BoardUtil.isNumber(request.getParameter("idx")))
			idx = Integer.parseInt(request.getParameter("idx"));
		
		int page = 0; 
		if(BoardUtil.isNumber(request.getParameter("idx")))
			page = Integer.parseInt(request.getParameter("page"));
			
			
		BoardDao dao = BoardDao.getInstance();
		Board infoBoard = dao.getContentInfo(idx);
		dao.countAdd(infoBoard);
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		request.setAttribute("url", "content.do?idx="+idx+"&page="+page);
		
		return "redirection.jsp";
	}

}
