<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

	<c:if test="${sessionScope.mvo == null }">
		<form action="" method="POST">
			<label>ID:</label>
			<input type="text" name="id">
			<br>
			
			<label>PW:</label>
			<input type="password" name="pw">
			<br>
			<input type="button" value="LOGIN"/>
		</form>
		<!-- 첫번째 호출 REST_API_KEY + http://localhost:9090/kakao/login -->
		<!-- KEY : e9a4160ebafba2956d773a60fc5f7c59 REDIRECT URL : http://localhost:9090/kakao/login -->
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=e9a4160ebafba2956d773a60fc5f7c59&redirect_uri=http://localhost:9090/kakao/login&response_type=code"><img src="resources/img/kakao_login_medium_wide.png"></a>
	</c:if>
	
</body>
</html>
