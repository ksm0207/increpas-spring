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
<h2>게시판 수정입니다.</h2>
<div>
	<form action="edit.do" method="POST" enctype="multipart/form-data">
		
		<div>
			<span>제목:</span>
			<input type="text" id="subject" name="subject" size="45" value="${bbs.subject}">
			
			<span>이름:</span>
			<input type="text" name="writer" value="${bbs.writer}" size="12" readonly="readonly">
		
			<textarea rows="8" cols="50" name="content" id="content">
				${bbs.content}
			</textarea>
			<span>첨부파일:</span>
			<input type="file" name="file" size="45">
			
			<span>비밀번호:</span>
			<input type="password"  name="pwd" size="12" value="${bbs.pwd}">
			<input type="hidden" name="b_idx" value="${bbs.b_idx}" >
			<input type="hidden" name="cPage" value="${param.cPage}" >
		</div>
		
		<div>
			<button type="button" onclick="sendData()">수정</button>
		<a href="javascript:location.href='bbs_view.do?b_idx=${bbs.b_idx}+&cPage=${param.cPage}'">목록</a>
		</div>	
	
	</form>
</div>

</body>
</html>