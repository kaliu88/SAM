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
		 String driverName = "oracle.jdbc.driver.OracleDriver"; //�����ͺ��̽��� �����ϱ����� ����̹��� �ε��մϴ�.
		 
	     String url = "jdbc:oracle:thin:@localhost:1521:ORCL";            //���� URL������ ��Ʈ��ȣ(oracle��Ʈ), sid(oracle����)
	 
	 
	 
	     Class.forName(driverName);
	 
	     con = DriverManager.getConnection(url,"system","enovia");    // getCo... : �������� url, id, pw
	 
	     out.println("Oracle �����ͺ��̽� db�� ���������� �����߽��ϴ�");
	 
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