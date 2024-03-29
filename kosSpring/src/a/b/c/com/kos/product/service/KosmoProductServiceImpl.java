package a.b.c.com.kos.product.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kos.product.dao.KosmoProductDAO;
import a.b.c.com.kos.product.vo.KosmoProductVO;


@Service
@Transactional
public class KosmoProductServiceImpl implements KosmoProductService {
	Logger logger = LogManager.getLogger(KosmoProductServiceImpl.class);
	
	// 서비스에서 DAO 연결하기 
	// 필드 @Autowired 어노테이션으로  DI (의존성 주입하기)
	@Autowired(required=false)
	private KosmoProductDAO kosmoProductDAO;	

	@Override
	public int kosmoProductInsert(KosmoProductVO kpvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoProductVO 함수 진입 >>> : ");			
		return kosmoProductDAO.kosmoProductInsert(kpvo);
	}

	@Override
	public List<KosmoProductVO> kosmoProductSelectAll(KosmoProductVO kpvo) {
		// TODO Auto-generated method stub
		logger.info("kosmoProductSelectAll 함수 진입 >>> : ");			
		return kosmoProductDAO.kosmoProductSelectAll(kpvo);
	}

	@Override
	public List<KosmoProductVO> kosmoProductSelect(KosmoProductVO kpvo) {
		// TODO Auto-generated method stub
		logger.info("kosmoProductSelect 함수 진입 >>> : ");			
		return kosmoProductDAO.kosmoProductSelect(kpvo);
	}

	@Override
	public int getProductTotalCount() {
		// TODO Auto-generated method stub
		logger.info("kosmoProduct getTotalCount함수 진입 >>> : ");			
		return  kosmoProductDAO.getTotalCount();
	}

	

}
