<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1da86eabe193b36b4d476a06264dee01&libraries=services"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1da86eabe193b36b4d476a06264dee01"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	width:800px;
	height:300px;
	border-collapse: collapse;	
	text-align: center;	
}

tr td {
	border: 1px solid black;
}

.container{

	margin: 0 auto;
	width: 500px;
	height: 200px;
}
</style>
</head>
<body>
<div class="container">
	<table class="table">
		<colgroup>
			<col width="9%">
			<col width="9%">
			<col width="9%">
			<col width="9%">
			<col width="9%">
			<col width="9%">
			<col width="9%">
			<col width="9%">
		</colgroup>
			<thead>
				<tr>
					<th>공고번호</th>
					<th>공매번호</th>
					<th>입찰시작일시</th>
					<th>입찰마감일시</th>
					<th>주소</th>
					<th>물건상태</th>
					<th>물건번호</th>
					<th>물건상세정보</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="vo" items="${data}">
				<tr>
					<td>${vo.PLNM_NO}</td>
					<td>${vo.PBCT_NO}</td>
					<c:if test="${vo.PBCT_BEGN_DTM != null}">
						<td>${fn:substring(vo.PBCT_BEGN_DTM,0,8)}</td>
					</c:if>
					
					<c:if test="${vo.PBCT_CLS_DTM != null}">
						<td>${fn:substring(vo.PBCT_CLS_DTM,0,8)}</td>
					</c:if>
					<td><a href="javascript:getAddress('${vo.CLTR_NM}')">${vo.CLTR_NM}</a></td>
					<td>${vo.PBCT_CLTR_STAT_NM}</td>
					<td>${vo.CLTR_NO}</td>
					<td>${vo.GOODS_NM}</td>
					<td>${vo.IQRY_CNT}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
		
		<div id="map" style="width:1000px;height:400px;"></div>
		
		<script>
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
</div>
</body>
</html>