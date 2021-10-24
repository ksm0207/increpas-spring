<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<header>
	<h1>부서 목록</h1>
</header>
<article>
	<ul>
		<c:forEach var="dvo" items="${total}" varStatus="i">
			
			<li>
				${dvo.department_id},${dvo.department_name}
				<c:if test="${dvo.e_list ne null and !empty dvo.e_list }">
					(${fn:length(dvo.e_list)})
				</c:if>
			</li>
		</c:forEach>
	</ul>
</article>


</body>
</html>