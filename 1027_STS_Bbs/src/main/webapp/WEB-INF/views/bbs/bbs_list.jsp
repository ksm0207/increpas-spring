<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- main/webapp/resources/ -->
<link href="<c:url value="/resources/css/list.css"/>" rel="stylesheet">

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
			<c:forEach var="bbs" items="${bbs_list}" varStatus="i">
				<tr>
					
					<td>${rowTotal-((nowPage-1)*blockList+i.index)}</td>
					
					<td><a style="text-decoration: none"href="board_view.do?b_idx=${bbs.b_idx}&cPage=${nowPage}">${bbs.subject}</a></td>
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
				<li>
					<c:choose>
						<c:when test="${page.isPrePage()}">
							<li><a href="list.do?cPage=${page.nowPage - page.blockPage}">이전</a>	</li>
						</c:when>
						<c:when test="${!page.isPrePage()}">
								&lt;
						</c:when>
					</c:choose>
						<c:forEach var="i" varStatus="status" begin="${page.startPage}" end="${page.endPage}">
							<c:choose>
								<c:when test="${i == page.nowPage}">
									<li>${i}</li>
								</c:when>
								<c:when test="${i ne page.nowPage}">
									<li><a href="list.do?cPage=${i}">${i}</a></li>
								</c:when>
							</c:choose>
						</c:forEach>
					<c:choose>
						<c:when test="${page.isNextPage()}">
							<li> <a href="list.do?cPage=${page.nowPage + page.blockPage}">다음</a></li>
						</c:when>
						
						<c:when test="${!page.isNextPage()}">
							<li>&gt;</li>
						</c:when>		
					</c:choose>
				</li>
			</ul>
		</div>
		
	</div>
	
</body>
</html>