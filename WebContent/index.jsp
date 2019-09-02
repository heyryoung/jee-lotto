<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lotto program</title>
</head>
<body>
<form id="lotto" action="<%=request.getContextPath()%>/lotto.do" >
	<input type="text" value="1000" name ="money"/>
	<input type="submit" value="로또번호생성"/>
</form>



</body>
<script >
	$("#lotto").submit(function(){
		alert("여기까지 왔꾸나.");
	});
	
</script>
</html>