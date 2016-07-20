package spring.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.board.model2.beans.Board;

@Controller
public abstract class BoardController {

	@RequestMapping("/list/{page}")//url Mapping
	public abstract ModelAndView listAction(@PathVariable Integer page)throws Exception;
	
	//파일 업로드를 위한 request 객체, 폼에서 넘어온 값 자동으로 빈 셋팅
	public abstract ModelAndView insertAction(HttpServletRequest request, @ModelAttribute Board article) throws Exception;
}
