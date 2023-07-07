package a.b.c.com.kos.mem.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kos.mem.vo.KosMemberVO;
@Repository
public class KosMemberDAOImpl implements KosMemberDAO{

	private Logger logger = LoggerFactory.getLogger(KosMemberDAOImpl.class);
	@Autowired(required = false)
	SqlSession sqlSession;
	@Override
	public int kosMemberInsert(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		logger.info("kosMemberInsert 함수 진입 >>> : ");
		return  sqlSession.insert("kosMemberInsert");
	}

	@Override
	public List<KosMemberVO> kosMemberSelectAll(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		logger.info("kosMemberSelectAll 함수 진입 >>> : ");
		return sqlSession.selectList("kosMemberSelectAll");
	}

	@Override
	public List<KosMemberVO> kosMemberSelect(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kosMemberSelect");
	}

	@Override
	public List<KosMemberVO> kosIdCheck(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int kosMemberUpdate(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		logger.info("kosMemberUpdate 함수 진입 >>> : ");
		logger.info("kosMemberUpdate 함수 KosMemberVO  >>> : "+kvo);
		return sqlSession.update("kosMemberUpdate");
	}

	@Override
	public int kosMemberDelete(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<KosMemberVO> kosEmailCheck(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kosEmailCheck");
	}

	@Override
	public int kosaddMemberBySNS(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("kosaddMemberBySNS");
	}

	@Override
	public List<KosMemberVO> dbCheckIdAndEmail(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("dbCheckIdAndEmail");
	}

	@Override
	public int kosMemberUpdatePW(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kosMemberUpdatePW");
	}

}
