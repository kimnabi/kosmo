package a.b.c.com.kos.rboard.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kos.rboard.dao.KosRboardDAO;
import a.b.c.com.kos.rboard.vo.KosRboardVO;

@Service
@Transactional
public class KosRboardServiceImpl implements KosRboardService {
	Logger logger = LogManager.getLogger(KosRboardServiceImpl.class);
	
	// 서비스에서 DAO 연결하기 
	// 필드 @Autowired 어노테이션으로  DI (의존성 주입하기)
	@Autowired(required=false)	
	private KosRboardDAO kosRboardDAO;

	@Override
	public int kosRboardInsert(KosRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("kosRboardInsert 함수 진입 >>> : ");			
		return kosRboardDAO.kosRboardInsert(rbvo);
	}

	@Override
	public List<KosRboardVO> kosRboardSelectAll(KosRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("kosRboardSelectAll 함수 진입 >>> : ");			
		return kosRboardDAO.kosRboardSelectAll(rbvo);
	}

	@Override
	public int kosRboardDelete(KosRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("kosRboardDelete 함수 진입 >>> : ");			
		return kosRboardDAO.kosRboardDelete(rbvo);
	}

}
