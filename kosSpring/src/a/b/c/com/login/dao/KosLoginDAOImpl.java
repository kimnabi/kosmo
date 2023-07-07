package a.b.c.com.login.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kos.mem.vo.KosMemberVO;
import a.b.c.com.login.service.KosLoginServiceImpl;
@Repository
public class KosLoginDAOImpl implements KosLoginDAO{
	
	private Logger logger = LogManager.getLogger(KosLoginServiceImpl.class);
	@Autowired(required = false)
	SqlSession sqlSession;
	@Override
	public List<KosMemberVO> kosLoginCheck(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		logger.info("KosLoginDAOImpl kosLoginCheck 함수진입 >>>");
		logger.info("kosLoginCheck KosMemberVO >>>"+kvo);
		return sqlSession.selectList("kosLoginCheck");
	}
	@Override
	public List<KosMemberVO> kakaoLogin(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kakaoLogin");
	}

}
