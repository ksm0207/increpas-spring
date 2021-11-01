<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<header id="header">
			<a href="/"><h1>SK Together</h1></a>
			<ul class="gnb">
				<li><a href="#"><span class="menu m01">기브유</span></a></li>
				<li><a href="#"><span class="menu m02">위드유</span></a></li>
				<li><a href="#"><span class="menu m03">스마트 전통시장</span></a></li>
			
				<li><a href="/sub/bravo"><span class="menu m04">BRAVO!</span></a></li>
				<li><a href="#"><span class="menu m05">SKT와 사회공헌</span></a></li>
				<c:if test="${sessionScope.mvo == null }">
					<li><a href="/login"><span class="menu m04">로그인</span></a></li>				
				</c:if>
				<c:if test="${sessionScope.mvo != null }">
					<li><a href="#"><span class="menu m04">게시판</span></a></li>		
				</c:if>
			</ul>
</header>
