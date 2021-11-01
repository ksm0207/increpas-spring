<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" 
		href="resources/css/common.css">
	<link rel="stylesheet" type="text/css" 
		href="resources/css/main.css">
</head>
<body>
	<div id="wrap">
		<!-- 상단영역 -->
		<jsp:include page="common/nav.jsp"></jsp:include>
		<!-- 상단영역 끝-->
		<!-- 콘텐츠 영역 -->
		<div id="contents">
			<div class="main_img">
				<a href="">
					<img src="resources/img/@img00.png" 
						alt="서울안전체험 한마당봉사"/>
				</a>
			</div>
			<div class="main_news">
				<div class="news_type01 fl">
					<p class="title">기브유 후원참여</p>
					<a href="" class="news_src">
						<span class="thum_img">
							<img src="resources/img/@img01.png" alt="기사사진"/>
						</span>
						<span class="subject ellip">
							난청이지만 피아니스트가 되고픈 
							한별이의 이야기 입니다.
						</span>
						<span class="writer">by ttogether</span>
						<span class="more_view">자세히보기</span>
						<span class="fclear"></span>
					</a>
				</div>
				<div class="news_type01 cen">
					<p class="title">기브유 후원금 쓰임현황</p>
					<a href="" class="news_src">
						<span class="thum_img">
							<img src="resources/img/@img02.png" alt="기사사진"/>
						</span>
						<span class="subject ellip">
							레티하씨 가정에 희망의 집 선물
						</span>
						<span class="writer">by 한국해비타트</span>
						<span class="more_view">자세히보기</span>
						<span class="fclear"></span>
					</a>
				</div>
				<div class="news_type01 fr">
					<p class="title">기브유 나눔영상</p>
					<a href="" class="news_src">
						<span class="thum_img">
							<img src="resources/img/@img03.png" alt="기사사진"/>
							<span id="btn_play" 
							   title="동영상 재생"><a href=""></a></span>
						</span>
						<span class="subject ellip">
							1리터의 생명을 선물해주세요.
						</span>
						<span class="writer">by hungersaver</span>
						<span class="more_view">자세히보기</span>
						<span class="fclear"></span>
					</a>
				</div>
			</div>
			<div class="main_board">
				<!-- 공지사항 -->
				<div class="board_type01 fl">
					<p class="title">공지사항</p>
					<span class="more_view"><a href="">더보기</a></span>
					<ul class="notice">
						<li>
							<a href="">T-together리뉴얼 오픈되었습니다.</a>
							<span class="date">2021.08.15</span>
						</li>
						<li>
							<a href="">GiveU 이벤트 당첨자 공지입니다.</a>
							<span class="date">2021.04.05</span>
						</li>
						<li>
							<a href="">인크레파스 교육센터 안내</a>
							<span class="date">2021.03.17</span>
						</li>
					</ul>
				</div>
				<!-- 공지사항 끝-->
				<!-- together트위터 -->
				<div class="board_type01 cen">
					<p class="title">T-Together트위터</p>
					<span class="more_view"><a href="">더보기</a></span>
					<a href="" class="article">
						<span class="thum_img">
							<img src="resources/img/@img04.png"/>
						</span>
						<span class="src">
							[캠페인] 뜨거웠던 여름이 지나가고 
							시원한 바람과 RGB색상이 나무를 흔듭니다.
						</span>
						<span class="fclear"></span>
					</a>
				</div>
				<!-- together트위터 끝-->
				<!-- 배너 -->
				<div class="board_type01 fr">
					<span class="banner b01">
						<a href="">
							T-Together와 함께할 기관/단체를 모십니다.
						</a>
					</span>
					<span class="banner b02">
						<a href="">
							T-Together 이젠 모바일로 함께해요.
						</a>
					</span>
				</div>
				<!-- 배너 끝-->
			</div>
		</div>
		<!-- 콘텐츠 영역 끝-->
		<!-- 하단 영역 -->
		<jsp:include page="common/footer.jsp"></jsp:include>
		
		<!-- 하단 영역 끝-->
	</div>
</body>