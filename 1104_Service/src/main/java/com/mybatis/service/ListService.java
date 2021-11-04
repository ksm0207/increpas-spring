package com.mybatis.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.EmpDAO;
import com.mybatis.vo.EmpVO;

@Service
public class ListService implements EmpService {
	
	@Autowired
	private EmpDAO dao;
	
	@Override
	public EmpVO[] all() throws Exception {
		// TODO Auto-generated method stub
		return dao.all();
	}
	
	@Override
	public EmpVO searchEmpno(String employee_id) throws Exception {
		
		System.out.println("ListService {searchEmpno} Param : " + employee_id);
		
		return dao.searchEmpno(employee_id);
	}

	@Override
	public EmpVO[] search(String searchType, String searchValue) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("searchType", searchType);
		map.put("searchValue", searchValue);
		
		return dao.search_empno(map);
	}

	

}
