<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
	<style>
		table{
			width: 500px;
			border-collapse: collapse;
		}
		table th, table td{
			padding: 4px;
			border: 1px solid black;
		}
		#s_win{ display: none; }
	</style>
</head>
<body>
	<header>
		<h1>비동기식 통신</h1>
	</header>
	<article>
		<table>
			<caption>비동기식 통신 연습</caption>
			<colgroup>
				<col width="70px"/>
				<col width="120px"/>
				<col width="*"/>
				<col width="70px"/>
			</colgroup>
			<thead>
				<tr>
					<td colspan="4">
						<button type="button" id="btn">확인</button>
						<%-- btn을 클릭했을 때 ex1_res.inc라는 경로로 
							비동기식 통신을 수행한다. --%>
							
						<button type="button" id="s_btn">검색</button>	
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
	
	<div id="s_win" title="검색창">
		<div id="content">
			<select id="type">
				<option value="0">사번</option>
				<option value="1">이름</option>
			</select>
			<input type="text" id="value"/><br/><br/>
			<button type="button" id="s_btn2">검색</button>
		</div>
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	<script>
		$(function(){
			
			
			
			//검색버튼을 클릭했을 때 
			$("#s_btn").bind("click", function(){
				$("#s_win").dialog();
			});
			
			//대화상자에서 검색버튼을 클릭했을 때
			$("#s_btn2").bind("click", function(){
				//id가 type인 요소의 값
				var type = $("#type").val();
				
				//id가 value인 요소의 값
				var value = $("#value").val();
				
				//유효성 검사
				
				//var param = "type="+encodeURIComponent(type)+
				//	"&value="+encodeURIComponent(value);
				$.ajax({
					url: "ex2.inc",
					data: {"type":type, "value":value},
					type: "post",
					dataType: "json",
				}).done(function(data){
					var str = "";
					for(var i=0; i<data.ar.length; i++){
						str += "<tr><td>";
						str += data.ar[i].employee_id;
						str += "</td><td>";
						str += data.ar[i].first_name;
						str += "</td><td>";
						str += data.ar[i].job_id;
						str += "</td><td>";
						str += data.ar[i].department_id;
						str += "</td></tr>";						
					}
					$("table tbody").html(str);
					$("#s_win").dialog("destroy");
				}).fail(function(err){
					
				});
			});
			
			//아이디가 btn인 요소를 클릭했을 때를 의미하는 이벤트!
			$("#btn").bind("click", function(){
				
				$.ajax({
					url: "ex1_res.inc", //요청경로
					type: "post", //요청방식
					dataType: "json" //받는 데이터의 타입
				}).done(function(data){ //요청 성공시
					//alert(data.length+","+data[1].first_name);
					//alert(data.len+","+data.ar[1].first_name);
					var code = "";
					for(var i=0; i<data.len; i++){
						code += "<tr><td>";
						code += data.ar[i].employee_id;
						code += "</td><td>";
						code += data.ar[i].first_name;
						code += "</td><td>";
						code += data.ar[i].job_id;
						code += "</td><td>";
						code += data.ar[i].department_id;
						code += "</td></tr>";
					}//for의 끝
					//위 반복문에서 만든 tr들을 tbody에 HTML로 적용
					$("table tbody").html(code);
				
				}).fail(function(err){ //요청 실패시
					
				});
			});
		});
	</script>
</body>
</html>










