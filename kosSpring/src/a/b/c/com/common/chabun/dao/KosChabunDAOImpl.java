package a.b.c.com.common.chabun.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kos.board.vo.KosBoardVO;
import a.b.c.com.kos.cart.vo.KosmoCartVO;
import a.b.c.com.kos.mem.vo.KosMemberVO;
import a.b.c.com.kos.order.vo.KosmoOrderVO;
import a.b.c.com.kos.product.vo.KosmoProductVO;
import a.b.c.com.kos.rboard.vo.KosRboardVO;

@Repository
public class KosChabunDAOImpl implements KosChabunDAO {
	Logger logger = LogManager.getLogger(KosChabunDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;

	@Override
	public KosMemberVO getKosMemberChabun() {
		// TODO Auto-generated method stub
		logger.info("getKosMemberChabun 함수 진입 >>> : ");
		return sqlSession.selectOne("getKosMemberChabun"); // getKosMemberChabun
	}

	@Override
	public KosBoardVO getKosBoardChabun() {
		// TODO Auto-generated method stub
		logger.info("getKosMemberChabun 함수 진입 >>> : ");
		return sqlSession.selectOne("getKosBoardChabun"); // getKosBoardChabun
	}

	@Override
	public KosRboardVO getKosRboardChabun() {
		// TODO Auto-generated method stub
		logger.info("getKosRboardChabun 함수 진입 >>> : ");
		return sqlSession.selectOne("getKosRboardChabun");
	}

	@Override
	public KosmoProductVO getProductChabun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getProductChabun");
	}

	@Override
	public KosmoCartVO getCartChabun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getCartChabun");
	}

	@Override
	public KosmoOrderVO getOrderChabun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getOrderChabun");
	}
}
