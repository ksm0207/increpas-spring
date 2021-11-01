package com.increpas.jdomex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.vo.TestVO;

@Controller
public class XmlParsingTestController {
	
	@Autowired
	ServletContext context;

	@RequestMapping("/test.do")
	public String showView(Model model) {
		
		SAXBuilder builder = new SAXBuilder();
		
		String path = "/resources/pm/data/member.xml";
		String realPath = context.getRealPath(path);
		String name = null;
		String email = null;
		
	
		try {
			
			Document doc = builder.build(realPath); // xml
			System.out.println(doc);
			Element root = doc.getRootElement(); // <members> 부모
			
			List<TestVO> list = new ArrayList<TestVO>();
			Iterator<Element> iter = root.getDescendants(new ElementFilter("member"));
			
			while(iter.hasNext()) {
				Element e = (Element)iter.next();
				name = e.getChildText("name");
				email = e.getChildText("email");
				
				TestVO vo = new TestVO(name, email);
				list.add(vo);
				
				model.addAttribute("vo", list);
			}
			/*
			for(Element e : list) {
			
				name = e.getChildText("name");
				email = e.getChildText("email");
				
				System.out.println(name);
				System.out.println(email);
				
			}
			*/
		//	model.addAttribute(list)
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "test";
	}
}
