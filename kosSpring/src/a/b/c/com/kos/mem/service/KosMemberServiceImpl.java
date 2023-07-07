package a.b.c.com.kos.mem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.kos.mem.controller.KosMemberController;
import a.b.c.com.kos.mem.dao.KosMemberDAO;
import a.b.c.com.kos.mem.vo.KosMemberVO;
@Service
@Transactional
public class KosMemberServiceImpl implements KosMemberService {
     
	private Logger logger = LoggerFactory.getLogger(KosMemberServiceImpl.class);
	@Autowired(required = false)
     KosMemberDAO kosMemberDAO;
	@Override
	public int kosMemberInsert(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		logger.info("kosMemberInsert 함수진입 >>>");
		logger.info("kosMemberInsert KosMemberVO >>>"+kvo);
	//	return 0;
		return kosMemberDAO.kosMemberInsert(kvo) ;
	}

	@Override
	public List<KosMemberVO> kosMemberSelectAll(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		logger.info("kosMemberSelectAll 함수진입 >>>");
		logger.info("kosMemberSelectAll KosMemberVO >>>"+kvo);
		return kosMemberDAO.kosMemberSelectAll(kvo);
	}

	@Override
	public List<KosMemberVO> kosMemberSelect(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		logger.info("kosMemberSelect 함수진입 >>>");
		logger.info("kosMemberSelect KosMemberVO >>>"+kvo);
		return kosMemberDAO.kosMemberSelect(kvo);
	}

	@Override
	public List<KosMemberVO> kosIdCheck(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int kosMemberUpdate(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		logger.info("kosMemberUpdate 함수진입 >>>");
		logger.info("kosMemberUpdate KosMemberVO >>>"+kvo);
		return  kosMemberDAO.kosMemberUpdate(kvo);
	}

	@Override
	public int kosMemberDelete(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<KosMemberVO> kosEmailCheck(KosMemberVO kvo) {
		// TODO Auto-generated method stub
			logger.info("kosEmailCheck 함수 진입 >>> : ");
			
			List<KosMemberVO> list = kosMemberDAO.kosEmailCheck(kvo);
			if (list != null) {
				
				logger.info("kosEmailCheck 함수 >>> : " + list.size());
				if (list.size() > 0)
					return list;
			}
			return null;
	}

	@Override
	public int kosaddMemberBySNS(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return  kosMemberDAO.kosaddMemberBySNS(kvo);
	}

	@Override
	public List<KosMemberVO> dbCheckIdAndEmail(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return  kosMemberDAO.dbCheckIdAndEmail(kvo);
	}

	@Override
	public int kosMemberUpdatePW(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return kosMemberDAO.kosMemberUpdatePW(kvo);
	}

}
