<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/board_list/list.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<h2>게시판 연습</h2>
	<div class="container">
	
		<table>
			
			<caption>게시판 Demo</caption>
			<colgroup>
				<col width="9%">
				<col width="65%">
				<col width="10%">
				<col width="7%">
				<col width="7%">
			</colgroup>
			<thead>
				
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>글쓴이</td>
					<td>작성일</td>
					<td>조회수</td>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach var="bbs" items="${bbs_total}" varStatus="i">
				<tr>
					<%-- <td>${bbs.b_idx}</td>--%>
					<td>${rowTotal-((nowPage-1)*blockList+i.index)}</td>
					
					<td><a style="text-decoration: none"href="board_view.do?cPage=${nowPage}&b_idx=${bbs.b_idx}">${bbs.subject}</a></td>
					<td>${bbs.writer}</td>
					<c:if test="${bbs.write_date ne null}">
						<td>${fn:substring(bbs.write_date,5,10)}</td>
					</c:if>
					<td>${bbs.hit}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="bottom_write">
			<a class="white_btn" href="#">목록</a>
			<a class="black_btn" href="write.do">글쓰기</a>
		</div>
		<div class="pageBlock">
		
			<ul>
				${pageCode}			
			</ul>
		</div>
		
	</div>
	
</body>
</html>