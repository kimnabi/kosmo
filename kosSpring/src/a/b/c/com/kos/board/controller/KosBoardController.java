package a.b.c.com.kos.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.K_Session;
import a.b.c.com.common.chabun.service.KosChabunService;
import a.b.c.com.kos.board.service.KosBoardService;
import a.b.c.com.kos.board.vo.KosBoardLikeVO;
import a.b.c.com.kos.board.vo.KosBoardPasingVO;
import a.b.c.com.kos.board.vo.KosBoardVO;
import a.b.c.com.kos.rboard.service.KosRboardService;
import a.b.c.com.kos.rboard.vo.KosRboardVO;


@Controller
public class KosBoardController {
	Logger logger = LogManager.getLogger(KosBoardController.class);
	
	// 컨트롤러에서 채번 서비스 연결 
	@Autowired(required=false)
	private KosChabunService kosChabunService;
	
	// 컨트롤러에서 회원 서비스 연결 
	@Autowired(required=false)
	private KosBoardService kosBoardService;
	
	// 컨트롤러에서 댓글 서비스 연결 
	@Autowired(required=false)
	private KosRboardService kosRboardService;
	//게시판 글쓰기 폼
	@GetMapping("boardForm")
	public String kosBoardForm() {
		logger.info("kosBoardForm 함수 진입 >>> : ");
		
		return "board/boardForm";
	}
	//게시판 댓글  폼
	@GetMapping("rboardForm")
	public String kosRboardForm() {
		logger.info("kosRboardForm 함수 진입 >>> : ");
		
		return "rboard/rboardForm";
	}
	//게시판 수정  폼
	@GetMapping("boardSelect")
	public String kosSelectForm(Model m,KosBoardVO kbvo) {
		logger.info("kosSelectForm 함수 진입 >>> : ");
		List<KosBoardVO> listS  = kosBoardService.kosBoardSelect(kbvo);
		if(listS.size() > 0) {
		m.addAttribute("listS", listS);
		return "board/boardSelect";
		}
		return "#";
		
	}
	//로그인 폼으로 이동
	@GetMapping("memLoginForm")
	public String kosLoginForm(Model m,KosBoardVO kbvo) {
		logger.info("kosSelectForm 함수 진입 >>> : ");
	//	List<KosBoardVO> listS  = kosBoardService.kosBoardSelect(kbvo);
		//if(listS.size() > 0) {
			//m.addAttribute("listS", listS);
			//return "board/boardSelect";
		//}
		return "login/memLoginForm";
		
	}
	//비번 검증
	@PostMapping("boardPwCheck")
	public @ResponseBody Object kosBoardPwCheck(Model m,KosBoardVO kbvo) {
		logger.info("kosBoardPwCheck 함수 진입 >>> : ");
		logger.info("kosBoardPwCheck kbvo.getBpw()() >>> : " + kbvo.getBpw());	
		List<KosBoardVO> res  = kosBoardService.kosBoardPwCheck(kbvo);
		logger.info("kosBoardPwCheck res.size() >>> : " + res.size());	
		String str="";
		if(res.size() == 1) {
			
			str= "ID_YES";
		}else {
			str = "ID_NO";
		}
		return str;
	}
	
	// 댓글 등록
		@PostMapping("rboardInsert")
		@ResponseBody
		public String kosRboardInsert(KosRboardVO rbvo) {	
			logger.info("kosRboardInsert >>> : ");
			logger.info("kosRboardInsert rbvo.getBnum() >>> : " + rbvo.getBnum());
								
			// 채번 구하기
			String rbnum = ChabunUtil.getRboardChabun("N", kosChabunService.getKosRboardChabun().getRbnum());
			logger.info("kosRboardInsertt rbnum >>> : " + rbnum);
			
			rbvo.setRbnum(rbnum);		
			logger.info("rbvo.getRbnum() >>> : " + rbvo.getRbnum());
			logger.info("rbvo.getBnum() >>> : " + rbvo.getBnum());
			logger.info("rbvo.getRbname() >>> : " + rbvo.getRbname());
			logger.info("rbvo.getRbcontent() >>> : " + rbvo.getRbcontent());		
			
			int nCnt = kosRboardService.kosRboardInsert(rbvo);
			logger.info("kosRboardInsert nCnt >>> : " + nCnt);
			
			if (1 == nCnt) { return "GOOD"; }
			else { return "BAD"; }
		}
		
