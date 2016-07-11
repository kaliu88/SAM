<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<c:forEach items="${boardArray }" var="board">
	<tr>
		<td>${board.idx }</td>
  		<td><a href="count.do?idx=${board.idx }&page=${page}">${board.title }</a></td>
 		<td>${board.writer }</td>
  		<td>${board.regdate }</td>
  		<td>${board.count }</td>
  		<td></td>
	</tr>
</c:forEach>
