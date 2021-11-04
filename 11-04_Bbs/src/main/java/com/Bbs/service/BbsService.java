package com.Bbs.service;

import com.Bbs.vo.BbsVO;

public interface BbsService {

	public int bbsTotal(String bname);
	public BbsVO[] bbsList(String begin, String end, String bname);
}
