package a.b.c.com.login.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import a.b.c.com.common.GooglePwMail;
import a.b.c.com.common.K_Session;
import a.b.c.com.kos.mem.service.KosMemberService;
import a.b.c.com.kos.mem.vo.KosMemberVO;
import a.b.c.com.login.service.KosLoginService;

@Controller
public class KosLoginController {
	Logger logger = LogManager.getLogger(KosLoginController.class);
	
	// 필드 오토와이어드 
	@Autowired(required=false)
	private KosLoginService kosLoginService;
	// 필드 오토와이어드 
	@Autowired(required=false)
	private KosMemberService kosMemberService;

	
	// 로긴 폼
	@GetMapping("loginForm")
	public String kosLoginForm() {
		logger.info("kosLoginForm 함수 진입 >>> : ");	
		return "login/loginForm";
	}
	// 메인페이지 폼
	@GetMapping("mainPage")
	public String kosmainPageForm() {
		logger.info("kosmainPageForm 함수 진입 >>> : ");	
		return "main/mainPage";
	}

	// kakao Login ========================================================================================	 	
		@PostMapping("kakaoLogin")
		@ResponseBody
		public Map<String,Object> kakaoLogin(HttpServletRequest req, KosMemberVO kvo) {
			logger.info("kakaoLogin 함수 진입 성공 >>> : ");
			
			String snstype = req.getParameter("snstype");
			String snsid = req.getParameter("snsid");
			String snsemail = req.getParameter("snsemail");
			
			logger.info("snstype >>> : " + snstype);
			logger.info("snsid >>> : " + snsid);
			logger.info("snsemail >>> : " + snsemail);
			
			kvo.setSnstype(snstype); // snstype :: 01:카카오, 02:네이버
			kvo.setSnsid(snsid);
//			kvo.setSnsemail(snsemail);
	//		kvo.setSnsemail("sddsa@asddas.net"); //테스트
	
			
	
			
			List<KosMemberVO> snsLogin = kosLoginService.kakaoLogin(kvo);
			
			Map <String, Object> resultMap = new HashMap<String, Object>();
			// 로직 처리하기  
			if (snsLogin.size() == 1) {
				//이메일 가입 되어있을때
				//이메일 가입 되어있고 카카오 연동 안되어 있을시
				if(snsLogin.get(0).getSnsid() == null) {
					//sns 관련 데이타 추가한다
					kvo.setMnum(snsLogin.get(0).getMnum());
					kosMemberService.kosaddMemberBySNS(kvo);
				}
				resultMap.put("memID",snsLogin.get(0).getMid());
				resultMap.put("memPassword",snsLogin.get(0).getMpw());
				logger.info("kakaoLogin 함수  >>> : "+snsLogin.get(0).getMpw());	
				resultMap.put("JavaData", "YES");
				//m.addAttribute("JavaData", "register");
			}else {
				//일치하는 이메일 없으면 가입
				//m.addAttribute("JavaData", "YES");
				resultMap.put("JavaData", "register");
			}
			return resultMap;
			
		}
		
	
	
	@RequestMapping("loginCheck")
	public String kosLoginCheck(HttpServletRequest req, KosMemberVO kvo, Model model) {
		logger.info("kosLoginCheck 함수 진입 >>> : ");	
		String mid = "";
		String mpw = "";
		try {
			mid  = URLDecoder.decode(req.getParameter("memID"), "UTF-8");//한글파라미터 깨짐 문제
			mpw  = req.getParameter("memPassword");//파라미터+ 깨짐 문제
			logger.info("kosLoginCheck 함수 mid >>> : "+mid);	
			logger.info("kosLoginCheck 함수 진입 >>> : "+mpw);	
			kvo.setMid(mid);
			kvo.setMpw(mpw);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 서비스 호출
		List<KosMemberVO> listLogin = kosLoginService.kosLoginCheck(kvo);
		logger.info("kosLoginCheck 함수 listLogin >>> : "+listLogin.size());	
				
		if (listLogin.size() == 1) { 
			logger.info("KosmoLoginController loginCheck listLogin.size() >>> : " + listLogin.size());
			
			K_Session ks = K_Session.getInstance();			
			ks.setSession(req, listLogin.get(0).getMnum());
			String kID = ks.getSession(req);
			logger.info("KosmoLoginController loginCheck kID >>> : " + kID);
			
			if (kID !=null || kID.equals(listLogin.get(0).getMid())){				
				logger.info("KosmoLoginController login >>> : 로그인 중 >>> : 메인 페이지로 이동 하기 >>> : " + kID);
				model.addAttribute("listLogin", listLogin);
				return "login/loginPage";
			}
		} // end listLogin.size() if
		return "login/memLoginForm";
//		return "login/loginForm";
	}
	
	// 아이디 찾기 ========================================================================================	
	@GetMapping("idFindForm")
	public String kosIdFindForm() {
		logger.info("kosLoginForm 함수 진입 >>> : ");	
		return "login/idFind";
	}
	
	// naver Login ========================================================================================	 
		@GetMapping("naverCallback")
		public String naverCallback() {
			logger.info("naverCallback 함수 진입 성공 >>> :");
			
			return "login/naverCallback";
		}
		@GetMapping("naverlogin")
		public String naverLogin(HttpServletRequest request, Model model) {
			logger.info("naverLogin 함수 진입 성공 >>> : ");

			String access_token = (String) request.getAttribute("access_token");
			logger.info("naverLogin access_token >>> : " + access_token);
			
			String token = access_token;
			String header = "Bearer " + token;
			String apiURL = "https://openapi.naver.com/v1/nid/me";
			Map<String, String> requestHeaders = new HashMap<>();
			requestHeaders.put("Authorization", header);
			String responseBody = get(apiURL, requestHeaders);
			logger.info("responseBody >>> : " + responseBody);
			
	        //위에 값을 콘솔로 찍어본다. name 값이 유니코드인데 브라우저에서 자동으로 변환해서 읽고 json simple 라이브러리가 변환해준다.
			
	        JSONObject jobj = new JSONObject();
	        JSONParser parser = new JSONParser();

	        try {
				jobj = (JSONObject)parser.parse(responseBody);
				
				// resultCode가 00이고 message가 success이면 실행
				String resultcode = (String)jobj.get("resultcode");
				String message = (String)jobj.get("message");
				
				jobj =(JSONObject)jobj.get("response"); 			//여기서 response가 json객체 안에 json객체
				String id =(String)jobj.get("id");					// 아이디 1x 
				String email =(String)jobj.get("email");			// 이메일 
				String name =(String)jobj.get("name");				// 이름 
				String nick = (String)jobj.get("nickname");			// 닉네임
				String phone = (String)jobj.get("mobile");			// 전화번호
				String photo = (String)jobj.get("profile_image");
				
				logger.info("id >>> : " + id);
				logger.info("email >>> : " + email);
				logger.info("name >>> : " + name);
				logger.info("nick >>> : " + nick);
				logger.info("phone >>> : " + phone);
				logger.info("photo >>> : " + photo);
		
				// VO 이용해서 로그인 루틴 만들기 
				
	        } catch (Exception e) {
				System.out.println("json 객체 변환실패");		
			}
			       
	        return "login/login";
		}
	
	@GetMapping("logout")
	public String kosLogout(HttpServletRequest req, KosMemberVO mvo, Model model) {	
		logger.info("kosLogout() 함수 진입 >>> : ");		
								
		K_Session ks = K_Session.getInstance();			
		ks.killSession(req);
		return "login/memLoginForm";
	}
//	-------- RestFul 방식의 데이터 받아오기 위한 메소드 -------------------------------------------------------------------
	public static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 에러 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}
	
