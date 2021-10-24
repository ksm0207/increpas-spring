package mybatis.dao;

import org.mybatis.spring.SqlSessionTemplate;

public class EmpDAO {

	private SqlSessionTemplate sst;
	
	public void setSst(SqlSessionTemplate sst) {
		this.sst = sst;
	}
}
