package com.board.model2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.board.beans.Board;

@Controller
public abstract class BoardController {

	@RequestMapping("/list/{page}")	// url 맵핑
	public abstract ModelAndView listAction(@PathVariable Integer page) throws Exception; // Restful : url에서 파라미터 가져오기

	@RequestMapping("/insert")
	public abstract ModelAndView insertAction(	HttpServletRequest request, @ModelAttribute Board article) throws Exception; //파일 업로드를 위한 request 객체// 폼에서 넘온 값 자동 으로 빈에 셋팅
}
