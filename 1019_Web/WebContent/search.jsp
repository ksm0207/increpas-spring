<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="mybatis.vo.EmpVO"%>
<%@page import="mybatis.dao.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<title>Insert title here</title>
<style>
   table{
      width: 500px;
      border: 1px solid black;
      border-collapse: collapse;
   }
   table th, table td{
      border: 1px solid black;
      padding: 4px;
   }
   table thead tr{
      background-color: #dedede;
   }
   div#search_win{
      width: 250px;
      height: 180px;
      padding: 5px;
      border: 1px solid black;
      background-color: #fff;
      border-radius: 5px;
      position: absolute;
      top: 120px;
      left: 200px;
      display: none;
   }
</style>

</head>
<body>
	<header>
		<h1>전체 사원</h1>
	</header>
	<article>
		<header>
			<button type="button" class="s_btn">이름 검색</button>
			&nbsp;&nbsp;
			
			<button type="button" class="s_btn">사번 검색</button>
			&nbsp;&nbsp;
			
			<button type="button" class="s_btn">직종 검색</button>
			&nbsp;&nbsp;
		</header>
		
			<div>
				<table>
					<colgroup>
						<col width="80px">
						<col width="*">
						<col width="100">
						<col width="70">
						<col width="80px">
					</colgroup>
					
					<thead>
						<tr>
							<th>사번</th>
							<th>이름</th>
							<th>성</th>
							<th>직종</th>
							<th>부서코드</th>
						</tr>
					</thead>
					
					<tbody>
<%
	request.setCharacterEncoding("UTF-8");
	String type = request.getParameter("type");
	System.out.println(type);
	String value = null;
	
	switch(type){
	
		case "1":
			value = request.getParameter("s_name");
		
			break;
		case "0":
			value = request.getParameter("s_empno");
		
			break;
		case "3":
			value = request.getParameter("s_job");
			
			break;
	}
	
	System.out.println("type :" + type + " / " + "value : " + value);

//	BeanFactory bf = new ClassPathXmlApplicationContext("config.xml");
	// 톰켓이 구동되기전 리스너가 먼저 움직임이고  xml 파일을 찾고 로드시킨다.
	// 즉 bean 객체들이 모두 생성된 상태라고 볼 수 있다.
	// 다시말해 bean객체들은 현재 프로젝트에 저장된 상태이다.
	// context(ServletContext)에 등록.
	
//  현재 Context를 얻어내준다.
	ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
	System.out.println(context);

	// EmpDAO dao = (EmpDAO)bf.getBean("search");
	EmpDAO dao = context.getBean(EmpDAO.class); //
	
	EmpVO[] arr = dao.search(type, value);

%>

 

					<%
						for(EmpVO evo : arr){
					%>
						<tr>
							<td><%=evo.getEmployee_id() %></td>
							<td><%=evo.getFirst_name() %></td>
							<td><%=evo.getLast_name() %></td>
							<td><%=evo.getJob_id() %></td>
						</tr>
					<%
						}
					%>
					
					</tbody>
				</table>
			</div>
	</article>
	
	<div id="search_win">
		<form method="GET" action="search.jsp">
			<input type="hidden" id = "type" name="type">
			<div id="empno_s">
				<label for="s_empno">검색할 사번</label>
				<input type="text" id="s_empno" name="s_empno"><br>
			</div>
			
			<div id="name_s">
				<label for="s_empno">이름</label>
				<input type="text" id="s_name" name="s_name"><br>
			</div>
			
			<!--  
			<div id="last_s">
				<label for="s_empno">성(이름)</label>
				<input type="text" id="s_last" name="s_last"><br>
			</div>
			-->
			<div id="job_s">
				<label for="s_empno">직종</label>
				<input type="text" id="s_job" name="s_job"><br>
			</div>
			<!--  
			<div id="dept_s">
				<label for="s_empno">부서코드</label>
				<input type="text" id="s_dept" name="s_dept"><br>
			</div>
			-->
			
			<div id="btn">
				<input type="button" value="검색" id="search_btn">&nbsp;
				
				<input type="button" value="취소" id="cancel_btn">&nbsp;
			</div>
			
		</form>
	</div>
	
	<script>
	
		$(function(){
			
			$(".s_btn").on("click",function(){
				
				let selectText = $(this).text(); // <태그>value</태그>
				// console.log(selectText);
				
				
				// 먼저 search_win 안에 존재하는 div들을 모두 숨겨준다
				$("#search_win div").css("display","none");
				
				if(selectText == "이름 검색"){
					$("#name_s").css("display","block");
					$("#type").val("1");
					
					//document.forms[0].action ="searchName.jsp";
				}
				
				if(selectText == "사번 검색"){
					$("#empno_s").css("display","block");
					$("#type").val("0");
					//document.forms[0].action ="searchEmpno.jsp";
				}
				
				if(selectText == "직종 검색"){
					$("#job_s").css("display","block");
					$("#type").val("3");
					//document.forms[0].action ="searchJob.jsp";
				}
				
				$("#btn").css("display","block");
				$("#search_win").css("display","block");
			});
			
			
			$("#cancel_btn").on("click",function(){
				$("#search_win").css("display","none");
			});
			
			
			$("#search_btn").on("click",function(){
				// 유효성 검사
				console.log("보내기");
				document.forms[0].submit();
			});
		});
		
	</script>	
		
		
</body>
</html>