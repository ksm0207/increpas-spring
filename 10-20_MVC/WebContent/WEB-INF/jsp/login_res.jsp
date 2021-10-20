<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>아이디 :  ${vo.id}</h1>
	<h1>비밀번호 : ${vo.pw}</h1>
	
	<c:choose>
		<c:when test="${vo.id eq 'admin' }">
			<span>관리자님 안녕하세요?</span>
		</c:when>
		
		<c:when test="${vo.id ne 'admin'}">
			<span>일반회원 이시군요 !</span>
		</c:when>
	</c:choose>

</body>
</html>