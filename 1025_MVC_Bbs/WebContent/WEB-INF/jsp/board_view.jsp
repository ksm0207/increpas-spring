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

	<div class="bv_border_tLine">
		<div class="top_container">
		<span class="fl_writer">글쓴이 : ${bbs.writer}</span>
		<c:if test="${bbs.write_date ne null }">
			<span class="fr_write_date">${fn:substring(bbs.write_date,0,10)}</span>		
		</c:if>
		<span style="float: right">조회수 : ${bbs.hit}</span>
		</div>
	</div>
	
	<div class="bv_middle_line">
		<span>[${bbs.bname}]</span>
		<span>${bbs.subject}</span>
	</div>
	
	<div class="bv_boder_bLine"></div>
	
	<div class="bv_bottom_line">
		<span>첨부파일 :<a href="#">${bbs.file_name}</a></span>
	</div>
</div>

<div class="bv_commnet">

</div>

</body>
</html>