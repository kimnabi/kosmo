package a.b.c.com.kos.order.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.common.chabun.service.KosChabunService;
import a.b.c.com.kos.cart.service.KosmoCartService;
import a.b.c.com.kos.cart.vo.KosmoCartVO;
import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.NumUtil;

import a.b.c.com.kos.order.service.KosmoOrderService;


@Controller
public class KosmoOrderController {
	Logger logger = LogManager.getLogger(KosmoOrderController.class);
	
	// 컨트롤러에서 채번 서비스 연결 
	@Autowired(required=false)
	private KosChabunService kosChabunService;

	// 필드 오토와이어드 
	@Autowired(required=false)	
	private KosmoOrderService kosmoOrderService;
	
	// 필드 오토와이어드 
	@Autowired(required=false)
	private KosmoCartService kosmoCartService;
	
	// 주문 입력 폼
	@RequestMapping(value="kosmoOrderInsertForm", method=RequestMethod.GET)
	public String kosmoOrderInsertForm(KosmoCartVO kcvo, Model model) {
		logger.info("KosmoOrderController kosmoOrderInsertForm 함수 진입 >>> : ");	
		
		logger.info("kcvo.getKcnum() >>> : " + kcvo.getKcnum());
		logger.info("kcvo.getKpid() >>> : " + kcvo.getKpid());
		logger.info("kcvo.getKpname() >>> : " + kcvo.getKpname());
		logger.info("kcvo.getKpfile() >>> : " + kcvo.getKpfile());
		logger.info("kcvo.getKpcnt() >>> : " + kcvo.getKpcnt());
		kcvo.setKpprice(NumUtil.comma_replace(kcvo.getKpprice()));
		logger.info("kcvo.getKpprice() >>> : " + kcvo.getKpprice());
		kcvo.setKppricesum(NumUtil.comma_replace(kcvo.getKppricesum()));
		logger.info("kcvo.getKppricesum() >>> : " + kcvo.getKppricesum());
		logger.info("kcvo.getKpnum() >>> : " + kcvo.getKpnum());
		logger.info("kcvo.getKmnum() >>> : " + kcvo.getKmnum());
		
		// 서비스 호출
		
		return "order/kosmoOrderInsertForm";
	}
	
	// 주문하기  
	@RequestMapping(value="kosmoOrderInsert", method=RequestMethod.POST)
	public String kosmoOrderInsert(HttpServletRequest req) {	
		logger.info("KosmoOrderController kosmoOrderInsert 함수 진입 >>> : ");	
		
		// 채번 구하기
		String konum = ChabunUtil.getOrderChabun("D", kosChabunService.getOrderChabun().getKonum());
		logger.info("KosmoProductController kosmoProductInsert kpnum >>> : " + konum);
		
		// 서비스 호출
		int nCnt = 0;
		
		
		return "product/kosmoProductInsertForm";
	}	
}
