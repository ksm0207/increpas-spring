package com.home.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.member.vo.MemberVO;

@Controller
public class LoginController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request;
	

	@RequestMapping("/naver_callback")
	public ModelAndView naverLogin(String code, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		// 네이버 code값
		System.out.println("Naver Code :" + code);
		
		// 접근 토큰 발급 요청 URL
		String access_token_url = "https://nid.naver.com/oauth2.0/token";
		
		// 요청파라미터 
		// (1) grant_type=authorization_code : 발급
		// (2) client_id
		// (3) client_secret
		// (4) code
		// (5) state
		
		URL url = new URL(access_token_url);
		System.out.println("토큰발급요청 URL :" + url);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		System.out.println("연결상태 :" + con);
		
		con.setRequestMethod("POST"); // POST방식으로 요청하기
		con.setDoOutput(true); // 출력에 URL 연결을 사용하려면 DoOutputflag를 true로 설정한다.
	
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
		
		// 파라미터 append
		StringBuffer sb = new StringBuffer();
		
		sb.append("grant_type=authorization_code");
		sb.append("&client_id=xMyF0KlYHyGgwDd2AA5B");
		sb.append("&client_secret=ecM6zl_RRc");
		sb.append("&code=");
		sb.append(code);
		sb.append("&state=1");
		
		bw.write(sb.toString());
		bw.flush();
		
		System.out.println("토큰 결과 :" + sb.toString());
		
		int status = con.getResponseCode();
		
		if(status == HttpURLConnection.HTTP_OK) {
			System.out.println("토큰발급요청 성공하였습니다." + status);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			StringBuffer token_result = new StringBuffer();
			String token_line = "";
			
			// 결과 메시지 읽어오기
			while((token_line = br.readLine()) != null ) {
				token_result.append(token_line);
			}
			System.out.println("결과 :"  + token_result.toString());
			
			// 네이버서버에서 전달해주는 access_token & refresh_token을
			// Json으로 처리하여 가져오기
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(token_result.toString());
			JSONObject json_obj = (JSONObject) obj;
			
			String access_token = "";
			String refresh_token = "";
			
			access_token = (String) json_obj.get("access_token");
			refresh_token = (String) json_obj.get("refresh_token");
			
			System.out.println("Access_token : " + access_token);
			System.out.println("Refresh_token : " + refresh_token);
			
			// 사용자 정보 요청하기
			String header = "Bearer "+access_token;
			String apiURL = "https://openapi.naver.com/v1/nid/me";
			
			URL getUserInfo = new URL(apiURL);
			
			HttpURLConnection con_api = (HttpURLConnection) getUserInfo.openConnection();
			
			con_api.setRequestMethod("POST");
			con_api.setDoOutput(true);
			con_api.setRequestProperty("Authorization", header);
			
			int request_code = con_api.getResponseCode();
			System.out.println(request_code);
			
			if(request_code == HttpURLConnection.HTTP_OK) {
				
				BufferedReader br2 = new BufferedReader(new InputStreamReader(con_api.getInputStream()));
				
				StringBuffer user_result = new StringBuffer();
				String line2 = "";
				
				while((line2 = br2.readLine())!= null) {
					user_result.append(line2);
				}
				System.out.println("사용자 정보 : "+user_result.toString());
				
				obj = parser.parse(user_result.toString());
				json_obj = (JSONObject) obj;
				
				// json 접근하기
				JSONObject getJson = (JSONObject) json_obj.get("response");
				
				String nickName = (String) getJson.get("nickname");
				String name = (String) getJson.get("name");
				String email = (String) getJson.get("email");
				String profile_image = (String) getJson.get("profile_image");
				
				MemberVO vo = new MemberVO();
				
				vo.setNickName(nickName);
				vo.setName(name);
				vo.setEmail(email);
				vo.setProfile_image(profile_image);
				
				// 사용자 세션 저장
				session.setAttribute("mvo", vo);
				
				mv.addObject("mvo",vo);
				mv.setViewName("home");
	
				if(bw != null) {
					bw.close();
				}
				if(br != null) {
					br.close();
				}
				if(br2 != null) {
					br2.close();
				}
			}
		}
		return mv;
	} // end of LoginController
	
	@RequestMapping("/logout.do")
	public String logout() {
		System.out.println("로그아웃");
		session = request.getSession();
		
		session.invalidate();
		
		return "redirect:/";
		
	}
	
}
