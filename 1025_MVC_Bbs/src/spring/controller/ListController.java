package spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.Controller;

import mybatis.dao.BoardDAO;
import mybatis.vo.BoardVO;
import spring.util.Paging;
import sun.security.krb5.internal.PAEncTSEnc;

@EnableWebMvc
public class ListController implements Controller {
	
	@Autowired
	private BoardDAO b_dao;
	
	// 페이징 기법을 위한 상수 선언.
	public final int BLOCK_LIST = 5; // 한 페이지당 보여질 게시물의 수
	public final int BLOCK_PAGE = 5; // 한 블럭당 보여지는 페이지 수
	
	int nowPage; // 현재 페이지
	int rowTotal; // 전체 게시물
	
	String pageCode; // 페이징 처리된 HTML코드가 저장되는 변수
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		// 현재 페이지 값 파라미터로 얻기
		String c_page = request.getParameter("cPage");
		System.out.println("현재페이지 :" + c_page);
		
		if(c_page == null) {
			nowPage = 1;
			System.out.println("c_page != null" + c_page != null);
		}else {
			nowPage = Integer.parseInt(c_page);
			System.out.println("NowPage : " + nowPage);
		}
		
		Paging page = new Paging(nowPage, rowTotal, BLOCK_LIST, BLOCK_PAGE);		
		pageCode = page.getSb().toString(); // HTML 코드 저장
		
		//게시판 종류를 구별하기 위한 파라미터를 받는다.
		String bname = request.getParameter("bname");
		System.out.println("Board Name :" + bname);
		if(bname == null) {
			bname ="BBS";
			System.out.println("bname == null" + bname == null);
		}
		
		// 총 게시물의 수를 얻어낸다.
		rowTotal = b_dao.getTotalCount(bname);
		System.out.println("RowTotal :" + rowTotal);
		// 페이징 처리를 하기 위한 객체 생성
		
		
		
		// JSP에서 표현할 게시물들의 목록을 받아내기 위해 begin / end 값을 구하자.
		
		int begin = page.getBegin();
		int end = page.getEnd();
		
		BoardVO [] ar = b_dao.getList(begin, end, bname);
		// b_dao.getList(page.getBegin(), page.getEnd(), bname);
		
		// JSP에서 사용해야 할 값들을 저장 후 뿌려주기
		mv.addObject("bbs_total",ar);
		mv.addObject("nowPage",nowPage);
		mv.addObject("rowTotal",rowTotal);
		mv.addObject("blockList",BLOCK_LIST);
		mv.addObject("pageCode",pageCode);
		
		mv.setViewName("list");
		return mv;
	}

}
