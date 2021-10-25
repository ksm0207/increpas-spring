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
	
	public int editBbs(String b_idx, String subject, String content,
			String fname, String oname, String pwd, String ip) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("b_idx", b_idx);
		map.put("subject", subject);
		map.put("content", content);
		map.put("pwd", pwd);
		map.put("ip", ip);
		
		//파일첨부가 되었을 때만 파일명들을 DB에 저장한다. 만약!
		//파일첨부가 안되었다면 기존 파일이 유지되어야 하기 때문이다.
		if(fname != null) {
			map.put("fname", fname);
			map.put("oname", oname);
		}
		
		int cnt = ss.update("bbs.edit", map);
		return cnt;
	}
}






