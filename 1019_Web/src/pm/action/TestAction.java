package pm.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import pm.vo.TestVO;

public class TestAction {
	
	// private : setter , cons 가 없는 상황에서
	// 		     값을 어떻게 넣을까?

	/*
	 	어노테이션을 사용하려면 applicationContext.xml 첫 부분에
	 	<context:annotation-config/> 가 명시가 되야 사용할 수 있음
	 * */
	
	@Autowired         // @AutoWired
	@Qualifier("vo2") // 알아두면 좋은거 , bean의 id값을 명시하면
	                  // 자동으로 vo2 빈 객체를 대입할 수 있음.
	                  // 여러 객체를 대입할 수 있다.
	private TestVO tvo;
	
	public TestVO getTvo() {
		return tvo;
	}
}
