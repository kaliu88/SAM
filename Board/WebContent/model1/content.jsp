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
<title>���� �Խ���</title>
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
			 String driverName = "oracle.jdbc.driver.OracleDriver"; //�����ͺ��̽��� �����ϱ����� ����̹��� �ε��մϴ�.
			 
		     String url = "jdbc:oracle:thin:@localhost:1521:ORCL";            //���� URL������ ��Ʈ��ȣ(oracle��Ʈ), sid(oracle����)
		 
		 
		 
		     Class.forName(driverName);
		 
		     con = DriverManager.getConnection(url,"system","enovia");    // getCo... : �������� url, id, pw
		 
		     out.println("Oracle �����ͺ��̽� db�� ���������� �����߽��ϴ�");
		 
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
			<th>��ȣ</th>
			<td><%=idx %></td>
			<th>�ۼ���</th>
			<td><%=writer %></td>
			<th>��¥</th>
			<td><%=regdate %></td>
			<th>��ȸ��</th>
			<td><%=count %></td>
		</tr>
		<tr>
			<th colspan="2">����</th>
			<td colspan="6"><%=title %></td>
		</tr>
		<tr>
			<th colspan="2">����</th>
			<td colspan="6" id="content"><%=content %></td>
		</tr>
		<%
		}
		catch(Exception e)
		{
			System.out.println("���� ����");
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
	<a href="delete.jsp?idx=<%=idx %>">�Խñ� ����</a>&nbsp;<a href="index.jsp">�������</a>
</body>
</html>