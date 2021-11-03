<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1da86eabe193b36b4d476a06264dee01&libraries=services"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1da86eabe193b36b4d476a06264dee01"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>


</head>
<body>
	<h2>공공데이터 - 한국환경공단 전기자동차 충전소 정보</h2>
	<div class ="container">
		<header>
			<h2>현황</h2>
		</header>
		
		<table style="text-align: center">
		<caption>정보</caption>
		<colgroup>
			<col width="9%">
			<col width="9%">
			<col width="9%">
			<col width="9%">
			<col width="9%">
			<col width="9%">
		</colgroup>
			<thead>
				<tr>
					<th>충전소명</th>
					<th>주소</th>
					<th>연락처</th>
					<th>이용자제한</th>
					<th>이용가능시간</th>
					<th>충전소안내</th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach var="vo" items ="${data}" varStatus="i">
				<tr>
					<td>${vo.statNm}</td>
					<td><a id="search" href="javascript:getAddress('${vo.addr}')">${vo.addr}</a></td>
					<td>${vo.busiCall}</td>
					<td>${vo.limitYn}</td>
					<td>${vo.useTime}</td>
					<td>${vo.note}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div id="search_win" title="Basic dialog">
  			<div id="map" style="width:500px;height:400px;"></div>
	</div>
	
	
	
	
	
	<script>
	
	$(function(){
		
		$("#search").on("click",function(){
			$("#search_win").dialog();
		})
	})
	
	
	function getAddress (address){
		
		let myAddress = address;
		
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			level: 8
		};

		var map = new kakao.maps.Map(container, options);
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(myAddress, function(result, status) {

	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {
		
	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
				
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div class="marker">위치</div>'
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        	map.setCenter(coords);
	   		 } 
		});
		
	}
		
	</script>
</body>
</html>