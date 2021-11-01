package com.example.ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.jdom2.Document;
import org.jdom2.Element;

import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.movie.vo.MovieVO;

@Controller
public class MovieController {
	
	@Autowired
	private ServletContext context;
	
	@RequestMapping("/movie")
	public ModelAndView showView() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		SAXBuilder builder = new SAXBuilder();
		
		String path = "/resources/data/movie.xml";
		String realPath = context.getRealPath(path);
		
		Document doc = builder.build(realPath);
		System.out.println(doc);
		Element root = doc.getRootElement();
		System.out.println(root);
		
		
		String name = null;
		String releasdate = null;
		String company = null;
		String screeningtime = null;
		
		
		List<MovieVO> list = new ArrayList<MovieVO>();
		Iterator<Element> iter = root.getDescendants(new ElementFilter("movie"));
		
		while(iter.hasNext()) {
			Element e = (Element)iter.next();
			// System.out.println("Element e :" + e); [Element : <movie/>]
			
		
			name = e.getChildText("name");
			System.out.println(name);
			releasdate = e.getChildText("releasdate");
			company = e.getChildText("company");
			screeningtime = e.getChildText("screeningtime");
			
			MovieVO vo  = new MovieVO(name, releasdate, company, screeningtime);
			
			list.add(vo);
			
			
			System.out.println(list.size());
			
			mv.addObject("movie", list);
			mv.setViewName("movie");
		}
		         
		return mv;
	}
}
