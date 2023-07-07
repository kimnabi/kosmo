package a.b.c.com.kos.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kos.cart.dao.KosmoCartDAO;
import a.b.c.com.kos.cart.vo.KosmoCartVO;

@Service
@Transactional
public class KosmoCartServiceImpl implements KosmoCartService {
	Logger logger = LogManager.getLogger(KosmoCartServiceImpl.class);;
	
	// 서비스에서 DAO 연결하기 
	// 필드 @Autowired 어노테이션으로  DI (의존성 주입하기)
	@Autowired(required=false)
	private KosmoCartDAO kosmoCartDAO;

	@Override
	public int kosmoCartInsert(KosmoCartVO kcvo) {
		// TODO Auto-generated method stub
		logger.info("kosmoCartInsert 함수 진입 >>> : ");		
		return kosmoCartDAO.kosmoCartInsert(kcvo);
	}

	@Override
	public List<KosmoCartVO> kosmoCartSelectAll(KosmoCartVO kcvo) {
		// TODO Auto-generated method stub
		logger.info("kosmoCartSelectAll 함수 진입 >>> : ");		
		return kosmoCartDAO.kosmoCartSelectAll(kcvo);
	}

	@Override
	public int kosmoCartDelete(KosmoCartVO kcvo) {
		// TODO Auto-generated method stub
		logger.info("kosmoCartDelete 함수 진입 >>> : ");		
		return kosmoCartDAO.kosmoCartDelete(kcvo);
	}

	@Override
	public int kosmoCartDeleteArray(ArrayList<KosmoCartVO> aList) {
		// TODO Auto-generated method stub
		logger.info("kosmoCartDeleteArray 함수 진입 >>> : ");		
		return kosmoCartDAO.kosmoCartDeleteArray(aList);
	}

}
