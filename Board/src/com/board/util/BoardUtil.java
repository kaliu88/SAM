package com.board.util;

public class BoardUtil {

	public static Boolean isNumber(String str)
	{
		Boolean flag = true;
		
		if(str == null || str.equals(""))
			flag = false;
		
		return flag;
	}
}
