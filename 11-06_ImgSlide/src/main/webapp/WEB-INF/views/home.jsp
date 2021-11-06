<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" defer="defer" src="resources/js/slider.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/slider.css">
</head>
<body>
	<h2>캐러셀 슬라이드 연습</h2>
	
	<!-- 전체를 감싸줄 영역 - container -->
	<div class="container">
		<!-- 아이템 영역 --> 
		<div class="slider_items">
			<!-- 아이템 -->
			<div class="slide_item"></div>
			<div class="slide_item"></div>
			<div class="slide_item"></div>
			<div class="slide_item"></div>
			<div class="slide_item"></div>		
		</div>
		<!-- end of slider_items -->
	
	
	<!-- 다음 버튼 -->
	<button type="button" class="nextButton">▶</button>
	<!-- 이전 버튼 -->
	<button type="button" class="prevButton">◀</button>
	
	<!-- 썸네일 영역 -->
	<div class="thumbnail">
		<!-- 썸네일 아이템 -->
		<div class="thumbnail_item"></div>
		<div class="thumbnail_item"></div>
		<div class="thumbnail_item"></div>
		<div class="thumbnail_item"></div>
		<div class="thumbnail_item"></div>
	</div>
	
   </div>
   <!-- end of container -->
</body>
</html>