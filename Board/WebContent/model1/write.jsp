<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 쓰기</title>
<link type="text/css" href="css/basic.css" rel="stylesheet">
<script type="text/javascript">
	function checkForm()
	{
		var title 		= document.writeForm.title;
		var mail 		= document.writeForm.mail;
		var content		= document.writeForm.content;
		var regDate 	= document.writeForm.regDate;
		
		
		if(title.value == "" || title.value == null)
		{
			alert("제목을 입력하세요");
			title.focus();
			return false;
		}
		if(mail.value == "" || mail.value == null)
		{
			alert("메일을 입력하세요");	
			mail.focus();
			return false;
		}
		else if(mail.value.match(/^(\w+)@(\w+)[.](\w+)$/ig) == null) // test@test.com
		{
			if(mail.value.match(/^(\w+)@(\w+)[.](\w+).(\w+)$/ig) == null) //test@test.co.kr
			{
				alert("Mail 형식에 맞지 않습니다.");
				mail.focus();
				return false;
			}
		}

		if(content.value == "" || content.value == null)
		{
			alert("내용을 입력하세요");
			content.focus();
			return false;
		}
		if(regDate.value == "" || regDate.value == null)
		{
			alert("날짜를 입력하세요");
			regDate.focus();
			return false;
		}
		else if(regDate.value.match(/^\d\d\d\d\d\d+$/ig) == null)
		{
			alert("숫자 형식에 맞지 않습니다.");
			regDate.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<form name="writeForm" action="insert.jsp" method="post" onsubmit="return checkForm();">
	<table id="test">
		<tr>
			<th>제목 :</th>
			<td> <input type="text" name="title"/></td>
		</tr>
		<tr>
			<th>작성자(Mail) :</th>
			<td><input type="text" name="mail"/></td>
		</tr>
		<tr>
			<th>내용 :</th>
			<td><textarea name="content" rows="10" cols="50"></textarea></td>
		</tr>
		<tr>
			<th>날짜 :</th>
			<td><input type="text" name="regDate"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" id ="submit_button" value="전송"></td>
		</tr>
	</table>
	</form>
</body>
</html>