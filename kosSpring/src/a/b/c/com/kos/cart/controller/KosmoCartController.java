package a.b.c.com.kos.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.kos.cart.service.KosmoCartService;
import a.b.c.com.kos.cart.vo.KosmoCart;
import a.b.c.com.kos.cart.vo.KosmoCartVO;
import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.NumUtil;
import a.b.c.com.common.chabun.service.KosChabunService;


@Controller
public class KosmoCartController {
	Logger logger = LogManager.getLogger(KosmoCartController.class);
	
	// 컨트롤러에서 채번 서비스 연결 
	@Autowired(required=false)
	private KosChabunService kosChabunService;
	
	// 필드 오토와이어드 
	@Autowired(required=false)
	private KosmoCartService kosmoCartService;
	
	
	
	// 카트 목록 
	@GetMapping(value="kosmoCartSelectAll")
	public String kosmoCartSelectAll(KosmoCartVO kcvo, Model model) {
		logger.info("kosmoCartSelectAll 함수 진입 >>> : ");
		
		kcvo.setKmnum("1234");
		logger.info("kcvo.getKmnum() >>> : " + kcvo.getKmnum());
		
		// 페이징 처리
		
		// 서비스 호출
		List<KosmoCartVO> cartListAll = kosmoCartService.kosmoCartSelectAll(kcvo);		
		if (cartListAll.size() > 0) { 
			logger.info("KosmoCartController listAll.size() >>> : " + cartListAll.size());		
			model.addAttribute("cartListAll", cartListAll);
			return "cart/kosmoCartSelectAll";
		}		
		return "cart/kosmoCartSelectAll";
	}
	
	// 한건 삭제 
	@RequestMapping(value="kosmoCartDelete", method=RequestMethod.GET)
	public String kosmoCartDelete(HttpServletRequest req, KosmoCartVO kcvo, Model model) {
		logger.info("kosmoCartDelete 함수 진입 >>> : ");
	
		kcvo.setKcnum(req.getParameter("kcnumV"));
		logger.info("kosmoCartDelete 함수 진입  kcvo.getKcnum() >>> : " + kcvo.getKcnum());
		
		int nCnt = kosmoCartService.kosmoCartDelete(kcvo);		
		if (nCnt > 0) {
			logger.info("kosmoCartDelete 함수 진입 nCnt >>> : " + nCnt);		
		}		
		return "cart/kosmoCartDelete";
	}
	
	//장바구니 저장
	
	@RequestMapping(value="kosmoCartInsert", method=RequestMethod.GET)
	public String kosmoCartInsert(KosmoCartVO kcvo) {	
		logger.info("kosmoCartInsert 함수 진입 >>> : ");	
		
		// 채번 
		String kcnum = ChabunUtil.getCartChabun("D", kosChabunService.getCartChabun().getKcnum());
		kcvo.setKcnum(kcnum);
		logger.info("kosmoCartInsert 함수 진입 >>> : kcnum " + kcnum);
		
		logger.info("kcvo.getKcnum() >>> : " + kcvo.getKcnum());
		logger.info("kcvo.getKpid() >>> : " + kcvo.getKpid());
		logger.info("kcvo.getKpname() >>> : " + kcvo.getKpname());
		logger.info("kcvo.getKpfile() >>> : " + kcvo.getKpfile());
		kcvo.setKpprice(NumUtil.comma_replace(kcvo.getKpprice()));
		logger.info("kcvo.getKpprice() >>> : " + kcvo.getKpprice());
		kcvo.setKppricesum(NumUtil.comma_replace(kcvo.getKppricesum()));
		logger.info("kcvo.getKppricesum() >>> : " + kcvo.getKppricesum());
		logger.info("kcvo.getKpnum() >>> : " + kcvo.getKpnum());
		logger.info("kcvo.getKmnum() >>> : " + kcvo.getKmnum());
		
		// 서비스 호출
		int nCnt = kosmoCartService.kosmoCartInsert(kcvo);
				
		if (nCnt > 0) {
			logger.info("kosmoProductInsert nCnt >>> : " + nCnt);
			return "cart/kosmoCartInsert";
		}
		return "prodcut/kosmoProductInsert";
	}
	
	//http://localhost:8088/springmvc1/cart/cartAdd?id=1&quantity=5
	@RequestMapping("cartAdd")
	public String add(Integer id, Integer quantity, HttpSession session,Model m) {
		//장바구니 정보를 session에 등록함
		//ModelAndView mav = new ModelAndView("cart/cart");
		//1. id에 해당하는 상품 조회
//		Item item = service.getItem(id);
		//2. session에 등록된 Cart 객체 조회
		KosmoCart cart = (KosmoCart)session.getAttribute("CART");
		if(cart == null) {
			cart = new KosmoCart();
			session.setAttribute("CART", cart);
		}
		//같은 상품인 경우 수량만 증가하도록 프로그램 수정
//		cart.push(new KosmoCartVO(item, quantity));
		m.addAttribute("cart", cart);
	//	m.addAttribute("message", item.getName() + ":" + quantity + "개 장바구니 추가");
		return "cart/cart";
	}
	
}