		// 댓글 전체 조회	
		@PostMapping("rboardSelectAll")
		@ResponseBody
		public String kosRboardSelectAll(KosRboardVO rbvo) {	
			logger.info("kosRboardSelectAll >>> : ");
			// rbvo.setSbnum("B0001");
			logger.info("kosRboardSelectAll rbvo.getBnum() >>> : " + rbvo.getBnum());
			
			List<KosRboardVO> list  = kosRboardService.kosRboardSelectAll(rbvo);
			logger.info("kosRboardSelectAll list >>> : " + list);
			
			String ss = "";
			String listStr = "";
			for (int i=0; i < list.size(); i++) {
				KosRboardVO _rbvo = list.get(i);
				String s0 = _rbvo.getRbnum();
				String s1 = _rbvo.getRbname();
				String s2 = _rbvo.getRbcontent();
				String s3 = _rbvo.getInsertdate();
				ss = s0+","+s1+","+s2+","+s3;
				listStr += ss+"&";
			}
			return listStr;
		}
		
		// 댓글 삭제	
		@PostMapping("rboardDelete")
		@ResponseBody
		public String kosRboardDelete(KosRboardVO rbvo) {	
			logger.info("kosRboardDelete >>> : ");
			logger.info("kosRboardDelete rbvo.getRbnum() >>> : " + rbvo.getRbnum());
		
			int nCnt  = kosRboardService.kosRboardDelete(rbvo);
			logger.info("kosRboardDelete nCnt >>> : " + nCnt);
			
			if (1 == nCnt) { return "GOOD"; }
			else { return "BAD"; }
		}

