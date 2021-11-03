<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">


.container{
	width: 800px;
	margin: 0 auto;
	text-align: center;
}
table {
	width: 100%;
    height: 200px;
	
	border: 1px solid #444;
}
th, td {
	border: 1px solid #444;
}
td {
	height: 50px;
}
img {
  width: 100px;
  object-fit: cover;
}

caption {
	text-indent: -9999px;
}

</style>
</head>
<body>
	<h2>공공데이터 - 2017년 09월 행사공연축제 정보조회</h2>
	<a href="#">캠코공매물건조회서비스</a>
	<a href="car">한국환경공단_전기자동차 충전소 정보</a>
	
	<div class ="container">
		<header>
			<h2>행사목록</h2>
		</header>
		
		<table style="text-align: center">
		<caption>행사정보</caption>
		<colgroup>
			<col width="9%">
			<col width="9%">
			<col width="9%">
			<col width="9%">
		</colgroup>
			<thead>
				<tr>
					<th>썸네일</th>
					<th>제목</th>
					<th>주소</th>
					<th>전화번호</th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach var="vo" items ="${data}" varStatus="i">
				<tr>
					<c:if test="${vo.firstimage2 eq null }">
						<td><img src="resources/img/r.png"></td>
					</c:if>
					<c:if test="${vo.firstimage2 ne null }">
						<td><img src="${vo.firstimage}"></td>					
					</c:if>
					<td>${vo.title}</td>
					<c:if test="${vo.addr1 eq null }">
						<td>준비중 입니다.</td>
					</c:if>
					<c:if test="${vo.addr1 ne null }">
						<td>${vo.addr1}</td>					
					</c:if>
					<td>${vo.tel}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>