<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ex4_res.inc" method="GET">
		
		<label for="s_msg">설명:</label>
		<input id="s_msg" name="msg" placeholder="Message">
		
		<button type="button" onclick="send(this.form)">열심히 보내기.</button>
		
	</form>

<script>
	function send(form){
		form.submit();
	}
</script>

</body>
</html>