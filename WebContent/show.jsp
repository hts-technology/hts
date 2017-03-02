<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jQuery.js"></script>
<c:if test="${ mess.equals('false')}"><script type="text/javascript"> alert("请输入数字");</script></c:if>
</head>
<body>
		<form action="GetResultServlet">
		请输入需要的题数：<input type="text" name="count" id="count"  style="width:50px;">&nbsp;&nbsp;&nbsp;
									<input type="submit" id="submit" value="生成">
		</form>
				<div >
		<form action="DealWithResultServlet" >
			<ol>
				<c:forEach var="result" items="${resultList}" varStatus="stat">
					<li><span style="font-weight:bold;">${result.formula}<input type="text" name="answer" style="width:50px;"></span></li><br>
					<c:if test="${stat.last}"><input type="submit"  value="提交"> </c:if>
				</c:forEach>
			</ol>			
		</form>
		</div>
</body>

</html>