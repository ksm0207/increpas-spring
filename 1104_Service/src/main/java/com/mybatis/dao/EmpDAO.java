package com.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mybatis.vo.EmpVO;

@Component
public class EmpDAO {
	
	@Autowired
	private SqlSessionTemplate sst;
	
	public EmpDAO() {
		System.out.println("DAO 호출");
	}
	
	public EmpVO[] all() {
		
		EmpVO[] vo = null;
		
		List<EmpVO> list = sst.selectList("emp.all");
		
		if(list != null && !list.isEmpty()) {
			
			vo = new EmpVO[list.size()];
			
			list.toArray(vo);
		
		}
		return vo;
	}
	
	public EmpVO searchEmpno(String employee_id) {
		
		return sst.selectOne("emp.search_empno",employee_id);
	}
	
	public EmpVO[] search_empno(Map<String, String> map) {
		
		EmpVO[] vo = null;
		
		List<EmpVO> list = sst.selectList("emp.search_empno",map);
		
		if(list != null && !list.isEmpty()) {
			
			vo = new EmpVO[list.size()];
			list.toArray(vo);
			
			
		}
		return vo;
	}

}
