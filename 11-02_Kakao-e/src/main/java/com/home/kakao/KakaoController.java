package com.home.kakao;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.member.vo.MemberVO;

@Controller
public class KakaoController {
	
	@Autowired
	private HttpSession session;
	
	// redirect_uri --> /kakao/login
	// 카카오 서버에서 인증코드를 전달해 주는 곳.
	@RequestMapping("/kakao/login")
	public ModelAndView showKakaoLogin(String code){
		ModelAndView mv = new ModelAndView();

		// 카카오 서버에서 인자로 전달해준 인증코드는 code로 받는다.
		// 인가 코드 요청의 응답결과를 받는다.
		System.out.println("Code : " + code);
		
		// 인가코드를 가지고 토큰을 요청한다.
		String requestURL = "https://kauth.kakao.com/oauth/token"; // HOST & POST 요청
		String access_token = ""; // access_token 사용자 액세스 토큰 값 받기 위한 변수
		String refresh_token = "";	  // 사용자 리프레시 토큰 값
		
		/* 토큰 생성 후 사용자 정보 요청하기.*/
		
		String header = ""; // 사용자 정보 요청 하기.
		String apiURL = ""; // 요청 URL
		
		try {
			
			// 웹상에 있는 경로를 객체화 시키기.
			URL url = new URL(requestURL);
			System.out.println("URL :" + url);
			// 웹상의 경로와 연결해주기 HttpURLConnection : URL 요청을 위한 클래스
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			                                            // openConnection()
			                                            // Application에서 연결하려는 URP에 주소를 통해 연결해주는 역할
			
			System.out.println("Connection : "+con);
			
			// POST방식으로 요청하기 위해 setDoOutput을 true로 지정한다.
			con.setRequestMethod("POST"); // 다음 중 하나에서 URL 요청에 대한 메서드를 설정가능하다.
			con.setDoOutput(true); // 출력에 URL 연결을 사용하려면 DoOutputflag를 true로 설정한다.
			
			// API 문서참고 : 보내고자 하는 Parameter를 준비하고
			//                OutputStream 준비하자.
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
			
			// grant_type client_id redirect_uri code 파라미터 준비후
			// 카카오 서버에 보내기
			StringBuffer sb = new StringBuffer();
			
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=e9a4160ebafba2956d773a60fc5f7c59");
			sb.append("&redirect_uri=http://localhost:9090/kakao/login");
			sb.append("&code=");
			sb.append(code);
			
			bw.write(sb.toString());
			bw.flush();
			
			System.out.println("Token Request : " + sb.toString());
			
			// 응답확인 : status = 200 이면 성공한것.
			int statusCode = con.getResponseCode();
			if(statusCode > 0) {
				System.out.println("Status Code : "+statusCode);
				
				// 요청을 통해 얻은 Json타입의 결과 메세지를 읽어오자.
				// Response
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
				StringBuffer result = new StringBuffer();
				String line = "";
				
				// 한줄 단위로 읽고 result에 적재하기
				while((line = br.readLine()) != null){
					result.append(line);
				}
				System.out.println("Reader Result :" + result.toString());
				
				//카카오서버에서 전달해준 access_token 와 refresh_token 을
				// JSON 파싱으로 처리하여 가져온다.
				// 파싱처리한 데이터를 가지고 카카오API에 요청한다.
				
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(result.toString());
				JSONObject json_obj = (JSONObject) obj;
				
				access_token = (String) json_obj.get("access_token");
				refresh_token= (String) json_obj.get("refresh_token");
				
				System.out.println("Access_token :" + access_token);
				System.out.println("Refresh_token :" + refresh_token);
				
				// 마지막 3번째 호출하기 , 사용자 정보 요청하기.
				header = "Bearer " + access_token;
				System.out.println("Header :" + header);
				apiURL = "https://kapi.kakao.com/v2/user/me";
				
				URL getUserInformation = new URL(apiURL);
				System.out.println("UserInformation :" + getUserInformation);
				
				// 웹상의 경로와 연결해주기
				HttpURLConnection con2 = (HttpURLConnection) getUserInformation.openConnection();
				System.out.println("Connection2 : "+con2);
				
				con2.setRequestMethod("POST");
				con2.setDoOutput(true);
				// 카카오 문서 참고 : Header에 값 넣기.
				con2.setRequestProperty("Authorization", header);
				
				int requestCode = con2.getResponseCode();
				
				// 사용자 정보 요청에 성공한 경우
				if(requestCode == HttpURLConnection.HTTP_OK) {
					// 필요한 정보를 얻어낸다.
					
					BufferedReader br2 = new BufferedReader(new InputStreamReader(con2.getInputStream()));
					
					StringBuffer result2 = new StringBuffer();
					String line2 = "";
					
					// 한줄 단위로 읽고 result에 적재하기
					while((line2 = br2.readLine()) != null){
						result2.append(line2);
					}
					System.out.println("Result2 :" + result2.toString());
					
				
					obj = parser.parse(result2.toString());
					json_obj = (JSONObject)obj;
					
					JSONObject props =  (JSONObject)json_obj.get("properties");
					
					String nickName = (String) props.get("nickname");
					String profile_image =(String)props.get("profile_image");
					
					JSONObject kakao_account = (JSONObject)json_obj.get("kakao_account");
					
					
					String email = (String)kakao_account.get("email");
					String birthday = (String)kakao_account.get("birthday");
					
					MemberVO vo = new MemberVO();
					
					vo.setName(nickName);
					vo.setEmail(email);
					vo.setProfile_image(profile_image);
					vo.setBirthday(birthday);
					
					session.setAttribute("mvo", vo);
					
					
					System.out.println("Properties :" +props);
					System.out.println("Kakao Account :" +kakao_account);
					
					System.out.println("Name : " + nickName);
					System.out.println("profile_image : " + profile_image);
					System.out.println(email);
					System.out.println(birthday);
					
					
					mv.addObject("mvo",vo);
					mv.setViewName("result");
				}
				
				if(bw != null) {
					bw.close();
				}
				if(br != null) {
					br.close();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@RequestMapping("/kakao/logout")
	public ModelAndView kakao_logout() {
		
		ModelAndView mv = new ModelAndView();
		
		session.removeAttribute("mvo");
		
		mv.setViewName("redirect:/");
		
		return mv;
	}

}
