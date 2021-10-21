package spring.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mybatis.vo.EmpVO;

@Controller
public class AjaxTestAction {
	
	
	@RequestMapping("/ajax_test1.do")
	public String test1() {
		return "ajax_test1";
	}
	
	/*
	@RequestMapping("/ajax_res")
	public ModelAndView
	*/
	
	// 테스트용 
	// value = URL
	// produces : 반환 할 데이터 타입 (minetype)
	@RequestMapping(value ="ajax_res.do",produces = "text/json;charset=utf-8")
	@ResponseBody // Ajax통신 
	public Map<String, Object> test1Res(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		EmpVO[] ar = new EmpVO[3];
		
		ar[0] = new EmpVO();
		
		ar[0].setEmployee_id("100");
		ar[0].setFirst_name("Kimsungmin");
		ar[0].setJob_id("IT_PROG");
		ar[0].setDepartment_id("50");
		
		ar[1] = new EmpVO();
		
		ar[1].setEmployee_id("100");
		ar[1].setFirst_name("Sungmin");
		ar[1].setJob_id("IT_PROG");
		ar[1].setDepartment_id("60");
		
		ar[2] = new EmpVO();
		
		ar[2].setEmployee_id("100");
		ar[2].setFirst_name("Min");
		ar[2].setJob_id("IT_PROG");
		ar[2].setDepartment_id("50");
		
		map.put("len", ar.length);
		map.put("ar",ar);
		
		return map;	
	}
	@RequestMapping(value="/ex2.do", produces = "text/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> test2(String id, String pw){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(id + " and " + pw);
		
		EmpVO[] ar = new EmpVO[2];
		
		ar[0] = new EmpVO();
		
		ar[0].setEmployee_id("100");
		ar[0].setFirst_name("차승원");
		ar[0].setJob_id("배우");
		ar[0].setDepartment_id("50");
		
		ar[1] = new EmpVO();
		
		ar[1].setEmployee_id("100");
		ar[1].setFirst_name("유해진");
		ar[1].setJob_id("배우");
		ar[1].setDepartment_id("60");
		
		map.put("ar",ar);
		
		
		return map;
	}
	/*
	public EmpVO[] test1Res() {
		
		EmpVO[] ar = new EmpVO[3];
		
		ar[0] = new EmpVO();
		
		ar[0].setEmployee_id("100");
		ar[0].setFirst_name("Kimsungmin");
		ar[0].setJob_id("IT_PROG");
		ar[0].setDepartment_id("50");
		
		ar[1] = new EmpVO();
		
		ar[1].setEmployee_id("100");
		ar[1].setFirst_name("Sungmin");
		ar[1].setJob_id("IT_PROG");
		ar[1].setDepartment_id("60");
		
		ar[2] = new EmpVO();
		
		ar[2].setEmployee_id("100");
		ar[2].setFirst_name("Min");
		ar[2].setJob_id("IT_PROG");
		ar[2].setDepartment_id("50");
		
		return ar;
	}
	*/
}
