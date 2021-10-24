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

	<c:if test="${res > 0}">
	</c:if>
	
	<c:choose>
		<c:when test="${res > 0 }">			
			<span>저장완료 되었습니다.</span>
		</c:when>
		
		<c:when test="${res <= 0 }">
			<span>저장실패 했습니다.</span>
		</c:when>
	</c:choose>

</body>
</html>
