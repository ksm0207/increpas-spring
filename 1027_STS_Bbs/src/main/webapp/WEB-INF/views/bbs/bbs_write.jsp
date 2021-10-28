<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="${path}/resources/asset/css/summernote-lite.css">-->

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="resources/asset/js/summernote.js"></script>
<script src="resources/asset/css/summernote-lite.css"></script>
<script src="resources/asset/js/summernote-lite.js"></script>
<link rel="stylesheet" href="resources/asset/css/summernote-lite.css">

</head>
<body>

<div>
	<form action="write.do" method="POST" enctype="multipart/form-data">
		
		<div>
			<span>제목:</span>
			<input type="text" name="subject" size="45">
			
			<span>이름:</span>
			<input type="text" name="writer" size="12">
		
			<textarea rows="8" cols="50" name="content" id="content" placeholder="내용을 입력하세요.">
			
			</textarea>
			<span>첨부파일:</span>
			<input type="file" name="file" size="45">
			
			<span>비밀번호:</span>
			<input type="text" name="pwd" size="12">
		</div>
		
		<div>
			<button type="button" onclick="sendData()">작성하기</button>
		</div>	
	
	</form>
</div>

</body>
</html>