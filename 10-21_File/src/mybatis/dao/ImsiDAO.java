package mybatis.dao;

import org.mybatis.spring.SqlSessionTemplate;

import mybatis.vo.ImsiVO;

public class ImsiDAO {

	private SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public int writeImsi(ImsiVO vo) {
		
		int create = session.insert("imsi.add",vo);
		
		return create;
	}
	
}
