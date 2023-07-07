package a.b.c.com.common.chabun.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.common.chabun.dao.KosChabunDAO;
import a.b.c.com.kos.board.vo.KosBoardVO;
import a.b.c.com.kos.cart.vo.KosmoCartVO;
import a.b.c.com.kos.mem.vo.KosMemberVO;
import a.b.c.com.kos.order.vo.KosmoOrderVO;
import a.b.c.com.kos.product.vo.KosmoProductVO;
import a.b.c.com.kos.rboard.vo.KosRboardVO;

@Service
@Transactional
public class KosChabunServiceImpl implements KosChabunService {
	Logger logger = LogManager.getLogger(KosChabunServiceImpl.class);

	@Autowired(required=false)
	private KosChabunDAO kosChabunDAO;
	
	
	@Override
	public KosMemberVO getKosMemberChabun() {
		// TODO Auto-generated method stub
		logger.info("getKosMemberChabun 함수 진입 >>> : ");
		return kosChabunDAO.getKosMemberChabun();
	}


	@Override
	public KosBoardVO getKosBoardChabun() {
		// TODO Auto-generated method stub
		logger.info("getKosBoardChabun 함수 진입 >>> : ");
		return kosChabunDAO.getKosBoardChabun();
	}
	@Override
	public KosRboardVO getKosRboardChabun() {
		// TODO Auto-generated method stub
		logger.info("getKosRboardChabun 함수 진입 >>> : ");
		return kosChabunDAO.getKosRboardChabun();
	}


	@Override
	public KosmoProductVO getProductChabun() {
		// TODO Auto-generated method stub
		logger.info("getProductChabun 함수 진입 >>> : ");
		return  kosChabunDAO.getProductChabun();
	}
	
	@Override
	public KosmoCartVO getCartChabun() {
		// TODO Auto-generated method stub
		logger.info("getCartChabun >>> : ");
		return kosChabunDAO.getCartChabun();
	}

	@Override
	public KosmoOrderVO getOrderChabun() {
		// TODO Auto-generated method stub
		logger.info("getOrderChabun >>> : ");
		return kosChabunDAO.getOrderChabun();
	}

}
