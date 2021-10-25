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
	<form action="write.do" method="POST" enctype="multipart/form-data">
		
		<div>
			<span>제목:</span>
			<input type="text" name="subject" size="45">
			
			<span>이름:</span>
			<input type="text" name="writer" size="12">
			
			<span>내용:</span>
			<textarea rows="8" cols="50" name="content" id="content">
			
			</textarea>
			<span>첨부파일:</span>
			<input type="file" name="file" size="45">
			
			<span>비밀번호:</span>
			<input type="text" name="pwd" size="12">
		</div>
		
		<div>
			<button type="submit">보내기</button>
		</div>	
	
		
	</form>
</div>

	Write.do

</body>
</html>