<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ol>
		<c:forEach var="result" items="${resultList2}" varStatus="stat">
			<li><span style="font-weight:bold;">${result.formula}${result.flag}</span></li><br>
			<c:if test="${stat.last}">正确率为：${result.correct}<br><br><br>
			<a href="ReturnFirstServlet">返回首页</a>
			</c:if>
		</c:forEach>
</ol>	


</body>
</html>