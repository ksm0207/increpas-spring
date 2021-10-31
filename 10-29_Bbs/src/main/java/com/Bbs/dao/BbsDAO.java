package com.Bbs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Bbs.vo.BbsVO;

@Component
public class BbsDAO {
	
	@Autowired
	private SqlSessionTemplate sql_temp;
	
	// 게시물 총합
	public int bbsTotal(String bname) {
		
		return sql_temp.selectOne("bbs.bbsTotal",bname);
	}
	
	// 게시물 가져오기
	
	public BbsVO[] bbsList(String begin, String end, String bname) {
		BbsVO[] vo = null;
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("begin", begin);
		map.put("end", end);
		map.put("bname", bname);
		
		List<BbsVO> list = sql_temp.selectList("bbs.bbsList",map);
		
		if(list.size() > 0 && !list.isEmpty()) {
			vo = new BbsVO[list.size()];
			list.toArray(vo);
		}
		
		return vo;
	}
	
	// 검색된 게시물 가져오기
	
	public BbsVO[] bbsSearch(String select , String search) {
		
		System.out.println("bbsSearch()");
		BbsVO[] vo = null;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("select", select);
		map.put("search", search);
		
		List<BbsVO> list = sql_temp.selectList("bbs.bbsSearch",map);
		
		if(!list.isEmpty()) {
			vo = new BbsVO[list.size()];
			list.toArray(vo);
		}
		
		
		return vo;
		
	}

}
