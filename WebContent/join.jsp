<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lotto</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<h1>회원가입</h1>
<form id="consumer" action="<%=request.getContextPath()%>/consumer.do" >
ID:		<input type="text" name= "cid"/> <br/>
PW:		<input type="password" name= "pass"/> <br/>
		<input type="submit" value="전송"/> <br/>
</form>


</body>
<script >
	$("#consumer").submit(function(){
		alert("여기까지 왔꾸나.");
		
	});
	
</script>
</html>