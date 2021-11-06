<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>



</head>
<body>

	<div>
		<div>
			<form action="getBidDate.do" method="POST" name="sform">
				<span>입찰 시작일</span>
				<input type="text" id="startDate" name="startDate" >
				
				<span>입찰 종료일</span>
				<input type="text" id="endDate" name = "endDate" >
				<button type="button" onclick="getSearch()" >검색</button>
			</form>
		</div>
		
		
		
		
	</div>
	<script>
	$( function() {
	    $( "#startDate" ).datepicker({
	    	
	    	changeMonth: true,
	    	changeYear: true,
	    	nextText: '다음 달',
	    	prevText: '이전 달',
	    	dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'], dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'], monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    	dateFormat: "yymmdd",

	    });
	    
	 $( "#endDate" ).datepicker({
	    	
	    	changeMonth: true,
	    	changeYear: true,
	    	nextText: '다음 달',
	    	prevText: '이전 달',
	    	dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'], dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'], monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    	dateFormat: "yymmdd",

	    });
	  
	
	});
	
	
	function getSearch(){
		
		console.log("ready");
		
		let startDate = document.getElementById("startDate").value;
		let endDate = document.getElementById("endDate").value;
		
		console.log(startDate);
		console.log(endDate);
		
		if(startDate == null && endDate == null ){
			alert('비어있는 입력란이 있습니다.');
			return false;
		}
		
		document.sform.action = "data_res.do";
		document.sform.submit();
		
	}
	
	
	
	</script>
</body>
</html>