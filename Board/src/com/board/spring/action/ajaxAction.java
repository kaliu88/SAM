package com.board.spring.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model2.beans.Board;
import com.board.model2.controller.CommandAction;
import com.board.model2.dao.BoardDao;

public class ajaxAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int page = 0;
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		
		ArrayList<Board> boardList = BoardDao.getInstance().getAticleList(page);
		
		request.setAttribute("boardArray", boardList);
		
		return "ajaxList.jsp";
	}

}
