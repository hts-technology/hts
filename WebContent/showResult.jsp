<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.1.1.js"></script>
<script src="js/jquery-3.1.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<ol>
		<c:forEach var="result" items="${resultList2}" varStatus="stat">
			<li><span style="font-weight:bold;">${result.formula}${result.flag}</span></li><br>
			<c:if test="${stat.last}"><span id="thirdPage1">正确率为：</span>${result.correct}<br><br><br>
			<a href="ReturnFirstServlet"><span id="thirdPage2">返回首页</span></a>
			</c:if>
		</c:forEach>
</ol>	


</body>

<script type="text/javascript">
$(function(){
	$.ajax({
		dataType:"json",
 		type:"post", 
 		url : "LanguageServlet?page=thirdPage",
 		success : function(result) {
 			$("#thirdPage1").html(result.thirdPage1);
 			$("#thirdPage2").html(result.thirdPage2);
 		}
 		}); 
 });
</script>
</html>