	@GetMapping("boardSelectAll")
	public String boardSelectAllForm(HttpServletRequest req,Model m,KosBoardVO kbvo) {
		logger.info("boardSelectAllForm 함수 진입 >>> : ");
		
		K_Session ks = K_Session.getInstance();	
		//ks.killSession(req);
		
		logger.info("boardSelectAllForm kbvo.getCurPage() >>> : "+kbvo.getCurPage());
		int curPage =0;
		if (kbvo.getCurPage() == 0){
			curPage = 1;
		}else {
			curPage = kbvo.getCurPage();
		}//int pageSize = CommonUtils.BOARD_PAGE_SIZE;
		int displayPageNum = CommonUtils.BOARD_GROUP_SIZE;
		int currPage = (curPage-1)*displayPageNum+1; // oracle 디비에서 시작넘버
		int endDisplayPage = curPage*displayPageNum; // oracle 디비에서 끝넘버
//		int totalCount = CommonUtils.BOARD_TOTAL_COUNT;
		int totalCount = kosBoardService.kosGetTotalCount();
		int endPage = (int) (Math.ceil(curPage/ (double)displayPageNum) * displayPageNum);
	//	int startPage = (endPage - displayPageNum)+1 ;
		int tempEndPage = (int) (Math.ceil(totalCount/ (double)displayPageNum) );
		if(tempEndPage< endPage ) {
			endPage = tempEndPage;
		}
		
		kbvo.setPageSize(endDisplayPage);
	    //kbvo.setGroupSize(displayPageNum);
		kbvo.setCurPage(currPage);
	//	kbvo.setTotalCount(String.valueOf(totalCount));

		
		logger.info("kosSpringFileUploadSelectAll kbvo.getPageSize() >>> : 	" + kbvo.getPageSize());//end page
		logger.info("kosSpringFileUploadSelectAll kbvo.getGroupSize() >>> : 	" + kbvo.getGroupSize()); //displayPageNum
		logger.info("kosSpringFileUploadSelectAll kbvo.getCurPage() >>> : 	" + kbvo.getCurPage()); //start page
		logger.info("kosSpringFileUploadSelectAll kbvo.getTotalCount() >>> : " + kbvo.getTotalCount());
		
		List<KosBoardVO> listAll = kosBoardService.kosBoardSelectAll(kbvo);
		KosBoardPasingVO kbpvo = new KosBoardPasingVO();
		kbpvo.setCurPage(curPage);
		kbpvo.setGroupSize(String.valueOf(displayPageNum));
		kbpvo.setPerPageNum(displayPageNum);
		kbpvo.setTotalCount(totalCount);
		String str = ks.getSession(req);
		logger.info("req.getSession().getId().toString() >>> : " + str);
		if(!"".equals(str)){
			logger.info(":::: req.getSession().getId().toString() >>> : " + str);
			
		m.addAttribute("listLogin", req.getSession().getId().toString());
		}
		m.addAttribute("listAll", listAll);
		m.addAttribute("pagingKBVO", kbpvo);	
		return "board/boardSelectAll";
	}
	@GetMapping("boardSelectContents")
	public String boardSelectContentsForm(HttpServletRequest req,Model m,KosBoardVO kbvo,KosBoardLikeVO kblvo) {
		logger.info("boardSelectContentsForm 함수 진입 >>> : ");
			List<KosBoardVO> listS = kosBoardService.kosBoardSelect(kbvo);
			List<KosBoardLikeVO> res = kosBoardService.kosBoardLikeSelect(kblvo);
			logger.info("boardSelectContentsForm  res.size()>>> : "+res.size());
		if (listS.size() == 1 ||  res.size() ==1 ) { 
			 
			logger.info("kosBoardSelect listS.size() >>> : " + listS.size());
	//		K_Session ks = K_Session.getInstance();			
	//		ks.setSession(req, "M202305230001");
//			ks.setSession(req, "B0001");
			int bhitCnt = kosBoardService.kobBoardBhit(kbvo);
			logger.info("boardSelectContentsForm bhitCnt >>> : " + bhitCnt);
			if(listS !=null ) {		
				m.addAttribute("listS", listS);
			}
			if(res !=null && res.size() > 0) {	
				m.addAttribute("listLike", res);
			}
			return "board/boardSelectContents";
		}		
		//에러메세지 필요
		return "redirect:boardSelectAll.k";
		//m.addAttribute("listS", listS);
	//	return "board/boardSelectContents";
	}
	@GetMapping("like_cnt_1")
	@ResponseBody
	public Object boardlike_cnt_1(HttpServletRequest req,KosBoardLikeVO kblvo) {
	logger.info("boardlike_cnt_1 함수 진입 >>> : ");
	logger.info("boardlike_cnt_1 함수 진입 >>> : "+kblvo);
	K_Session ks = K_Session.getInstance();	
	String kID = ks.getSession(req);
	logger.info("boardlike_cnt_1 ks.getSession(req) >>> : "+kID);
	if(!"".equals(kID)) {
		
			kblvo.setMnum(kID);
	}
	List<KosBoardLikeVO> list = kosBoardService.kosBoardLikeSelect(kblvo);
	//	int blikeCnt =0;
        //처음 접속이나 좋아요 추천을 안한 경우	
		//로그인
	    if (list.size() == 0  ) { 
			logger.info("boardlike_cnt_1 listS.size() >>> : " + list.size() );
			int blike = kosBoardService.kosBoardLikeInsert(kblvo);
			logger.info("kosBoardSelect blike >>> : " + blike);
			if(blike> 0) {
				kosBoardService.kosBoardLikeUpdate_1(kblvo);
			}
		}
		//이미 좋아요 추천이 한 경우
		if(list.size()  > 0 ) {
			logger.info("boardlike_cnt_1 blikeCnt >>> : " + list.size());
			kosBoardService.kosBoardLikeUpdate_1(kblvo);
		}
		List<KosBoardLikeVO> res = kosBoardService.kosBoardLikeSelect(kblvo);
		//	m.addAttribute("listS", listS);
		return res.get(0).getLike_cnt_1();
		//m.addAttribute("listS", listS);
		//return "board/boardSelectContents";
	}
	@GetMapping("like_cnt_2")
	@ResponseBody
	public Object boardlike_cnt_2(HttpServletRequest req,KosBoardLikeVO kblvo) {
		logger.info("boardlike_cnt_2 함수 진입 >>> : ");
		logger.info("boardlike_cnt_2 함수 진입 >>> : "+kblvo);
		K_Session ks = K_Session.getInstance();	
		String kID = ks.getSession(req);
		logger.info("boardlike_cnt_2 ks.getSession(req) >>> : "+kID);
		if(!"".equals(kID)) {
			
			kblvo.setMnum(kID);
		}
		logger.info("boardlike_cnt_2 함수 진입 >>> : "+kblvo);
		List<KosBoardLikeVO> list = kosBoardService.kosBoardLikeSelect(kblvo);
		//처음 접속이나 좋아요 추천을 안한 경우	
		//로그인
		if (list.size() == 0  ) {
			
			logger.info("boardlike_cnt_2 listS.size() >>> : " + list.size() );
			int likeCount =Integer.parseInt(list.get(0).getLike_cnt_2());
            int blike =0;
			if( likeCount == 0) {
					blike = kosBoardService.kosBoardLikeInsert(kblvo);
					logger.info("boardlike_cnt_2 blike >>> : " + blike);
					kosBoardService.kosBoardLikeUpdate_2(kblvo);
				
			}
		}
		//이미 좋아요 추천이 한 경우
		if(list.size()  > 0 ) {
			logger.info("boardlike_cnt_2 blikeCnt >>> : " + list.size());
			kosBoardService.kosBoardLikeUpdate_2(kblvo);
		}
		List<KosBoardLikeVO> res = kosBoardService.kosBoardLikeSelect(kblvo);
		//	m.addAttribute("listS", listS);
		return res.get(0).getLike_cnt_2();
		//m.addAttribute("listS", listS);
		//return "board/boardSelectContents";
	}

