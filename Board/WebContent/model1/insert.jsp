<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<%
	request.setCharacterEncoding("EUC-KR");
	
	String title 	= request.getParameter("title");
	String mail  	= request.getParameter("mail");
	String regDate 	= request.getParameter("regDate");
	String content  = request.getParameter("content");
	
	try
	{
		 String driverName = "oracle.jdbc.driver.OracleDriver"; //데이터베이스에 접속하기위한 드라이버를 로드합니다.
		 
	     String url = "jdbc:oracle:thin:@localhost:1521:ORCL";            //접속 URL정보와 포트번호(oracle포트), sid(oracle버전)
	 
	 
	 
	     Class.forName(driverName);
	 
	     Connection con = DriverManager.getConnection(url,"system","enovia");    // getCo... : 계정정보 url, id, pw
	 
	     out.println("Oracle 데이터베이스 db에 성공적으로 접속했습니다");
	 
	     Statement stmt = con.createStatement();
	     
	     String str = "INSERT INTO board (idx, title, writer, regdate, content, count) values(board_seq.nextval,'"+title+"','"+mail+"','"+regDate+"','"+content+"', '0')";
	    
	     stmt.executeUpdate(str);
	     
	     con.close();
	     stmt.close();
	}
	catch(Exception e)
	{
		out.println("Oracle 데이터베이스 db 접속에 문제가 있습니다. <hr>");
		 
	    out.println(e.getMessage());
	 
	    e.printStackTrace();
	}
	finally
	{
		out.print("<script>location.href='index.jsp'</script>");
	}
%>
<body>
</body>
</html>