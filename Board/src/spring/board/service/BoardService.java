package spring.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.portlet.ModelAndView;

import com.board.model2.beans.Board;
import com.board.model2.controller.BoardController;
import com.board.model2.dao.BoardDao;
import com.oreilly.servlet.MultipartRequest;

@Service
public class BoardService extends BoardController{

	@Override
	public ModelAndView listAction(Integer page) throws Exception {
		// TODO Auto-generated method stub
		if(page == null)
			page = 0;
		
		ArrayList<Board> articleList = BoardDao.getInstance().getAticleList(page);//파라미터로 들어온 page 값을 dao로 보내 검색후 받은 List ArrayList에 담아줌.
		
		
		
		ModelAndView mav = new ModelAndView(); //ModelandView에 해당 값을 셋팅
		mav.addObject("articleList", articleList); // Model(Dao)에서 받은 List값 셋팅
		mav.addObject("page", page); //페이지 번호를 view에서 보여주기 위해
		
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
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		return mav;
	}

}
