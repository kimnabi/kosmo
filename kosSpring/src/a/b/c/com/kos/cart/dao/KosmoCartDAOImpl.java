package a.b.c.com.kos.cart.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kos.cart.vo.KosmoCartVO;


@Repository
public class KosmoCartDAOImpl implements KosmoCartDAO {
	Logger logger = LogManager.getLogger(KosmoCartDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public int kosmoCartInsert(KosmoCartVO kcvo) {
		// TODO Auto-generated method stub
		logger.info("kosmoCartInsert 함수 진입 >>> : ");			
		return (Integer)sqlSession.insert("kosmoCartInsert", kcvo);
	}

	@Override
	public List<KosmoCartVO> kosmoCartSelectAll(KosmoCartVO kcvo) {
		// TODO Auto-generated method stub
		logger.info("kosmoCartInsert 함수 진입 >>> : ");	
		return sqlSession.selectList("kosmoCartSelectAll", kcvo);
	}
	
	@Override
	public int kosmoCartDelete(KosmoCartVO kcvo) {
		// TODO Auto-generated method stub
		logger.info("kosmoCartDelete 함수 진입 >>> : ");			
		return (Integer)sqlSession.update("kosmoCartDelete", kcvo);
	}

	@Override
	public int kosmoCartDeleteArray(ArrayList<KosmoCartVO> aList) {
		// TODO Auto-generated method stub
		logger.info("kosmoCartDeleteArray 함수 진입 >>> : ");			
		return (Integer)sqlSession.update("kosmoCartDeleteArray", aList);
	}
}
