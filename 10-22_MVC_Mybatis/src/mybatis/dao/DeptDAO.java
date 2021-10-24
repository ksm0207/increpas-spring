package mybatis.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.DeptVO;

@Component
public class DeptDAO {

	@Autowired
	private SqlSessionTemplate sst;
	
	public DeptVO[] getTotal() {
		
		DeptVO[] d_ar = null;
		
		List<DeptVO> list = sst.selectList("dept.total");
		
		if(!list.isEmpty()) {
			d_ar = new DeptVO[list.size()];
			list.toArray(d_ar);
		}
		return d_ar;
	}
}
