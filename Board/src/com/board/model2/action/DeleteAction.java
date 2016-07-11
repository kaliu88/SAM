package com.board.model2.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model2.beans.Board;
import com.board.model2.controller.CommandAction;
import com.board.model2.dao.BoardDao;

public class DeleteAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardDao boardDao = BoardDao.getInstance();
		
		//fileName을 가져오기 위해 idx로 데이터 검색
		Board board = boardDao.getContentInfo(idx);
		
		//file의 실제 위치 지정
		String fileName = request.getParameter("fileName");
		String filePath = request.getSession().getServletContext().getRealPath("/upload")+"\\"+fileName;
		
		File file = new File(filePath);
		
		//file 존재 유무 체크후 삭제.
		if(file.exists() && file.isFile())
		{
			file.delete();
		}
		
		boardDao.deleteSelect(idx);
		
		
		
		return "delete.jsp";
	}
	

}
