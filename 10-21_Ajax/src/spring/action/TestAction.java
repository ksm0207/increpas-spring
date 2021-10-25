package spring.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mybatis.vo.EmpVO;

@Controller
public class TestAction {

	@RequestMapping("/ex1.inc")
	public String test1() {
		return "test1";
	}
	
	
	@RequestMapping(value="/ex1_res.inc", produces="text/json;charset=utf-8")
	@ResponseBody
	//public EmpVO[] test1Res() {
	public Map<String, Object> test1Res() {
		EmpVO[] ar = new EmpVO[3];
		
		ar[0] = new EmpVO();
		ar[0].setEmployee_id("10");
		ar[0].setFirst_name("마루치");
		ar[0].setJob_id("IT_PROG");
		ar[0].setDepartment_id("50");
		
		ar[1] = new EmpVO();
		ar[1].setEmployee_id("15");
		ar[1].setFirst_name("아라치");
		ar[1].setJob_id("IT_PROG");
		ar[1].setDepartment_id("30");
		
		ar[2] = new EmpVO();
		ar[2].setEmployee_id("21");
		ar[2].setFirst_name("홍길동");
		ar[2].setJob_id("IT_PROG");
		ar[2].setDepartment_id("50");
		
		//return ar;
		
		Map<String, Object> map = 
				new HashMap<String, Object>();
		map.put("len", ar.length);
		map.put("ar", ar);
		
		return map;
	}
	
	@RequestMapping(value="/ex2.inc", produces="text/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> test2(String type, String value){
		//반환형 객체 생성
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(type+"/"+value);
		
		EmpVO[] ar = new EmpVO[2];
		
		ar[0] = new EmpVO();
		ar[0].setEmployee_id("40");
		ar[0].setFirst_name("일지매");
		ar[0].setJob_id("IT_PROG");
		ar[0].setDepartment_id("90");
		
		ar[1] = new EmpVO();
		ar[1].setEmployee_id("41");
		ar[1].setFirst_name("마동석");
		ar[1].setJob_id("IT_PROG");
		ar[1].setDepartment_id("10");
		
		map.put("ar", ar);
		
		return map;
	}
}










