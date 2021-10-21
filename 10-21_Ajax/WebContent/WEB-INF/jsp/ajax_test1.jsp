<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
</head>
<style>
	table{
		width: 500px;
		border-collapse: collapse;
	}
	
	table th, table td{
		padding: 4px;
		border: 1px solid black;
	}
	
</style>
<body>
	<header>
		<h1>Spring - Ajax 연습</h1>
	</header>
	<article>
		<table>
			<caption>비동기식 통신 연습입니다.</caption>
			<colgroup>
				<col width="70px">
				<col width="120px">
				<col width="*">
				<col width="80px">
			</colgroup>
			<thead>
				<tr>
					<td colspan="4">
						<button type="button" id="btn">Ajax</button>
						<%-- 버튼클릭시 -> ex1_res.inc 경로로 비동기식 통신을 수행하기 --%>
					
					</td>
				</tr>
			
				<tr>
					<th>사번</th>
					<th>이름</th>
					<th>직종</th>
					<th>부서</th>
				</tr>
			</thead>
			
			<tbody>
				
			</tbody>
		</table>
	</article>
	
	<div id="search_win">
	
	</div>
	
	<script>
	
		$(function(){
			$("#btn").on("click",function(){
				
				$.ajax({
					type : "POST",
					url : "ajax_res.do",
					dataType :"json"
				})
				.done(function(data){
				//	alert("성공 :" + data[0].first_name);
					alert(data.len+" / " + data.ar[1].first_name);	
					
					let res = "";
					
					
					for(let i=0; i < data.len; i ++){
						console.log(data.ar[i]);
						res += "<tr>";
					
						res += "<td>"+data.ar[i].employee_id+"</td>";
						res += "<td>" +data.ar[i].first_name +"</td>";
						res += "<td>"+data.ar[i].job_id+"</td>";
						res += "<td>"+data.ar[i].department_id+"</td>";
						
						res += "</tr>";
					}
					
					$("table tbody").html(res);
					
					
				})
				
				.fail(function(data){
					alert("실패 :" + data);
				})
			})
		});
	
	</script>
	

</body>
</html>