package com.home.app;

import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.vo.DataVO;

@Controller
public class DataController {
	
	private String RNUM;
	private String PLNM_NO;
	private String PBCT_NO;
	private String PBCT_CDTN_NO;
	private String CLTR_NO;
	private String CLTR_HSTR_NO;
	private String SCRN_GRP_CD;
	private String CTGR_FULL_NM;
	private String BID_MNMT_NO;
	private String CLTR_NM;
	private String CLTR_MNMT_NO;
	private String LDNM_ADRS;
	private String NMRD_ADRS;
	private String LDNM_PNU;
	private String DPSL_MTD_CD;
	private String DPSL_MTD_NM;
	private String BID_MTD_NM;
	private String MIN_BID_PRC;
	private String APSL_ASES_AVG_AMT;
	private String FEE_RATE;
	private String PBCT_BEGN_DTM;
	private String PBCT_CLS_DTM;
	private String PBCT_CLTR_STAT_NM;
	private String USCBD_CNT;
	private String IQRY_CNT;
	private String GOODS_NM;
	private DataVO vo;
	
	
	@RequestMapping("/data.do")
	public String showView() {
		
		return "data";
	}
	
	@RequestMapping("/data_res.do")
	public ModelAndView getXMLParsing(String startDate, String endDate) {
		System.out.println("do");
		ModelAndView mv = new ModelAndView();
		
		StringBuffer sb = new StringBuffer("http://openapi.onbid.co.kr/openapi/services/KamcoPblsalThingInquireSvc/getKamcoPbctCltrList?");
		
		
		sb.append("serviceKey=");
		sb.append("0SejzUWse4klmxjJaW0m5OqkvGIK1CA1OWv37uv8%2BBNI%2BMxy6hew8zceRpHaLOEqWp5iJCujwnE7K%2FVdNAlehA%3D%3D");
		sb.append("&pageNo=1");
		sb.append("&numOfRows=10");
		sb.append("&DPSL_MTD_CD=0001");
		sb.append("&CTGR_HIRK_ID=10000");
		sb.append("&CTGR_HIRK_ID_MID=10100");
		sb.append("&PBCT_BEGN_DTM=20211101");
		sb.append("&PBCT_CLS_DTM=20211231");
		
		try {
			URL url = new URL(sb.toString());
		
				
			URLConnection con = url.openConnection();
			con.setRequestProperty("Content-Type", "application/xml");
			con.connect();
			
			SAXBuilder builder = new SAXBuilder();
			
			Document doc = builder.build(con.getInputStream());
			
			Element root = doc.getRootElement();
			
			List<DataVO> list = new ArrayList<DataVO>();
			
			
			Iterator<Element> iter = root.getDescendants(new ElementFilter("item"));
			while(iter.hasNext()) {
				Element e = (Element)iter.next();
				
				RNUM = e.getChildText("RNUM");
				PLNM_NO = e.getChildText("PLNM_NO");
				PBCT_NO = e.getChildText("PBCT_NO");
				PBCT_CDTN_NO = e.getChildText("PBCT_CDTN_NO");
				CLTR_NO = e.getChildText("CLTR_NO");
				CLTR_HSTR_NO = e.getChildText("CLTR_HSTR_NO");
				SCRN_GRP_CD = e.getChildText("SCRN_GRP_CD");
				CTGR_FULL_NM = e.getChildText("CTGR_FULL_NM");
				BID_MNMT_NO = e.getChildText("BID_MNMT_NO");
				CLTR_NM = e.getChildText("CLTR_NM");
				CLTR_MNMT_NO = e.getChildText("CLTR_MNMT_NO");
				LDNM_ADRS = e.getChildText("LDNM_ADRS");
				NMRD_ADRS = e.getChildText("NMRD_ADRS");
				LDNM_PNU = e.getChildText("LDNM_PNU");
				DPSL_MTD_CD = e.getChildText("DPSL_MTD_CD");
				DPSL_MTD_NM = e.getChildText("DPSL_MTD_NM");
				
				BID_MTD_NM = e.getChildText("BID_MTD_NM");
				MIN_BID_PRC = e.getChildText("MIN_BID_PRC");
				APSL_ASES_AVG_AMT = e.getChildText("APSL_ASES_AVG_AMT");
				FEE_RATE = e.getChildText("FEE_RATE");
				PBCT_BEGN_DTM = e.getChildText("PBCT_BEGN_DTM");
				PBCT_CLS_DTM = e.getChildText("PBCT_CLS_DTM");
				PBCT_CLTR_STAT_NM = e.getChildText("PBCT_CLTR_STAT_NM");
				USCBD_CNT = e.getChildText("USCBD_CNT");
				IQRY_CNT = e.getChildText("IQRY_CNT");
				GOODS_NM = e.getChildText("GOODS_NM");
						
				String start = PBCT_BEGN_DTM.substring(0,8);
				String end = PBCT_CLS_DTM.substring(0,8);
				
				PBCT_BEGN_DTM = start;
				PBCT_CLS_DTM = end;
				
				vo = new DataVO(RNUM, PLNM_NO, PBCT_NO, PBCT_CDTN_NO, CLTR_NO, CLTR_HSTR_NO, SCRN_GRP_CD, CTGR_FULL_NM, BID_MNMT_NO, CLTR_NM, CLTR_MNMT_NO, LDNM_ADRS, NMRD_ADRS, LDNM_PNU, DPSL_MTD_CD, DPSL_MTD_NM, BID_MTD_NM, MIN_BID_PRC, APSL_ASES_AVG_AMT, FEE_RATE, PBCT_BEGN_DTM, PBCT_CLS_DTM, PBCT_CLTR_STAT_NM, USCBD_CNT, IQRY_CNT, GOODS_NM);
			
				System.out.println(startDate.compareTo(PBCT_BEGN_DTM));
				
				// 검색 수정예정.
				list.add(vo);
				mv.addObject("data",list);
				
				mv.setViewName("data_res");
				mv.addObject("vo",vo);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return mv;
	}
	
	
	
	

}
