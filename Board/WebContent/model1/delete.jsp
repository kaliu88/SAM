<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<%
	String idx = request.getParameter("idx");

	Connection con = null;
	Statement stmt = null;
	try
	{
		 String driverName = "oracle.jdbc.driver.OracleDriver"; //데이터베이스에 접속하기위한 드라이버를 로드합니다.
		 
	     String url = "jdbc:oracle:thin:@localhost:1521:ORCL";            //접속 URL정보와 포트번호(oracle포트), sid(oracle버전)
	 
	 
	 
	     Class.forName(driverName);
	 
	     con = DriverManager.getConnection(url,"system","enovia");    // getCo... : 계정정보 url, id, pw
	 
	     out.println("Oracle 데이터베이스 db에 성공적으로 접속했습니다");
	 
	     stmt = con.createStatement();
	     
	     String str = "Delete from board where idx='"+idx+"'";
	    
	     stmt.executeUpdate(str);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		con.close();
		stmt.close();
		out.print("<Script>location.href = 'index.jsp'</Script>");
	}
%>
<body>
</body>
</html>