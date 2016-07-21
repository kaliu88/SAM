package spring.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.portlet.ModelAndView;

import com.board.beans.Board;
import com.board.model2.controller.BoardController;
import com.board.model2.dao.BoardDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class BoardService extends BoardController{

	@Override
	public ModelAndView listAction(Integer page) throws Exception {
		// TODO Auto-generated method stub
		if(page == null)
			page = 0;
		
		ArrayList<Board> articleList = BoardDao.getInstance().getAticleList(page);
						
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("articleList", articleList);
		mav.addObject("page", page); 
		
		return mav;
	}

	@Override
	public ModelAndView insertAction(HttpServletRequest request, Board article)
			throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		
		MultipartRequest multi = null;
		
		int size = 10 * 1024 * 1024;
		
		String savePath = request.getSession().getServletContext().getRealPath("/upload");
		
		try
		{
			multi = new MultipartRequest(request, savePath, size, "euc-kr", new DefaultFileRenamePolicy());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		int count = 0;
		
		article.setRegip(request.getRemoteAddr());
		article.setCount(count);
		
		BoardDao.getInstance().insertArticle(article);
		

		return new ModelAndView("insert");
	}

}
