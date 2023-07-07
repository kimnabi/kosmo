package a.b.c.com.kos.rboard.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kos.rboard.vo.KosRboardVO;

@Repository
public class KosRboardDAOImpl implements KosRboardDAO {
	Logger logger = LogManager.getLogger(KosRboardDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;

	@Override
	public int kosRboardInsert(KosRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("kosRboardInsert 함수 진입 >>> : ");			
		return sqlSession.insert("kosRboardInsert", rbvo);
	}

	@Override
	public List<KosRboardVO> kosRboardSelectAll(KosRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("kosRboardSelectAll 함수 진입 >>> : ");	
		return sqlSession.selectList("kosRboardSelectAll", rbvo);
	}

	@Override
	public int kosRboardDelete(KosRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("kosRboardDelete 함수 진입 >>> : ");			
		return sqlSession.update("kosRboardDelete", rbvo);
	}

}
