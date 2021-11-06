<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Line_Controls_Chart</title>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery.min.js"></script>
<!-- google charts -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<style type="text/css">


#container{
	width: 600px;
	height: 500px;
}
</style>
</head>
  <body>
  
  	<div id="container">
  	
  	</div>


  <script>
  
  google.charts.load('current', {'packages':['corechart']}); // 차트 로드
  google.charts.setOnLoadCallback(drawChart); // drawChart() 호출
  
  function drawChart() {
	  console.log("()");
	  var chart = new google.visualization.arrayToDataTable([
		  ['Year','Korea'], ['2017',900],['2018',1100],['2019',800],
		  ['2020',1250],['2021',1550]
		  
		  
		  
	  ]);
	  
	  // 속성부여
	  var options = {
		title: "Hello Google Chart!"
	  };
	  
	  // #container에 차트 그르기.
	  var chart_obj = new google.visualization.ColumnChart(document.getElementById('container'));
	  chart_obj.draw(chart,options);
	  
	  console.log(chart);
	  console.log(options);
	  console.log(chart_obj);
  }

  </script>
</html>