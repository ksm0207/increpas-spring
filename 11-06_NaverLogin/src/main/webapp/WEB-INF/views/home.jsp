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
	<h2>네이버 로그인 페이지</h2>

<div>
	<c:choose >
		<c:when test="${sessionScope.mvo == null}">
		
		<form action="login.do" method="POST" name="login_form">
		<h3>로그인</h3>	
		<input type="text" id="id" name="id" placeholder="아이디"><br>
		<h3></h3>	
		<input type="text" id="pw" name="pw" placeholder="비밀번호"><br>
		
		<input type="submit" value="로그인">
		</form>
		<a href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=xMyF0KlYHyGgwDd2AA5B&redirect_uri=http%3a%2f%2flocalhost%3a9090%2fnaver_callback&state=0"><img width="200px" src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png"></a>
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=e9a4160ebafba2956d773a60fc5f7c59&redirect_uri=http://localhost:9090/kakao/login&response_type=code"><img src="resources/img/kakao_login_medium_wide.png"></a>
	
		</c:when>	
	</c:choose>
	
	
		
		<c:choose>
		<c:when test="${sessionScope.mvo ne null }">
			<h3>카카오 & 네이버 로그인 성공!</h3>
			<span>닉네임 : ${mvo.nickName} </span><br>
			<span>이름 : ${mvo.name} </span><br>
			<span>이메일 : ${mvo.email} </span><br>
			<span>프로필이미지 : <img src="${mvo.profile_image}"></span><br>
			<a href="logout.do">로그아웃</a>
		</c:when>
	</c:choose>
		
	

</div>

</body>
</html>