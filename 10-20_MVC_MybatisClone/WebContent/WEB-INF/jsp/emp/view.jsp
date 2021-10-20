<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 
	<c:if test="${emp_view ne null }">
		<span>사번 : ${emp_view.employee_id}</span><br>
		<span>이름 : ${emp_view.first_name} ${emp_view.last_name}</span><br>
		<span>직업 : ${emp_view.job_id}</span><br>
		<span>입사일 : ${emp_view.hire_date}</span><br>
		<span>부서코드 : ${emp_view.department_id}</span><br>
	</c:if>


</body>
</html>