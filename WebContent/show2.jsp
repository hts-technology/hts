<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#div1{float:left}
.div2{position:absolute;left:300px;top:100px}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.1.1.js"></script>
<script src="js/jquery-3.1.1.min.js"></script>
</head>
<body onload="time_fun()">
<div id="div1">
		<form action="GetResultServlet">
		<span  id="secondPage1" ></span><input type="text" name="count" id="count"  style="width:50px;">&nbsp;&nbsp;&nbsp;
									<input type="submit"   id ="submit" value="生成">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<span id="secondPage3"></span><span id="timeShow"></span><input  type="hidden"   id="timeShow"  style="width:60px;">	
		</form>
</div>

<br>	
	<div >
		<form action="DealWithResultServlet"  method="post">
					<input type="hidden"  id="time" name="time">	
			<ol>
				<c:forEach var="result" items="${resultList}" varStatus="stat">
					<li><span style="font-weight:bold;">${result.formula}<input type="text" name="answer"  style="width:50px;" id="answer"></span></li><br>
					<c:if test="${stat.last}"><input type="submit"  id="submit2"  value="提交"> </c:if>
				</c:forEach>
			</ol>						
		</form>
		</div>
	<div class="div2">
		<table border="1">
		<c:if test="${!empty flag}">	
			<tr>
					<th></th>
					<th></th>
			</tr>
		</c:if>	
			<c:forEach var="Result" items="${timeList}">
				<c:if test="${!empty Result.time}">
				<tr>
						<td>${Result.message}</td>
						<td>${Result.time}</td>
				</tr>
				</c:if>
			</c:forEach>
		</table>
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
            document.getElementById("timeShow").innerText = two_char(h) + ":" + two_char(m) + ":" + two_char(s);
            document.getElementById("time").value=two_char(h) + ":" + two_char(m) + ":" + two_char(s);
        }, 1000);      
    }
</script>

<script type="text/javascript">
$(function(){
	var lanaguage1=$('input:radio:checked').val();
	$.ajax({
		dataType:"json",
 		type:"post", 
 		url : "LanguageServlet?page=secondPage",
 		data : {
 			lanaguage : lanaguage1
 		},
 		success : function(result) {
 			$("#secondPage1").html(result.secondPage1);
 			$("#submit").val(result.secondPage2);
 			$("#secondPage3").html(result.secondPage3);
 			$("#submit2").val(result.secondPage4);
 			$("table tr th:eq(0)").html(result.secondPage5);
 			$("table tr th:eq(1)").html(result.secondPage6);
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
 		url : "LanguageServlet?page=secondPage",
 		data : {
 			lanaguage : lanaguage1
 		},
 		success : function(result) {
 			$("#secondPage1").html(result.secondPage1);
 			$("#submit").val(result.secondPage2);
 			$("#secondPage3").html(result.secondPage3);
 			$("#submit2").val(result.secondPage4);
 			$("table tr th:eq(0)").html(result.secondPage5);
 			$("table tr th:eq(1)").html(result.secondPage6);
 		}
 	});
 })
</script>
</html>