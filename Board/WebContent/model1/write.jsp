<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ����</title>
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
			alert("������ �Է��ϼ���");
			title.focus();
			return false;
		}
		if(mail.value == "" || mail.value == null)
		{
			alert("������ �Է��ϼ���");	
			mail.focus();
			return false;
		}
		else if(mail.value.match(/^(\w+)@(\w+)[.](\w+)$/ig) == null) // test@test.com
		{
			if(mail.value.match(/^(\w+)@(\w+)[.](\w+).(\w+)$/ig) == null) //test@test.co.kr
			{
				alert("Mail ���Ŀ� ���� �ʽ��ϴ�.");
				mail.focus();
				return false;
			}
		}

		if(content.value == "" || content.value == null)
		{
			alert("������ �Է��ϼ���");
			content.focus();
			return false;
		}
		if(regDate.value == "" || regDate.value == null)
		{
			alert("��¥�� �Է��ϼ���");
			regDate.focus();
			return false;
		}
		else if(regDate.value.match(/^\d\d\d\d\d\d+$/ig) == null)
		{
			alert("���� ���Ŀ� ���� �ʽ��ϴ�.");
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
			<th>���� :</th>
			<td> <input type="text" name="title"/></td>
		</tr>
		<tr>
			<th>�ۼ���(Mail) :</th>
			<td><input type="text" name="mail"/></td>
		</tr>
		<tr>
			<th>���� :</th>
			<td><textarea name="content" rows="10" cols="50"></textarea></td>
		</tr>
		<tr>
			<th>��¥ :</th>
			<td><input type="text" name="regDate"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" id ="submit_button" value="����"></td>
		</tr>
	</table>
	</form>
</body>
</html>