<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>본문 게시판</title>
<link type="text/css" href="css/basic.css" rel="stylesheet">
</head>
<%
	String idx = request.getParameter("idx");
%>
<body>
	<table border=1>
	<%
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			 String driverName = "oracle.jdbc.driver.OracleDriver"; //데이터베이스에 접속하기위한 드라이버를 로드합니다.
			 
		     String url = "jdbc:oracle:thin:@localhost:1521:ORCL";            //접속 URL정보와 포트번호(oracle포트), sid(oracle버전)
		 
		 
		 
		     Class.forName(driverName);
		 
		     con = DriverManager.getConnection(url,"system","enovia");    // getCo... : 계정정보 url, id, pw
		 
		     out.println("Oracle 데이터베이스 db에 성공적으로 접속했습니다");
		 
		     stmt = con.createStatement();
		     
		     String str = "select * from board where idx='"+idx+"'";
		    
		     rs =  stmt.executeQuery(str);
		     
		     rs.next();
	    	 int count 		= rs.getInt("count");
	    	 String title 	= rs.getString("title");
	    	 String writer 	= rs.getString("writer");
	    	 String regdate	= rs.getString("regdate");
	    	 String content = rs.getString("content");

	%>
		<tr>
			<th>번호</th>
			<td><%=idx %></td>
			<th>작성자</th>
			<td><%=writer %></td>
			<th>날짜</th>
			<td><%=regdate %></td>
			<th>조회수</th>
			<td><%=count %></td>
		</tr>
		<tr>
			<th colspan="2">제목</th>
			<td colspan="6"><%=title %></td>
		</tr>
		<tr>
			<th colspan="2">내용</th>
			<td colspan="6" id="content"><%=content %></td>
		</tr>
		<%
		}
		catch(Exception e)
		{
			System.out.println("접속 실패");
			e.printStackTrace();
		}
		finally
		{
			con.close();
			stmt.close();
			con.close();
		}
		%>
	</table>
	<a href="delete.jsp?idx=<%=idx %>">게시글 삭제</a>&nbsp;<a href="index.jsp">목록으로</a>
</body>
</html>