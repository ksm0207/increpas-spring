package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import mybatis.vo.EmpVO;

public class EmpDAO {
	
	public EmpDAO() {
		System.out.println("Listener on");
	}

	private SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public EmpVO[] total() {
		
		EmpVO[] er = null;
		
		List<EmpVO> list = session.selectList("emp.total");
		
		if(!list.isEmpty()) {
			er = new EmpVO[list.size()];
			list.toArray(er);
		}
		return er;
	}
	
	public EmpVO[] search(String type , String value) {
		
		EmpVO[] er = null;
		Map<String,String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("value", value);
		List<EmpVO> list = session.selectList("emp.search",map);
		
		if(!list.isEmpty()) {
			er = new EmpVO[list.size()];
			list.toArray(er);
		}
		
		return er;
	}
	
	public EmpVO view(String idx) {
		
		EmpVO vo = session.selectOne("emp.view",idx);
		
		return vo;
	}
}
