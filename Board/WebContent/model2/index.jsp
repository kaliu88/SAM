<%@page import="com.board.beans.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.security.interfaces.RSAKey"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խ���</title>
</head>

<body>
	<h1>�Խñ� ����Ʈ</h1>
	<table>
		<tr>
			<th>��ȣ</th>
			<th>����</th>
			<th>�ۼ���</th>
			<th>��¥</th>
			<th>��ȸ��</th>
		</tr>
		<c:forEach items="${boardArray}" var="board">
	  	<tr>
	  		<td>${board.idx }</td>
	  		<td><a href="count.do?idx=${board.idx }&page=${page}">${board.title }</a></td>
	  		<td>${board.writer }</td>
	  		<td>${board.regdate }</td>
	  		<td>${board.count }</td>
	  	</tr>
	  	</c:forEach>
	</table>
	
	
	<c:if test="${page > 0}">
		<a href="list.do?page=${page-10}">���� ������</a>
	</c:if>
	<c:if test="${page == 0}">
		<a href="#">���� ������</a>
	</c:if> 
	<fmt:parseNumber value="${page/10+1 }" type="number"  integerOnly="True" /> ������
	<c:if test="${fn:length( boardArray ) < 10}">
		<a href="#">���� ������</a>
	</c:if>
	<c:if test="${fn:length( boardArray ) == 10}">
		<a href="list.do?page=${page+10 }">���� ������</a>
	</c:if>
	<br/>
	<a href="write.do">
		<input type="button" name="write" value="�۾���"/>
	</a> 

</body>
</html>