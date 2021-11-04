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


<style type="text/css">


.container{
	width: 800px;
	margin: 0 auto;
	text-align: center;
}
table {
	width: 100%;
    height: 200px;
	
	border: 1px solid #444;
}
th, td {
	border: 1px solid #444;
}
td {
	height: 50px;
}
img {
  width: 100px;
  object-fit: cover;
}

caption {
	text-indent: -9999px;
}

#search_win{    
    width: 1000px;
    height: 500px;
    border: 1px solid red;
}

 button {
  background-color: #F9B514;
  padding: 5px 10px;
  border-radius: 4px;
  cursor: pointer;
}

.modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal .bg {
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.6);
}

.modalBox {
  position: absolute;
  background-color: #fff;
  width: 1000px;
  height: 700px;
  padding: 15px;
}

.modalBox button {
  display: block;
  width: 80px;
  margin: 0 auto;
}

.hidden {
  display: none;
}

</style>
</head>
<body>
	<h2>공공데이터 - 한국환경공단 전기자동차 충전소 정보</h2>
	<div class ="container">
		<header>
			<h2>현황</h2>
		</header>
		
		<table style="text-align: center" id="table">
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
					<td><a class="" href="javascript:getAddress('${vo.addr}')">${vo.addr}</a></td>
					<td>${vo.busiCall}</td>
					<td>${vo.limitYn}</td>
					<td>${vo.useTime}</td>
					<td>${vo.note}</td>
					<td style="display: none">${vo.statid}</td>
					<td style="display: none">${vo.chgerid}</td>
					<td style="display: none">${vo.stat}</td>
					<td style="display: none">${vo.chgerType}</td>
					<td style="display: none">${vo.lat}</td>
					<td style="display: none">${vo.lng}</td>
					<td style="display: none">${vo.busiNm}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
  <div class="modal hidden">
  <div class="bg"></div>
 
  <div class="modalBox">
  		<div id="map" style="width:1000px;height:400px;"></div>
  		<div class="modalText">
  		
  		</div>
  	
  	<!--  
	 
	    <span>충전소 : ${vo.statid}</span><br>
	    <span>충전기 : ${vo.chgerid}</span><br>
	    <span>충전기상태 : ${vo.stat}</span><br>
	    <span>충전소 타입 : ${vo.chgerType}</span><br>
	 
	    <span>위도 : ${vo.lat}</span><br>
	    <span>경도 : ${vo.lng}</span><br>
	    <span>운영기관명 :  ${vo.busiNm}</span><br>
	    <span>운영기관연락처 : ${vo.busiCall}</span><br>
	-->
	     <button class="closeBtn">✖</button>
  </div>
   
   
</div>
	
	<script>
	
	const open = () => {
	    document.querySelector(".modal").classList.remove("hidden");
	  }

	  const close = () => {
	    document.querySelector(".modal").classList.add("hidden");
	  }

	  document.querySelector(".container").addEventListener("click", open);
	  document.querySelector(".closeBtn").addEventListener("click", close);
	  document.querySelector(".bg").addEventListener("click", close);
	  
	  $("#table tr").on("click",function(){
		 
		  let tr = $(this);
		  let td = tr.children();
		  let tdArray = new Array();
			
			// tr.text()는 클릭된 Row 즉 tr에 있는 모든 값을 가져온다.
			console.log("클릭한 Row의 모든 데이터 : "+tr.text());
		
			let str = "";
		
				let statNm = td.eq(0).text();	
				let addr = td.eq(1).text();
				let busiCall = td.eq(2).text();
				let limitYn = td.eq(3).text();
				let useTime = td.eq(4).text();
				let note = td.eq(5).text();
				let statid = td.eq(6).text();
				let chgerid = td.eq(7).text();
				let stat = td.eq(8).text();
				let chgerType = td.eq(9).text();
				let lat = td.eq(10).text();
				let lng = td.eq(11).text();
				let busiNm = td.eq(12).text();
			
		
			str += "<span>충전소명 : "+statNm+"</span>" +"<br>" + "<span>주소 :" + addr +"</span>"+ "<br>"
			       +"<span>운영기관연락처 : "+busiCall + "</span>" +"<br>"+ "<span>이용자 제한" + limitYn + "</span>" + "<br>"
			       +"<span>이용가능시간 : " + useTime +  "</span>" +"<br>" + "<span>충전소 안내 : " + note + "</span>" + "<br>"
			       +"<span>충전소 : " + statid + "</span>" + "<br>" + "<span>충전기 : " + chgerid +"</span>" + "<br>"
			       +"<span>충전기 상태 : " +stat +"/<span>" + "<br>" + "<span>충전기 타입 : " + chgerType + "</span>" +"<br>"
			       +"<span>위도 : " + lat +"</span>" +"<br>" + "<span>경도 : " + lng +"</span>" +"<br>"
			       +"<span>운영기관명 : " + busiNm +"</span>" +"<br>";
			       
			
			
		    $(".modalText").html(str);
			
			
		  
	  });
	
	
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