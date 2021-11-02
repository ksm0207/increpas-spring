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

	<h3>XML 테스트 입니다.</h3>
	${sessionScope.mvo}
	<c:forEach var="vo" items="${movie}">
		<span>영화제목 : <a href="#">${vo.name}</a></span> <a href="javascript:authCheck();">[예약]</a><br> <br>
				
		<br>
		<span>출시일 :   ${vo.releasdate}</span><br>
		<br>
		<span>제작사 : ${vo.company}</span> <br>
		<br>
		<span>상영시간 : ${vo.screeningtime}</span><br>
		<br>
	</c:forEach>	

	<script>
		function authCheck(){
			
			let msg = "${sessionScope.msg}";
			let session = "${sessionScope.mvo}";
			
			if(session == ""){	
				alert(msg);
				location.href = "reservation";
			}
			
			
		}
	</script>
	
</body>


</html>