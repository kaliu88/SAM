<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� �Խ���</title>
<link type="text/css" href="css/basic.css" rel="stylesheet">
</head>
<script type="text/javascript">
	function onDownload(idx)
	{
		var hiddenFrame = document.getElementById("ifrm_filedown");
		hiddenFrame.src = "download.do?idx="+idx;
	}
	
</script>
<body>
	<table border=1>
		<tr>
			<th>��ȣ</th>
			<td>${content.idx}</td>
			<th>�ۼ���</th>
			<td>${content.writer}</td>
			<th>��¥</th>
			<td>${content.regdate}</td>
			<th>��ȸ��</th>
			<td>${content.count}</td>
		</tr>
		<tr>
			<th colspan="2">����</th>
			<td colspan="6">${content.title}</td>
		</tr>
		<tr>
			<th colspan="2">����</th>
			<td colspan="6" id="content">${content.content}</td>
		</tr>
		<tr>
			<th colspan="2">����</th>
			<td colspan="6"><a href="#" onclick="onDownload(${content.idx});">${content.filename}</a></td>
		</tr>
	</table>
	<a href="delete.do?idx=${content.idx}&fileName=${content.filename}">�Խñ� ����</a>&nbsp;<a href="list.do?page=${page }">�������</a>
	<iframe id="ifrm_filedown"  style="position:absolute; z-index:1;visibility : hidden;"></iframe>  
</body>
</html>