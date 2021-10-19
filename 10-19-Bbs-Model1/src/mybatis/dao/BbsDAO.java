package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import mybatis.vo.BbsVO;
import mybatis.vo.CommentVO;
import oracle.net.jdbc.TNSAddress.SOException;

public class BbsDAO {
	
	private SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session) {
		this.session=session;
	}
	
	public BbsVO[] getList(int begin, int end) {
		
		BbsVO[] arr = null;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("begin", begin);
		map.put("end",end);
		
		List<BbsVO> list = session.selectList("bbs.bbs_list",map);
		
		if(list != null && !list.isEmpty()) {
			
			arr = new BbsVO[list.size()];
			list.toArray(arr); 
		}
		
		
		return arr;
	}

	public int getTotalCount() {
		
		int total_page = session.selectOne("bbs.total_count");
		
		return total_page;
	}
	
	
	public int createData(String title, String writer, String content, String file_name,String ip,String pwd){

		Map<String,String> map = new HashMap<String, String>();
		
		map.put("subject",title);
		map.put("writer",writer);
		map.put("content",content);
		map.put("file_name",file_name);
		map.put("ip",ip);
		map.put("pwd",pwd);
	
		int res = session.insert("bbs.add",map);
		
		
		return res;
	}
	
	public BbsVO search(int b_idx) {
	
		BbsVO vo = session.selectOne("bbs.search",b_idx);
		
		return vo;
	}
	
	public int addAns(CommentVO cvo) {
		
		int status = session.insert("bbs.ans",cvo);
		
		return status;
	}
	
	public int updateBoard(String title, String writer, String content,String b_idx,String pwd) {
		
		
		Map<String,String> map = new HashMap<String, String>();
		
		
		map.put("subject",title);
		map.put("writer",writer);
		map.put("content",content);
		map.put("b_idx",b_idx);
		map.put("pwd",pwd);
		
		
		int value = session.update("bbs.update",map);
		
		return value;
	}
	
	public int setBoardHit(String idx) {
		
		int hit = session.update("bbs.hit",idx);
		
		
		System.out.println("idx : " + idx);
		
		
		return hit;
	}
}
