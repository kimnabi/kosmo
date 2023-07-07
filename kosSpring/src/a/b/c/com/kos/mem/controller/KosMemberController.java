package a.b.c.com.kos.mem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.EncryptAES;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.chabun.service.KosChabunService;
import a.b.c.com.kos.mem.service.KosMemberService;
import a.b.c.com.kos.mem.vo.KosMemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class KosMemberController {

	@Autowired(required = false)
	KosMemberService kosMemberService;

	// 필드 오토 와이어드
	@Autowired(required = false)
	private KosChabunService kosChabunService;

	private Logger logger = LoggerFactory.getLogger(KosMemberController.class);

	// 회원 입력 폼
	@GetMapping("memForm1")
	public String kosMemberForm( HttpServletRequest req,Model m) {
		logger.info("kosMemberInsertForm 함수 진입 >>> : ");
		//memID='+data.memID+"&memPassword="+encodeURIComponent(data.memPassword)
		return "mem/memInsertForm";
	}
	// 회원 입력 폼
	@GetMapping("memForm")
	public String kosMemberInsertForm( HttpServletRequest req,Model m) {
		logger.info("kosMemberInsertForm 함수 진입 >>> : ");
		//memID='+data.memID+"&memPassword="+encodeURIComponent(data.memPassword)
		String snstype = req.getParameter("snstype");
		String snsid = req.getParameter("snsid");
		String snsemail = req.getParameter("snsemail");
		
		m.addAttribute("snstype", snstype);
		m.addAttribute("snsid", snsid);
		m.addAttribute("snsemail", snsemail);
		return "mem/memForm";
	}

	// 회원 입력 폼
	@GetMapping("memSelectAll")
	public String kosMemberSelectAllForm(KosMemberVO kvo, Model model) {
		logger.info("kosMemberSelectAllForm 함수 진입 >>> : ");
		// 서비스 호출
		List<KosMemberVO> listAll = kosMemberService.kosMemberSelectAll(kvo);
		logger.info("kosMemberSelectAllForm 함수  >>> listAll " + listAll);
		model.addAttribute("listAll", listAll);
		model.addAttribute("search_kvo", kvo);
		return "mem/memSelectAll";
	}

	// 회원 입력 폼
	@GetMapping("kosIdCheck")
	@ResponseBody
	public String kosIdCheck(KosMemberVO vo) {
		logger.info("koskosIdCheck 함수 진입 >>> : ");

		List<KosMemberVO> list = kosMemberService.kosIdCheck(vo);
		if (list != null) {

			logger.info("koskosIdCheck 함수 >>> : " + list.size());
			if (list.size() > 0)
				return "fail";
		}
		return "ID_YES";
	}
	// 회원 수정 폼
	@PostMapping("memSelect")
	public String kosMemberSelectOneForm(KosMemberVO kvo, Model model) {
		logger.info("kosMemberSelectOneForm 함수 진입 >>> : ");
		// 서비스 호출
		List<KosMemberVO> listS = kosMemberService.kosMemberSelect(kvo);
		logger.info("kosMemberSelectOneForm 함수  >>> listS " + listS);
		model.addAttribute("listS", listS);
		return "mem/memSelect";
	}
	
	// 회원 수정
	@PostMapping("memUpdate")
	public String kosmemModify(HttpServletRequest req, KosMemberVO vo ) {
		logger.info("kosmemModify 함수 진입 >>> : ");
		logger.info("kosmemModify 함수  >>> : "+vo.getMnum());
		
		// 핸드폰 번호
		String mhp = req.getParameter("mhp");
		String mhp1 = req.getParameter("mhp1");
		String mhp2 = req.getParameter("mhp2");
		vo.setMhp(mhp.concat(mhp1).concat(mhp2));

		// 유선전화 번호
		String mtel = req.getParameter("mtel");
		String mtel1 = req.getParameter("mtel1");
		String mtel2 = req.getParameter("mtel2");
		vo.setMtel(mtel.concat(mtel1).concat(mtel2));

		// 이메일
		String memail = req.getParameter("memail");
		String memail1 = req.getParameter("memail1");
		vo.setMemail(memail.concat("@").concat(memail1));

		// 도로명 주소, 지번 주소
		vo.setMzonecode(req.getParameter("mzonecode"));
		vo.setMroadaddr(req.getParameter("mroadaddr"));
		vo.setMroaddetail(req.getParameter("mroaddetail"));
		vo.setMjibunaddr(req.getParameter("mjibunaddr"));

		// 취미
		String mhobby = "";
		String hobby[] = req.getParameterValues("mhobby");
		if (hobby.length > 0) {
			for (int i = 0; i < hobby.length; i++) {
				mhobby += hobby[i] + ",";
			}
		}
		vo.setMhobby(mhobby);

		// 내소개
		vo.setMinfo(req.getParameter("minfo"));

		logger.info("kosmemModify 함수 KosMemberVO >>> : " + vo);
		// 서비스 호출
		int Cnt = kosMemberService.kosMemberUpdate(vo);

		if (Cnt > 0) {
			// 수정 성공
			logger.info("kosmemModify 함수 >>> : " + Cnt);
		}
		return "redirect:memSelectAll.k";
	}

	// 회원 등록
	@PostMapping("memInsert")
	public String kosMemberInsert(HttpServletRequest req) {
		logger.info("kosMemberInsert 함수 진입 >>> : ");

		// 채번 구하기
		String mnum = ChabunUtil.getMemberChabun("D", kosChabunService.getKosMemberChabun().getMnum());
		logger.info("kosMemberInsert 함수 mnum >>> : " + mnum);

		// 이미지 업로드
		FileUploadUtil fu = new FileUploadUtil(CommonUtils.MEM_IMG_UPLOAD_PATH, CommonUtils.MEM_IMG_FILE_SIZE,
				CommonUtils.MEM_EN_CODE);
		// req - mr - fu
		// 이미지 파일 원본 사이즈
		boolean bool = fu.imgfileUpload(req);
		logger.info("kosMemberInsert bool >>> : " + bool);

		KosMemberVO kvo = null;
		kvo = new KosMemberVO();

		// 채번
		kvo.setMnum(mnum);

		// 이름
		kvo.setMname(fu.getParameter("mname"));

		// 아이디
		kvo.setMid(fu.getParameter("mid"));

		// 패스워드
		EncryptAES ase = EncryptAES.getInstance();
	//	mpw = ase.aesEncode(fu.getParameter("mpw"));
		kvo.setMpw(ase.aesEncode(fu.getParameter("mpw"))); // 패스워드 암호화 디비에저장

		// 성별
		kvo.setMgender(fu.getParameter("mgender"));

		// 생일
		String mbirth = fu.getParameter("mbirth");
		String mbirth1 = fu.getParameter("mbirth1");
		String mbirth2 = fu.getParameter("mbirth2");
		kvo.setMbirth(mbirth.concat("-").concat(mbirth1).concat("-").concat(mbirth2));

		// 핸드폰 번호
		String mhp = fu.getParameter("mhp");
		String mhp1 = fu.getParameter("mhp1");
		String mhp2 = fu.getParameter("mhp2");
		kvo.setMhp(mhp.concat("-").concat(mhp1).concat("-").concat(mhp2));

		// 유선전화 번호
		String mtel = fu.getParameter("mtel");
		String mtel1 = fu.getParameter("mtel1");
		String mtel2 = fu.getParameter("mtel2");
		kvo.setMtel(mtel.concat("-").concat(mtel1).concat("-").concat(mtel2));

		// 이메일
		String memail = fu.getParameter("memail");
		String memail1 = fu.getParameter("memail1");
		kvo.setMemail(memail.concat("@").concat(memail1));

		// 도로명 주소, 지번 주소
		kvo.setMzonecode(fu.getParameter("mzonecode"));
		kvo.setMroadaddr(fu.getParameter("mroadaddr"));
		kvo.setMroaddetail(fu.getParameter("mroaddetail"));
		kvo.setMjibunaddr(fu.getParameter("mjibunaddr"));

		// 취미
		String mhobby = "";
		String hobby[] = fu.getParameterValues("mhobby");
		if (hobby.length > 0) {
			for (int i = 0; i < hobby.length; i++) {
				mhobby += hobby[i] + ",";
			}
		}
		kvo.setMhobby(mhobby);

		// 내소개
		kvo.setMinfo(fu.getParameter("minfo"));

		// 파일
		kvo.setMphoto(fu.getFileName("mphoto"));
		//snstype
		kvo.setSnstype(fu.getParameter("snstype"));
		//snsid
		kvo.setSnsid(fu.getParameter("snsid"));
        //snsemail
		kvo.setSnsemail(fu.getParameter("snsemail"));
		logger.info("kosMemberInsert 함수 KosMemberVO >>> : " + kvo);

		// 서비스 호출
		int nCnt = kosMemberService.kosMemberInsert(kvo);

		if (nCnt > 0) {
			logger.info("kosMemberInsert 함수 nCnt >>> : " + nCnt);
			return "mem/memInsert";
		}

		return "mem/memForm";
	}

}
