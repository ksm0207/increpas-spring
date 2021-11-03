package com.home.test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.go.vo.DataVO;

@Controller
public class IndexController {
	
	private String title;
	private String addr1;
	private String addr2; 
	private String tel;
	private String firstimage;
	private String firstimage2;
	private String eventstartdate;
	private String eventenddate;
	private String mapx;
	private String mapy;
	
	// public static final String PUBLIC_API_URL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?serviceKey=0SejzUWse4klmxjJaW0m5OqkvGIK1CA1OWv37uv8%2BBNI%2BMxy6hew8zceRpHaLOEqWp5iJCujwnE7K%2FVdNAlehA%3D%3D&MobileOS=ETC&MobileApp=AppTest&arrange=A&listYN=Y&eventStartDate=20211101";
	
	@RequestMapping("/")
	public ModelAndView index() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		StringBuffer sb = new StringBuffer("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?");
		sb.append("serviceKey=");
		sb.append("0SejzUWse4klmxjJaW0m5OqkvGIK1CA1OWv37uv8%2BBNI%2BMxy6hew8zceRpHaLOEqWp5iJCujwnE7K%2FVdNAlehA%3D%3D");
		sb.append("&MobileOS=ETC&MobileApp=AppTest");
		sb.append("&MobileApp=AppTest");
		sb.append("&arrange=A");
		sb.append("&listYN=Y");
		sb.append("&eventStartDate=20211101");
		sb.append("&pageNo=1"); // 문서 참고
		sb.append("&numOfRows=20"); 
		
		
		URL url = new URL(sb.toString());
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("Content-Type", "application/xml");
		con.connect(); // 참조하는 리소스에 대한 통신 링크를 오픈한다.URL
		//System.out.println(con);
		
		SAXBuilder builder = new SAXBuilder();
		
		Document doc = builder.build(url); //제공된 URL에서 문서를 작성합니다.
		                                  // con.getInputStream() 열린 연결에서 읽는 입력 스트림을 반환합니다
		
		//System.out.println("Document :" + doc);
		Element root = doc.getRootElement();
		//System.out.println("Element :" + root);
		Iterator<Element> iter =  root.getDescendants(new ElementFilter("item"));
		
		List<DataVO> list = new ArrayList<DataVO>();
		
		while(iter.hasNext()) {
			Element e = (Element)iter.next();
			
			title = e.getChildText("title");
			addr1 = e.getChildText("addr1");
			addr2 = e.getChildText("addr2");
			tel = e.getChildText("tel");
			firstimage = e.getChildText("firstimage");
			firstimage2 = e.getChildText("firstimage2");
			eventstartdate = e.getChildText("eventstartdate");
			eventenddate = e.getChildText("eventenddate");
			mapx = e.getChildText("mapx");
			mapy = e.getChildText("mamy");
			
			DataVO vo = new DataVO(title, addr1, addr2, tel, firstimage, firstimage2, eventstartdate, eventenddate, mapx, mapy);
			
			list.add(vo);
		
			mv.addObject("data",list);
			mv.setViewName("index");
		}
		
		return mv;
	}
}
