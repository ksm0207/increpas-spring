<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link rel="stylesheet" href="resources/css/list.css">
</head>
<body>
<h2>게시판 리스트</h2>
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
			<c:forEach var="bbs" items="${bbs}" varStatus="i">
				<tr>
					<td>${bbsRowTotal-((currentPage-1)*boardList+i.index)}</td>
					<td>
						<a style="text-decoration: none" href="#">${bbs.subject}</a> 
					</td>
					<td>${bbs.writer}</td>
					<c:if test="${bbs.write_date ne null }">
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
						<c:when test="${ page.isPrePage()}">
							<li><a href="list.do?cPage=${page.currentPage - page.boardList}">이전</a></li>
						</c:when>
						
						<c:when test="${!page.isPrePage()}">
							<li><span></span></li>
						</c:when>
					</c:choose>
					
					<c:forEach var="i" begin="${page.startPage}" end="${page.finalPage}">
						
						<c:choose>
							<c:when test="${i == page.currentPage}">
								<li>${i}</li>
							</c:when>
							<c:when test="${i ne page.currentPage}">
								<li><a href="list.do?cPage=${i}">${i}</a></li>
							</c:when>
						</c:choose>
					</c:forEach>
					
					<c:choose>
						<c:when test="${page.isNextPage()}">
						
							<c:if test="${page.currentPage < page.finalPage}">
									<li><a href="list.do?cPage=${page.startPage + page.boardList}">다음</a></li>
							</c:if>
							
							<c:if test="${page.currentPage >= page.finalPage}">
									<li><a href="list.do?cPage=${page.currentPage + 1}">다음</a></li>
							</c:if>
							
						</c:when>
						
						<c:when test="${!page.isNextPage()}">
							<li>&gt;</li>
						</c:when>
					</c:choose>
				
				</li>
			</ul>
			
		</div>
		<div>
			<form action="list.do" method="POST">
				
				<select name="select">
					<option value="0">제목</option>
					<option value="1">내용</option>
					<option value="2">닉네임</option>
				</select>
				
				 <input type="text" id="search" name="search" placeholder="검색">
				<button class="search_btn" type="button">검색</button>
			</form>
		</div>
		
	</div>
	<script type="text/javascript">
		
		$(function(){
			
			$(".search_btn").on("click",function(){
				console.log("ready");
				
				const search = $("#search").val();
				console.log(search);
				if(!search){
					alert("검색할 내용을 입력해주세요.");
					return false;
				}
				
				document.forms[0].submit();
					
			});
		});
		
	</script>
	
</body>
</html>