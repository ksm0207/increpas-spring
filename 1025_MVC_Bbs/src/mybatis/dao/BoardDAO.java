package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.BoardVO;
import mybatis.vo.CommentVO;

@Component
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate ss;
	
	//총 게시물 수 - 총페이지 값을 구할 수 있다.
	//               10/25 - 내용추가 BBS 분류를 위한 파라미터 값 받음 
	public int getTotalCount(String bname) {
		
		int cnt = ss.selectOne("bbs.totalCount",bname);
		
		return cnt;
	}
	
	//목록
	public BoardVO[] getList(int begin, int end, String bname) {
		BoardVO[] ar = null;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", String.valueOf(begin));
		map.put("end", String.valueOf(end));
		map.put("bname", bname);
		
		List<BoardVO> list = ss.selectList("bbs.bbsList", map);
		if(list != null && list.size() > 0 && !list.isEmpty()) {
			ar = new BoardVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
	}
	
	public int add(BoardVO vo) {
		
		int cnt = ss.insert("bbs.add", vo);
				
		return cnt;
	}
	
	public BoardVO getBbs(String b_idx) {
		BoardVO vo = ss.selectOne("bbs.getBbs", b_idx);
		return vo;
	}
	
	public int addAns(CommentVO vo) {
		
		int cnt = ss.insert("bbs.addAns", vo);
		
		
		return cnt;
	}
	
	public int delBbs(String b_idx) {
		int cnt = ss.update("bbs.delBbs", b_idx);
		
		return cnt;
	}
	
	public int updateHit(String b_idx) {
		int cnt = ss.update("bbs.hit", b_idx);
		
		return cnt;
	}
	
	public int editBbs(BoardVO vo) {
		
		
		return ss.update("bbs.edit", vo);
	}
}






