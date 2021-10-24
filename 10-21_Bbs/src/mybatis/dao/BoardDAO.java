package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import mybatis.vo.BoardVO;

public class BoardDAO {
	
	public BoardDAO() {
		System.out.println("1.BoardDAO()");
	}
	
	private SqlSessionTemplate sst;
	
	public void setSst(SqlSessionTemplate sst) {
		this.sst = sst;
	}
	
	public BoardVO[] bbsGetList(int start, int end) {
		
		BoardVO[] b_ar = null;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("start", start);
		map.put("end", end);
		
		List<BoardVO> list = sst.selectList("bbs.bbsGetList",map);
		
		if(list != null && !list.isEmpty()) {
			b_ar = new BoardVO[list.size()];
			list.toArray(b_ar);
		}
		return b_ar;
	}
	
	public int bbsTotal() {
		
		int total = sst.selectOne("bbs.bbsTotal");
		
		return total;
	}
}
