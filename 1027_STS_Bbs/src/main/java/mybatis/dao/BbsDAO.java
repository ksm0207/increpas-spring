package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.BbsVO;

@Component
public class BbsDAO {
	
	@Autowired
	private SqlSessionTemplate sst;

	// 게시물 가져오기
	public BbsVO[] list(String begin, String end, String bname) {
		
		BbsVO[] ar = null;
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("begin",begin);
		map.put("end", end);
		map.put("bname", bname);
		
		List<BbsVO> list = sst.selectList("bbs.list",map);
		
		if(list != null && !list.isEmpty()) {
			ar = new BbsVO[list.size()];
			list.toArray(ar);
		}
		return ar;
	}
	
	// 게시물 총합구하기
	public int getBoardTotalCount(String bname) {
		
		int status = sst.selectOne("bbs.getBoardTotalCount",bname);
		
		return status;
		
	}
	
}
