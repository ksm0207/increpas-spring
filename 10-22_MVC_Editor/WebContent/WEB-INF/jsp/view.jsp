<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="mybatis.vo.CommentVO"%>
<%@page import="mybatis.vo.BbsVO"%>
<%@page import="mybatis.dao.BbsDAO"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	#bbs table {
	    width:580px;
	    margin-left:10px;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	#bbs table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	#bbs table th {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	#bbs table td {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	.no {width:15%}
	.subject {width:30%}
	.writer {width:20%}
	.reg {width:20%}
	.hit {width:15%}
	.title{background:lightsteelblue}
	
	.odd {background:silver}
	
		
</style>

</head>

<%!
	ArrayList<BbsVO> r_list;

	public boolean checkBbs(BbsVO bvo){
		boolean check = true;
		
		for(BbsVO vo : r_list){
			//if(vo.getB_idx().equals(bvo.getB_idx())){
			int a = vo.getB_idx().compareTo(bvo.getB_idx());
			
			if(a == 0){
				check = false;
				break;
				
			}
				
			
				//}
		}
		/*
		for(int i=0; i<r_list.size() ; i ++){
			BbsVO vo = r_list.get(i);
			
			if(vo.getB_idx().equals(bvo.getB_idx())){
				check = false;
				break;
			}
			
		}
		*/
		
		return check; // return false;
	}
	
%>
	

<body>
<%
		String index = request.getParameter("b_idx");
		// cPage : 원래 페이지로 돌아가기위한 변수
	    String cPage = request.getParameter("cPage");
		
		// view.jsp 에서 새로고침을 하면 조회수가 늘어나는것을 방지 시작
		// 1. 세션에 저장된 read_list이름의 객체를 얻는다. - 세션처리
		Object obj = session.getAttribute("read_list");
		System.out.println("Object : "+obj);
		
		if(obj == null){
			// 저장된 겂이 없으니깐 만들어서 저장해주기
			r_list = new ArrayList<BbsVO>();
			System.out.println("r_list size() : " + r_list);
			session.setAttribute("read_list", r_list);
			
			
		}else{
			r_list = (ArrayList<BbsVO>)obj;
		}
		System.out.println("r_list size() : " + r_list);
		int b_idx = Integer.parseInt(index);
		
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		System.out.println(context);
		BbsDAO dao = context.getBean(BbsDAO.class);
		
		if(b_idx > 0){
			
			BbsVO bvo = dao.search(b_idx);;
			
			boolean flag = checkBbs(bvo); // 한번이라도 읽은 게시물인지 확인하는 메소드 
			// 한번 읽기를 한 게시물은 r_list에 저장됨.
			// bvo 가 r_list에 있다면 조회수가 +1 한 경우
			// 없으면 조회수를 늘려준다
			System.out.println("Flag : " + flag);
			
			if(flag){
				r_list.add(bvo);
				dao.setBoardHit(index);
			}
	
%>
	<div id="bbs">
	<form method="post" name = "form">
		<table summary="게시판 글쓰기">
			<caption>게시판 글쓰기</caption>
			<tbody>
				<tr>
					<th>제목:</th>
					<td><%=bvo.getSubject()%></td>
				</tr>
						<%
							if(bvo.getFile_name() != null && bvo.getFile_name().length() > 4){
						%>
				<tr>
					<th>첨부파일:</th>
					<td><a href="javascript: download('<%=bvo.getFile_name() %>')">
						<%=bvo.getFile_name() %>
					</a></td>
				</tr>
					<%
						}
					%>
				<tr>
					<th>이름:</th>
					<td><%=bvo.getWriter() %> </td>
				</tr>
				<tr>
					<th>내용:</th>
					<td><%=bvo.getContent() %></td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="button" value="수정" onclick="javascript:location.href='edit.jsp?cPage=<%=cPage%>&b_idx=<%=bvo.getB_idx()%>'"/>
						
						<input type="button" value="삭제"/>
						<input type="button" value="목록" onclick="goList();"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>

	<!-- 원글을 의미하는 원글의 기본키 -->
	<form method="post" action="ans_write.jsp">
		이름:<input type="text" name="writer"/><br/>
		내용:<textarea rows="4" cols="55" name="content"></textarea><br/>
		비밀번호:<input type="password" name="pwd"/><br/>
		<input type="hidden" name="b_idx" value="<%=bvo.getB_idx()%>">
		<input type="hidden" name="cPage" value="<%=cPage%>">
		<input type="submit" value="저장하기"/> 
	</form>
	
	댓글들<hr/>
	
	<%
		List<CommentVO> c_list = bvo.getCvo_list();
		for(CommentVO cvo : c_list){
	
	%>
	
		<div>
			이름:<%=cvo.getWriter() %> &nbsp;&nbsp;
			날짜:<%=cvo.getWrite_date() %><br/>
			내용:<%=cvo.getContent() %>
		</div>
	</div>
	<%
		}
	%>
	<form name="frm" method="POST">
		<input type="hidden" name="cPage" value="<%=cPage%>">
		<input type="hidden" name="b_idx" value="<%=bvo.getB_idx()%>">
		<input type="hidden" name="f_name">
	</form>
	<%
		}else{
			response.sendRedirect("list.jsp");
	%>
			
	<%
		}
	%>
	
	<script>
		function goList(){
			location.href='list.jsp?=<%=cPage%>';
		}
		
		function download(file){
			document.frm.f_name.value = file;
			document.frm.action = 'download.jsp';
			document.frm.submit();
			
		}
	</script>
	
</body>
</html>

	
