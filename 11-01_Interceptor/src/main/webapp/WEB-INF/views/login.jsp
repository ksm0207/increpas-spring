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
		href="resources/css/login.css">
</head>
<body>
	<div id="wrap">
		<!-- 상단영역 -->
		<jsp:include page="common/nav.jsp"></jsp:include>
		
	<!-- 상단영역 끝-->
	<!-- 콘텐츠영역 -->
		<div id="contents">
			<h1 class="sub_title tit02">회원 로그인</h1>
			<div class="login_area">
				<!-- 일반개인회원 -->
				<div class="person_login">
					<h2 class="sub_title title01">일반 개인회원</h2>
					<div class="login">
					
						<form action="login" method="post" name="normal_login">
							<div class="input_area">
								<p>
									<label for="s_id">아이디</label>
									<input type="text" id="s_id" name="id"/>
								</p>
								<p>
									<label for="s_pw">비밀번호</label>
									<input type="password" 
										id="s_pw" name="pw"/>
								</p>
							</div>
							<div class="btnArea_right">
								<span class="btn b_login">
									<a href="javascript:login()">로그인</a>
								</span>
							</div>
							<div class="fclear"></div>
							<p class="login_search">
								<input type="checkbox" name="chk"
									id="ch01"/>
								<label for="ch01">아이디저장</label>
								<span class="btn b_search">
									<a href="">아이디/비밀번호찾기</a>
								</span>
							</p>
						</form>
					</div>
				</div>
				<!-- 일반개인회원 끝-->
				
				<!-- 기관단체회원 -->
				<div class="group_login">
					<h2 class="sub_title title02">기관단체회원</h2>
					<div class="login">
						<form action="" method="post" name="">
							<div class="input_area">
								<p>
									<label for="s_id">아이디</label>
									<input type="text" id="s_id" name="id"/>
								</p>
								<p>
									<label for="s_pw">비밀번호</label>
									<input type="password" 
										id="s_pw" name="pw"/>
								</p>
							</div>
							<div class="btnArea_right">
								<span class="btn b_login">
									<a href="#">로그인</a>
								</span>
							</div>
							<div class="fclear"></div>
							<p class="login_search">
								<input type="checkbox" name="chk"
									id="ch01"/>
								<label for="ch01">아이디저장</label>
								<span class="btn b_search">
									<a href="">아이디/비밀번호찾기</a>
								</span>
							</p>
						</form>
					</div>
				</div>
				<!-- 기관단체회원 끝-->
			</div>
		</div>
	<!-- 콘텐츠영역 끝-->
	<!-- 하단영역 -->
		<jsp:include page="common/footer.jsp"></jsp:include>
	<!-- 하단영역 끝-->
	</div>
	
	<script type="text/javascript">
	
		function login(){
			
			document.normal_login.submit();
		}
	
	</script>
	
</body>