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

table th, table td{
	border: 1px solid black;
	padding: 4px;
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
		<h2>사원 목록</h2>
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
			
			<thead>
				<tr>
					<th>사번</th>
					<th>이름</th>
					<th>직종</th>
					<th>부서코드</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="vo" items="${vo}">
				<tr class="hand" onclick="showData('${vo.employee_id}')">
					<td>${vo.employee_id}</td>
					<td>${vo.first_name}</td>
					<td>${vo.job_id}</td>
					<td>${vo.department_id}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</article>
	
	<form action="emp_view.do" method="POST" name="form">
		<input type="hidden" name="empno"> 
	</form>
	
	<script>
	
	function showData(emp_no){
		
		//document.form.empno.value=emp_no;
		//document.form.submit();
		
		location.href="emp_view.do?empno="+emp_no;
		
		alert(emp_no);
	
	}
	
	</script>
	
</body>
</html>