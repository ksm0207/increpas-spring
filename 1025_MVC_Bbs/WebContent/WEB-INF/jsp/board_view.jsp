<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/board_list/view.css" rel="stylesheet">
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
				<span>첨부파일 <a href="#">${bbs.file_name}</a></span>			
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
	<a class="black_btn" href="#">수정</a>
	<a class="black_btn" href="#">삭제</a>
	<a class="white_btn" href="#">목록</a>
</div>


<div class="bv_commnet">

</div>

<!-- 원글을 의미하는 원글의 기본키 -->
	<form method="post" action="ans_write.jsp">
		이름:<input type="text" name="writer"/><br/>
		내용:<textarea rows="4" cols="55" name="content"></textarea><br/>
		비밀번호:<input type="password" name="pwd"/><br/>
		<%-- <input type="hidden" name="b_idx" value="<%=bvo.getB_idx()%>">--%>
		<%--<input type="hidden" name="cPage" value="<%=cPage%>">--%>
		<input type="submit" value="저장하기"/> 
	</form>
	
	댓글들<hr/>

		<div>
			이름: cvo.getWriter &nbsp;&nbsp;
			날짜:cvo.getWrite_date() <br/>
			내용:cvo.getContent() 
		</div>
		
	<form name="frm" method="POST">
		<%--<input type="hidden" name="cPage" value="<%=cPage%>">--%>
		<%--<input type="hidden" name="b_idx" value="<%=bvo.getB_idx()%>">--%>
		<input type="hidden" name="f_name">
	</form>
	
	<script>
		function goList(){
			// location.href='list.jsp?=cPage';
		}
		
		function download(file){
			document.frm.f_name.value = file;
			document.frm.action = 'download.jsp';
			document.frm.submit();
			
		}
	</script>

</body>
</html>