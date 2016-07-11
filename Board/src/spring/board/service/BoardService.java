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
		
		ArrayList<Board> articleList = BoardDao.getInstance().getAticleList(page);//�Ķ���ͷ� ���� page ���� dao�� ���� �˻��� ���� List ArrayList�� �����.
		
		
		
		ModelAndView mav = new ModelAndView(); //ModelandView�� �ش� ���� ����
		mav.addObject("articleList", articleList); // Model(Dao)���� ���� List�� ����
		mav.addObject("page", page); //������ ��ȣ�� view���� �����ֱ� ����
		
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
