<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="write.do" enctype="multipart/form-data" method="POST">
		<label>제목:</label>
		<input type="text" name="title">
		<br>
		<label>내용:</label>
		<textarea rows="" cols="" name="content">
		
		</textarea>
		<br>
		<label>첨부파일</label>
		<input type="file" name="s_file">
		<br>
		
		<button onclick="sendData(this.form)">전송</button>
	</form>
	
	<script>
		function sendData(form){
			
			form.submit();
		}
	</script>

</body>
</html>