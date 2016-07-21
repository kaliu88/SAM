package com.board.model2.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.model2.controller.CommandAction;
import com.board.model2.dao.BoardDao;
import com.board.util.BoardUtil;

public class DownloadAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("euc-kr");
		
		int idx = 0;
		if(BoardUtil.isNumber(request.getParameter("idx")))
			idx = Integer.parseInt(request.getParameter("idx"));
		
		Board board = BoardDao.getInstance().getContentInfo(idx);
		
		String fileName = board.getFilename();
		
		String uploadFileName = request.getSession().getServletContext().getRealPath("/upload")+"\\"+fileName;
		 
		File file = new File(uploadFileName);
		
		if(file.exists() && file.isFile() )
		{
			try 
			{
				long fileSize = file.length();
				response.setContentType("application/x-msdownload");
				response.setContentLength((int) fileSize);
				
				String strClient = request.getHeader("user-agent");



				if(strClient.indexOf("MSIE 5.5")!=-1)

				{

					response.setHeader("Content-Disposition", "filename=" + fileName + ";" );

				}

				else 

				{

					fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+","%20");					

					response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ";" );

				}



				response.setHeader("Content-Length", String.valueOf(fileSize));

				response.setHeader("Content-Transfer-Encoding", "binary;");

				response.setHeader("Pragma", "no-cache");

				response.setHeader("Cache-Control", "private");

				

				byte b[] = new byte[1024];

				BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));

				BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());

				int read = 0;

				while((read=fin.read(b)) != -1)

				{

					outs.write(b, 0, read);

				}

				outs.flush();

				outs.close();

				fin.close();
			}
			catch (Exception e) 
			{
				// TODO: handle exception
			}
		}
		
		return null;
	}

}