	public static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다 >>> : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다 >>> : " + apiUrl, e);
		}
	}
	
	public static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);
		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();
			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}
			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패했습니다. >>> : ", e);
		}
	}
	//패스워드 찾기 폼
	@GetMapping(value="pwFindForm")
	public String kosPwFindForm( Model model) {
		return "login/pwFind";
	}
	//임시 비밀번호 가져오기
	@GetMapping(value="pwFindAuthnum")
	@ResponseBody
	public Object kospwFindAuthnum(KosMemberVO kvo,Model m,HttpServletRequest req) {
		logger.info("kospwFindAuthnum() 함수 진입 >>> : ");	
		//db에 사용자의 아이디 ,이메일 유효한지 체크
		List <KosMemberVO> dbList =kosMemberService.dbCheckIdAndEmail(kvo);
	
		if(dbList.size() > 0) {
			//사용자입력 아이디,혹은 이메일가 존재하는 경우
			if(dbList.get(0).getMid() != null || dbList.get(0).getMemail() != null) {
				
				//임시 비번 생성
				UUID uuid = UUID.randomUUID();
				//임시 비번6자리만 쓰기
				String tempw = uuid.toString().substring(0, 10);
				//사용자 계정 db에 임시 비번를 갱신시킨다
				KosMemberVO _kvo = new KosMemberVO();
				_kvo.setMpw(tempw);
				_kvo.setMid(dbList.get(0).getMid());
				int res =kosMemberService.kosMemberUpdatePW(_kvo);
				//임시 비번를 사용자의 메일로 전달
				GooglePwMail pwMail = new GooglePwMail();
				pwMail.pwMailByEmail(kvo.getMemail(), tempw);
				//db의 결과가 갱신되면
				if(res > 0) {
					logger.info("kospwFindAuthnum()  진입 >>> : "+res);
					return "SUCCESS";
				}
			}
			
		}
			//사용자의 아이디,이메일 없는 경우
			//req.setAttribute("historyBack", true);
			// 되돌아간다
		return "FAIL";
	}
	//임시 비밀번호 가져오기
	@GetMapping(value="pwUpdateForm")
	public String kospwAuthForm(HttpServletRequest req,Model m) {
		logger.info("kospwAuthForm() 함수 진입 >>> : ");	
	  
		String mid =req.getParameter("mid");
		String ppw =req.getParameter("ppw");
		logger.info("kospwAuthForm() mid >>> : "+mid);	
		logger.info("kospwAuthForm() ppw >>> : "+ppw);	
		
	
		m.addAttribute("mid", mid);
		m.addAttribute("ppw", ppw);
		return "login/pwUpdateForm";
	}
	//임시 비밀번호 갱신하기
	@GetMapping(value="tempwUpdate")
	public String kostempwUpdate(Model m,HttpServletRequest req) {
		logger.info("kostempwUpdate() 함수 진입 >>> : ");	
		
		String mid =req.getParameter("mid");
		String tempw =req.getParameter("mpw");
		
		KosMemberVO kvo = new KosMemberVO();
		kvo.setMpw(tempw);
		kvo.setMid(mid);
		int res =kosMemberService.kosMemberUpdatePW(kvo);
		logger.info("kostempwUpdate()  res >>> : "+res);
		//db의 결과가 갱신되면
		if(res > 0) {
			return "login/loginForm";
		}
		return "login/pwUpdateForm";
	}
	
}
