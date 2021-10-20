<%@page import="ex1.Test2Action"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>번호 : ${idx}</h1>
	<h1>이름 : ${name}</h1>
	<h1>나이 : ${age}</h1>
	<h1>이메일 : ${email}</h1>
	<h1>연락처 : ${phone}</h1>
	
	<h1>====================</h1>
	
</body>
</html>