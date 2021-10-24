package spring.bbs.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.BoardDAO;
import mybatis.vo.BoardVO;
import spring.bbs.util.PageNation;

@Controller
public class PageAction {
	
	@Autowired
	HttpServletRequest request;
	@Autowired
	BoardDAO board;
	
	@RequestMapping(value="/list.do",method = RequestMethod.GET)
	public ModelAndView test() {
		
		ModelAndView mv = new ModelAndView();
		PageNation page = new PageNation();
		
		// 총 게시물 수 저장
		page.setTotalRecord(board.bbsTotal());
		
		String cPage = request.getParameter("cPage");
		
		if(cPage != null) {
			int nowPage = Integer.parseInt(cPage);
			System.out.println("cPage : " + cPage);
			page.setNowPage(nowPage);
		}else {
			page.setNowPage(page.getNowPage());
		}
		
		BoardVO[] bbs = board.bbsGetList(page.getStart(), page.getEnd());
		
		mv.addObject("page",page);
		mv.addObject("bbs_total",bbs);
		
		mv.setViewName("list");
		
		return mv;
		
	}

}