	// 게시판 글쓰기 
	@PostMapping("boardInsert")
	public String kosBoardInsert(HttpServletRequest req) {
		logger.info("kosBoardInsert 함수 진입 >>> : ");	
		
		// 채번 구하기
		String num = kosChabunService.getKosBoardChabun().getBnum();
		logger.info("kosBoardInsert num >>> : " + num);
		String bnum = ChabunUtil.getBoardChabun("N", num);
		logger.info("kosBoardInsert bnum >>> : " + bnum);
			
		// 이미지 업로드 
		FileUploadUtil fu = new FileUploadUtil(	 CommonUtils.BOARD_IMG_UPLOAD_PATH
								                ,CommonUtils.BOARD_IMG_FILE_SIZE
								                ,CommonUtils.BOARD_EN_CODE);
		
		// 이미지 파일 원본 사이즈 
		boolean bool = fu.imgfileUpload(req);
		logger.info("kosBoardInsert bool >>> : " + bool);

		KosBoardVO _kbvo = null;
		_kbvo = new KosBoardVO();
			
		_kbvo.setBnum(bnum);
		_kbvo.setBsubject(fu.getParameter("bsubject"));
		_kbvo.setBname(fu.getParameter("bname"));
		_kbvo.setBpw(fu.getParameter("bpw"));
		_kbvo.setBcontent(fu.getParameter("bcontent"));
		_kbvo.setBfile(fu.getFileName("bfile"));
		
		// 서비스 호출
		int nCnt = kosBoardService.kosBoardInsert(_kbvo);
		if (nCnt > 0) { 
			logger.info("kosBoardInsert nCnt >>> : " + nCnt);
			return "board/boardInsert";
		}
		return "board/boardForm";
	}
	// 게시글 수정 
		@GetMapping("boardUpdate")
		public String kosBoardUpdate(KosBoardVO kbvo, Model model) {
			logger.info("kosBoardUpdate 함수 진입 >>> : ");
			logger.info("kosBoardDelete 함수 진입 kbvo.getBnum() >>> : " + kbvo.getBnum());
			
			int nCnt = kosBoardService.kosBoardUpdate(kbvo);
			
			if (nCnt > 0) { 
				logger.info("kosBoardUpdate nCnt >>> : " + nCnt);
				return "board/boardUpdate";
			}
			return "#";		
		}
		
	// 게시글 삭제
		@GetMapping("boardDelete")
		public String kosBoardDelete(KosBoardVO kbvo, Model model) {
			logger.info("kosBoardDelete 함수 진입 >>> : ");
			logger.info("kosBoardDelete 함수 진입 kbvo.getBnum() >>> : " + kbvo.getBnum());
			
			int nCnt = kosBoardService.kosBoardDelete(kbvo);
			
			if (nCnt > 0) { 
				logger.info("kosBoardDelete nCnt >>> : " + nCnt);
				return "board/boardDelete";
			}
			return "#";		
		}
}
