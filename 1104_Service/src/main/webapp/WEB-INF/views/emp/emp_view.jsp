<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
 table {
 	width: 100%;
    border-collapse: collapse;
}

table th{
	border: 1px solid black;
	padding: 4px;
	
}

table td{
	border: 1px solid black;
	padding: 4px;
	background-color: #bcbcbc;
}
.container{
	width: 800px;
	margin: 0 auto;
	text-align: center;
}
.hand{
	cursor : pointer;
}
</style>

<body>
	<header>
		<h2>정보 결과</h2>
	</header>
	<article>
	<div class="container">
		<table>
			<colgroup>
				<col width="9%"/>
				<col width="9%"/>
				<col width="9%"/>
				<col width="9%"/>
			</colgroup>
			
			<tbody>
			
				<tr>
					<td>사번</td>
					  <td>${vo.employee_id}</td>
					<td>이름</td>
					<td>${vo.first_name}</td>
				</tr>
				
				<tr>
					<td>직종</td>
					<td>${vo.job_id}</td>
					<td>부서</td>
					<td>${vo.department_id}</td>
				</tr>
				
			</tbody>
		</table>
		</div>
	</article>
	
	<script>
	
	
	</script>
	
</body>
</html>