package a.b.c.com.kos.order.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kos.order.vo.KosmoOrderVO;

@Repository
public class KosmoOrderDAOImpl implements KosmoOrderDAO {
	Logger logger = LogManager.getLogger(KosmoOrderDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public int kosmoOrderInsert(KosmoOrderVO kovo) {
		// TODO Auto-generated method stub
		logger.info("kosmoOrderInsert 함수 진입 >>> : ");			
		return (Integer)sqlSession.insert("kosmoOrderInsert", kovo);
	}
}
