package com.board.model2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.board.model2.beans.Board;

@Controller
public abstract class BoardController {

	@RequestMapping("/list/{page}")	// url ����
	public abstract ModelAndView listAction(@PathVariable Integer page) throws Exception; // Restful : url���� �Ķ���� ��������

	@RequestMapping("/insert")
	public abstract ModelAndView insertAction(	HttpServletRequest request, @ModelAttribute Board article) throws Exception; // ���� ���ε带 ���� request��ü // ������ �Ѿ�� �� �ڵ����� �� ����
}
