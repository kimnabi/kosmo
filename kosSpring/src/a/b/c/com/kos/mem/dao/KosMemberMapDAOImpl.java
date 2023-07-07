package a.b.c.com.kos.mem.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.common.CommandMap;
@Repository
public class KosMemberMapDAOImpl implements KosMemberMapDAO{

	private Logger logger = LoggerFactory.getLogger(KosMemberMapDAOImpl.class);
	@Autowired(required = false)
	SqlSession sqlSession;

	@Override
	public List<Map<String, Object>> kosMemberMapSelectAll(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kosMemberMapSelectAll", param);
	}
	
}
