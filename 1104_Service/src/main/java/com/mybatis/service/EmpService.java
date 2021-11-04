package com.mybatis.service;


import com.mybatis.vo.EmpVO;

// Service 개념 시작!!
public interface EmpService {
	
	public EmpVO[] all() throws Exception;
	public EmpVO searchEmpno(String empno) throws Exception;
	public EmpVO[] search(String searchType, String searchValue) throws Exception;
	
}
