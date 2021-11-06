<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.reg_cotainer {
	width : 500px;
	margin : 0 auto;
	text-align: center;
	font-size: 15px;
	margin-top: 50px;
	border: 1px solid green;
}
</style>



</head>
<body>
	
	<div class="reg_cotainer">
		<form action="registry.do" method="POST" name = "form_reg"> 
			<lable>아이디:</lable>
			<input type="text" id = "id" name = "m_id">
			<br>
			
			<lable>비밀번호 : </lable>
			<input type="password" id = "" name = "m_pw">
			<br>
			
			
			<lable>이름:</lable>
			<input type="text" id = "id" name = "m_name">
			<br>
			
			<lable>이메일 : </lable>
			<input type="password" id = "" name = "m_email">
			<br>
			<button type="submit">회원가입</button>
			
			<!--  <button type="button" onclick="memberReg()"  >회원가입</button> -->
		</form>
	</div>
	
	<script>
	
	</script>

</body>
</html>