<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>首页</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.1.1.js"></script>
<script src="js/jquery-3.1.1.min.js"></script>
<style type="text/css">
div{
Float:left;
}
</style>
<c:if test="${ mess.equals('false')}"><script type="text/javascript"> alert("请输入数字");</script></c:if>
</head>
<body>
<div>
		<form action="GetResultServlet"  method="post">
		<div  id="firstPage1" ></div> <input type="text" name="count" id="count"  style="width:50px;">&nbsp;&nbsp;&nbsp;
		<input type="submit"  id="submit"  value="生成">
		</form>
</div>	
<div>
<form action="">
		<input type="radio"  name="lanaguage"  id="radio" value="simpleChinese" >简体中文
		<input type="radio"  name="lanaguage"  id="radio" value="traditionalChinese">繁体中文
		<input type="radio"  name="lanaguage"   id="radio" value="English">English
</form>
</div>
</body>
<script type="text/javascript">
$(function(){
	var lanaguage1=$('input:radio:checked').val();
	$.ajax({
		dataType:"json",
 		type:"post", 
 		url : "LanguageServlet?page=firstPage",
 		success : function(result) {
 			$("#firstPage1").html(result.firstPage1);
 			$("#firstPage2").val()=result.firstPage2;
 		}
 		}); 
 });
</script>
<script type="text/javascript">
$(":radio").change(function(){
	var lanaguage1=$('input:radio:checked').val();
	$.ajax({
		dataType:"json",
 		type:"post", 
 		url : "LanguageSelectServlet",
 		data : {
 			lanaguage : lanaguage1
 		}
 	});
	$.ajax({
		dataType:"json",
 		type:"post", 
 		url : "LanguageServlet?page=firstPage",
 		success : function(result) {
 			$("#firstPage1").html(result.firstPage1);
 			$("#submit").val(result.firstPage2);
 		}
 	});
 })
</script>
</html>