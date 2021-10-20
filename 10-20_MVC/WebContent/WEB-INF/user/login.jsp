<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="login_res.inc" method="POST">
		<label for="id">ID : </label>
		<input type="text" name="id">
		<br>
		<label for="id">PW : </label>
		<input type="text" name="pw">
		<br>
		<button type="button" onclick="login(this.form)">로그인</button>
	</form>

<script>
	function login(form){
		form.submit();
	}
</script>


</body>
</html>