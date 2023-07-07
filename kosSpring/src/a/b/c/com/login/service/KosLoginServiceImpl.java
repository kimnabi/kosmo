package a.b.c.com.login.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kos.mem.vo.KosMemberVO;
import a.b.c.com.login.dao.KosLoginDAO;
@Service
@Transactional
public class KosLoginServiceImpl implements KosLoginService {
	
	private Logger logger = LogManager.getLogger(KosLoginServiceImpl.class);
	@Autowired(required = false)
	KosLoginDAO kosLoginDAO;
	@Override
	public List<KosMemberVO> kosLoginCheck(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		logger.info("KosLoginServiceImpl kosLoginCheck 함수진입 >>>");
		logger.info("kosLoginCheck KosMemberVO >>>"+kvo);
		return kosLoginDAO.kosLoginCheck(kvo);
	}
	@Override
	public List<KosMemberVO> kakaoLogin(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		logger.info("KosLoginServiceImpl kakaoLogin 함수진입 >>>");
		return kosLoginDAO.kakaoLogin(kvo);
	}

}
