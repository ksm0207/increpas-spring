<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="asset/css/summernote-lite.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="asset/js/summernote-lite.js"></script>
<script src="asset/js/lang/summernote-ko-KR.js"></script>
<script src="asset/js/summernote.js"></script>

</head>
<body>

<div>
	<form action="edit.do" method="POST" enctype="multipart/form-data">
		
		<div>
			<span>제목:</span>
			<input type="text" name="subject" value="${bbs.subject}" size="45">
			
			<span>이름:</span>
			<input type="text" name="writer" value="${bbs.writer}" size="12" readonly="readonly">
		
			<textarea rows="8" cols="50" name="content" id="content" >
				${bbs.content}
			</textarea>
			<span>첨부파일:</span>
			<input type="file" name="file" size="45" >
			
			<span>비밀번호:</span>
			<input type="text" name="pwd" size="12" value="${bbs.pwd}">
			<input type="hidden" name="cPage" value="${param.cPage}">
			<input type="hidden" name="b_idx" value="${bbs.b_idx}">
		</div>
		
		<div>
			<button type="button" onclick="sendData()">수정</button>
		</div>	
	
	</form>
</div>

</body>
</html>