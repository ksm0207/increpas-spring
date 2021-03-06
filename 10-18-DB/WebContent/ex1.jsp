<%@page import="mybatis.vo.EmpVO"%>
<%@page import="mybatis.dao.EmpDAO"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	table{
	
		width: 600px;
		border-collapse: collapse;
	
	}
	table th, table td {
		border: 1px solid black;
		padding: 5px;
	}	
</style>
<body>

<%
	BeanFactory bf = new ClassPathXmlApplicationContext("config.xml");
	System.out.println("BF : "+ bf);
	
	// EmpVO[] vo = (EmpVO[])bf.getBean("total");
	
	EmpDAO dao = (EmpDAO)bf.getBean("total");
	
	// 전체 사원 가져오기
	EmpVO[] vo = dao.getTotal();
	request.setAttribute("vo", vo);
%>
<div>
	<header>
		<h1>사원목록</h1>
	</header>
	<article>
		<table style="text-align: center">
			<colgroup>
					<col width="30px"/>
					<col width="100px"/>
					<col width="150px"/>
					<col width="*"/>
			</colgroup>
	<thead>
		
		<tr>
			<td colspan="5">
				<h3>Employees All</h3>
			</td>
		</tr>
		
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>직종</th>
			<th>입사일</th>
			<th>부서코드</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="evo" items="${vo}">
		<tr>
			<td>${evo.employee_id}</td>
			<td>${evo.first_name}</td>
			<td>${evo.job_id}</td>
			<c:if test="${evo.hire_date != null}">
				<td>${fn:substring(evo.hire_date,0,10)} </td>
			</c:if>
			<td>${evo.department_id}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
	</article>

</div>


</body>
</html>