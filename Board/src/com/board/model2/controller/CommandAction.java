package com.board.model2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public interface CommandAction {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
