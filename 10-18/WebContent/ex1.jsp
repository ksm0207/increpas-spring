<%@page import="ex1.vo.Test5"%>
<%@page import="ex1.vo.Test4"%>
<%@page import="ex1.vo.Test3"%>
<%@page import="ex1.vo.Test2"%>
<%@page import="ex1.vo.Test1"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%@page import="com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream"%>
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
    // 준비된 환경설정 파일 (config.xml)을 로드시킨다
	BeanFactory bf = new ClassPathXmlApplicationContext("config.xml");

	// ClassPathXmlApplicationContext를 호출하면
	// config.xml에 정의된 모든 bean 들이 생성시킨다.
	
	
	// 사용자가 원하는 빈객체를 얻어내준다.
	Test1 t1 = (Test1)bf.getBean("t1");
	Test2 t2 = (Test2)bf.getBean("t2");
	Test3 t3 = (Test3)bf.getBean("t3");
	Test4 t4 = (Test4)bf.getBean("t4");
	Test5 t5 = (Test5)bf.getBean("t5");
	
	// 위 상태로만 실행하면 에러가 발생하므로 원인을 분석해보자.
	// 에러 : NoClassDefFoundError
	// http://commons.apache.org/proper/commons-logging/download_logging.cgi
    // 위 경로	
%>

<h1>ex1.vo.Test1.Java</h1>
<h1><%=t1.getMsg()%></h1>
<h1><%=t1.getAge() %></h1>
------------------------------
<h1>ex1.vo.Test2.Java</h1>
<h2><%=t2.getStr()%></h2>
<h2><%=t2.getValue() %></h2>
------------------------------

<h1>ex1.vo.Test3.Java</h1>
<h2><%=t3.getMsg() %></h2>
<h2><%=t3.getV1() %></h2>
<h2><%=t3.isChk() %></h2>
------------------------------

<h1>ex1.vo.Test4.Java</h1>
<h2><%=t4.getT2().getStr() %></h2>
<h2><%=t4.getT2().getValue() %></h2>

------------------------------

<h1>ex1.vo.Test5.Java</h1>
<h2><%=t5.getT3().getMsg() %></h2>
<h2><%=t5.getT3().getV1() %></h2>
<h2><%=t5.getT3().isChk() %></h2>
<h2><%=t5.getValue() %></h2>

</body>
</html>