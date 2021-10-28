<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/css/view.css"/>" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

<div class="bv_container">
   <form>
	<div class="bv_border_tLine">
	
		<div class="top_container">
		<span class="fl_writer">글쓴이 : ${bbs.writer}</span>
		<c:if test="${bbs.write_date ne null }">
			<span class="fr_write_date">${fn:substring(bbs.write_date,0,10)}</span>		
		</c:if>
		<span style="float: right; padding: 5px;">조회수 : ${bbs.hit}</span>
		</div>
	</div>
	
	<div class="bv_middle_line">
		<div class="bv_bname_line">
			<span class="bv_bname">게시판 유형 : [${bbs.bname}]</span>
		</div>
		
		<div class="bv_middle_file_line">
			<c:if test="${bbs.file_name ne null}">
				<span>첨부파일 <a href="javascript:download('${bbs.file_name}')">${bbs.file_name}</a></span>			
			</c:if>
		</div>
		
		<div class="bv_middle_subject_line">
			<span class="bv_subject">제목:${bbs.subject}</span>		
		</div>
		
		<div class="bv_c_container">
			<span class="bv_content">내용:${bbs.content}</span>
		</div>
	</div>
	</form>	
</div>

<div class="btn_container">
	<a class="black_btn" href="javascript:location.href='edit.do?b_idx=${bbs.b_idx}&cPage=${cPage}'">수정</a>
	<a class="black_btn" href="javascript:location.href='delete.do?b_idx=${bbs.b_idx}&cPage=${cPage}'">삭제</a>
	<a class="white_btn" href="javascript:location.href='list.do?cPage=${cPage}'">목록</a>
</div>


<div class="bv_commnet">
	<div>
		<form method="post" action="ans_write.do">
				이름:<input type="text" name="writer"/><br/>
				내용:<textarea rows="4" cols="55" name="content"></textarea><br/>
				비밀번호:<input type="password" name="pwd"/><br/>
				<input type="hidden" name="b_idx" value="${bbs.b_idx}">
				<input type="hidden" name="cPage" value="${cPage}">
				<input type="submit" value="저장하기"/> 
		</form>
	</div>
		<div>
			<h3>댓글</h3>
			
			<c:forEach var="cvo" items="${bbs.c_list}">
				<span>이름:${cvo.writer}</span>
			    <span>내용:${cvo.content}</span>
			    <span>작성일:${cvo.write_date}</span>
			</c:forEach>
		</div>
</div>

<!-- 원글을 의미하는 원글의 기본키 -->
	
	
		
	<form name="frm" method="POST">
		<input type="hidden" name="cPage" value="${cPage}">
		<input type="hidden" name="b_idx" value="${bbs.b_idx}">
		<input type="hidden" name="bname" value="${bbs.bname}">
	</form>
	
	<script>
		function goList(){
			// location.href='list.jsp?=cPage';
		}
		
		function download(file){
			/*
				document.frm.f_name.value = file;
				document.frm.action = 'download.jsp';
				document.frm.submit();
			*/
			console.log(file);
			// dir : 변수 , bbs_upload 문자열
			location.href= "FileDownload?dir=bbs_upload&filename="+file;
		}
		/*
		function edit(){
			document.frm.action = 'edit.do';
			
		}
		*/
	</script>

</body>
</html>