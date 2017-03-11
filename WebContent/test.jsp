<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.1.1.js"></script>
<script src="js/jquery-3.1.1.min.js"></script>
</head>
<body>
	<input type="button"  id="button" value="确定">
</body>
<script type="text/javascript">
$("#button").click(function(){
	$.ajax({
	type:"post",
	dataType:"json",
	url : "TestServlet",
	success:function(result){
		for(var i=0;i<result.length;i++){
			alert(result[i].molecular+" "+result[i].denominator);
		}
	}
	});	
});

</script>

</html>