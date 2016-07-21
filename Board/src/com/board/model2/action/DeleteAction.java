package com.board.model2.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.model2.controller.CommandAction;
import com.board.model2.dao.BoardDao;

public class DeleteAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardDao boardDao = BoardDao.getInstance();
		
		//fileName�� �������� ���� idx�� ������ �˻�
		Board board = boardDao.getContentInfo(idx);
		
		//file�� ���� ��ġ ����
		String fileName = request.getParameter("fileName");
		String filePath = request.getSession().getServletContext().getRealPath("/upload")+"\\"+fileName;
		
		File file = new File(filePath);
		
		//file ���� ���� üũ�� ����.
		if(file.exists() && file.isFile())
		{
			file.delete();
		}
		
		boardDao.deleteSelect(idx);
		
		
		
		return "delete.jsp";
	}
	

}
