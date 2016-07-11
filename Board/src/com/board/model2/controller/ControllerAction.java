package com.board.model2.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerAction extends HttpServlet{

	private Map commandMap = new HashMap();
	
	public void init(ServletConfig config) throws ServletException
	{
		loadProperties("com/board/model2/properties/Command");
	}
	
	public void loadProperties(String path)
	{
		ResourceBundle rbHome = ResourceBundle.getBundle(path);
		
		Enumeration<String> actionEnum = rbHome.getKeys();
		
		while(actionEnum.hasMoreElements())
		{
			String command = actionEnum.nextElement();
			String className = rbHome.getString(command);
			try {
				Class commandClass = Class.forName(className);
				Object commandInstace = commandClass.newInstance();
				
				commandMap.put(command, commandInstace);
				
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				continue;
			} catch (InstantiationException e) {
				e.printStackTrace();
				// TODO: handle exception
			} catch (IllegalAccessException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		requestPro(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		requestPro(request, response);
	}
	
	public void requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String view = null;
		CommandAction com= null;
		
		try
		{
			String command = request.getRequestURI();
			if(command.indexOf(request.getContextPath())==0)
			{
				command = command.substring(request.getContextPath().length());
			}
			com = (CommandAction) commandMap.get(command);
			if(com == null)
			{
				System.out.println("not found : " + command);
				return;
			}
			
			view = com.requestPro(request, response);
			
			if(view == null)
			{
				return;
			}
		}
		catch(Throwable t)
		{
			throw new ServletException(t);
		}
		
		if(view == null)
			return;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
