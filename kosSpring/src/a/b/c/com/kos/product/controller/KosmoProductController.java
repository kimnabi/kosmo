package a.b.c.com.kos.product.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.chabun.service.KosChabunService;
import a.b.c.com.kos.cart.vo.KosmoCart;
import a.b.c.com.kos.product.service.KosmoProductService;
import a.b.c.com.kos.product.vo.KosProductPasingVO;
import a.b.c.com.kos.product.vo.KosmoProductVO;

@Controller
public class KosmoProductController {
	Logger logger = LogManager.getLogger(KosmoProductController.class);

	// 컨트롤러에서 채번 서비스 연결 
	@Autowired(required=false)
	private KosChabunService kosChabunService;
	
	// 필드 오토와이어드 
	@Autowired(required=false)
	private KosmoProductService kosmoProductService;
	
	// 상품 입력 폼
	@RequestMapping(value="kosmoProductInsertForm", method=RequestMethod.GET)
	public String kosmoProductInsertForm() {
		logger.info("kosmoProductInsertForm 함수 진입 >>> : ");	
		return "product/kosmoProductInsertForm";
	}
	
	// 상품 입력 
	@RequestMapping(value="kosmoProductInsert", method=RequestMethod.POST)
	public String kosmoProductInsert(HttpServletRequest req) {	
		logger.info("kosmoProductInsert 함수 진입 >>> : ");	
		
		// 채번 구하기
		String kpnum = ChabunUtil.getProductChabun("D", kosChabunService.getProductChabun().getKpnum());
		logger.info("kosmoProductInsert kpnum >>> : " + kpnum);
		
		
		// 이미지 업로드 
		FileUploadUtil fu = new FileUploadUtil(	 CommonUtils.PRODUCT_IMG_UPLOAD_PATH
								                ,CommonUtils.PRODUCT_IMG_FILE_SIZE
								                ,CommonUtils.PRODUCT_EN_CODE);
		
		// 이미지 파일 원본 사이즈 
		boolean bool = fu.imgfileUpload(req);			
		logger.info("kosmoProductInsert bool >>> : " + bool);
		
		KosmoProductVO _kpvo = null;
		_kpvo = new KosmoProductVO();
			
		_kpvo.setKpnum(kpnum);
		_kpvo.setKpid(fu.getParameter("kpid"));
		_kpvo.setKpname(fu.getParameter("kpname"));
		_kpvo.setKpcompany(fu.getParameter("kpcompany"));
		
		_kpvo.setKpfile(fu.getFileName("kpfile"));
		
		_kpvo.setKpcnt(fu.getParameter("kpcnt"));
		_kpvo.setKpprice(fu.getParameter("kpprice"));
		_kpvo.setKpdesc(fu.getParameter("kpdesc"));
		
		// 서비스 호출
		int nCnt = kosmoProductService.kosmoProductInsert(_kpvo);
		logger.info("kosmoProductInsert nCnt >>> : " + nCnt);
		
		if (nCnt > 0) { return "product/kosmoProductInsert";}
		return "product/kosmoProductInsertForm";
	}	
	
	// 상품 목록 페이징 조회
		@RequestMapping(value="kosmoProductSelectAll", method=RequestMethod.GET)
		public String kosmoProductSelectAll(KosmoProductVO kpvo, Model model) {
			logger.info("kosmoProductSelectAll 함수 진입 >>> : ");
			
			// 페이징 처리 ====================================================================
			logger.info("kosmoProductSelectAll kpvo.getCurPage() >>> : "+kpvo.getCurPage());
			int curPage =0;
			if (kpvo.getCurPage() == 0){
				curPage = 1;
			}else {
				curPage = kpvo.getCurPage();
			}//int pageSize = CommonUtils.BOARD_PAGE_SIZE;
			int displayPageNum = CommonUtils.BOARD_GROUP_SIZE;
			int currPage = (curPage-1)*displayPageNum+1; // oracle 디비에서 시작넘버
			int endDisplayPage = curPage*displayPageNum; // oracle 디비에서 끝넘버
			int totalCount = kosmoProductService.getProductTotalCount();
			int endPage = (int) (Math.ceil(curPage/ (double)displayPageNum) * displayPageNum);
		//	int startPage = (endPage - displayPageNum)+1 ;
			int tempEndPage = (int) (Math.ceil(totalCount/ (double)displayPageNum) );
			if(tempEndPage< endPage ) {
				endPage = tempEndPage;
			}
			
			kpvo.setPageSize(endDisplayPage);
		    //kbvo.setGroupSize(displayPageNum);
			kpvo.setCurPage(currPage);
		//	kbvo.setTotalCount(String.valueOf(totalCount));

			
			logger.info("kosSpringFileUploadSelectAll kbvo.getPageSize() >>> : 	" + kpvo.getPageSize());//end page
			logger.info("kosSpringFileUploadSelectAll kpvo.getGroupSize() >>> : 	" + kpvo.getGroupSize()); //displayPageNum
			logger.info("kosSpringFileUploadSelectAll kpvo.getCurPage() >>> : 	" + kpvo.getCurPage()); //start page
			logger.info("kosSpringFileUploadSelectAll kpvo.getTotalCount() >>> : " + kpvo.getTotalCount());
			
			List<KosmoProductVO> listAll = kosmoProductService.kosmoProductSelectAll(kpvo);		
			
			KosmoCart cart = new KosmoCart();
			for(KosmoProductVO vo :listAll) {
				KosmoProductVO _kpvo = null;
				_kpvo = vo;
				
				cart.push(_kpvo);
			}
			KosProductPasingVO kbpvo = new KosProductPasingVO();
			kbpvo.setCurPage(curPage);
			kbpvo.setGroupSize(String.valueOf(displayPageNum));
			kbpvo.setPerPageNum(displayPageNum);
			kbpvo.setTotalCount(totalCount);
	
			// 페이징 처리 ====================================================================
			
			// 서비스 호출
			if (listAll.size() > 0) { 
				logger.info("kosmoProductSelectAll listAll.size() >>> : " + listAll.size());
				
				model.addAttribute("pagingKPVO", kbpvo);
				model.addAttribute("listAll", cart);
				return "product/kosmoProductList";
			}		
			return "product/kosmoProductSelectAll";
		}
		//kosmoProductSelect
		// 상품 조회: 상품담기: 장바구니
		@RequestMapping(value="kosmoProductSelect", method=RequestMethod.POST)
		public String kosmoProductSelect(@Param ("kpnum") String kpnum, Model model) {
			logger.info("kosmoProductSelect 함수 진입 >>> : ");
			KosmoProductVO kpvo =null;
			kpvo = new KosmoProductVO();
			kpvo.setKpnum(kpnum);
			// 상품번호 확인해보기
			logger.info("kosmoProductSelect 함수 진입::: kpvo.getKpnum() >>> : " + kpvo.getKpnum());
			
			// 서비스 호출
			List<KosmoProductVO> listS = kosmoProductService.kosmoProductSelect(kpvo);		
			if (listS.size() > 0) { 
				logger.info("KosmoProductController kosmoProductSelectAll listS.size() >>> : " + listS.size());		
				model.addAttribute("listS", listS);
				return "product/kosmoProductSelect";
			}		
			return "product/kosmoProductSelectAll";
		}
}
