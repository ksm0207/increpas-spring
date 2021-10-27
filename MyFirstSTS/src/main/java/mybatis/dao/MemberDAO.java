package mybatis.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.MemberVO;

@Component
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sst;
	
	public MemberVO login(String m_id, String m_pw) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("m_id", m_id);
		map.put("m_pw", m_pw);
		
		MemberVO vo = sst.selectOne("mem",map);
		
		return vo;
	}
}
