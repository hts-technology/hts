<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

.div2{position:absolute;left:300px;top:100px}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jQuery.js"></script>
<c:if test="${ mess.equals('false')}"><script type="text/javascript"> alert("请输入数字");</script></c:if>
</head>
<body onload="time_fun()">
		<form action="GetResultServlet">
		请输入需要的题数：<input type="text" name="count" id="count"  style="width:50px;">&nbsp;&nbsp;&nbsp;
									<input type="submit"  value="生成">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									做题计时开始：<input  type="text"  name="time"  id="input"  style="width:60px;">	
		</form>
		
	<div >
		<form action="DealWithResultServlet" >
			<ol>
				<c:forEach var="result" items="${resultList}" varStatus="stat">
					<li><span style="font-weight:bold;">${result.formula}<input type="text" name="answer" style="width:50px;" ></span></li><br>
					<c:if test="${stat.last}"><input type="submit"  id="submit"  value="提交"> </c:if>
				</c:forEach>
			</ol>			
		</form>
		</div>
	<div class="div2">
		<ol>
			<c:forEach var="Result" items="${timeList}">
				<c:if test="${!empty Result.time}">
				<li><span style="font-weight:bold;">${Result.message} ${Result.time}</span></li><br>
				</c:if>
			</c:forEach>
		</ol>
</div>
</body>
<script>
    function two_char(n) {
        return n >= 10 ? n : "0" + n;
    }
    function time_fun() {
        var sec=0;
        setInterval(function () {
            sec++;
            var date = new Date(0, 0)
            date.setSeconds(sec);
            var h = date.getHours(), m = date.getMinutes(), s = date.getSeconds();
            document.getElementById("input").innerText = two_char(h) + ":" + two_char(m) + ":" + two_char(s);
        }, 1000);      
    }
</script>

<script type="text/javascript">
$("#submit").click(function(){
	var time1=$("#input").val();
	$.ajax({
 		type:"post", 
 		url : "DealWithResultServlet",
 		data : {
 			time : time1
 		},
 		success : function(result) {
 		}
 		});
	
})

</script>
</html>