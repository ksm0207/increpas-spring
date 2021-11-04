package com.Bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bbs.dao.BbsDAO;
import com.Bbs.vo.BbsVO;

@Service
public class BbsUsingService implements BbsService {
	
	@Autowired
	private BbsDAO dao;

	@Override
	public int bbsTotal(String bname) {
		
		return dao.bbsTotal(bname);
	}

	@Override
	public BbsVO[] bbsList(String begin, String end, String bname) {
		
		return dao.bbsList(begin, end, bname);
	}

	
	
	

}
