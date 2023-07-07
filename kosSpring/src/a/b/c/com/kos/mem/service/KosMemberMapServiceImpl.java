package a.b.c.com.kos.mem.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.common.CommandMap;
import a.b.c.com.kos.mem.dao.KosMemberMapDAO;
@Service
@Transactional
public class KosMemberMapServiceImpl implements KosMemberMapService {
     
	private Logger logger = LoggerFactory.getLogger(KosMemberMapServiceImpl.class);
	@Autowired(required = false)
     KosMemberMapDAO kosMemberMapDAO;
	@Override
	public List<Map<String, Object>> kosMemberSelectAll(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return kosMemberMapDAO.kosMemberMapSelectAll(param);
	}
	

}
