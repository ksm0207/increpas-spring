<%@page import="pm.action.TestAction"%>
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

<%
	ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
	TestAction ta =  context.getBean("action",TestAction.class);
%>

<h1>Name : <%=ta.getTvo().getName()%></h1>
<h1>Email : <%=ta.getTvo().getEmail()%></h1>

</body>
</html>