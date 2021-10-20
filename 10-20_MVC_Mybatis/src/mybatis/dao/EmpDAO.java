package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import mybatis.vo.EmpVO;

public class EmpDAO {

	private SqlSessionTemplate session; // config.xml 파일에서 현재 DAO를 정의할 때
	                                    // <property>를 정의하면서 반드시 setter를 통해 
	                                    // 저장되도록 해야한다.
	
	
	public EmpDAO() {
		System.out.println("EmpDAO");
	}
	
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public EmpVO[] getTotal() {
		
		EmpVO[] ar = null;
		
		List<EmpVO> list = session.selectList("emp.total");
		
		if(!list.isEmpty()) {
			ar = new EmpVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
	}
	
	public EmpVO[] search(String searchType, String searchValue) {
		EmpVO[] ar = null;
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("searchType", searchType);
		map.put("searchValue", searchValue);
		
		List<EmpVO> list = session.selectList("emp.search",map);
		
		if(!list.isEmpty()) {
			ar = new EmpVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
		
	}
	
}
