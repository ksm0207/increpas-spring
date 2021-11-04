package com.home.test;

import java.net.MalformedURLException;
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

import kr.go.vo.DataVO3;

@Controller
public class Data3Controller {
	
	private String limitYn; // 이용자 제한
	private String stat; // 충전기상태
	private String busiCall; // 운영기관연락처
	private String busiNm; // 운영기관명
	private String useTime; // 이용가능시간
	private String lat; // 위도
	private String lng; // 경도
	private String addr; // 주소 
	private String chgerType; // 충전기타입
	private String chgerid; // 충전기
	private String statid; // 충전소
	private String statNm; // 충전소 명
	private String note; // 충전소 안내
	private DataVO3 vo;
	
	@RequestMapping("/car")
	public ModelAndView getXMLParsing() {
		ModelAndView mv = new ModelAndView();
		
		StringBuffer sb = new StringBuffer("http://apis.data.go.kr/B552584/EvCharger/getChargerInfo?");
		
		sb.append("serviceKey=");
		sb.append("0SejzUWse4klmxjJaW0m5OqkvGIK1CA1OWv37uv8%2BBNI%2BMxy6hew8zceRpHaLOEqWp5iJCujwnE7K%2FVdNAlehA%3D%3D");
		sb.append("&numOfRows=10");
		sb.append("&pageNo=1");
		
		try {
			URL url = new URL(sb.toString());
			
			URLConnection con =  url.openConnection();
			
			con.setRequestProperty("Content-Type", "application/xml");
			con.connect();
			
			SAXBuilder builder = new SAXBuilder();
			
			Document doc = builder.build(con.getInputStream());
			
			Element root = doc.getRootElement();
			System.out.println("Root : " + root);
			
			List<DataVO3> list = new ArrayList<DataVO3>();
			Iterator<Element> iter = root.getDescendants(new ElementFilter("item"));
			
			while(iter.hasNext()) {
				
				Element e = (Element)iter.next();
			
				limitYn = e.getChildText("limitYn");
				stat = e.getChildText("stat");
				busiCall = e.getChildText("busiCall");
				busiNm = e.getChildText("busiNm");
				useTime = e.getChildText("useTime");
				lat = e.getChildText("lat");
				lng = e.getChildText("lng");
				addr = e.getChildText("addr");
				chgerType = e.getChildText("chgerType");
				chgerid = e.getChildText("chgerid");
				statid = e.getChildText("statid");
				statNm = e.getChildText("statNm");
				note = e.getChildText("note");
				
				System.out.println("충전소  : " + statid);
				System.out.println("충전기  : " + chgerid);
				
				vo = new DataVO3(limitYn, stat, busiCall, busiNm, useTime, lat, lng, addr, chgerType, chgerid, statid, statNm,note);
				list.add(vo);
			}
			
			mv.addObject("data",list);
			mv.addObject("vo", vo);
			mv.setViewName("car");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return mv;
	}

}
