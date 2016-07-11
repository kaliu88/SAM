<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
<script type="text/javascript">
$.ajax({
	   type:'post',
	   url:'${url}',
	   success:function(data)
	   {
		 $('#content').html(data);
	   }
});
</script>
<div id="content">
</div>